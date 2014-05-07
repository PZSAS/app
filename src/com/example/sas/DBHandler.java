package com.example.sas;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBHandler {
	private SQLiteDatabase sdb;
	private Database db;
	private Context context;
	
	public DBHandler(Context context){
		this.context = context;
	}
	
	public DBHandler open() throws SQLException {
		db = new Database(context);
		sdb = db.getWritableDatabase();
		return this;
	}
	
	public void close(){
		sdb.close();
	}
	
	public void setLogin(int id,String name,String pass){
		String q = "INSERT OR REPLACE INTO Login ("
        		+ "user_id,"
        		+ "login_name,"
        		+ "login_password) "
        	+ "VALUES ("
        		+ "'"+id+"',"
        		+ "'"+name+"',"
        		+ "'"+pass+"');";
		sdb.execSQL(q);
	}
	
	public Cursor getLogin(int id){
		String q = "SELECT "
				+ "user_id,"
				+ "login_name,"
				+ "login_password "
			+ "FROM login "
				+ "WHERE user_id = " + id + ";";
		Cursor c = sdb.rawQuery(q, null);	
		return c;
	}
	
	public Cursor listLogin(){
		String q = "SELECT "
				+ "user_id,"
				+ "login_name,"
				+ "login_password "
			+ "FROM login;";
		Cursor c = sdb.rawQuery(q, null);	
		return c;
	}
}
