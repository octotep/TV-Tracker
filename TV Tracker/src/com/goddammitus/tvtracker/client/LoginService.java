package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	public Account login(Login login);

	public boolean checkIfAccountExists(String username);

	boolean createAccount(String username, String password);

	boolean addMedia(int account_id, String name, int currentSeason,
			int episodesWatched, int totalEpisodes);
}
