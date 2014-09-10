package com.ntd.pushpush.data;

/**
 * TReplyMessage entity. @author MyEclipse Persistence Tools
 */

public class ReplyMessageInfo{

	// Fields

	private String replyMessageId;
	private String replyMessage;
	private String messageTypeId;
	private String messageTypeName;
	private String replyUserId;
	private String replyUserName;
	private int replyTime;
	private String replyWayId;
	private String replyWayName;
	private String isNotDelete;
	private String remark;

	// Constructors

	/** default constructor */
	public ReplyMessageInfo() {
	}

	// Property accessors

	public String getReplyMessageId() {
		return this.replyMessageId;
	}

	public void setReplyMessageId(String replyMessageId) {
		this.replyMessageId = replyMessageId;
	}

	public String getReplyMessage() {
		return this.replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	public String getMessageTypeId() {
		return this.messageTypeId;
	}

	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageTypeName() {
		return this.messageTypeName;
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public String getReplyUserId() {
		return this.replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyUserName() {
		return this.replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public int getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(int replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyWayId() {
		return this.replyWayId;
	}

	public void setReplyWayId(String replyWayId) {
		this.replyWayId = replyWayId;
	}

	public String getReplyWayName() {
		return this.replyWayName;
	}

	public void setReplyWayName(String replyWayName) {
		this.replyWayName = replyWayName;
	}

	public String getIsNotDelete() {
		return this.isNotDelete;
	}

	public void setIsNotDelete(String isNotDelete) {
		this.isNotDelete = isNotDelete;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}