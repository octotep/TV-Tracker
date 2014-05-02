package com.goddammitus.tvtracker.server.model.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tvtracker.model.Account;
import com.tvtracker.model.Media;
import com.tvtracker.model.MediaList;
import com.tvtracker.model.MediaListProgress;
import com.tvtracker.model.MediaProgress;
import com.tvtracker.model.Progress;

public class FakeDatabase implements IDatabase {
	private ArrayList<Account> accountList;
	private Account dummyAccount;
	private Account otherDummyAccount;

	public FakeDatabase() {
		this.accountList = new ArrayList<Account>();

		// Dummy show data to test list with
		Media testMedia = new Media(0, "Samurai Flamenco");
		Map<Media, Progress> testMap = new HashMap<Media, Progress>();
		testMap.put(testMedia, new Progress(0, 1, 1, 22));
		MediaList testMediaList = new MediaList();
		testMediaList.addMedia(testMedia);
		MediaProgress testMediaProgress = new MediaProgress(0, testMap);
		MediaListProgress testMediaListProgress = new MediaListProgress(0, testMediaList, testMediaProgress);

		dummyAccount =  new Account(0, "Forry", "12345");
		accountList.add(dummyAccount);
		dummyAccount.setMediaListProgress(testMediaListProgress);

		// Dummy show data to test list with
		Media testMedia2 = new Media(1, "Chuck");
		Map<Media, Progress> testMap2 = new HashMap<Media, Progress>();
		testMap2.put(testMedia2, new Progress(1, 5, 8, 13));
		MediaList testMediaList2 = new MediaList();
		testMediaList2.addMedia(testMedia2);
		MediaProgress testMediaProgress2 = new MediaProgress(1, testMap2);
		MediaListProgress testMediaListProgress2 = new MediaListProgress(1, testMediaList2, testMediaProgress2);

		otherDummyAccount = new Account(1, "Decker", "password1");
		accountList.add(otherDummyAccount);
		otherDummyAccount.setMediaListProgress(testMediaListProgress2);
	}

	@Override
	public Account login(String username, String password) {
		for(Account account:accountList){
			if(account != null)
				if(account.getName().equalsIgnoreCase(username))
					if(account.getPassword().equals(password))
						return account;
		}
		return null;
	}

	@Override
	public boolean checkIfAccountExists(String username) {
		for(Account account:accountList) {
			if(account.getName() == username) {
				return true;
			}
		}

		return false;
	}
}
