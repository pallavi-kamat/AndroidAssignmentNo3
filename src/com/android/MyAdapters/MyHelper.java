package com.android.MyAdapters;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "ListDatabase";
	private static final int DATABASE_VERSION = 1;
	
	public MyHelper(Activity context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE list (name TEXT PRIMARY KEY,"
					+ "age INTEGER );");
			db.execSQL("CREATE TABLE info (name TEXT PRIMARY KEY,"+"emailId TEXT,"
					+ "age INTEGER,"+"gender TEXT);");					
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
