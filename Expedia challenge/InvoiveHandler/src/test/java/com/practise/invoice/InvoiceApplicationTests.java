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
	public void testCreateInvoice(){
        ArrayList<Item> arrayList=new ArrayList<>();
        Item item=new Item();
		item.setQuantity(1);
		item.setItemName("Book");
		item.setCost(20);
        arrayList.add(item);
        Item item1=new Item();
        item1.setQuantity(2);
        item1.setItemName("pen");
        item1.setCost(10);
        arrayList.add(item1);
        createInvoice.createInvoice(arrayList);

	}

}
