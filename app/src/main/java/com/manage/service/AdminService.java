package com.manage.service;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.manage.db.DbConnection;

/**
 * Created by Lwy on 2019/11/29.
 */

public class AdminService {
    private DbConnection dbConnection;
    public AdminService(){
        dbConnection=new DbConnection();
    }
    public boolean check(String name,String password){
        SQLiteDatabase db=dbConnection.getConnection();
        String sql="select * from admin where name=? and password=?";
        Cursor cursor=db.rawQuery(sql, new String[]{name,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;

    }
}
