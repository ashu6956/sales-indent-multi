package com.agriscience.salesindent.rbm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.CountryRemark;
import com.agriscience.salesindent.R;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.rbm.RBMScreenActivity;


public class RBMIndentSelection extends Activity {

    //MyCustomAdapter dataAdapter = null;
    private static final String TAG = "";
    String myJSON;
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

    ;

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    EditText usernames, Passwords;
    String usernames1, Passwords1, textDeviceID1;
    Button Login;
    String Check = "";
    String Checks = "";

    String NameUser, Departments, Imei;

    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;

    TextView textDeviceID;
    // Connection detector class
    WIFIInternetConnectionDetector cd;


    ProgressDialog prgDialog;

    private TextToSpeech tts;
    String txtText;
    String toSpeak, text;
    AppLocationService appLocationService;


    TextView Latitude, Longitude, ImeiNo, SimNo, MobileNo, TmName;

    String LocationTimes = "";

    EditText Location, TmCode, PoCode, PoName, SupportingPo, EventDecription, Expenses, NoofFarmer, FarmerName, ContactNo, Remarks;


    Spinner Crop, Stage, EventName, ActivityName;
    String Crops, Stages;


    String Eventcodes = "";
    String Activitycodes = "";
    String EventNames = "";
    String ActivityNames = "";


    TextView Remarks1;

    Button Upload1, Upload2, Upload3;
    ImageView Image1, Image2, Image3;
    Bitmap bitmap1, bitmap2, bitmap3;

    int CAMERA_PIC_REQUEST = 0;
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;

    String CheckUpload1 = "";
    String CheckUpload2 = "";
    String CheckUpload3 = "";


    private Button uploadButton, btnselectpic, btnselectaudio, btnselectvideo;
    private ImageView imageview;
    private int serverResponseCode = 0;
    private ProgressDialog dialog = null;

    private String upLoadServerUri = null;
    private String filepath1 = "";
    private String filepath2 = "";
    private String filepath3 = "";
    int FLAG = 0;


    String imagenames;
    String timevalue;
    Integer UploadCount1 = 1;


    String Pocodes, Ponames, Tmcodes;


    String Imagepath1 = "";
    String Imagepath2 = "";
    String Imagepath3 = "";


    Boolean Syncomplete = true;
    Boolean fisttimecountexit = true;

    Boolean fistautosyn = true;

    String Nfarm, Remks, Supprtpo, Expnss, IM1, IM2, IM3;


    String ChecksEvent = "";

    String EventDataUpdateCheck = "";


    String UpDateString = "";


    String POCodeGet = "";
    String PONameGet = "";
    String TerritoryNameGet = "";
    String PostCodeTransfer = "";

    EditText ActivityNamee;


    String Creationdate1, ActivityName1, TerritoryName1, StateCode1, Region1, VillageName1, POCode1, HybridName1, BudgetAmt1, Status1;


    EditText AType, SubActivityName;


    Spinner EventCode;

    String EventCodes;


    String Village, pocodemy;

    Button Transdate;

    private TextView pDisplayDate;
    private Button CrostD2, CroenD2;
    private int pYear;
    private int pMonth;
    private int pDay;
    /**
     * This integer will uniquely define the dialog to be used for displaying date picker.
     */
    static final int DATE_DIALOG_ID = 0;


    Spinner ActivityType, SubActivity, PoCodeSpinner, VillageNameSpineer;


    String PoHeadQRs, PoState, PoRegion, POTerritory;

    String PoCodeSpinners = "";


    File Iroot = Environment.getExternalStorageDirectory();
    File Oroot = Environment.getExternalStorageDirectory();


    File APPOMasterInput = null;
    File APActivityTypeMasterInput = null;
    File APSubActivityMasterInput = null;
    File APVillageMasterInput = null;

    File APEvenetDataFile = null;
    File APEventCodeFile = null;


    File APEventRecordBulkApprovalFile = null;
    File ISIndentBulkApprovalFile = null;

    Button PODate;


    Spinner POCodeCheckSpinner;
    Button DateCheck;


    String POCodeCheckSpinners;
    Button Submit;

    String ActivityTypes, SubActivitys, VillageNameSpineers = "";

    Boolean fisttimecount = true;


    EditText pocoderet, villagenameret, Dateret, Supportingret, TmRemarkret;

    String Atypes, Anames, Daterets, Supportingrets, TmRemarkrets;

    LinearLayout Linearfirst;
    ScrollView LinearSecond;


    private String[] EventCodess;
    private String[] Dates;
    private String[] Pocodess;
    private String[] ActivityTypess;
    private String[] Activitys;
    private String[] Villages;
    private Integer[] Selections;


    List<String> EventCodessTransfer = new ArrayList<String>();
    List<String> DatesTransfer = new ArrayList<String>();
    List<String> PocodessTransfer = new ArrayList<String>();
    List<String> ActivityTypessTransfer = new ArrayList<String>();
    List<String> ActivitysTransfer = new ArrayList<String>();
    List<String> VillagesTransfer = new ArrayList<String>();
    List<Integer> SelectionsTransfer = new ArrayList<Integer>();

    ListView list;


    Button SelectAll;
    ImageButton BulkUpload;


    String BulkIndentCodeUpdate;


    int linecheck = 1;
    int totalcount = 0;


    CheckBox AllDataApproval;


    String ApprovalDataSyn;


    ArrayList<CountryRemark> countryList = new ArrayList<CountryRemark>();

    private String[] IndentCodeBulk;
    private  String[]  EventDateBulk;
    private  String[]  CancelRemarks;
    private  String[]  AxRecid;






    boolean[] checkBoxState;


    TextView LableName;





    String CancelRemarksSet="";

    String CancelRemarkscheck;

    String AXRecidcheck;



    List<String> codes = new ArrayList<String>();
    List<String> codes1 = new ArrayList<String>();
    List<String> codes2 = new ArrayList<String>();
    List<Boolean> checkBoxState1 = new ArrayList<Boolean>();

    List<String> codes3 = new ArrayList<String>();

    private boolean checkBoxStateCheck=false;

    String AXRecidupdate="";



    List<String> CancelRemarkscheck2 = new ArrayList<String>();
    List<Boolean> checkBoxStateCheck2 = new ArrayList<Boolean>();



//    String FinalIPAddress;
    String IPAddress = "http://103.44.97.110:8080/kanagaraj/";
//    String IPAddress = "http://192.168.35.24/hyveg/Sales_Indent_App/";


    File ISHeaderDataFile =null;
    File ISLineDataFile =null;
    File ISLineDataTempFile =null;

    File ISIndentCodeFile =null;

    File ISProductMasterFile =null;

    File ISCustMasterInput=null;
    File ISItemMasterInput=null;
    File ISCropMasterInput =null;
    File ISSiteMasterInput =null;
    File ISWarehouseMasterInput =null;

    String PostCodeTransferGet="";
    String SiteGet="";



    List<String> codes4 = new ArrayList<String>();
    List<String> codes5 = new ArrayList<String>();
    List<String> codes6 = new ArrayList<String>();

    private  String[]  AXCustAccount;
    private  String[]  AXHybrid;
    private  String[]  AxIndentDate;

    String DivisionGet="";
    String ProjectFolder="";

    ArrayList<String> resultlocation;
    ArrayList<String> resultWarehouse;
    ArrayList<String> resultproject;

    String IndentNo="";

    String FullIPData="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbmindent_selection);

        //Generate list View from ArrayList


        appLocationService = new AppLocationService(RBMIndentSelection.this);

        list = (ListView) findViewById(R.id.listView);

        PoCodeSpinner = (Spinner) findViewById(R.id.spSTORbm);

        Linearfirst = (LinearLayout) findViewById(R.id.Linear1);
        LinearSecond = (ScrollView) findViewById(R.id.scrollView);


        BulkUpload = (ImageButton) findViewById(R.id.bnSubmit);

        LableName = (TextView) findViewById(R.id.textView33);


    //    FinalIPAddress = "http://210.212.238.34:8081";

        // FinalIPAddress="http://117.232.103.178:8080";

       // FinalIPAddress = "http://10.20.1.37:8080";
//        FinalIPAddress="http://103.44.97.110:8080";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            POCodeGet = extras.getString("Po_code");
            PONameGet = extras.getString("Po_name");
            TerritoryNameGet = extras.getString("Tm_name");
            PostCodeTransferGet = extras.getString("Post_code");
            SiteGet = extras.getString("Site_ID");
            DivisionGet = extras.getString("Division_code");
            IndentNo = extras.getString("IndentNo_No");

            if (DivisionGet.equals("Cotton")) {

                // ProjectFolder="CNFSalesOrderCotton";
                ProjectFolder = "SalesIndentCotton";


            } else {
                //ProjectFolder="CNFSalesOrderFieldCrop";
                ProjectFolder = "SalesIndentFieldCrop";

            }


        }


        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));


        if (Oroot.canWrite())

        {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISCustMasterInput = new File(dir, "ISCustMaster.csv");


        }

        if (Oroot.canWrite())

        {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISItemMasterInput = new File(dir, "ISItemMaster.csv");


        }


        if (Oroot.canWrite())

        {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISCropMasterInput = new File(dir, "ISCropMaster.csv");


        }


        if (Oroot.canWrite())

        {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISSiteMasterInput = new File(dir, "ISSiteMaster.csv");


        }

        if (Oroot.canWrite())

        {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISWarehouseMasterInput = new File(dir, "ISWarehouseMaster.csv");


        }


        if (Iroot.canWrite())

        {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISHeaderDataFile = new File(dir, "ISHeaderDataFile.csv");
        }


        if (Iroot.canWrite())

        {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISLineDataFile = new File(dir, "ISLineDataFile.csv");
        }


        if (Iroot.canWrite())

        {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISLineDataTempFile = new File(dir, "ISLineDataTempFile.csv");
        }


        if (Iroot.canWrite())

        {
            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentData");
            dir.mkdirs();

            ISIndentCodeFile = new File(dir, "ISIndentCodeFile.csv");
        }

        if (Iroot.canWrite())

        {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISProductMasterFile = new File(dir, "ISProductMaster.csv");
        }


        if (Iroot.canWrite())

        {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISIndentBulkApprovalFile = new File(dir, "ISIndentBulkApprovalFile.csv");
        }


        //GetTeritory();
        getData3();

    }
        //Getlist3();

        //  displayListView();

        //    checkButtonClick();

     /*   PoCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get select item


                String UnitIds2 = PoCodeSpinner.getItemAtPosition(position).toString();
                PoCodeSpinners = PoCodeSpinner.getSelectedItem().toString();

                String[] separated = PoCodeSpinners.split("-");
                PoCodeSpinners = separated[0];


                if ("Please Select".equals(PoCodeSpinners)) {

                } else {
                    //  Toast.makeText(getApplicationContext(), "Transfer OrderID: " +  UnitIds + " Selected", Toast.LENGTH_LONG).show();
                    // UnitId.setEnabled(false);


                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });


    }*/




    /**
     * Callback received when the user "picks" a date in the dialog
     */
    /*  private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;



                    updateDisplay();

                    updateDisplay2();

                    //  displayToast();
                }
            };

    /** Updates the date in the TextView
   private void updateDisplay() {


       // Transdate.setText(
           //     new StringBuilder()
                        // Month is 0 based so add 1

                     //   .append(pDay).append("/")
                        //.append(pMonth + 1).append("/")
                       // .append(pYear).append(" "));






    }

    private void updateDisplay2() {


      //  DateCheck.setText(
              //  new StringBuilder()
                        // Month is 0 based so add 1

                       // .append(pDay).append("/")
                        //.append(pMonth + 1).append("/")
                        //.append(pYear).append(" "));



    }


    public void Getlist3() {

        String check = "";


        List<String> codes = new ArrayList<String>();
        codes.add("Please Select");

        try {
            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader(new FileReader(APPOMasterInput));
            String line = "";


            int lineNumber = 0;

            //read comma separated file line by line
            while ((line = br.readLine()) != null) {
                lineNumber++;


                //use comma as token separator
                String[] country = line.split(",");


                if (PostCodeTransfer.equals("TM")) {

                    if (country[12].equals(POCodeGet)) {

                        // codes.add(new String(country[16]));
                        codes.add(new String(country[16] + "-" + country[17]));
                    }
                } else {
                    if (country[16].equals(POCodeGet)) {

                        // codes.add(new String(country[16]));
                        codes.add(new String(country[16] + "-" + country[17]));

                    }
                }


            }


            HashSet<String> set = new HashSet<>(codes);

            // Create ArrayList from the set.
            ArrayList<String> result = new ArrayList<>(set);
            //Comparator mycomparator = Collections.reverseOrder();
            //Collections.sort(result,mycomparator);

            Collections.sort(result);

            //ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
            // adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //PoCodeSpinner.setAdapter(adapter1);

            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes);
            adapter1.setDropDownViewResource(R.layout.spinner_item);
            PoCodeSpinner.setAdapter(adapter1);


        } catch (Exception e) {
            System.err.println("CSV file cannot be read : " + e);
            // Toast.makeText(getApplicationContext(), "CSV file  cannot be read or Opened ", Toast.LENGTH_LONG).show();

        }

    }

*/


    private void GetTeritory() {



        prgDialog.show();
        class GetDataJSON extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                // HttpPost httppost = new HttpPost("http://210.212.238.34:8081/kanagaraj/crosssinginsyn.php");

                HttpPost httppost = new HttpPost(IPAddress +ProjectFolder+"/TerritoryFetchs.php?RBMCode="+POCodeGet);
//                HttpPost httppost = new HttpPost(FinalIPAddress + "/kanagaraj/"+ProjectFolder+"/TerritoryFetchs.php?RBMCode="+POCodeGet);
//                HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/TerritoryFetchs.php?RBMCode="+POCodeGet);

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


                if (result!=null)


                {
                    try {
                        showList1();
                    }catch (Exception e){
                        prgDialog.cancel();
                        Toast.makeText(RBMIndentSelection.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    // Internet connection doesn't exist
                    showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                            "Your device doesn't have WIFI or Data Plan internet access", false);

                    prgDialog.hide();



                }

            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }


    protected void showList1() {

        List<String> codes = new ArrayList<String>();
        String Checkfile ="";

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
                String E = c.getString(T7);
                String F = c.getString(T9);
                String G = c.getString(T10);
                String H = c.getString(T11);


                codes.add(Id+"-"+A);
                Checkfile ="Checkfile";

            }
            if(Checkfile.equals("Checkfile")) {

                HashSet<String> set = new HashSet<>(codes);

                // Create ArrayList from the set.
                ArrayList<String> result = new ArrayList<>(set);
                //Comparator mycomparator = Collections.reverseOrder();
                //Collections.sort(result,mycomparator);

                Collections.sort(result);


                // List<String> codes3 = new ArrayList<String>();

                resultlocation = new ArrayList<String>();


                resultlocation.add("Please Select");
                resultlocation.add("ALL");


                for (int j = 0; j < result.size(); j++) {

                    String codes2 = result.get(j);


                    resultlocation.add(codes2);

                }


                // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
                //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Product.setAdapter(adapter1);


                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, resultlocation);
                adapter1.setDropDownViewResource(R.layout.spinner_item);
                PoCodeSpinner.setAdapter(adapter1);
                prgDialog.hide();
            }


        } catch (JSONException e) {
            e.printStackTrace();

            //  Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();

            prgDialog.hide();

        }


    }













    public void getData3() {

        FullIPData="";

        if(IndentNo.equals("ALL"))
        {

            FullIPData=  IPAddress+ProjectFolder+"/ISIndentDataFetchRBMALL.php?RBMCode="+POCodeGet;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentDataFetchRBMALL.php?RBMCode="+POCodeGet;
//            FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentDataFetchRBMALL.php?RBMCode="+POCodeGet;


        }
        else
        {

            FullIPData=  IPAddress+ProjectFolder+"/ISIndentDataFetchRBM.php?IndentNo="+IndentNo;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentDataFetchRBM.php?IndentNo="+IndentNo;
//            FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentDataFetchRBM.php?IndentNo="+IndentNo;

        }



        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {


            prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    //  HttpPost httppost = new HttpPost(FinalIPAddress+"/kanagaraj/APEventRecorders/APEeventDataFetch.php");
                    //HttpPost httppost = new HttpPost(FinalIPAddress+"/kanagaraj/APEventRecorders/APEventDatafetchChecknew.php?Pocode="+PoCodeSpinners);
                    HttpPost httppost = new HttpPost(FullIPData);


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
                        prgDialog.hide();
                        // Oops
                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {
                            prgDialog.hide();
                        }
                    }
                    return result;
                }

                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;
                    try {
                        showList3();
                    }catch (Exception e){
                        prgDialog.cancel();
                        Toast.makeText(RBMIndentSelection.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        }


        else

        {

            //Internet connection doesn't exist
            showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }


    protected void showList3() {



        Check = "";



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
                String J =c.getString(T11);
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
                /*String V = c.getString(T23);
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
                persons.put(T20, S);
                persons.put(T21, T);
                persons.put(T22, U);
                /*persons.put(T23, V);
                persons.put(T24, W);
                persons.put(T25, X);
                persons.put(T26, Y);
                persons.put(T27, Z);*/

//INDENTNO	INDENTDATE	INDENTTIME	CUSTCODE	CUSTNAME	SITE	WAREHOUSE	EXPECTEDDATE	TMCODE	TERRITORY	STATECODE	REGION	ITEMID	ITEMNAME	CROPTYPE	CROPNAME	INDENTQTY	DATAAREAID	RECVERSION	RECID	SLNO	STRINGDATE	INDENTSTATUS


                // if (Pocoode1.equals(PoCodeSpinners) && OpenCloseStatus1.equals("OPEN") && ApprovalPendingStatus1.equals("PENDING")) {

                if (R.equals("0")) {


                    Check = "chckfile".toString();

                    //  EventCodessTransfer.add(EventCode1);
                    // DatesTransfer.add(CreationDate1);
                    // PocodessTransfer.add(Pocoode1);
                    // ActivityTypessTransfer.add(ActivityCode1);
                    // ActivitysTransfer.add(ActivityName1);
                    // VillagesTransfer.add(VillageName1);
                    // SelectionsTransfer.add(0);


                    // EventCodess = new String[EventCodessTransfer.size()];
                    //  Dates = new String[DatesTransfer.size()];
                    //  Pocodess = new String[PocodessTransfer.size()];
                    //  ActivityTypess = new String[ActivityTypessTransfer.size()];
                    // Activitys = new String[ActivitysTransfer.size()];
                    // Villages = new String[VillagesTransfer.size()];
                    // Selections = new Integer[SelectionsTransfer.size()];


                    codes.add(Id);
                    codes1.add(D);
                    // codes1.add(A + "    " + C + "    " + D + "      " + T + "      " + M  );
                    codes2.add(P);
                    codes3.add(U);
                    codes4.add(L);
                    codes5.add(A);
                    codes6.add(C);


                    checkBoxState1.add(false);


                    // IndentCodeBulk = EventCode1;
                    // EventDateBulk = CreationDate1 + "    " + Pocoode1 + "    " + ActivityCode1 + "      " + ActivityName1 + "      " + VillageName1 + "    " + TalukMandal1 + "      " + HybridName1 + "      " + SupportingPOs1 + "      " + Remarks1;
                    // CancelRemarks="";

                    //  CountryRemark country = new CountryRemark("", IndentCodeBulk, CancelRemarks,EventDateBulk,false);
                    //  countryList.add(country);


                    IndentCodeBulk = new String[codes.size()];
                    EventDateBulk = new String[codes1.size()];
                    CancelRemarks = new String[codes2.size()];
                    AxRecid=new String[codes3.size()];


                    AXHybrid=new String[codes4.size()];
                    AxIndentDate=new String[codes5.size()];
                    AXCustAccount=new String[codes6.size()];







                    checkBoxState = new boolean[checkBoxState1.size()];


                }

            }


            for (int j = 0; j < codes.size(); j++) {
                // Get the path of the image file
                IndentCodeBulk[j] = codes.get(j);
                EventDateBulk[j] = codes1.get(j);
                CancelRemarks[j] = codes2.get(j);
                AxRecid[j] = codes3.get(j);
                checkBoxState[j] = checkBoxState1.get(j);

                AXHybrid[j] = codes4.get(j);
                AxIndentDate[j] = codes5.get(j);
                AXCustAccount[j] = codes6.get(j);





            }

            if (Check.equals("chckfile")) {


                LayoutInflater inflater = getLayoutInflater();
                ViewGroup header = (ViewGroup) inflater.inflate(R.layout.approveheader, list,
                        false);
                //ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer, list,
                //   false);
                list.addHeaderView(header, null, false);
                // list.addFooterView(footer, null, false);


                MyListAdapter myListAdapter = new MyListAdapter();
                list.setAdapter(myListAdapter);
                setListViewHeightBasedOnItems(list);
            }
            // displayListView();


            //  for (int j = 0; j < EventCodessTransfer.size(); j++) {
            // Get the path of the image file
            // EventCodess[j] = EventCodessTransfer.get(j);
            // Dates[j] = DatesTransfer.get(j);
            // Pocodess[j] = PocodessTransfer.get(j);
            // ActivityTypess[j] = ActivityTypessTransfer.get(j);
            // Activitys[j] = ActivitysTransfer.get(j);
            // Villages[j] = VillagesTransfer.get(j);
            // Selections[j] = SelectionsTransfer.get(j);
            //   }


            if (Check.equals("chckfile")) {

                prgDialog.hide();
                BulkUpload.setVisibility(View.VISIBLE);
                Linearfirst.setVisibility(View.GONE);
                Check = "";
            } else {
                Toast.makeText(getApplicationContext(), "No Pending Validate", Toast.LENGTH_SHORT).show();
                prgDialog.hide();
                finish();
            }



        } catch (JSONException e) {
            e.printStackTrace();
            prgDialog.hide();
        }

    }



    public void EveentGetData(View view) {

        if ("Please Select".equals(PoCodeSpinners)) {

            Toast.makeText(getApplicationContext(), "Please Select PO code", Toast.LENGTH_LONG).show();

        } else {


            isConnectionExist = cd.checkMobileInternetConn();
            isConnectionExistMobile = cd.checkMobileInternetConns();

            if (isConnectionExist || isConnectionExistMobile)
            {


                getData3();


            } else {

                //Internet connection doesn't exist
                showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);


            }




        }


    }


    /*private void displayListView() {

        //Array list of countries

        //country = new Country("ALB", "Albania", true);
        //countryList.add(country);
        //country = new Country("DZA", "Algeria", false);
        // countryList.add(country);
        // country = new Country("ASM", "American Samoa", true);
        // countryList.add(country);
        // country = new Country("AND", "Andorra", true);
        // countryList.add(country);
        // country = new Country("AGO", "Angola", false);
        // countryList.add(country);
        // country = new Country("AIA", "Anguilla", false);
        // countryList.add(country);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this, R.layout.list_item, countryList);

        // Assign adapter to ListView
        list.setAdapter(dataAdapter);
        setListViewHeightBasedOnItems(list);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                CountryRemark country = (CountryRemark) parent.getItemAtPosition(position);
                // Toast.makeText(getApplicationContext(),
                //  "Clicked on Row: " + country.getName(),
                //  Toast.LENGTH_LONG).show();
            }
        });




        LableName.setFocusable(true);
        LableName.setFocusableInTouchMode(true);
        LableName.requestFocus();


    }

 /*   private class MyCustomAdapter extends ArrayAdapter<CountryRemark> {

        private ArrayList<CountryRemark> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<CountryRemark> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<CountryRemark>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox name;
            EditText CancelMyRemakrs;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_remarks, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
                holder.CancelMyRemakrs = (EditText) convertView.findViewById(R.id.editText51);


                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {

                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        CountryRemark country = (CountryRemark) cb.getTag();
                        // Toast.makeText(getApplicationContext(),"Clicked on Checkbox: " + cb.getText() +                                    " is " + cb.isChecked(),
                        //    Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());


                    }
                });



            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            CountryRemark country = countryList.get(position);
            holder.code.setText( country.getCode() );
            holder.eventdatas.setText( country.getEventdata());
            holder.name.setText(country.getName());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);
            holder.CancelMyRemakrs.setText(country.getCancelremarks());


            return convertView;

        }

    } */


    private class MyListAdapter extends BaseAdapter {



        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (IndentCodeBulk != null && IndentCodeBulk.length != 0) {
                return IndentCodeBulk.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return IndentCodeBulk[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //ViewHolder holder = null;
            final ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = RBMIndentSelection.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.country_remarks, null);

                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
                holder.Qtys = (EditText) convertView.findViewById(R.id.editText51);
                holder.Qtys.setEnabled(false);
                holder.AxcodeID = (TextView) convertView.findViewById(R.id.textView11);
                holder.name = (CheckBox) convertView.findViewById(R.id.cbSalesIndent);

                holder.AXHybrids = (TextView) convertView.findViewById(R.id.textView15);
                holder.AxIndentDates = (TextView) convertView.findViewById(R.id.textView16);
                holder.AXCustAccounts = (TextView) convertView.findViewById(R.id.textView17);





                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;

            holder.code.setText( "" );
            holder.eventdatas.setText( EventDateBulk[position]);
            holder.name.setText(IndentCodeBulk[position]);
            holder.name.setChecked(checkBoxState[position]);
            holder.Qtys.setText( CancelRemarks[position]);
            holder.AxcodeID.setText( AxRecid[position]);

            holder.AXHybrids.setText( AXHybrid[position]);
            holder.AxIndentDates.setText( AxIndentDate[position]);
            holder.AXCustAccounts.setText( AXCustAccount[position]);




            //for managing the state of the boolean
            //array according to the state of the
            //CheckBox

            holder.name.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if(((CheckBox)v).isChecked()) {
                        checkBoxState[holder.ref] = true;
                        holder.Qtys.setEnabled(true);
                        holder.Qtys.setFocusable(true);
                    }

                    else {
                        checkBoxState[holder.ref] = false;
                        holder.Qtys.setEnabled(false);
                        // holder.Qtys.setText("");
                    }

                }
            });



            holder.name.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    //inserttemp();

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    IndentCodeBulk[holder.ref] = arg0.toString();


                }
            });




            holder.eventdatas.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    //inserttemp();



                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    EventDateBulk[holder.ref] = arg0.toString();


                }
            });

            holder.Qtys.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    //inserttemp();

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    CancelRemarks[holder.ref] = arg0.toString();



                }
            });


            holder.AxcodeID.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    //inserttemp();

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    AxRecid[holder.ref] = arg0.toString();



                }
            });

            holder.AXHybrids.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    //inserttemp();

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    AXHybrid[holder.ref] = arg0.toString();



                }
            });


            holder.AxIndentDates.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    //inserttemp();

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    AxIndentDate[holder.ref] = arg0.toString();



                }
            });

            holder.AXCustAccounts.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    //inserttemp();

                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub


                    AXCustAccount[holder.ref] = arg0.toString();



                }
            });

            return convertView;
        }


        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox name;
            EditText Qtys;
            TextView AxcodeID;

            TextView AXHybrids;
            TextView AxIndentDates;
            TextView AXCustAccounts;


            int ref;


        }

    }





   /* private void checkButtonClick() {


        ImageButton myButton = (ImageButton) findViewById(R.id.imageButton26);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                isConnectionExist = cd.checkMobileInternetConn();
                isConnectionExistMobile = cd.checkMobileInternetConns();

                if (isConnectionExist || isConnectionExistMobile)
                {

                    ISIndentBulkApprovalFile.delete();

                    StringBuffer responseText = new StringBuffer();
                    responseText.append("Please Select EventCode...\n");

                    ArrayList<CountryRemark> countryList = dataAdapter.countryList;
                    for(int i=0;i<countryList.size();i++){
                        CountryRemark country = countryList.get(i);
                        if(country.isSelected()){
                            // responseText.append("\n" + country.getName());

                            BulkIndentCodeUpdate= country.getName();
                            CancelRemarkscheck=country.getCancelremarks();
                            BulkApprovalDataSave();


                        }
                    }

                    //  BulkApprovalDataSaveNew();

                    // Toast.makeText(getApplicationContext(),
                    //    responseText, Toast.LENGTH_LONG).show();


                } else {

                    //Internet connection doesn't exist
                    showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                            "Your device doesn't have WIFI or Data Plan internet access", false);


                }

            }
        });

    }


 */

    public void savedataCountCheck(View view) {

        CancelRemarkscheck2.removeAll(CancelRemarkscheck2);
        checkBoxStateCheck2.removeAll(checkBoxStateCheck2);


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            ISIndentBulkApprovalFile.delete();

            for (int j = 0; j < IndentCodeBulk.length; j++) {



                String CancelRemarkscheck1 = CancelRemarks[j];
                boolean  checkBoxStateCheck1 = checkBoxState[j];


                // if(CancelRemarkscheck1.trim().length()>0)
                //  {
                //  CancelRemarkscheck2.add(CancelRemarkscheck1 );

                // }

                if(checkBoxStateCheck1==true)
                {
                    checkBoxStateCheck2.add(checkBoxStateCheck1 );

                }




            }


            // if( CancelRemarkscheck2.size()== checkBoxStateCheck2.size())
            // {

            //savedata();

            //  }
            // else
            // {

            if(checkBoxStateCheck2.size()==0)
            {
                Toast.makeText(getApplicationContext(), " Please Tick Indent Code ", Toast.LENGTH_LONG).show();

            }
            else {

                // Toast.makeText(getApplicationContext(), " Please Enter Qty", Toast.LENGTH_LONG).show();
                savedata();
            }
            //}


        } else {

            //Internet connection doesn't exist
            showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }


    }


    private void savedata() {


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            ISIndentBulkApprovalFile.delete();

            for (int j = 0; j < IndentCodeBulk.length; j++) {


                BulkIndentCodeUpdate = IndentCodeBulk[j];
                CancelRemarkscheck = CancelRemarks[j];
                checkBoxStateCheck = checkBoxState[j];
                AXRecidcheck=AxRecid[j];


                if (BulkIndentCodeUpdate.trim().length() > 0 && CancelRemarkscheck.trim().length() > 0 && checkBoxStateCheck == true) {



                    BulkApprovalDataSave();



                }


            }


            BulkApprovalDataSaveNew();


        } else {

            //Internet connection doesn't exist
            showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }


    }



    public void UpdateBulkUpload(View view) {


        ISIndentBulkApprovalFile.delete();

        for (int j = 0; j < EventCodess.length; j++) {


            BulkIndentCodeUpdate = EventCodess[j];
            AXRecidcheck=AxRecid[j];

            BulkApprovalDataSave();

        }
        BulkApprovalDataSaveNew();

    }


    private void BulkApprovalDataSave() {

        //LocationDate,LocationTime,ImeiNo,SimNo,MobNo,GpsLocation,Latitude,Longitude,Growercode,Remarks

        try {


            FileWriter fw = new FileWriter(ISIndentBulkApprovalFile, true);

            BufferedWriter pw = new BufferedWriter(fw);

            //  pw.append(convertStringToHex("GIN" )+ "," + convertStringToHex(lotnoss )+","+ convertStringToHex(scanunique) +","+ convertStringToHex(strDate) + "," + convertStringToHex(Errstring )+","+convertStringToHex(Empcode)+","+convertStringToHex(Unit)+"," +convertStringToHex(lotnoss+"GIN")+ "\r\n");

            pw.append(BulkIndentCodeUpdate +","+AXRecidcheck+ " \r\n");


            pw.flush();
            pw.close();
            fw.close();


            // Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            // Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            // r.play();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Log.i(TAG, "******* File not found. Did you"
            // + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();


        }

    }


    public void BulkApprovalDataSaveNew() {


        fisttimecount = true;
        totalcount = 0;
        linecheck = 1;


        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            if (ISIndentBulkApprovalFile.exists()) {

                if (fisttimecount.equals(true)) {

                    try {

                        // totcounts.setVisibility(View.VISIBLE);
                        // update.setVisibility(View.VISIBLE);

                        //    prgDialog.show();


                        //create BufferedReader to read csv file
                        BufferedReader br = new BufferedReader(new FileReader(ISIndentBulkApprovalFile));
                        String line = "";


                        int lineNumber = 0;

                        //read comma separated file line by line
                        while ((line = br.readLine()) != null) {
                            lineNumber++;
                            totalcount++;

                            //use comma as token separator
                            String[] country = line.split(",");

                            if (lineNumber == linecheck) {


                                ApprovalDataSyn = country[0].toString();
                                AXRecidupdate=country[1].toString();


                                fisttimecountexit = false;
                                EventDataApprovalUpdate();
                            }

                        }
                        // totcounts.setText(String.valueOf("TotCnt:" + totalcount));
                        fisttimecount = false;

                    } catch (Exception e) {
                        System.err.println("CSV file cannot be read : " + e);
                        //  prgDialog.hide();
                    }


                } else {

                    if (Syncomplete.equals(false)) {
                        Toast.makeText(getApplicationContext(), " Already Syn completed ", Toast.LENGTH_LONG).show();
                        // prgDialog.hide();
                    } else {

                        Toast.makeText(getApplicationContext(), " Syn in progress", Toast.LENGTH_LONG).show();
                        //  prgDialog.hide();
                    }
                }


            } else {

                Toast.makeText(getApplicationContext(), " Please Tick Event Code ", Toast.LENGTH_LONG).show();
                Check = "Checkfile".toString();

                // prgDialog.hide();
            }

        } else {
            {

                // Internet connection doesn't exist
                showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                // prgDialog.hide();

            }

        }


    }

    private void BulkApprovalDataSaveNewSyn() {


        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            try {


                //create BufferedReader to read csv file
                BufferedReader br = new BufferedReader(new FileReader(ISIndentBulkApprovalFile));
                String line = "";


                int lineNumber = 0;

                //read comma separated file line by line
                while ((line = br.readLine()) != null) {
                    lineNumber++;


                    //use comma as token separator
                    String[] country = line.split(",");

                    if (lineNumber == linecheck) {


                        ApprovalDataSyn = country[0].toString();
                        AXRecidupdate=country[1].toString();

                        EventDataApprovalUpdate();


                    }
                }


            } catch (Exception e) {
                System.err.println("CSV file cannot be read : " + e);
                /// prgDialog.hide();
            }

        } else

        {


            // Internet connection doesn't exist
            showAlertDialog(RBMIndentSelection.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Synchronization Not Completed", Toast.LENGTH_LONG).show();

            //  prgDialog.hide();
            fisttimecount = true;
            totalcount = 0;
        }

    }


    private void EventDataApprovalUpdate() {


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        //if (isConnectionExist || isConnectionExistMobile) {


        String IndentCode1 = ApprovalDataSyn.toString();

        String AXrecid1 = AXRecidupdate.trim().toString();

        //  prgDialog1.show();
        //  prgDialog.show();

        // insertToDatabase2(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);
        insertToDatabase3(IndentCode1, AXrecid1);


        //} else {

        // Internet connection doesn't exist
        // showAlertDialog(MainActivity.this, "No Internet Connection",
        //     "Your device doesn't have WIFI or Data Plan internet access", false);


        // }
    }

    // private void insertToDatabase2( String EventCode1,String ApType1,String SubActivity1,String PoCodeSpinner2, String VillageNameSpineer2,String Date2,String SupportingPo2, String Remark2,String PoState2,String PoRegion2, String POTerritory2){

    private void insertToDatabase3(String IndentCode1, String AXrecid1) {


        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];


                String IndentCode1 = ApprovalDataSyn.toString();

                String AXrecid1 = AXRecidupdate.trim().toString();


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


                nameValuePairs.add(new BasicNameValuePair("IndentNo", IndentCode1));
                nameValuePairs.add(new BasicNameValuePair("AXRecID", AXrecid1.trim().toString()));


                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    // HttpPost httpPost = new HttpPost("http://172.16.3.21/HrDataUpdate.php");

                    HttpPost httpPost = new HttpPost(IPAddress+ProjectFolder+"/ISDataRBMValidate.php");
//                    HttpPost httpPost = new HttpPost(FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISDataRBMValidate.php");
//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISDataRBMValidate.php");
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

                    Toast.makeText(getApplicationContext(), "  Indent Approval Completed", Toast.LENGTH_LONG).show();


                    prgDialog.hide();
                    linecheck = 0;
                    totalcount = 0;
                    fisttimecount = true;

                    list.setAdapter(null);
                    prgDialog.hide();
                    finish();

                } else {


                    linecheck = linecheck + 1;

                    BulkApprovalDataSaveNewSyn();
                }


            }


        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        //sendPostReqAsyncTask.execute(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);
        sendPostReqAsyncTask.execute(IndentCode1, AXrecid1);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rbmindent_approval_process, menu);
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


  /*  @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Back");
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

    //protected Dialog onCreateDialog(int id) {
    // switch (id) {
    //  case DATE_DIALOG_ID:
    //  return new DatePickerDialog(this,
    // pDateSetListener,
    //pYear, pMonth, pDay);

    // }
    //return null;
    // }


    public void CloseActivity(View view) {

        //  finish();


        Intent intent = new Intent(this, RBMScreenActivity.class);
        intent.putExtra("Po_code", POCodeGet);
        intent.putExtra("Po_name", PONameGet);
        intent.putExtra("Tm_name", TerritoryNameGet);
        intent.putExtra("Post_code", PostCodeTransfer);
        intent.putExtra("Division_code", DivisionGet);
        intent.putExtra("Site_ID", SiteGet);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// This flag ensures all activities on top of the CloseAllViewsDemo are cleared.
        this.startActivity(intent);



    }


    public static boolean setListViewHeightBasedOnItems(ListView listView) {

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
            int totalDividersHeight = listView.getDividerHeight() *
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
