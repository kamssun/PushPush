package com.ntd.pushpush.request;

import android.content.Context;
import android.widget.Toast;
import com.ntd.pushpush.PushApplication;
import com.ntd.pushpush.R;
import com.ntd.pushpush.api.ApiException.ApiError;
import com.ntd.pushpush.request.result.ApiErrorResult;
import com.ntd.pushpush.request.result.NetErrorResult;
import com.ntd.pushpush.request.result.SuccessResult;

/**
 * 网络请求回调接口
 * 
 * @author _sush
 */
public abstract class OnRequestResponseListener {
	private Context context = PushApplication.getInstance();

	private final static long TOAST_INTERVAL = 8 * 1000;
	private static long lastApiErrorToastTime, lastNetErrorToastTime;

	/**
	 * Called when request success
	 */
	public abstract void onRequestSuccess(long requestId, Request request, SuccessResult successResult);

	/**
	 * Called when request API error
	 */
	public void onRequestApiError(long requestId, Request request, ApiErrorResult apiErrorResult) {
		final ApiError apiError = apiErrorResult.getApiException()
				.getApiError();
		String error = "";
		if (apiError != null) {
			final String message = apiError.getErrorMessage() == null ? "" : ":" + apiError.getErrorMessage();
			error = " " + apiError.getReasonCode().getErrorCode() + message;
		}

		final long now = System.currentTimeMillis();
		if (lastApiErrorToastTime + TOAST_INTERVAL < now) {
			Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
			lastApiErrorToastTime = now;
		}
	}

	/**
	 * Called when request net error
	 */
	public void onRequestNetError(long requestId, Request request, NetErrorResult netErrorResult) {
		final long now = System.currentTimeMillis();
		if (lastNetErrorToastTime + TOAST_INTERVAL < now) {
			Toast.makeText(context, context.getString(R.string.net_error), Toast.LENGTH_SHORT).show();
			lastNetErrorToastTime = now;
		}
	}
}
