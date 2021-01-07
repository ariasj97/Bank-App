package com.bank.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.bank.customer.Customer;
import com.bank.exception.BusinessException;
import com.bank.model.Employee;
import com.bank.model.Login;

public interface EmployeeDAO {
	
	public Employee employeeLogin(int user_id, int account_number)throws BusinessException;
	public int newCustomer(Customer customer);
	public List<Customer> viewAllCustomers() throws BusinessException;
	public Customer viewCustomerByCustomerName();
	public boolean newCustomerValidation(int credit_score, double balance);
	public ResultSet viewTransactionsByAccountNumber(int account_number);
}
