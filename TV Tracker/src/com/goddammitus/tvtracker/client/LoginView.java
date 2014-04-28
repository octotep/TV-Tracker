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
import com.google.gwt.user.client.ui.PasswordTextBox;

public class LoginView extends Composite implements IsWidget {
	private Account user;
	private TextBox txtUsername;
	private PasswordTextBox txtPassword;
	private Label lblLoginFailed;

	public LoginView() {
		this.user = new Account();

		LayoutPanel panel = new LayoutPanel();
		panel.setStyleName("root");
		initWidget(panel);

		Label lblLoginPage = new Label("Login Page:");
		panel.add(lblLoginPage);
		panel.setWidgetLeftWidth(lblLoginPage, 156.0, Unit.PX, 61.0, Unit.PX);
		panel.setWidgetTopHeight(lblLoginPage, 40.0, Unit.PX, 15.0, Unit.PX);

		txtUsername = new TextBox();
		txtUsername.setWidth("114px");
		panel.add(txtUsername);
		panel.setWidgetLeftWidth(txtUsername, 123.0, Unit.PX, 124.0, Unit.PX);
		panel.setWidgetTopHeight(txtUsername, 87.0, Unit.PX, 31.0, Unit.PX);

		Label lblPassword = new Label("Password:");
		panel.add(lblPassword);
		panel.setWidgetLeftWidth(lblPassword, 29.0, Unit.PX, 73.0, Unit.PX);
		panel.setWidgetTopHeight(lblPassword, 143.0, Unit.PX, 15.0, Unit.PX);

		Label lblUsername = new Label("Username:");
		panel.add(lblUsername);
		panel.setWidgetLeftWidth(lblUsername, 29.0, Unit.PX, 73.0, Unit.PX);
		panel.setWidgetTopHeight(lblUsername, 87.0, Unit.PX, 15.0, Unit.PX);
		
		txtPassword = new PasswordTextBox();
		txtPassword.setWidth("114px");
		panel.add(txtPassword);
		panel.setWidgetLeftWidth(txtPassword, 123.0, Unit.PX, 124.0, Unit.PX);
		panel.setWidgetTopHeight(txtPassword, 143.0, Unit.PX, 31.0, Unit.PX);

		Button btnLogin = new Button("Login");
		btnLogin.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				lblLoginFailed.setText("");
				handleLogin();
			}
		});
		panel.add(btnLogin);
		panel.setWidgetLeftWidth(btnLogin, 123.0, Unit.PX, 94.0, Unit.PX);
		panel.setWidgetTopHeight(btnLogin, 205.0, Unit.PX, 27.0, Unit.PX);
		
		lblLoginFailed = new Label("");
		panel.add(lblLoginFailed);
		panel.setWidgetLeftWidth(lblLoginFailed, 260.0, Unit.PX, 73.0, Unit.PX);
		panel.setWidgetTopHeight(lblLoginFailed, 200.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblNoAccount = new Label("No Account?");
		panel.add(lblNoAccount);
		panel.setWidgetLeftWidth(lblNoAccount, 29.0, Unit.PX, 89.0, Unit.PX);
		panel.setWidgetTopHeight(lblNoAccount, 258.0, Unit.PX, 18.0, Unit.PX);
		
		Button btnSignUp = new Button("Sign Up");
		btnSignUp.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleAccountCreate();
			}
		});
		panel.add(btnSignUp);
		panel.setWidgetLeftWidth(btnSignUp, 123.0, Unit.PX, 94.0, Unit.PX);
		panel.setWidgetTopHeight(btnSignUp, 246.0, Unit.PX, 30.0, Unit.PX);
	}

	public void handleLogin() {
		updateModel();

		RPC.loginService.login(Session.getInstance().getLogin(), new AsyncCallback<Account>() {
		    @Override
		    public void onSuccess(Account result) {
		    	if (result == null) {
		    		// TODO: display error (unknown user/password)
		    		lblLoginFailed.setText("Login failed!");
		    	} else {
		    		user = result;
		    		
		    		// Switch to next view
		    		TV_Tracker.setView(new HomePageView(user));
		    	}
		        
		    }

		    @Override
		    public void onFailure(Throwable caught) {
		    	// TODO: display error
		        //errorInlineLabel.setText("Error adding");
		    }
		});
	}
	
	public void handleAccountCreate() {
		AccountCreateView view = new AccountCreateView();
		TV_Tracker.setView(view);
	}

	public void updateModel() {
		Login model = new Login();
		Session.getInstance().setLogin(model);
		model.setUsername(txtUsername.getText());
		model.setPassword(txtPassword.getText());
	}
}
