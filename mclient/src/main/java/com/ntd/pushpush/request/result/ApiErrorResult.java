package com.ntd.pushpush.request.result;

import com.ntd.pushpush.api.ApiException;

public class ApiErrorResult extends RequestResult {
	private static final long serialVersionUID = 1L;

	private ApiException exception;
	
	public ApiErrorResult(ApiException exception) {
		this.exception = exception;
	}
	
	public ApiException getApiException() {
		return exception;
	}
}
