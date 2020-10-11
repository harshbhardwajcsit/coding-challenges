package com.freshworks.requestproxy.service;

import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.entity.responseEntity.CommonResponse;
import com.freshworks.requestproxy.exception.RequestTimeoutException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ExecutionService {

    public CommonResponse<?> executeRequest(CommonRequest commonRequest) throws RequestTimeoutException, IOException, URISyntaxException;
}
