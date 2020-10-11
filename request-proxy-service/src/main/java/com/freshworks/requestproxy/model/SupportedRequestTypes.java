package com.freshworks.requestproxy.model;

public enum SupportedRequestTypes {
    POST("POST"),
    GET("GET");

    private String requestType;

    SupportedRequestTypes(String requestType) {
        this.requestType = requestType;
    }
}
