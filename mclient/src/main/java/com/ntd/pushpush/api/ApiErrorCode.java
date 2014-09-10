package com.ntd.pushpush.api;

/**
 * Error code for {@link ApiResponse}.
 *
 */
public enum ApiErrorCode {
	/**
	 * success.
	 */
	NO_ERROR(0),
	/**
	 * invalid parameter
	 */
	INVALID_PARAM(-1),
	/**
	 * server internal error
	 */
	SERVER_INTERNAL(-98),
	/**
	 * server database error
	 */
	SERVER_DB(-99),
	// defined by client.
	/**
	 * gson convert error.
	 */
	GSON_ERROR(8001),
	/**
	 * Unknown error.
	 */
	UNKNOWN(8002), ;

	private int errorCode;

	ApiErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
