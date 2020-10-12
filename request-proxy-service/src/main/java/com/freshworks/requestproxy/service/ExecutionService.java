package com.freshworks.requestproxy.service;

import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.entity.responseEntity.CommonResponse;
import com.freshworks.requestproxy.exception.RequestParseException;
import com.freshworks.requestproxy.exception.RequestTimeoutException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * executeRequest method is used to execute the incoming request to replay with the Common request format
 */
public interface ExecutionService {

    public CommonResponse<?> executeRequest(CommonRequest commonRequest) throws RequestTimeoutException, IOException, URISyntaxException, RequestParseException;
}
