package com.goddammitus.tvtracker.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.tvtracker.model.Login;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TV_Tracker implements EntryPoint {
	private static IsWidget currentView;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		LoginView view = new LoginView();
		setView(view);
	}
	
	public static void setView(IsWidget view) {
		if (currentView != null) {
			RootLayoutPanel.get().remove(currentView);
		}
		
		RootLayoutPanel.get().add(view);
		RootLayoutPanel.get().setWidgetLeftWidth(view, 0.0, Unit.PX, 1000.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopHeight(view, 0.0, Unit.PX, 400.0, Unit.PX);

		currentView = view;
	}
}
