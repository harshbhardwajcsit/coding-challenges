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

        ArrayList<Item> expectedList=new ArrayList<>();
        Item item2=new Item();
        item2.setItemName("book");
        item2.setQuantity(1);
        item2.setCost(36.0);
        arrayList.add(item2);
        expectedList.add(item2);

        Item item3=new Item();
        item3.setItemName("chocolate");
        item3.setQuantity(1);
        item3.setCost(1.2);
        arrayList.add(item3);
        expectedList.add(item3);


        assertEquals("The Total cost after apply regular tax",37.2,createInvoice.finalPriceAfterTaxApplied);
        assertEquals("Total Sales Tax",6.2,createInvoice.totalSalesTax);
	}

}
