package com.freshworks.requestproxy;

import com.freshworks.requestproxy.model.SupportedRequestTypes;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.google.common.net.HttpHeaders.CONTENT_TYPE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RequestProxyServiceApplication.class)
class RequestProxyServiceIntegrationTests {

    private HttpURLConnection connection;

    private OutputStream outputStream;

    private BufferedReader inputStream;

    @BeforeEach
    void initialize() throws IOException {
        URL obj = new URL(createURLWithPort("/api/v1/replay"));
        connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod(SupportedRequestTypes.POST.name());
        connection.setRequestProperty(CONTENT_TYPE, "application/json");
        connection.setDoOutput(true);

        outputStream = connection.getOutputStream();

    }

    @AfterEach
    void closeAllConnection() throws IOException {
        outputStream.flush();
        outputStream.close();
        connection.disconnect();
    }

    @Test
    public void testRequestProcessorSuccess() throws IOException {

        String body = "{\n    \"clientId\" :1000,\n     \"url\":\"https://google.com\",\n     \"headers\": {\n       \"Accept\":\"application/json\"\n     },\n    \"request\":\"GET\",\n     \"body\":\"abc\"\n}";

        outputStream.write(body.getBytes());

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String inputLine;
            StringBuffer response = new StringBuffer();
            inputStream = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            while ((inputLine = inputStream.readLine()) != null) {
                response.append(inputLine);
            }
            inputStream.close();
        }
        Assert.assertEquals(responseCode, 200);
    }

    @Test
    public void testRequestProcessorWithMissingParameters() throws IOException {

        String body = "{\n    \"clientId\" :,\n     \"url\":\"https://google.com\",\n     \"headers\": {\n       \"Accept\":\"application/json\"\n     },\n    \"request\":\"\",\n     \"body\":\"abc\"\n}";

        outputStream.write(body.getBytes());

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String inputLine;
            StringBuffer response = new StringBuffer();
            inputStream = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            while ((inputLine = inputStream.readLine()) != null) {
                response.append(inputLine);
            }
            inputStream.close();
        }

        Assert.assertEquals(responseCode, 400);
    }

    @Test
    public void testRequestProcessorWithInvalidUrl() throws IOException {

        String body = "{\n    \"clientId\" :1000,\n     \"url\":\"http://google.com\",\n     \"headers\": {\n       \"Accept\":\"application/json\"\n     },\n    \"request\":\"GET\",\n     \"body\":\"abc\"\n}";

        outputStream.write(body.getBytes());

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String inputLine;
            StringBuffer response = new StringBuffer();
            inputStream = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            while ((inputLine = inputStream.readLine()) != null) {
                response.append(inputLine);
            }
            inputStream.close();
        }

        Assert.assertEquals(responseCode, 400);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:8090" + uri;
    }
}
