package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import com.tvtracker.model.Account;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	
	public FakeDatabase() {
		this.accountList = new ArrayList<Account>();
		// TODO: add sample accounts
	}

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
