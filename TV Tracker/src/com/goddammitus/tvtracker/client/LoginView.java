package com.goddammitus.tvtracker.client;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.tvtracker.model.Account;

public class LoginView extends Composite implements IsWidget {
	private Account model;

	public LoginView() {

	}

	public void setModel(Account model) {
		this.model = model;
	}
}
