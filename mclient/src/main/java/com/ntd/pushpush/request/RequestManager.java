package com.ntd.pushpush.request;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.common.collect.Maps;
import com.ntd.pushpush.api.RequestProgressConfig;
import com.ntd.pushpush.request.result.ApiErrorResult;
import com.ntd.pushpush.request.result.NetErrorResult;
import com.ntd.pushpush.request.result.RequestResult;
import com.ntd.pushpush.request.result.SuccessResult;
import com.ntd.pushpush.util.Logger;

/**
 * 网络请求管理类 {@link RequestThread}
 * 
 * @author _sush
 */
public class RequestManager {
	/**
	 * Key is generated id.
	 */
	private Map<Long, OnRequestResponseListener> listeners = Maps.newHashMap();
	private Map<Long, ProgressDialog> progressDialogs = Maps.newHashMap();
	private Map<Long, Request> requests = Maps.newHashMap();
	
	private final static ExecutorService threadPool = Executors.newFixedThreadPool(5);

	private static class RequestManagerContainer {
		private static RequestManager instance = new RequestManager();
	}

	public static RequestManager getInstance() {
		return RequestManagerContainer.instance;
	}

	public RequestManager() {
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.obj == null) {
				return ;
			}
			
			final Bundle bundle = (Bundle) msg.obj;
			final long requestId = bundle.getLong(RequestThread.BUNDLE_REQUEST_ID);
			final RequestResult result = (RequestResult) bundle.get(RequestThread.BUNDLE_RESULT);
			
			// remove records
			final Request request = requests.remove(requestId);
			final OnRequestResponseListener listener = listeners.remove(requestId);
			ProgressDialog progressDialog = progressDialogs.remove(requestId);
			if (progressDialog != null) {
				progressDialog.dismiss();
				progressDialog = null;
			}
			
			if (listener != null) {
				if (result instanceof SuccessResult) {
					listener.onRequestSuccess(requestId, request, (SuccessResult) result);
				} else if (result instanceof NetErrorResult) {
					listener.onRequestNetError(requestId, request, (NetErrorResult) result);
				} else if (result instanceof ApiErrorResult) {
					listener.onRequestApiError(requestId, request, (ApiErrorResult) result);
				}
			}
			super.handleMessage(msg);
		}

	};

	/**
	 * Starts a request without progress dialog
	 * @return requestId for this request.
	 */
	public synchronized void startRequest(OnRequestResponseListener listener,
			Request request) {
		startRequest(listener, request, null);
	}

	/**
	 * Start a request with a progress dialog
	 * 
	 * @return requestId for this request. -1 means failed
	 */
	public synchronized void startRequest(OnRequestResponseListener listener,
			Request request, RequestProgressConfig progressConfig) {
	    if (getDuplicatedRequest(request)) {
	    	// repeated request
	    	Logger.i("startRequest: duplicated request", "duplicated request:" + request.getClass().getSimpleName());
	    	return ;
	    }
		
		final RequestThread thread = RequestFactory.createRequestThread(handler, request);
		if (thread != null) {
			final long requestId = thread.getRequestId();
			threadPool.execute(thread);
			
			listeners.put(requestId, listener);
			requests.put(requestId, request);
			
			if (progressConfig != null && progressDialogs.isEmpty()) {
				// Just allowed one progress dialog.
				final ProgressDialog dialog = createProgressDialog(progressConfig);
				progressDialogs.put(requestId, dialog);
				dialog.show();
			}
		} else {
			Logger.e("create thread failed", request.getClass().getSimpleName());
		}
	}
	
	/**
	 * Is repeated requests.
	 * @param request
	 * @return
	 */
	private boolean getDuplicatedRequest(Request request) {
	    for (final Map.Entry<Long, Request> entry : requests.entrySet()) {
	    	if (entry.getValue().isDuplicated(request)) {
	    		return true;
	    	}
	    }
	    return false;
	}

	// TODO
	public ProgressDialog createProgressDialog(RequestProgressConfig progressConfig) {
//	    Preconditions.checkNotNull(progressConfig);
//	    final Context context = progressConfig.getContext();
//	    final ProgressDialog dialog = new ProgressDialog(context);
//	    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//	    dialog.setIndeterminate(false);
//	    dialog.setCancelable(progressConfig.getCancelable());
//	    dialog.setMessage(context.getString(progressConfig.getContentTextId()));
//	    return dialog;
		return null;
	}
}
