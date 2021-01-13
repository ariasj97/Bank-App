package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface CustomerService {

	public List<Customer> viewAllCustomers() throws BusinessException;
	public List<Customer> viewCustomerByCustomerName(String name)throws BusinessException;
	
}
