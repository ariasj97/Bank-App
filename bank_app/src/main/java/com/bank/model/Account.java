package com.bank.model;

public class Account {

	private int user_id;
	private double balance;
	private String account_type;
	private int account_number;
	
	public Account() {
		
	}
	public Account (int user_id, double balance, String account_type,int account_number) {
		super();
		this.user_id = user_id;
		this.balance = balance;
		this.account_type = account_type;
		this.account_number = account_number;
	}
	
	public Account (int user_id, double balance, String account_type) {
		super();
		this.user_id = user_id;
		this.balance = balance;
		this.account_type = account_type;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	@Override
	public String toString() {
		return "Account [user_id=" + user_id + ", balance=" + balance + ", account_type=" + account_type
				+ ", account_number=" + account_number + "]";
	}
	
}
