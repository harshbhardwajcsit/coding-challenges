package com.freshworks.requestproxy.validator;

import com.freshworks.requestproxy.constant.CommonConstants;
import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.model.SupportedRequestTypes;
import com.freshworks.requestproxy.model.Transaction;
import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;

public class RequestValidator {

    public static Boolean isValidURL(String url) throws MalformedURLException, URISyntaxException {
        UrlValidator defaultValidator = new UrlValidator(CommonConstants.ALLOWED_SCHEMES);
        return defaultValidator.isValid(url);
    }

    public static Boolean isValidRequest(CommonRequest request) {
        if (request.getClientId() == null || request.getRequest() == null || request.getHeaders() == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean isValidRequestType(CommonRequest request) {
        final List<String> supportedRequestTypes = Arrays.stream(SupportedRequestTypes.values()).map(Enum::name).collect(Collectors.toList());
        return supportedRequestTypes.contains(request.getRequest());
    }

    public static Boolean isMaximumRequestLimitReached(Optional<Transaction> transaction, int limit){

        if(transaction.isPresent()){
            final Date lastAccessed = transaction.get().getAccessTime();
            final Long seconds = (new Date().getTime()-lastAccessed.getTime())/1000;
            if(seconds < 60){
                return transaction.get().getAccessCount() >= limit;
            }
        }

        return Boolean.TRUE;
    }
}
