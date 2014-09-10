package com.ntd.pushpush.db;

import android.database.Cursor;
import com.ntd.pushpush.data.ReceivedMessageInfo;

public class ReveiveMessageDao extends BaseDao {
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
	
	private static class SendMsgListDaoContainer {
		private static SendMessageDao instance = new SendMessageDao();
	}
	
	public static SendMessageDao getInstance() {
		return SendMsgListDaoContainer.instance;
	}
	
	private synchronized ReceivedMessageInfo createMsgInfo(Cursor cursor) {
		ReceivedMessageInfo info = new ReceivedMessageInfo();
		return info;
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
