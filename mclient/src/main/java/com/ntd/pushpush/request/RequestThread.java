package com.ntd.pushpush.request;

import java.io.IOException;

import com.ntd.pushpush.PushApplication;
import com.ntd.pushpush.api.ApiException;
import com.ntd.pushpush.request.result.ApiErrorResult;
import com.ntd.pushpush.request.result.NetErrorResult;
import com.ntd.pushpush.request.result.RequestResult;
import com.ntd.pushpush.request.result.SuccessResult;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public abstract class RequestThread implements Runnable {
	public static final String BUNDLE_REQUEST_ID = "BUNDLE_REQUEST_ID";
	public static final String BUNDLE_RESULT = "BUNDLE_RESULT";
	
	private Context context;
	private Handler handler;
	private Request request;

	private long requestId = nextId();
	private static long lastId = System.currentTimeMillis();
	
	/**
	 * 获取线程ID，注意synchroized关键字，防止多线程出现同ID情况的发生
	 */
	private static synchronized long nextId() {
		long now = System.currentTimeMillis();
		if (now <= lastId) {
			now = lastId + 1;
		}
		lastId = now;
		return now;
	}
	
	public RequestThread() {}

	public RequestThread(Handler handler, Request request) {
		this.handler = handler;
		this.request = request;
	}

	@Override
	public void run() {
		// TODO
		try {
			internalRun();
		} catch (final ApiException e) {
			sendApiErrorMessage(e);
		} catch (final IOException e) {
			sendNetErrorMessage(e);
		}
	}
	
	protected abstract void internalRun() throws ApiException, IOException;
	
	/**
	 * 通知调用接口类
	 */
	private void sendMessage(RequestResult result) {
		if (handler == null) {
			return ;
		}
		
		final Message message = handler.obtainMessage();
		final Bundle bundle = new Bundle();
		bundle.putLong(BUNDLE_REQUEST_ID, requestId);
		if (result != null) {
			bundle.putSerializable(BUNDLE_RESULT, result);
		}
		message.obj = bundle;
		handler.sendMessage(message);
		
	}
	
	/**
	 * @see SuccessResult
	 */
	protected void sendSuccessMessage(Response response) {
		// 是否需要缓存
		if (request instanceof WithCacheResponse) {
			final WithCacheResponse withCahe = (WithCacheResponse) request;
			if (withCahe.isNeedCacheResponse()) {
				// 进行缓存
				RequestCacheManager.getInstance().saveResponseCache(response, withCahe.getExpiredTime());
			}
		}
		sendMessage(new SuccessResult(response));
	}
	
	
	/**
	 * @see NetErrorResult
	 */
	protected void sendNetErrorMessage(Exception e) {
		sendMessage(new NetErrorResult(e));
	}
	
	/**
	 * @see ApiErrorResult
	 */
	private void sendApiErrorMessage(ApiException e) {
		sendMessage(new ApiErrorResult(e));
	}
	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public long getRequestId() {
		return requestId;
	}

	protected Context getApplicationContext() {
		if (context == null) {
			context = PushApplication.getInstance();
		}
		return context;
	}
}
