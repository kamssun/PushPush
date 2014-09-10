package com.ntd.pushpush.api;

//http://localhost:8080/PushPushWeb/User_add?studentId=2012213738&passWord=233233&userType=Student&user_id=773943111140739900&channel_id=4053894688190760687
public class RegistByIdRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;
	@ApiField(paramName = "studentId")
	String studentId;
	@ApiField(paramName = "passWord")
	String password;
	@ApiField(paramName = "userType")
	String userType;
	@ApiField(paramName = "user_id")
	String user_id;
	@ApiField(paramName = "channel_id")
	String channel_id;

	public RegistByIdRequest(String studentId, String password, String userType,String user_id,String channel_id) {
		super();
		this.studentId = studentId;
		this.password = password;
		this.userType = userType;
		this.user_id=user_id;
		this.channel_id=channel_id;
	}
}
