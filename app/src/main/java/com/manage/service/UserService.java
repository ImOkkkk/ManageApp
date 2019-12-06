package com.manage.service;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.manage.db.DbConnection;
import com.manage.domain.User;

import java.util.ArrayList;

/**
 * Created by Lwy on 2019/11/29.
 */

public class UserService {
    private DbConnection dbConnection;
    private ArrayList<User> userList = new ArrayList<User>();

    /**
     * 静态成员方法：负责初始化
     *
     * @return
     */
    public ArrayList<User> getUserList() {
        //查询显示员工信息
        DbConnection connection = new DbConnection();
        SQLiteDatabase db = connection.getConnection();
        Cursor cursor = db.query("user", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idnum = cursor.getColumnIndex("id");
            int namenum = cursor.getColumnIndex("name");
            int departmentnum = cursor.getColumnIndex("department");

            String id = cursor.getString(idnum);
            String name = cursor.getString(namenum);
            String department = cursor.getString(departmentnum);

            User user = new User(id, name, department);
            userList.add(user);
            cursor.moveToNext();

        }
        db.close();
        return userList;
    }


    /**
     * 添加员工时查找id（员工编号）是否存在
     */
    private boolean checkId(String userId) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (userId.equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找员工所在位置
     */
    private int getIndex(String userid) {
        for (int i = 0; i < userList.size(); i++) {
            User b = userList.get(i);
            if (userid.equals(b.getId())) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 检查员工名称是否存在，是则移除
     */
    public boolean checkName(String name) {
        for (int i = 0; i < userList.size(); i++) {
            User b = userList.get(i);
            if (name.equals(b.getName())) {
                userList.remove(i);
                return true;
            }
        }
        return false;

    }

    /**
     * 插入员工方法
     */
    public boolean insert(User user) {

        if (checkId(user.getId())) {
            return false;
        } else {
            userList.add(user);
            DbConnection conn = new DbConnection();
            SQLiteDatabase db = conn.getConnection();
            String sql = "insert into user(id,name,department) values('" + user.getId() + "','" + user.getName() + "','" + user.getDepartment() + "')";
            db.execSQL(sql);
            db.close();
        }
        return true;
    }

    /**
     * 删除员工方法
     */
    public boolean delete(String name) {
        if (checkName(name)) {
            DbConnection conn = new DbConnection();
            SQLiteDatabase db = conn.getConnection();
            String sql = "delete from user where name='" + name + "'";
            db.execSQL(sql);
            db.close();
            return true;
        }
        return false;
    }

    /**
     * 修改员工方法
     */
    public boolean set(User user) {
        if (checkId(user.getId())) {
            int index = getIndex(user.getId());
            userList.get(index).setName(user.getName());
            userList.get(index).setDepartment(user.getDepartment());

            DbConnection conn = new DbConnection();
            SQLiteDatabase db = conn.getConnection();
            String sql = "update user set name='" + user.getName() + "',department='" + user.getDepartment() + "' where id='" + user.getId() + "'";

            db.execSQL(sql);
            db.close();
            return true;
        }
        return false;
    }
}
