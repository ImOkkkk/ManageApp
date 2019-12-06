package com.manage.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.books.R;
import com.manage.controller.Controller;
import com.manage.domain.User;
import com.manage.domain.UserList;

/**
 * 查询员工界面
 */
public class SelectActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Controller controller=new Controller();
        UserList books=controller.getAllUser();
        creatTable(books);

    }

    private void creatTable(UserList userList){
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
