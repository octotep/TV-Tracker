package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import com.tvtracker.model.Account;

public class FakeDatabase implements IDatabase {
	private List<Account> accountList;
	
	public FakeDatabase() {
		this.accountList = new ArrayList<Account>();
		// TODO: add sample accounts
		accountList.add(new Account("Austin", "12345"));
	}

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		for(Account account:accountList){
            if(account!=null)
                if(account.getName().equals(username))
                	if(account.getPassword().equals(password))
                		return account;
        }
		return null;
	}
	
}
