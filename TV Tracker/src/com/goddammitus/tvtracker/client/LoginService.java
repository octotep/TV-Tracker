package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	public Account login(Login login);
}
