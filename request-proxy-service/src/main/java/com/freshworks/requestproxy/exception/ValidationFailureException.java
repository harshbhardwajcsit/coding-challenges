package com.freshworks.requestproxy.exception;

public class ValidationFailureException extends Exception{

    public ValidationFailureException(String message) {
        super(message);
    }
}
