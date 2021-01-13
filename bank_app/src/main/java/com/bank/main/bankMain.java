package com.bank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.AccountDAO;
import com.bank.dao.CustomerDAO;
import com.bank.dao.TransactionDAO;
import com.bank.dao.impl.AccountDAOImpl;
import com.bank.dao.impl.CustomerDAOImpl;
import com.bank.dao.impl.TransactionDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.model.Login;
import com.bank.model.Transaction;
import com.bank.service.AccountService;
import com.bank.service.EmployeeService;
import com.bank.service.LoginService;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.service.impl.EmployeeServiceImpl;
import com.bank.service.impl.LoginServiceImpl;



public class bankMain {

	private static Logger log = Logger.getLogger(bankMain.class);
	
	public static void main(String[] args) {
	
		bankMainFunctions logInMenu = new bankMainFunctions();

		int choice = logInMenu.logInMenu();
		int employeeChoice= 0;
		int employeeChoice2 = 0;
		int custChoice = 0;
		int custChoice2 = 0;
		
		bankMainFunctions logInAsEmployee = new bankMainFunctions();
		TransactionDAO transactionService = new TransactionDAOImpl();
		CustomerDAO customerService = new CustomerDAOImpl();
		AccountService accountService = new AccountServiceImpl();
		
		Scanner sc = new Scanner (System.in);
		
		if(choice==1) {
			
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
						log.info("");
						log.info("New Customer Menu");
						log.info("--------------------------------------------");
						log.info("1)Validate A New Customer");
						log.info("2)Register a new Customer's username and password");
						log.info("3)Register a new Customer's details");
						log.info("4)Exit");
						try {
							employeeChoice2 = Integer.parseInt(sc.nextLine());
						}catch(NumberFormatException e) {}
						
						switch(employeeChoice2) {
						case 1:
							//Customer validation
							log.info("Please enter the potential customer's credit score");
							int nCredit_score =Integer.parseInt(sc.nextLine());
							
							try {
								employeeService.newCustomerValidation(nCredit_score);
							} catch (BusinessException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							break;
						case 2:
							
							//New Customer Username and password
							LoginService loginService = new LoginServiceImpl();
							log.info("Enter the new Customer's Details");
		
							
							log.info("Username: ");
							String username =sc.nextLine();

							log.info("Password: ");
							String password=sc.nextLine();
							
							Login login = new Login(username, password);
							try {
								int valid2 =loginService.newCredentials(login);
								if (valid2!=0) {
									log.info("New Customer added to the database");
									log.info("");
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

							log.info("Date of Birth (format:MM-dd-yyyy): ");
							String dob = sc.nextLine();
							
							SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
							Date dob2 =null;
							sdf.setLenient(false);
							try {
								dob2=sdf.parse(dob);
							}catch(ParseException e1) {
								log.info("Invalid date format");
								log.info("");
							}
								
							Customer customer = new Customer(user_id, newName, street_address, dob2, credit_score);
							try {
								int valid =employeeService.newCustomer(customer);
								if (valid!=0) {
									log.info("New Customer added to the database");
									log.info("");
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
						case 4:
							
							//Exit menu
							log.info("Exiting New Cusomter Menu......Returning to Employee Menu.");
							log.info("");
							break;
							
						default:
							log.info("Invalid menu option. Input a valid menu choice.");
							log.info("");
						}
					}while(employeeChoice2!=4);
					break;
				
				//Get all customers in the database
				case 2:
					log.info("Retrieving all customer details in the database");
					log.info("");
					try {
						List<Customer> allCustomersList = customerService.viewAllCustomers();
						if(allCustomersList!=null && allCustomersList.size()>0) {
							log.info("There are "+ allCustomersList.size()+" cutomers in this database. Printing thier information now.");
							for(Customer c:allCustomersList) {
								log.info(c);
							}
							log.info("");
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
						List<Customer> getCustomersName = customerService.viewCustomerByCustomerName(name);
						if(getCustomersName!=null && getCustomersName.size()>0) {
							log.info("Found "+getCustomersName.size()+" customers in this database. Printing their details now.");
							for(Customer c:getCustomersName) {
								log.info(c);
							}
							log.info("");
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
						List<Transaction> getTransaction = transactionService.viewTransactionsByAccountNumber(account_number);
						if(getTransaction!=null && getTransaction.size()>0) {
							log.info("There are "+getTransaction.size()+" transactions with this account nummber in the database. Printing their details now.");
							log.info("");
							for(Transaction t:getTransaction) {
								log.info(t);
							}
							log.info("");
					}
					}catch(NumberFormatException e) {
					log.info("Account number cannot include special character, symbols, or white spaces");
					log.info("");
					
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
					log.info("");
					
				}
				
			}while(employeeChoice !=5);
			
		}
	
		else if(choice==2){
			bankMainFunctions logInAsCustomer = new bankMainFunctions();
			
			while(logInAsCustomer.LogInAsCustomer()==false)
				logInAsCustomer.LogInAsCustomer();
			
			
			do{
				log.info("Customer Menu");
				log.info("--------------------------------------------");
				log.info("1)New Customer Menu");
				log.info("2)View Balance of specified account");
				log.info("3)Withdraw");
				log.info("4)Deposit");
				log.info("5)Transfer Funds");
				log.info("6)View Transactions");
				log.info("7)Exit");
				try {
					custChoice = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {}
				
			switch(custChoice) {
			case 1:
				
				EmployeeService employeeService = new EmployeeServiceImpl();
				//AccountService accountService = new AccountServiceImpl();

				do {
					log.info("");
					log.info("New Customer Menu");
					log.info("--------------------------------------------");
					log.info("1)Register a new Customer's username and password");
					log.info("2)Register a new Customer's details");
					log.info("3)Register a new bank account with balance");
					log.info("4)Exit");
					try {
						custChoice2 = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {}
					
					switch(custChoice2) {
					case 1:
						
						//New Customer Username and password
						LoginService loginService = new LoginServiceImpl();
						log.info("Enter the new Customer's Details");
						log.info("------------------------------------------------");
						log.info("");
						
						log.info("Username: ");
						String username =sc.nextLine();

						log.info("Password: ");
						String password=sc.nextLine();
						
						Login login = new Login(username, password);
						try {
							int valid2 =loginService.newCredentials(login);
							if (valid2!=0) {
								log.info("New Customer added to the database");
								log.info("");
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
						
					case 2:
						
						//New Customer Details
						log.info("Enter the new Customer's Details");
						log.info("------------------------------------------------");
						log.info("");
						log.info("User Id: ");
						int user_id =Integer.parseInt(sc.nextLine());

						log.info("Name: ");
						String newName=sc.nextLine();
						
						log.info("Street Adress: ");
						String street_address=sc.nextLine();
						
						log.info("Credit Score: ");
						int credit_score = Integer.parseInt(sc.nextLine());

						log.info("Date of Birth (format:MM-dd-yyyy): ");
						String dob = sc.nextLine();
						
						SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
						Date dob2 =null;
						sdf.setLenient(false);
						try {
							dob2=sdf.parse(dob);
						}catch(ParseException e1) {
							log.info("Invalid date format");
							log.info("");
						}
							
						Customer customer = new Customer(user_id, newName, street_address, dob2, credit_score);
						try {
							int valid =employeeService.newCustomer(customer);
							if (valid!=0) {
								log.info("New Customer added to the database");
								log.info("");
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
						
					case 3:
						log.info("Please enter new bank account details");
						log.info("------------------------------------------------");
						log.info("");
						log.info("User Id: ");
						int user_id3 =Integer.parseInt(sc.nextLine());
						
						log.info("savings or Checking account: ");
						String account_type = sc.nextLine();
						
						log.info("Starting Balance: ");
						double starting_balance =Double.parseDouble(sc.nextLine());
						
						try {
							int valid =accountService.newAccount(user_id3,starting_balance,account_type);
							if(valid!=0) {
								log.info("New Account added to the database");
								log.info("");
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						break;
					case 4:
						
						//Exit menu
						log.info("Exiting New Cusomter Menu......Returning to Customer Menu.");
						log.info("");
						break;
						
					default:
						log.info("Invalid menu option. Input a valid menu choice.");
						log.info("");
					}
				}while(custChoice2!=4);
				break;
			case 2:
				
				//view the balance of specified account
				log.info("Enter a valid account number to view the balance ");
				try {
					int account_number = Integer.parseInt(sc.nextLine());
					double getBalance = accountService.viewBalance(account_number);
					
					log.info("Printing the balance of "+ account_number+ " now.");
					log.info("Balance: $"+getBalance);
					log.info("");
		
				}catch(NumberFormatException e) {
				log.info("Account number cannot include special character, symbols, or white spaces");
				log.info("");
				
				} catch (BusinessException e) {
				log.info(e.getMessage());
				}
				break;
			case 3:
				
				//withdraw from a specific account
				double balance;
				log.info("4) Enter the account number you wish to withdraw from: ");
				int account_number3 = Integer.parseInt(sc.nextLine());
				
				log.info("4) Enter the amount you wish to withdraw from account number "+ account_number3+":");
				double amount3 =Double.parseDouble(sc.nextLine());
				try {
					balance = accountService.viewBalance(account_number3);
					if (balance<amount3 || amount3<0.00) {
						log.info("Balance cannot be less than amount or the amount cannot be less than 0.00");
						break;
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					int valid = accountService.Withdraw(amount3, account_number3);
					if (valid!=0) {
						log.info("Successfully Withdrew $"+amount3+" from account number: "+account_number3);
						log.info("");
					}
				}catch(BusinessException e) {
					log.info(e.getMessage());
				}
				break;
				
			case 4:
				
				//deposit to specific account number
				log.info("4) Enter the account number you wish to deposit to: ");
				int account_number4 = Integer.parseInt(sc.nextLine());
				
				log.info("4) Enter the amount you wish to deposit to account number "+ account_number4+":");
				double amount4 =Double.parseDouble(sc.nextLine());
				
				if (amount4<0.00) {
					log.info("Amount cannot be less than 0.00");
					break;
				}
				
				try {
					int valid =accountService.Deposit(amount4, account_number4);
					if (valid!=0) {
						log.info("Successfully Deposited $"+amount4+" to account number: "+account_number4);
						log.info("");
					}
				}catch(BusinessException e) {
					log.info(e.getMessage());
				}
				
				break;
				
			case 5:
				
				log.info("4) Enter the account number you wish to tranfer funds to: ");
				int account_number5 = Integer.parseInt(sc.nextLine());
				
				log.info("4) Enter the account number you wish to tranfer funds from: ");
				int account_number51 = Integer.parseInt(sc.nextLine());
				
				log.info("4) Enter the amount you wish to transfer to account number "+ account_number5+":");
				double amount5 =Double.parseDouble(sc.nextLine());
				
				try {
					int valid =accountService.transferFunds(amount5,account_number51,account_number5 );
					if (valid!=0) {
						log.info("Successfully transfered $"+amount5+" to account number: "+account_number5);
						log.info("");
					}
				}catch(BusinessException e) {
					log.info(e.getMessage());
				}
				break;
				
			case 6:
				
				//View Transactions 
				log.info("Enter your account number to get all their transactions: ");
				try {
					int account_number6 = Integer.parseInt(sc.nextLine());
					List<Transaction> getTransaction = transactionService.viewTransactionsByAccountNumber(account_number6);
					if(getTransaction!=null && getTransaction.size()>0) {
						log.info("There are "+getTransaction.size()+" transactions with this account nummber in the database. Printing their details now.");
						log.info("");
						for(Transaction t:getTransaction) {
							log.info(t);
						}
				}
				}catch(NumberFormatException e) {
				log.info("Account number cannot include special character, symbols, or white spaces");
				log.info("");
				
				} catch (BusinessException e) {
				log.info(e.getMessage());
				}
				break;
				
			case 7:
				
				//Exit Menu
				log.info("Exiting....Thank you for using jason's banking app.");
				break;
				
			default:
				
				log.info("Invalid menu option. Input a valid menu choice.");
				log.info("");
				
				}
			
			}while(custChoice!=7);
		
		}
			
		
		else if(choice==3) 
			log.info("Exiting....Thank you for using jason's banking app.");
		
	
		}
	}

