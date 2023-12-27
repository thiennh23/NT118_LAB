package com.example.lab03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class EmployeePageFragment extends Fragment {
    private Employee employee;
    private TextView textViewEmail;
    private TextView textViewPosition;
    private TextView textViewFullName;

    private static int counter = 0;
    public EmployeePageFragment(Employee employee) {
        this.employee = employee;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.fragment_bai4, container, false);

        counter++;
        if(counter % 2 != 0) {
            view.setBackgroundColor(Color.parseColor("#ebdef0"));
        } else  {
            view.setBackgroundColor(Color.parseColor("#e8f8f5"));
        }

        this.textViewFullName = view.findViewById(R.id.textView_fullName);
        this.textViewPosition = view.findViewById(R.id.textView_position);
        this.textViewEmail = view.findViewById(R.id.textView_email);
        this.textViewFullName.setText(employee.getFullName());
        this.textViewPosition.setText(employee.getPosition());
        this.textViewEmail.setText(employee.getEmail());
        return view;
    }
}