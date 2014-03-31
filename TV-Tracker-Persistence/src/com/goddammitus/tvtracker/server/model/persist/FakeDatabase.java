package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import com.tvtracker.model.Account;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	private Account dummyAccount(Austin, 12345);
	
	public FakeDatabase() {
		this.accountList = new ArrayList<Account>();
		// TODO: add sample accounts
		accountList.add(new Account());
	}

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
