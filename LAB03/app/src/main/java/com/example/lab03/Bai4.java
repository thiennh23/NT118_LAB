package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Bai4 extends AppCompatActivity {
    private ViewPager2 viewPager2Employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        this.viewPager2Employee = findViewById(R.id.vPager);
        Employee emp1 = new Employee("Elizabeth Johnson", "elizabethjohnson@example.com", "Project Manager");
        Employee emp2 = new Employee("Catherine Johnson", "catherinejohnson@example.com", "President of Sales");
        Employee emp3 = new Employee("Michael Smith", "michaelsmith@example.com", "Software Engineer");
        Employee emp4 = new Employee("Jennifer Davis", "jenniferdavis@example.com", "Marketing Specialist");
        Employee emp5 = new Employee("Christopher Lee", "christopherlee@example.com", "Data Analyst");
        Employee emp6 = new Employee("Amanda Miller", "amandamiller@example.com", "Financial Analyst");
        Employee emp7 = new Employee("Robert Brown", "robertbrown@example.com", "HR Coordinator");
        Employee emp8 = new Employee("Emily White", "emilywhite@example.com", "Quality Assurance Tester");

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        list.add(emp7);
        list.add(emp8);
        // Employee FragmentStateAdapter.
        EmployeeFragmentStateAdapter adapter = new EmployeeFragmentStateAdapter(this, list);
        this.viewPager2Employee.setAdapter(adapter);
    }
}