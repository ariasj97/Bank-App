package com.bank.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Employee;
import com.bank.model.Login;
import com.bank.model.Transaction;
import com.bank.model.Customer;

public interface EmployeeDAO {
	
	public Employee employeeLogin(int user_id, int account_number)throws BusinessException;
	public int newCustomer(Customer customer)throws BusinessException;
	public void newCustomerValidation(int credit_score);
}
