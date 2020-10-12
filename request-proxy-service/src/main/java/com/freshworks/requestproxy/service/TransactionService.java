package com.freshworks.requestproxy.service;

import com.freshworks.requestproxy.model.Transaction;

import java.util.Optional;

/** Transaction service is a singleton service just to keep track on the transaction
 * or the requests made by the client to the proxy system
 */

public interface TransactionService {

    /**
     * getClientAccessRecords fetch transaction record based on unique clientId
     */

    public Optional<Transaction> getClientAccessRecords(Long clientId);

    /**
     * storeClientAccessRecords store transaction record based on unique clientId
     */

    public void storeClientAccessRecords(Long clientId);
}
