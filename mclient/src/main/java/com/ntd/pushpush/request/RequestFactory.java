package com.ntd.pushpush.request;

import java.lang.reflect.Constructor;

import android.os.Handler;

public class RequestFactory {
	@SuppressWarnings("unchecked")
	public static <T extends RequestThread> T createRequestThread(Handler handler, Request request) {
		final Class<? extends RequestThread> requestThreadClass = request.getRequestThreadClasss();
		try {
			final Constructor<? extends RequestThread> constructor = requestThreadClass.getConstructor(Handler.class, Request.class);
			return (T) constructor.newInstance(handler, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
