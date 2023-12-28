package com.example.broadcastservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("phone_number")) {
            String phoneNumber = intent.getStringExtra("phone_number");
            phoneNumberTextView.setText(phoneNumber);
        }
    }
}
