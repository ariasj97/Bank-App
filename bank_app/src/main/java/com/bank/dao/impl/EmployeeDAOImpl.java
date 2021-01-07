package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.dbutil.PostresqlConnection;
import com.app.model.Player;
import com.bank.customer.Customer;
import com.bank.dao.EmployeeDAO;
import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Employee;
import com.bank.model.Login;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	@Override
	public int newCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

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
				customer.setStreet_address(resultSet.getString("name"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setCredit_score(resultSet.getInt("credit_score"));
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
	public Customer viewCustomerByCustomerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean newCustomerValidation(int credit_score, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet viewTransactionsByAccountNumber(int account_number) {
		// TODO Auto-generated method stub
		return null;
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
