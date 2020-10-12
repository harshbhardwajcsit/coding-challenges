package com.freshworks.requestproxy.model;

public enum SupportedRequestTypes {

    POST("POST"),
    GET("GET"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private String requestType;

    SupportedRequestTypes(String requestType) {
        this.requestType = requestType;
    }
}
