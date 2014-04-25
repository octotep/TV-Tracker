package com.goddammitus.tvtracker.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class APIKeyListener implements ServletContextListener {
	private static String key;

	public static String getKey() {
		return key;
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(
				"com/goddammitus/tvtracker/server/res/apikey.txt");
		if (in != null) {
			BufferedReader reader= new BufferedReader(new InputStreamReader(in));
			try {
				key = reader.readLine();
				System.out.println("API key is " + key);
			} catch (IOException e) {
				System.out.println("Warning: could not read API key");
				e.printStackTrace(System.out);
			}
		}

		if (key == null) {
			System.out.println("Warning: no API key found");
			return;
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// TODO Auto-generated method stub

	}

}
