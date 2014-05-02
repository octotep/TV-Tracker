package com.goddammitus.tvtracker.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.omertron.thetvdbapi.model.Series;

public interface APISearchServiceAsync {
	void seriesSearch(String series, AsyncCallback<ArrayList<Series>> callback);
}
