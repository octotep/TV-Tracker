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

public class HomePageView extends Composite implements IsWidget {
	private Login model;
	private Account user;

	public HomePageView(Account user) {
		this.user = user;

		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		Label lblNewLabel = new Label("Welcome, " + user.getName());
		panel.add(lblNewLabel);
		panel.setWidgetLeftWidth(lblNewLabel, 19.0, Unit.PX, 138.0, Unit.PX);
		panel.setWidgetTopHeight(lblNewLabel, 12.0, Unit.PX, 18.0, Unit.PX);
	}

	public void setModel(Login model) {
		this.model = model;
	}
}
