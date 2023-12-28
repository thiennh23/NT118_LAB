package com.example.broadcastservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SmsReceiver", "SMS Received");

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            if (pdus != null) {
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }

                if (messages.length > 0) {
                    String phoneNumber = messages[0].getOriginatingAddress();
                    launchMainActivity(context, phoneNumber);
                }
            }
        }
    }

    private void launchMainActivity(Context context, String phoneNumber) {
        Intent mainIntent = new Intent(context, MainActivity.class);
        mainIntent.putExtra("phone_number", phoneNumber);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mainIntent);
    }
}
