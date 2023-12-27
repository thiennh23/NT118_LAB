package com.example.btth6_2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    private PowerStateChangeReceiver powerStateChangeReceiver;
    private IntentFilter powerFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BATTERY_STATS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.BATTERY_STATS}, 25);
        }
        initPowerStateChangeReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (powerStateChangeReceiver == null) initPowerStateChangeReceiver();
        registerReceiver(powerStateChangeReceiver, powerFilter);
    }

    private void initPowerStateChangeReceiver() {
        powerFilter = new IntentFilter();
        powerFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        powerFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        powerStateChangeReceiver = new PowerStateChangeReceiver();
    }
}
