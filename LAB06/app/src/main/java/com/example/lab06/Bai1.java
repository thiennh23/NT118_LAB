package com.example.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Bai1 extends AppCompatActivity {
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        initBroadcastReceiver();
    }

    //Auto regis and delete broadcastREceiver when resume or stop activity


    @Override
    protected void onResume() {
        super.onResume();

        //Make sure that broadcast receiver is created
        if (broadcastReceiver == null){
            initBroadcastReceiver();
        }

        //Register BroadcastReceiver
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregis when app is destroy
        unregisterReceiver(broadcastReceiver);
    }

    //INIT BROADCAST
    public void initBroadcastReceiver(){
        //create filter to listen to sms coming
        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        //create broadcast receiver
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                processReceive(context, intent);
            }
        };
    }

    //Proccess when the sms comes
    public void processReceive(Context context, Intent intent){
        Toast.makeText(context, getString(R.string.you_have_a_new_message), Toast.LENGTH_LONG).show();

        TextView tvContent = (TextView) findViewById(R.id.tv_content);

        final String SMS_EXTRA = "pdus";
        Bundle bundle = intent.getExtras();
        Object [] messages = (Object[]) bundle.get(SMS_EXTRA);
        String sms = "";

        SmsMessage smsMessage;
        for (int i = 0; i < messages.length; i++){
            if (Build.VERSION.SDK_INT >= 23){
                smsMessage = SmsMessage.createFromPdu((byte[]) messages[i], "");
            }
            else smsMessage = SmsMessage.createFromPdu((byte[]) messages[i]);

            //GET MESSAGE BODY
            String smsBody = smsMessage.getMessageBody();
            //GET SOURCE ADDRESS FROM THE SMS
            String address = smsMessage.getDisplayOriginatingAddress();
            sms+=address + ":\n" + smsBody + ":\n";
        }

        //Show sms in the textview
        tvContent.setText(sms);
    }
}