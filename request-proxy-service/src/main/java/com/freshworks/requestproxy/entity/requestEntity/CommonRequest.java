package com.freshworks.requestproxy.entity.requestEntity;

import com.google.gson.JsonObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonRequest implements Serializable {

    private Long clientId;
    private String url;
    private JsonObject headers;
    private String request;
    private String body;

    public CommonRequest() {
    }

    public CommonRequest(Long clientId, String url, JsonObject headers, String request, String body) {
        this.clientId = clientId;
        this.url = url;
        this.headers = headers;
        this.request = request;
        this.body = body;
    }
}
