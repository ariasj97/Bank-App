package com.bank.dao;


import com.bank.exception.BusinessException;


public interface AccountDAO {
	public double viewBalance(int account_num)throws BusinessException;
	public int Deposit(double amount, int account_number) throws BusinessException;
	public int Withdraw(double amount, int account_number) throws BusinessException;
	public int transferFunds(double amount, int accountnumber1, int accountnumber2)throws BusinessException;
	public int newAccount(int user_id,String account_type, double balance)throws BusinessException;
}
