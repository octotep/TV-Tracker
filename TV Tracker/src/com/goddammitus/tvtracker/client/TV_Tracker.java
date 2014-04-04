package com.goddammitus.tvtracker.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.tvtracker.model.Account;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TV_Tracker implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Account model = new Account();
		LoginView view = new LoginView();
		view.setModel(model);

		RootLayoutPanel.get().add(view);
		RootLayoutPanel.get().setWidgetLeftWidth(view, 10.0, Unit.PX, 500.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopHeight(view, 10.0, Unit.PX, 400.0, Unit.PX);
	}
}
