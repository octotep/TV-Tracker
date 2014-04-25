package com.goddammitus.tvtracker.client;

import com.google.gwt.core.shared.GWT;

public class RPC {
	public static final LoginServiceAsync loginService =
			GWT.create(LoginService.class);
	public static final APISearchServiceAsync searchService = GWT.create(APISearchService.class);
}
