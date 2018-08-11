package com.practise.invoice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

@Component
public class CreateInvoice extends CalculatorImpl  {


    void createInvoice(ArrayList<Item> itemList){
        ArrayList<Item> updatedInvoiceList=new ArrayList<>();
        double finalPriceBeforeTax=0;
        double finalPriceAfterTaxApplied=0;
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            Item itemWithTaxApplied=getItemFinalPriceIncludingTax(iterator.next());
            updatedInvoiceList.add(itemWithTaxApplied);
            finalPriceBeforeTax=finalPriceBeforeTax+itemWithTaxApplied.getCost();
        }
        finalPriceAfterTaxApplied=getFinalPurchasedPrice(finalPriceBeforeTax);
        printInvoice(updatedInvoiceList);

    }

    void printInvoice(ArrayList<Item> updatedInvoiceList){
        System.out.println(updatedInvoiceList);

    }
}
