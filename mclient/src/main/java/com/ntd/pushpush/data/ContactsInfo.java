package com.ntd.pushpush.data;

/**
 * 联系人信息
 * 包含手机内通讯录联系人 && 使用应用的注册好友
 * 
 * @author _sush
 */
public class ContactsInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Fields
	private String userId;
	private String userChannelId;
	private String userName;
	private String userNickName;
	private String sex;
	private String telephone;
	private String email;
	private String headPortraitUrl;
	private String registerTime;
	
	private int contactsType;	// 联系人类型，手机通讯录 & 用户
	
	public static interface ContactType {
		public static final int REGISTERED_USER = 0;	// 已注册用户
		public static final int PHONE_CONTACTS_USER = REGISTERED_USER + 1; // 手机通讯录联系人
	}

	// Constructors

	/** default constructor */
	public ContactsInfo() {
	}

	/** minimal constructor */
	public ContactsInfo(String userId, String userName, String telephone,
			String registerTime) {
		this.userId = userId;
		this.userName = userName;
		this.telephone = telephone;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public ContactsInfo(String userId, String userChannelId, String userName,
			String userNickName, String sex, String telephone,
			String email, String headPortraitUrl, String registerTime,
			String remark) {
		this.userId = userId;
		this.userChannelId = userChannelId;
		this.userName = userName;
		this.userNickName = userNickName;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.headPortraitUrl = headPortraitUrl;
		this.registerTime = registerTime;
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

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public int getContactsType() {
		return contactsType;
	}

	public void setContactsType(int contactsType) {
		this.contactsType = contactsType;
	}

}