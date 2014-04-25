package com.goddammitus.tvtracker.server.model.persist;

public class ApiProvider {
	private static IApi theInstance;

	public static IApi getInstance() {
		return theInstance;
	}

	public static void setInstance(IApi db) {
		theInstance = db;
	}
}
