package com.ntd.pushpush.api;

public class RegisterByPhoneRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;
	
	@ApiField(paramName = "accountName")
	String phone;
	@ApiField(paramName = "userName")
	String userName;

	public RegisterByPhoneRequest(String phone, String userName) {
		super();
		this.phone = phone;
		this.userName = userName;
	}
}
