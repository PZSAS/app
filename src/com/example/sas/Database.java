package com.example.sas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	private static SQLiteDatabase db;
	private static final String DATABASE_NAME = "sas.db";
	private static final int DATABASE_VERSION = 1;
	
	private Cursor cs;
	
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase sdb){
		db = sdb;
		createTableUser();
		createTableLogin();
		createTableAddress();
		createTableDevice();
		createTableUserDevice();
		createTableApnea();
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(Database.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS todo");
		onCreate(database);
	}
	
	private void createTableUser() {
		final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS User ("
				+ "user_id INTEGER PRIMARY KEY," 
				+ "user_name TEXT NOT NULL," 
				+ "user_name2 TEXT,"
				+ "user_surname TEXT NOT NULL," 
				+ "user_PESEL TEXT NOT NULL," 
				+ "user_sex TEXT NOT NULL);";
		db.execSQL(CREATE_TABLE_LOGIN);
	}
	
	private void createTableLogin() {
		final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS Login ("
				+ "user_id INTEGER," 
				+ "login_name TEXT NOT NULL," 
				+ "login_password TEXT NOT NULL);";
		db.execSQL(CREATE_TABLE_LOGIN);
	}
	
	private void createTableAddress() {
		final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS Address ("
				+ "address_id INTEGER PRIMARY KEY," 
				+ "user_id INTEGER," 
				+ "address_type TEXT NOT NULL," 
				+ "address_place TEXT NOT NULL,"
				+ "address_street TEXT NOT NULL,"
				+ "address_building TEXT NOT NULL,"
				+ "address_flat TEXT NOT NULL);";
		db.execSQL(CREATE_TABLE_LOGIN);
	}
	
	private void createTableDevice() {
		final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS Device ("
				+ "device_id INTEGER PRIMARY KEY," 
				+ "device_name TEXT NOT NULL," 
				+ "device_address TEXT NOT NULL);";
		db.execSQL(CREATE_TABLE_LOGIN);
	}
	
	private void createTableUserDevice() {
		final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS UserDevice ("
				+ "user_id INTEGER," 
				+ "device_id INTEGER);";
		db.execSQL(CREATE_TABLE_LOGIN);
	}
	
	private void createTableApnea() {
		final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS Apnea ("
				+ "apnea_id INTEGER PRIMARY KEY," 
				+ "file_name TEXT NOT NULL," 
				+ "apnea_timestamp INTEGER,"
				+ "apnea_duration INTEGER);";
		db.execSQL(CREATE_TABLE_LOGIN);
	}
}
