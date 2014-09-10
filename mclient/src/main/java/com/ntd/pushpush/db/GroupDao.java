package com.ntd.pushpush.db;


public class GroupDao extends BaseDao {
	private static final String DB_NAME = "groups";
	private static final String CMD_CREATE_TABLE = "CREATE TABLE groups ("
          // 0
          + "_id INTEGER PRIMARY KEY,"
          // 1
          + "s_price INTEGER"
          // end
          + ");";
	
	private static class GroupDaoContainer {
		private static GroupDao instance = new GroupDao();
	}
	
	public static GroupDao getInstance() {
		return GroupDaoContainer.instance;
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
