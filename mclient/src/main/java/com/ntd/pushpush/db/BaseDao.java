package com.ntd.pushpush.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * Base class for database DAO
 * @author _sush
 */
public abstract class BaseDao {
	/**
	 * Get DB name
	 */
	public abstract String getDbName();
	
	/**
	 * Get create DB SQL statement
	 */
	public abstract String getCreateDbSQLStatement();
	
	/**
	 * Get readable DB
	 */
	public SQLiteDatabase getDb() {
		return DBOpenHelper.getInstance().getWritableDatabase();
	}
	
	/**
	 * Clear all data of this DB
	 */
	public void clearAllData() {
		getDb().delete(getDbName(), null, null);
	}
}
