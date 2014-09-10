package com.ntd.pushpush.request.result;

public class NetErrorResult extends RequestResult {
	private static final long serialVersionUID = 1L;

	private Exception exception;

	public NetErrorResult(Exception exception) {
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}
}
