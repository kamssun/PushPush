package com.ntd.pushpush.api;

import java.io.Serializable;

import com.ntd.pushpush.request.Response;

public abstract class ApiResponse implements Response, Serializable {
	
	private static final long serialVersionUID = 1L;
	private int result_code;
	
	public int getResultCode() {
		return result_code;
	}
	
	/**
	 * 请求是否成功
	 * @return
	 */
	public boolean isSuccess() {
		return result_code == ApiErrorCode.NO_ERROR.getErrorCode();
	}
}
