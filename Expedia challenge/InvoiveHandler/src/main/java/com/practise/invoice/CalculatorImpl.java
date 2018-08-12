package com.practise.invoice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

public class CalculatorImpl implements Calculator {
    private int tax=20;

    @Override
    public Item getItemFinalPriceIncludingTax(Item item) {
        item.setCost(item.getCost()*item.getQuantity()+applyRegularTax(item.getCost()*item.getQuantity()));
        return item;

    }

    @Override
    public double getFinalPurchasedPrice(ArrayList<Item> listWithTaxApplied) {
        double finalPriceBeforeTax=0;
        Iterator<Item> iterator = listWithTaxApplied.iterator();
        while (iterator.hasNext()) {
            Item listItem=iterator.next();
            finalPriceBeforeTax=finalPriceBeforeTax+listItem.getCost();
        }

        return applyRegularTax(finalPriceBeforeTax)+finalPriceBeforeTax;
    }

    @Override
    public double applyRegularTax(double cost) {

        return (cost*tax)/100;
    }
}
