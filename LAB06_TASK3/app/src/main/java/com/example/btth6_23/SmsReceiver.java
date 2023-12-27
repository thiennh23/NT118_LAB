package com.example.btth6_23;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.util.ArrayList;

public class SmsReceiver  extends BroadcastReceiver {

    public static final String SMS_FORWARD_BROADCAST_RECEIVER = "sms_forward_broadcast_receiver";
    public static final String SMS_MESSAGE_ADDRESS_KEY = "sms_messages_key";

    @Override
    public void onReceive (Context context, Intent intent) {
        String queryString = "Are you OK?".toLowerCase();
        System.out.println("________" + queryString);

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            ArrayList<String> addresses = new ArrayList<>();

            for (SmsMessage message : messages) {

                if (message.getMessageBody().toLowerCase().contains(queryString)) {
                    addresses.add(message.getOriginatingAddress());
                }
            }
            if (addresses.size() > 0) {
                if (!MainActivity.isRunning) {
                    Intent iMain = new Intent(context,MainActivity.class);
                    iMain.putStringArrayListExtra(SMS_MESSAGE_ADDRESS_KEY, addresses);
                    iMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
                    context.sendBroadcast(iMain);
                    context.startActivity(iMain);
                } else {
                    Intent iForwardBroadcastReceiver = new Intent(SMS_FORWARD_BROADCAST_RECEIVER);

                    iForwardBroadcastReceiver.putStringArrayListExtra(SMS_MESSAGE_ADDRESS_KEY, addresses);
                    context.sendBroadcast(iForwardBroadcastReceiver);
                }
            }
        }
    }
}