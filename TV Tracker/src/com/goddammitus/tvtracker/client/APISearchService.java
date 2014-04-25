package com.goddammitus.tvtracker.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.omertron.thetvdbapi.model.Series;

@RemoteServiceRelativePath("search")
public interface APISearchService extends RemoteService {
	public List<Series> seriesSearch(String series);
}
