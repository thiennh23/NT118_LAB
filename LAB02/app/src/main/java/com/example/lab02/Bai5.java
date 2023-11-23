package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class Bai5 extends AppCompatActivity {
    EditText edtName;
    CheckBox chbxManager;
    Button btnAdd;
    RecyclerView rcv_Employee;
    ArrayList<Bai5_Employee> bai5Employees;
    Bai5_EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai5_employee);
        EditText edtID = findViewById(R.id.edtId);

        edtName = findViewById(R.id.edtName);
        chbxManager = findViewById(R.id.chbxManager);
        btnAdd = findViewById(R.id.btnAdd);
        rcv_Employee = findViewById(R.id.rcv_Employee);
        bai5Employees = new ArrayList<Bai5_Employee>();

        adapter = new Bai5_EmployeeAdapter(this, R.layout.bai5_item_employee, bai5Employees);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Employee.setLayoutManager(linearLayoutManager);
        rcv_Employee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String id = edtID.getText().toString();
                Bai5_Employee bai5Employee = new Bai5_Employee();
                if (chbxManager.isChecked())
                {
                    bai5Employee.setManager(true);
                }
                else
                {
                    bai5Employee.setManager(false);
                }
                bai5Employee.setFullName(name);
                //Đưa employee vào ArrayList
                bai5Employees.add(bai5Employee);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
            }
        });
    }
}