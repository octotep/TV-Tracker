package com.goddammitus.tvtracker.server;

import com.goddammitus.tvtracker.client.LoginService;
import com.goddammitus.tvtracker.server.controllers.LoginController;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	private static final long serialVersionUID = 1L;

	@Override
	public Account login(Login login) {
		LoginController controller = new LoginController();
		Account acct = controller.login(login.getUsername(), login.getPassword());

		System.out.println("Login " + ((acct != null) ? "succeeded" : "failed"));

		return acct;
	}
}
