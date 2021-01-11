package com.bank.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface AccountDAO {
	public List<Account> viewBalance(int account_num)throws BusinessException;
}
