package com.bank.dao;


import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface AccountDAO {
	public double viewBalance(int account_num)throws BusinessException;
	public Account getBalance(int account_number) throws BusinessException;
	public int Deposit(double amount, int account_number) throws BusinessException;
	public int Withdraw(double amount, int account_number) throws BusinessException;
	public int transferFunds(double amount, int accountnumber1, int accountnumber2)throws BusinessException;
}
