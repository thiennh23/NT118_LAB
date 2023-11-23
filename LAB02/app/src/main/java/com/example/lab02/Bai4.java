package com.example.lab02;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai4 extends AppCompatActivity {
    Spinner spinnerMonAn;
    Bai4_SpinnerAdapter bai4SpinnerAdapter;
    Bai4_Food res_monan;
    Button btnAdd;
    GridView gvDish;
    EditText edtName;
    ArrayList<Bai4_Food> arrayMonan;
    ArrayList<Bai4_Food> monanGv;
    Bai4_FoodAdapter adapter;
    CheckBox chbxPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4_main);


        arrayMonan = new ArrayList<Bai4_Food>();
        arrayMonan.add(new Bai4_Food("Thumbnail 1", R.drawable.thumbnail1));
        arrayMonan.add(new Bai4_Food("Thumbnail 2", R.drawable.thumbnail2));
        arrayMonan.add(new Bai4_Food("Thumbnail 3", R.drawable.thumbnail3));
        arrayMonan.add(new Bai4_Food("Thumbnail 4", R.drawable.thumbnail4));

        //final List<String> thumbnails = Arrays.asList("cake", "candy", "chocolate", "icecream", "omelette");
        spinnerMonAn = (Spinner) findViewById(R.id.spinner);

        bai4SpinnerAdapter = new Bai4_SpinnerAdapter(getApplicationContext(), R.layout.bai4_dropdown_item, arrayMonan);
        spinnerMonAn.setAdapter(bai4SpinnerAdapter);


        spinnerMonAn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Bai4.this, "Added successfully", Toast.LENGTH_SHORT).show();
                res_monan = arrayMonan.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        chbxPromotion = (CheckBox) findViewById(R.id.checkBox) ;
        btnAdd  = (Button) findViewById(R.id.btnAdd) ;
        gvDish = (GridView) findViewById(R.id.gvDish);

        edtName = (EditText) findViewById(R.id.edtName);
        monanGv = new ArrayList<Bai4_Food>();
        adapter = new Bai4_FoodAdapter(this, R.layout.bai4_item_food,monanGv);
        gvDish.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                Bai4_Food monan = new Bai4_Food();
                monan.setName(name);

                monan.setThumbnail(res_monan.getThumbnail());

                if (chbxPromotion.isChecked())
                {
                    monan.setPromotion(true);
                }
                else
                {
                    monan.setPromotion(false);
                }

                monanGv.add(monan);
                edtName.setText("");
                spinnerMonAn.setSelection(0);
                chbxPromotion.setChecked(false);
                adapter.notifyDataSetChanged();
                Toast.makeText(Bai4.this, "Added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}