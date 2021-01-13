package com.bank.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.service.AccountService;

import com.bank.service.impl.AccountServiceImpl;


class AccountServiceTest {

	private static AccountService app;
	
	@BeforeAll
	public static void setUp() {
		app = new AccountServiceImpl();
	}
	
	@Test 
	public void testViewBalance()throws BusinessException{
		double expected = 7564.42;
		assertEquals(expected, app.viewBalance(100000002));
	}
	
	@Test 
	public void testWithdraw()throws BusinessException{
		double amount = 17.75;
		int account_number = 100000001;
		assertEquals(1, app.Withdraw(amount,account_number));
	}
	
	@Test 
	public void testDeposit()throws BusinessException{
		double amount = 17.75;
		int account_number = 100000001;
		assertEquals(1, app.Deposit(amount,account_number));
	}
	
	@Test 
	public void testTransferFunds()throws BusinessException{
		double amount = 25.00;
		int account_number1 = 100000001;
		int account_number2 = 100000000;
		assertEquals(1, app.transferFunds(amount,account_number1,account_number2));
	}
	
	@Test void testGetBalance(){
		Account account = new Account();
		account.setBalance(123.45);
	
		
		assertEquals(123.45,account.getBalance());
	}
	
	
}
