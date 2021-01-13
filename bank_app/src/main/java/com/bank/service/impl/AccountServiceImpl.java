package com.bank.service.impl;


import org.apache.log4j.Logger;

import com.bank.dao.AccountDAO;
import com.bank.dao.impl.AccountDAOImpl;
import com.bank.exception.BusinessException;

import com.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO = new AccountDAOImpl();
	
	private static Logger log = Logger.getLogger(AccountServiceImpl.class);

	
	@Override
	public double viewBalance(int account_num) throws BusinessException {
		double balance;
		if(account_num>=999999 && account_num<100000100) {
			balance = accountDAO.viewBalance(account_num);
		}else {
			throw new BusinessException("Entered account number "+ account_num+" is invalid");
		}
		
		return balance;
	}

	@Override
	public int Deposit(double amount, int account_number) throws BusinessException {
		int valid=0;
		try {
			if(accountDAO.Deposit(amount,account_number) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}

	@Override
	public int Withdraw(double amount, int account_number) throws BusinessException {

			int valid=0;
			try {
				if(accountDAO.Withdraw(amount,account_number) !=0) {
					valid = 1;
				}
			}catch (BusinessException e) {
				log.info(e.getMessage());
			}
			return valid;
		}

	@Override
	public int transferFunds(double amount, int account_number1, int account_number2) throws BusinessException {
		int valid=0;
		try {
			if(accountDAO.transferFunds(amount,account_number1,account_number2) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}

	@Override
	public int newAccount(int user_id, double balance,String account_type) throws BusinessException {
		int valid = 0;
		try {
			if(accountDAO.newAccount(user_id, account_type, balance)!=0) {
				valid =1;
			}
		}catch(BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}
	

}
