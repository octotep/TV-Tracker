package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;

public interface LoginServiceAsync {

	void login(Login login,
			AsyncCallback<Account> callback);
}
