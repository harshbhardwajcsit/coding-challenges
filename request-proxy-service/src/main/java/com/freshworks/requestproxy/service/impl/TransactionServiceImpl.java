package com.freshworks.requestproxy.service.impl;

import com.freshworks.requestproxy.model.Transaction;
import com.freshworks.requestproxy.service.TransactionService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TransactionServiceImpl implements TransactionService {

    private final Map<Long, Transaction> transactions = new ConcurrentHashMap<>();

    @Override
    public Optional<Transaction> getClientAccessRecords(Long clientId) {
        if (transactions.containsKey(clientId)) {
            return Optional.ofNullable(transactions.get(clientId));
        }
        return Optional.empty();
    }

    @Override
    public void storeClientAccessRecords(Long clientId) {

        if (!transactions.containsKey(clientId)) {
            transactions.put(clientId, new Transaction(new Date(), 1));
        } else {
            transactions.put(clientId, new Transaction(new Date(), transactions.get(clientId).getAccessCount() + 1));
        }
    }
}
