package com.practise.invoice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

public class CalculatorImpl implements Calculator {

    @Override
    public Item getItemFinalPriceIncludingTax(Item item) {
        if(!isMedicalProduct(item)){
            item.setCost(getGrossPrice(item)+applyRegularTax(getGrossPrice(item)));
        }else{
            item.setCost(getGrossPrice(item));
        }

        return item;

    }

    @Override
    public double getFinalPurchasedPrice(ArrayList<Item> listWithTaxApplied) {
        double finalPriceBeforeTax=0;
        for (Item listItem : listWithTaxApplied) {
            finalPriceBeforeTax = finalPriceBeforeTax + listItem.getCost();
        }

        return finalPriceBeforeTax;
    }

    @Override
    public double applyRegularTax(double cost) {

        int tax = 20;
        return (cost* tax)/100;
    }

    @Override
    public double getGrossPrice(Item item){
        return item.getCost()*item.getQuantity();
    }

    @Override
    public  boolean isMedicalProduct(Item item){
        boolean isMedicalProduct=false;
        if(new ItemList().getMedicalItemList().contains(item.getItemName())){
            isMedicalProduct=true;
        }
        return isMedicalProduct;
    }
}
