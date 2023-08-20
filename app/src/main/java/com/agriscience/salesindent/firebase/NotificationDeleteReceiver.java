package com.agriscience.salesindent.firebase;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.agriscience.salesindent.AppSharedPreferences;

public class NotificationDeleteReceiver extends BroadcastReceiver {

    AppSharedPreferences sessionManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        sessionManager.put_notify_count(0);
    }
}
