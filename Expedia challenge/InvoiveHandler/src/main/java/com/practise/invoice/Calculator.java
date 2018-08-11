package com.practise.invoice;

public interface Calculator {
    public float getItemFinalPriceIncludingTax(Item item);
    public float getFinalPurchasedPrice(Item item);
    public float applyRegularTax(Item item);
}
