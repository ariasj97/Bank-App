package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.AccountDAO;
import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> viewBalance(int account_num) throws BusinessException {
		List<Account> accountList = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql= "select user_id, balance, account_type, account_number from public.account where account_number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,account_num);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Account account = new Account();
				account.setUser_id(resultSet.getInt("user_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setAccount_type(resultSet.getString("account_type"));
				account.setAccount_number(account_num);
				accountList.add(account);
			}
			
			if(accountList.size()==0) {
				throw new BusinessException("No Account in the database with account number: "+account_num);
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		return accountList;
	}

}
