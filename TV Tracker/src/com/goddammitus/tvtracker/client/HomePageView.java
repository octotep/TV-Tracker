package com.goddammitus.tvtracker.client;
import java_cup.internal_error;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;
import com.tvtracker.model.MediaListProgress;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.FlexTable;

public class HomePageView extends Composite implements IsWidget {
	private Login model;
	private Account user;

	public HomePageView(Account user) {
		this.user = user;
		String welcomeMessage = "Welcome, " + user.getName();

		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);

		Label lblWelcome = new Label(welcomeMessage);
		panel.add(lblWelcome);
		panel.setWidgetLeftWidth(lblWelcome, 19.0, Unit.PX, 250.0, Unit.PX);
		panel.setWidgetTopHeight(lblWelcome, 12.0, Unit.PX, 18.0, Unit.PX);

		FlexTable flexTable = new FlexTable();
		flexTable.setStyleName("td");
		panel.add(flexTable);
		panel.setWidgetLeftRight(flexTable, 19.0, Unit.PX, 19.0, Unit.PX);
		panel.setWidgetTopHeight(flexTable, 38.0, Unit.PX, 145.0, Unit.PX);

		flexTable.setText(0, 0, "Show Name");
		flexTable.setText(0, 1, "Current Season");
		flexTable.setText(0, 2, "Episodes Seen");

		for (int i=0; i < user.getMediaListProgress().getSize(); i++) {
			flexTable.setText(1 + i, 0, user.getMediaListProgress().getMedia(i).getName());
			flexTable.setText(1 + i, 1, user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(i)).getCurrentSeason().toString());
			flexTable.setText(1 + i, 2, user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(i)).getEpisodesSeen().toString() + " / " + user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(i)).getEpisodesInCurrentSeason().toString());
		}

		Button btnLogout = new Button("Logout");
		btnLogout.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleLogout();
			}
		});
		panel.add(btnLogout);
		panel.setWidgetLeftWidth(btnLogout, 369.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnLogout, 2.0, Unit.PX, 30.0, Unit.PX);
	}

	public void handleLogout() {
		Session.clear();
		LoginView view = new LoginView();
		TV_Tracker.setView(view);
	}

	public void setModel(Login model) {
		this.model = model;
	}
}
