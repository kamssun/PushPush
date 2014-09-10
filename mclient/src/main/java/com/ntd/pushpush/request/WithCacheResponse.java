package com.ntd.pushpush.request;

/**
 * {@link Request} with a cache {@link Response} that automatic saved by {@link RequestThread}.
 */
public interface WithCacheResponse {

	void setNeedCache(boolean isNeedCache);

	boolean isNeedCacheResponse();

	void setExpiredTime(long time);

	long getExpiredTime();
}
