package com.ntd.pushpush.api;

public class LogInRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;
	
	@ApiField(paramName = "studentId")
	String studentId;
	@ApiField(paramName = "passWord")
	String password;
	@ApiField(paramName = "userType")
	String userType;
	public LogInRequest(String studentId, String password,String userType) {
		super();
		this.studentId = studentId;
		this.password = password;
		this.userType=userType;
	}
}
