package com.manage.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.books.R;
import com.manage.controller.UserController;

/**
 *添加员工
*/
public class InsertActivity extends Activity {
	
	private EditText id;//编号
    private EditText name;//姓名
    private EditText department;//部门

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_insert);

        name= (EditText) findViewById(R.id.name);
        id= (EditText) findViewById(R.id.id);
        department= (EditText) findViewById(R.id.department);

        Button insert= (Button) findViewById(R.id.i_insert);
        insert.setOnClickListener(new ButtonListener());

    }

    /**
     * 插入按钮事件监听
     */
    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String username=name.getText().toString();
            String userid=id.getText().toString();
            String userdepartment=department.getText().toString();

            UserController userController =new UserController();
            if("".equals(username) || "".equals(userid) || "".equals(userdepartment)){
                new AlertDialog.Builder(InsertActivity.this).setMessage("员工信息不能为空").show();
            }else {
                if(userController.addUser(userid,username,userdepartment)){
                    id.setText("");
                    name.setText("");
                    department.setText("");
                    buildDialog();
                }else {
                    new AlertDialog.Builder(InsertActivity.this).setMessage("已经存在该员工").show();
                }
            }

        }

        /**
         * 弹出框  提示是返回首页还是继续插入
         */
        private void buildDialog(){
            AlertDialog.Builder builder=new AlertDialog.Builder(InsertActivity.this);
            builder.setTitle("插入成功，是否继续添加");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            builder.setPositiveButton("继续插入",null);
            builder.show();
        }

    }
}
