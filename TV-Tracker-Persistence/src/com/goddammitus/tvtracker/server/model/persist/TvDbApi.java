package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import com.omertron.thetvdbapi.TheTVDBApi;
import com.omertron.thetvdbapi.model.Series;

public class TvDbApi implements IApi {
	private final TheTVDBApi tvdb;

	public TvDbApi(String api_key) {
		System.out.println("The api key as seen by the API implementation is: " + api_key);
		tvdb = new TheTVDBApi(api_key);
	}

	@Override
	public ArrayList<Series> searchSeries(String query) {
		System.out.println("the qurey for teh api implementation is: " + query);
		List<Series> results = tvdb.searchSeries(query, "en");
		return (ArrayList<Series>) results;
	}
}
