package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.CustomerDAO;
import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {


	@Override
	public List<Customer> viewAllCustomers() throws BusinessException {
		List<Customer> customersList = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql= "select user_id, name, street_address, dob, credit_score from public.customer";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("user_id"));
				customer.setName(resultSet.getString("name"));
				customer.setStreet_address(resultSet.getString("street_address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setCredit_score(resultSet.getInt("credit_score"));
				customersList.add(customer);
			}
			
			if(customersList.size()==0) {
				throw new BusinessException("No customers in the database so far ");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		return customersList;
	}

	@Override
	public List<Customer> viewCustomerByCustomerName(String name) throws BusinessException {
		List<Customer> customerList  = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql= "select user_id, name, street_address, dob, credit_score from public.customer where name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("user_id"));
				customer.setName(name);
				customer.setStreet_address(resultSet.getString("street_address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setCredit_score(resultSet.getInt("credit_score"));
				customerList.add(customer);
			}
			
			if(customerList.size()==0) {
				throw new BusinessException("No customer in the database with that name. Please check spelling and case sensitivity ");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
	return customerList;
	
	}

	@Override
	public double viewBalance(int account_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdrawl(int amount, int account_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit(int amount, int account_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transferFunds(int account_num1, int account_num2, int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
