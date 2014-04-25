package com.goddammitus.tvtracker.server.model.persist;

import java.util.List;

import com.omertron.thetvdbapi.model.Series;

public interface IApi {
	public List<Series> searchSeries(String query);
}
