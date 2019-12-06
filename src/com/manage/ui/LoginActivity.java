package com.manage.ui;

import com.example.books.R;
import com.manage.controller.AdminController;
import com.manage.controller.Controller;
import com.manage.db.DbConnection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 登录界面
 */
public class LoginActivity extends Activity {

	private EditText name;//姓名
	private EditText pwd;//密码

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		DbConnection.setContext(this.getApplicationContext());//创建数据库

		//		  DbConnection conn=new DbConnection();
		//      SQLiteDatabase db=conn.getConnection();
		//      String sql="insert into user(id,name,department) values('1','小米','技术部')";
		//      String sql2="insert into admin(id,name,password) values('001','admin','12345')";
		//      db.execSQL(sql);
		//      db.execSQL(sql2);
		//      db.close();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);



		name= (EditText) findViewById(R.id.aname);	
		pwd= (EditText) findViewById(R.id.apwd);

		//按钮
		Button login= (Button) findViewById(R.id.login);

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String adminName=name.getText().toString();
				String adminPwd=pwd.getText().toString();


				System.out.println(adminName+""+adminPwd);

				AdminController admin=new AdminController();
				// TODO Auto-generated method stub
				if("".equals(adminName) || "".equals(adminPwd)){
					new AlertDialog.Builder(LoginActivity.this).setMessage("信息不能为空").show();
				}else {
					if(admin.checkAdmin(adminName,adminPwd)){
						Intent intent=new Intent(getApplicationContext(),MainActivity.class);
						startActivity(intent);
						LoginActivity.this.finish();
					}else {
						new AlertDialog.Builder(LoginActivity.this).setMessage("用户名或者密码错误").show();
					}
				}

			}
		});				
	}


}


