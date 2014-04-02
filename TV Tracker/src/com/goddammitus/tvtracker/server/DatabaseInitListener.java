package com.goddammitus.tvtracker.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.goddammitus.tvtracker.server.model.persist.DatabaseProvider;
import com.goddammitus.tvtracker.server.model.persist.FakeDatabase;

public class DatabaseInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// Webapp is starting up
		DatabaseProvider.setInstance(new FakeDatabase()); // FIXME: use real database
		System.out.println("Database initialized!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// Webapp is shutting down

	}

}
