package com.practise.invoice;

import org.springframework.stereotype.Service;

public class CalculatorImpl implements Calculator {
    private int tax=20;

    @Override
    public double getItemFinalPriceIncludingTax(Item item) {
        return applyRegularTax(item)+item.getCost();

    }

    @Override
    public double getFinalPurchasedPrice(Item item) {
        return 0;
    }

    @Override
    public double applyRegularTax(Item item) {
        return (item.getQuantity()*item.getCost()*tax)/100;
    }
}
