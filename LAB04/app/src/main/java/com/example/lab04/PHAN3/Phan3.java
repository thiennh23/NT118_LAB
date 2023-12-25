package com.example.lab04.PHAN3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab04.R;

import java.util.List;

public class Phan3 extends AppCompatActivity {
    private RecyclerView rView;
    private StudentAdapter adapter;
    private Button btnAdd;
    private EditText edName;
    private EditText edEmail;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phan3);
        StudentDB db = new StudentDB(this);
        db.deleteAllContacts();

        rView = findViewById(R.id.recyclerView);
        adapter = new StudentAdapter(this);
        adapter.setDB(db);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rView.setLayoutManager(linearLayoutManager);

        db.addStudent(new Student(1,"Ravi", "Ravi@gmail.com", "9100000000"));
        db.addStudent(new Student(2,"Srinivas", "Sri@gmail.com", "9199999999"));
        db.addStudent(new Student(3,"Tommy", "Tom@gmail.com", "9522222222"));
        db.addStudent(new Student(4,"Karthik", "Kar@gmail.com", "9533333333"));

        List<Student> students = db.getAllStudents();

        adapter.setData(students);
        rView.setAdapter(adapter);

        btnAdd = findViewById(R.id.btnAdd);
        edName = findViewById(R.id.eTName);
        edEmail = findViewById(R.id.eTEmail);
        edPhone = findViewById(R.id.editTextPhone);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edName.getText().length() == 0 || edEmail.getText().length() == 0||edPhone.getText().length() == 0)
                {
                    Toast toast = Toast.makeText(Phan3.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    Student new_stu = new Student(edName.getText().toString(), edEmail.getText().toString(), edPhone.getText().toString());
                    db.addStudent(new_stu);
                    students.add(new_stu);
                    adapter.setData(students);
                    adapter.notifyDataSetChanged();
                    edName.setText("");
                    edEmail.setText("");
                    edPhone.setText("");
                }
            }
        });
    }
}