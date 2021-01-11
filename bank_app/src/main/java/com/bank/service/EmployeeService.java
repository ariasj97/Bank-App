package com.bank.service;

import java.sql.ResultSet;
import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.model.Transaction;

public interface EmployeeService {
	public int newCustomer(Customer customer)throws BusinessException;
	public void newCustomerValidation(int credit_score) throws BusinessException;
}
