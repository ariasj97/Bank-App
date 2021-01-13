package com.bank.service;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface EmployeeService {
	public int newCustomer(Customer customer)throws BusinessException;
	public void newCustomerValidation(int credit_score) throws BusinessException;
}
