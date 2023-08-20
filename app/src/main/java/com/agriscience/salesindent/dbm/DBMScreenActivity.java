package com.agriscience.salesindent.dbm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.agriscience.salesindent.dbm.DBMIndentApprovalProcess;
import com.agriscience.salesindent.dbm.DBMReportViewActivity;
import com.agriscience.salesindent.stodbm.DbmStockReportActivity;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.CustomGrids;
import com.agriscience.salesindent.ExpandableHeightGridView;
import com.agriscience.salesindent.LoginActivity;
import com.agriscience.salesindent.R;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.am.AMScreenActivity;
import com.agriscience.salesindent.model.ZOrganogramResponseDetails;
import com.agriscience.salesindent.rbm.RBMScreenActivity;
import com.agriscience.salesindent.room_database.SalesIndentDataBase;
import com.agriscience.salesindent.stodbm.DbmStockApprovalActivity;
import com.agriscience.salesindent.tm.TMSalesIndentActivity;
import com.agriscience.salesindent.tm.TMScreenActivity;


public class DBMScreenActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;
    String myJSON;

    private static final String T1 = "Id";

    /*private static final String TAG_RESULTS1 = "result";
    private static final String T2k = "POCode";
    private static final String T3k = "POName";
    private static final String T4k = "TerritoryName";
    private static final String T5k = "Password";
    private static final String T6k = "POSCode";
    String PoCodes = "";
    String POCodeTransfer = "";
    String PONameTransfer = "";
    String TerritoryNameTransfer = "";
    TextView tvAddress;
    TextView Gps, Network;
    private DatePicker datePicker;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    TextView scandata ,tamilfont;
    Spinner Farmarcode;
    Spinner Inspectioncd;
    TextView Growercd, GrowerName, FatherName, VillageName, FaCode, VarietyCd, SowingDates,  Description1, InspectionDate, InspectionDate1, Farmerarea, Farmerarea1;
    Button PFOSCAN, GetData;
    ProgressDialog mProgressDialog;
    Boolean fistautosyn1 = true;
    File PFOfileIn = null;
    File PFOfileOut = null;
    String FielOrder1;
    String GroweCode1;
    String GroweName1;
    String FatName1;
    String VillgName1;
    String FCode1;
    String VarietCode1;
    private TextToSpeech tts;
    String ListSelect;
    String UserIdData, UnitData;
    Boolean DeleteFileCheck = true;
    EditText Empcode;
    File FieldfileIn = null;
    File FieldfileOut = null;
    File PFOMoveFile = null;
    String syninput6 = "",subActivity ,Remark , PoTerritory, OpenStatus, ApprovalStatus,TalukMandals;
    File APEventRecorderPostSeasonalFile =null;
    String EventCreationCode = "";
    private Button uploadButton, btnselectpic, btnselectaudio, btnselectvideo;
    private ImageView imageview;
    private int serverResponseCode = 0;
    private ProgressDialog dialog = null;
    private String upLoadServerUri = null;
    private String filepath1 = "";
    private String filepath2 = "";
    private String filepath3 = "";
    String ImageFileName1="";
    String ImageFileName2="";
    String ImageFileName3="";
    String    EventCodeNew,	TransDateNew,	ActivityTypeNew,	ActivityNameNew,	ProductNew,	PoCodeNew,TerritoryNew,HostFarmerNameNew,	NoofFarmerCoveredNew,	NoofVillageCoveredNew,	NoofDealersCoveredNew,	TalukMandalNew,	VillageNameNew,	FarmerNameNew,	MobileNumberNew,	ObserVationonNew,	SolutionsNew,	VisitNoNew,	CropCondtionNew,	StatusNew,	BudgetAmtNew,	SupportingPosNew,	ExpensesNew,	FarmerCoverageNew,	RemarksNew,	GpsLocationNew,	LatitudeNew,	LongitudeNew,	Image1New,	Image2New,	Image3New,	LoactionDateNew,	LocationTimeNew,	StringDateNew;
    File ISCustMasteInput=null;
    String SiteTransfer="";
    String ResponseCheckLine="";*/

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
    /*private static final String T20 = "S";
    private static final String T21 = "T";
    private static final String T22 = "U";
    private static final String T23 = "V";
    private static final String T24 = "W";
    private static final String T25 = "X";
    private static final String T26 = "Y";
    private static final String T27 = "Z";*/

    EditText PoCode, Password;
    String Passwords = "", Description;

    String PostCodeTransfer = "";

    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    PendingResult<LocationSettingsResult> result;
    final static int REQUEST_LOCATION = 199;

    AppLocationService appLocationService;

    String Check = "";

    Boolean fisttimecount = true;
    Boolean Syncomplete = true;
    Boolean fisttimecountexit = true;
    Boolean fistautosyn = true;

    File PFOfilSynFile = null;
    File Iroot = Environment.getExternalStorageDirectory();
    File Oroot = Environment.getExternalStorageDirectory();

    int linecheck = 1;
    int totalcount = 0;
    int linechecks = 1;
    int totalcounts = 0;

    TextView totcounts, update, stage;

    ProgressDialog prgDialog;
    ProgressDialog prgDialog1;

    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;

    // Connection detector class
    WIFIInternetConnectionDetector cd;

    String txtText;
    String toSpeak, text;
    boolean bool = true;

    String syninput1 = "";
    String syninput2 = "";
    String syninput3 = "";
    String syninput4 = "";
    String syninput5 = "";
    String crossyndata;

    ListView listView;

    int autocountsun = 1;

    File APPOMasterInput = null;
    File APActivityTypeMasterInput = null;
    File APSubActivityMasterInput = null;
    File APVillageMasterInput = null;
    File APEventCrateCodeFile = null;
    File APEvenetDataFile = null;
    File APEventCodeFile = null;
    File FileEventDatMovefile = null;
    File APEventRecorderPostSeasonalMoveFile = null;

    String ActivityType, PoCodeSpinner, VillageNameSpineer, Transdate, SupportingPo, PoState, PoRegion;
    String Checks = "";
    String POCodeGet = "";
    String PONameGet = "";
    String TerritoryNameGet = "";
    String PostCodeTransferGet = "";
    String SiteGet = "";

    String imagenames;
    String timevalue;
    Integer UploadCount1 = 1;
    String Pocodes, Ponames, Tmcodes;
    int FLAG = 0;
    String Imagepath1 = "";
    String Imagepath2 = "";
    String Imagepath3 = "";

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
    String Slno;
    String Sites, Warehouses, ExpectedDate;
    String ItemNames;

    int linecheckPoevent = 1;
    int totalcountPoevent = 0;

    //    String  IPAddress;
    String IPAddress = "http://103.44.97.110:8080/kanagaraj/";
    //    String  IPAddress = "http://192.168.35.24/hyveg/Sales_Indent_App/";
    String DivisionGet = "";
    String ProjectFolder = "";
    String IndentName = "";
    //    GridView grid;
    ExpandableHeightGridView grid;
    String[] web = {
            // "GET MASTER",
            // "UPLOAD",
            "INDENT APPROVE",
            "INDENT STATUS",
            "STOCK APPROVAL",
            "STR STATUS",
            "LOGOUT",
            "EXIT",
    };

//    String[] web = {
//            // "GET MASTER",
//            // "UPLOAD",
//            "INDENT APPROVE",
//            "INDENT STATUS",
//            "STOCK APPROVAL",
//            "STR STATUS",
//            "SALES DISPATCH STATUS",
//            "STO DISPATCH STATUS",
//            "LOGOUT",
//            "EXIT",
//    };

    int[] imageId = {
            // R.drawable.get71,
            //  R.drawable.upload6,
            R.drawable.approve984,
            R.drawable.salesview,
            R.drawable.view1,
            R.drawable.rep,
            R.drawable.lo2,
            R.drawable.exit,
    };

//    int[] imageId = {
//            // R.drawable.get71,
//            //  R.drawable.upload6,
//            R.drawable.approve984,
//            R.drawable.salesview,
//            R.drawable.view1,
//            R.drawable.rep,
//            R.drawable.salesview,
//            R.drawable.rep,
//            R.drawable.lo2,
//            R.drawable.exit,
//    };

    TextView tvAmMenu, tvRbmMenu;
    File GoTOTMCheck = null;
    String Acting = "";
    String DCode = "";
    AppSharedPreferences appSharedPreferences;
    int latestAppVersion;

    private FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
    private HashMap<String, Object> firebaseDefaultMap;
    private final String LAST_APP_VERSION_KEY = "latestappversion";

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
                                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                    try {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                    } catch (android.content.ActivityNotFoundException anfe) {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
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
        setContentView(R.layout.activity_dbmscreen);
        appLocationService = new AppLocationService(DBMScreenActivity.this);
        appSharedPreferences = new AppSharedPreferences(this);
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
                    Toast.makeText(DBMScreenActivity.this, "Someting went wrong please try again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

//        if (version_to_login == 0) {
//            Toast.makeText(this, "New Update Available...\nLogout to get new version", Toast.LENGTH_SHORT).show();
//        }

        saveDivisionAndTerritoryId();
        tvAmMenu = (TextView) findViewById(R.id.tvDbmAmMenu);
        tvRbmMenu = findViewById(R.id.tvDbmRbmMenu);

        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage(" Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));

        // checkwifi ();

     /*   mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();
        mGoogleApiClient.connect(); */

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

            File dir = new File(Iroot.getAbsolutePath() + "/Android/SITMCheck");
            dir.mkdirs();

            GoTOTMCheck = new File(dir, "GoTOTMCheck.csv");

        }


        CustomGrids adapter = new CustomGrids(DBMScreenActivity.this, web, imageId);
        grid = (ExpandableHeightGridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setExpanded(true);
        setListViewHeightBasedOnItems(grid);


        grid.setOnItemClickListener((parent, view, position, id) -> {
            // Toast.makeText(CanvasingActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            IndentName = web[+position];
            indentactivity();


        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            try {
                POCodeGet = extras.getString("Po_code");
                PONameGet = extras.getString("Po_name");
                TerritoryNameGet = extras.getString("Tm_name");
                PostCodeTransferGet = extras.getString("Post_code");
                SiteGet = extras.getString("Site_ID");
                DivisionGet = extras.getString("Division_code");
//                Acting=extras.getString("Action_Code");
                DCode = extras.getString("D_Code");
            } catch (Exception e) {
                e.printStackTrace();
            }


            appSharedPreferences.put_ZM("login_ZM");

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

            TextView textViewNameleft = (TextView) findViewById(R.id.textView22);
            textViewNameleft.setAnimation(animationToLeft);
            textViewNameleft.setText("WELCOME  Mr. " + PONameGet.toUpperCase());


            tvAmMenu.setOnClickListener(v -> AMMenu());

            tvRbmMenu.setOnClickListener(v -> RBMMenu());
        }



        if(appSharedPreferences.getIsRbm()){
            tvRbmMenu.setVisibility(View.VISIBLE);
        }
        else {
            tvRbmMenu.setVisibility(View.GONE);
        }

        if(appSharedPreferences.getIsAM()){
            tvAmMenu.setVisibility(View.VISIBLE);
        }
        else {
            tvAmMenu.setVisibility(View.GONE);
        }


    }


    private void saveDivisionAndTerritoryId() {
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            ZOrganogramResponseDetails organogramDetails = SalesIndentDataBase.getDataBase(this).zOrganogramDetailsDao().getZOrganogramDetailsByDbmId(appSharedPreferences.getUserId());
            if (organogramDetails != null) {
                Log.d("ZOrganogramResponseDetails", organogramDetails.toString());
                appSharedPreferences.putDivision(organogramDetails.getDivision());
                appSharedPreferences.putTerritoryId(organogramDetails.getTerritoryId());
            }

        });
    }

    private void RBMMenu() {
        Intent intent = new Intent(this, RBMScreenActivity.class);
        intent.putExtra("Po_code", appSharedPreferences.getUserId());
        intent.putExtra("Po_name", appSharedPreferences.getUserName());
        startActivity(intent);
    }

    private void AMMenu() {
        Intent intent = new Intent(this, AMScreenActivity.class);
        intent.putExtra("Po_code", appSharedPreferences.getUserId());
        intent.putExtra("Po_name", appSharedPreferences.getUserName());
        startActivity(intent);


//        TMMenuSave();


    }

    private void TMMenuSave() {


        try {

            GoTOTMCheck.delete();


            FileWriter fw = new FileWriter(GoTOTMCheck, true);
            BufferedWriter pw = new BufferedWriter(fw);

            pw.append("YES" + "\r\n");

            pw.flush();
            pw.close();
            fw.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Log.i(TAG, "******* File not found. Did you"
            // + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();


        }


    }


    private void TMMenuCheck() {

        if (GoTOTMCheck.exists()) {

            Intent intent = new Intent(this, TMScreenActivity.class);
            intent.putExtra("Po_code", POCodeGet);
            intent.putExtra("Po_name", PONameGet);
            intent.putExtra("Tm_name", TerritoryNameGet);
            intent.putExtra("Post_code", PostCodeTransferGet);
            intent.putExtra("Site_ID", SiteGet);
            intent.putExtra("Division_code", DivisionGet);
            intent.putExtra("Action_Code", Acting);
            intent.putExtra("D_Code", DCode);
            startActivity(intent);


        }
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
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }

    private void indentactivity() {

        if (IndentName.equals("INDENT APPROVE")) {


//            NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//            Notification notify=new Notification.Builder
//                    (getApplicationContext()).setContentTitle("").setContentText("").
//                    setContentTitle("fdffsdsdsdsd").setSmallIcon(R.mipmap.saleslogos).build();
//
//            notify.flags |= Notification.FLAG_AUTO_CANCEL;
//            notif.notify(0, notify);


            isConnectionExist = cd.checkMobileInternetConn();
            isConnectionExistMobile = cd.checkMobileInternetConns();

            if (isConnectionExist || isConnectionExistMobile) {
                Intent intent = new Intent(this, DBMIndentApprovalProcess.class);
                intent.putExtra("Po_code", POCodeGet);
                intent.putExtra("Po_name", PONameGet);
                intent.putExtra("Tm_name", TerritoryNameGet);
                intent.putExtra("Post_code", PostCodeTransferGet);
                intent.putExtra("Site_ID", SiteGet);
                intent.putExtra("Division_code", DivisionGet);
                intent.putExtra("Acting", Acting);
                intent.putExtra("D_code", DCode);
                startActivity(intent);


            } else {

                //Internet connection doesn't exist
                showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);


            }


        }

        if (IndentName.equals("INDENT STATUS")) {
            Intent intent = new Intent(this, DBMReportViewActivity.class);
            intent.putExtra("Po_code", POCodeGet);
            intent.putExtra("Po_name", PONameGet);
            intent.putExtra("Tm_name", TerritoryNameGet);
            intent.putExtra("Post_code", PostCodeTransferGet);
            intent.putExtra("Site_ID", SiteGet);
            intent.putExtra("Division_code", DivisionGet);
            intent.putExtra("Acting", Acting);
            intent.putExtra("D_code", DCode);
            startActivity(intent);


        }

        if (IndentName.equals("STOCK APPROVAL")) {
            Intent intent = new Intent(this, DbmStockApprovalActivity.class);
            intent.putExtra("Po_code", POCodeGet);
            intent.putExtra("Po_name", PONameGet);
            intent.putExtra("Tm_name", TerritoryNameGet);
            intent.putExtra("Post_code", PostCodeTransferGet);
            intent.putExtra("Site_ID", SiteGet);
            intent.putExtra("Division_code", DivisionGet);
            intent.putExtra("Acting", Acting);
            intent.putExtra("D_code", DCode);
            startActivity(intent);
        }

        if (IndentName.equals("STR STATUS")) {
            Intent intent = new Intent(this, DbmStockReportActivity.class);
            intent.putExtra("Po_code", POCodeGet);
            intent.putExtra("Po_name", PONameGet);
            intent.putExtra("Tm_name", TerritoryNameGet);
            intent.putExtra("Post_code", PostCodeTransferGet);
            intent.putExtra("Site_ID", SiteGet);
            intent.putExtra("Division_code", DivisionGet);
            intent.putExtra("Acting", Acting);
            intent.putExtra("D_code", DCode);
            startActivity(intent);
        }

        if (IndentName.equals("LOGOUT")) {


//            ISLoginMaster.delete();


            // moveTaskToBack(true);
            //  android.os.Process.killProcess(android.os.Process.myPid());
            //   System.exit(1);

            appSharedPreferences.putLoginRole(null);
            appSharedPreferences.putUserId(null);
            appSharedPreferences.putName(null);
            appSharedPreferences.putIsTM(false);
            appSharedPreferences.putIsAM(false);
            appSharedPreferences.putIsRbM(false);
            appSharedPreferences.putIsDbM(false);
            appSharedPreferences.put_ZM("");
            appSharedPreferences.clear();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);


        }


        if (IndentName.equals("EXIT")) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);


        }

    }

    //    public void popup_view(String a,String heading){
//        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        linearlayout_DBM=findViewById(R.id.linearlayout_DBM);
//
//        popupWindow.showAtLocation(linearlayout_DBM, Gravity.CENTER, 0, 0);
//        popupView = layoutInflater.inflate(R.layout.popup,null);
//        popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//
//        TextView tt=popupView.findViewById(R.id.textview_remarks);
//        ImageView close=popupView.findViewById(R.id.imageview);
//        TextView Remark_heading=popupView.findViewById(R.id.heading);
//
//        tt.setText(a);
//        Remark_heading.setText(heading);
//
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                popupWindow.dismiss();
//            }
//        });
//    }
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
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
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
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
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
                                    DBMScreenActivity.this,
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


    protected void showList2() {

        prgDialog.show();


        if (autocountsun >= 4) {
            prgDialog.hide();
        }


        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(T1);
                String A = c.getString(T2);
                String B = c.getString(T3);
                String C = c.getString(T4);
                String D = c.getString(T5);
                String E = c.getString(T6);
                String F = c.getString(T7);
              /*  String G = c.getString(T8);
                String H = c.getString(T9);
                String I = c.getString(T10);
                String J =g c.getString(T11);
                String K = c.getString(T12);
                String L = c.getString(T13);

                String M = c.getString(T14);
                String N = c.getString(T15);
                String O = c.getString(T16);
                String P = c.getString(T17);
                String Q = c.getString(T18);
                String R = c.getString(T19);
                String S = c.getString(T20);
                String T = c.getString(T21);
                String U = c.getString(T22);
                String V = c.getString(T23);
                String W = c.getString(T24);
                String X = c.getString(T25);
                String Y = c.getString(T26);
                String Z = c.getString(T27);*/


                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(T1, Id);
                persons.put(T2, A);
                persons.put(T3, B);
                persons.put(T4, C);
                persons.put(T5, D);
                persons.put(T6, E);
                persons.put(T7, F);
               /* persons.put(T8, G);
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
                persons.put(T21, T);
                persons.put(T22, U);
                persons.put(T23, V);
                persons.put(T24, W);
                persons.put(T25, X);
                persons.put(T26, Y);
                persons.put(T27, Z);*/

                totalcounts = totalcounts + 1;
            }
            //  prgDialog.hide();

            totcounts.setText(String.valueOf(totalcounts));
            GetSyns();


        } catch (JSONException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();


            prgDialog.hide();

        }


    }

    private void GetSyn5() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {


            totalcounts = 0;
            linechecks = 1;


            autocountsun = 1;


            if (autocountsun == 1) {
                prgDialog.show();

            }
            if (autocountsun == 6) {
                prgDialog.hide();

            }


            if (fistautosyn.equals(true)) {
                if (autocountsun == 1) {

                    syninput1 = "raja";


                    if (Oroot.canWrite()) {

                        File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
                        dir.mkdirs();

                        PFOfilSynFile = new File(dir, "ISCustMaster.csv");


                    }

                    PFOfilSynFile.delete();
                    autocountsun = autocountsun + 1;
                    GetSynss();


                }


            }
        } else {

            //Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }


    private void GetSyn8() {

        prgDialog.show();


        if (autocountsun >= 5) {
            prgDialog.hide();
        }


        if (autocountsun == 2) {

            syninput2 = "SiteMaster";


            if (Oroot.canWrite()) {

                File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
                dir.mkdirs();

                PFOfilSynFile = new File(dir, "ISSiteMaster.csv");

            }

            PFOfilSynFile.delete();
            autocountsun = autocountsun + 1;
            GetSynss();


        } else {
            if (autocountsun == 3) {
                syninput3 = "WarehouseMaster";


                if (Oroot.canWrite()) {

                    File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
                    dir.mkdirs();

                    PFOfilSynFile = new File(dir, "ISWarehouseMaster.csv");


                }
                PFOfilSynFile.delete();
                autocountsun = autocountsun + 1;
                GetSynss();


            } else {
                if (autocountsun == 4) {
                    syninput4 = "ItemMaster";


                    if (Iroot.canWrite()) {

                        File dir = new File(Iroot.getAbsolutePath() + "/IndentMaster");
                        dir.mkdirs();

                        PFOfilSynFile = new File(dir, "ISItemMaster.csv");

                    }
                    PFOfilSynFile.delete();
                    autocountsun = autocountsun + 1;
                    GetSynss();


                } else {
                    if (autocountsun == 5) {
                        syninput5 = "CropMaster";


                        if (Iroot.canWrite()) {

                            File dir = new File(Iroot.getAbsolutePath() + "/IndentMaster");
                            dir.mkdirs();

                            PFOfilSynFile = new File(dir, "ISCropMaster.csv");

                        }
                        PFOfilSynFile.delete();
                        autocountsun = autocountsun + 1;
                        GetSynss();


                    }


                }


            }
        }

    }


    private void GetSynss() {


        prgDialog.show();


        if (syninput1.equals("raja")) {
            //crossyndata ="http://10.20.1.37:8080/kanagaraj/IndentSales/ISCustMaster.php";

            //crossyndata=  "http://10.20.1.37:8080/kanagaraj/IndentSales/ISCustMaster.php?Site="+SiteGet;


            crossyndata = IPAddress + ProjectFolder + "/ISCustMaster.php?EmpCode=" + POCodeGet;
//            crossyndata=  IPAddress+"/kanagaraj/"+ProjectFolder+"/ISCustMaster.php?EmpCode="+POCodeGet;
//            crossyndata=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISCustMaster.php?EmpCode="+POCodeGet;
//            crossyndata = new_api.ISCustMaster(ProjectFolder ,POCodeGet);


        }


        if (syninput2.equals("SiteMaster")) {
            //  crossyndata=  "http://10.20.1.37:8080/kanagaraj/IndentSales/ISSiteMaster.php";

            crossyndata = IPAddress + ProjectFolder + "/ISSiteMaster.php";
//            crossyndata=  IPAddress+"/kanagaraj/"+ProjectFolder+"/ISSiteMaster.php";
//            crossyndata=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISSiteMaster.php";
//            crossyndata = new_api.ISSiteMaster(ProjectFolder);

        }

        if (syninput3.equals("WarehouseMaster")) {
            //crossyndata=  "http://10.20.1.37:8080/kanagaraj/IndentSales/ISWarehouseMaster.php";

            crossyndata = IPAddress + ProjectFolder + "/ISWarehouseMaster.php";
//            crossyndata=  IPAddress+"/kanagaraj/"+ProjectFolder+"/ISWarehouseMaster.php";
//            crossyndata=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISWarehouseMaster.php";
//            crossyndata = new_api.ISWarehouseMaster(ProjectFolder);

        }

        if (syninput4.equals("ItemMaster")) {
            // crossyndata=  "http://10.20.1.37:8080/kanagaraj/IndentSales/ISItemMaster.php";
            //crossyndata=  "http://10.20.1.37:8080/kanagaraj/IndentSales/APVillageMasternew.php?Tmcode="+POCodeGet;


            crossyndata = IPAddress + ProjectFolder + "/ISItemMaster.php";
//            crossyndata=  IPAddress+"/kanagaraj/"+ProjectFolder+"/ISItemMaster.php";
//            crossyndata=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISItemMaster.php";
//            crossyndata = new_api.ISItemMaster(ProjectFolder);

        }

        if (syninput5.equals("CropMaster")) {
            //  crossyndata=  "http://10.20.1.37:8080/kanagaraj/IndentSales/ISCropMaster.php";

            crossyndata = IPAddress + ProjectFolder + "/ISCropMaster.php";
//            crossyndata=  IPAddress+"/kanagaraj/"+ProjectFolder+"/ISCropMaster.php";
//            crossyndata=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISCropMaster.php";
//            crossyndata = new_api.ISCropMaster(ProjectFolder);
        }

        prgDialog.show();
        class GetDataJSON extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                // HttpPost httppost = new HttpPost("http://10.20.1.37:8080/kanagaraj/crosssinginsyn.php");
                HttpPost httppost = new HttpPost(crossyndata);

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
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
                try {
                    showList2();
                } catch (Exception e) {
                    prgDialog.cancel();
                    Toast.makeText(DBMScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }


    protected void showList3() {

        prgDialog.show();


        if (autocountsun >= 5) {
            prgDialog.hide();
        }

        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(T1);
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
                    /* String S = c.getString(T20);
                String T = c.getString(T21);
                String U = c.getString(T22);
                String V = c.getString(T23);
                String W = c.getString(T24);
                String X = c.getString(T25);
                String Y = c.getString(T26);
                String Z = c.getString(T27);*/


                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(T1, Id);
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
                  /*  persons.put(T20, S);
                persons.put(T21, T);
                persons.put(T22, U);
                persons.put(T23, V);
                persons.put(T24, W);
                persons.put(T25, X);
                persons.put(T26, Y);
                persons.put(T27, Z);*/


                try {


                    FileWriter fw = new FileWriter(PFOfilSynFile, true);
                    BufferedWriter pw = new BufferedWriter(fw);


                    pw.append(Id + "," + A + "," + B + "," + C + "," + D + "," + E + "," + F + "," + G + "," + H + "," + I + "," + J + "," + K + "," + L + "," + M + "," + N + "," + O + "," + P + "," + Q + "," + R + "," + "s" + "\r\n");


                    //  pw.append(Id + "," + AssetName + "," + AssetNO + "," + Location + "," + Unit + "," + BldgDetails + "," + UserName  + "\r\n");

                    pw.flush();
                    pw.close();
                    fw.close();


                    if (totalcounts == linechecks) {

                        //   Toast.makeText(getApplicationContext(), "Syn Completed" + PFOfilSynFile, Toast.LENGTH_LONG).show();

                        //toSpeak =  "Syn Completed"+PFOfilSynFile;
                        // speakOut();
                        Toast.makeText(getApplicationContext(), linechecks + " Line Import", Toast.LENGTH_LONG).show();

                        prgDialog.hide();

                        syninput1 = "";
                        syninput2 = "";
                        syninput3 = "";
                        syninput4 = "";
                        syninput5 = "";
                        // prgDialog.hide();
                        Check = "Checkfile".toString();
                        crossyndata = "";
                        GetSyn8();
                    }
                    update.setText(String.valueOf(linechecks));
                    linechecks = linechecks + 1;


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    // Log.i(TAG, "******* File not found. Did you"
                    // + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
                    prgDialog.hide();
                } catch (IOException e) {
                    e.printStackTrace();
                    prgDialog.hide();
                }

            }


            //   prgDialog.hide();

        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }

    }


    public void GetSyns() {

        prgDialog.show();
        class GetDataJSON extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost(crossyndata);

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
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
                try {
                    showList3();
                } catch (Exception e) {
                    prgDialog.cancel();
                    Toast.makeText(DBMScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
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
                    //HttpPost httppost = new HttpPost("http://172.16.3.21/HrAttendance.php");

                    HttpPost httppost = new HttpPost(IPAddress + "NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost(IPAddress + "/kanagaraj/NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App//NetworkCheck/NetworkStatusCheck.php");
//                    HttpPost httppost = new HttpPost(new_api.NetworkStatusCheck());


                    // Depends on your web service
                    httppost.setHeader("Content-type", "application/json");

                    InputStream inputStream = null;
                    String result = null;
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();

                        inputStream = entity.getContent();
                        // json is UTF-8 by default
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
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
                            Toast.makeText(DBMScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.hide();


                    }


                }
            }


            GetDataJSON g = new GetDataJSON();
            g.execute();


        } else {

            // Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }


    private void Syn() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {


            IndnetHeaderdataSyn();
            IndnetLinedataSyn();


        } else {

            // Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }


    private void IndnetHeaderdataSyn() {

        linecheck = 1;
        totalcount = 0;
        fisttimecount = true;

        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            if (ISHeaderDataFile.exists()) {

                if (fisttimecount.equals(true)) {

                    try {

                        // totcounts.setVisibility(View.VISIBLE);
                        // update.setVisibility(View.VISIBLE);

                        prgDialog.show();


                        //create BufferedReader to read csv file
                        BufferedReader br = new BufferedReader(new FileReader(ISHeaderDataFile));
                        String line = "";


                        int lineNumber = 0;

                        //read comma separated file line by line
                        while ((line = br.readLine()) != null) {
                            lineNumber++;
                            totalcount++;

                            //use comma as token separator
                            String[] country = line.split(",");

                            if (lineNumber == linecheck) {

                                //  String IndentCreationCode="",strDate="",strTime="",CustomerAccounts="",CustomerName="" ,CropTypes="",CropNames="", Hybrids="",Qty2="";
                                //  pw.append(IndentCreationCode + "," + strDate + "," + strTime + "," + CustomerAccounts + "," + CustomerName2 + TerritoryNameGet + ","+PoState + "," + PoRegion + "," + "" + "," + "" + "," + "c" + " \r\n");


                                IndentCreationCode = country[0].toString();
                                strDate = country[1].toString();
                                strTime = country[2].toString();
                                CustomerAccounts = country[3].toString();
                                CustomerName = country[4].toString();
                                TerritoryNameGet = country[5].toString();
                                PoState = country[6].toString();
                                PoRegion = country[7].toString();
                                POCodeGet = country[8].toString();
                                Sites = country[9].toString();
                                Warehouses = country[10].toString();
                                ExpectedDate = country[11].toString();


                                insert();
                                fisttimecountexit = false;
                            }

                        }
                        // totcounts.setText(String.valueOf("TotCnt:" + totalcount));
                        fisttimecount = false;

                    } catch (Exception e) {
                        System.err.println("CSV file cannot be read : " + e);
                        prgDialog.hide();
                    }


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

                Toast.makeText(getApplicationContext(), " No Data Available  ", Toast.LENGTH_LONG).show();
                Check = "Checkfile".toString();

                prgDialog.hide();
            }

        } else {
            {

                // Internet connection doesn't exist
                showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.hide();

            }

        }
    }


    private void Syns() {


        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            try {

                prgDialog.show();
                //create BufferedReader to read csv file
                BufferedReader br = new BufferedReader(new FileReader(ISHeaderDataFile));
                String line = "";


                int lineNumber = 0;

                //read comma separated file line by line
                while ((line = br.readLine()) != null) {
                    lineNumber++;


                    //use comma as token separator
                    String[] country = line.split(",");

                    if (lineNumber == linecheck) {


                        IndentCreationCode = country[0].toString();
                        strDate = country[1].toString();
                        strTime = country[2].toString();
                        CustomerAccounts = country[3].toString();
                        CustomerName = country[4].toString();
                        TerritoryNameGet = country[5].toString();
                        PoState = country[6].toString();
                        PoRegion = country[7].toString();
                        POCodeGet = country[8].toString();
                        Sites = country[9].toString();
                        Warehouses = country[10].toString();
                        ExpectedDate = country[11].toString();


                        insert();


                    }
                }


            } catch (Exception e) {
                System.err.println("CSV file cannot be read : " + e);
                prgDialog.hide();
            }

        } else {


            // Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Synchronization Not Completed", Toast.LENGTH_LONG).show();

            prgDialog.hide();
            fisttimecount = true;
            totalcount = 0;
        }

    }


    public void insert() {


        String IndentCreationCode1 = IndentCreationCode.toString();
        String strDate1 = strDate.toString();
        String strTime1 = strTime.toString();
        String CustomerAccounts1 = CustomerAccounts.toString();
        String CustomerName1 = CustomerName.toString();
        String TerritoryNameGet1 = TerritoryNameGet.toString();
        String PoState1 = PoState.toString();
        String PoRegion1 = PoRegion.toString();
        String POCodeGet1 = POCodeGet.toString();

        String Sites1 = Sites.toString();
        String Warehouses1 = Warehouses.toString();
        String ExpectedDate1 = ExpectedDate.toString();


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            insertToDatabase(IndentCreationCode1, strDate1, strTime1, CustomerAccounts1, CustomerName1, POCodeGet1, TerritoryNameGet1, PoState1, PoRegion1, Sites1, Warehouses1, ExpectedDate1);


        } else {


            // Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Syn Not Completed", Toast.LENGTH_LONG).show();


            prgDialog.hide();
            fisttimecount = true;
            totalcount = 0;


        }


    }

    // private void insertToDatabase(String FielOrder, String GroweCode,String GroweName, String FatName,String VillgName,String FCode,String VarietCode,String SowinDate ,String InspectioCode,String Inspectescription,String InspectioDate,String Totabolls,String BolWeight,String Estimateyield,String KapasOnhand,String Assesmenyield,String CrossingSDate ,String CrossingEDate ){
    private void insertToDatabase(String IndentCreationCode1, String strDate1, String strTime1, String CustomerAccounts1, String CustomerName1, String POCodeGet1, String TerritoryNameGet1, String PoState1, String PoRegion1, String Sites1, String Warehouses1, String ExpectedDate1) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];

                String IndentCreationCode1 = IndentCreationCode.toString();
                String strDate1 = strDate.toString();
                String strTime1 = strTime.toString();
                String CustomerAccounts1 = CustomerAccounts.toString();
                String CustomerName1 = CustomerName.toString();
                String TerritoryNameGet1 = TerritoryNameGet.toString();
                String PoState1 = PoState.toString();
                String PoRegion1 = PoRegion.toString();
                String POCodeGet1 = POCodeGet.toString();

                String Sites1 = Sites.toString();
                String Warehouses1 = Warehouses.toString();
                String ExpectedDate1 = ExpectedDate.toString();


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("IndentNo", IndentCreationCode1));
                nameValuePairs.add(new BasicNameValuePair("IndentDate", strDate1));
                nameValuePairs.add(new BasicNameValuePair("IndentTime", strTime1));
                nameValuePairs.add(new BasicNameValuePair("CustCode", CustomerAccounts1));
                nameValuePairs.add(new BasicNameValuePair("CustName", CustomerName1));
                nameValuePairs.add(new BasicNameValuePair("TMCode", POCodeGet1));
                nameValuePairs.add(new BasicNameValuePair("Territory", TerritoryNameGet1));
                nameValuePairs.add(new BasicNameValuePair("StateCode", PoState1));
                nameValuePairs.add(new BasicNameValuePair("Region", PoRegion1));
                nameValuePairs.add(new BasicNameValuePair("Site", Sites1));
                nameValuePairs.add(new BasicNameValuePair("Warehouse", Warehouses1));
                nameValuePairs.add(new BasicNameValuePair("ExpectedDate", ExpectedDate1));


                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    //  HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/kanagaraj/IndentSales/ISIndentHeaderDataSynInsert.php");

                    // HttpPost httpPost = new HttpPost("http://10.10.2.34/kanagaraj/IndentSales/ISIndentHeaderDataSynInsert.php");

                    //   HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/Testing/APEventDataSynInsert.php");

                    HttpPost httpPost = new HttpPost(IPAddress + ProjectFolder + "/ISIndentHeaderDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost(IPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentHeaderDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentHeaderDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost(new_api.ISIndentHeaderDataSynInsert(ProjectFolder));

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";


            }


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);


                if (totalcount == linecheck) {

                    Toast.makeText(getApplicationContext(), "Synchronization Completed", Toast.LENGTH_LONG).show();

                    Syncomplete = false;
                    prgDialog.hide();
                    Checks = "Checkfile".toString();
                    // APEvenetDataFile.renameTo(FileEventDatMovefile);
                    ISHeaderDataFile.delete();
                    //  totcounts.setVisibility(View.GONE);
                    // update.setVisibility(View.GONE);
                    //  totcounts.setText("");
                    //update.setText("");

                    linecheck = 0;
                    totalcount = 0;
                    fisttimecount = true;


                    prgDialog.hide();
                }
                update.setText(String.valueOf("SynCnt:" + linecheck));
                linecheck = linecheck + 1;
                Syns();
            }


        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        // sendPostReqAsyncTask.execute(FielOrder,GroweCode,GroweName,FatName,VillgName,FCode,VarietCode,SowinDate,InspectioCode,Inspectescription,InspectioDate,Totabolls,BolWeight,Estimateyield,KapasOnhand,Assesmenyield,CrossingSDate,CrossingEDate);
        sendPostReqAsyncTask.execute(IndentCreationCode1, strDate1, strTime1, CustomerAccounts1, CustomerName1, POCodeGet1, TerritoryNameGet1, PoState1, PoRegion1, Sites1, Warehouses1, ExpectedDate1);

    }


    private void IndnetLinedataSyn() {


        fisttimecount = true;
        totalcountPoevent = 0;
        linecheckPoevent = 1;

        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            if (ISLineDataFile.exists()) {

                if (fisttimecount.equals(true)) {

                    try {

                        // totcounts.setVisibility(View.VISIBLE);
                        // update.setVisibility(View.VISIBLE);

                        prgDialog.show();


                        //create BufferedReader to read csv file
                        BufferedReader br = new BufferedReader(new FileReader(ISLineDataFile));
                        String line = "";


                        int lineNumber = 0;

                        //read comma separated file line by line
                        while ((line = br.readLine()) != null) {
                            lineNumber++;
                            totalcountPoevent++;

                            //use comma as token separator
                            String[] country = line.split(",");

                            if (lineNumber == linecheckPoevent) {

                                //  String IndentCreationCode="",strDate="",strTime="",CustomerAccounts="",CustomerName="" ,CropTypes="",CropNames="", Hybrids="",Qty2="";
                                //  pw.append(IndentCreationCode + "," + strDate + "," + strTime + "," + CustomerAccounts + "," + CustomerName2 + TerritoryNameGet + ","+PoState + "," + PoRegion + "," + "" + "," + "" + "," + "c" + " \r\n");

                                //        pw.append(IndentCreationCodeTemp+","+LineNo+","+strDateTemp+","+strTimeTemp+","+CustomerAccountsTemp + "," + CustomerName2Temp + "," + CropTypesTemp + "," + CropNamesTemp + "," + HybridsTemp + "," + Qty2Temp+","+TerritoryNameGet + ","+PoState + "," + PoRegion + "," + POCodeGet+","+"c"+" \r\n");


                                IndentCreationCode = country[0].toString();
                                Slno = country[1].toString();
                                strDate = country[2].toString();
                                strTime = country[3].toString();
                                CustomerAccounts = country[4].toString();
                                CustomerName = country[5].toString();
                                CropTypes = country[6].toString();
                                CropNames = country[7].toString();
                                Hybrids = country[8].toString();
                                ItemNames = country[9].toString();
                                Qty2 = country[10].toString();
                                TerritoryNameGet = country[11].toString();
                                PoState = country[12].toString();
                                PoRegion = country[13].toString();
                                POCodeGet = country[14].toString();
                                Sites = country[15].toString();
                                Warehouses = country[16].toString();
                                ExpectedDate = country[17].toString();


                                insert1();
                                fisttimecountexit = false;
                            }

                        }
                        // totcounts.setText(String.valueOf("TotCnt:" + totalcount));
                        fisttimecount = false;

                    } catch (Exception e) {
                        System.err.println("CSV file cannot be read : " + e);
                        prgDialog.hide();
                    }


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

                Toast.makeText(getApplicationContext(), " No Data Available ", Toast.LENGTH_LONG).show();
                Check = "Checkfile".toString();

                prgDialog.hide();
            }

        } else {
            {

                // Internet connection doesn't exist
                showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.hide();

            }

        }
    }


    private void Syns1() {


        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            try {

                prgDialog.show();

                //create BufferedReader to read csv file
                BufferedReader br = new BufferedReader(new FileReader(ISLineDataFile));
                String line = "";


                int lineNumber = 0;

                //read comma separated file line by line
                while ((line = br.readLine()) != null) {
                    lineNumber++;


                    //use comma as token separator
                    String[] country = line.split(",");

                    if (lineNumber == linecheckPoevent) {


                        IndentCreationCode = country[0].toString();
                        Slno = country[1].toString();
                        strDate = country[2].toString();
                        strTime = country[3].toString();
                        CustomerAccounts = country[4].toString();
                        CustomerName = country[5].toString();
                        CropTypes = country[6].toString();
                        CropNames = country[7].toString();
                        Hybrids = country[8].toString();
                        ItemNames = country[9].toString();
                        Qty2 = country[10].toString();
                        TerritoryNameGet = country[11].toString();
                        PoState = country[12].toString();
                        PoRegion = country[13].toString();
                        POCodeGet = country[14].toString();
                        Sites = country[15].toString();
                        Warehouses = country[16].toString();
                        ExpectedDate = country[17].toString();


                        insert1();


                    }
                }


            } catch (Exception e) {
                System.err.println("CSV file cannot be read : " + e);
                prgDialog.hide();
            }

        } else {


            // Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Synchronization Not Completed", Toast.LENGTH_LONG).show();

            prgDialog.hide();
            fisttimecount = true;
            totalcountPoevent = 0;
        }

    }


    public void insert1() {


        String IndentCreationCode1 = IndentCreationCode.toString();
        String Slno1 = Slno.toString();
        String strDate1 = strDate.toString();
        String strTime1 = strTime.toString();
        String CustomerAccounts1 = CustomerAccounts.toString();
        String CustomerName1 = CustomerName.toString();
        String CropNames1 = CropNames.toString();
        String CropTypes1 = CropTypes.toString();
        String Hybrids1 = Hybrids.toString();
        String Qty21 = Qty2.toString();
        String TerritoryNameGet1 = TerritoryNameGet.toString();
        String PoState1 = PoState.toString();
        String PoRegion1 = PoRegion.toString();
        String POCodeGet1 = POCodeGet.toString();
        String Sites1 = Sites.toString();
        String Warehouses1 = Warehouses.toString();
        String ExpectedDate1 = ExpectedDate.toString();
        String ItemNames1 = ItemNames.toString();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            insertToDatabase1(IndentCreationCode1, Slno1, strDate1, strTime1, CustomerAccounts1, CustomerName1, CropNames1, CropTypes1, Hybrids1, Qty21, TerritoryNameGet1, PoState1, PoRegion1, POCodeGet1, Sites1, Warehouses1, ExpectedDate1, ItemNames1);


        } else {


            // Internet connection doesn't exist
            showAlertDialog(DBMScreenActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Syn Not Completed", Toast.LENGTH_LONG).show();


            prgDialog.hide();
            fisttimecount = true;
            totalcountPoevent = 0;


        }


    }

    // private void insertToDatabase(String FielOrder, String GroweCode,String GroweName, String FatName,String VillgName,String FCode,String VarietCode,String SowinDate ,String InspectioCode,String Inspectescription,String InspectioDate,String Totabolls,String BolWeight,String Estimateyield,String KapasOnhand,String Assesmenyield,String CrossingSDate ,String CrossingEDate ){
    private void insertToDatabase1(String IndentCreationCode1, String Slno1, String strDate1, String strTime1, String CustomerAccounts1, String CustomerName1, String CropNames1, String CropTypes1, String Hybrids1, String Qty21, String TerritoryNameGet1, String PoState1, String PoRegion1, String POCodeGet1, String Sites1, String Warehouses1, String ExpectedDate1, String ItemNames1) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];

                String IndentCreationCode1 = IndentCreationCode.toString();
                String Slno1 = Slno.toString();
                String strDate1 = strDate.toString();
                String strTime1 = strTime.toString();
                String CustomerAccounts1 = CustomerAccounts.toString();
                String CustomerName1 = CustomerName.toString();
                String CropNames1 = CropNames.toString();
                String CropTypes1 = CropTypes.toString();
                String Hybrids1 = Hybrids.toString();
                String Qty21 = Qty2.toString();
                String TerritoryNameGet1 = TerritoryNameGet.toString();
                String PoState1 = PoState.toString();
                String PoRegion1 = PoRegion.toString();
                String POCodeGet1 = POCodeGet.toString();
                String Sites1 = Sites.toString();
                String Warehouses1 = Warehouses.toString();
                String ExpectedDate1 = ExpectedDate.toString();
                String ItemNames1 = ItemNames.toString();


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
                nameValuePairs.add(new BasicNameValuePair("IndentQty", Qty21));
                nameValuePairs.add(new BasicNameValuePair("TMCode", POCodeGet1));
                nameValuePairs.add(new BasicNameValuePair("Territory", TerritoryNameGet1));
                nameValuePairs.add(new BasicNameValuePair("StateCode", PoState1));
                nameValuePairs.add(new BasicNameValuePair("Region", PoRegion1));
                nameValuePairs.add(new BasicNameValuePair("Site", Sites1));
                nameValuePairs.add(new BasicNameValuePair("Warehouse", Warehouses1));
                nameValuePairs.add(new BasicNameValuePair("ExpectedDate", ExpectedDate1));
                nameValuePairs.add(new BasicNameValuePair("ItemName", ItemNames1));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    //HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/kanagaraj/IndentSales/ISIndentLineDataSynInsert.php");

                    //HttpPost httpPost = new HttpPost("http://10.10.2.34/kanagaraj/IndentSales/ISIndentLineDataSynInsert.php");

                    //   HttpPost httpPost = new HttpPost("http://10.20.1.37:8080/Testing/APEventDataSynInsert.php");

                    HttpPost httpPost = new HttpPost(IPAddress + ProjectFolder + "/ISIndentLineDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost(IPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentLineDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentLineDataSynInsert.php");
//                    HttpPost httpPost = new HttpPost(new_api.ISIndentLineDataSynInsert(ProjectFolder));

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";


            }


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);


                if (totalcountPoevent == linecheckPoevent) {

                    Toast.makeText(getApplicationContext(), "Synchronization Completed", Toast.LENGTH_LONG).show();

                    Syncomplete = false;
                    prgDialog.hide();
                    Checks = "Checkfile".toString();
                    // APEvenetDataFile.renameTo(FileEventDatMovefile);
                    ISLineDataFile.delete();
                    //  totcounts.setVisibility(View.GONE);
                    // update.setVisibility(View.GONE);
                    //  totcounts.setText("");
                    //update.setText("");

                    linecheckPoevent = 0;
                    totalcountPoevent = 0;
                    fisttimecount = true;


                    prgDialog.hide();
                }
                update.setText(String.valueOf("SynCnt:" + linecheckPoevent));
                linecheckPoevent = linecheckPoevent + 1;
                Syns1();
            }


        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        // sendPostReqAsyncTask.execute(FielOrder,GroweCode,GroweName,FatName,VillgName,FCode,VarietCode,SowinDate,InspectioCode,Inspectescription,InspectioDate,Totabolls,BolWeight,Estimateyield,KapasOnhand,Assesmenyield,CrossingSDate,CrossingEDate);
        sendPostReqAsyncTask.execute(IndentCreationCode1, Slno1, strDate1, strTime1, CustomerAccounts1, CustomerName1, CropNames1, CropTypes1, Hybrids1, Qty21, TerritoryNameGet1, PoState1, PoRegion1, POCodeGet1, Sites1, Warehouses1, ExpectedDate1, ItemNames1);


    }


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
        super.onDestroy();
    }


    // Class with extends AsyncTask class


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
                DBMScreenActivity.this);

        alertDialog.setTitle(provider + " SETTINGS");

        alertDialog
                .setMessage(provider + " is not enabled! Want to go to settings menu?");

        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);

                        DBMScreenActivity.this.startActivity(intent);


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


}




