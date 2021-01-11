package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface CustomerService {

	public List<Customer> viewAllCustomers() throws BusinessException;
	public List<Customer> viewCustomerByCustomerName(String name)throws BusinessException;
	public double viewBalance(int account_num);
	public double withdrawl(int amount, int account_num);
	public double deposit(int amount, int account_num);
	public double transferFunds(int account_num1, int account_num2, int amount);
	
}
