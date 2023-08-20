package com.agriscience.salesindent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsResult;

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


public class  PasswordChange extends Activity {
    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;


    String myJSON;


    private static final String TAG_RESULTS1 = "result";
    private static final String T1 = "Id";
    private static final String T2k = "POCode";
    private static final String T3k = "POName";
    private static final String T4k = "TerritoryName";
    private static final String T5k = "Password";
    private static final String T6k = "POSCode";


    private static final String TAG_RESULTS = "result";

    private static final String T2 = "AssetName";
    private static final String T3 = "AssetNO";
    private static final String T4 = "Location";
    private static final String T5 = "Unit";
    private static final String T6 = "BldgDetails";
    private static final String T7 = "UserName";
    private static final String T8 = "Department";
    private static final String T9 = "UserResponsibility";
    private static final String T10 = "IPAddress";
    private static final String T11 = "Gateway";
    private static final String T12 = "MotherBoardModel";
    private static final String T13 = "Processor";
    private static final String T14 = "HDD";
    private static final String T15 = "RAM";
    private static final String T16 = "RAMtype";
    private static final String T17 = "MonitorType";
    private static final String T18 = "MonitorSize";
    private static final String T19 = "OS";
    private static final String T20 = "ServicePack";
    private static final String T21 = "Office";
    private static final String T22 = "MailTool";
    private static final String T23 = "OtherSoftware";
    private static final String T24 = "InternetProvision";
    private static final String T25 = "Yearofpurchase";
    private static final String T26 = "OtherDeviceAttached";
    private static final String T27 = "Remarks";


    EditText PoCode, Password;
    String PoCodes = "";
    String Passwords = "";

    String POCodeTransfer = "";
    String PONameTransfer = "";
    String TerritoryNameTransfer = "";
    String PostCodeTransfer = "";


    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    PendingResult<LocationSettingsResult> result;
    final static int REQUEST_LOCATION = 199;


    AppLocationService appLocationService;
    TextView tvAddress;
    TextView Gps, Network;
    private DatePicker datePicker;

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    TextView scandata;
    Spinner Farmarcode;
    Spinner Inspectioncd;
    TextView Growercd, GrowerName, FatherName, VillageName, FaCode, VarietyCd, SowingDates, Description, Description1, InspectionDate, InspectionDate1, Farmerarea, Farmerarea1;


    Button PFOSCAN, GetData;

    ProgressDialog mProgressDialog;
    String Check = "";


    Boolean fisttimecount = true;
    Boolean Syncomplete = true;
    Boolean fisttimecountexit = true;

    Boolean fistautosyn = true;


    File PFOfileIn = null;
    File PFOfileOut = null;
    File PFOfilSynFile = null;

    File Iroot = Environment.getExternalStorageDirectory();
    File Oroot = Environment.getExternalStorageDirectory();


    int linecheck = 1;
    int totalcount = 0;

    int linechecks = 1;
    int totalcounts = 0;


    String FielOrder1;
    String GroweCode1;
    String GroweName1;
    String FatName1;
    String VillgName1;
    String FCode1;
    String VarietCode1;

    TextView totcounts, update, tamilfont, stage;


    ProgressDialog prgDialog;
    ProgressDialog prgDialog1;

    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;


    // Connection detector class
    WIFIInternetConnectionDetector cd;

    private TextToSpeech tts;
    String txtText;
    String toSpeak, text;


    boolean bool = true;


    String syninput1 = "";
    String syninput2 = "";
    String syninput3 = "";
    String syninput4 = "";

    String crossyndata;

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


    File APEvenetDataFile = null;
    File APEventCodeFile = null;

    File FileEventDatMovefile = null;


    File APPOLoginMaster = null;

    String ActivityType, subActivity, PoCodeSpinner, VillageNameSpineer, Transdate, SupportingPo, Remark, PoState, PoRegion, PoTerritory, OpenStatus, ApprovalStatus;


    String Checks = "";

    String EventCreationCode = "";


    ImageButton ServerSyn, MobileSyn;

    ImageButton PasswordChangeButton;


    EditText NewPassword, ConfirmPassword;


    String NewPasswords, ConfirmPasswords;

    String IPAddress="http://103.44.97.110:8080/kanagaraj/";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);


        appLocationService = new AppLocationService(PasswordChange.this);


        PoCode = (EditText) findViewById(R.id.etUserId);
        PoCode.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        Password = (EditText) findViewById(R.id.etPassword);


        NewPassword = (EditText) findViewById(R.id.editText25);
        ConfirmPassword = (EditText) findViewById(R.id.editText26);


        totcounts = (TextView) findViewById(R.id.textView47);
        update = (TextView) findViewById(R.id.textView48);


//        PasswordChangeButton = (ImageButton) findViewById(R.id.imageButton20);


        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));

        // checkwifi ();
        PoCode.setEnabled(false);


        if (Iroot.canWrite())

        {

            File dir = new File(Iroot.getAbsolutePath() + "/APEventData");
            dir.mkdirs();

            APEvenetDataFile = new File(dir, "APEventDataFile.csv");
        }



        Calendar cal = Calendar.getInstance();
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        //  SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

        String strDate, strTime;

        strDate = sdf.format(cal.getTime());


        File dir = new File(Iroot.getAbsolutePath() + "/APPOLoginMaster");
        dir.mkdirs();

        APPOLoginMaster = new File(dir, "APPOLoginMaster" + strDate + ".csv");

      //  IPAddress="http://210.212.238.34:8081";
        //IPAddress="http://117.232.103.178:8080";
       //IPAddress="http://10.20.1.37:8080";
//        IPAddress="http://103.44.97.110:8080";
        APPOloginMasterOffline();


    }


    protected void showList() {


        try {

            Check = "";

            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(T1);
                String Pocodess = c.getString(T2k);
                String Ponames = c.getString(T3k);
                String TerritoryNameS = c.getString(T4k);
                String Passwordss = c.getString(T5k);
                String POSCodes = c.getString(T6k);


                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(T1, Id);
                persons.put(T2k, Pocodess);
                persons.put(T3k, Ponames);
                persons.put(T4k, TerritoryNameS);
                persons.put(T5k, Passwordss);
                persons.put(T6k, POSCodes);


                if (Pocodess.trim().toString().equals(PoCodes) && Passwordss.trim().toString().equals(Passwords))

                {
                    Check = "chckfile".toString();

                }


            }

            if (Check.equals("chckfile")) {

                prgDialog.hide();

                Passwordupdate();


            } else

            {

                //Toast.makeText(getApplicationContext(), "UserName Password Incorrect",   Toast.LENGTH_SHORT).show();

                showAlertDialog1(PasswordChange.this, "UserId  or Password Incorrect", false);

                // Passwords.setText("");
                prgDialog.hide();
            }


        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }

    }


    private void Passwordupdate() {

        prgDialog.show();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {


            String PoCode1 = PoCode.getText().toString();
            String NewPassword1 = NewPassword.getText().toString();


            //  prgDialog1.show();
            //  prgDialog.show();

            // insertToDatabase2(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);
            insertToDatabase3(PoCode1, NewPassword1);


        } else {

            // Internet connection doesn't exist
            showAlertDialog(PasswordChange.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }

    // private void insertToDatabase2( String EventCode1,String ApType1,String SubActivity1,String PoCodeSpinner2, String VillageNameSpineer2,String Date2,String SupportingPo2, String Remark2,String PoState2,String PoRegion2, String POTerritory2){

    private void insertToDatabase3(String PoCode1, String NewPassword1) {


        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];

                String PoCode1 = PoCode.getText().toString();
                String NewPassword1 = NewPassword.getText().toString();


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


                nameValuePairs.add(new BasicNameValuePair("POCode", PoCode1));
                nameValuePairs.add(new BasicNameValuePair("Password", NewPassword1));


                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    // HttpPost httpPost = new HttpPost("http://172.16.3.21/HrDataUpdate.php");
                    HttpPost httpPost = new HttpPost(IPAddress+"APEventRecorders/APPasswordUpdate.php");
//                    HttpPost httpPost = new HttpPost(IPAddress+"/kanagaraj/APEventRecorders/APPasswordUpdate.php");
//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hiveg/Sales_Indent_App/APEventRecorders/APPasswordUpdate.php");
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

                prgDialog.hide();
                showAlertDialog1(PasswordChange.this, "Password Updated", true);
                APPOloginMasterGet();
            }


        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        //sendPostReqAsyncTask.execute(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);
        sendPostReqAsyncTask.execute(PoCode1, NewPassword1);


    }


    public void Newpasswordcheck(View View) {


        NewPasswords = NewPassword.getText().toString();
        ConfirmPasswords = ConfirmPassword.getText().toString();

        if (NewPasswords.equals(ConfirmPasswords)) {

            PasswordChangeUpdate();

        } else {
            Toast.makeText(getApplicationContext(), "New Password Not Match", Toast.LENGTH_LONG).show();


        }


    }


    public void PasswordChangeUpdate() {


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        PoCodes = PoCode.getText().toString();
        Passwords = Password.getText().toString();


        if (isConnectionExist || isConnectionExistMobile) {
            //Internet Connection exists
            //showAlertDialog(PasswordChange.this, "Internet Connection",
            //"Your device has WIFI internet access", true);


            if (PoCodes.trim().length() > 0 && Passwords.trim().length() > 0) {


                prgDialog.show();


                class GetDataJSON extends AsyncTask<String, Void, String> {

                    @Override
                    protected String doInBackground(String... params) {
                        DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                        //HttpPost httppost = new HttpPost("http://rasiaosit.16mb.com/getdata.php");
                        //HttpPost httppost = new HttpPost("http://172.16.3.21/HrAttendance.php");

                        HttpPost httppost = new HttpPost(IPAddress+"APEventRecorders/APPoLogin.php");
//                        HttpPost httppost = new HttpPost(IPAddress+"/kanagaraj/APEventRecorders/APPoLogin.php");
//                        HttpPost httppost = new HttpPost("http://192.168.35.24/hiveg/Sales_Indent_App/APEventRecorders/APPoLogin.php");

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
                        try {
                            showList();
                        }catch (Exception e){
                            prgDialog.cancel();
                            Toast.makeText(PasswordChange.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


                GetDataJSON g = new GetDataJSON();
                g.execute();

            } else {

                Toast.makeText(PasswordChange.this, "UserId Or Password must be filled", Toast.LENGTH_LONG).show();

                // showAlertDialog1(LoginActivity.this, "Please Enter PO Code", false);
                prgDialog.hide();

            }


        } else {

            //Internet connection doesn't exist
            showAlertDialog(PasswordChange.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_password_change, menu);
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
                doubleBackToExitPressedOnce=false;
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


    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    public void CloseActivity(View view) {
        finish();
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
                PasswordChange.this);

        alertDialog.setTitle(provider + " SETTINGS");

        alertDialog
                .setMessage(provider + " is not enabled! Want to go to settings menu?");

        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);

                        PasswordChange.this.startActivity(intent);


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


    public void APPOloginMasterOffline() {


        Check = "";

        if (APPOLoginMaster.exists()) {

            try {
                //create BufferedReader to read csv file
                BufferedReader br = new BufferedReader(new FileReader(APPOLoginMaster));
                String line = "";


                int lineNumber = 0;

                //read comma separated file line by line
                while ((line = br.readLine()) != null) {
                    lineNumber++;


                    //use comma as token separator
                    String[] country = line.split(",");

                    PoCode.setText(country[1]);
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void APPOloginMasterGet( ) {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {


            totalcounts = 0;
            linechecks = 1;

            // APPOLoginMaster.delete();

            folderDelete();


            prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {


                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    // HttpPost httppost = new HttpPost(IPAddress+"/kanagaraj/crosssinginsyn.php");

                    HttpPost httppost = new HttpPost(IPAddress+"APEventRecorders/APPologinMasterFetch.php");
//                    HttpPost httppost = new HttpPost(IPAddress+"/kanagaraj/APEventRecorders/APPologinMasterFetch.php");
//                    HttpPost httppost = new HttpPost("http://192.168.35.24/hiveg/Sales_Indent_App/APEventRecorders/APPologinMasterFetch.php");

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
                        showListevent2();
                    }catch (Exception e){
                        prgDialog.cancel();
                        Toast.makeText(PasswordChange.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
            prgDialog.hide();


        } else {

            //Internet connection doesn't exist
            showAlertDialog(PasswordChange.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.hide();

        }
    }


    protected void showListevent2() {

        prgDialog.show();



        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String Id = c.getString(T1);
                String AssetName = c.getString(T2);
                String AssetNO = c.getString(T3);
                String Location = c.getString(T4);
                String Unit = c.getString(T5);
                String BldgDetails = c.getString(T6);
                String UserName = c.getString(T7);
              /*  String Department = c.getString(T8);
                String UserResponsibility = c.getString(T9);
                String IPAddress = c.getString(T10);
                String Gateway =g c.getString(T11);
                String MotherBoardModel = c.getString(T12);
                String Processor = c.getString(T13);

                String HDD = c.getString(T14);
                String RAM = c.getString(T15);
                String RAMtype = c.getString(T16);
                String MonitorType = c.getString(T17);
                String MonitorSize = c.getString(T18);
                String OS = c.getString(T19);
                String ServicePack = c.getString(T20);
                String Office = c.getString(T21);
                String MailTool = c.getString(T22);
                String OtherSoftware = c.getString(T23);
                String InternetProvision = c.getString(T24);
                String Yearofpurchase = c.getString(T25);
                String OtherDeviceAttached = c.getString(T26);
                String Remarks = c.getString(T27);*/


                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(T1, Id);
                persons.put(T2, AssetName);
                persons.put(T3, AssetNO);
                persons.put(T4, Location);
                persons.put(T5, Unit);
                persons.put(T6, BldgDetails);
                persons.put(T7, UserName);
               /* persons.put(T8, Department);
                persons.put(T9, UserResponsibility);
                persons.put(T10, IPAddress);
                persons.put(T11, Gateway);
                persons.put(T12, MotherBoardModel);
                persons.put(T13, Processor);
                persons.put(T14, HDD);
                persons.put(T15, RAM);
                persons.put(T16, RAMtype);
                persons.put(T17, MonitorType);
                persons.put(T18, MonitorSize);
                persons.put(T19, OS);
                persons.put(T20, ServicePack);
                persons.put(T21, Office);
                persons.put(T22, MailTool);
                persons.put(T23, OtherSoftware);
                persons.put(T24, InternetProvision);
                persons.put(T25, Yearofpurchase);
                persons.put(T26, OtherDeviceAttached);
                persons.put(T27, Remarks);*/

                totalcounts = totalcounts + 1;
            }
            prgDialog.hide();

            totcounts.setText(String.valueOf(totalcounts));
            GetSynsEvent();


        } catch (JSONException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();


            prgDialog.hide();

        }


    }


    public void GetSynsEvent() {


        prgDialog.show();



        class GetDataJSON extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost(IPAddress+"APEventRecorders/APPologinMasterFetch.php");
//                HttpPost httppost = new HttpPost(IPAddress+"/kanagaraj/APEventRecorders/APPologinMasterFetch.php");
//                HttpPost httppost = new HttpPost("http://192.168.35.24/hiveg/Sales_Indent_App/APEventRecorders/APPologinMasterFetch.php");

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
                    showListevent3();
                }catch (Exception e){
                    prgDialog.cancel();
                    Toast.makeText(PasswordChange.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }




    protected void showListevent3() {
        prgDialog.show();



        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);


                String Id = c.getString(T1);
                String AssetName = c.getString(T2);
                String AssetNO = c.getString(T3);
                String Location = c.getString(T4);
                String Unit = c.getString(T5);
                String BldgDetails = c.getString(T6);
                String UserName = c.getString(T7);

                String Department = c.getString(T8);
                String UserResponsibility = c.getString(T9);



                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(T1, Id);
                persons.put(T2, AssetName);
                persons.put(T3, AssetNO);
                persons.put(T4, Location);
                persons.put(T5, Unit);
                persons.put(T6, BldgDetails);
                persons.put(T7, UserName);
                persons.put(T8, Department);
                persons.put(T9, UserResponsibility);



                try {


                    FileWriter fw = new FileWriter(APPOLoginMaster, true);
                    BufferedWriter pw = new BufferedWriter(fw);

                    if( AssetName.equals(PoCodes)  ) {
                        pw.append(Id + "," + AssetName + "," + AssetNO + "," + Location + "," + Unit + "," + BldgDetails + "," + UserName + "," + Department + "," + UserResponsibility + "," + "s" + "\r\n");
                    }
                    //  pw.append(Id + "," + AssetName + "," + AssetNO + "," + Location + "," + Unit + "," + BldgDetails + "," + UserName  + "\r\n");

                    pw.flush();
                    pw.close();
                    fw.close();


                    if (totalcounts == linechecks) {

                        //  Toast.makeText(getApplicationContext(), "Syn Completed" + PFOfilSynFile, Toast.LENGTH_LONG).show();
                        //  Toast.makeText(getApplicationContext(), linechecks + " Line Import",  Toast.LENGTH_LONG).show();

                        prgDialog.hide();
                        //toSpeak =  "Syn Completed"+PFOfilSynFile;
                        // speakOut();

                        Check = "Checkfile".toString();


                        finish();

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


        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }

    }


    private void  folderDelete ()
    {



        File dir = new File(Iroot.getAbsolutePath() + "/APPOLoginMaster");
        if (dir.isDirectory())
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++)
            {
                new File(dir, children[i]).delete();
            }
        }



    }



}
