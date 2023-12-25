package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai3 extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btn = findViewById(R.id.btnBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai3.this, Bai1Bai2.class);
                startActivity(intent);
               /* // Animation for moving from right to left
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);*/
            }
        });
    }
}