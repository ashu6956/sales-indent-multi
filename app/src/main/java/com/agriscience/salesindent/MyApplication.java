package com.agriscience.salesindent;

import android.app.Application;

import com.agriscience.salesindent.ConnectivityReceiver;

/**
 * Created by Kanagaraj.M on 05/02/2018.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
