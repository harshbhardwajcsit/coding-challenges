package com.freshworks.requestproxy.service.impl;

import com.freshworks.requestproxy.constant.MessageConstants;
import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.entity.responseEntity.CommonResponse;
import com.freshworks.requestproxy.exception.RequestParseException;
import com.freshworks.requestproxy.model.SupportedRequestTypes;
import com.freshworks.requestproxy.service.ExecutionService;
import com.freshworks.requestproxy.service.TransactionService;
import com.freshworks.requestproxy.validator.RequestValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static com.google.common.net.HttpHeaders.USER_AGENT;

@Service
public class ExecutionServiceImpl implements ExecutionService {

    @Value("${request.limit}")
    private int limit;

    @Value("${connection.timeout}")
    private int timeout;

    private final TransactionService transactionService;

    @Autowired
    public ExecutionServiceImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public CommonResponse<?> executeRequest(CommonRequest commonRequest) throws URISyntaxException, RequestParseException, MalformedURLException {

        if (!RequestValidator.isValidRequest(commonRequest)) {
            return CommonResponse.failure(HttpStatus.BAD_REQUEST.value(), MessageConstants.MISSING_REQUEST_PARAMS);
        }

        if (!RequestValidator.isValidURL(commonRequest.getUrl())) {
            return CommonResponse.failure(HttpStatus.BAD_REQUEST.value(), MessageConstants.MALFORMED_URL_STRUCTURE);
        }

        if (!RequestValidator.isValidRequestType(commonRequest)) {
            return CommonResponse.failure(HttpStatus.BAD_REQUEST.value(), MessageConstants.UNSUPPORTED_REQUEST);
        }

        if (RequestValidator.isMaximumRequestLimitReached(transactionService.getClientAccessRecords(commonRequest.getClientId()), limit)) {
            return CommonResponse.failure(HttpStatus.TOO_MANY_REQUESTS.value(), MessageConstants.MAX_LIMIT_REACHED);
        }

        return replayRequestOnUrl(commonRequest);
    }

    private CommonResponse<?> replayRequestOnUrl(CommonRequest commonRequest) throws RequestParseException {

        int responseCode = 0;
        String responseMessage = MessageConstants.SUCCESS;
        StringBuilder response = null;

        try {
            URL obj = new URL(commonRequest.getUrl());
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            prepareRequest(connection, commonRequest);

            if (commonRequest.getRequest().equals(SupportedRequestTypes.POST.name())) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(commonRequest.getBody().getBytes());
                outputStream.close();
                outputStream.flush();
            }

            responseCode = connection.getResponseCode();
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            response = new StringBuilder();

            while ((inputLine = inputStream.readLine()) != null) {
                response.append(inputLine);
            }

            inputStream.close();

            transactionService.storeClientAccessRecords(commonRequest.getClientId());


        } catch (SocketTimeoutException timeoutException) {

            responseCode = 502;
            responseMessage = MessageConstants.REQUEST_TIMEOUT;

        } catch (ConnectException connectException) {

            responseCode = 503;

            responseMessage = MessageConstants.CONNECTION_FAILED;

        } catch (IOException ioException) {
            responseMessage = MessageConstants.EXCEPTION;
        }

        return buildResponse(responseCode, responseMessage, response);

    }

    private void prepareRequest(HttpURLConnection connection, CommonRequest commonRequest) throws RequestParseException, ProtocolException {

        connection.setRequestProperty(USER_AGENT, "User-Agent");
        connection.setRequestProperty(ACCESS_CONTROL_ALLOW_HEADERS, "*/*");
        connection.setRequestMethod(commonRequest.getRequest());

        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);

        if (!ObjectUtils.isEmpty(commonRequest.getHeaders())) {
            try {
                JSONObject userDefinedHeaders = commonRequest.getHeaders();
                for (String key : userDefinedHeaders.keySet()) {
                    connection.setRequestProperty(key, String.valueOf(userDefinedHeaders.get(key)));
                }
            } catch (Exception e) {
                throw new RequestParseException(e.getMessage());
            }
        }
    }

    private CommonResponse<?> buildResponse(int responseCode, String message, StringBuilder response) {
        if (HttpStatus.valueOf(responseCode).is2xxSuccessful()) {
            return CommonResponse.success(responseCode, message, response.toString());
        }
        return CommonResponse.failure(responseCode, message);
    }
}
