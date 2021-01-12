package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface AccountService {
	public double viewBalance(int account_num)throws BusinessException;
	public int Deposit(double amount, int account_number) throws BusinessException;
	public int Withdraw(double amount, int account_number) throws BusinessException;
	public int transferFunds(double amount, int account_number1, int account_number2) throws BusinessException;
}
