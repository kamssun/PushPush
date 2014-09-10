package com.ntd.pushpush.client;

import com.google.mygson.Gson;

public class ApiServiceClientManager {
	private ApiServiceClient apiServiceClient;
	private final static String SERVER_URL = "http://59.68.29.92:8080/PushPushWeb/";
	private final static int TIMEOUT_TIME = 15 * 1000;
	
	private static class ApiServiceClientMangerContainer {
		private static ApiServiceClientManager instance = new ApiServiceClientManager();
	}
	
	public static ApiServiceClientManager getInstance() {
		return ApiServiceClientMangerContainer.instance;
	}
	
	public ApiServiceClientManager() {}
	
	public synchronized ApiServiceClient getClient() {
		if (apiServiceClient == null) {
			apiServiceClient = new ApiServiceClient(new Gson(), SERVER_URL, TIMEOUT_TIME);
		}
		return apiServiceClient;
	}
}
