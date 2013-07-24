package com.g6.georeminderv2;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
	
	public static final String KEY_ROWID = "id";

	public static final String KEY_TITLE = "title";
	public static final String KEY_MSG = "msg";
	public static final String KEY_DATE = "date";
	public static final String KEY_TIME = "time";
	public static final String KEY_PLACE = "place";
	public static final String KEY_TAG = "tag";

	public static final String DATABASE_NAME = "GeoReminderDB";
	public static final String ACTIONS_TABLE = "actions";
	public static final String PLACE_TABLE = "placelog";
	public static final int DATABASE_VERSION = "2";

	public static final String CREATE_ACTONS_TABLE = "create table if not exist actions (id integer primary key autoincrement, "
			+ "title VARCHAR not null, msg VARCHAR, place VARCHAR, ddate date, ttime time);";

	
	private final Context context;
	
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter (Context ctx){
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
		
	}
	
	private static class DataDatabaseHelper extends SQLiteOpenHelper {

		public DataDatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(CREATE_ACTONS_TABLE);
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}











