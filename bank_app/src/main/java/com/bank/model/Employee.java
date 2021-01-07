package com.bank.model;

public class Employee {
	
	private int employee_id;
	private int account_number;
	
	public Employee() {
		
	}
	
	public Employee(int employee_id,int account_number) {
		super();
		this.account_number = account_number;
		this.employee_id = employee_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", account_number=" + account_number + "]";
	}
	
	
}
