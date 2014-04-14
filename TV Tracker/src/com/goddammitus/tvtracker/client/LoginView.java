package com.goddammitus.tvtracker.client;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class LoginView extends Composite implements IsWidget {
	private Login model;
	private Account user;
	private TextBox txtUsername;
	private TextBox txtPassword;

	public LoginView() {
		this.user = new Account();

		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);

		Label lblLoginPage = new Label("Login Page:");
		panel.add(lblLoginPage);
		panel.setWidgetLeftWidth(lblLoginPage, 157.0, Unit.PX, 61.0, Unit.PX);
		panel.setWidgetTopHeight(lblLoginPage, 39.0, Unit.PX, 15.0, Unit.PX);

		txtUsername = new TextBox();
		txtUsername.setWidth("114px");
		panel.add(txtUsername);
		panel.setWidgetLeftWidth(txtUsername, 123.0, Unit.PX, 124.0, Unit.PX);
		panel.setWidgetTopHeight(txtUsername, 87.0, Unit.PX, 31.0, Unit.PX);

		txtPassword = new TextBox();
		txtPassword.setWidth("114px");
		panel.add(txtPassword);
		panel.setWidgetLeftWidth(txtPassword, 123.0, Unit.PX, 124.0, Unit.PX);
		panel.setWidgetTopHeight(txtPassword, 142.0, Unit.PX, 31.0, Unit.PX);

		Label lblPassword = new Label("Password:");
		panel.add(lblPassword);
		panel.setWidgetLeftWidth(lblPassword, 29.0, Unit.PX, 73.0, Unit.PX);
		panel.setWidgetTopHeight(lblPassword, 143.0, Unit.PX, 15.0, Unit.PX);

		Label lblUsername = new Label("Username:");
		panel.add(lblUsername);
		panel.setWidgetLeftWidth(lblUsername, 29.0, Unit.PX, 73.0, Unit.PX);
		panel.setWidgetTopHeight(lblUsername, 87.0, Unit.PX, 15.0, Unit.PX);

		Button btnLogin = new Button("Login");
		btnLogin.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleLogin();
			}
		});
		panel.add(btnLogin);
		panel.setWidgetLeftWidth(btnLogin, 139.0, Unit.PX, 89.0, Unit.PX);
		panel.setWidgetTopHeight(btnLogin, 200.0, Unit.PX, 27.0, Unit.PX);
	}

	public void handleLogin() {
		updateModel();

		RPC.loginService.login(model, new AsyncCallback<Account>() {
		    @Override
		    public void onSuccess(Account result) {
		    	if (result == null) {
		    		// TODO: display error (unknown user/password)
		    	} else {
		    		user = result;
		    		
		    		// Switch to next view
		    		TV_Tracker.setView(new HomePageView(user));
		    		//TV_Tracker.setView(new ExampleView());
		    	}
		        
		    }

		    @Override
		    public void onFailure(Throwable caught) {
		    	// TODO: display error
		        //errorInlineLabel.setText("Error adding");
		    }
		});
	}

	public void setModel(Login model) {
		this.model = model;
	}

	public void updateModel() {
		model.setUsername(txtUsername.getText());
		model.setPassword(txtPassword.getText());
	}
}
