package com.practise.invoice;

import org.springframework.stereotype.Service;

public class CalculatorImpl implements Calculator {
    private int tax=20;

    @Override
    public Item getItemFinalPriceIncludingTax(Item item) {
        item.setCost(applyRegularTax(item)+item.getCost());
        return item;

    }

    @Override
    public double getFinalPurchasedPrice(double finalPriceBeforeTax) {
        return (finalPriceBeforeTax*20)/100;
    }

    @Override
    public double applyRegularTax(Item item) {

        return (item.getQuantity()*item.getCost()*tax)/100;
    }
}
