package com.practise.invoice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceApplicationTests {

	private CreateInvoice createInvoice=new CreateInvoice();

	@Test
	public void contextLoads() {
	}


	@Test
	public void testCreateInvoice(){
		Item item=new Item();
		item.setQuantity(1);
		item.setItemName("Book");
		item.setCost(20);
        System.out.println(createInvoice.createInvoice(item));
        assertEquals("The calculated amount",24.0,createInvoice.createInvoice(item));
	}

}
