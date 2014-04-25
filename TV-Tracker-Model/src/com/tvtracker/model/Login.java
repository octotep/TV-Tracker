package com.tvtracker.model;

import java.io.Serializable;

/*
 * constructor
 */
public class Login implements Serializable{
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	/*
	 * set username for use by login service
	 */
	public void  setUsername(String username) {
		this.username = username;
	}
	
	/*
	 * set password for use by login service
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * returns the username
	 */
	public String getUsername() {
		return username;
	}
	
	/*
	 * returns the password
	 */
	public String getPassword() {
		return password;
	}
}
