package com.goddammitus.tvtracker.server.model.persist;

import com.tvtracker.model.Account;

public interface IDatabase {
	public Account login(String username, String password);

	public boolean checkIfAccountExists(String username);
}
