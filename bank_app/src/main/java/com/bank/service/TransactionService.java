package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Transaction;

public interface TransactionService {
	public List<Transaction> viewTransactionsByAccountNumber(int account_number) throws BusinessException;
}
