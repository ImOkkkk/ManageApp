package com.manage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbConnection extends SQLiteOpenHelper{

	private final static int DATABASE_VERSION=1;//数据库版本号
	private final static String DATABASE_NAME="manage.db";//数据库名
	private static Context context;         //context对象


	public DbConnection(){
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}

	public static Context getContext() {
		return context;
	}

	public static void setContext(Context context) {
		DbConnection.context = context;
	}

	public SQLiteDatabase getConnection(){
		SQLiteDatabase db=getWritableDatabase();
		return db;
	}

	@Override
	//创建数据表user
	public void onCreate(SQLiteDatabase db) {
		String sql="create table user("+"id varchar(30) not null,"
				+" name varchar(30) not null,"
				+" department varchar(30) not null);";
		String sql2="create table admin("+"id varchar(30) not null,"
				+" name varchar(30) not null,"
				+" password varchar(30) not null);";
		db.execSQL(sql);
		db.execSQL(sql2);
	}

	//数据库升级(版本更新等)
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void close(SQLiteDatabase db){
		db.close();
	}

}
