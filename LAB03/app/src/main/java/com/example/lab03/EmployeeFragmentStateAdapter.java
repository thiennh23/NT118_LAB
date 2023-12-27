package com.example.lab03;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class EmployeeFragmentStateAdapter extends FragmentStateAdapter {
    private List<Employee> employees;


    public EmployeeFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<Employee>employees) {
        super(fragmentActivity);

        this.employees = employees;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Employee employee = this.employees.get(position);
        return new EmployeePageFragment(employee);
    }


    @Override
    public int getItemCount() {
        return this.employees.size();
    }
}
