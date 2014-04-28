package com.goddammitus.tvtracker.client;

import com.tvtracker.model.Login;

public class Session {
	private static Session theInstance = new Session();
	
	public static Session getInstance() {
		return theInstance;
	}
	
	// Call this to clear the current contents (aka logout)
	public static void clear() {
		theInstance = new Session();
	}
	
	private Login login;
	// could add other fields...
	
	private Session() {
		
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public Login getLogin() {
		return login;
	}
}
