package com.ntd.pushpush.api;


public class SendMessageRequest extends ApiRequest {

	private static final long serialVersionUID = 1L;

	String id;
	
	public SendMessageRequest(String id) {
		this.id = id;
	}
}
