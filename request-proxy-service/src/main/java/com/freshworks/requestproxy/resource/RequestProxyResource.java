package com.freshworks.requestproxy.resource;

import com.freshworks.requestproxy.constant.CommonConstants;
import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.entity.responseEntity.CommonResponse;
import com.freshworks.requestproxy.exception.RequestTimeoutException;
import com.freshworks.requestproxy.service.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(CommonConstants.API_VERSION + "/replay")
public class RequestProxyResource {

    final private ExecutionService executionService;

    @Autowired
    public RequestProxyResource(ExecutionService executionService) {
        this.executionService = executionService;
    }

    @PostMapping
    public CommonResponse<?> processRequest(@RequestBody CommonRequest commonRequest) throws RequestTimeoutException, IOException, URISyntaxException {
        return executionService.executeRequest(commonRequest);
    }

}
