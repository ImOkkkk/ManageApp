package com.manage.ui;

import com.example.books.R;
import com.manage.controller.Controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 *修改员工信息界面
 **/
public class SetActivity  extends Activity {

	//类属性
    private EditText name;
    private EditText id;
    private EditText department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        name= (EditText) findViewById(R.id.sname);
        id= (EditText) findViewById(R.id.sid);
        department= (EditText) findViewById(R.id.sdepartment);

        Button set= (Button) findViewById(R.id.s_set);
        set.setOnClickListener(new SetActivity.ButtonListener());

    }

    public class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String username=name.getText().toString();
            String userid=id.getText().toString();
            String userdepartment=department.getText().toString();

            Controller controller=new Controller();
            if("".equals(username) || "".equals(userid) || "".equals(userdepartment)){
                new AlertDialog.Builder(SetActivity.this).setMessage("员工信息不能为空").show();
            }else {
                if(controller.setUser(userid,username,userdepartment)){
                    id.setText("");
                    name.setText("");
                    department.setText("");
                    buildDialog();
                }else {
                    new AlertDialog.Builder(SetActivity.this).setMessage("不存在该员工,请输入正确的员工编号").show();
                }
            }
        }

        /**
         * 弹出框  提示是返回首页还是继续插入
         */
        private void buildDialog(){
            AlertDialog.Builder builder=new AlertDialog.Builder(SetActivity.this);
            builder.setTitle("修改成功，是否继续添加");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            builder.setPositiveButton("继续修改",null);
            builder.show();
        }

    }
}
