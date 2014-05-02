package com.goddammitus.tvtracker.server;

import java.util.ArrayList;
import java.util.List;

import com.goddammitus.tvtracker.client.APISearchService;
import com.goddammitus.tvtracker.server.controllers.ApiController;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.omertron.thetvdbapi.model.Series;

public class APISearchServiceImpl extends RemoteServiceServlet implements APISearchService {
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<Series> seriesSearch(String series) {
		System.out.println("The series query is: " + series);
		ApiController controller = new ApiController();
		ArrayList<Series> results = controller.searchSeries(series);

		for (Series found_series : results) {
			System.out.println("Search Result: " + found_series);
		}
		return results;
	}
}
