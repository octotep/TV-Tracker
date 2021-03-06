package com.goddammitus.tvtracker.server.model.persist;

import com.tvtracker.model.Account;

public interface IDatabase {
	public Account login(String username, String password);

	public boolean checkIfAccountExists(String username);

	public boolean createAccount(String username, String password);

	public boolean addMedia(int account_id, String name, int currentSeason, int episodesWatched, int totalEpisodes);
}
