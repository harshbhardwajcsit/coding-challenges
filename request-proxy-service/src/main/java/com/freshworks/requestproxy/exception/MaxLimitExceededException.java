package com.freshworks.requestproxy.exception;

public class MaxLimitExceededException extends Exception {

    public MaxLimitExceededException(String message) {
        super(message);
    }
}
