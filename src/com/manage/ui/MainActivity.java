package com.manage.ui;


import com.example.books.R;
import com.manage.db.DbConnection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemLongClickListener;


/**
 * 功能：主界面
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		DbConnection.setContext(this.getApplicationContext());//创建数据库

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//按钮
		Button insert= (Button) findViewById(R.id.m_insert);
		Button delete= (Button) findViewById(R.id.m_delete);
		Button set= (Button) findViewById(R.id.m_set);
		Button select= (Button) findViewById(R.id.m_select);
		Button quit= (Button) findViewById(R.id.m_quit);

		//按钮监听
		ButtonListener buttonListener=new ButtonListener();
		insert.setOnClickListener(buttonListener);
		delete.setOnClickListener(buttonListener);
		set.setOnClickListener(buttonListener);
		select.setOnClickListener(buttonListener);
		quit.setOnClickListener(buttonListener);

	}

	 /**
     * 按钮监听类
     */
	class ButtonListener implements View.OnClickListener{

		 /**
         * 页面跳转
         */
		@Override
		public void onClick(View v) {
			int id= v.getId();
			Intent intent=new Intent();
			switch ( id ){
			case R.id.m_insert:
				//添加员工界面
				intent.setClass(MainActivity.this,InsertActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.m_delete:
				//删除员工界面
				intent.setClass(MainActivity.this,DeleteActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.m_set:
				//修改员工界面
				intent.setClass(MainActivity.this,SetActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.m_select:
				//查询员工界面
				intent.setClass(MainActivity.this,SelectActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.m_quit:
				//退出
				buildDialog();
				break;

			}
		}
	}

	/**
	 * 弹出框  提示是退出程序还是继续操作
	 */
	private void buildDialog(){
		AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("确定要退出吗？");
		builder.setNegativeButton("确定",
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});

		builder.setPositiveButton("取消",null);
		builder.show();
	}


}


