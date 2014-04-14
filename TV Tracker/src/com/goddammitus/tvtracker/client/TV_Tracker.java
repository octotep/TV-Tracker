package com.goddammitus.tvtracker.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.tvtracker.model.Login;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TV_Tracker implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Login model = new Login();
		LoginView view = new LoginView();
		view.setModel(model);

		RootLayoutPanel.get().add(view);
		RootLayoutPanel.get().setWidgetLeftWidth(view, 0.0, Unit.PX, 450.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopHeight(view, 0.0, Unit.PX, 300.0, Unit.PX);
	}
}
