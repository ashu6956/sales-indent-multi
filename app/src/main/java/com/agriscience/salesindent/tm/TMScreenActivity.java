package com.agriscience.salesindent.tm;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.agriscience.salesindent.LoginActivity;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.model.ZOrganogramResponseDetails;
import com.agriscience.salesindent.room_database.entity.CustomerEntity;
import com.agriscience.salesindent.room_database.entity.MaterialEntity;
import com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity;
import com.agriscience.salesindent.room_database.entity.SeasonEntity;
import com.agriscience.salesindent.tm.TMReportViewActivity;
import com.agriscience.salesindent.tm.TMSalesIndentActivity;
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
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.ConnectivityReceiver;
import com.agriscience.salesindent.CustomGrids;
import com.agriscience.salesindent.ExpandableHeightGridView;
import com.agriscience.salesindent.MyApplication;
import com.agriscience.salesindent.R;
import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.CustomerMasterDetailsResponse;
import com.agriscience.salesindent.model.CustomerMasterResponse;
import com.agriscience.salesindent.model.MaterialMasterDetailResponse;
import com.agriscience.salesindent.model.MaterialSeasonResponse;
import com.agriscience.salesindent.model.SeasonMasterDetailsResponse;
import com.agriscience.salesindent.model.SuccessResponse;
import com.agriscience.salesindent.room_database.SalesIndentDataBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TMScreenActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ConnectivityReceiver.ConnectivityReceiverListener {

    private ApiInterface apiInterface;
    private SalesIndentDataBase salesIndentDataBase;


    final static int REQUEST_LOCATION = 199;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    private static final String TAG_RESULTS1 = "result";
    private static final String T1 = "Id";
    private static final String T2k = "POCode";
    private static final String T3k = "POName";
    private static final String T4k = "TerritoryName";
    private static final String T5k = "Password";
    private static final String T6k = "POSCode";
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
    private final String LAST_APP_VERSION_KEY = "latestappversion";
    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;
    String myJSON;
    EditText PoCode, Password;
    String PoCodes = "";
    String Passwords = "";
    String POCodeTransfer = "";
    String PONameTransfer = "";
    String TerritoryNameTransfer = "";
    String PostCodeTransfer = "", old_indent_no = "";
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    PendingResult<LocationSettingsResult> result;
    AppLocationService appLocationService;
    TextView tvAddress;
    TextView Gps, Network;
    TextView scandata;
    Spinner Farmarcode;
    Spinner Inspectioncd;
    TextView Growercd, GrowerName, FatherName, VillageName, FaCode, VarietyCd, SowingDates, Description, Description1, InspectionDate, InspectionDate1, Farmerarea, Farmerarea1;


    Button PFOSCAN, GetData;


    String Check = "";


    Boolean fisttimecount = true;
    Boolean Syncomplete = true;
    Boolean fisttimecountexit = true;

    Boolean fistautosyn = true;

    Boolean fistautosyn1 = true;

    File PFOfileIn = null;
    File PFOfileOut = null;
    File PFOfilSynFile = null;

    File Iroot = Environment.getExternalStorageDirectory();
    File Oroot = Environment.getExternalStorageDirectory();

    int linechecks = 1;
    int totalcounts = 0;


    TextView totcounts, update;


    ProgressDialog prgDialog;

    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;


    // Connection detector class
    WIFIInternetConnectionDetector cd;

    String sCustomerInput = "";
    String syninput2 = "";
    String sCropInput = "";
    String sPackingInput = "";
    String sPriceInput = "";
    String sInventInput = "";
    String syninput7 = "";
    String syninput8 = "";
    String syninput9 = "";
    String getDataApi;
    ListView listView;
    String ListSelect;
    String UserIdData, UnitData;
    int autocountsun = 1;
    Boolean DeleteFileCheck = true;
    EditText Empcode;
    File FieldfileIn = null;
    File FieldfileOut = null;
    File PFOMoveFile = null;
    File APPOMasterInput = null;
    File APActivityTypeMasterInput = null;
    File APSubActivityMasterInput = null;
    File APVillageMasterInput = null;
    File APEventCrateCodeFile = null;
    File APEventRecorderPostSeasonalFile = null;
    File APEvenetDataFile = null;
    File APEventCodeFile = null;
    File FileEventDatMovefile = null;
    File APEventRecorderPostSeasonalMoveFile = null;
    String PoState, PoRegion;
    String Checks = "";

    String POCodeGet = "";
    String PONameGet = "";
    String TerritoryNameGet = "";
    String PostCodeTransferGet = "";
    String SiteGet = "";

    Integer UploadCount1 = 1;

    int FLAG = 0;
    String Imagepath1 = "";
    String Imagepath2 = "";
    String Imagepath3 = "";
    String ImageFileName1 = "";
    String ImageFileName2 = "";
    String ImageFileName3 = "";
    String EventCodeNew, TransDateNew, ActivityTypeNew, ActivityNameNew, ProductNew, PoCodeNew, TerritoryNew, HostFarmerNameNew, NoofFarmerCoveredNew, NoofVillageCoveredNew, NoofDealersCoveredNew, TalukMandalNew, VillageNameNew, FarmerNameNew, MobileNumberNew, ObserVationonNew, SolutionsNew, VisitNoNew, CropCondtionNew, StatusNew, BudgetAmtNew, SupportingPosNew, ExpensesNew, FarmerCoverageNew, RemarksNew, GpsLocationNew, LatitudeNew, LongitudeNew, Image1New, Image2New, Image3New, LoactionDateNew, LocationTimeNew, StringDateNew;
    File ISCustMasteInput = null;
    File ISItemMasterInput = null;
    File ISCropMasterInput = null;
    File ISSiteMasterInput = null;
    File ISWarehouseMaster = null;
    File ISHeaderDataFile = null;
    File ISLineDataFile = null;
    File ISLineDataTempFile = null;
    File ISIndentCodeFile = null;
    File ISProductMasterFile = null;
    File ISLoginMaster = null;
    String IndentCreationCode = "", strDate = "", strTime = "", CustomerAccounts = "", CustomerName = "", CropTypes = "", CropNames = "", Hybrids = "", Qty2 = "";
    String TMId;
    String Slno;
    String Sites, Warehouses, ExpectedDate;
    String ItemNames;
    int linecheckPoevent = 1;
    int totalcountPoevent = 0;
    String IPAddress = "http://103.44.97.110:8080/kanagaraj/";
    String DivisionGet = "";
    String ProjectFolder = "";
    String ResponseCheckLine = "";
    String IndentName = "";
    String Acting = "";
    String DCode = "";
    //    GridView grid;
    ExpandableHeightGridView grid;
    String[] gridViewData = {
            "GET DATA",
            "UPLOAD DATA",
            "SALES INDENT",
            "INDENT STATUS",
            "LOGOUT",
            "EXIT",
    };
    int[] gridViewImageId = {
            R.drawable.g2,
            R.drawable.upload57,
            R.drawable.salesindent,
            R.drawable.salesview,
            R.drawable.lo2,
            R.drawable.exit,
    };

    File Getmasterpath = null;
    File SalesIndentPath = null;
    String GetmasterCheck = "";
    String SPrice = "";
    String SAmount = "";
    String PkgSizes = "";
    String PkgName = "";
    String UomValue = "";
    String ProcessingId = "";
    String Remarks = "";
    File GoTOTMCheck = null;
    TextView snackbar_text;
    AppSharedPreferences appSharedPreferences;
    int latestAppVersion;
    boolean doubleBackToExitPressedOnce = false;
    private SQLiteDatabase dbGetmaster;
    private Cursor cScanDetails;
    private SQLiteDatabase dbSalesIndent;
    private final FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
    private HashMap<String, Object> firebaseDefaultMap;

    public static boolean setListViewHeightBasedOnItems(GridView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getGravity() *
                    (numberOfItems - 1);
            // Get padding
            int totalPadding = listView.getPaddingTop() + listView.getPaddingBottom();

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight + totalPadding;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

    }

    private int getcurrentversioncode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void checkForUpdate() {
        latestAppVersion = (int) mFirebaseRemoteConfig.getDouble(LAST_APP_VERSION_KEY);
        appSharedPreferences.save_version(latestAppVersion);
        if (latestAppVersion > getcurrentversioncode()) {

            new AlertDialog.Builder(this).setTitle("Please Update the App")
                    .setMessage("A new version of this app is available. Please update it").setPositiveButton(
                            "OK", new DialogInterface.OnClickListener() {


                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    cScanDetails = dbSalesIndent.rawQuery("select * from SalesIndentDetails", null);
                                    if (cScanDetails.getCount() == 0) {

                                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                        try {
                                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                        } catch (android.content.ActivityNotFoundException anfe) {
                                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                                        }

                                    } else {
                                        new AlertDialog.Builder(TMScreenActivity.this).setTitle("Upload the data")
                                                .setMessage("Please upload the data and then update").setPositiveButton(
                                                        "OK", new DialogInterface.OnClickListener() {


                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                dialog.dismiss();


                                                            }
                                                        }).setCancelable(false).show();

                                    }


                                }
                            }).setCancelable(false).show();
        } else {
            //  Toast.makeText(this,"This app is already upto date", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmsreen);
        appSharedPreferences = new AppSharedPreferences(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        salesIndentDataBase = SalesIndentDataBase.getDataBase(this);
        saveDivisionAndTerritoryId();

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
                    //   Log.d(TAG, "Fetched value: " + mFirebaseRemoteConfig.getString(LAST_APP_VERSION_KEY));
                    //calling function to check if new version is available or not
                    checkForUpdate();
                } else {
                    Toast.makeText(TMScreenActivity.this, "Someting went wrong please try again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (LoginActivity.version_to_login == 0) {
            Toast.makeText(this, "New Update Available...\nLogout to get new version", Toast.LENGTH_SHORT).show();
        }

        appLocationService = new AppLocationService(TMScreenActivity.this);

        totcounts = (TextView) findViewById(R.id.textView47);
        update = (TextView) findViewById(R.id.textView48);

        snackbar_text = (TextView) findViewById(R.id.snackbar_text);
        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage(" Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));

        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISHeaderDataFile = new File(dir, "ISHeaderDataFile.csv");
        }


        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISLineDataFile = new File(dir, "ISLineDataFile.csv");
        }


        if (Iroot.canWrite()) {
            Calendar cal = Calendar.getInstance();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            //  SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

            String strDate, strTime;

            strDate = sdf.format(cal.getTime());


            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentData");
            dir.mkdirs();

            APEventRecorderPostSeasonalMoveFile = new File(dir, strDate + "APEventRecorderPostSeasonalMoveFile.csv");
        }

        if (Iroot.canWrite()) {

            Calendar cal = Calendar.getInstance();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            //  SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

            String strDate, strTime;

            strDate = sdf.format(cal.getTime());


            File dir = new File(Iroot.getAbsolutePath() + "/ISLoginMaster");
            dir.mkdirs();

            ISLoginMaster = new File(dir, "ISLoginMaster" + strDate + ".csv");
        }


        if (Iroot.canWrite()) {
            Calendar cal = Calendar.getInstance();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            //  SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

            String strDate, strTime;

            strDate = sdf.format(cal.getTime());


            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentData");
            dir.mkdirs();

            FileEventDatMovefile = new File(dir, strDate + "APEventDataOutput.csv");
        }

        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            APEventCrateCodeFile = new File(dir, "APEventCrateCodeFile.csv");
        }


        if (Oroot.canWrite()) {
            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentHVG");
            dir.mkdirs();

            Getmasterpath = new File(dir, "SIGetmasterDB.db");

        }


        if (Oroot.canWrite()) {
            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentHVG");
            dir.mkdirs();

            SalesIndentPath = new File(dir, "SIDetailsDB.db");

        }


        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentDB3");
            dir.mkdirs();

            ISIndentCodeFile = new File(dir, "NumberSequence.csv");
        }


        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/Android/SITMCheck");
            dir.mkdirs();

            GoTOTMCheck = new File(dir, "GoTOTMCheck.csv");

        }


//        createDatabaseGetMaster();
//        createDatabaseSalesIndentData();
//        createTableSalesIndentDetails();
//        createTableSalesIndentDetailsTemp();

        CustomGrids adapter = new CustomGrids(TMScreenActivity.this, gridViewData, gridViewImageId);
        grid = (ExpandableHeightGridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setExpanded(true);

        grid.setOnItemClickListener((parent, view, position, id) -> {
            IndentName = gridViewData[+position];
            salesIndentGridDataClick();
        });


        checkConnection();
        ISloginMasterOfflineFileCheck();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            try {
                POCodeGet = extras.getString("Po_code");
                PONameGet = extras.getString("Po_name");
                TerritoryNameGet = extras.getString("Tm_name");
                PostCodeTransferGet = extras.getString("Post_code");
                SiteGet = extras.getString("Site_ID");
                DivisionGet = extras.getString("Division_code");
                Acting = extras.getString("Action_Code");
                DCode = extras.getString("D_Code");
            } catch (Exception e) {
                e.printStackTrace();
            }


            appSharedPreferences.put_ZM("login_TM");

            appSharedPreferences.putUserId(POCodeGet);
            appSharedPreferences.putName(PONameGet);
            appSharedPreferences.Tm_name(TerritoryNameGet);
            appSharedPreferences.Post_code(PostCodeTransferGet);
            appSharedPreferences.Site_ID(SiteGet);
            appSharedPreferences.Division_code(DivisionGet);
            appSharedPreferences.Action_Code(Acting);
            appSharedPreferences.D_Code(DCode);


            Animation animationToLeft = new TranslateAnimation(400, -400, 0, 0);
            animationToLeft.setDuration(12000);
            animationToLeft.setRepeatMode(Animation.RESTART);
            animationToLeft.setRepeatCount(Animation.INFINITE);

            Animation animationToRight = new TranslateAnimation(-100, 100, 0, 0);
            animationToRight.setDuration(2500);
            animationToRight.setRepeatMode(Animation.RELATIVE_TO_PARENT);
            animationToRight.setRepeatCount(Animation.REVERSE);

            TextView textViewNameleft = (TextView) findViewById(R.id.textView65);
            textViewNameleft.setAnimation(animationToLeft);
            textViewNameleft.setText("WELCOME  Mr. " + PONameGet.toUpperCase());

        }

    }


    private void saveDivisionAndTerritoryId() {
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            ZOrganogramResponseDetails organogramDetails = SalesIndentDataBase.getDataBase(this).zOrganogramDetailsDao().getZOrganogramDetailsByUserId(appSharedPreferences.getUserId());
            if (organogramDetails != null) {
                Log.d("ZOrganogramResponseDetails", organogramDetails.toString());
                appSharedPreferences.putDivision(organogramDetails.getDivision());
                appSharedPreferences.putTerritoryId(organogramDetails.getTerritoryId());
            }

        });
    }

    public void checkwifi() {

        // get Internet status
        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {
            // Internet Connection exists
            //  showAlertDialog(MainActivity.this, "Internet Connection",
            //"Your device has WIFI internet access", true);
        } else {
            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }

    private void salesIndentGridDataClick() {


        if (IndentName.equals("GET DATA")) {

//            fetchSalesIndentData();
            callCustomerApi();
        }

        if (IndentName.equals("UPLOAD DATA")) {

//            cScanDetails = dbSalesIndent.rawQuery("select * from SalesIndentDetails", null);
//            if ((cScanDetails.getCount() == 0)) {
//                DeleteSalesIndentDetails();
//                createTableSalesIndentDetails();
//
//
//            } else {
//
//                createTableSalesIndentDetails();
//                SynNetWorkCheck();
//
//            }
            uploadSalesIndentRequestData();

        }


        if (IndentName.equals("SALES INDENT")) {
            if (appSharedPreferences.get_version() == getcurrentversioncode()) {
                Intent intent = new Intent(this, TMSalesIndentActivity.class);
                intent.putExtra("Po_code", POCodeGet);
                intent.putExtra("Po_name", PONameGet);
                intent.putExtra("Tm_name", TerritoryNameGet);
                intent.putExtra("Post_code", PostCodeTransferGet);
                intent.putExtra("Site_ID", SiteGet);
                intent.putExtra("Division_code", DivisionGet);

                startActivity(intent);
            } else {
                new AlertDialog.Builder(this).setTitle("Please Update the App")
                        .setMessage("A new version of this app is available. Please update it").setPositiveButton(
                                "OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                        try {
                                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                        } catch (android.content.ActivityNotFoundException anfe) {
                                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                                        }


                                    }
                                }).setCancelable(false).show();
            }


        }

        if (IndentName.equals("INDENT STATUS")) {
//            Toast.makeText(this, "It is under process", Toast.LENGTH_SHORT).show();
//            if (sessionManager.get_version() == getcurrentversioncode()) {
            Intent intent = new Intent(this, TMReportViewActivity.class);
            intent.putExtra("Po_code", POCodeGet);
            intent.putExtra("Po_name", PONameGet);
            intent.putExtra("Tm_name", TerritoryNameGet);
            intent.putExtra("Post_code", PostCodeTransferGet);
            intent.putExtra("Site_ID", SiteGet);
            intent.putExtra("Division_code", DivisionGet);
            startActivity(intent);
//            } else {
//                new AlertDialog.Builder(this).setTitle("Please Update the App")
//                        .setMessage("A new version of this app is available. Please update it").setPositiveButton(
//                                "OK", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
//                                        try {
//                                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                                        } catch (android.content.ActivityNotFoundException anfe) {
//                                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//                                        }
//
//
//                                    }
//                                }).setCancelable(false).show();
//            }


        }


        if (IndentName.equals("LOGOUT")) {

            SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                List<SalesIndentRequestDetailsEntity> allSalesIndentRequestDetails = salesIndentDataBase.salesIndentDetailsDao().getAllSalesIndentRequestDetails();

                if (allSalesIndentRequestDetails != null && allSalesIndentRequestDetails.size() > 0) {
                    runOnUiThread(() -> {
                        Toast.makeText(this, "Please Upload The Data Then Logout", Toast.LENGTH_SHORT).show();
                    });
                } else {
                    clearDB();
                    runOnUiThread(() -> {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    });

                }
            });


        }

        if (IndentName.equals("EXIT")) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

    }

    private void clearDB() {
        appSharedPreferences.putLoginRole(null);
        appSharedPreferences.putUserId(null);
        appSharedPreferences.putName(null);
        appSharedPreferences.putIsTM(false);
        appSharedPreferences.putIsAM(false);
        appSharedPreferences.putIsRbM(false);
        appSharedPreferences.putIsDbM(false);
        appSharedPreferences.put_ZM("");
        appSharedPreferences.clear();
        salesIndentDataBase.seasonDao().deleteAllSeasonDetails();
        salesIndentDataBase.materialDao().deleteAllMaterialDetails();
        salesIndentDataBase.customerDao().deleteAllCustomerData();
    }

    public void TMSalesPlanActivity(View view) {

        Intent intent = new Intent(this, TMSalesIndentActivity.class);
        intent.putExtra("Po_code", POCodeGet);
        intent.putExtra("Po_name", PONameGet);
        intent.putExtra("Tm_name", TerritoryNameGet);
        intent.putExtra("Post_code", PostCodeTransferGet);
        intent.putExtra("Site_ID", SiteGet);
        startActivity(intent);
    }

    public void POEventRecorder(View view) {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            //Intent intent = new Intent(this, ModifyApprovalActivity.class);
            // intent.putExtra("Po_code", POCodeGet);
            //intent.putExtra("Po_name", PONameGet);
            // intent.putExtra("Tm_name", TerritoryNameGet);
            //  intent.putExtra("Post_code", PostCodeTransferGet);
            // startActivity(intent);

        } else {

            //Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }

    public void POBulkApproval(View view) {

        // Intent intent = new Intent(this, TMBulkApprovalActivity.class);
        // intent.putExtra("Po_code", POCodeGet);
        // intent.putExtra("Po_name", PONameGet);
        //intent.putExtra("Tm_name", TerritoryNameGet);
        // intent.putExtra("Post_code", PostCodeTransferGet);
        //  startActivity(intent);
    }

    public void BulkApprovalupload(View view) {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            //  Intent intent = new Intent(this, BulkActionSelectionActivity.class);
            // intent.putExtra("Po_code", POCodeGet);
            // intent.putExtra("Po_name", PONameGet);
            // intent.putExtra("Tm_name", TerritoryNameGet);
            // intent.putExtra("Post_code", PostCodeTransferGet);
            //  startActivity(intent);


        } else {

            //Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
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
                                    TMScreenActivity.this,
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

                        //13.12.2016 modified
                        //finish();

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

    private void fetchSalesIndentData() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            if (isTableExists(dbSalesIndent, "SalesIndentDetails")) {
//                Toast.makeText(this, "Please Upload The Data Then Click Getmaster", Toast.LENGTH_SHORT).show();
            } else {
                DeleteGetMasterDatabase();
                createTableGetMasterDatabase();


                totalcounts = 0;
                linechecks = 1;


                autocountsun = 1;


                if (autocountsun == 1) {
                    prgDialog.show();

                }
                if (autocountsun == 9) {
                    // prgDialog.hide();

                }


                if (fistautosyn.equals(true)) {
                    if (autocountsun == 1) {

                        sCustomerInput = "CustMaster";

                        autocountsun = autocountsun + 1;
                        fetchAllGetApiData();

                    }


                }
            }

        } else {

            //Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }

    private void GetSyn8() {

        prgDialog.show();

        GetmasterCheck = "";


        if (autocountsun == 2) {

            syninput2 = "InventMaster";
            sInventInput = "InventMaster";
            autocountsun = autocountsun + 1;
            fetchAllGetApiData();


        } else {
            if (autocountsun == 3) {
                sCropInput = "CropMaster";


                /*if (Oroot.canWrite())

                {

                    File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
                    dir.mkdirs();

                    PFOfilSynFile = new File(dir, "ISWarehouseMaster.csv");


                }
                PFOfilSynFile.delete();*/
                autocountsun = autocountsun + 1;
                fetchAllGetApiData();


            } else {
                if (autocountsun == 4) {
                    sPackingInput = "SeedProcessPackingTable";


                 /*   if (Iroot.canWrite())

                    {

                        File dir = new File(Iroot.getAbsolutePath() + "/IndentMaster");
                        dir.mkdirs();

                        PFOfilSynFile = new File(dir, "ISItemMaster.csv");

                    }
                    PFOfilSynFile.delete();*/
                    autocountsun = autocountsun + 1;
                    fetchAllGetApiData();


                } else {
                    if (autocountsun == 5) {
                        sPriceInput = "PriceDiscMaster";


                     /*   if (Iroot.canWrite())

                        {

                            File dir = new File(Iroot.getAbsolutePath() + "/IndentMaster");
                            dir.mkdirs();

                            PFOfilSynFile = new File(dir, "ISCropMaster.csv");

                        }
                        PFOfilSynFile.delete();*/
                        autocountsun = autocountsun + 1;
                        fetchAllGetApiData();


                    } else {
//                        if (autocountsun == 6) {
//                            syninput6 = "InventMaster";
//
//
//                     /*   if (Iroot.canWrite())
//
//                        {
//
//                            File dir = new File(Iroot.getAbsolutePath() + "/IndentMaster");
//                            dir.mkdirs();
//
//                            PFOfilSynFile = new File(dir, "ISCropMaster.csv");
//
//                        }
//                        PFOfilSynFile.delete();*/
//                            autocountsun = autocountsun + 1;
//                            GetSynss();
//
//
//                        }
                    }


                }
            }

        }

    }

    // This method used for preparing api end point
    private void fetchAllGetApiData() {


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {

            if (sCustomerInput.equals("CustMaster")) {
                getDataApi = IPAddress + ProjectFolder + "/ISCustomerMasterTM.php?TMCode=" + POCodeGet;
            }

            if (sCropInput.equals("CropMaster")) {
                getDataApi = IPAddress + ProjectFolder + "/ISCropMaster.php";
            }
            if (sPackingInput.equals("SeedProcessPackingTable")) {
                getDataApi = IPAddress + ProjectFolder + "/ISSeedProcessPackingTable.php";
            }
            if (sPriceInput.equals("PriceDiscMaster")) {
                getDataApi = IPAddress + ProjectFolder + "/ISPriceMaster.php?TMCode=" + POCodeGet;
            }

            if (sInventInput.equals("InventMaster")) {
                getDataApi = IPAddress + ProjectFolder + "/ISInventMaster.php";
            }


            class GetApiDataJSONAsyncTask extends AsyncTask<String, Void, String> {


                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    HttpPost httppost = new HttpPost(getDataApi);
                    Log.e(TAG_RESULTS, getDataApi);

                    // Depends on your web service
                    httppost.setHeader("Content-type", "application/json");

                    InputStream inputStream = null;
                    String result = null;
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();

                        inputStream = entity.getContent();
                        // json is UTF-8 by default
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8);
                        StringBuilder sb = new StringBuilder();

                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        result = sb.toString();
                    } catch (Exception e) {
                        // Oops
                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {
                        }
                    }
                    return result;
                }

                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;

                    if (result != null) {
                        try {
                            showList2();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(TMScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.hide();


                    }


                }
            }
            GetApiDataJSONAsyncTask g = new GetApiDataJSONAsyncTask();
            g.execute();

        } else {
            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();
        }
    }


    protected void showList2() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {


            prgDialog.show();


            if (autocountsun >= 9) {
                prgDialog.hide();
            }


            try {
                JSONObject jsonObj = new JSONObject(myJSON);
                peoples = jsonObj.getJSONArray(TAG_RESULTS);

                for (int i = 0; i < peoples.length(); i++) {
                    JSONObject c = peoples.getJSONObject(i);
                    String Id;
                    String A;
                    String B;
                    String C;
                    String D;
                    String E;
                    String F;
                    if (getDataApi.contains("ISInventMaster.php")) {

                        A = c.getString(T2);
                        B = c.getString(T3);
                        C = c.getString(T4);
                        D = c.getString(T5);
                        E = c.getString(T6);
                        F = c.getString(T7);

                        HashMap<String, String> persons = new HashMap<String, String>();


                        persons.put(T2, A);
                        persons.put(T3, B);
                        persons.put(T4, C);
                        persons.put(T5, D);
                        persons.put(T6, E);
                        persons.put(T7, F);
                    } else {

                        Id = c.getString(T1);    //customer_code
//                        Id=c.getString("customer_code"); //id
                        A = c.getString(T2);    // customer_name
//                         A= c.getString("customer_name");
//                        String tmCode=c.getString("tm_code");
//                        String businessVertical=c.getString("business_vertical");
                        B = c.getString(T3);
                        C = c.getString(T4);
                        D = c.getString(T5);
                        E = c.getString(T6);
                        F = c.getString(T7);   // rbm_code
//                        F = c.getString("rbm_code");

                        // business_vertical


                        HashMap<String, String> persons = new HashMap<String, String>();

                        persons.put(T1, Id);
                        persons.put(T2, A);
//                        persons.put(T3, B);
//                        persons.put(T4, C);
//                        persons.put(T5, D);
//                        persons.put(T6, E);
                        persons.put(T7, F);
                    }

                    totalcounts = totalcounts + 1;
                }
                //  prgDialog.hide();

                totcounts.setText(String.valueOf(totalcounts));
                callApiAsyncTask();


            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG_RESULTS, "error " + e);

                Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();


                prgDialog.hide();

            }

        } else {

            //Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }


    protected void showList3() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            prgDialog.show();

            if (autocountsun >= 5) {
                // prgDialog.hide();
            }

            try {
                JSONObject jsonObj = new JSONObject(myJSON);
                peoples = jsonObj.getJSONArray(TAG_RESULTS);

                for (int i = 0; i < peoples.length(); i++) {
                    JSONObject c = peoples.getJSONObject(i);
                    String Id = "";
                    String A;
                    String B = "";
                    String C = "";
                    String D = "";
                    String E = "";
                    String F = "";
                    String G = "";
                    String H = "";
                    String I = "";
                    String J = "";
                    String K = "";
                    String M = "";
                    String N = "";
                    String L = "";
                    String O = "";
                    String P = "";
                    String Q = "";
                    String R = "";
                    if (getDataApi.contains("ISInventMaster.php")) {
                        A = c.getString(T2);
                        B = c.getString(T3);
                        C = c.getString(T4);
                        D = c.getString(T5);
                        E = c.getString(T6);
                        F = c.getString(T7);
                        HashMap<String, String> persons = new HashMap<String, String>();

                        persons.put(T2, A);
                        persons.put(T3, B);
                        persons.put(T4, C);
                        persons.put(T5, D);
                        persons.put(T6, E);
                        persons.put(T7, F);

                    } else {

//                        Id = c.getString(T1);
//                        A = c.getString(T2);
//                        B = c.getString(T3);
//                        C = c.getString(T4);
//                        D = c.getString(T5);
//                        E = c.getString(T6);
//                        F = c.getString(T7);
//                        G = c.getString(T8);
//                        H = c.getString(T9);
//                        I = c.getString(T10);
//                        J = c.getString(T11);
//                        K = c.getString(T12);
//                        L = c.getString(T13);

                        Id = c.getString(T1);    //customer_code
//                        Id=c.getString("customer_code"); //id
                        A = c.getString(T2);    // customer_name
//                        A= c.getString("customer_name");
//                        String tmCode=c.getString("tm_code");
//                        String businessVertical=c.getString("business_vertical");
                        B = c.getString(T3);
                        C = c.getString(T4);
                        D = c.getString(T5);
                        E = c.getString(T6);
                        F = c.getString(T7);   // rbm_code
//                        F = c.getString("rbm_code");

//                        M = c.getString(T14);
//                        N = c.getString(T15);
//                        O = c.getString(T16);
//                        P = c.getString(T17);
//                        Q = c.getString(T18);
//                        R = c.getString(T19);

                        HashMap<String, String> persons = new HashMap<String, String>();

                        persons.put(T1, Id);
                        persons.put(T2, A);
//                        persons.put(T3, B);
//                        persons.put(T4, C);
//                        persons.put(T5, D);
//                        persons.put(T6, E);
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
                    }


                    if (sCustomerInput.equals("CustMaster")) {


                        // String query = "INSERT INTO CustMaster ( AccountNum,Name,CustGroup,PostingProfile,CreditMax ,Blocked,RBMId,TmId,Dimension,State,SeedLicNo,GSTNumber_IN ,MandatoryCreditLimit  ) VALUES('" +Id +"','"+ A +"','"+ B+"','"+ C+"','"+D+"','"+ E+"','"+F+"','"+G+"','"+H+"','"+I +"','"+F+"','"+ G+"','"+H+"','"+I+"','"+J+"','"+K +"','"+L+"');";
                        A = A.replace("'", "''");
//                        B = B.replace("'","''");
//                        C = C.replace("'","''");
//                        D = D.replace("'","''");
//                        E = E.replace("'","''");
//                        F = F.replace("'","''");
//                        G = G.replace("'","''");
//                        H = H.replace("'","''");
//                        I = I.replace("'","''");
//                        J = J.replace("'","''");
//                        K = K.replace("'","''");
//                        L = L.replace("'","''");

//                        String query = "INSERT INTO CustMaster ( AccountNum,Name,CustGroup,PostingProfile,CreditMax ,Blocked,RBMId,TmId,Dimension,State,SeedLicNo,GSTNumber_IN ,MandatoryCreditLimit) " +
//                                "VALUES('" + Id + "','" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "','" + G + "','" + H + "','" + I + "','" + J + "','" + K + "','" + L + "');";
//                        dbGetmaster.execSQL(query);

                    }


                    if (syninput2.equals("ItemMaster")) {

                        String query = "INSERT INTO ItemMaster (RecID,ItemId,ItemName,ItemGroup,Uom,CropCode,CropName ) VALUES('" + Id + "','" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "');";
                        dbGetmaster.execSQL(query);

                    }


                    if (sCropInput.equals("CropMaster")) {

//                        String query = "INSERT INTO CropMaster (CropCode,Name,CropType ) VALUES('" + Id + "','" + A + "','" + B + "');";
//                        dbGetmaster.execSQL(query);

                    }


                    if (sPackingInput.equals("SeedProcessPackingTable")) {

                        String query = "INSERT INTO SeedProcessPackingTable ( PackingId,Description,UnitID,StdWeight,ConvFactor,PkgSize,CartonBoxSize)" +
                                " VALUES('" + Id + "','" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "');";
                        dbGetmaster.execSQL(query);

                    }


                    if (sPriceInput.equals("PriceDiscMaster")) {
                        String query = "INSERT INTO PriceDiscMaster (ItemRelation,AccountRelation,Price ) VALUES('" + Id + "','" + A + "','" + B + "');";
                        dbGetmaster.execSQL(query);

                    }

                    if (sInventInput.equals("InventMaster")) {

//                        String query = "INSERT INTO InventMaster (ItemId,ItemName, CropCode,CropName,Hybridname,PackingId) VALUES('" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "');";
//                        dbGetmaster.execSQL(query);

                    }

                    if (totalcounts == linechecks) {

                        if (sPriceInput.equals("PriceDiscMaster")) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    prgDialog.hide();
                                    showAlertDialog1(TMScreenActivity.this, " Data Import Successfully", true);

                                }

                            }, 2500);

                        }


                        sCustomerInput = "";
                        syninput2 = "";
                        sCropInput = "";
                        sPackingInput = "";
                        sPriceInput = "";
                        sInventInput = "";
                        syninput7 = "";
                        syninput8 = "";
                        syninput9 = "";

                        // prgDialog.hide();
                        Check = "Checkfile";
                        getDataApi = "";
                        totalcounts = 0;
                        linechecks = 1;
                        GetSyn8();
                    } else {
                        update.setText(String.valueOf(linechecks));
                        linechecks = linechecks + 1;
                    }

                    //  } catch (FileNotFoundException e) {
                    //  e.printStackTrace();
                    // Log.i(TAG, "******* File not found. Did you"
                    // + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
                    //  prgDialog.hide();
                    //  } catch (IOException e) {
                    //   e.printStackTrace();
                    //   prgDialog.hide();
                    //  }
                }


            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG_RESULTS, "error " + e);
                prgDialog.hide();
                Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();

            }

        } else {
            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);

            prgDialog.hide();


        }
    }

    public void callApiAsyncTask() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {

            //prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {


                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    HttpPost httppost = new HttpPost(getDataApi);

                    // Depends on your web service
                    httppost.setHeader("Content-type", "application/json");

                    InputStream inputStream = null;
                    String result = null;
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();

                        inputStream = entity.getContent();
                        // json is UTF-8 by default
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8);
                        StringBuilder sb = new StringBuilder();

                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        result = sb.toString();
                    } catch (Exception e) {
                        // Oops
                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {
                        }
                    }
                    return result;
                }

                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;
                    if (result != null) {
                        try {
                            showList3();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(TMScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.hide();


                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {

            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }

    private void SynNetWorkCheck() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {
            // Internet Connection exists
            //   showAlertDialog(MainActivity.this, "Internet Connection",
            // "Your device has WIFI internet access", true);


            prgDialog.show();


            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    //HttpPost httppost = new HttpPost("http://rasiaosit.16mb.com/getdata.php");


                    HttpPost httppost = new HttpPost(IPAddress + "NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost(IPAddress + "/kanagaraj/NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost(new_api.NetworkStatusCheck());
//                    HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/NetworkCheck/NetworkStatusCheck.php");


                    //HttpPost httppost = new HttpPost("http://172.16.3.21/HrAttendance.php");

                    // Depends on your web service
                    httppost.setHeader("Content-type", "application/json");

                    InputStream inputStream = null;
                    String result = null;
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();

                        inputStream = entity.getContent();
                        // json is UTF-8 by default
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8);
                        StringBuilder sb = new StringBuilder();
                        // List<String> codes = new ArrayList<String>();
                        // String line = null;
                        String line = "";
                        int lineNumber = 0;

                        while ((line = reader.readLine()) != null) {

                            sb.append(line + "\n");
                        }


                        result = sb.toString();


                    } catch (Exception e) {

                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {

                        }
                    }
                    return result;
                }

                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;
                    if (result != null) {
                        try {
                            Syn();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            ///////////////////////////////////

                            dbSalesIndent.execSQL("ALTER TABLE SalesIndentDetails ADD COLUMN Remarks VARCHAR");

                            Toast.makeText(TMScreenActivity.this, "Error1", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.hide();


                    }


                }
            }


            GetDataJSON g = new GetDataJSON();
            g.execute();


        } else {

            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }

    private void Syn() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {


            IndnetLinedataSyn();


        } else {

            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }

    private void SynNetWorkCheckfunctionsLine() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        prgDialog.show();

        if (isConnectionExist || isConnectionExistMobile) {
            // Internet Connection exists
            //   showAlertDialog(MainActivity.this, "Internet Connection",
            // "Your device has WIFI internet access", true);


            // prgDialog.show();


            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    //HttpPost httppost = new HttpPost("http://rasiaosit.16mb.com/getdata.php");

                    HttpPost httppost = new HttpPost(IPAddress + "NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost(IPAddress + "/kanagaraj/NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost(new_api.NetworkStatusCheck());
//                    HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/NetworkCheck/NetworkStatusCheck.php");


                    //HttpPost httppost = new HttpPost("http://172.16.3.21/HrAttendance.php");

                    // Depends on your web service
                    httppost.setHeader("Content-type", "application/json");

                    InputStream inputStream = null;
                    String result = null;
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();

                        inputStream = entity.getContent();
                        // json is UTF-8 by default
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8);
                        StringBuilder sb = new StringBuilder();
                        // List<String> codes = new ArrayList<String>();
                        // String line = null;
                        String line = "";
                        int lineNumber = 0;

                        while ((line = reader.readLine()) != null) {

                            sb.append(line + "\n");
                        }


                        result = sb.toString();


                    } catch (Exception e) {

                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {

                        }
                    }
                    return result;

                }

                @Override
                protected void onPostExecute(String result) {
                    //  myJSON = result;


                    if (result != null) {
                        try {
                            Syns1();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(TMScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.hide();
                        fisttimecount = true;
                        totalcountPoevent = 0;


                    }


                }
            }

            isConnectionExist = cd.checkMobileInternetConn();
            isConnectionExistMobile = cd.checkMobileInternetConns();


            if (isConnectionExist || isConnectionExistMobile) {

                GetDataJSON g = new GetDataJSON();
                g.execute();
            } else {


                // Internet connection doesn't exist
                showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.hide();
                fisttimecount = true;
                totalcountPoevent = 0;

            }


        } else {


            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);

            prgDialog.hide();
            fisttimecount = true;
            totalcountPoevent = 0;
        }
    }

    private void IndnetLinedataSyn() {

        fisttimecount = true;
        totalcountPoevent = 0;


        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            prgDialog.show();


            if (isTableExists(dbSalesIndent, "SalesIndentDetails")) {


                if (fisttimecount.equals(true)) {


                    cScanDetails = dbSalesIndent.rawQuery("select MAX(id) from SalesIndentDetails ", null);


                    if (cScanDetails.moveToFirst()) {

                        do {


                            totalcountPoevent = Integer.parseInt(cScanDetails.getString(0));


                        } while (cScanDetails.moveToNext());

                    }

                    // closing connection
                    //  c.close();
                    // db.close();


                    fisttimecount = false;

                    Syns1();


                } else {

                    if (Syncomplete.equals(false)) {
                        Toast.makeText(getApplicationContext(), " Already Syn completed ", Toast.LENGTH_LONG).show();
                        prgDialog.hide();
                    } else {
                        Toast.makeText(getApplicationContext(), " Syn in progress", Toast.LENGTH_LONG).show();
                        prgDialog.hide();
                    }
                }


            } else {
                Log.e(TAG_RESULTS, "error");
                Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_LONG).show();
                Check = "Checkfile";
                prgDialog.hide();
            }

        } else {
            {

                // Internet connection doesn't exist
                showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.hide();

            }

        }
    }

    private void Syns1() {

        DecimalFormat formatter = new DecimalFormat("0.00");
        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {


            int lineNumber = 1;

            if (isTableExists(dbSalesIndent, "SalesIndentDetails")) {

                cScanDetails = dbSalesIndent.rawQuery("select * from SalesIndentDetails ", null);


                if (cScanDetails.moveToFirst()) {


                    do {

                        if (lineNumber == linecheckPoevent) {


                            IndentCreationCode = cScanDetails.getString(1);
                            Slno = cScanDetails.getString(2);
                            strDate = cScanDetails.getString(3);
                            strTime = cScanDetails.getString(4);
                            CustomerAccounts = cScanDetails.getString(5);

                            CustomerName = cScanDetails.getString(6);

                            CropNames = cScanDetails.getString(8);
                            CropTypes = cScanDetails.getString(7);

                            Hybrids = cScanDetails.getString(9);
                            ItemNames = cScanDetails.getString(10);
                            Qty2 = cScanDetails.getString(11);
                            TerritoryNameGet = cScanDetails.getString(12);
                            PoState = cScanDetails.getString(13);
                            PoRegion = cScanDetails.getString(14);
                            POCodeGet = cScanDetails.getString(15);
                            Sites = cScanDetails.getString(16);
                            Warehouses = cScanDetails.getString(17);
                            ExpectedDate = cScanDetails.getString(18);
                            TMId = cScanDetails.getString(19);
                            SPrice = cScanDetails.getString(20);
                            SAmount = cScanDetails.getString(21);
                            PkgSizes = cScanDetails.getString(22);
                            PkgName = cScanDetails.getString(23);
                            UomValue = cScanDetails.getString(24);
//                            notify = cScanDetails.getString(25).toString();


                            ProcessingId = cScanDetails.getString(7);

                            try {
                                Remarks = cScanDetails.getString(25);
                            } catch (Exception e) {
                                Remarks = "";
                            }

                            TerritoryNameGet = PONameGet;


                            Double OrderValueTot = Double.valueOf(formatter.format(Double.parseDouble(SAmount)));

                            SAmount = OrderValueTot.toString();

                            insert1();


                        }

                        lineNumber = lineNumber + 1;

                    } while (cScanDetails.moveToNext());


                }

            }


        } else {


            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Synchronization Not Completed", Toast.LENGTH_LONG).show();

            prgDialog.hide();
            fisttimecount = true;
            totalcountPoevent = 0;
        }

    }

    public void insert1() {


        String IndentCreationCode1 = IndentCreationCode;
        String Slno1 = Slno;
        String strDate1 = strDate;
        String strTime1 = strTime;
        String CustomerAccounts1 = CustomerAccounts;
        String CustomerName1 = CustomerName;
        String CropNames1 = CropNames;
        String CropTypes1 = CropTypes;
        String Hybrids1 = Hybrids;
        String Qty21 = Qty2;
        String TerritoryNameGet1 = TerritoryNameGet;
        String PoState1 = PoState;
        String PoRegion1 = PoRegion;
        String POCodeGet1 = POCodeGet;
        String Sites1 = Sites;
        String Warehouses1 = Warehouses;
        String ExpectedDate1 = ExpectedDate;
        String ItemNames1 = ItemNames;
        String TMId1 = TMId;
        String SPrice1 = SPrice;
        String SAmount1 = SAmount;

        String PkgSizes1 = PkgSizes;
        String PkgName1 = PkgName;
        String UomValue1 = UomValue;
//        String notify1=notify.toString();
        String Acting = this.Acting;
        String DCode = this.DCode;

        String processFinggid = ProcessingId;


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            insertToDatabase1(IndentCreationCode1, Slno1, strDate1, strTime1, CustomerAccounts1, CustomerName1, CropNames1, CropTypes1, Hybrids1, Qty21, TerritoryNameGet1, PoState1, PoRegion1, POCodeGet1, Sites1, Warehouses1, ExpectedDate1, ItemNames1, TMId1, SPrice1, SAmount1, PkgSizes1, PkgName1, UomValue1, Acting, DCode);


        } else {


            // Internet connection doesn't exist
            showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Syn Not Completed", Toast.LENGTH_LONG).show();


            prgDialog.hide();
            fisttimecount = true;
            totalcountPoevent = 0;


        }


    }

    // private void insertToDatabase(String FielOrder, String GroweCode,String GroweName, String FatName,String VillgName,String FCode,String VarietCode,String SowinDate ,String InspectioCode,String Inspectescription,String InspectioDate,String Totabolls,String BolWeight,String Estimateyield,String KapasOnhand,String Assesmenyield,String CrossingSDate ,String CrossingEDate ){
    private void insertToDatabase1(String IndentCreationCode1, String Slno1, String strDate1, String strTime1, String CustomerAccounts1, String CustomerName1, String CropNames1, String CropTypes1, String Hybrids1, String Qty21, String TerritoryNameGet1, String PoState1, String PoRegion1, String POCodeGet1, String Sites1, String Warehouses1, String ExpectedDate1, String ItemNames1, String TMId1, String SPrice1, String SAmount1, String PkgSizes1, String PkgName1, String UomValue1, final String Acting, final String DCode) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String notify = "1";
                String paramUsername = params[0];
                String paramAddress = params[1];

                String IndentCreationCode1 = IndentCreationCode;
                String Slno1 = Slno;
                String strDate1 = strDate;
                String strTime1 = strTime;
                String CustomerAccounts1 = CustomerAccounts;
                String CustomerName1 = CustomerName;
                String CropNames1 = CropNames;
                String CropTypes1 = CropTypes;
                String Hybrids1 = Hybrids;
                String Qty21 = Qty2;
                String TerritoryNameGet1 = TerritoryNameGet;
                String PoState1 = PoState;
                String PoRegion1 = PoRegion;
                String POCodeGet1 = POCodeGet;
                String Sites1 = Sites;
                String Warehouses1 = Warehouses;
                String ExpectedDate1 = ExpectedDate;
                String ItemNames1 = ItemNames;
                String TMId1 = TMId;
                String SPrice1 = SPrice;
                String SAmount1 = SAmount;
                String PkgSizes1 = PkgSizes;
                String PkgName1 = PkgName;
                String UomValue1 = UomValue;
//                String notify1=notify.toString();
                String acting = Acting;
                String dcode = DCode;
                String processinggid = ProcessingId;
                String remarks = null;
                try {
                    remarks = Remarks;
                } catch (Exception e) {
                    remarks = "";
                    e.printStackTrace();
                }

                if (old_indent_no.equals(IndentCreationCode1)) {
                    notify = "0";
                } else {
                    notify = "1";
                    old_indent_no = IndentCreationCode1;
                }

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("IndentNo", IndentCreationCode1));
                nameValuePairs.add(new BasicNameValuePair("SlNo", Slno1));
                nameValuePairs.add(new BasicNameValuePair("IndentDate", strDate1));
                nameValuePairs.add(new BasicNameValuePair("IndentTime", strTime1));
                nameValuePairs.add(new BasicNameValuePair("CustCode", CustomerAccounts1));
                nameValuePairs.add(new BasicNameValuePair("CustName", CustomerName1));

                nameValuePairs.add(new BasicNameValuePair("CropName", CropNames1));

                nameValuePairs.add(new BasicNameValuePair("CropType", CropTypes1));
                nameValuePairs.add(new BasicNameValuePair("ItemID", Hybrids1));
                nameValuePairs.add(new BasicNameValuePair("IndentQty", Qty21.trim()));
                nameValuePairs.add(new BasicNameValuePair("TMCode", POCodeGet1));
                nameValuePairs.add(new BasicNameValuePair("Territory", TerritoryNameGet1));
                nameValuePairs.add(new BasicNameValuePair("StateCode", PoState1));
                nameValuePairs.add(new BasicNameValuePair("Region", PoRegion1));
                nameValuePairs.add(new BasicNameValuePair("Site", Sites1));
                nameValuePairs.add(new BasicNameValuePair("Warehouse", Warehouses1));
                nameValuePairs.add(new BasicNameValuePair("ExpectedDate", ExpectedDate1));
                nameValuePairs.add(new BasicNameValuePair("ItemName", ItemNames1));
                nameValuePairs.add(new BasicNameValuePair("TMId", TMId1));
                nameValuePairs.add(new BasicNameValuePair("SalesPrice", SPrice1));
                nameValuePairs.add(new BasicNameValuePair("LineAmount", SAmount1));
                nameValuePairs.add(new BasicNameValuePair("notify", notify));

                nameValuePairs.add(new BasicNameValuePair("PackingId", PkgSizes1.trim()));
                nameValuePairs.add(new BasicNameValuePair("Description", PkgName1));
                nameValuePairs.add(new BasicNameValuePair("UnitID", UomValue1));
                nameValuePairs.add(new BasicNameValuePair("Acting", acting));
                nameValuePairs.add(new BasicNameValuePair("Dcode", dcode));

                nameValuePairs.add(new BasicNameValuePair("processingItem", processinggid));

                nameValuePairs.add(new BasicNameValuePair("remarks", remarks));

                Log.d("Result-----", "-----" + nameValuePairs);

                InputStream inputStream = null;

                Log.e("TAG", nameValuePairs.toString());
                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    //HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/kanagaraj/IndentSales/ISIndentLineDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentLineDataSynInsert.php");

                    //HttpPost httpPost = new HttpPost("http://10.10.2.34/kanagaraj/IndentSales/ISIndentLineDataSynInsert.php");


                    //   HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/Testing/APEventDataSynInsert.php");
                    ////                    HttpPost httpPost = new HttpPost(IPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentLineDataSynInsert.php");
                    ////                    HttpPost httpPost = new HttpPost(new_api.ISIndentLineDataSynInsert(ProjectFolder));


                    // HttpPost httpPost = new HttpPost(IPAddress+ProjectFolder+"/ISIndentLineDataSynInsert.php");
                    HttpPost httpPost = new HttpPost(IPAddress + "ProjecettFolder" + "/ISIndentLineDataSynInsert_test.php");
//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentLineDataSynInsert.php");

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    int status = response.getStatusLine().getStatusCode();
                    ResponseCheckLine = String.valueOf(status);


                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8), 8);
                    StringBuilder sb = new StringBuilder();
                    // List<String> codes = new ArrayList<String>();
                    // String line = null;
                    String line = "";
                    int lineNumber = 0;

                    while ((line = reader.readLine()) != null) {

                        sb.append(line + "\n");
                    }


                    Log.e("tn", sb.toString());


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";
            }


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                Log.e("TAG-1", result);

//                DeleteSalesIndentDetails();
//                createTableSalesIndentDetails();

                if (totalcountPoevent == linecheckPoevent) {


                    // Toast.makeText(getApplicationContext(), "Synchronization Completed", Toast.LENGTH_LONG).show();
                    showAlertDialog1(TMScreenActivity.this, " Data Uploaded Successfully", true);
                    Syncomplete = false;

                    prgDialog.hide();

                    Checks = "Checkfile";
                    // APEvenetDataFile.renameTo(FileEventDatMovefile);
                    // ISLineDataFile.delete();
                    //  totcounts.setVisibility(View.GONE);
                    // update.setVisibility(View.GONE);
                    //  totcounts.setText("");
                    //update.setText("");

                    DeleteSalesIndentDetails();
                    createTableSalesIndentDetails();

                    linecheckPoevent = 1;
                    totalcountPoevent = 0;
                    fisttimecount = true;


                } else {

                    if (ResponseCheckLine.equals("200")) {
                        ResponseCheckLine = "";

                        update.setText("SynCnt:" + linecheckPoevent);
                        linecheckPoevent = linecheckPoevent + 1;
                        Log.e("linecheckPoevent", String.valueOf(linecheckPoevent));

                        SynNetWorkCheckfunctionsLine();
                        //  Syns();

                    } else {

                        // Internet connection doesn't exist
                        showAlertDialog(TMScreenActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);


                        prgDialog.hide();
                        fisttimecount = true;
                        totalcountPoevent = 0;


                    }
                }
            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        // sendPostReqAsyncTask.execute(FielOrder,GroweCode,GroweName,FatName,VillgName,FCode,VarietCode,SowinDate,InspectioCode,Inspectescription,InspectioDate,Totabolls,BolWeight,Estimateyield,KapasOnhand,Assesmenyield,CrossingSDate,CrossingEDate);
        sendPostReqAsyncTask.execute(IndentCreationCode1, Slno1, strDate1, strTime1, CustomerAccounts1, CustomerName1, CropNames1, CropTypes1, Hybrids1, Qty21, TerritoryNameGet1, PoState1, PoRegion1, POCodeGet1, Sites1, Warehouses1, ExpectedDate1, ItemNames1, TMId1, SPrice1, SAmount1, PkgSizes1, PkgName1, UomValue1);


    }

    /*@Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are You Sure?");


        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                finish();



             //   moveTaskToBack(true);
               // android.os.Process.killProcess(android.os.Process.myPid());
               // System.exit(1);

              //  dialog.dismiss();





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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tmsreen, menu);
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
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        }, 500);
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

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        super.onDestroy();
    }

    public void deletefile() {

        // Server Request URL
        String serverURL = "http://10.20.1.37:8080/kanagaraj/IT004/GpDeleteOut.php";

        // Create Object and call AsyncTask execute Method
//        new LongOperation().execute(serverURL);


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
                TMScreenActivity.this);

        alertDialog.setTitle(provider + " SETTINGS");

        alertDialog
                .setMessage(provider + " is not enabled! Want to go to settings menu?");

        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);

                        TMScreenActivity.this.startActivity(intent);


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

    protected void createDatabaseGetMaster() {
        // db=openOrCreateDatabase("CNFBagDetailsDB", Context.MODE_PRIVATE, null);
        // db.execSQL("CREATE TABLE IF NOT EXISTS CNFBagDetails(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, BagNo VARCHAR);");


        dbGetmaster = openOrCreateDatabase(Getmasterpath.getPath(), Context.MODE_PRIVATE, null);


    }

    protected void createDatabaseSalesIndentData() {


        dbSalesIndent = openOrCreateDatabase(SalesIndentPath.getPath(), Context.MODE_PRIVATE, null);


    }

    protected void createTableGetMasterDatabase() {

        // CustTable.AccountNum,CustTable.Name ,CustTable.CustGroup,CustTable.PostingProfile,CustTable.CreditMax,CustTable.Blocked,CustTable.RBMId,CustTable.TmId,CustTable.Dimension,CustTable.State,CustTable.SeedLicNo,CustTable.GSTNumber_IN,CustTable.MandatoryCreditLimit

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS CustMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, AccountNum VARCHAR,Name VARCHAR,CustGroup VARCHAR, PostingProfile VARCHAR, CreditMax REAL ,Blocked INTEGER,RBMId VARCHAR,TmId VARCHAR,Dimension VARCHAR,State VARCHAR,SeedLicNo VARCHAR,GSTNumber_IN VARCHAR,MandatoryCreditLimit INTEGER);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS ItemMaster (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, RecID VARCHAR,ItemId VARCHAR, ItemName VARCHAR,ItemGroup VARCHAR,Uom VARCHAR,CropCode VARCHAR,CropName VARCHAR );");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS CropMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CropCode VARCHAR,Name VARCHAR,CropType VARCHAR);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS SeedProcessPackingTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,StdWeight REAL,ConvFactor  REAL, PkgSize VARCHAR,CartonBoxSize REAL);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS PriceDiscMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ItemRelation VARCHAR,AccountRelation VARCHAR,Price REAL);");

//newly added
        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS InventMaster (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ItemId VARCHAR,ItemName VARCHAR, CropCode VARCHAR,CropName VARCHAR,Hybridname VARCHAR,PackingId VARCHAR );");


    }

    protected void createTableGetMasterDatabaseFinish() {


        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS CustMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, AccountNum VARCHAR,Name VARCHAR,CustGroup VARCHAR, PostingProfile VARCHAR, CreditMax REAL ,Blocked INTEGER,RBMId VARCHAR,TmId VARCHAR,Dimension VARCHAR,State VARCHAR,SeedLicNo VARCHAR,GSTNumber_IN VARCHAR,MandatoryCreditLimit INTEGER);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS ItemMaster (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, RecID VARCHAR,ItemId VARCHAR, ItemName VARCHAR,ItemGroup VARCHAR,Uom VARCHAR,CropCode VARCHAR,CropName VARCHAR );");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS CropMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CropCode VARCHAR,Name VARCHAR,CropType VARCHAR);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS SeedProcessPackingTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,StdWeight REAL,ConvFactor  REAL, PkgSize VARCHAR,CartonBoxSize REAL);");


        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS PriceDiscMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ItemRelation VARCHAR,AccountRelation VARCHAR,Price REAL);");

//newly added
        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS InventMaster (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ItemId VARCHAR,ItemName VARCHAR, CropCode VARCHAR,CropName VARCHAR,Hybridname VARCHAR,PackingId VARCHAR );");


        finish();


    }

    private void DeleteGetMasterDatabase() {


        String DATABASE_TABLE_CustMaster = "CustMaster";
        String DATABASE_TABLE_ItemMaster = "ItemMaster";
        String DATABASE_TABLE_CropMaster = "CropMaster";
        String DATABASE_TABLE_SeedProcessPackingTable = "SeedProcessPackingTable";
        String DATABASE_TABLE_PriceDiscMaster = "PriceDiscMaster";
        String DATABASE_TABLE_InventMaster = "InventMaster";


        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_CustMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_ItemMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_CropMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SeedProcessPackingTable + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_PriceDiscMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_InventMaster + "'");


    }

    protected void createTableSalesIndentDetails() {

//id
        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentDetails(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR,LineNum REAL,IndentDate DATETIME, IndentTime VARCHAR, CustCode VARCHAR ,CustName VARCHAR,CropName VARCHAR,CropType VARCHAR, ItemID VARCHAR,ItemName VARCHAR,IndentQty REAL,Territory VARCHAR, StateCode VARCHAR,Region VARCHAR,TMCode VARCHAR,Site VARCHAR,Warehouse VARCHAR,ExpectedDate DATETIME, TMId VARCHAR,SalesPrice REAL,LineAmount REAL,PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,Remarks VARCHAR);");//Remarks


    }

    protected void createTableSalesIndentDetailsTemp() {
//id
        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentDetailsTemp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR ,IndentDate DATETIME, IndentTime VARCHAR, CustCode VARCHAR ,CustName VARCHAR,CropName VARCHAR,CropType VARCHAR, ItemID VARCHAR,ItemName VARCHAR,IndentQty REAL,Site VARCHAR,Warehouse VARCHAR,ExpectedDate DATETIME,SalesPrice REAL,LineAmount REAL,PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,Remarks VARCHAR);");

    }

    private void DeleteSalesIndentDetails() {

        String DATABASE_TABLE_SalesIndentDetails = "SalesIndentDetails";

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SalesIndentDetails + "'");


    }

    private void DeleteSalesIndentDetailsTemp() {

        String DATABASE_TABLE_SalesIndentDetailsTemp = "SalesIndentDetailsTemp";

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SalesIndentDetailsTemp + "'");


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

            }, 600);
        } else {
            snackbar_text.setVisibility(View.VISIBLE);
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

                POCodeGet = country[1];
                PONameGet = country[2];
                TerritoryNameGet = country[3];
                PostCodeTransferGet = country[5];
                SiteGet = country[13];
                DivisionGet = country[15];
                Acting = country[16];
                DCode = country[18];
            }
        } catch (Exception e) {
            System.err.println("CSV file cannot be read : " + e);
            //  Toast.makeText(getApplicationContext(), "CSV file  cannot be read or Opened ", Toast.LENGTH_LONG).show();
            prgDialog.hide();
        }
    }

    // Class with extends AsyncTask class
    public void callCustomerApi() {
        if (prgDialog != null) {
            prgDialog.show();
        }
        Call<CustomerMasterResponse> call = apiInterface.getCustomerResponseDetails(appSharedPreferences.getDivision(), appSharedPreferences.getTerritoryId());
        call.enqueue(new Callback<CustomerMasterResponse>() {
            @Override
            public void onResponse(Call<CustomerMasterResponse> call, Response<CustomerMasterResponse> response) {
                Log.d("TMScreenActivity", response.code() + "" + response.body().toString());
                CustomerMasterResponse customerResponse = response.body();

                if (customerResponse.getAcsenCustomerMasterRes() != null && customerResponse.getAcsenCustomerMasterRes().size() > 0) {

                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        for (CustomerMasterDetailsResponse detailsResponse : customerResponse.getAcsenCustomerMasterRes()) {

                            CustomerEntity customerEntity = new CustomerEntity();
                            customerEntity.setSalesOrganization(detailsResponse.getSalesOrganization());
                            customerEntity.setDivision(detailsResponse.getDivision());
                            customerEntity.setDistributionChannel(detailsResponse.getDistributionChannel());
                            customerEntity.setCustomerName(detailsResponse.getCustomerName());
                            customerEntity.setCustomerCode(detailsResponse.getCustomerCode());
                            customerEntity.setTerritoryId(detailsResponse.getTerritoryId());
                            customerEntity.setStateId(detailsResponse.getStateId());
                            customerEntity.setSales_office(detailsResponse.getSales_office());
                            salesIndentDataBase.customerDao().insertAll(customerEntity);
                        }
                        Log.d("TMScreenActivity fetch from db", salesIndentDataBase.customerDao().getAllCustomers().toString());
                    });
                }

                callMaterialAndSeasonApi();
            }

            @Override
            public void onFailure(Call<CustomerMasterResponse> call, Throwable t) {
                call.cancel();
                if (prgDialog != null) {
                    prgDialog.hide();
                }
            }
        });


    }


    public void callMaterialAndSeasonApi() {
        Call<MaterialSeasonResponse> call = apiInterface.getMaterialAndSeasonResponseDetails(appSharedPreferences.getDivision(), appSharedPreferences.getTerritoryId());
        call.enqueue(new Callback<MaterialSeasonResponse>() {
            @Override
            public void onResponse(Call<MaterialSeasonResponse> call, Response<MaterialSeasonResponse> response) {
                Log.d("TMScreenActivity", response.code() + "" + response.body().toString());
                MaterialSeasonResponse materialSeasonResponse = response.body();
                if (materialSeasonResponse.getAcsenMaterialMasterRes() != null && materialSeasonResponse.getAcsenMaterialMasterRes().size() > 0) {
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        for (MaterialMasterDetailResponse detailResponse : materialSeasonResponse.getAcsenMaterialMasterRes()) {
                            MaterialEntity materialEntity = new MaterialEntity();
                            materialEntity.setMaterialCode(detailResponse.getMaterialCode());
                            materialEntity.setMaterialName(detailResponse.getMaterialName());
                            materialEntity.setBaseUom(detailResponse.getBaseUom());
                            materialEntity.setCropCode(detailResponse.getCropCode());
                            materialEntity.setCropName(detailResponse.getCropName());
                            materialEntity.setVarietyCode(detailResponse.getVarietyCode());
                            materialEntity.setVarietyName(detailResponse.getVarietyName());
                            materialEntity.setPackingQuantity(detailResponse.getPackingQuantity());
                            salesIndentDataBase.materialDao().insertAll(materialEntity);
                        }
                        Log.d("TMScreenActivity fetch from db", salesIndentDataBase.materialDao().getAllCropDetails().toString());

                    });
                } else {
                    Toast.makeText(TMScreenActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }

                if (materialSeasonResponse.getAcsenSeasonMasterRes() != null && materialSeasonResponse.getAcsenSeasonMasterRes().size() > 0) {
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        for (SeasonMasterDetailsResponse detailsResponse : materialSeasonResponse.getAcsenSeasonMasterRes()) {
                            SeasonEntity seasonEntity = new SeasonEntity();
                            seasonEntity.setSeasonCode(detailsResponse.getSeasonCode());
                            seasonEntity.setSeasonName(detailsResponse.getSeasonName());
                            seasonEntity.setCropCode(detailsResponse.getCropCode());
                            seasonEntity.setCropName(detailsResponse.getCropName());
                            seasonEntity.setDescription(detailsResponse.getDescription());
                            seasonEntity.setState(detailsResponse.getState());
                            seasonEntity.setSeasonStartDate(detailsResponse.getSeasonStartDate());
                            seasonEntity.setSeasonEndDate(detailsResponse.getSeasonEndDate());
                            seasonEntity.setReturnCutOffDate(detailsResponse.getReturnCutOffDate());
                            salesIndentDataBase.seasonDao().insertAll(seasonEntity);
                        }
                        Log.d("TMScreenActivity fetch from db", salesIndentDataBase.seasonDao().getAllSeasons().toString());


                    });
                }
                runOnUiThread(() -> {
                    if (prgDialog != null) {
                        prgDialog.hide();
                    }
                    showAlertDialog1(TMScreenActivity.this, " Data Import Successfully", true);

                });
            }

            @Override
            public void onFailure(Call<MaterialSeasonResponse> call, Throwable t) {
                call.cancel();
                if (prgDialog != null) {
                    prgDialog.hide();
                }
            }
        });
    }

    private int i = 1;

    private void uploadSalesIndentRequestData() {
        prgDialog.show();
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<SalesIndentRequestDetailsEntity> requestDetails = SalesIndentDataBase.getDataBase(TMScreenActivity.this).salesIndentDetailsDao().getAllSalesIndentRequestDetails();
            Log.d("Request Details", requestDetails.toString());
            if (requestDetails != null && requestDetails.size() > 0) {
                requestDetails.stream().forEach(salesIndentRequestDetailsEntity -> {
                    callSalesIndentRequestPostApi(salesIndentRequestDetailsEntity, requestDetails.size());
                });
            } else {
                runOnUiThread(() -> {
                    prgDialog.hide();
                    Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();

                });
            }
        });
    }

    private void callSalesIndentRequestPostApi(SalesIndentRequestDetailsEntity requestDetails, int size) {
        HashMap<String, String> map = new HashMap<>();
        map.put("data", new Gson().toJson(requestDetails));
        Log.d("TmScreenActivity", map.toString());
        Call<SuccessResponse> call = apiInterface.postSalesIndentRequest(map);
        call.enqueue(new Callback<SuccessResponse>() {
            @Override
            public void onResponse(Call<SuccessResponse> call, Response<SuccessResponse> response) {
                Log.d("Post Data", "success");
                if (size == i) {
                    prgDialog.hide();
                    Toast.makeText(TMScreenActivity.this, "Data uploaded successfully", Toast.LENGTH_SHORT).show();
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        salesIndentDataBase.salesIndentDetailsDao().deleteAllSalesIndentRequestDetails();
                    });
                    i = 1;
                } else {
                    i++;
                }
            }

            @Override
            public void onFailure(Call<SuccessResponse> call, Throwable t) {
                i = 1;
                prgDialog.hide();
                Toast.makeText(TMScreenActivity.this, "Invalid response", Toast.LENGTH_SHORT).show();
            }
        });
    }

}