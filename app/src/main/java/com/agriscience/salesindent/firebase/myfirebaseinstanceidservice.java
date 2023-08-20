package com.agriscience.salesindent.firebase;//package kanagaraj.salesindent.firebase;
//import android.content.Context;
//import android.content.SharedPreferences;
//
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.FirebaseInstanceIdService;
//
//import com.agriscience.salesindent.R;
//
//
//public class myfirebaseinstanceidservice extends FirebaseInstanceIdService {
//
//    @Override
//    public void onTokenRefresh() {
//
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PRE), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.putString(getString(R.string.FCM_TOKEN),refreshedToken);
//        editor.apply();
//
//
//    }
//}
