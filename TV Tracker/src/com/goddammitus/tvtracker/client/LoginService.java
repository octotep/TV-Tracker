package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.tvtracker.model.Account;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	public Account login(String username, String password);
}
