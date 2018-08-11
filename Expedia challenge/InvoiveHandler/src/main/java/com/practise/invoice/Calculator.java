package com.practise.invoice;

public interface Calculator {
    public double getItemFinalPriceIncludingTax(Item item);
    public double getFinalPurchasedPrice(Item item);
    public double applyRegularTax(Item item);
}
