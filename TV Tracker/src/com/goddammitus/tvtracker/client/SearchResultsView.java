package com.goddammitus.tvtracker.client;

import java.util.List;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.omertron.thetvdbapi.model.Series;
import com.tvtracker.model.Account;

public class SearchResultsView extends Composite implements IsWidget {
	private Account user;
	private List<Series> results;

	public SearchResultsView(Account user, List<Series> results) {
		this.user = user;
		this.results = results;
	}



}
