package com.beauessence.agenda.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.beauessence.agenda.models.Customer;
import com.beauessence.agenda.services.CustomerServices;

@RunWith(SpringRunner.class)
@WebMvcTest(Customer.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CustomerServices customerServices;
	
	@Test
	public void getCustomerTest() {}
	
	@Test
	public void getAllCustomersTest() {}
	
	@Test
	public void addCustomer() {}
	
	@Test
	public void updateCustomer() {}
	
	@Test
	public void deleteCustomer() {}

}
