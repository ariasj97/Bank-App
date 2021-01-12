package com.bank.model;

public class Login {
	private int user_id;
	private String username;
	private String password;
	
	
	public Login(int user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		
	}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}
	
	public Login() {
		
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Login [User_id=" + user_id + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
