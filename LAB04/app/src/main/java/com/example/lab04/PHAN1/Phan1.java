package com.example.lab04.PHAN1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;

public class Phan1 extends AppCompatActivity {

    private DbAdapter dbAdapter;
    private Cursor cursor;
    private List<String> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phan1);
        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        dbAdapter.deleteAllUsers();
        for (int i = 0; i < 10; i++) {
            dbAdapter.createUser("Nguyễn Hữu Thiện " + i);
        }
        users = getData();
        showData();
    }
    @SuppressLint("Range")
    private List<String> getData() {
        List<String> users = new ArrayList<>();
        cursor = dbAdapter.getAllUsers();
        while (cursor.moveToNext()) {

            users.add(cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NAME)));
            Log.e("Name: ", String.valueOf(users.size()));

        }
        Log.e("Name: ", String.valueOf(users.size()));
        return users;
    }
    private void showData() {
        ListView lvUser = (ListView) findViewById(R.id.lv_user);
        ArrayAdapter<String> userAdapter = new
                ArrayAdapter<String>(Phan1.this, R.layout.item_user, users);
        lvUser.setAdapter(userAdapter);
    }
}