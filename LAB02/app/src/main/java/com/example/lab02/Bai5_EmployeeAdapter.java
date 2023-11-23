package com.example.lab02;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public  class Bai5_EmployeeAdapter extends  RecyclerView.Adapter<Bai5_EmployeeAdapter.EmployeeHolder>{
    private Activity context=null;
    private int layoutID;
    private List<Bai5_Employee> mListBai5Employee =null;

    public Bai5_EmployeeAdapter(Activity context, int layoutID, List<Bai5_Employee> mListBai5Employee) {
        this.context = context;
        this.layoutID = layoutID;
        this.mListBai5Employee = mListBai5Employee;
    }

    public List<Bai5_Employee> getmListEmployee() {
        return mListBai5Employee;
    }

    public void setmListEmployee(List<Bai5_Employee> mListBai5Employee) {
        this.mListBai5Employee = mListBai5Employee;
    }
    class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView tvFullName, tvPosition;
        ImageView ivManager;
        LinearLayout llParent;
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.item_employee_tv_fullname);
            tvPosition = itemView.findViewById(R.id.item_employee_tv_position);
            ivManager = itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = itemView.findViewById(R.id.item_employee_ll_parent);
        }

    }
    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bai5_item_employee, null,
                false);
        return new EmployeeHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Bai5_Employee bai5Employee = mListBai5Employee.get(position);
        if (bai5Employee == null ) {
            return;
        }
        if (bai5Employee.getFullName()!=null) {
            holder.tvFullName.setText(bai5Employee.getFullName());
        }
        else holder.tvFullName.setText("");
        // If this is a manager -> show icon manager. Otherwise, show Staff in tvPosition
        if (bai5Employee.isManager())
        {
            holder.ivManager.setVisibility(View.VISIBLE);
            holder.tvPosition.setVisibility(View.GONE);
        }
        else
        {
            holder.ivManager.setVisibility(View.GONE);
            holder.tvPosition.setVisibility(View.VISIBLE);
            holder.tvPosition.setText(context.getString(R.string.staff));
        }
        // Show different color backgrounds for 2 continuous employees
        if (position%2==0)
        {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {

            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return mListBai5Employee.size();
    }
}