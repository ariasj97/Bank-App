package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface AccountService {
	public List<Account> viewBalance(int account_num)throws BusinessException;
}
