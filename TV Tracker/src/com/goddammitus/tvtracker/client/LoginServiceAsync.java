package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tvtracker.model.Account;

public interface LoginServiceAsync {

	void login(String username, String password,
			AsyncCallback<Account> callback);
}
