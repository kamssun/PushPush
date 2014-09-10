package com.ntd.pushpush.api;

import com.ntd.pushpush.request.ApiRequestThread;
import com.ntd.pushpush.request.Request;
import com.ntd.pushpush.request.RequestThread;
import com.ntd.pushpush.request.WithCacheResponse;
import com.ntd.pushpush.util.TimeUtil;

public abstract class ApiRequest extends Request implements WithCacheResponse {
	private static final long serialVersionUID = 1L;
	
	private static final long DEFAULT_EXPIRED_TIME = 10 * TimeUtil.ONE_MINUTE_MS; // 10min
	private long expiredTime = DEFAULT_EXPIRED_TIME;
	private boolean isNeedCache = false;	// 默认不需要缓存
	
	@Override
	public Class<? extends RequestThread> getRequestThreadClasss() {
		return ApiRequestThread.class;
	}

	@Override
	public void setExpiredTime(long time) {
		this.expiredTime = time;
	}

	@Override
	public long getExpiredTime() {
		return expiredTime;
	}

	@Override
	public void setNeedCache(boolean isNeedCache) {
		this.isNeedCache = isNeedCache;
	}

	@Override
	public boolean isNeedCacheResponse() {
		return isNeedCache;
	}
}
