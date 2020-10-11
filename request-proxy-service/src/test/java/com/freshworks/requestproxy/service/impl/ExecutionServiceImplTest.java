package com.freshworks.requestproxy.service.impl;


import com.freshworks.requestproxy.RequestProxyUnitTest;
import com.freshworks.requestproxy.TestConstants;
import com.freshworks.requestproxy.constant.MessageConstants;
import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.entity.responseEntity.CommonResponse;
import com.freshworks.requestproxy.exception.RequestTimeoutException;
import com.freshworks.requestproxy.model.SupportedRequestTypes;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

@RunWith(SpringRunner.class)
@Category(RequestProxyUnitTest.class)
public class ExecutionServiceImplTest {

    public ExecutionServiceImplTest() {
    }

    @InjectMocks
    private ExecutionServiceImpl executionService;

    @Mock
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void initialize() throws Exception {
        transactionService = new TransactionServiceImpl();
        MockitoAnnotations.initMocks(this);
        executionService = new ExecutionServiceImpl(transactionService);
    }

    @Test
    public void testWithInValidUrlRequest() throws RequestTimeoutException, URISyntaxException, IOException {
        final CommonRequest invalidRequest = new CommonRequest(1000L,"http://abc.com", new JsonObject(), SupportedRequestTypes.GET.name(), "");
        final CommonResponse<?> response = executionService.executeRequest(invalidRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponseCode());
        Assert.assertEquals(MessageConstants.MALFORMED_URL_STRUCTURE, response.getMessage());

    }

    @Test
    public void testWithMissingParametersInRequest() throws RequestTimeoutException, URISyntaxException, IOException {
        final CommonRequest invalidRequest = new CommonRequest(1000L,"https://abc.com", null, SupportedRequestTypes.GET.name(), "");
        final CommonResponse<?> response = executionService.executeRequest(invalidRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponseCode());
        Assert.assertEquals(MessageConstants.MISSING_REQUEST_PARAMS, response.getMessage());
    }

    @Test
    public void testWithUnsupportedRequestType() throws RequestTimeoutException, URISyntaxException, IOException {
        final CommonRequest invalidRequest = new CommonRequest(1000L, "https://abc.com", new JsonObject(), TestConstants.PUT, "");
        final CommonResponse<?> response = executionService.executeRequest(invalidRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponseCode());
        Assert.assertEquals(MessageConstants.UNSUPPORTED_REQUEST, response.getMessage());
    }

    @Test
    public void testForIncorrectGetResponse() throws RequestTimeoutException, URISyntaxException, IOException {
        URL url = new URL("https://www.google.com/");
        HttpURLConnection con = Mockito.mock(HttpURLConnection.class);
        Mockito.doReturn(400).when(con).getResponseCode();

        con.setRequestMethod(SupportedRequestTypes.GET.name());
        con.setDoOutput(true);

        con.setConnectTimeout(300);
        con.setReadTimeout(300);

        int status = con.getResponseCode();
        con.disconnect();

        Assert.assertNotEquals("status code correct", status, 200);
    }

    @Test
    public void testForCorrectGetResponse() throws RequestTimeoutException, URISyntaxException, IOException {
        URL url = new URL("https://www.google.com/");
        HttpURLConnection con = Mockito.mock(HttpURLConnection.class);
        Mockito.doReturn(200).when(con).getResponseCode();

        con.setRequestMethod(SupportedRequestTypes.GET.name());
        con.setDoOutput(true);

        con.setConnectTimeout(300);
        con.setReadTimeout(300);

        int status = con.getResponseCode();
        con.disconnect();

        Assert.assertEquals("status code correct", status, 200);
    }

}
