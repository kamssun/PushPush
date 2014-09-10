package com.ntd.pushpush.data;

import java.sql.Timestamp;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Fields

	private String userId;
	private String userChannelId;
	private String userName;
	private String userNickName;
	private String password;
	private String sex;
	private String telephone;
	private String email;
	private String headPortraitUrl;
	private Timestamp registerTime;
	private String remark;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userId, String userName, String telephone,
			Timestamp registerTime) {
		this.userId = userId;
		this.userName = userName;
		this.telephone = telephone;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public UserInfo(String userId, String userChannelId, String userName,
			String userNickName, String password, String sex, String telephone,
			String email, String headPortraitUrl, Timestamp registerTime,
			String remark) {
		this.userId = userId;
		this.userChannelId = userChannelId;
		this.userName = userName;
		this.userNickName = userNickName;
		this.password = password;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.headPortraitUrl = headPortraitUrl;
		this.registerTime = registerTime;
		this.remark = remark;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserChannelId() {
		return this.userChannelId;
	}

	public void setUserChannelId(String userChannelId) {
		this.userChannelId = userChannelId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return this.userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadPortraitUrl() {
		return this.headPortraitUrl;
	}

	public void setHeadPortraitUrl(String headPortraitUrl) {
		this.headPortraitUrl = headPortraitUrl;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}