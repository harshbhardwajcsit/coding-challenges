package com.freshworks.requestproxy.constant;

public interface MessageConstants {

    public static final String UNSUPPORTED_REQUEST = "Request not supported by system, only GET or POST are allowed";
    public static final String MALFORMED_URL_STRUCTURE = "The Requested URL is not allowed as per the RFC protocol";
    public static final String MISSING_REQUEST_PARAMS = "Required Parameters are missing in a request";
    public static final String MAX_LIMIT_REACHED = "Maximum limit is reached to request the resource, please re-try after 1 minute";
    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failure";
}
