package com.bank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.EmployeeDAO;
import com.bank.dao.impl.EmployeeDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.model.Login;
import com.bank.model.Transaction;
import com.bank.service.EmployeeService;
import com.bank.service.LoginService;
import com.bank.service.impl.EmployeeServiceImpl;
import com.bank.service.impl.LoginServiceImpl;


public class bankMain {

	private static Logger log = Logger.getLogger(bankMain.class);
	
	public static void main(String[] args) {
	
		bankMainFunctions logInMenu = new bankMainFunctions();

		int choice = logInMenu.logInMenu();
		int employeeChoice= 0;
		int choice2 = 0;
		Scanner sc = new Scanner (System.in);
		
		if(choice==1) {
			bankMainFunctions logInAsEmployee = new bankMainFunctions();
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			
			//loops until a valid user_id and account number is valid
			while(logInAsEmployee.LogInEmployee()==false){
				logInAsEmployee.LogInEmployee();
			}
			
			//Employee Menu that loops until a valid input is selected
			EmployeeService employeeService = new EmployeeServiceImpl();
			do {
				log.info("Employee Menu");
				log.info("--------------------------------------------");
				log.info("1)New Customer Menu");
				log.info("2)View all customer details");
				log.info("3)View details by customer name");
				log.info("4)View transactions by account number");
				log.info("5)Exit");
				try {
					employeeChoice = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {}
				
				//New Customer Menu
				switch(employeeChoice) {
				case 1:
					
					do {
						log.info("New Customer Menu");
						log.info("--------------------------------------------");
						log.info("1)Validate A New Customer");
						log.info("2)Register a new Customer's username and password");
						log.info("3)Register a new Customer's details");
						log.info("4)Exit");
						try {
							choice2 = Integer.parseInt(sc.nextLine());
						}catch(NumberFormatException e) {}
						
						switch(choice2) {
						case 1:
							
							//Validation for new Customers
							log.info("validation under construction");
							break;
						case 2:
							
							//New Customer Username and password
							LoginService loginService = new LoginServiceImpl();
							log.info("Enter the new Customer's Details");
							log.info("User ID: ");
							int cUserId = Integer.parseInt(sc.nextLine());
							
							log.info("Username: ");
							String username =sc.nextLine();

							log.info("Password: ");
							String password=sc.nextLine();
							
							Login login = new Login(cUserId, username, password);
							try {
								int valid2 =loginService.newCredentials(login);
								if (valid2!=0) {
									log.info("New Customer added to the database");
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
							
						case 3:
							
							//New Customer Details
							log.info("Enter the new Customer's Details");
							log.info("User Id: ");
							int user_id =Integer.parseInt(sc.nextLine());

							log.info("Name: ");
							String newName=sc.nextLine();
							
							log.info("Street Adress: ");
							String street_address=sc.nextLine();
							
							log.info("Credit Score: ");
							int credit_score = Integer.parseInt(sc.nextLine());

							log.info("Date of Birth: ");
							String dob = sc.nextLine();
							
							SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
							Date dob2 =null;
							sdf.setLenient(false);
							try {
								dob2=sdf.parse(dob);
							}catch(ParseException e1) {
								log.info("Invalid date format");
							}
								
							Customer customer = new Customer(user_id, newName, street_address, dob2, credit_score);
							try {
								int valid =employeeService.newCustomer(customer);
								if (valid!=0) {
									log.info("New Customer added to the database");
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
						case 4:
							
							//Exit menu
							log.info("Exiting New Cusomter Menu......Returning to Employee Menu.");
							break;
							
						default:
							log.info("Invalid menu option. Input a valid menu choice.");
						}
					}while(choice2!=4);
					break;
				
				//Get all customers in the database
				case 2:
					log.info("Retrieving all customer details in the database");
					try {
						List<Customer> allCustomersList = employeeService.viewAllCustomers();
						if(allCustomersList!=null && allCustomersList.size()>0) {
							log.info("There are "+ allCustomersList.size()+" cutomers in this database. Printing thier information now.");
							for(Customer c:allCustomersList) {
								log.info(c);
							}
							
						}
					}catch(BusinessException e) {
						log.info(e.getMessage());
					}
					break;
				
				//Get Customer by Name
				case 3:
					log.info("Enter the name you wish to see the details of: ");
					try {
						String name = sc.nextLine();
						List<Customer> getCustomersName = employeeService.viewCustomerByCustomerName(name);
						if(getCustomersName!=null && getCustomersName.size()>0) {
							log.info("Found "+getCustomersName.size()+" customers in this database. Printing their details now.");
							for(Customer c:getCustomersName) {
								log.info(c);
							}
						}
					} catch (BusinessException e) {
						log.info(e.getMessage());
					}
					break;
				
				//Get Transactions by account number
				case 4:
					log.info("Enter a valid account number to get all their transactions: ");
					try {
						int account_number = Integer.parseInt(sc.nextLine());
						List<Transaction> getTransaction = employeeService.viewTransactionsByAccountNumber(account_number);
						if(getTransaction!=null && getTransaction.size()>0) {
							log.info("There are "+getTransaction.size()+" transactions with this account nummber in the database. Printing their details now.");
							for(Transaction t:getTransaction) {
								log.info(t);
							}
					}
					}catch(NumberFormatException e) {
					log.info("Account number cannot include special character, symbols, or white spaces");
					
					} catch (BusinessException e) {
					log.info(e.getMessage());
					}
					break;
					
				//Exit Employee Menu
				case 5:
					log.info("Exiting....Thank you for using jason's banking app.");
					break;
				default:
					log.info("Invalid menu option. Input a valid menu choice.");
					
				}
				
			}while(employeeChoice !=5);
			
		
	
		if(choice==2){
			bankMainFunctions logInAsCustomer = new bankMainFunctions();
			while(logInAsCustomer.LogInAsCustomer()==false){
				logInAsEmployee.LogInAsCustomer();
			}
			}
		
		
	
		}
	}
}