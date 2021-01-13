package com.bank.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.bank.model.Employee;

import com.bank.service.EmployeeService;

import com.bank.service.impl.EmployeeServiceImpl;

class EmployeeServiceTest {

	private static EmployeeService app;

	@BeforeAll
	public static void setUp() {
		app = new EmployeeServiceImpl();
	}

	@Test
	public void testGetEmployee_id(){
		
		Employee employee = new Employee();
		employee.setEmployee_id(1000);
	
		
		assertEquals(1000,employee.getEmployee_id());
	}
	
	@Test
	public void testGetAccount_number(){
		
		Employee employee = new Employee();
		employee.setAccount_number(123456788);
	
		
		assertEquals(123456788,employee.getAccount_number());
	}
}
