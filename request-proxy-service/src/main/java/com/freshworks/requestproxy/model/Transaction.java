package com.freshworks.requestproxy.model;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {

    private Date accessTime;

    private Integer accessCount;

    public Transaction() {
    }

    public Transaction(Date accessTime, Integer accessCount) {
        this.accessTime = accessTime;
        this.accessCount = accessCount;
    }
}
