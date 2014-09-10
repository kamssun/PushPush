package com.ntd.pushpush.db;

import java.util.List;
import android.database.Cursor;
import com.ntd.pushpush.data.ContactsInfo;

/**
 * 联系人管理
 * 包括已注册用户 && 手机通讯录
 * 
 * @author _sush
 */
public class ContactsDao extends BaseDao {
	private static final String DB_NAME = "contacts";
	private static final String CMD_CREATE_TABLE = "CREATE TABLE contacts ("
          // 0
          + "_id INTEGER PRIMARY KEY,"
          // 1
          + "user_id TEXT"
          // 2
          + "channel_id TEXT"
          // 3
          + "contacts_type INTEGER"
          // 4
          + "nick_name TEXT"
          // 5
          + "telephone TEXT"
          // 6
          + "email TEXT"
          // 7
          + "avatar_url TEXT"
          // end
          + ");";

	private static class ContactsDaoContainer {
		private static ContactsDao instance = new ContactsDao();
	}
	
	public static ContactsDao getInstance() {
		return ContactsDaoContainer.instance;
	}
	
	private synchronized ContactsInfo createContactsInfo(Cursor cursor) {
		final ContactsInfo item = new ContactsInfo();
		item.setUserId(cursor.getString(1));
		item.setUserChannelId(cursor.getString(2));
		item.setContactsType(cursor.getInt(3));
		item.setUserNickName(cursor.getString(4));
		item.setTelephone(cursor.getString(5));
		item.setEmail(cursor.getString(6));
		item.setHeadPortraitUrl(cursor.getString(7));
		
		return item;
	}
	
	public synchronized List<ContactsInfo> getRegisteredFriends() {
		
		
		return null;
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
