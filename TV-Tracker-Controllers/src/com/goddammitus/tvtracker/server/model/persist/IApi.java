package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import com.omertron.thetvdbapi.model.Series;

public interface IApi {
	public ArrayList<Series> searchSeries(String query);
}
