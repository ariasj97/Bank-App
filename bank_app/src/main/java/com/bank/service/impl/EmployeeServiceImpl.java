package com.bank.service.impl;


import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.EmployeeDAO;
import com.bank.dao.impl.EmployeeDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;


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
	public void newCustomerValidation(int credit_score) throws BusinessException {
		if(credit_score>300 && credit_score <850) {
			employeeDAO.newCustomerValidation(credit_score);
		}else {
			throw new BusinessException("Entered credit score "+ credit_score+ " must be between 300 and 850");
		}
		
	}
	

}
