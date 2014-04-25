package com.goddammitus.tvtracker.server.controllers;

import java.util.List;

import com.goddammitus.tvtracker.server.model.persist.ApiProvider;
import com.omertron.thetvdbapi.model.Series;

public class ApiController {
	public List<Series> searchSeries(String query) {
		return ApiProvider.getInstance().searchSeries(query);
	}
}
