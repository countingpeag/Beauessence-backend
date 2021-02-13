package com.beauessence.agenda.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beauessence.agenda.repositories.CustomerRep;

import junit.framework.TestCase;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest extends TestCase{

	@Mock
	private CustomerRep customerRepo;
	
	@InjectMocks
	private CustomerServices customerServices;
	
	@Test
	public void getCustomerTest() {}
	
	@Test
	public void addCustomerTest() {}
	
	@Test
	public void updateCustomerTest() {}
	
	@Test
	public void deleteCustomerTest() {}
}
