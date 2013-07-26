 package com.g6.georeminderv2;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	public static final String DATABASE_NAME = "GeoReminderDB";

	// Reminder Notification table name

	// it has 4 colums,
	// 1. id(which is auto increamented)
	// 2. title
	// 3. msg
	// 4. place
	// 5. time

	private static final String TABLE_ACTIONS = "ACTIONS";

	// Places table name
	// it has 4 colums,
	// 1. for id(which is auto increamented)
	// 2.for place name
	// 3. for pace longitude
	// 4.for place latitude
	private static final String TABLE_PLACES = "ACTIONS";

	// Actions Table Columns names
	public static final String KEY_ACTIONS_ID = "aid";
	public static final String KEY_ACTOINS_TITLE = "title";
	public static final String KEY_ACTIONS_MSG = "msg";
	public static final String KEY_ACTIONS_PLACE_NAME = "pname";
	public static final String KEY_ACTIONS_PLACE_LONG = "plong";
	public static final String KEY_ACTIONS_PLACE_LAT = "plat";
	public static final String KEY_ACTIONS_DATE = "date";
	public static final String KEY_ACTIONS_TIME = "time";
	public static final String KEY_ACTIONS_TAG = "actions_tag";

	// Place Table Columns names
	public static final String KEY_PLACE_ID = "pid";
	public static final String KEY_PLACES_NAME = "pname";
	public static final String KEY_PLACE_LONG = "pplong";
	public static final String KEY_PLACE_LAT = "pplat";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_ACTIONS_TABLE = "CREATE TABLE " + TABLE_ACTIONS + "("
				+ KEY_ACTIONS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ACTOINS_TITLE
				+ " VARCHAR," + KEY_ACTIONS_MSG + " VARCHAR" + KEY_ACTIONS_DATE
				+ " DATE" + KEY_ACTIONS_TIME + " TEXT" + KEY_ACTIONS_PLACE_LONG
				+ " LONG" + KEY_ACTIONS_PLACE_LAT + " LONG" + ")";

		try {
			db.execSQL(CREATE_ACTIONS_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String CREATE_PLACE_TABLE = "CREATE TABLE " + TABLE_PLACES + "("
				+ KEY_PLACE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_PLACES_NAME
				+ " VARCHAR," + KEY_PLACE_LONG + " LONG" + KEY_PLACE_LAT + ")";

		try {
			db.execSQL(CREATE_PLACE_TABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		
		try {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIONS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACES);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new actions
	void addRemAction(RemActions remaction) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ACTOINS_TITLE, remaction.getTitle()); // Action title
		values.put(KEY_ACTIONS_MSG, remaction.getMsg()); // action msg
		values.put(KEY_ACTIONS_DATE, remaction.getDate()); // action date
		values.put(KEY_ACTIONS_TIME, remaction.getTime()); // action time
		values.put(KEY_ACTIONS_PLACE_LONG, remaction.getPlong()); // action place long
		values.put(KEY_ACTIONS_PLACE_LAT, remaction.getPlat());  // action place lat

		// Inserting Row
		db.insert(TABLE_ACTIONS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single action
	RemActions getRemAction(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_ACTIONS, new String[] {KEY_ACTOINS_TITLE, KEY_ACTIONS_MSG, KEY_PLACES_NAME, KEY_ACTIONS_DATE, KEY_ACTIONS_TIME}, KEY_ACTIONS_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		RemActions remActions = new RemActions(cursor.getString(0),
				cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
		// return remActions
		return remActions;
	}

	// Getting All RemActions
	public List<RemActions> getAllActions() {
		List<RemActions> actionList = new ArrayList<RemActions>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_ACTIONS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				RemActions remActions = new RemActions();
				remActions.setTitle(cursor.getString(0));
				remActions.setMsg(cursor.getString(1));
				remActions.setPlace(cursor.getString(2));
				remActions.setDate(cursor.getString(3));
				remActions.setTime(cursor.getString(4));
				
				// Adding remActions to list
				actionList.add(remActions);
			} while (cursor.moveToNext());
		}

		// return remActions list
		return actionList;
	}

	// Updating single remActions
	public int updateRemAction(RemActions remActions) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ACTOINS_TITLE, remActions.getTitle());
		values.put(KEY_ACTIONS_MSG, remActions.getMsg());
		values.put(KEY_ACTIONS_DATE, remActions.getDate()); // action date
		values.put(KEY_ACTIONS_TIME, remActions.getTime()); // action time
		values.put(KEY_ACTIONS_PLACE_LONG, remActions.getPlong()); // action place long
		values.put(KEY_ACTIONS_PLACE_LAT, remActions.getPlat());  // action place lat


		// updating row
		return db.update(TABLE_ACTIONS, values, KEY_ACTIONS_ID + " = ?",
				new String[] { String.valueOf(remActions.getAid()) });
		db.close();
	}

	// Deleting single remActions
	public void deleteRemAction(RemActions remActions) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_ACTIONS, KEY_ACTIONS_ID + " = ?",
				new String[] { String.valueOf(remActions.getAid()) });
		db.close();
	}

}
