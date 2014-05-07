package com.goddammitus.tvtracker.server.controllers;

import com.goddammitus.tvtracker.server.model.persist.DatabaseProvider;
import com.tvtracker.model.Account;

public class LoginController {
	public Account login(String username, String password) {
		return DatabaseProvider.getInstance().login(username, password);
	}

	public boolean checkIfAccountExists(String username) {
		return DatabaseProvider.getInstance().checkIfAccountExists(username);
	}

	public boolean createAccount(String username, String password) {
		return DatabaseProvider.getInstance().createAccount(username, password);
	}

	public boolean addMedia(int account_id, String name, int currentSeason, int episodesWatched, int totalEpisodes) {
		return DatabaseProvider.getInstance().addMedia(account_id, name, currentSeason, episodesWatched, totalEpisodes);
	}
}
