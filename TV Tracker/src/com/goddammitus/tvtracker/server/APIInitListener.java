package com.goddammitus.tvtracker.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.goddammitus.tvtracker.server.model.persist.ApiProvider;
import com.goddammitus.tvtracker.server.model.persist.TvDbApi;

public class APIInitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ApiProvider.setInstance(new TvDbApi(APIKeyListener.getKey()));
		System.out.println("Api initialized");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
