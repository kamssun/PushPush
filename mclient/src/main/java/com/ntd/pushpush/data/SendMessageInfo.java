package com.ntd.pushpush.data;

/**
 * 发送消息信息
 * 
 */

public class SendMessageInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Fields
	private String messageId;
	private String messageContent;
	private int messageType;
	private String senderId;
	private String senderName;
	private int sendTime;
	private int receiverAmount;
	private int receiverAmountByApp;
	private int replyNumber;
	private String receiverIds;// 接收人ID

	public static interface MsgType {
		public static final int DEFAULT = 0;
		public static final int TYPE_1 = DEFAULT + 1;
		public static final int TYPE_2 = TYPE_1 + 1;
	}

	// Constructors

	/** default constructor */

	public SendMessageInfo() {
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSendTime(int sendTime) {
		this.sendTime = sendTime;
	}

	public void setReceiverAmount(int receiverAmount) {
		this.receiverAmount = receiverAmount;
	}

	public void setReceiverAmountByApp(int receiverAmountByApp) {
		this.receiverAmountByApp = receiverAmountByApp;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}

	public Integer getSendTime() {
		return sendTime;
	}

	public void setSendTime(Integer sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getReceiverAmount() {
		return this.receiverAmount;
	}

	public void setReceiverAmount(Integer receiverAmount) {
		this.receiverAmount = receiverAmount;
	}

	public Integer getReceiverAmountByApp() {
		return this.receiverAmountByApp;
	}

	public void setReceiverAmountByApp(Integer receiverAmountByApp) {
		this.receiverAmountByApp = receiverAmountByApp;
	}

	public Integer getReplyNumber() {
		return this.replyNumber;
	}

	public void setReplyNumber(Integer replyNumber) {
		this.replyNumber = replyNumber;
	}

	public String getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
	}

}