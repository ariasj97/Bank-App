package com.bank.service.impl;

import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.dao.impl.TransactionDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Transaction;
import com.bank.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	@Override
	public List<Transaction> viewTransactionsByAccountNumber(int account_number) throws BusinessException {
		List<Transaction> getTransactions = null;
		if(account_number>=999999 && account_number<100000100) {
			getTransactions = transactionDAO.viewTransactionsByAccountNumber(account_number);
		}else {
			throw new BusinessException("Entered account number "+ account_number+" is invalid");
		}
		
		return getTransactions;
	}

}
