package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public List<Transaction> viewTransactionsByAccountNumber(int account_number) throws BusinessException {
		List<Transaction> transactionList  = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql= "select transaction_type, amount, account_number, date from public.transaction where account_number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,account_number);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransaction_type(resultSet.getString("transaction_type"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setAccount_number(account_number);
				transaction.setDate(resultSet.getDate("date"));
				transactionList.add(transaction);
			}
			
			if(transactionList.size()==0) {
				throw new BusinessException("No account number in the database with that number. Please enter a valid account number ");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
	return transactionList;
	}

}
