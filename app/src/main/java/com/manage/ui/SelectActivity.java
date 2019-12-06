package com.manage.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.books.R;
import com.manage.controller.UserController;
import com.manage.domain.User;

import java.util.ArrayList;

/**
 * 查询员工界面
 */
public class SelectActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        UserController userController =new UserController();
        ArrayList<User> user= userController.getAllUser();
        creatTable(user);

    }

    private void creatTable(ArrayList<User> userList){
        TableLayout tableLayout= (TableLayout) findViewById(R.id.ALLBOOKLAYOUT);
        for ( int i = 0; i <userList.size() ; i++ ) {
            User book=userList.get(i);

            TableRow row=new TableRow(this);
            TextView TVid=new TextView(this);
            TextView TVname=new TextView(this);
            TextView TVprice=new TextView(this);

            TVid.setText(book.getId());
            TVname.setText(book.getName());
            TVprice.setText(book.getDepartment());

            row.addView(TVid);
            row.addView(TVname);
            row.addView(TVprice);

            tableLayout.addView(row);

        }
    }
}
