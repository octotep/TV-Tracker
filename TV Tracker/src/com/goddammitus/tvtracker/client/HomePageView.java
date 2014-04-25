package com.goddammitus.tvtracker.client;
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

		RPC.searchService.seriesSearch(query, new AsyncCallback<List<Series>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				System.out.println("RPC search series call failed with query: \"" + query + "\"");
			}

			@Override
			public void onSuccess(List<Series> results) {
				// TODO Auto-generated method stub
				TV_Tracker.setView(new SearchResultsView(user, results));
			}


		});
	}

	public void updateSearch() {
		query = textSeriesQuery.getText();
	}
}
