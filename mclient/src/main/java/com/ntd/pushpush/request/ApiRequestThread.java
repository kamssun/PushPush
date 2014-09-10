package com.ntd.pushpush.request;

import java.io.IOException;
import android.os.Handler;
import com.ntd.pushpush.api.ApiException;
import com.ntd.pushpush.api.ApiRequest;
import com.ntd.pushpush.api.ApiResponse;
import com.ntd.pushpush.client.ApiServiceClientManager;

public class ApiRequestThread extends RequestThread {
	
	public ApiRequestThread(Handler handler, Request apiRequest) {
		super(handler, apiRequest);
	}

	@Override
	protected void internalRun() throws ApiException, IOException {
		final ApiRequest request = (ApiRequest) getRequest();
		final ApiResponse response = ApiServiceClientManager.getInstance().getClient().execute(request);
		sendSuccessMessage(response);
	}
}
