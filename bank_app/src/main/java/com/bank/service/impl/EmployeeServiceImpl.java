package com.bank.service.impl;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.EmployeeDAO;
import com.bank.dao.impl.EmployeeDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.main.bankMain;
import com.bank.model.Customer;
import com.bank.model.Transaction;

import com.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	Scanner sc = new Scanner (System.in);
	
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	

	@Override
	public int newCustomer(Customer customer) throws BusinessException {
		int valid=0;
		try {
			if(employeeDAO.newCustomer(customer) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}

	@Override
	public List<Customer> viewAllCustomers() throws BusinessException {
		List<Customer> allCustomersList = null;
		allCustomersList = employeeDAO.viewAllCustomers();
		return allCustomersList;
	}

	@Override
	public List<Customer> viewCustomerByCustomerName(String name)throws BusinessException {
		List<Customer> getCustomersName = null;
		if(name.length()>=0 && name.length()<25) {
			getCustomersName = employeeDAO.viewCustomerByCustomerName(name);
		}else {
			throw new BusinessException("Entered name "+ name+" is invalid");
		}
		
		return getCustomersName;
	}

	@Override
	public boolean newCustomerValidation(int credit_score, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transaction> viewTransactionsByAccountNumber(int account_number)throws BusinessException {
		List<Transaction> getTransactions = null;
		if(account_number>=999999 && account_number<100000100) {
			getTransactions = employeeDAO.viewTransactionsByAccountNumber(account_number);
		}else {
			throw new BusinessException("Entered account number "+ account_number+" is invalid");
		}
		
		return getTransactions;
	}

	

}
