package com.ntd.pushpush.db;

import java.util.List;

/**
 * 示例：使用数据库
 * @author _sush
 */
public class DemoXXDao extends BaseDao {
	private static final String DB_NAME = "demo";
	private static final String CMD_CREATE_TABLE = "CREATE TABLE pay ("
          // 0
          + "_id INTEGER PRIMARY KEY,"
          // 1
          + "s_price INTEGER"
          // end
          + ");";
	
	private static class DemoXXDaoContainer {
		private static DemoXXDao instance = new DemoXXDao();
	}
	
	public static DemoXXDao getInstance() {
		return DemoXXDaoContainer.instance;
	}

	@Override
	public String getDbName() {
		return DB_NAME;
	}

	@Override
	public String getCreateDbSQLStatement() {
		return CMD_CREATE_TABLE;
	}
	
	/**
	 * ！：
	 * 每次增删改查都需要在操作前添加同步关键字synchronized
	 * 保证同一时刻最多有一个线程操作该方法或代码块，保证数据安全
	 */
	public synchronized void add() {
	}

	public synchronized List<String> query() {
		return null;
	}
	
	public synchronized void delete() {
	}

	public synchronized void update() {
	}
}
