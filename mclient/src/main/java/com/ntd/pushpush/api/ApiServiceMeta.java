package com.ntd.pushpush.api;

import java.util.Map;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum ApiServiceMeta {
	POI_LIST("Poi/poiList", HotShareRequest.class, HotShareResponse.class), 
	/**
	 * Send Message
	 */
	Login("User_login?",LogInRequest.class,LogInResponse.class),
	Regist("User_add?",RegistByIdRequest.class,RegistByIdResponse.class),
	SEND_MESSAGE("Poi/poiList", SendMessageRequest.class, SendMessageResponse.class), ;
	private final String uri;
	private final Class<? extends ApiRequest> requestType;
	private final Class<? extends ApiResponse> responseType;
	private static final Map<Class<? extends ApiRequest>, ApiServiceMeta> metas;

	static {
		final Builder<Class<? extends ApiRequest>, ApiServiceMeta> builder = ImmutableMap
				.<Class<? extends ApiRequest>, ApiServiceMeta> builder();
		for (final ApiServiceMeta meta : values()) {
			builder.put(meta.requestType, meta);
		}
		metas = builder.build();
	}

	public static ApiServiceMeta getApiServiceMeta(Class<? extends ApiRequest> requestType) {
		return metas.get(requestType);
	}

	private ApiServiceMeta(String uri, Class<? extends ApiRequest> requestType,
			Class<? extends ApiResponse> responseType) {
		this.uri = uri;
		this.requestType = requestType;
		this.responseType = responseType;
	}

	public Class<? extends ApiRequest> getRequestType() {
		return requestType;
	}

	public Class<? extends ApiResponse> getResponseType() {
		return responseType;
	}

	public String getUri() {
		return uri;
	}
}
