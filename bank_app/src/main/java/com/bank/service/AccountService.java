package com.bank.service;



import com.bank.exception.BusinessException;


public interface AccountService {
	public double viewBalance(int account_num)throws BusinessException;
	public int Deposit(double amount, int account_number) throws BusinessException;
	public int Withdraw(double amount, int account_number) throws BusinessException;
	public int transferFunds(double amount, int account_number1, int account_number2) throws BusinessException;
	public int newAccount(int user_id, double balance,String account_type)throws BusinessException;
}
