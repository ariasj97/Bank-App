package com.bank.model;

import java.util.Date;

public class Customer {
	private int customer_id;
	private String name;
	private String street_address;
	private Date dob;
	private int credit_score;
	
	public Customer() {
		
	}


	public Customer(int customer_id, String name, String street_address, Date dob, int credit_score) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.street_address = street_address;
		this.dob = dob;
		this.credit_score = credit_score;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStreet_address() {
		return street_address;
	}


	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public int getCredit_score() {
		return credit_score;
	}


	public void setCredit_score(int credit_score) {
		this.credit_score = credit_score;
	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", street_address=" + street_address
				+ ", dob=" + dob + ", credit_score=" + credit_score + "]";
	}
	
}