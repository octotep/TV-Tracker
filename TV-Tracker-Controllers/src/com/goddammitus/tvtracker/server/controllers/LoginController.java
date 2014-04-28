package com.goddammitus.tvtracker.server.controllers;

import com.goddammitus.tvtracker.server.model.persist.DatabaseProvider;
import com.tvtracker.model.Account;

public class LoginController {
	public Account login(String username, String password) {
		return DatabaseProvider.getInstance().login(username, password);
	}
	
	public boolean checkIfAccountExists(String username) {
		return DatabaseProvider.getInstance().checkIfAccountExists(username);
	}
}
