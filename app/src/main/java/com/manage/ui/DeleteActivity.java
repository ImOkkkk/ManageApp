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
 * 功能：删除界面
 */
public class DeleteActivity  extends Activity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name= (EditText) findViewById(R.id.dname);
        Button delete= (Button) findViewById(R.id.d_delete);
        delete.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String userName=name.getText().toString().trim();
            UserController userController =new UserController();
            if("".equals(userName)){
                new AlertDialog.Builder(DeleteActivity.this).setMessage("员工姓名不能为空").show();
            }else {
                if(userController.deleteUser(userName)){
                    name.setText("");
                    buildDialog();
                }else {
                    new AlertDialog.Builder(DeleteActivity.this).setMessage("没有此员工").show();
                }
            }
        }

        /**
         * 弹出框  提示是返回首页还是继续插入
         */
        private void buildDialog(){
            AlertDialog.Builder builder=new AlertDialog.Builder(DeleteActivity.this);
            builder.setTitle("删除成功，是否继续添加");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            builder.setPositiveButton("继续删除",null);
            builder.show();
        }

    }
}
