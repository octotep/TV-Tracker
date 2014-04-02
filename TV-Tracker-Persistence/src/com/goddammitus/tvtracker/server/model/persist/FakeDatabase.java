package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import com.tvtracker.model.Account;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	private Account dummyAccount;

	public FakeDatabase() {
		this.accountList = new ArrayList<Account>();
		// TODO: add sample accounts
		dummyAccount =  new Account("Austin", "12345");
		accountList.add(dummyAccount);
	}

	@Override
	public Account login(String username, String password) {
		//TODO: search accountList for matching username and password
		return null;
	}

}
