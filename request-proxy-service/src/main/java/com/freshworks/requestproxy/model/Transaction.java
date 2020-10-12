package com.freshworks.requestproxy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("An Entity to capture or trace client activing on the proxy system")
public class Transaction {

    @ApiModelProperty(value = "Represents time when client access the system last")
    private Date accessTime;

    @ApiModelProperty(value = "Represents the count, client requested the system already")
    private Integer accessCount;

    public Transaction() {
    }

    public Transaction(Date accessTime, Integer accessCount) {
        this.accessTime = accessTime;
        this.accessCount = accessCount;
    }
}
