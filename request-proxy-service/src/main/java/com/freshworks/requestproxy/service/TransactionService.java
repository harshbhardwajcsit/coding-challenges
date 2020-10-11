package com.freshworks.requestproxy.service;

import com.freshworks.requestproxy.model.Transaction;

import java.util.Optional;

public interface TransactionService {

    public Optional<Transaction> getClientAccessRecords(Long clientId);

    public void storeClientAccessRecords(Long clientId);
}
