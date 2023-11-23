package com.example.lab02;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Bai4_SpinnerAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Bai4_Food> arrMonan;

    // Constructor accepts Context (from MainActivity) and a list of state abbreviations

    public Bai4_SpinnerAdapter(Context context, int layout, ArrayList<Bai4_Food> arrMonan) {
        this.context = context;
        this.layout = layout;
        this.arrMonan = arrMonan;
    }


    // Override these methods and instead return our custom view (with image and text)

    @Override
    public int getCount() {
        return arrMonan.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.bai4_dropdown_item, parent, false);


        // Image and TextViews
        TextView thbName = row.findViewById(R.id.thbnailText);
        ImageView flag = row.findViewById(R.id.thbnailImage);

        // Get flag image from drawables folder

        Drawable drawable = context.getResources().getDrawable(arrMonan.get(position).getThumbnail());

        //Set state abbreviation and state flag
        thbName.setText(arrMonan.get(position).getName());
        flag.setImageDrawable(drawable);

        return row;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.bai4_dropdown_item, parent, false);

        TextView thbName = row.findViewById(R.id.thbnailText);


        thbName.setText(arrMonan.get(position).getName());

        return row;
    }

}
