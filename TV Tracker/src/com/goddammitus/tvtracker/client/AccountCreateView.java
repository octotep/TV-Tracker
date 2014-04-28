package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class AccountCreateView extends Composite implements IsWidget{
	
	public AccountCreateView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		Label lblCreateAnAccount = new Label("Create An Account");
		panel.add(lblCreateAnAccount);
		panel.setWidgetLeftWidth(lblCreateAnAccount, 160.0, Unit.PX, 119.0, Unit.PX);
		panel.setWidgetTopHeight(lblCreateAnAccount, 21.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCreateUsername = new Label("Create Username:");
		panel.add(lblCreateUsername);
		panel.setWidgetLeftWidth(lblCreateUsername, 35.0, Unit.PX, 112.0, Unit.PX);
		panel.setWidgetTopHeight(lblCreateUsername, 87.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCreatePassword = new Label("Create Password:");
		panel.add(lblCreatePassword);
		panel.setWidgetLeftWidth(lblCreatePassword, 35.0, Unit.PX, 112.0, Unit.PX);
		panel.setWidgetTopHeight(lblCreatePassword, 146.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox txtboxCreateUsername = new TextBox();
		panel.add(txtboxCreateUsername);
		panel.setWidgetLeftWidth(txtboxCreateUsername, 160.0, Unit.PX, 173.0, Unit.PX);
		panel.setWidgetTopHeight(txtboxCreateUsername, 81.0, Unit.PX, 34.0, Unit.PX);
		
		TextBox txtboxCreatePassword = new PasswordTextBox();
		panel.add(txtboxCreatePassword);
		panel.setWidgetLeftWidth(txtboxCreatePassword, 160.0, Unit.PX, 173.0, Unit.PX);
		panel.setWidgetTopHeight(txtboxCreatePassword, 140.0, Unit.PX, 34.0, Unit.PX);
		
		Button btnSubmit = new Button("Submit");
		panel.add(btnSubmit);
		panel.setWidgetLeftWidth(btnSubmit, 160.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnSubmit, 208.0, Unit.PX, 30.0, Unit.PX);
	}
}
