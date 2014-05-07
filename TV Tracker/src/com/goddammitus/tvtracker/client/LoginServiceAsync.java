package com.goddammitus.tvtracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tvtracker.model.Account;
import com.tvtracker.model.Login;

public interface LoginServiceAsync {

	void login(Login login,
			AsyncCallback<Account> callback);

	void checkIfAccountExists(String username,
			AsyncCallback<Boolean> callback);

	void createAccount(String username, String password,
			AsyncCallback<Boolean> callback);

	void addMedia(int account_id, String name, int currentSeason,
			int episodesWatched, int totalEpisodes, AsyncCallback<Boolean> callback);
}
