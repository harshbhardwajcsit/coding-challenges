package com.freshworks.requestproxy.exception;

public class RequestTimeoutException extends Exception {

    public RequestTimeoutException(String message) {
        super(message);
    }
}
