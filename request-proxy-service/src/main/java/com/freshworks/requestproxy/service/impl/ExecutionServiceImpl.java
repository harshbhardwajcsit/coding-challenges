package com.freshworks.requestproxy.service.impl;

import com.freshworks.requestproxy.constant.MessageConstants;
import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.entity.responseEntity.CommonResponse;
import com.freshworks.requestproxy.exception.RequestTimeoutException;
import com.freshworks.requestproxy.model.SupportedRequestTypes;
import com.freshworks.requestproxy.service.ExecutionService;
import com.freshworks.requestproxy.service.TransactionService;
import com.freshworks.requestproxy.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import static com.google.common.net.HttpHeaders.USER_AGENT;

@Service
public class ExecutionServiceImpl implements ExecutionService {

    @Value("${request.limit}")
    private int limit;

    private final TransactionService transactionService;

    @Autowired
    public ExecutionServiceImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public CommonResponse<?> executeRequest(CommonRequest commonRequest) throws RequestTimeoutException, IOException, URISyntaxException {

        if (!RequestValidator.isValidRequest(commonRequest)) {
            return CommonResponse.failure(HttpStatus.BAD_REQUEST.value(), MessageConstants.MISSING_REQUEST_PARAMS);
        }

        if (!RequestValidator.isValidURL(commonRequest.getUrl())) {
            return CommonResponse.failure(HttpStatus.BAD_REQUEST.value(), MessageConstants.MALFORMED_URL_STRUCTURE);
        }

        if (!RequestValidator.isValidRequestType(commonRequest)) {
            return CommonResponse.failure(HttpStatus.BAD_REQUEST.value(), MessageConstants.UNSUPPORTED_REQUEST);
        }

        if (!RequestValidator.isMaximumRequestLimitReached(transactionService.getClientAccessRecords(commonRequest.getClientId()), limit)) {
            return CommonResponse.failure(HttpStatus.TOO_MANY_REQUESTS.value(), MessageConstants.MAX_LIMIT_REACHED);
        }

        return replayRequestOnUrl(commonRequest);
    }

    private CommonResponse<?> replayRequestOnUrl(CommonRequest commonRequest) throws IOException, RequestTimeoutException {

        try {
            URL obj = new URL(commonRequest.getUrl());
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod(commonRequest.getRequest());
            connection.setRequestProperty("User-Agent", USER_AGENT);

            if (commonRequest.getRequest().equals(SupportedRequestTypes.POST.name())) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(commonRequest.getBody().getBytes());
                outputStream.close();
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = inputStream.readLine()) != null) {
                    response.append(inputLine);
                }

                inputStream.close();

                transactionService.storeClientAccessRecords(commonRequest.getClientId());

                return CommonResponse.success(responseCode, MessageConstants.SUCCESS, response.toString());

            } else {

                return CommonResponse.failure(responseCode, MessageConstants.FAILURE);
            }

        } catch (Exception exception) {
            throw new RequestTimeoutException(exception.getMessage());
        }
    }
}
