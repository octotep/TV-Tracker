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
	private List<Account> accountList;
	private Account dummyAccount;
	private Account otherDummyAccount;
	private Media testMedia;
	private MediaListProgress testMediaListProgress;
	private MediaList testMediaList;
	private MediaProgress testMediaProgress;
	private Map<Media, Progress> testMap;

	public FakeDatabase() {
		this.accountList = new ArrayList<Account>();
		
		// Dummy show data to test list with
		testMedia = new Media("Samurai Flamenco");
		testMap = new HashMap<Media, Progress>();
		testMap.put(testMedia, new Progress(1, 1));
		testMediaList = new MediaList();
		testMediaList.addMedia(testMedia);
		testMediaProgress = new MediaProgress(testMap);
		testMediaListProgress = new MediaListProgress(testMediaList, testMediaProgress);
		
		dummyAccount =  new Account("Austin", "12345");
		accountList.add(dummyAccount);
		otherDummyAccount = new Account("Decker", "password1");
		accountList.add(otherDummyAccount);
		dummyAccount.setMediaListProgress(testMediaListProgress);
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

}
