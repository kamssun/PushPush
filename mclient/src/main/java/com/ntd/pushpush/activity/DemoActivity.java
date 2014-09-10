package com.ntd.pushpush.activity;

import com.ntd.pushpush.R;
import com.ntd.pushpush.api.HotShareRequest;
import com.ntd.pushpush.request.OnRequestResponseListener;
import com.ntd.pushpush.request.Request;
import com.ntd.pushpush.request.RequestManager;
import com.ntd.pushpush.request.result.ApiErrorResult;
import com.ntd.pushpush.request.result.NetErrorResult;
import com.ntd.pushpush.request.result.SuccessResult;
import com.ntd.pushpush.util.Logger;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DemoActivity extends BaseActivity {

	@Override
	protected void onInit(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		
		this.findViewById(R.id.send).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				RequestManager.getInstance().startRequest(new OnRequestResponseListener() {
					
					@Override
					public void onRequestSuccess(long requestId, Request request,SuccessResult successResult) {
						
						Logger.i("onRequestSuccess", successResult.getResponse().toString());
					}
				}, new HotShareRequest(20, 1));
			}
		});
	}
	
	OnRequestResponseListener listener = new OnRequestResponseListener() {
		
		@Override
		public void onRequestSuccess(long requestId, Request request,
				SuccessResult successResult) {
			
		}

		@Override
		public void onRequestApiError(long requestId, Request request,
				ApiErrorResult apiErrorResult) {
			super.onRequestApiError(requestId, request, apiErrorResult);
		}

		@Override
		public void onRequestNetError(long requestId, Request request,
				NetErrorResult netErrorResult) {
			super.onRequestNetError(requestId, request, netErrorResult);
		}
		
	};

}
