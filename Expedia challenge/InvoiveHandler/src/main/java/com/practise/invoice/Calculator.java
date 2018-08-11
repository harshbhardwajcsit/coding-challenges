package com.practise.invoice;

public interface Calculator {
    public Item getItemFinalPriceIncludingTax(Item item);
    public double getFinalPurchasedPrice(double finalPriceBeforeTax);
    public double applyRegularTax(Item item);
}
