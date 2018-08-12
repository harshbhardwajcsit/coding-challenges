package com.practise.invoice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceApplicationTests {

	private CreateInvoice createInvoice=new CreateInvoice();
    private ItemList itemList=new ItemList();
    private Item item=new Item();

	@Test
	public void contextLoads() {
	}


	@Test
	public void testCreateInvoiceWithNoMedicalProducts(){
        ArrayList<Item> arrayList=new ArrayList<>();
        Item item=new Item();
		item.setQuantity(1);
		item.setItemName("book");
		item.setCost(30);
        arrayList.add(item);


        Item item1=new Item();
        item1.setQuantity(1);
        item1.setItemName("chocolate");
        item1.setCost(1);
        arrayList.add(item1);
        createInvoice.createInvoice(arrayList);

        assertEquals("The Total cost after apply regular tax",37.2,createInvoice.finalPriceAfterTaxApplied);
        assertEquals("Total Sales Tax",6.2,createInvoice.totalSalesTax);
	}

    @Test
    public void testCreateInvoiceWithMedicalProducts(){
        ArrayList<Item> arrayList=new ArrayList<>();
        Item item=new Item();
        item.setQuantity(1);
        item.setItemName("bottle of wine");
        item.setCost(20);
        arrayList.add(item);


        Item item1=new Item();
        item1.setQuantity(2);
        item1.setItemName("box of headache pills");
        item1.setCost(4);
        arrayList.add(item1);


        Item item3=new Item();
        item3.setQuantity(1);
        item3.setItemName("box of pens");
        item3.setCost(10);
        arrayList.add(item3);
        createInvoice.createInvoice(arrayList);


        assertEquals("The Total cost after apply regular tax",44.0,createInvoice.finalPriceAfterTaxApplied);
        assertEquals("Total Sales Tax",6.0,createInvoice.totalSalesTax);
    }

}
