package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bank.dao.EmployeeDAO;
import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Employee;
import com.bank.model.Login;
import com.bank.model.Transaction;
import com.bank.model.Customer;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	@Override
	public int newCustomer(Customer customer)throws BusinessException {
		int c= 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="insert into public.customer(user_id,name,street_address,dob,credit_score) values(?,?,?,?,?) ";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getCustomer_id());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getStreet_address());
			preparedStatement.setDate(4, new java.sql.Date(customer.getDob().getTime()));
			preparedStatement.setInt(5, customer.getCredit_score());
			
			c= preparedStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return c;
	}

	

	@Override
	public void newCustomerValidation(int credit_score) {
	
		if(credit_score<500) {
			log.info("This Customer does not meet the sufficient credit score of at least 500.");
		}else {
			log.info("This customer meets the requirements to become a new bank member. Please continue with the regestration process");
		}
	}

	
	@Override
	public Employee employeeLogin(int user_id, int account_number)throws BusinessException{
		Employee employee = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select user_id, account_number from public.employee where user_id=? and account_number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2,account_number);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee();
				employee.setEmployee_id(user_id);
				employee.setAccount_number(account_number);
				
			}else {
				throw new BusinessException("No combination of inputted user id and account number found");
				
			}
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
			
		return employee;
	}

}
