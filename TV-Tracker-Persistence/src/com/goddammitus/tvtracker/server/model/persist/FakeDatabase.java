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
		accountList.add(dummyAccount);
	}

	@override
	public Account login(String username, String password) {
		//TODO: search accountList for matching username and password
		return null;
	}
	
}
