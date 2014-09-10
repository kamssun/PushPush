package com.ntd.pushpush.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;

import com.ntd.pushpush.data.SendMessageInfo;

/**
 * 消息管理
 * 
 * @author _sush
 */
public class SendMessageDao extends BaseDao {
	private static final String DB_NAME = "send_msg";
	private static final String CMD_CREATE_TABLE = "CREATE TABLE send_msg ("
          // 0
          + "_id INTEGER PRIMARY KEY,"
          // 1
          + "msg_id TEXT"
          // 2
          + "msg_content TEXT"
          // 3
          + "msg_type INTEGER"
          // 4
          + "sender_id TEXT"
          // 5
          + "sender_name TEXT"
          // 6
          + "send_time INTEGER"
          // 7
          + "receiver_num INTEGER"
          // 8
          + "reply_num INTEGER"
          // end
          + ");";
	
	private synchronized SendMessageInfo createMsgInfo(Cursor cursor) {
		SendMessageInfo info = new SendMessageInfo();
		info.setMessageId(cursor.getString(1));
		info.setMessageContent(cursor.getString(2));
		info.setMessageType(cursor.getInt(3));
		info.setSenderId(cursor.getString(4));
		info.setSenderName(cursor.getString(5));
		info.setSendTime(cursor.getInt(6));
		info.setReceiverAmount(cursor.getInt(7));
		info.setReplyNumber(cursor.getInt(8));
		return info;
	}
	
	/**
	 * 添加一条新消息
	 */
	public synchronized void addOneMsg(String msgId, String msgContent, int msgType, String senderId, String senderName, int receiverAmout, int sendTime) {
		ContentValues values = new ContentValues();
		values.put("msg_id", msgId);
		values.put("msg_content", msgContent);
		values.put("msg_type", msgType);
		values.put("sender_id", senderId);
		values.put("sender_name", senderName);
		values.put("send_time", sendTime);
		values.put("receiver_num", receiverAmout);
		
		getDb().insert(getDbName(), null, values);
	}
	
	/**
	 * 获取全部消息
	 */
	public synchronized List<SendMessageInfo> getAllMsg() {
		String sql = "";
		final Cursor cursor = getDb().rawQuery(sql, null);
		final List<SendMessageInfo> list = new ArrayList<SendMessageInfo>();
		
		if (cursor.moveToFirst()) {
			do {
				list.add(createMsgInfo(cursor));
			} while(cursor.moveToNext());
		}
		cursor.close();
		return list;
	}
	
	/**
	 * 获取指定消息类型的消息
	 */
	public synchronized List<SendMessageInfo> getSentMsg(int msgType) {
		String sql = "";
		final Cursor cursor = getDb().rawQuery(sql, null);
		final List<SendMessageInfo> list = new ArrayList<SendMessageInfo>();
		
		if (cursor.moveToFirst()) {
			do {
				list.add(createMsgInfo(cursor));
			} while(cursor.moveToNext());
		}
		cursor.close();
		return list;
	}
	
	/**
	 * 删除一条消息
	 */
	public synchronized int deleteMsg(String msgId) {
		return getDb().delete(getDbName(), "msg_id=?", new String[] { msgId });
	}
	
	/**
	 * 批量删除
	 */
	public synchronized int deleteMsges() {
		
		return 0;
	}
	
	/**
	 * 删除所有消息
	 */
	public synchronized int deleteAllMsg() {
		
		return 0;
	}
	
	private static class SendMsgListDaoContainer {
		private static SendMessageDao instance = new SendMessageDao();
	}
	
	public static SendMessageDao getInstance() {
		return SendMsgListDaoContainer.instance;
	}

	@Override
	public String getDbName() {
		return DB_NAME;
	}

	@Override
	public String getCreateDbSQLStatement() {
		return CMD_CREATE_TABLE;
	}
}
