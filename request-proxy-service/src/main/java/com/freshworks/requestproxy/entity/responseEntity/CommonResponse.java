package com.freshworks.requestproxy.entity.responseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "Entity representing response if all inputs were valid")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T extends Serializable> {

    public enum OperationStatus {
        SUCCESS, FAILURE
    }

    @ApiModelProperty(value = "A relevant HTTPs response code")
    private final int responseCode;

    @ApiModelProperty(value = "Any relevant message related to the overall state of operation")
    private final String message;

    @ApiModelProperty(value = "Status of operation, either SUCCESS or FAILURE")
    private final OperationStatus status;

    @ApiModelProperty(value = "Any entity or data associated with success of operation")
    private final T data;

    public static <T extends Serializable> CommonResponse<T> failure(int responseCode, String message) {
        return CommonResponse.failure(responseCode, message, null);
    }

    public static <T extends Serializable> CommonResponse<T> failure(int responseCode, String message, T data) {
        return new CommonResponse<>(responseCode, message, OperationStatus.FAILURE, data);
    }

    public static CommonResponse<?> success(int responseCode, String message) {
        return CommonResponse.success(responseCode, message, null);
    }

    public static <T extends Serializable> CommonResponse<T> success(int responseCode, String message, T data) {
        return new CommonResponse<>(responseCode, message, OperationStatus.SUCCESS, data);
    }

    public CommonResponse(int responseCode, String message, OperationStatus status) {
        this(responseCode, message, status, null);
    }

    public CommonResponse(int responseCode, String message, OperationStatus status, T data) {
        this.responseCode = responseCode;
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
