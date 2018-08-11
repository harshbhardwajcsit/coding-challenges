package com.practise.invoice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.SortedMap;

@Component
public class CreateInvoice  {

@Autowired
public Calculator calculator;

    public float createInvoice(Item item){
        System.out.println(calculator);
        float finalPrice=calculator.getItemFinalPriceIncludingTax(item);
        return finalPrice;
    }

    public static void main(String[] args){
        Item item=new Item();
        item.setQuantity(1);
        item.setItemName("Book");
        item.setCost(20);
        CreateInvoice createInvoice=new CreateInvoice();
        createInvoice.createInvoice(item);
    }
}
