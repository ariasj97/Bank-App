package com.bank.service.impl;

import java.util.List;

import com.bank.dao.CustomerDAO;
import com.bank.dao.impl.CustomerDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Override
	public List<Customer> viewAllCustomers() throws BusinessException {
			List<Customer> allCustomersList = null;
			allCustomersList = customerDAO.viewAllCustomers();
			return allCustomersList;
	}

	@Override
	public List<Customer> viewCustomerByCustomerName(String name) throws BusinessException {
		List<Customer> getCustomersName = null;
		if(name.length()>=0 && name.length()<25) {
			getCustomersName = customerDAO.viewCustomerByCustomerName(name);
		}else {
			throw new BusinessException("Entered name "+ name+" is invalid");
		}
		
		return getCustomersName;
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
