package com.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.EmployeeDAO;
import com.bank.dao.impl.EmployeeDAOImpl;
import com.bank.dao.impl.LoginDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Employee;
import com.bank.model.Login;

	public class bankMainFunctions {
		private static Logger log = Logger.getLogger(bankMainFunctions.class);
		
		int logInMenu() {
			Scanner sc = new Scanner (System.in);
			
			log.info("Welcome to Jason's Bank app V1.0");
			int ch = 0;
			
			do {
				
				log.info("Log In Menu");
				log.info("---------------------------------------");
				log.info(System.lineSeparator());
				log.info("1) Log in as Employee");
				log.info("2) Log in as Customer");
				log.info("3) Exit bank app");
				try {
					ch= Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {}
				
				if(ch >=1 && ch <4)
					return ch;
				else {
					log.info("Invalid menu choice please try again.");
					log.info("");
				}
			}while(true);
		
		}
		
		boolean LogInAsCustomer(){
			boolean valid= false;
			LoginDAOImpl loginDAO = new LoginDAOImpl();
			String username, password;
			Scanner scan = new Scanner(System.in);
			log.info("Please enter your username:");
			username = scan.nextLine();
			log.info("Please enter your password:");
			password = scan.nextLine();
			try {
				Login login = loginDAO.credentialVerification(username,password);
				if(login !=null) {
					log.info("Successfully Logged In As Customer! ");
					log.info("");
					log.info("Your user ID is: "+ login.getUser_id());
					valid = true;
				}
			}catch(BusinessException e) {
				log.info(e);
			}
			return valid;
		}
		
		boolean LogInEmployee(){
			boolean valid= false;
			
			
			EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
			int user_id,account_number;
			Scanner scan = new Scanner(System.in);
			log.info("Please enter your user ID:");
			user_id = scan.nextInt();
			log.info("Please enter your account_number:");
			account_number = scan.nextInt();
			try {
				Employee employee = employeeDAO.employeeLogin(user_id, account_number);
				if(employee !=null) {
					log.info("Successfully Logged In As Employee! ");
					log.info("");
					log.info("Your user ID is: "+ employee.getEmployee_id());
					log.info("");
					valid = true;
				}
			}catch(BusinessException e) {
				log.info(e);
			}
			return valid;
		}
		
		
		
}
