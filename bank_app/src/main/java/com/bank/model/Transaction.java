package com.bank.model;

import java.util.Date;

public class Transaction {

	private String transaction_type;
	private double amount;
	private int account_number;
	private Date date;
	
	public Transaction() {
		
	}
	public Transaction(String transaction_type,double amount,int account_number,Date date) {
		super();
		this.transaction_type = transaction_type;
		this.amount =amount;
		this.account_number = account_number;
		this.date = date;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [transaction_type=" + transaction_type + ", amount=" + amount + ", account_number="
				+ account_number + ", date=" + date + "]";
	}
	
}
