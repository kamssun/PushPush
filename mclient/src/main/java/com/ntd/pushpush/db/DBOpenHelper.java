package com.ntd.pushpush.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
	private static final int DB_VERSION = 1;

	private static class DBOpenHelperContainer {
		private static DBOpenHelper instance = new DBOpenHelper(null, DB_VERSION); 
	}
	
	public static DBOpenHelper getInstance() {
		return DBOpenHelperContainer.instance;
	}

	public DBOpenHelper(CursorFactory factory, int version) {
		super(null, null, factory, version);
	}

	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
//			db.execSQL(DemoXXDao.getInstance().getCreateDbSQLStatement());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}
}
