package com.bank.service;

import java.sql.ResultSet;
import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.model.Transaction;

public interface EmployeeService {
	public int newCustomer(Customer customer)throws BusinessException;
	public List<Customer> viewAllCustomers() throws BusinessException;
	public List<Customer> viewCustomerByCustomerName(String name)throws BusinessException;
	public boolean newCustomerValidation(int credit_score, double balance);
	public List<Transaction> viewTransactionsByAccountNumber(int account_number) throws BusinessException;
}
