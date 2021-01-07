package com.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;


public class bankMain {

	private static Logger log = Logger.getLogger(bankMain.class);
	
	public static void main(String[] args) {
	
		bankMainFunctions logInMenu = new bankMainFunctions();

		int choice = logInMenu.logInMenu();
		
		if(choice==1) {
			bankMainFunctions logInAsEmployee = new bankMainFunctions();
			logInAsEmployee.LogInEmployee();
		}
		if(choice==2){
			bankMainFunctions logInAsCustomer = new bankMainFunctions();
			logInAsCustomer.LogInAsCustomer();
		}
		
		
	
	}
}