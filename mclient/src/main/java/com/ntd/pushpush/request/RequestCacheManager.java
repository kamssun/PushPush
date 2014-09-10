package com.ntd.pushpush.request;

import java.io.Serializable;
import android.content.SharedPreferences.Editor;
import com.google.mygson.Gson;
import com.google.mygson.GsonBuilder;
import com.ntd.pushpush.util.MyPreferenceManager;
import com.ntd.pushpush.util.StringUtils;

/**
 * 缓存管理
 * 
 * @author _sush
 */
public class RequestCacheManager {
	private Gson gson = new GsonBuilder().registerTypeAdapter(Response.class,
			new ResponseTypeAdapter()).create();

	public static class RequestCacheEntry implements Serializable {

		private static final long serialVersionUID = 1L;

		private Response response;
		private long expiredTime;
		private long saveTime;

		public RequestCacheEntry(Response response, long expiredTime) {
			this.response = response;
			this.expiredTime = expiredTime;
			this.saveTime = System.currentTimeMillis();
		}

		public boolean isExpired() {
			if (response == null) {
				return true;
			}
			return saveTime + expiredTime <= System.currentTimeMillis();
		}

		@SuppressWarnings("unchecked")
		public <T extends Response> T getResponse() {
			return (T) response;
		}
	}

	public RequestCacheManager() {
	}

	private static class RequestCacheManagerContainer {
		private static RequestCacheManager instance = new RequestCacheManager();
	}

	public static RequestCacheManager getInstance() {
		return RequestCacheManagerContainer.instance;
	}

	/**
	 * Returns cached {@link Response} if the cache exist or not expired.
	 * 
	 * @see WithCacheResponse
	 */
	public <T extends Response> RequestCacheEntry getCachedResponse(
			Class<T> responseType) {
		final String cacheName = getCacheName(responseType);
		final String gsonString = MyPreferenceManager.getSharedPreferences().getString(cacheName, null);
		if (!StringUtils.isEmpty(gsonString)) {
			return gson.fromJson(gsonString, RequestCacheEntry.class);
		}
		return null;
	}

	/**
	 * Save success request result 
	 */
	public <T extends Response> void saveResponseCache(T response, long expiredTime) {
		final RequestCacheEntry cacheEntry = new RequestCacheEntry(response,
				expiredTime);
		final String gsonString = gson.toJson(cacheEntry);
		final String cacheName = getCacheName(response.getClass());
		final Editor editor = MyPreferenceManager.getSharedPreferences()
				.edit();
		editor.putString(cacheName, gsonString);
		editor.commit();
	}

	private String getCacheName(Class<? extends Response> responseType) {
		return responseType.getName();
	}
}
