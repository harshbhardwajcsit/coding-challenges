package com.freshworks.requestproxy.validator;

import com.freshworks.requestproxy.RequestProxyUnitTest;
import com.freshworks.requestproxy.TestConstants;
import com.freshworks.requestproxy.entity.requestEntity.CommonRequest;
import com.freshworks.requestproxy.model.SupportedRequestTypes;
import com.freshworks.requestproxy.model.Transaction;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@Category(RequestProxyUnitTest.class)
public class RequestValidatorTest {

    public RequestValidatorTest() {
    }

    @Test
    public void testInvalidUrl() throws MalformedURLException, URISyntaxException {
        //given
        final String url1 = "https: //abc.com";
        final String url2 = "http://abc. com";
        final String url3 = "";

        //when
        final Boolean isValidUrl1 = RequestValidator.isValidURL(url1);
        final Boolean isValidUrl2 = RequestValidator.isValidURL(url2);
        final Boolean isValidUrl3 = RequestValidator.isValidURL(url3);

        //then
        Assert.assertFalse(isValidUrl1);
        Assert.assertFalse(isValidUrl2);
        Assert.assertFalse(isValidUrl3);
    }

    @Test
    public void testForValidUrl() throws MalformedURLException, URISyntaxException {
        //given
        final String url = "https://google.com";

        //when
        final Boolean isValidUrl = RequestValidator.isValidURL(url);

        //them
        Assert.assertTrue(isValidUrl);
    }

    @Test
    public void testNonHttpsUrl() throws MalformedURLException, URISyntaxException {
        //given
        final String url = "http://abc.com";

        //when
        final Boolean isValidUrl = RequestValidator.isValidURL(url);

        //them
        Assert.assertFalse(isValidUrl);
    }

    @Test
    public void testForParameters() {
        //given
        final String url = "http://abc.com";
        final CommonRequest invalidRequest = new CommonRequest(1000L,url,null, null, "");
        final CommonRequest validRequest = new CommonRequest(1000L,url, new JsonObject(), SupportedRequestTypes.GET.name(), "");

        //when
        final Boolean inValidRequest = RequestValidator.isValidRequest(invalidRequest);
        final Boolean validateRequest = RequestValidator.isValidRequest(validRequest);

        //then
        Assert.assertFalse(inValidRequest);
        Assert.assertTrue(validateRequest);
    }

    @Test
    public void testForInValidRequestType(){
        //given
        final String url = "https://abc.com";
        final CommonRequest request = new CommonRequest(1000L,url, new JsonObject(), TestConstants.PUT, "");

        //when
        final Boolean isRequestWithValidType = RequestValidator.isValidRequestType(request);

        //then
        Assert.assertFalse(isRequestWithValidType);
    }

    @Test
    public void testForRequestLimitExceeds(){
        //given
        Optional<Transaction> mockTransaction = Optional.of(new Transaction(new Date(), 50));

        //when
        final Boolean isLimitExceeds = RequestValidator.isMaximumRequestLimitReached(mockTransaction, 50);

        //then
        Assert.assertTrue(isLimitExceeds);
    }
}
