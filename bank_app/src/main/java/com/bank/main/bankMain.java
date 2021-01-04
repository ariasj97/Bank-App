package com.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class bankMain {

	private static Logger log = Logger.getLogger(bankMain.class);
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		log.info("Welcome to Jason's Bank app V1.0");
		int ch = 0;
		
		do {
			
			log.info("Log In Menu");
			log.info("---------------------------------------");
			log.info(System.lineSeparator());
			log.info("1) Log in as Customer");
			log.info("2) Log in as Employee");
			log.info("3) Exit bank app");
			try {
				ch= Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {}
			
			switch(ch){
			case 1:
				log.info("Welcome to the customer menu");
				break;
			case 2:
				log.info("Welcome to the employee menu");
				break;
			case 3:
				log.info("Thank you for banking with us. Have a good day.");
				break;
			default:
				log.info("Invalid Log In option. Please enter a valid Log In option.");
				

			
			}
		}while(ch!=3);
		

	}
}