package com.bank.service.impl;

import java.util.List;

import com.bank.dao.AccountDAO;
import com.bank.dao.impl.AccountDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public List<Account> viewBalance(int account_num) throws BusinessException {
		List<Account> balance = null;
		if(account_num>=999999 && account_num<100000100) {
			balance = accountDAO.viewBalance(account_num);
		}else {
			throw new BusinessException("Entered account number "+ account_num+" is invalid");
		}
		
		return balance;
	}

}
