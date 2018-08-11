package com.practise.invoice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.SortedMap;

@Component
public class CreateInvoice extends CalculatorImpl  {


    double createInvoice(Item item){
        return getItemFinalPriceIncludingTax(item);
    }
}
