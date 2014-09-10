package com.ntd.pushpush.request;

import java.io.Serializable;


public abstract class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public abstract Class<? extends RequestThread> getRequestThreadClasss();

	public boolean isDuplicated(Request other) {
		return getClass() == other.getClass();
	}
}
