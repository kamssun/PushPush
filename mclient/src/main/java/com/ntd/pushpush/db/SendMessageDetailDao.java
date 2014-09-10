package com.ntd.pushpush.db;


public class SendMessageDetailDao extends BaseDao {
	private static final String DB_NAME = "send_msg_detail";
	private static final String CMD_CREATE_TABLE = "CREATE TABLE send_msg_detail ("
          // 0
          + "_id INTEGER PRIMARY KEY,"
          // 1
          + "s_price INTEGER"
          // end
          + ");";
	
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
