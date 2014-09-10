package com.ntd.pushpush.client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.google.common.base.Charsets;
import com.google.mygson.Gson;
import com.ntd.pushpush.api.ApiErrorCode;
import com.ntd.pushpush.api.ApiException;
import com.ntd.pushpush.api.ApiField;
import com.ntd.pushpush.api.ApiRequest;
import com.ntd.pushpush.api.ApiResponse;
import com.ntd.pushpush.api.ApiServiceMeta;
import com.ntd.pushpush.util.ByteUtil;
import com.ntd.pushpush.util.Loger;
import com.ntd.pushpush.util.Logger;

public class ApiServiceClient {
	private String serverUrl;
	private Gson gson;
	private int timeout;
	
	public ApiServiceClient() {}
	
	public ApiServiceClient(final Gson gson, final String serverUrl) {
		this(gson, serverUrl, 0);
	}
	
	public ApiServiceClient(final Gson gson, final String serverUrl, final int timeout) {
		this.gson = gson;
		this.serverUrl = serverUrl;
		this.timeout = timeout;
	}
	
	/**
	 * 执行请求
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public synchronized <REQ extends ApiRequest, RES extends ApiResponse> RES execute(final REQ request) throws ApiException, IOException {
		final ApiServiceMeta meta = ApiServiceMeta.getApiServiceMeta(request.getClass());
		final String apiUrl = serverUrl + meta.getUri();
		
		final String httpUrl = apiUrl + convertRequestToString(request);
		final HttpGet httpGet = new HttpGet(httpUrl);
		
		Logger.i("httpUrl", httpUrl);
		new Loger().v(httpUrl);
		try {
			HttpResponse httpResponse = createHttpClient().execute(httpGet);
			
			final HttpEntity entity = httpResponse.getEntity();
			if ((httpResponse.getStatusLine().getStatusCode() != 200) || (entity.getContentLength() == 0)) {
				entity.consumeContent();
				throw new IOException("http_request_status: " + httpResponse.getStatusLine());
			}
			final String content = ByteUtil.toString(EntityUtils.toByteArray(entity));
			Logger.i("http_content", content);
			
			final ApiResponse apiResponse = parse(content, meta.getResponseType());
			return (RES) apiResponse;
		} finally {
		}
	}
	
	private <T> T parse(String content, Class<T> classType) {
		try {
			return gson.fromJson(content, classType);
		} catch (final RuntimeException e) {
			e.printStackTrace();
			Logger.w("gson_error", content + " || exceptinon: " + e);
			throw new ApiException(ApiErrorCode.GSON_ERROR, e.getMessage());
		}
	}

	private String convertRequestToString(ApiRequest request) {
		final StringBuilder sbResult = new StringBuilder();
		Class<?> classType = request.getClass();
		while (true) {
			sbResult.append(convertFieldsToString(request, classType.getDeclaredFields()));
			if (classType.getGenericSuperclass() == null) {
				break;
			}
			classType = classType.getSuperclass();
		}
		return sbResult.toString();
	}
	
	private String convertFieldsToString(ApiRequest request, Field[] fields) {
		final StringBuilder sbResult = new StringBuilder();
		int i=1;
		for (final Field field : fields) {
			if (!field.isAnnotationPresent(ApiField.class)) {
				continue;
			}
			Object value = null;
			try {
				field.setAccessible(true);
				value = field.get(request);
				if (value != null) {
					final String paramName = field.getAnnotation(ApiField.class).paramName();
					if(i!=1)
					sbResult.append("&");
					sbResult.append(paramName);
					sbResult.append("=");
					sbResult.append(URLEncoder.encode(String.valueOf(value), Charsets.UTF_8.name()));
					i++;
				}
			} catch (final Exception e) {
				Logger.w("convert request string failed.", e.getMessage());
			}
		}
		return sbResult.toString();
	}
	
	private DefaultHttpClient createHttpClient() {
		if (timeout > 0) {
			final HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters, timeout);
			HttpConnectionParams.setSoTimeout(httpParameters, timeout);
			return new DefaultHttpClient(httpParameters);
		} else {
			return new DefaultHttpClient();
		}
	}
}
