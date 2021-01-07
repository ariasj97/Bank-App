package com.bank.dao;

import com.bank.exception.BusinessException;

import com.bank.customer.Customer;

public interface CustomerDAO {

	public Customer newAccount(String account_type, int amount) throws BusinessException;
	public double viewBalance(int account_num);
	public double withdrawl(int amount, int account_num);
	public double deposit(int amount, int account_num);
	public double transferFunds(int account_num1, int account_num2, int amount);
	
}
