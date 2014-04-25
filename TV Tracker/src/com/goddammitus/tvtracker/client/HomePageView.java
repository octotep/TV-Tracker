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
		panel.add(flexTable);
		panel.setWidgetLeftRight(flexTable, 19.0, Unit.PX, 19.0, Unit.PX);
		panel.setWidgetTopHeight(flexTable, 38.0, Unit.PX, 46.0, Unit.PX);
		
		flexTable.setText(0, 0, "Show Name");
		flexTable.setText(0, 1, "Current Season");
		flexTable.setText(0, 2, "Episodes Seen in Current Season");
		
		flexTable.setText(1, 0, user.getMediaListProgress().getMedia(0).getName());
		flexTable.setText(1, 1, user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(0)).getCurrentSeason().toString());
		flexTable.setText(1, 2, user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(0)).getEpisodesSeen().toString());
	}

	public void setModel(Login model) {
		this.model = model;
	}
}
