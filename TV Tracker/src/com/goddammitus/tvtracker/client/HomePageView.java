package com.goddammitus.tvtracker.client;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.omertron.thetvdbapi.model.Series;
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
	private Account user;
	private String query;
	TextBox textSeriesQuery;

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
		panel.setWidgetLeftWidth(flexTable, 19.0, Unit.PX, 100.0, Unit.PX);
		panel.setWidgetTopHeight(flexTable, 38.0, Unit.PX, 100.0, Unit.PX);

		flexTable.setText(0, 0, user.getMediaListProgress().getMedia(0).getName());
		flexTable.setText(0, 1, user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(0)).getCurrentSeason().toString());
		flexTable.setText(0, 2, user.getMediaListProgress().currentProgress(user.getMediaListProgress().getMedia(0)).getCurrentSeason().toString());

		Label lblSearchSeries = new Label("Search Series:");
		panel.add(lblSearchSeries);
		panel.setWidgetLeftWidth(lblSearchSeries, 58.0, Unit.PX, 110.0, Unit.PX);
		panel.setWidgetTopHeight(lblSearchSeries, 61.0, Unit.PX, 15.0, Unit.PX);

		textSeriesQuery = new TextBox();
		panel.add(textSeriesQuery);
		panel.setWidgetLeftWidth(textSeriesQuery, 154.0, Unit.PX, 159.0, Unit.PX);
		panel.setWidgetTopHeight(textSeriesQuery, 55.0, Unit.PX, 31.0, Unit.PX);

		Button btnSearch = new Button("Search");
		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleSearch();
			}
		});
		panel.add(btnSearch);
		panel.setWidgetLeftWidth(btnSearch, 325.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnSearch, 59.0, Unit.PX, 27.0, Unit.PX);
	}

	public void handleSearch() {
		updateSearch();

		RPC.searchService.seriesSearch(query, new AsyncCallback<ArrayList<Series>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO do something with error
				System.out.println("RPC search series call failed with query: \"" + query + "\"");
			}

			@Override
			public void onSuccess(ArrayList<Series> results) {
				TV_Tracker.setView(new SearchResultsView(user, results));
			}


		});
	}

	public void updateSearch() {
		query = textSeriesQuery.getText();
	}
}
