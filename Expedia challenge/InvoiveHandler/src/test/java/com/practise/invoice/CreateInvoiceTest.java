package com.practise.invoice;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CreateInvoiceTest {

    @InjectMocks
    CreateInvoice createInvoice;

    @Mock
    Calculator calculator;

    @Test
    public void testCreateInvoice(){
        Item item=new Item();
        item.setQuantity(1);
        item.setItemName("Book");
        item.setCost(20);
        Assert.assertEquals(24.0,createInvoice.createInvoice(item));
    }
}
