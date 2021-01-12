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
	public double viewBalance(int account_num) throws BusinessException {
		double balance=0.0;

		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="select balance from public.account where account_number=?"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setDouble(1,account_num);
				
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				balance = resultSet.getDouble("balance");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return balance;
	}

	@Override
	public int Deposit(double amount, int account_number) throws BusinessException {
		int c =0;

		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="update public.account set balance=balance+? where account_number=?"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setDouble(1,amount);
			preparedStatement.setInt(2, account_number);
				
			c= preparedStatement.executeUpdate();
			
			String sql2 ="insert into public.transaction(transaction_type,amount,account_number,date) values('deposit',?,?,current_date)"; 
			PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
			preparedStatement2.setDouble(1,amount);
			preparedStatement2.setInt(2, account_number);
			c= preparedStatement2.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return c;
	}

	@Override
	public int Withdraw(double amount, int account_number) throws BusinessException {
		int c =0;

		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="update public.account set balance=balance-? where account_number=?"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setDouble(1,amount);
			preparedStatement.setInt(2, account_number);
				
			c= preparedStatement.executeUpdate();
			
			String sql2 ="insert into public.transaction(transaction_type,amount,account_number,date) values('withdraw',?,?,current_date)"; 
			PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
			preparedStatement2.setDouble(1,amount);
			preparedStatement2.setInt(2, account_number);
			c= preparedStatement2.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return c;
	}

	@Override
	public Account getBalance(int account_number) throws BusinessException {
		Account account = null;

		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="select balance from public.account where account_number=?"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setDouble(1,account_number);
				
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				account= new Account();
				account.setAccount_number(account_number);
				account.setBalance(resultSet.getDouble("balance"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return account;
	}

	@Override
	public int transferFunds(double amount, int account_number1, int account_number2) throws BusinessException {
		int c =0;

		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="update public.account set balance=balance-? where account_number=?"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setDouble(1,amount);
			preparedStatement.setInt(2, account_number1);
				
			c= preparedStatement.executeUpdate();
			
			String sql2 ="update public.account set balance=balance+? where account_number=?"; 
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setDouble(1,amount);
			preparedStatement2.setInt(2, account_number2);
				
			c= preparedStatement2.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return c;
	}

}
