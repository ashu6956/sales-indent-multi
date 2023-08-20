package com.agriscience.salesindent;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.Retrofit.versionn;
import com.agriscience.salesindent.am.AMScreenActivity;
import com.agriscience.salesindent.dbm.DBMScreenActivity;
import com.agriscience.salesindent.model.LoginDetailsResponse;
import com.agriscience.salesindent.model.LoginResponse;
import com.agriscience.salesindent.model.ZOrganogramResponse;
import com.agriscience.salesindent.rbm.RBMScreenActivity;
import com.agriscience.salesindent.room_database.SalesIndentDataBase;
import com.agriscience.salesindent.tm.TMScreenActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ConnectivityReceiver.ConnectivityReceiverListener {

    private ApiInterface apiInterface;


    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;
    String myJSON;
    private static final String TAG_RESULTS1 = "result";
    private static final String ID = "Id";
    private static final String EMP_CODE = "EmpCode";
    private static final String EMP_NAME = "EmpName";
    private static final String TERRITORY_NAME = "TerritoryName";
    private static final String PASSWORD = "Password";
    private static final String POS_CODE = "POSCode";
    private static final String TAG_RESULTS = "result";
    private static final String T2 = "A";
    private static final String T3 = "B";
    private static final String T4 = "C";
    private static final String T5 = "D";
    private static final String T6 = "E";
    private static final String T7 = "F";
    private static final String T8 = "G";
    private static final String T9 = "H";
    private static final String T10 = "I";
    private static final String T11 = "J";
    private static final String T12 = "K";
    private static final String T13 = "L";
    private static final String T14 = "M";
    private static final String T15 = "N";
    private static final String T16 = "O";
    private static final String T17 = "P";
    private static final String T18 = "Q";
    private static final String T19 = "R";
    private static final String T20 = "S";
    private static final String T21 = "T";
    private static final String T22 = "U";
    private static final String T23 = "V";
    private static final String T24 = "W";
    private static final String T25 = "X";
    private static final String T26 = "Y";
    private static final String T27 = "Z";
    private static final String USER_STATUS = "UserStatus";
    private static final String SITE = "Site";
    private static final String WAREHOUSE = "Warehouse";
    private static final String ACTING = "Acting";
    private static final String DCODE = "Dcode";
    private static final String DEVICE_ID = "DeviceId";
    private static final String INVENT_SITE = "InventSite";
    private static final int REQUEST_CODE_SOME_FEATURES_PERMISSIONS = 1;
    EditText etUserId, etPassword;
    String PoCodes = "";
    String Passwords = "";
    String POCodeTransfer = "";
    String PONameTransfer = "";
    String TerritoryNameTransfer = "";
    String PostCodeTransfer = "";
    String SiteTransfer = "";
    String DCode = "";
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    PendingResult<LocationSettingsResult> result;
    final static int REQUEST_LOCATION = 199;
    AppLocationService appLocationService;


    String Check = "";


    TextView totcounts, update;
    ProgressDialog prgDialog;

    ProgressDialog prgDialogUpdate;
    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;
    // Connection detector class
    WIFIInternetConnectionDetector cd;

    File ISIndentCodeFile = null;
    File ISIndentCodeFile1 = null;

    TextView HyperLink;
    TextView textDeviceID;
    String UserStatusCheck;
    String VersionAndroid, VersionServer;
    File ISLoginMaster = null;
    //    String IPAddress;
    public static String IPAddress = "http://103.44.97.110:8080/kanagaraj/";
    String UpdateNumberSequence = "";
    String UpdateNumberSequence1 = "";
    CheckBox cbVeg, cbFC;
    String DivisionCheckBoxValue = "";
    String DivisionTransfer = "";
    String Acting = "";
    String ProjectFolder = "";
    AppSharedPreferences appSharedPreferences;
    TelephonyManager telephonyManager;
    private SQLiteDatabase dbNumberSequence;
    private Cursor GetCursordbNumberSequence;
    CheckBox mCbShowPwd;
    File GoTOTMCheck = null;
    TextView snackbar_text;
    TextView version;

    int versioncode = 0;
    public static int version_to_login = 1;

    String versioncodefromserver = "";
    String Upadatedlinkfromserver = "";

    public static ImageButton imageButton15;
    public static ImageView googleupdatebtn;

    versionn VersionBody;
    private static int DM01_value = 0;

    //Firebase
    private FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
    private HashMap<String, Object> firebaseDefaultMap;
    private final String LAST_APP_VERSION_KEY = "latestappversion";

    LinearLayout linear_layout, linearupdate;
    TextView updatetext;

    private int getcurrentversioncode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void checkForUpdate() {
        int latestAppVersion = (int) mFirebaseRemoteConfig.getDouble(LAST_APP_VERSION_KEY);
        if (latestAppVersion > getcurrentversioncode()) {
            imageButton15.setVisibility(View.GONE);
            linear_layout.setVisibility(View.GONE);
            linearupdate.setVisibility(View.VISIBLE);
            updatetext.setVisibility(View.VISIBLE);

        } else {
//            Toast.makeText(this, "This app is already upto date", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        version = findViewById(R.id.version);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        callZOrganogramApi();
        //for update using firebase
        firebaseDefaultMap = new HashMap<>();
        firebaseDefaultMap.put(LAST_APP_VERSION_KEY, getcurrentversioncode());

        mFirebaseRemoteConfig.setDefaults(firebaseDefaultMap);
        mFirebaseRemoteConfig.setConfigSettings(
                new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(true)
                        .build());

        mFirebaseRemoteConfig.fetch().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    mFirebaseRemoteConfig.activateFetched();
                    Log.d("Login", "Fetched value: " + mFirebaseRemoteConfig.getString(LAST_APP_VERSION_KEY));
                    //calling function to check if new version is available or not
                    checkForUpdate();
                } else {
                    Toast.makeText(LoginActivity.this, "Someting went wrong please try again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        imageButton15 = findViewById(R.id.imageButton15);
        googleupdatebtn = findViewById(R.id.googleimageupdate);
        googleupdatebtn.setVisibility(View.GONE);
//        versiongetting();

        appLocationService = new AppLocationService(LoginActivity.this);

        linear_layout = findViewById(R.id.linear_layout);
        linearupdate = findViewById(R.id.linearupdate);
        updatetext = findViewById(R.id.updatetext);


        etUserId = (EditText) findViewById(R.id.etUserId);
        etUserId.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        etPassword = (EditText) findViewById(R.id.etPassword);
//        etPassword.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        snackbar_text = (TextView) findViewById(R.id.snackbar_text);


        cbVeg = (CheckBox) findViewById(R.id.cbVeg);
        cbFC = (CheckBox) findViewById(R.id.cbFC);
        cbFC.setClickable(false);
        cbVeg.setClickable(false);

        appSharedPreferences = new AppSharedPreferences(this);
        appSharedPreferences.put_notify_count(0);

        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));

        updatetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }

            }
        });

        // checkwifi ();

        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        VersionAndroid = pInfo.versionName;
        etUserId.setTypeface(Typeface.SERIF);
        etPassword.setTypeface(Typeface.SERIF);

        etUserId.setHint("User Id");
        etPassword.setHint("Password");

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();
        mGoogleApiClient.connect();


        //retrieve a reference to an instance of TelephonyManager
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        textDeviceID.setText(getDeviceID(telephonyManager));

        checkConnection();
//        POLoginFileCheck();
        checkUserWithSharedPreferences();


        addTextChangeListener();

        mCbShowPwd = (CheckBox) findViewById(R.id.cbShowPwd);
        // add onCheckedListener on checkbox
        // when user clicks on this checkbox, this is the handler.
        mCbShowPwd.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // checkbox status is changed from uncheck to checked.
            if (!isChecked) {
                // show password
                etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                // hide password
                etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
    }

    public void callZOrganogramApi() {
        Call<ZOrganogramResponse> call = apiInterface.getZOrganogramDetails();
        call.enqueue(new Callback<ZOrganogramResponse>() {
            @Override
            public void onResponse(Call<ZOrganogramResponse> call, Response<ZOrganogramResponse> response) {
                Log.d("TMScreenActivity", response.code() + "" + response.body().toString());
                ZOrganogramResponse zOrganogramResponse = response.body();

                if (zOrganogramResponse.getResponse() != null && zOrganogramResponse.getResponse().size() > 0) {
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        zOrganogramResponse.getResponse().stream().forEach(zOrganogramResponseDetails -> SalesIndentDataBase.getDataBase(LoginActivity.this).zOrganogramDetailsDao().insertAll(zOrganogramResponseDetails));
                        Log.d("TMScreenActivity fetch from DB", SalesIndentDataBase.getDataBase(LoginActivity.this).zOrganogramDetailsDao().getAllZOrganogramReponseDetails().toString());
                    });

                }
            }

            @Override
            public void onFailure(Call<ZOrganogramResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }

    private void addTextChangeListener() {
        etUserId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO document why this method is empty
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO document why this method is empty
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // TODO document why this method is empty
                String userId = editable.toString();
                Log.d("afterTextChanged", userId);
            }
        });
    }


    public void versiongetting() {
        Call<versionn> call = apiInterface.getversion("");
        call.enqueue(new Callback<versionn>() {
            @Override
            public void onResponse(Call<versionn> call, Response<versionn> response) {
                VersionBody = response.body();
                if (VersionBody == null) {
                    Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                } else {
                    String versionyretro = VersionBody.getV();
                    String versionylinkretro = VersionBody.getL();

                    versioncodefromserver = versionyretro;
                    Upadatedlinkfromserver = versionylinkretro;
                    saveVersionNameAndCode(LoginActivity.this);
                }

            }

            @Override
            public void onFailure(Call<versionn> call, Throwable t) {

            }
        });

    }

    private void link() {
        if (ISLoginMaster.exists()) {
            Intent intent = new Intent(this, PasswordChange.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "No Record Found", Toast.LENGTH_LONG).show();
        }
    }

    protected void showList() {
        try {
            Check = "";
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(ID);
                String Pocodess = c.getString(EMP_CODE);
                String Ponames = c.getString(EMP_NAME);
                String TerritoryNameS = c.getString(TERRITORY_NAME);
                String Passwordss = c.getString(PASSWORD);
                String POSCodes = c.getString(POS_CODE);
                String UserStatus = c.getString(USER_STATUS);
                String Site = c.getString(SITE);
                String Warehouse = c.getString(WAREHOUSE);
                String indent_site = c.getString(INVENT_SITE);

                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(ID, Id);
                persons.put(EMP_CODE, Pocodess);
                persons.put(EMP_NAME, Ponames);
                persons.put(TERRITORY_NAME, TerritoryNameS);
                persons.put(PASSWORD, Passwordss);
                persons.put(POS_CODE, POSCodes);
                persons.put(USER_STATUS, UserStatus);
                persons.put(SITE, Site);
                persons.put(WAREHOUSE, Warehouse);
                persons.put(INVENT_SITE, indent_site);

                if (UserStatus.equals("ACTIVE")) {
                    UserStatusCheck = "UserStatusCheckfile".toString();
                    if (Pocodess.trim().toString().equals(PoCodes) && Passwordss.trim().toString().equals(Passwords)) {
                        Check = "chckfile".toString();
                        POCodeTransfer = Pocodess.toString();
                        PONameTransfer = Ponames.toString();
                        TerritoryNameTransfer = TerritoryNameS.toString();
                        PostCodeTransfer = POSCodes.toString();
                        SiteTransfer = Site.toString();
                    }
                }
            }

            if (Check.equals("chckfile")) {
                prgDialog.hide();
                if (PostCodeTransfer.equals("TM")) {
                    Log.d("intent--------------", "-----TM------3---------");

                    Intent intent = new Intent(this, TMScreenActivity.class);
                    intent.putExtra("Po_code", POCodeTransfer);
                    intent.putExtra("Po_name", PONameTransfer);
                    intent.putExtra("Tm_name", TerritoryNameTransfer);
                    intent.putExtra("Post_code", PostCodeTransfer);
                    intent.putExtra("Site_ID", SiteTransfer);
                    intent.putExtra("Division_code", DivisionTransfer);
                    intent.putExtra("Action_Code", Acting);
                    intent.putExtra("D_Code", DCode);
                    startActivity(intent);
                } else if (PostCodeTransfer.equals("RBM")) {
                    Intent intent = new Intent(this, RBMScreenActivity.class);
                    intent.putExtra("Po_code", POCodeTransfer);
                    intent.putExtra("Po_name", PONameTransfer);
                    intent.putExtra("Tm_name", TerritoryNameTransfer);
                    intent.putExtra("Post_code", PostCodeTransfer);
                    intent.putExtra("Site_ID", SiteTransfer);
                    intent.putExtra("Division_code", DivisionTransfer);
                    intent.putExtra("Action_Code", Acting);
                    intent.putExtra("D_Code", DCode);
                    startActivity(intent);
                }
//                else if (PostCodeTransfer.equals("DBM") )
                else if (PostCodeTransfer.equals("ZM")) {
                    if (DM01_value == 1) {
                        appSharedPreferences.put_ZM("login_ZM");


                        appSharedPreferences.putUserId(POCodeTransfer);
                        appSharedPreferences.putName(PONameTransfer);
                        appSharedPreferences.Tm_name(TerritoryNameTransfer);
                        appSharedPreferences.Post_code(PostCodeTransfer);
                        appSharedPreferences.Site_ID(SiteTransfer);
                        appSharedPreferences.Division_code(DivisionTransfer);
                        appSharedPreferences.Action_Code(Acting);
                        appSharedPreferences.D_Code(DCode);
                    }
                    Log.d("intent--------------", "-----------4---------");
                    Intent intent = new Intent(this, DBMScreenActivity.class);
                    intent.putExtra("Po_code", POCodeTransfer);
                    intent.putExtra("Po_name", PONameTransfer);
                    intent.putExtra("Tm_name", TerritoryNameTransfer);
                    intent.putExtra("Post_code", PostCodeTransfer);
                    intent.putExtra("Site_ID", SiteTransfer);
                    intent.putExtra("Division_code", DivisionTransfer);
                    intent.putExtra("Action_Code", Acting);
                    intent.putExtra("D_Code", DCode);
                    startActivity(intent);
                } else {
                    showAlertDialog1(LoginActivity.this, "User Not Authorized", false);
                }
            } else {
                //Toast.makeText(getApplicationContext(), "UserName Password Incorrect",   Toast.LENGTH_SHORT).show();
                //showAlertDialog1(LoginActivity.this, "UserId  or Password Incorrect", false);
                etUserId.setError("UserId Incorrect!");
                etPassword.setError("Password Incorrect!");
                // Passwords.setText("");
                prgDialog.hide();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(30 * 1000);
        mLocationRequest.setFastestInterval(5 * 1000);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);

        //  result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                //final LocationSettingsStates state = result.getLocationSettingsStates();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        // All location settings are satisfied. The client can initialize location
                        // requests here.
                        //...
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        // Location settings are not satisfied. But could be fixed by showing the user
                        // a dialog.
                        try {
                            // Show the dialog by calling startResolutionForResult(),
                            // and check the result in onActivityResult().
                            status.startResolutionForResult(
                                    LoginActivity.this,
                                    REQUEST_LOCATION);
                        } catch (IntentSender.SendIntentException e) {
                            // Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        // Location settings are not satisfied. However, we have no way to fix the
                        // settings so we won't show the dialog.
                        //...
                        break;
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("onActivityResult()", Integer.toString(resultCode));

        //final LocationSettingsStates states = LocationSettingsStates.fromIntent(data);
        switch (requestCode) {
            case REQUEST_LOCATION:
                switch (resultCode) {
                    case Activity.RESULT_OK: {
                        // All required changes were successfully made
                        // Toast.makeText(MainActivity.this, "Location enabled by user!", Toast.LENGTH_LONG).show();

                        break;
                    }
                    case Activity.RESULT_CANCELED: {
                        // The user was asked to change settings, but chose not to
                        //  Toast.makeText(MainActivity.this, "Location not enabled, user cancelled.", Toast.LENGTH_LONG).show();
                        //  finish();

                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onLoginButtonClick(View View) {

        PoCodes = etUserId.getText().toString();
        Passwords = etPassword.getText().toString();


        //code hidden
        if (version_to_login == 1) {
            snackbar_text.setVisibility(View.GONE);
            imageButton15.setVisibility(android.view.View.VISIBLE);
            googleupdatebtn.setVisibility(View.GONE);

            if (PoCodes.trim().length() > 0) {
                if (Passwords.trim().length() > 0) {
//                    if (ISLoginMaster.exists()) {
//                        ISloginMasterOffline();
//                    } else {
//                        UpdateCheckOnline();
//                    }


                    HashMap<String, String> loginMap = new HashMap<>();
                    loginMap.put("username", PoCodes);
                    loginMap.put("password", Passwords);

                    if (prgDialog != null) {
                        prgDialog.show();
                    }
                    callLoginApi(loginMap);


//                    if (DivisionCheckBoxValue.trim().length() > 0) {
//                        if (DivisionCheckBoxValue.equals("Cotton")) {
//                            ProjectFolder = "SalesIndentCotton";
//                        } else {
//                            ProjectFolder = "SalesIndentFieldCrop";
//                        }
//                        if (ISLoginMaster.exists()) {
//                            ISloginMasterOffline();
//                        } else {
//                            UpdateCheckOnline();
//                        }
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Please Tick Division", Toast.LENGTH_LONG).show();
//                    }
                } else {
                    etPassword.setError("Please Enter Password");
                }
            } else {
                etUserId.setError("Please Enter User ID");
            }
        } else if (version_to_login == 0) {
            String message = "New Update Available...Click to Update";
            int colors = Color.WHITE;
            snackbar_text.setBackgroundColor(Color.parseColor("#FFEC1934"));
            prgDialog.hide();
            snackbar_text.setVisibility(View.VISIBLE);
            snackbar_text.setTextColor(colors);
            snackbar_text.setText(message);
            imageButton15.setVisibility(android.view.View.GONE);
            googleupdatebtn.setVisibility(View.VISIBLE);
        }
    }


    private void callLoginApi(HashMap<String, String> loginMap) {
        apiInterface.getLoginDetails(loginMap).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (prgDialog != null) {
                    prgDialog.hide();
                }
                LoginResponse loginResponse = response.body();
                if (loginResponse != null && loginResponse.isSuccess()) {
                    LoginDetailsResponse detailsResponse = loginResponse.getData();
                    appSharedPreferences.putUserId(detailsResponse.getUserName());
                    appSharedPreferences.putLoginRole(detailsResponse.getRole());
                    appSharedPreferences.putName(detailsResponse.getName());
                    appSharedPreferences.putIsTM(detailsResponse.isTM());
                    appSharedPreferences.putIsAM(detailsResponse.isAM());
                    appSharedPreferences.putIsRbM(detailsResponse.isRbM());
                    appSharedPreferences.putIsDbM(detailsResponse.isDbM());
                    redirectBasedOnRole(detailsResponse.getRole(), detailsResponse.getUserName(), detailsResponse.getName());
                } else {
                    Toast.makeText(LoginActivity.this,"Invalid username or password.", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                if (prgDialog != null) {
                    prgDialog.hide();
                }
                Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void redirectBasedOnRole(String role, String userName, String name) {
        if (role.equalsIgnoreCase("Tm")) {
            Intent intent = new Intent(LoginActivity.this, TMScreenActivity.class);
            intent.putExtra("Po_code", userName);
            intent.putExtra("Po_name", name);
            startActivity(intent);
        } else if (role.equalsIgnoreCase("Am")) {
            Intent intent = new Intent(LoginActivity.this, AMScreenActivity.class);
            intent.putExtra("Po_code", userName);
            intent.putExtra("Po_name", name);
            startActivity(intent);
        } else if (role.equalsIgnoreCase("Rbm")) {
            Intent intent = new Intent(LoginActivity.this, RBMScreenActivity.class);
            intent.putExtra("Po_code", userName);
            intent.putExtra("Po_name", name);
            startActivity(intent);
        } else if (role.equalsIgnoreCase("Dbm")) {
            Intent intent = new Intent(LoginActivity.this, DBMScreenActivity.class);
            intent.putExtra("Po_code", userName);
            intent.putExtra("Po_name", name);
            startActivity(intent);
        }
    }

    public void playstoreupdatelink(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Upadatedlinkfromserver)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Upadatedlinkfromserver)));
        }
    }

    public void ISloginMasterOffline() {
        Check = "";
        prgDialog.show();
        try {
            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader(new FileReader(ISLoginMaster));
            String line = "";

            int lineNumber = 0;


            //read comma separated file line by line
            while ((line = br.readLine()) != null) {
                lineNumber++;


                //use comma as token separator
                String[] country = line.split(",");

                Log.e("values_names", country[1].toString());

                if (country[1].toString().equals(PoCodes) && country[4].toString().equals(Passwords)) {
                    Check = "chckfile".toString();

                    POCodeTransfer = country[1].toString();
                    PONameTransfer = country[2].toString();
                    TerritoryNameTransfer = country[3].toString();
                    PostCodeTransfer = country[5].toString();
                    SiteTransfer = country[13].toString();
                    DivisionTransfer = country[15].toString();
                    Acting = country[16].toString();
                    DCode = country[18].toString();
                    try {
                        if (Acting.equals("TM")) {
                            appSharedPreferences.put_siteTM(country[19].toString());
                            appSharedPreferences.put_warehouseTM(country[20].toString());
                        } else {
                            appSharedPreferences.put_siteTM(country[19].toString());
                            appSharedPreferences.put_warehouseTM(country[20].toString());
                            appSharedPreferences.put_siteRBM(country[21].toString());
                            appSharedPreferences.put_warehouseRBM(country[22].toString());
                        }
                    } catch (Exception e) {
                        Log.e("offline", "data null " + e.toString());
                    }
                }
            }
//            APPOloginMasterGet();

            if (Check.equals("chckfile")) {
                prgDialog.hide();
                if (DCode.equals("TM")) {
                    prgDialog.hide();
                    Log.d("intent--------------", "-----TM------3---------");


                    Intent intent = new Intent(this, TMScreenActivity.class);
                    intent.putExtra("Po_code", POCodeTransfer);
                    intent.putExtra("Po_name", PONameTransfer);
                    intent.putExtra("Tm_name", TerritoryNameTransfer);
                    intent.putExtra("Post_code", PostCodeTransfer);
                    intent.putExtra("Site_ID", SiteTransfer);
                    intent.putExtra("Division_code", DivisionTransfer);
                    intent.putExtra("Action_Code", Acting);
                    intent.putExtra("D_Code", DCode);
                    startActivity(intent);
                } else if (DCode.equals("RBM")) {
                    prgDialog.hide();
                    Intent intent = new Intent(this, RBMScreenActivity.class);
                    intent.putExtra("Po_code", POCodeTransfer);
                    intent.putExtra("Po_name", PONameTransfer);
                    intent.putExtra("Tm_name", TerritoryNameTransfer);
                    intent.putExtra("Post_code", PostCodeTransfer);
                    intent.putExtra("Site_ID", SiteTransfer);
                    intent.putExtra("Division_code", DivisionTransfer);
                    intent.putExtra("Action_Code", Acting);
                    intent.putExtra("D_Code", DCode);
                    startActivity(intent);
                }
//             else if  (PostCodeTransfer.equals("DBM"))
                else if (DCode.equals("ZM")) {
                    prgDialog.hide();
                    if (DM01_value == 1) {
                        appSharedPreferences.put_ZM("login_ZM");


                        appSharedPreferences.putUserId(POCodeTransfer);
                        appSharedPreferences.putName(PONameTransfer);
                        appSharedPreferences.Tm_name(TerritoryNameTransfer);
                        appSharedPreferences.Post_code(PostCodeTransfer);
                        appSharedPreferences.Site_ID(SiteTransfer);
                        appSharedPreferences.Division_code(DivisionTransfer);
                        appSharedPreferences.Action_Code(Acting);
                        appSharedPreferences.D_Code(DCode);
                    }
                    Log.d("intent--------------", "-----------3---------");
                    Intent intent = new Intent(this, DBMScreenActivity.class);
                    intent.putExtra("Po_code", POCodeTransfer);
                    intent.putExtra("Po_name", PONameTransfer);
                    intent.putExtra("Tm_name", TerritoryNameTransfer);
                    intent.putExtra("Post_code", PostCodeTransfer);
                    intent.putExtra("Site_ID", SiteTransfer);
                    intent.putExtra("Division_code", DivisionTransfer);
                    intent.putExtra("Action_Code", Acting);
                    intent.putExtra("D_Code", DCode);
                    startActivity(intent);
                }
            } else {
                //Toast.makeText(getApplicationContext(), "UserName Password Incorrect",   Toast.LENGTH_SHORT).show();
                showAlertDialog1(LoginActivity.this, "UserId  or Password Incorrect123", false);
                // Passwords.setText("");
                prgDialog.hide();
            }
        } catch (Exception e) {
            //  System.err.println("CSV file cannot be read : " + e);
            //  Toast.makeText(getApplicationContext(), "CSV file  cannot be read or Opened ", Toast.LENGTH_LONG).show();
            prgDialog.hide();
        }
    }

    protected void showListonline() {
        try {
            UserStatusCheck = "";
            Check = "";

            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(ID);
                String Pocodess = c.getString(EMP_CODE);
                String Ponames = c.getString(EMP_NAME);
                String TerritoryNameS = c.getString(TERRITORY_NAME);
                String Passwordss = c.getString(PASSWORD);
                String POSCodes = c.getString(POS_CODE);
//                String POSCodes = c.getString(T34);
                String UserStatus = c.getString(USER_STATUS);
                String Site = c.getString(SITE);
                String Acting1 = c.getString(ACTING);
                String DCode = c.getString(DCODE);
                String WarehouseTM = null, WarehouseRBM = null;
                JSONObject ware_arr = c.getJSONObject(WAREHOUSE);
                if (DCode.equals("TM")) {
                    if (ware_arr.has("tm")) {
                        try {
                            JSONArray tm_arr = ware_arr.getJSONArray("tm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                JSONObject obj = tm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseTM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseTM = WarehouseTM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }

                        } catch (Exception e) {

                            JSONArray tm_arr = ware_arr.getJSONArray("tm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                JSONObject obj = tm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseTM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseTM = WarehouseTM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        }
                    }
                } else if (DCode.equals("RBM")) {
                    if (ware_arr.has("tm") || ware_arr.has("rbm")) {
                        try {
                            JSONArray tm_arr = ware_arr.getJSONArray("tm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                JSONObject obj = tm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseTM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseTM = WarehouseTM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }

                            JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                JSONObject obj = rbm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseRBM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseRBM = WarehouseRBM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                            JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                JSONObject obj = rbm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseRBM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseRBM = WarehouseRBM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        }
                    }
                } else if (DCode.equals("ZM")) {
                    if (ware_arr.has("zm")) {
                        try {
                            JSONArray tm_arr = ware_arr.getJSONArray("zm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                JSONObject obj = tm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseTM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseTM = WarehouseTM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        } catch (Exception e) {

                            JSONArray tm_arr = ware_arr.getJSONArray("zm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                JSONObject obj = tm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseTM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseTM = WarehouseTM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        }
                    } else if (ware_arr.has("tm") || ware_arr.has("rbm")) {
                        try {
                            JSONArray tm_arr = ware_arr.getJSONArray("tm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                JSONObject obj = tm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseTM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseTM = WarehouseTM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }

                            JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                JSONObject obj = rbm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseRBM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseRBM = WarehouseRBM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                            JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                JSONObject obj = rbm_arr.getJSONObject(j);
                                if (j == 0) {
                                    WarehouseRBM = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                } else {
                                    WarehouseRBM = WarehouseRBM + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                                }
                            }
                        }

                    }
                }

                String device_id = c.getString(DEVICE_ID);
                String invent_siteTM = null;
                String invent_siteRBM = null;
                JSONObject site_arr = c.getJSONObject(INVENT_SITE);
                if (DCode.equals("TM")) {
                    if (site_arr.has("tm")) {
                        JSONArray tm_arr = site_arr.getJSONArray("tm");
                        for (int j = 0; j < tm_arr.length(); j++) {
                            if (j == 0) {
                                invent_siteTM = tm_arr.get(j).toString();
                            } else {
                                invent_siteTM = invent_siteTM + "|" + tm_arr.get(j).toString();
                            }
                        }
                    }
                } else if (DCode.equals("RBM")) {
                    if (site_arr.has("tm") || site_arr.has("rbm")) {
                        try {
                            JSONArray tm_arr = site_arr.getJSONArray("tm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                if (j == 0) {
                                    invent_siteTM = tm_arr.get(j).toString();
                                } else {
                                    invent_siteTM = invent_siteTM + "|" + tm_arr.get(j).toString();
                                }
                            }

                            JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                if (j == 0) {
                                    invent_siteRBM = rbm_arr.get(j).toString();
                                } else {
                                    invent_siteRBM = invent_siteRBM + "|" + rbm_arr.get(j).toString();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                            JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                if (j == 0) {
                                    invent_siteRBM = rbm_arr.get(j).toString();
                                } else {
                                    invent_siteRBM = invent_siteRBM + "|" + rbm_arr.get(j).toString();
                                }
                            }
                        }
                    }
                } else if (DCode.equals("ZM")) {
                    if (site_arr.has("zm")) {
                        JSONArray rbm_arr = site_arr.getJSONArray("zm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            if (j == 0) {
                                invent_siteRBM = rbm_arr.get(j).toString();
                            } else {
                                invent_siteRBM = invent_siteRBM + "|" + rbm_arr.get(j).toString();
                            }
                        }
                    } else if (site_arr.has("tm") || site_arr.equals("rbm")) {
                        try {
                            JSONArray tm_arr = site_arr.getJSONArray("tm");
                            for (int j = 0; j < tm_arr.length(); j++) {
                                if (j == 0) {
                                    invent_siteTM = tm_arr.get(j).toString();
                                } else {
                                    invent_siteTM = invent_siteTM + "|" + tm_arr.get(j).toString();
                                }
                            }

                            JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                if (j == 0) {
                                    invent_siteRBM = rbm_arr.get(j).toString();
                                } else {
                                    invent_siteRBM = invent_siteRBM + "|" + rbm_arr.get(j).toString();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                            JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                            for (int j = 0; j < rbm_arr.length(); j++) {
                                if (j == 0) {
                                    invent_siteRBM = rbm_arr.get(j).toString();
                                } else {
                                    invent_siteRBM = invent_siteRBM + "|" + rbm_arr.get(j).toString();
                                }
                            }
                        }

                    }
                }

                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(ID, Id);
                persons.put(EMP_CODE, Pocodess);
                persons.put(EMP_NAME, Ponames);
                persons.put(TERRITORY_NAME, TerritoryNameS);
                persons.put(PASSWORD, Passwordss);
                persons.put(POS_CODE, POSCodes);
                persons.put(USER_STATUS, UserStatus);
                persons.put(SITE, Site);
                persons.put(WAREHOUSE, WarehouseTM);
                persons.put(INVENT_SITE, invent_siteTM);

                if (Pocodess.trim().toString().equals(PoCodes) && Passwordss.trim().toString().toUpperCase().equals(Passwords)) {

                    if (UserStatus.equals("ACTIVE")) {

                        UserStatusCheck = "UserStatusCheckfile".toString();
                        POCodeTransfer = Pocodess.toString();
                        PONameTransfer = Ponames.toString();
                        TerritoryNameTransfer = TerritoryNameS.toString();
//                        PostCodeTransfer = POSCodes.toString();
                        PostCodeTransfer = DCode.toString();
                        SiteTransfer = Site.toString();
                        Acting = Acting1.toString();
                        this.DCode = DCode.toString();
                        appSharedPreferences.put_dcode(DCode);
                        appSharedPreferences.put_siteTM(invent_siteTM);
                        appSharedPreferences.put_warehouseTM(WarehouseTM);
                        appSharedPreferences.put_siteRBM(invent_siteRBM);
                        appSharedPreferences.put_warehouseRBM(WarehouseRBM);


//                        folderDelete();
//                        UpdateImeiNo();
                        if (device_id.equals("null") || device_id.equals("")) {
                            UpdateImeiNo();
//                            APPOloginMasterGet();
                            Check = "chckfile".toString();
                            if (PostCodeTransfer.equals("TM")) {


//                                APPOloginMasterGet();
                                //  UpdateImeiNo();
                            }
//                        else if (PostCodeTransfer.equals("DBM") || PostCodeTransfer.equals("RBM"))
                            else if (PostCodeTransfer.equals("ZM") || PostCodeTransfer.equals("RBM")) {

//                                APPOloginMasterGet();
                                // UpdateImeiNo();

                            } else {
                            }
                        } else if (device_id.equals(getDeviceID(telephonyManager))) {
                            Check = "chckfile".toString();
                            if (PostCodeTransfer.equals("TM")) {
//                                APPOloginMasterGet();
                                //  UpdateImeiNo();

                            }
//                        else if (PostCodeTransfer.equals("DBM") || PostCodeTransfer.equals("RBM"))
                            else if (PostCodeTransfer.equals("ZM") || PostCodeTransfer.equals("RBM")) {
//                                APPOloginMasterGet();
                                // UpdateImeiNo();

                            } else {
                            }
                        } else {
//                            Check = "imei_not_match";
                            Check = "chckfile".toString();
                        }
                    }
                }
            }

            if (Check.equals("chckfile")) {
                if (UserStatusCheck.equals("UserStatusCheckfile")) {
                    prgDialog.hide();
                    if (PostCodeTransfer.equals("TM")) {

                        Log.d("intent--------------", "-----TM------1---------");

                        Intent intent = new Intent(this, TMScreenActivity.class);
                        intent.putExtra("Po_code", POCodeTransfer);
                        intent.putExtra("Po_name", PONameTransfer);
                        intent.putExtra("Tm_name", TerritoryNameTransfer);
                        intent.putExtra("Post_code", PostCodeTransfer);
                        intent.putExtra("Site_ID", SiteTransfer);
                        intent.putExtra("Division_code", DivisionTransfer);
                        intent.putExtra("Action_Code", Acting);
                        intent.putExtra("D_Code", DCode);
                        startActivity(intent);
                    } else if (PostCodeTransfer.equals("RBM")) {
                        Intent intent = new Intent(this, RBMScreenActivity.class);
                        intent.putExtra("Po_code", POCodeTransfer);
                        intent.putExtra("Po_name", PONameTransfer);
                        intent.putExtra("Tm_name", TerritoryNameTransfer);
                        intent.putExtra("Post_code", PostCodeTransfer);
                        intent.putExtra("Site_ID", SiteTransfer);
                        intent.putExtra("Division_code", DivisionTransfer);
                        intent.putExtra("Action_Code", Acting);
                        intent.putExtra("D_Code", DCode);
                        startActivity(intent);
                    }
//                    else if (PostCodeTransfer.equals("DBM") )
                    else if (PostCodeTransfer.equals("ZM")) {
                        if (DM01_value == 1) {
                            appSharedPreferences.put_ZM("login_ZM");


                            appSharedPreferences.putUserId(POCodeTransfer);
                            appSharedPreferences.putName(PONameTransfer);
                            appSharedPreferences.Tm_name(TerritoryNameTransfer);
                            appSharedPreferences.Post_code(PostCodeTransfer);
                            appSharedPreferences.Site_ID(SiteTransfer);
                            appSharedPreferences.Division_code(DivisionTransfer);
                            appSharedPreferences.Action_Code(Acting);
                            appSharedPreferences.D_Code(DCode);
                        }
                        Log.d("intent--------------", "-----------2---------");
                        Intent intent = new Intent(this, DBMScreenActivity.class);
                        intent.putExtra("Po_code", POCodeTransfer);
                        intent.putExtra("Po_name", PONameTransfer);
                        intent.putExtra("Tm_name", TerritoryNameTransfer);
                        intent.putExtra("Post_code", PostCodeTransfer);
                        intent.putExtra("Site_ID", SiteTransfer);
                        intent.putExtra("Division_code", DivisionTransfer);
                        intent.putExtra("Action_Code", Acting);
                        intent.putExtra("D_Code", DCode);

                        startActivity(intent);
                    } else {
                        showAlertDialog1(LoginActivity.this, "User Not Authorized", false);
                        prgDialog.hide();
                    }
                } else {
                    //Toast.makeText(getApplicationContext(), "UserName Password Incorrect",   Toast.LENGTH_SHORT).show();
                    showAlertDialog1(LoginActivity.this, "Left user for you", false);
                    // Passwords.setText("");
                    prgDialog.hide();
                }
            } else if (Check.equals("imei_not_match")) {
                showAlertDialog1(LoginActivity.this, "Wrong device login", false);
                prgDialog.hide();
            } else {
                //Toast.makeText(getApplicationContext(), "UserName Password Incorrect",   Toast.LENGTH_SHORT).show();
                showAlertDialog1(LoginActivity.this, "UserId  or Password Incorrect", false);
                // Passwords.setText("");
                prgDialog.hide();
            }
        } catch (JSONException e) {
            Log.e(TAG_RESULTS, e.toString());
            e.printStackTrace();
            prgDialog.hide();
        }
    }

//    public void POLoginOnline() {
//        isConnectionExist = cd.checkMobileInternetConn();
//        isConnectionExistMobile = cd.checkMobileInternetConns();
//        if (isConnectionExist || isConnectionExistMobile) {
//            PoCodes = etUserId.getText().toString();
//            Passwords = etPassword.getText().toString();
//            prgDialog.show();
//            class GetDataJSON extends AsyncTask<String, Void, String> {
//                @Override
//                protected String doInBackground(String... params) {
//                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                    HttpPost httppost = new HttpPost(IPAddress + "SalesIndentCotton" + "/ISLogin.php?EmpCode=" + PoCodes + "&password=" + Passwords);
//
//                    // Depends on your web service
//                    httppost.setHeader("Content-type", "application/json");
//
//                    InputStream inputStream = null;
//                    String result = null;
//                    try {
//                        HttpResponse response = httpclient.execute(httppost);
//                        HttpEntity entity = response.getEntity();
//
//                        inputStream = entity.getContent();
//                        // json is UTF-8 by default
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                        StringBuilder sb = new StringBuilder();
//                        // List<String> codes = new ArrayList<String>();
//                        // String line = null;
//                        String line = "";
//                        int lineNumber = 0;
//                        while ((line = reader.readLine()) != null) {
//                            sb.append(line + "\n");
//                        }
//                        result = sb.toString();
//                    } catch (Exception e) {
//
//                    } finally {
//                        try {
//                            if (inputStream != null) inputStream.close();
//                        } catch (Exception squish) {
//
//                        }
//                    }
//                    return result;
//                }
//
//                @Override
//                protected void onPostExecute(String result) {
//                    myJSON = result;
//                    try {
//                        // Log.e("login", myJSON);
//                        showListonline();
//                    } catch (Exception e) {
//                        Log.e(TAG_RESULTS, "error 1 ");
//                        // Log.e(TAG_RESULTS, "error 1 " + e.toString());
//                        prgDialog.cancel();
//                        Toast.makeText(LoginActivity.this, "Error1", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//            GetDataJSON g = new GetDataJSON();
//            g.execute();
//        } else {
//            //Internet connection doesn't exist
//            showAlertDialog(LoginActivity.this, "No Internet Connection",
//                    "Your device doesn't have WIFI or Data Plan internet access", false);
//            prgDialog.hide();
//        }
//    }

//    public void APPOloginMasterGet() {
//        prgDialog.show();
//        class GetDataJSON extends AsyncTask<String, Void, String> {
//
//            @Override
//            protected String doInBackground(String... params) {
//                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                // HttpPost httppost = new HttpPost("http://10.20.1.37:8080/kanagaraj/IndentSales/ISloginMasterFetch.php");
//
//                //   HttpPost httppost = new HttpPost(IPAddress+"/kanagaraj/IndentSales/ISloginMasterFetch.php");
//
//                // HttpPost httppost = new HttpPost(IPAddress + "/kanagaraj/"+ProjectFolder+"/ISloginMasterFetch.php");
//                ////                HttpPost httppost = new HttpPost(IPAddress +"/kanagaraj/"+ProjectFolder+"/ISloginMasterFetchNew.php?EmpCode="+PoCodes);
//                ////                HttpPost httppost = new HttpPost(new_api.ISloginMasterFetchNew(ProjectFolder ,PoCodes));
//
//                HttpPost httppost = new HttpPost(IPAddress + "SalesIndentCotton" + "/ISloginMasterFetchNew.php?EmpCode=" + PoCodes);
////                HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISloginMasterFetchNew.php?EmpCode=" + PoCodes);
//
//                // Depends on your web service
//                httppost.setHeader("Content-type", "application/json");
//
//                InputStream inputStream = null;
//                String result = null;
//                try {
//                    HttpResponse response = httpclient.execute(httppost);
//                    HttpEntity entity = response.getEntity();
//
//                    inputStream = entity.getContent();
//                    // json is UTF-8 by default
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                    StringBuilder sb = new StringBuilder();
//
//                    String line = null;
//                    while ((line = reader.readLine()) != null) {
//                        sb.append(line + "\n");
//                    }
//                    result = sb.toString();
//                } catch (Exception e) {
//                    // Oops
//                } finally {
//                    try {
//                        if (inputStream != null) inputStream.close();
//                    } catch (Exception squish) {
//                    }
//                }
//                return result;
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                myJSON = result;
//                try {
//                    Log.e("login", myJSON);
//                    showListevent3();
//                } catch (Exception e) {
//                    Log.e(TAG_RESULTS, "error2 " + e.toString());
//                    prgDialog.cancel();
//                    Toast.makeText(LoginActivity.this, "Error2", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//        GetDataJSON g = new GetDataJSON();
//        g.execute();
//    }

    protected void showListevent3() {
        //  prgDialog.show();
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(ID);
                String A = c.getString(T2);
                String B = c.getString(T3);
                String C = c.getString(T4);
                String D = c.getString(T5);
                String E = c.getString(T6);
                String F = c.getString(T7);
                String G = c.getString(T8);
                String H = c.getString(T9);
                String I = c.getString(T10);
                String J = c.getString(T11);
                String K = c.getString(T12);
                String L = c.getString(T13);
                String M = c.getString(T14);
                String N = c.getString(T15);
                String O = c.getString(T16);
                String P = c.getString(T17);
                String Q = c.getString(T18);
                String R = c.getString(T19);
                String S = c.getString(T20);
                /*    String T = c.getString(T21);
                String U = c.getString(T22);
                String V = c.getString(T23);
                String W = c.getString(T24);*/
                String V = null, X = null;
                JSONObject site_arr = null;
                try {
                    site_arr = c.getJSONObject(T25);
                    if (site_arr.length() == 0 || site_arr == null) {
                        DM01_value = 1;
                        Log.d("intent------", "String_of_X");
                        Log.d("intent------", "String_of_X_is_Fitted");

                    }

                    Log.d("intent------", "String_of_X_is_coming");
                } catch (JSONException e) {
                    e.printStackTrace();
                    DM01_value = 1;
                    Log.d("intent------", "String_of_X");
                    method_for_DM();

                }
                if (S.equals("TM")) {
                    JSONArray tm_arr = site_arr.getJSONArray("tm");
                    for (int j = 0; j < tm_arr.length(); j++) {
                        if (j == 0) {
                            V = tm_arr.get(j).toString();
                        } else {
                            V = V + "|" + tm_arr.get(j).toString();
                        }
                    }
                } else if (S.equals("RBM")) {
                    try {
                        JSONArray tm_arr = site_arr.getJSONArray("tm");
                        for (int j = 0; j < tm_arr.length(); j++) {
                            if (j == 0) {
                                V = tm_arr.get(j).toString();
                            } else {
                                V = V + "|" + tm_arr.get(j).toString();
                            }
                        }

                        JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            if (j == 0) {
                                X = rbm_arr.get(j).toString();
                            } else {
                                X = X + "|" + rbm_arr.get(j).toString();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            if (j == 0) {
                                X = rbm_arr.get(j).toString();
                            } else {
                                X = X + "|" + rbm_arr.get(j).toString();
                            }
                        }
                    }
                } else if (S.equals("ZM")) {
                    try {
                        JSONArray tm_arr = site_arr.getJSONArray("tm");
                        for (int j = 0; j < tm_arr.length(); j++) {
                            if (j == 0) {
                                V = tm_arr.get(j).toString();
                            } else {
                                V = V + "|" + tm_arr.get(j).toString();
                            }
                        }

                        JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            if (j == 0) {
                                X = rbm_arr.get(j).toString();
                            } else {
                                X = X + "|" + rbm_arr.get(j).toString();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JSONArray rbm_arr = site_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            if (j == 0) {
                                X = rbm_arr.get(j).toString();
                            } else {
                                X = X + "|" + rbm_arr.get(j).toString();
                            }
                        }
                    }

                }
                String W = null, Y = null;
                JSONObject ware_arr = c.getJSONObject(T26);
                if (S.equals("TM")) {
                    JSONArray tm_arr = ware_arr.getJSONArray("tm");
                    for (int j = 0; j < tm_arr.length(); j++) {
                        JSONObject obj = tm_arr.getJSONObject(j);
                        if (j == 0) {
                            W = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                        } else {
                            W = W + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                        }
                    }
                } else if (S.equals("RBM")) {
                    try {
                        JSONArray tm_arr = ware_arr.getJSONArray("tm");
                        for (int j = 0; j < tm_arr.length(); j++) {
                            JSONObject obj = tm_arr.getJSONObject(j);
                            if (j == 0) {
                                W = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            } else {
                                W = W + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            }
                        }

                        JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            JSONObject obj = rbm_arr.getJSONObject(j);
                            if (j == 0) {
                                Y = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            } else {
                                Y = Y + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();

                        JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            JSONObject obj = rbm_arr.getJSONObject(j);
                            if (j == 0) {
                                Y = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            } else {
                                Y = Y + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            }
                        }
                    }
                } else if (S.equals("ZM")) {
                    try {
                        JSONArray tm_arr = ware_arr.getJSONArray("tm");
                        for (int j = 0; j < tm_arr.length(); j++) {
                            JSONObject obj = tm_arr.getJSONObject(j);
                            if (j == 0) {
                                W = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            } else {
                                W = W + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            }
                        }

                        JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            JSONObject obj = rbm_arr.getJSONObject(j);
                            if (j == 0) {
                                Y = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            } else {
                                Y = Y + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();

                        JSONArray rbm_arr = ware_arr.getJSONArray("rbm");
                        for (int j = 0; j < rbm_arr.length(); j++) {
                            JSONObject obj = rbm_arr.getJSONObject(j);
                            if (j == 0) {
                                Y = obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            } else {
                                Y = Y + "|" + obj.getString("wareHouseId") + "!" + obj.getString("Name");
                            }
                        }
                    }

                }

                String Z = c.getString(T27);

                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(ID, Id);
                persons.put(T2, A);
                persons.put(T3, B);
                persons.put(T4, C);
                persons.put(T5, D);
                persons.put(T6, E);
                persons.put(T7, F);
                persons.put(T8, G);
                persons.put(T9, H);
                persons.put(T10, I);
                persons.put(T11, J);
                persons.put(T12, K);
                persons.put(T13, L);
                persons.put(T14, M);
                persons.put(T15, N);
                persons.put(T16, O);
                persons.put(T17, P);
                persons.put(T18, Q);
                persons.put(T19, R);
                persons.put(T20, S);
                /*  persons.put(T21, T);
                persons.put(T22, U);*/
                persons.put(T23, V);
                persons.put(T24, W);
                persons.put(T25, X);
                persons.put(T26, Y);
                persons.put(T27, Z);
                try {

                    FileWriter fw = new FileWriter(ISLoginMaster, true);
                    BufferedWriter pw = new BufferedWriter(fw);
                    if (A.equals(PoCodes)) {
                        if (PostCodeTransfer.equals("TM")) {
                            UpdateNumberSequence = O;
                        } else {
                            UpdateNumberSequence = O;
                            UpdateNumberSequence1 = Z;
                        }
                        P = DivisionCheckBoxValue;

                        pw.append(Id + "," + A + "," + B + "," + C + "," + D + "," + E + "," + F + "," + G + "," + H + "," + I + "," + J + "," + K + "," + L + "," + M + "," + N + "," + P + "," + Q + "," + R + "," + S + "," + V + "," + W + "," + X + "," + Y + "\r\n");
                        pw.flush();
                        pw.close();
                        fw.close();
                        ExcelNumberSequenceSaveTM();
                    }
                    //  pw.append(Id + "," + AssetName + "," + AssetNO + "," + Location + "," + Unit + "," + BldgDetails + "," + UserName  + "\r\n");
                 /*   if (totalcounts == linechecks) {
                        //  Toast.makeText(getApplicationContext(), "Syn Completed" + PFOfilSynFile, Toast.LENGTH_LONG).show();
                        //  Toast.makeText(getApplicationContext(), linechecks + " Line Import",  Toast.LENGTH_LONG).show();
                        prgDialog.hide();
                        //toSpeak =  "Syn Completed"+PFOfilSynFile;
                        // speakOut();
                        Check = "Checkfile".toString();
                    }
                    update.setText(String.valueOf(linechecks));
                    linechecks = linechecks + 1;*/
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.e(TAG_RESULTS, "error3 " + e.toString());
                    // Log.i(TAG, "******* File not found. Did you"
                    // + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
                    prgDialog.hide();
                } catch (IOException e) {
                    e.printStackTrace();
                    prgDialog.hide();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }
    }

    private void method_for_DM() {


    }

    public void UpdateImeiNo() {
        String token = FirebaseInstanceId.getInstance().getToken();
        //  Log.e("login", token);
        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        //if (isConnectionExist || isConnectionExistMobile) {

        String EmpCode1 = etUserId.getText().toString();
        String ImeiNo1 = textDeviceID.getText().toString();

        //  prgDialog1.show();
        prgDialog.show();
//        insertToDatabase2(EmpCode1, ImeiNo1, Acting, DCode, token);

        //} else {
        // Internet connection doesn't exist
        // showAlertDialog(MainActivity.this, "No Internet Connection",
        //     "Your device doesn't have WIFI or Data Plan internet access", false);
        // }
    }

//    private void insertToDatabase2(String EmpCode1, String ImeiNo1, final String acting, final String dcode, final String token) {
//        @SuppressLint("StaticFieldLeak")
//        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
//            @Override
//            protected String doInBackground(String... params) {
//                String paramUsername = params[0];
//                String paramAddress = params[1];
//
//                String EmpCode1 = etUserId.getText().toString();
//                String ImeiNo1 = textDeviceID.getText().toString();
//
//                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                nameValuePairs.add(new BasicNameValuePair("EmpCode", EmpCode1));
//                nameValuePairs.add(new BasicNameValuePair("DeviceId", ImeiNo1));
//                nameValuePairs.add(new BasicNameValuePair("Acting", acting));
//                nameValuePairs.add(new BasicNameValuePair("Dcode", dcode));
//                nameValuePairs.add(new BasicNameValuePair("Token", token));
////                nameValuePairs.add(new BasicNameValuePair("SimNo", SimNo1));
////                nameValuePairs.add(new BasicNameValuePair("MobileNo", MobileNo1));
//
//                try {
//                    HttpClient httpClient = new DefaultHttpClient();
//                    // HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/kanagaraj/IndentSales/ISImeiMasterUpdate.php");
//
//                    // HttpPost httpPost = new HttpPost("http://172.16.3.21/HrDataUpdate.php");
//                    ////                    HttpPost httpPost = new HttpPost(IPAddress + "/kanagaraj/" + ProjectFolder + "/ISUpdateDevice.php");
//                    ////                    HttpPost httpPost = new HttpPost(new_api.ISUpdateDevice(ProjectFolder));
//
//                    HttpPost httpPost = new HttpPost(IPAddress + ProjectFolder + "/ISUpdateDevice.php");
////                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISUpdateDevice.php");
//                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                    HttpResponse response = httpClient.execute(httpPost);
//                    HttpEntity entity = response.getEntity();
//
//                } catch (ClientProtocolException e) {
//
//                } catch (IOException e) {
//
//                }
//                return "success";
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                super.onPostExecute(result);
//            }
//        }
//        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
//        sendPostReqAsyncTask.execute(EmpCode1, ImeiNo1, acting, dcode, token);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are You Sure?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }*/

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    /**
     * Function to display simple Alert Dialog
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param status  - success/failure (used to set icon)
     */
    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        // Setting Dialog Title
        alertDialog.setTitle(title);
        // Setting Dialog Message
        alertDialog.setMessage(message);
        // Setting alert dialog icon
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    public void showAlertDialog1(Context context, String title, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        // Setting Dialog Title
        alertDialog.setTitle(title);
        // Setting Dialog Message
        // alertDialog.setMessage(message);
        // Setting alert dialog icon
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    String getDeviceID(TelephonyManager phonyManager) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        String deviceId = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            deviceId = telephonyManager.getImei(0);
//        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deviceId = Settings.Secure.getString(
                    this.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } else {
            final TelephonyManager mTelephony = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            if (mTelephony.getDeviceId() != null) {
                deviceId = mTelephony.getDeviceId();
            } else {
                deviceId = Settings.Secure.getString(
                        this.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
            }
        }

        return deviceId;


//        String id = phonyManager.getDeviceId();
//        if (id == null) {
//            id = "not available";
//        }
//        int phoneType = phonyManager.getPhoneType();
//        switch (phoneType) {
//            case TelephonyManager.PHONE_TYPE_NONE:
//                //return "NONE: " + id;
//                return id;
//
//            case TelephonyManager.PHONE_TYPE_GSM:
//                // return "GSM: IMEI=" + id;
//                return id;
//
//            case TelephonyManager.PHONE_TYPE_CDMA:
//                //return "CDMA: MEID/ESN=" + id;
//                return id;
//
//            /*
//             *  for API Level 11 or above
//             *  case TelephonyManager.PHONE_TYPE_SIP:
//             *   return "SIP";
//             */
//
//            default:
//                // return "UNKNOWN: ID=" + id;
//                return id;
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void CloseActivity(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    private void GpsLocation() {
        Location gpsLocation = appLocationService.getLocation(LocationManager.NETWORK_PROVIDER);
        if (gpsLocation != null) {
            double latitude = gpsLocation.getLatitude();
            double longitude = gpsLocation.getLongitude();
            //    Toast.makeText(getApplicationContext(), "Mobile Location (GPS): \nLatitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_LONG).show();

            //Gps.setText("" + latitude);
            //Network.setText("" + longitude);

            //Locatn2.setText(""+latitude+"\n"+longitude);

            // Locatn2.setText("" + latitude+""+longitude);
        } else {
            //  showSettingsAlert("GPS");
        }
    }

    public void showSettingsAlert(String provider) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                LoginActivity.this);
        alertDialog.setTitle(provider + " SETTINGS");
        alertDialog
                .setMessage(provider + " is not enabled! Want to go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        LoginActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

    public void Network() {

        Location nwLocation = appLocationService.getLocation(LocationManager.NETWORK_PROVIDER);

        if (nwLocation != null) {
            double latitude = nwLocation.getLatitude();
            double longitude = nwLocation.getLongitude();
            //  Toast.makeText(getApplicationContext(), "Mobile Location (NW): \nLatitude: " + latitude + "\nLongitude: " + longitude,
            //  Toast.LENGTH_LONG).show();

            //  Locatn2.setText("Latitude:" + latitude+""+"Longitude:" + longitude);

        } else {
            //showSettingsAlert("NETWORK");
        }
    }


    private void checkUserWithSharedPreferences() {
        if (appSharedPreferences.getLoginRole() != null && appSharedPreferences.getUserId() != null) {
            redirectBasedOnRole(appSharedPreferences.getLoginRole(), appSharedPreferences.getUserId(), appSharedPreferences.getUserName());
        }
    }


    private void POLoginFileCheck() {
        if (ISLoginMaster.exists() && ISIndentCodeFile.exists()) {
            ISloginMasterOfflineFileCheck();
        } else {
            if (appSharedPreferences.get_zm().matches("login_ZM")) {
//                Log.d("intent--------------","LoginActivity");
                // ISloginMasterOfflineFileCheck();
                Intent intent = new Intent(this, DBMScreenActivity.class);
                intent.putExtra("Po_code", appSharedPreferences.getUserId());
                intent.putExtra("Po_name", appSharedPreferences.getUserName());
                intent.putExtra("Tm_name", appSharedPreferences.get_Tm_name());
                intent.putExtra("Post_code", appSharedPreferences.get_Post_code());
                intent.putExtra("Site_ID", appSharedPreferences.get_Site_ID());
                intent.putExtra("Division_code", appSharedPreferences.get_Division_code());
                intent.putExtra("Action_Code", appSharedPreferences.get_Action_Code());
                intent.putExtra("D_Code", appSharedPreferences.get_D_Code());
                startActivity(intent);
            } else if (appSharedPreferences.get_zm().matches("login_TM")) {
//                Log.d("intent--------------","LoginActivity");
                // ISloginMasterOfflineFileCheck();
                Intent intent = new Intent(this, TMScreenActivity.class);
                intent.putExtra("Po_code", appSharedPreferences.getUserId());
                intent.putExtra("Po_name", appSharedPreferences.getUserName());
                intent.putExtra("Tm_name", appSharedPreferences.get_Tm_name());
                intent.putExtra("Post_code", appSharedPreferences.get_Post_code());
                intent.putExtra("Site_ID", appSharedPreferences.get_Site_ID());
                intent.putExtra("Division_code", appSharedPreferences.get_Division_code());
                intent.putExtra("Action_Code", appSharedPreferences.get_Action_Code());
                intent.putExtra("D_Code", appSharedPreferences.get_D_Code());
                startActivity(intent);
            } else if (appSharedPreferences.get_zm().matches("login_RBM")) {
                Intent intent = new Intent(this, RBMScreenActivity.class);
                intent.putExtra("Po_code", appSharedPreferences.getUserId());
                intent.putExtra("Po_name", appSharedPreferences.getUserName());
                intent.putExtra("Tm_name", appSharedPreferences.get_Tm_name());
                intent.putExtra("Post_code", appSharedPreferences.get_Post_code());
                intent.putExtra("Site_ID", appSharedPreferences.get_Site_ID());
                intent.putExtra("Division_code", appSharedPreferences.get_Division_code());
                intent.putExtra("Action_Code", appSharedPreferences.get_Action_Code());
                intent.putExtra("D_Code", appSharedPreferences.get_D_Code());
                startActivity(intent);
            }

//            folderDelete();
        }
    }

    public void ISloginMasterOfflineFileCheck() {
        Check = "";

        try {
            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader(new FileReader(ISLoginMaster));
            String line = "";

            int lineNumber = 0;
            //read comma separated file line by line
            while ((line = br.readLine()) != null) {
                lineNumber++;

                //use comma as token separator
                String[] country = line.split(",");
                POCodeTransfer = country[1].toString();
                PONameTransfer = country[2].toString();
                TerritoryNameTransfer = country[3].toString();
                PostCodeTransfer = country[5].toString();
                SiteTransfer = country[13].toString();
                DivisionTransfer = country[15].toString();
                Acting = country[16].toString();
                DCode = country[18].toString();
                try {

                    if (Acting.equals("TM")) {
                        appSharedPreferences.put_siteTM(country[19].toString());
                        appSharedPreferences.put_warehouseTM(country[20].toString());
                    } else {
                        appSharedPreferences.put_siteTM(country[19].toString());
                        appSharedPreferences.put_warehouseTM(country[20].toString());
                        appSharedPreferences.put_siteRBM(country[21].toString());
                        appSharedPreferences.put_warehouseRBM(country[22].toString());
                    }
                } catch (Exception e) {
                    Log.d("intent--------------", "Catch" + "--" + DCode);
                    Log.e("offline", "data null " + e.toString());
                }
            }

            if (DCode.equals("TM")) {
                prgDialog.hide();
                Log.d("intent--------------", "-----TM------2---------");

                Intent intent = new Intent(this, TMScreenActivity.class);
                intent.putExtra("Po_code", POCodeTransfer);
                intent.putExtra("Po_name", PONameTransfer);
                intent.putExtra("Tm_name", TerritoryNameTransfer);
                intent.putExtra("Post_code", PostCodeTransfer);
                intent.putExtra("Site_ID", SiteTransfer);
                intent.putExtra("Division_code", DivisionTransfer);
                intent.putExtra("Action_Code", Acting);
                intent.putExtra("D_Code", DCode);
                startActivity(intent);
            } else if (DCode.equals("RBM")) {
                prgDialog.hide();
                Intent intent = new Intent(this, RBMScreenActivity.class);
                intent.putExtra("Po_code", POCodeTransfer);
                intent.putExtra("Po_name", PONameTransfer);
                intent.putExtra("Tm_name", TerritoryNameTransfer);
                intent.putExtra("Post_code", PostCodeTransfer);
                intent.putExtra("Site_ID", SiteTransfer);
                intent.putExtra("Division_code", DivisionTransfer);
                intent.putExtra("Action_Code", Acting);
                intent.putExtra("D_Code", DCode);
                startActivity(intent);
            }
//            else if (PostCodeTransfer.equals("DBM"))
            else if (DCode.equals("ZM")) {
                prgDialog.hide();
                if (DM01_value == 1) {
                    appSharedPreferences.put_ZM("login_ZM");


                    appSharedPreferences.putUserId(POCodeTransfer);
                    appSharedPreferences.putName(PONameTransfer);
                    appSharedPreferences.Tm_name(TerritoryNameTransfer);
                    appSharedPreferences.Post_code(PostCodeTransfer);
                    appSharedPreferences.Site_ID(SiteTransfer);
                    appSharedPreferences.Division_code(DivisionTransfer);
                    appSharedPreferences.Action_Code(Acting);
                    appSharedPreferences.D_Code(DCode);
                }
                Log.d("intent--------------", "-----------1---------");
                Intent intent = new Intent(this, DBMScreenActivity.class);
                intent.putExtra("Po_code", POCodeTransfer);
                intent.putExtra("Po_name", PONameTransfer);
                intent.putExtra("Tm_name", TerritoryNameTransfer);
                intent.putExtra("Post_code", PostCodeTransfer);
                intent.putExtra("Site_ID", SiteTransfer);
                intent.putExtra("Division_code", DivisionTransfer);
                intent.putExtra("Action_Code", Acting);
                intent.putExtra("D_Code", DCode);
                startActivity(intent);
            }
        } catch (Exception e) {
            // System.err.println("CSV file cannot be read : " + e);
            //  Toast.makeText(getApplicationContext(), "CSV file  cannot be read or Opened ", Toast.LENGTH_LONG).show();
            prgDialog.hide();
        }
    }


//    public void UpdateCheckOnline() {
//        isConnectionExist = cd.checkMobileInternetConn();
//        isConnectionExistMobile = cd.checkMobileInternetConns();
//
//        if (isConnectionExist || isConnectionExistMobile) {
//            prgDialog.show();
//            class GetDataJSON extends AsyncTask<String, Void, String> {
//
//                @Override
//                protected String doInBackground(String... params) {
//                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                    //HttpPost httppost = new HttpPost("http://rasiaosit.16mb.com/getdata.php");
//                    //  HttpPost httppost = new HttpPost("http://10.20.1.37:8080/kanagaraj/IndentSales/Version.php");
//
//                    //HttpPost httppost = new HttpPost("http://172.16.3.21/HrAttendance.php");
//                    ////                    HttpPost httppost = new HttpPost(IPAddress + "/kanagaraj/"+ProjectFolder+"/Version.php");
//                    ////                    HttpPost httppost = new HttpPost(new_api.Version(ProjectFolder));
//
//                    HttpPost httppost = new HttpPost(IPAddress + "SalesIndentCotton" + "/Version.php");
////                    HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/Version.php");
//
//                    // Depends on your web service
//                    httppost.setHeader("Content-type", "application/json");
//
//                    InputStream inputStream = null;
//                    String result = null;
//                    try {
//                        HttpResponse response = httpclient.execute(httppost);
//                        HttpEntity entity = response.getEntity();
//
//                        inputStream = entity.getContent();
//                        // json is UTF-8 by default
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                        StringBuilder sb = new StringBuilder();
//                        // List<String> codes = new ArrayList<String>();
//                        // String line = null;
//                        String line = "";
//                        int lineNumber = 0;
//                        while ((line = reader.readLine()) != null) {
//                            sb.append(line + "\n");
//                        }
//                        result = sb.toString();
//
//                    } catch (Exception e) {
//
//                    } finally {
//                        try {
//                            if (inputStream != null) inputStream.close();
//                        } catch (Exception squish) {
//
//                        }
//                    }
//                    return result;
//                }
//
//                @Override
//                protected void onPostExecute(String result) {
//                    myJSON = result;
//                    try {
//                        Log.e("TAG", myJSON);
//                        folderDelete();
//                        showListUpdateonline();
//                    } catch (Exception e) {
//                        prgDialog.cancel();
//                        Log.e(TAG_RESULTS, e.toString());
//                        Toast.makeText(LoginActivity.this, "Error3", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//            GetDataJSON g = new GetDataJSON();
//            g.execute();
//        } else {
//            //Internet connection doesn't exist
//            showAlertDialog(LoginActivity.this, "No Internet Connection",
//                    "Your device doesn't have WIFI or Data Plan internet access", false);
//            prgDialog.hide();
//        }
//    }

    protected void showListUpdateonline() {
        try {
            UserStatusCheck = "";
            Check = "";

            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(ID);

                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(ID, Id);
                VersionServer = Id;

                if (!VersionServer.trim().toString().equals(VersionAndroid.trim().toString())) {
                    Check = "chckfile".toString();
                }
            }

            if (Check.equals("chckfilee")) {

                Toast.makeText(getApplicationContext(), "Update Available", Toast.LENGTH_SHORT).show();

                prgDialogUpdate = new ProgressDialog(this, R.style.StyledDialog);
                prgDialogUpdate.setMessage("Please Wait New Update Downloading ...");
                prgDialogUpdate.setCancelable(false);
                prgDialogUpdate.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));
                Log.e(TAG_RESULTS, IPAddress + "Android/SalesIndent.apk");

                Update(IPAddress + "Android/SalesIndent_V1.4.7.apk");
//                Update("http://
// /hiveg/Sales_Indent_App/SalesIndent.apk");
//                Update(new_api.apk);
            } else {
//                POLoginOnline();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }
    }

    public void Update(final String apkurl) {
        prgDialogUpdate.show();
        new AsyncTask<Void, String, String>() {
            String result = "";

            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url = new URL(apkurl);
                    HttpURLConnection c = (HttpURLConnection) url
                            .openConnection();
                    c.setRequestMethod("GET");
                    c.connect();

                    String PATH = Environment.getExternalStorageDirectory()
                            + "/download/";
                    File file = new File(PATH);
                    file.mkdirs();
                    File outputFile = new File(file, "SalesIndent.apk");
                    FileOutputStream fos = new FileOutputStream(outputFile);

                    InputStream is = c.getInputStream();

                    byte[] buffer = new byte[1024];
                    int len1 = 0;
                    while ((len1 = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len1);
                    }
                    fos.close();
                    is.close();
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/download/" + "SalesIndent.apk")), "application/vnd.android.package-archive");
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);

                    try {
                        File toInstall = new File(Environment.getExternalStorageDirectory() + "/download/", "SalesIndent.apk");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            Uri apkUri = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", toInstall);
                            Intent intent1 = new Intent(Intent.ACTION_INSTALL_PACKAGE);
                            intent1.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);
                            intent1.setDataAndType(apkUri, "application/vnd.android.package-archive");
                            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent1.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            startActivity(intent1);
                        } else {
                            Uri apkUri = Uri.fromFile(toInstall);
                            Intent intent2 = new Intent(Intent.ACTION_VIEW);
                            intent2.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);
                            intent2.setDataAndType(apkUri, "application/vnd.android.package-archive");
                            intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent2.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            startActivity(intent2);
                        }
                    } catch (Exception e) {
                        Log.e("Update", "File open error " + e.toString());
                    }
                } catch (IOException e) {
                    result = "Update error! " + e.getMessage();
                    e.printStackTrace();
                }
                return result;
            }

            protected void onPostExecute(String result) {
                Toast.makeText(getApplicationContext(), "Downloading Successful Please Install",
                        Toast.LENGTH_LONG).show();
                prgDialogUpdate.hide();
                prgDialog.hide();
            }
        }.execute();
    }

    private void ExcelNumberSequenceSaveTM() {
        try {

            ISIndentCodeFile.delete();

            FileWriter fw = new FileWriter(ISIndentCodeFile, true);
            BufferedWriter pw = new BufferedWriter(fw);
            pw.append(UpdateNumberSequence + "\r\n");
            pw.flush();
            pw.close();
            fw.close();

            ISIndentCodeFile1.delete();

            FileWriter fw1 = new FileWriter(ISIndentCodeFile1, true);
            BufferedWriter pw1 = new BufferedWriter(fw1);
            pw1.append(UpdateNumberSequence1 + "\r\n");
            pw1.flush();
            pw1.close();
            fw1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Log.i(TAG, "******* File not found. Did you"
            // + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ExcelNumberSequenceSaveTMOLD() {
        DeleteNumberSequence();
        createTableNumberSequence();

        String query = "INSERT INTO SINumberSequence  (NumberSequence) VALUES('" + UpdateNumberSequence + "');";
        dbNumberSequence.execSQL(query);
    }

    protected void createDatabaseNumberSequence() {
        dbNumberSequence = openOrCreateDatabase(ISIndentCodeFile.getPath(), Context.MODE_PRIVATE, null);
    }

    protected void createTableNumberSequence() {
        dbNumberSequence.execSQL("CREATE TABLE IF NOT EXISTS SINumberSequence(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NumberSequence INTEGER);");
    }

    private void DeleteNumberSequence() {
        String DATABASE_TABLE_SINumberSequence = "SINumberSequence".toString();
        dbNumberSequence.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SINumberSequence + "'");
    }

    boolean isTableExists(SQLiteDatabase db, String tableName) {
        if (tableName == null || db == null || !db.isOpen()) {
            return false;
        }
        Cursor cursor = db.rawQuery("select * from  " + tableName + " ", null);
        if (!cursor.moveToFirst()) {
            cursor.close();
            return false;
        }
        int count = cursor.getInt(0);
        cursor.close();
        return count > 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register connection status listener
        MyApplication.getInstance().setConnectivityListener(this);
    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;

        String TextViewShow = "";
        int color;

        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
            snackbar_text.setBackgroundColor(Color.parseColor("#FF0A8D07"));
            TextViewShow = "TextViewShow";
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.WHITE;
            snackbar_text.setBackgroundColor(Color.parseColor("#FFEC1934"));

            prgDialog.hide();
        }

        snackbar_text.setTextColor(color);
        snackbar_text.setText(message);


        if (TextViewShow.equals("TextViewShow")) {
            TextViewShow = "";
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    snackbar_text.setVisibility(View.GONE);

                }

            }, 1000);

        } else {

            snackbar_text.setVisibility(View.VISIBLE);
        }
    }

    public void saveVersionNameAndCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            int versionCode = packageInfo.versionCode;
            String versionName = packageInfo.versionName;

            version.setText("version :" + versionName);
            versioncode = (versionCode);

            int num = Integer.parseInt(versioncodefromserver);

            Log.d("jjakjalka", "----------codessss" + num);
            Log.d("jjakjalka", "----------code-----" + versioncode);
            if ((versioncode > num) || ((versioncode == num))) {
                Log.d("jjakjalka", "*******1******");

                version_to_login = 1;
            } else {
                Log.d("jjakjalka", "*******0******");

                version_to_login = 0;
            }


            // SAVE YOUR DATA

        } catch (Exception e) {
        }
    }


}