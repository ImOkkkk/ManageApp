package com.manage.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.books.R;
import com.manage.controller.AdminController;
import com.manage.db.DbConnection;

/**
 * 登录界面
 */
public class LoginActivity extends Activity {

    private EditText name;//姓名
    private EditText pwd;//密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        DbConnection.setContext(this.getApplicationContext());//创建数据库

        DbConnection conn = new DbConnection();
        SQLiteDatabase db = conn.getConnection();
        String sql = "insert into admin(id,name,password) values('001','admin','admin')";
        db.execSQL(sql);
        db.close();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        name = (EditText) findViewById(R.id.aname);
        pwd = (EditText) findViewById(R.id.apwd);

        //按钮
        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String adminName = name.getText().toString();
                String adminPwd = pwd.getText().toString();


                AdminController admin = new AdminController();
                // TODO Auto-generated method stub
                if ("".equals(adminName) || "".equals(adminPwd)) {
                    new AlertDialog.Builder(LoginActivity.this).setMessage("信息不能为空").show();
                } else {
                    if (admin.checkAdmin(adminName, adminPwd)) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    } else {
                        new AlertDialog.Builder(LoginActivity.this).setMessage("用户名或者密码错误").show();
                    }
                }

            }
        });
    }


}


