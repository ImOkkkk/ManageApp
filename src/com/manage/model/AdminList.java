package com.manage.domain;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.manage.db.DbConnection;

import java.util.ArrayList;


public class AdminList extends ArrayList<Admin> {
    private static AdminList adminList=null;
    private AdminList(){
    	
    }

    
    public static AdminList getAdminList(){
        if(null==adminList){

            synchronized ( AdminList.class ){
                if(null==adminList){
                	adminList=new AdminList();
                }
            }
       
        DbConnection connection=new DbConnection();
        SQLiteDatabase db=connection.getConnection();
        Cursor cursor=db.query("admin",null,null,null,null,null,null);
        while ( cursor.moveToNext() ){
            int idnum=cursor.getColumnIndex("id");
            int namenum=cursor.getColumnIndex("name");
            int pricenum=cursor.getColumnIndex("password");

            String id=cursor.getString(idnum);
            String name=cursor.getString(namenum);
            String password=cursor.getString(pricenum);

            Admin admin=new Admin(id,name,password);
            adminList.add(admin);
            cursor.moveToNext();

        }
        db.close();

        }
        return adminList;
    }
    
    public boolean check(String name,String password){
        for ( int i = 0; i <adminList.size() ; i++ ) {
            Admin b=adminList.get(i);
            if(name.equals(b.getName()) && password.equals(b.getPassword())){
            	adminList.remove(i);
                return true;
            }
        }
        return false;

    }
    
}
