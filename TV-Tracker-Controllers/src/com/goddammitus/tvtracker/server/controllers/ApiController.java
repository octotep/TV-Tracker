package com.goddammitus.tvtracker.server.controllers;

import java.util.ArrayList;
import java.util.List;

import com.goddammitus.tvtracker.server.model.persist.ApiProvider;
import com.omertron.thetvdbapi.model.Series;

public class ApiController {
	public ArrayList<Series> searchSeries(String query) {
		System.out.println("the controllers query is: " + query);
		return (ArrayList<Series>) ApiProvider.getInstance().searchSeries(query);
	}
}
