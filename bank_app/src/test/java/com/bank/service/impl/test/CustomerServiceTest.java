package com.bank.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.bank.model.Customer;
import com.bank.service.CustomerService;
import com.bank.service.impl.CustomerServiceImpl;


class CustomerServiceTest {

	private static CustomerService app;

	@BeforeAll
	public static void setUp() {
		app = new CustomerServiceImpl();
	}
	
	@Test
	public void getNameTest(){
		
		Customer customer = new Customer();
		customer.setName("Jason Arias");
	
		assertEquals("Jason Arias",customer.getName());
	}
	@Test
	public void getCredit_scoreTest(){
		
		Customer customer = new Customer();
		customer.setCredit_score(750);
	
		
		assertEquals(750,customer.getCredit_score());
	}

	@Test
	public void getStreet_addressTest(){
		
		Customer customer = new Customer();
		customer.setStreet_address("123 Memory Lane");
	
		assertEquals("123 Memory Lane",customer.getStreet_address());
	}


}
