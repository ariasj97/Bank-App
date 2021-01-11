package com.bank.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Transaction;

public interface TransactionDAO {
	public List<Transaction> viewTransactionsByAccountNumber(int account_number) throws BusinessException;
}
