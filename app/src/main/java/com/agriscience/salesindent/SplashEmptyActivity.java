package com.agriscience.salesindent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.agriscience.salesindent.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class SplashEmptyActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SOME_FEATURES_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        check_permissions();
    }

    private void check_permissions() {
        if (Build.VERSION.SDK_INT >= 23) {

            int internet = checkSelfPermission(Manifest.permission.INTERNET);
            int network_state = checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE);
            int fine_location = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
            int coarse_location = checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);
            int read_external = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            int write_external = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int read_phone = checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
            int access_wifi = checkSelfPermission(Manifest.permission.ACCESS_WIFI_STATE);
            int change_wifi = checkSelfPermission(Manifest.permission.CHANGE_WIFI_STATE);
            int write_settings = checkSelfPermission(Manifest.permission.WRITE_SETTINGS);
            int install_packages = checkSelfPermission(Manifest.permission.INSTALL_PACKAGES);
            int req_install_packages = checkSelfPermission(Manifest.permission.REQUEST_INSTALL_PACKAGES);

            List<String> permission = new ArrayList<>();
            if (internet != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.INTERNET);
            }
            if (network_state != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.ACCESS_NETWORK_STATE);
            }
            if (fine_location != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (coarse_location != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if (read_external != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (write_external != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (read_phone != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.READ_PHONE_STATE);
            }
            if (access_wifi != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.ACCESS_WIFI_STATE);
            }
            if (change_wifi != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.CHANGE_WIFI_STATE);
            }
            if (write_settings != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.WRITE_SETTINGS);
            }
            if (install_packages != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.INSTALL_PACKAGES);
            }
            if (req_install_packages != PackageManager.PERMISSION_GRANTED) {
                permission.add(Manifest.permission.REQUEST_INSTALL_PACKAGES);
            }

            if (!permission.isEmpty()) {
                requestPermissions(permission.toArray(new String[permission.size()]),
                        REQUEST_CODE_SOME_FEATURES_PERMISSIONS);
            }else {
                after();
            }
        }else {
            after();
        }
    }

    private void after() {
        Intent i = new Intent(SplashEmptyActivity.this , LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_SOME_FEATURES_PERMISSIONS:
                {
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    {
                        Log.v("Permissions", "Permission Granted: " + permissions[i]);
                    }
                    else if (grantResults[i] == PackageManager.PERMISSION_DENIED)
                    {
                        Log.v("Permissions", "Permission Denied: " + permissions[i]);
                    }
                }
                after();

            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
}
