package com.practise.invoice;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {
    private int tax=20;

    @Override
    public float getItemFinalPriceIncludingTax(Item item) {
        return applyRegularTax(item);

    }

    @Override
    public float getFinalPurchasedPrice(Item item) {
        return 0;
    }

    @Override
    public float applyRegularTax(Item item) {
        return (item.getQuantity()*item.getCost()*tax)/100;
    }
}
