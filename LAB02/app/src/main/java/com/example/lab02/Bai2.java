//TRUONG HOP 4
package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Bai2 extends AppCompatActivity {
    EditText etId;
    EditText etName;
    RadioButton rd_FT, rdBtnKhong;
    RadioGroup rgType;
    Button btnadd;
    ListView lv_person;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;
    Employee employee;
    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        etId = (EditText) findViewById(R.id.edtName);
        etName = (EditText) findViewById(R.id.edtName2);
        rgType = (RadioGroup) findViewById(R.id.rgType);
        btnadd = (Button) findViewById(R.id.btnAdd);
        lv_person = (ListView) findViewById(R.id.lv_person);
        label = findViewById(R.id.tv_person);
        employees = new ArrayList<Employee>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employees);
        lv_person.setAdapter(adapter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etId.getText().toString().isEmpty() || etName.getText().toString().isEmpty())
                {}
                else {
                    int radId = rgType.getCheckedRadioButtonId();
                    String id = etId.getText().toString();
                    String name = etName.getText().toString();
                    if (radId == R.id.rd_FT) {
                        //create instance: Fulltime
                        employee = new EmployeeFulltime();
                    } else {
                        //create instance: parttime
                        employee = new EmployeeParttime();
                    }

                    employee.setId(id);
                    employee.setName(name);
                    //add employee into ArrayList
                    employees.add(employee);
                    //Update UI
                    adapter.notifyDataSetChanged();
                    etId.getText().clear();
                    etName.getText().clear();
                }
            }
        });

        lv_person.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                String value = lv_person.getItemAtPosition(position).toString();
                label.setText("Position:" + position + " ; Value: " + value);
            }
        });
        lv_person.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                employees.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}