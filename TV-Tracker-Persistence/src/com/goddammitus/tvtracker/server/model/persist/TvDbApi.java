package com.goddammitus.tvtracker.server.model.persist;

import java.util.List;

import com.omertron.thetvdbapi.TheTVDBApi;
import com.omertron.thetvdbapi.model.Series;

public class TvDbApi implements IApi {
	private final TheTVDBApi tvdb;

	public TvDbApi(String api_key) {
		 tvdb = new TheTVDBApi(api_key);
	}

	@Override
	public List<Series> searchSeries(String query) {
		List<Series> results = tvdb.searchSeries(query, "en");
		return results;
	}
}
