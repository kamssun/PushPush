package com.ntd.pushpush.request.result;

import com.ntd.pushpush.request.Response;

/**
 * Result of request for success
 * @author _sush
 */
public class SuccessResult extends RequestResult {
	private static final long serialVersionUID = 1L;

	private Response response;
	
	public SuccessResult(Response response) {
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}
}
