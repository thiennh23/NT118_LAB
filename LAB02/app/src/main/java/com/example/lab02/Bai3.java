package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai3 extends AppCompatActivity {

    Button btnAdd;
    ListView lv_Employee;
    ArrayList<Bai3_Employee> bai3Employees;
    EditText edtName;
    CheckBox chbxManager;
    Bai3_EmployeeAdapter adapter;
    EditText edtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        edtName = findViewById(R.id.edtName);
        chbxManager = findViewById(R.id.chbxManager);
        btnAdd =  findViewById(R.id.btnAdd);
        lv_Employee = findViewById(R.id.lv_Employee);
        bai3Employees = new ArrayList<Bai3_Employee>();
        edtID = findViewById(R.id.edtId);

        adapter = new Bai3_EmployeeAdapter(this, R.layout.bai3_item, bai3Employees);
        lv_Employee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String id = edtID.getText().toString();
                if (!name.isEmpty() && !id.isEmpty())
                {
                    Bai3_Employee bai3Employee = new Bai3_Employee();
                    if (chbxManager.isChecked())
                    {
                        bai3Employee.setManager(true);
                    }
                    else
                    {
                        bai3Employee.setManager(false);
                    }
                    bai3Employee.setFullName(name);
                    //employee => ArrayList
                    bai3Employees.add(bai3Employee);
                    //update UI
                    adapter.notifyDataSetChanged();
                    edtID.getText().clear();
                    edtName.getText().clear();
                    Toast.makeText(Bai3.this, "ADDED SUCCESSFULLY!", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(Bai3.this, "FILL IN THE BOX PLEASE!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}