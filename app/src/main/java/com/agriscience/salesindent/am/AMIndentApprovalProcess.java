package com.agriscience.salesindent.am;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

import com.agriscience.salesindent.Retrofit.ApiInterface;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.CountryRemark;
import com.agriscience.salesindent.R;
import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.am.AMIndentSelection;
import com.agriscience.salesindent.model.AmDetailsResponse;
import com.agriscience.salesindent.model.AmResponse;
import com.agriscience.salesindent.model.IndentNoDetailsResponse;
import com.agriscience.salesindent.model.IndentNoResponse;
import com.agriscience.salesindent.model.SalesIndentStatusDetailsResponse;
import com.agriscience.salesindent.model.SalesIndentStatusResponse;
import com.agriscience.salesindent.model.SalesIndentStatusUIData;
import com.agriscience.salesindent.model.SuccessResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AMIndentApprovalProcess extends Activity {
    private Cursor GetCursorOrderDetails;
    String UnitIDtosend;
    String PackagingIDsend;
    // private SQLiteDatabase dbGetmaster;
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
    float int_size = 0;
    String int_type = " Kgs";

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

    String spSelectedTmCode = "";


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
    LinearLayout LinearSeconds;
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

    ListView statusListView;


    Button SelectAll;
    ImageButton bnSubmit;


    String BulkIndentCodeUpdate;


    int linecheck = 1;
    int totalcount = 0;


    CheckBox AllDataApproval;


    String ApprovalDataSyn;


    ArrayList<CountryRemark> countryList = new ArrayList<CountryRemark>();

    private String[] IndentCodeBulk;
    private String[] EventDateBulk;
    private String[] CancelRemarks;
    private String[] item_remarks_String;
    private String[] AxRecid;


    boolean[] nameCheckBoxState;


    TextView LableName;


    String CancelRemarksSet = "";

    String CancelRemarkscheck;

    String AxQtyBagCheck = "";

    String AXRecidcheck;


    List<String> indentNoList = new ArrayList<String>();
    List<String> customerNameList = new ArrayList<String>();
    List<String> qtyInPktList = new ArrayList<String>();
    List<Boolean> nameCheckBoxStateList = new ArrayList<Boolean>();

    List<String> codes3 = new ArrayList<String>();

    private boolean checkBoxStateCheck = false;

    String AXRecidupdate = "";


    List<String> CancelRemarkscheck2 = new ArrayList<String>();
    List<String> itemRemarksList = new ArrayList<>();
    List<Boolean> checkBoxStateCheck2 = new ArrayList<Boolean>();


    private boolean checkBoxStateCS = false;
    private boolean checkBoxStateDS = false;

    private boolean checkBoxStateAP = false;
    private boolean checkBoxStateRET = false;


//    List<Boolean> checkBoxStateCS2 = new ArrayList<Boolean>();
//    List<Boolean> checkBoxStateDS2 = new ArrayList<Boolean>();

    List<Boolean> approvalCheckBoxList = new ArrayList<Boolean>();
    List<Boolean> rejectCheckBoxList = new ArrayList<Boolean>();


//    boolean[] checkBoxState3;
//    boolean[] checkBoxState4;

    boolean[] approvalCheckBoxState;
    boolean[] rejectCheckBoxState;

    //    String FinalIPAddress;
    String IPAddress = "http://103.44.97.110:8080/kanagaraj/";
//    String IPAddress = "http://192.168.35.24/hyveg/Sales_Indent_App/";

    File ISHeaderDataFile = null;
    File ISLineDataFile = null;
    File ISLineDataTempFile = null;

    File ISIndentCodeFile = null;

    File ISProductMasterFile = null;

    File ISCustMasterInput = null;
    File ISItemMasterInput = null;
    File ISCropMasterInput = null;
    File ISSiteMasterInput = null;
    File ISWarehouseMasterInput = null;

    String PostCodeTransferGet = "";
    String SiteGet = "";


    List<String> hybridList = new ArrayList<String>();
    List<String> indentDateList = new ArrayList<String>();
    List<String> customerCodeList = new ArrayList<String>();
    List<String> qtyInBagList = new ArrayList<String>();
    List<String> qtyInKgList = new ArrayList<String>();


    private String[] AXCustAccount;
    private String[] AXHybrid;
    private String[] AxIndentDate;
    private String[] AxQtyInBag;
    private String[] AxQtyInPkt;
    private String[] AxQtyInKgs;
    private String[] AxQtyInKgs_temp;


    String DivisionGet = "";
    String ProjectFolder = "";

    ArrayList<String> resultlocation;
    ArrayList<String> resultIndentNo;
    ArrayList<String> resultproject;


    Spinner spIndentNo;
    String spSelectedIndentNos = "";

    String FullIPData = "";

    String EventBackCheck = "";
    ViewGroup headerView;

    String AxQtyUpdate = "";
    String AxIndentTypes = "";

    String IntentType = "";


    String UomValueCheck = "";

    Double SalQty = 0.00;

    Double SalQtyKgs = 0.00;

    Double QtyInKgsCheck = 0.00;

    String ItemCodeCheck = "";

    String RecIdCheck = "";

    int Axposion = 1;

    LinearLayout HeaderView;


    List<String> RejectRemarkscheck2 = new ArrayList<String>();
    List<Boolean> IndentBoxStateCheck2 = new ArrayList<Boolean>();
    List<Boolean> RejectBoxStateCheck2 = new ArrayList<Boolean>();
    List<String> AxQtyInBagCheck2 = new ArrayList<String>();
    List<String> AxQtyInPktCheck2 = new ArrayList<String>();


    String ApproveDataCheck = "";
    String RejectDataCheck = "";
    String RejectRemarksCheck = "";

    String AxApproveRejectType = "";
    String AxRejectRemarksChecks = "";


    Double CurrentStockQty = 0.00;
    Double AllocationStockQty = 0.00;
    Double InvoieStockQty = 0.00;
    Double BalQty = 0.00;
    Double PBalQty = 0.00;
    Double PlacementQty = 0.00;

    Double SalPrice = 0.00;
    String SalPriceTemp = "";

    Double CustBal = 0.00;
    Double OrderValue = 0.00;
    Double CurCustBal = 0.00;
    Double CustCreditLimit = 0.00;

    String AllocationCheckItems = "";

    String PriceCheckItems1 = "";
    String PriceCheckItems2 = "";

    String MandatoryCreditLimit = "";

    Double CustCreditLimitAlert = 0.00;

    Double EmptyBagQty = 0.00;


    private SQLiteDatabase dbGetmaster;
    File Getmasterpath = null;


    private Cursor cScanDetails;


    private SQLiteDatabase dbSalesIndent;
    File SalesIndentPath = null;


    String GetmasterCheck = "";


    String UpdatePlacementCheck = "";
    String UpdateAllocaionCheck = "";
    String UpdateCreditLimitCheck = "";


    String IndentCodeBulkEditText = "";


    Double OldSalesQtyTemp = 0.00;
    Double OrderValueTemp = 0.00;


    Double StdWeight = 0.00;
    Double ConFactor = 0.00;

    String QtyInPkts = "";


    String QtyInPktsChecks = "";

    AppSharedPreferences sessionManager;
    private ApiInterface apiInterface;
    private List<AmDetailsResponse> amDetailsResponseList;

    private List<SalesIndentStatusUIData> statusUiDataList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amindent_approval_process);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //Generate list View from ArrayList


        appLocationService = new AppLocationService(AMIndentApprovalProcess.this);

        statusListView = (ListView) findViewById(R.id.listView);

        PoCodeSpinner = (Spinner) findViewById(R.id.spSTORbm);

        Linearfirst = (LinearLayout) findViewById(R.id.Linear1);
        LinearSecond = (ScrollView) findViewById(R.id.scrollView);
        LinearSeconds = (LinearLayout) findViewById(R.id.llIndentNo);
        HeaderView = (LinearLayout) findViewById(R.id.Header);

        bnSubmit = (ImageButton) findViewById(R.id.bnSubmit);

        LableName = (TextView) findViewById(R.id.textView33);

        spIndentNo = (Spinner) findViewById(R.id.spIndentNo);

        sessionManager = new AppSharedPreferences(this);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            POCodeGet = extras.getString("Po_code");
            PONameGet = extras.getString("Po_name");
            TerritoryNameGet = extras.getString("Tm_name");
            PostCodeTransferGet = extras.getString("Post_code");
            SiteGet = extras.getString("Site_ID");
            DivisionGet = extras.getString("Division_code");
//
//            if (DivisionGet.equals("Cotton")) {
//
//                // ProjectFolder="CNFSalesOrderCotton";
//                ProjectFolder = "SalesIndentCotton";
//
//
//            } else {
//                //ProjectFolder="CNFSalesOrderFieldCrop";
//                ProjectFolder = "SalesIndentFieldCrop";
//
//            }


        }


        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));


        if (Oroot.canWrite()) {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISCustMasterInput = new File(dir, "ISCustMaster.csv");


        }

        if (Oroot.canWrite()) {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISItemMasterInput = new File(dir, "ISItemMaster.csv");


        }


        if (Oroot.canWrite()) {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISCropMasterInput = new File(dir, "ISCropMaster.csv");


        }


        if (Oroot.canWrite()) {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISSiteMasterInput = new File(dir, "ISSiteMaster.csv");


        }

        if (Oroot.canWrite()) {

            File dir = new File(Oroot.getAbsolutePath() + "/IndentMaster");
            dir.mkdirs();

            ISWarehouseMasterInput = new File(dir, "ISWarehouseMaster.csv");


        }


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

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISLineDataTempFile = new File(dir, "ISLineDataTempFile.csv");
        }


        if (Iroot.canWrite()) {
            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentData");
            dir.mkdirs();

            ISIndentCodeFile = new File(dir, "ISIndentCodeFile.csv");
        }

        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISProductMasterFile = new File(dir, "ISProductMaster.csv");
        }


        if (Iroot.canWrite()) {

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISIndentBulkApprovalFile = new File(dir, "ISIndentBulkApprovalFile.csv");
        }


        if (Oroot.canWrite()) {
            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentDB");
            dir.mkdirs();

            SalesIndentPath = new File(dir, "SIDetailsDB.db");

        }


//        createDatabaseSalesIndentData();
//        createTableSalesIndentApprove();
//        createTableSalesIndentApproveTemp();

//        GetTeritory();
        callAmApi();

        //  getData3();
        //Getlist3();

        //  displayListView();

        //    checkButtonClick();

        PoCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get select item


                String UnitIds2 = PoCodeSpinner.getItemAtPosition(position).toString();
                spSelectedTmCode = PoCodeSpinner.getSelectedItem().toString();

                String[] separated = spSelectedTmCode.split("-");
                spSelectedTmCode = separated[0];


                if ("Please Select".equals(spSelectedTmCode)) {

                } else {
//                    GetIndentData();
                    callIndentApi();
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });


        spIndentNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get select item


                String UnitIds2 = spIndentNo.getItemAtPosition(position).toString();
                spSelectedIndentNos = spIndentNo.getSelectedItem().toString();

                // String[] separated = PoCodeSpinners.split("-");
                // PoCodeSpinners = separated[0];


                if ("Please Select".equals(spSelectedIndentNos)) {

                } else {
//                    getTmRequestData();
                    callIndentNoStatusApi();

                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });


    }


    private void IndentActivity() {

        Intent intent = new Intent(this, AMIndentSelection.class);
        intent.putExtra("Po_code", POCodeGet);
        intent.putExtra("Po_name", PONameGet);
        intent.putExtra("Tm_name", TerritoryNameGet);
        intent.putExtra("Post_code", PostCodeTransferGet);
        intent.putExtra("Site_ID", SiteGet);
        intent.putExtra("Division_code", DivisionGet);
        intent.putExtra("IndentNo_No", spSelectedIndentNos);
        startActivity(intent);

    }


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
                HttpPost httppost = new HttpPost(IPAddress + ProjectFolder + "/TerritoryFetchs.php?RBMCode=" + POCodeGet);
//                HttpPost httppost = new HttpPost(FinalIPAddress + "/kanagaraj/"+ProjectFolder+"/TerritoryFetchs.php?RBMCode="+POCodeGet);
//                HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/TerritoryFetchs.php?RBMCode=" + POCodeGet);
//                HttpPost httppost = new HttpPost(new_api.TerritoryFetchs(ProjectFolder ,POCodeGet));

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
                    prgDialog.show();
                } finally {
                    try {
                        if (inputStream != null) inputStream.close();
                    } catch (Exception squish) {
                        prgDialog.show();
                    }
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;


                if (result != null) {
                    try {
                        showList1();
                    } catch (Exception e) {
                        prgDialog.cancel();
                        Toast.makeText(AMIndentApprovalProcess.this, "Error3", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Internet connection doesn't exist
                    showAlertDialogWarning(AMIndentApprovalProcess.this, "No Internet Connection",
                            "Your device doesn't have WIFI or Data Plan internet access", false);

                    prgDialog.cancel();
                }

            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    private void callAmApi() {
        prgDialog.show();
        Call<AmResponse> call = apiInterface.getAllAMDetails(sessionManager.getUserId());
        call.enqueue(new Callback<AmResponse>() {
            @Override
            public void onResponse(Call<AmResponse> call, Response<AmResponse> response) {
                AmResponse amResponse = response.body();
                prgDialog.hide();
                if (amResponse.getResult() != null && amResponse.getResult().size() > 0) {
                    amDetailsResponseList = amResponse.getResult();
                    showAmDetailsOnView();
                } else {
                    Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AmResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });
    }

    private void showAmDetailsOnView() {
        List<String> codes = new ArrayList<String>();

        amDetailsResponseList.stream().forEach(amDetailsResponse -> {
            codes.add(amDetailsResponse.getTiId().trim() + " - " + amDetailsResponse.getTiName());
        });

        HashSet<String> set = new HashSet<>(codes);

        // Create ArrayList from the set.
        ArrayList<String> result = new ArrayList<>(set);
        Collections.sort(result);
        resultlocation = new ArrayList<>();


        resultlocation.add("Please Select");
//        resultlocation.add("ALL");


        for (int j = 0; j < result.size(); j++) {

            String codes2 = result.get(j);


            resultlocation.add(codes2);

        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, resultlocation);
        adapter1.setDropDownViewResource(R.layout.spinner_item);
        PoCodeSpinner.setAdapter(adapter1);
        prgDialog.cancel();
    }


    protected void showList1() {


        List<String> codes = new ArrayList<String>();
        String Checkfile = "";

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


                codes.add(Id + "-" + A);
                Checkfile = "Checkfile";

            }
            if (Checkfile.equals("Checkfile")) {

                HashSet<String> set = new HashSet<>(codes);

                // Create ArrayList from the set.
                ArrayList<String> result = new ArrayList<>(set);
                //Comparator mycomparator = Collections.reverseOrder();
                //Collections.sort(result,mycomparator);

                Collections.sort(result);


                // List<String> codes3 = new ArrayList<String>();

                resultlocation = new ArrayList<>();


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
                prgDialog.cancel();
            }


        } catch (JSONException e) {
            e.printStackTrace();

            //  Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();

            prgDialog.cancel();

        }


    }

    private void callIndentApi() {
        prgDialog.show();
        if (spSelectedTmCode.equals("ALL")) {
//            FullIPData = IPAddress + ProjectFolder + "/ISIndenNoFetchRBMALL.php?RBMCode=" + POCodeGet + "&Dcode=" + sessionManager.get_dcode();
        } else {
//            FullIPData = IPAddress + ProjectFolder + "/ISIndenNoFetchRBM.php?TMId=" + PoCodeSpinners + "&Dcode=" + sessionManager.get_dcode();

            Call<IndentNoResponse> call = apiInterface.getAllAMIndentNoDetails(spSelectedTmCode);
            call.enqueue(new Callback<IndentNoResponse>() {
                @Override
                public void onResponse(Call<IndentNoResponse> call, Response<IndentNoResponse> response) {
                    IndentNoResponse indentNoResponse = response.body();
                    prgDialog.hide();
                    if (indentNoResponse.getResult() != null && indentNoResponse.getResult().size() > 0) {
                        List<IndentNoDetailsResponse> detailsResponseList = indentNoResponse.getResult();
                        showIndentNoOnView(detailsResponseList);
                    } else {

                        Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_LONG).show();

                    }


                }

                @Override
                public void onFailure(Call<IndentNoResponse> call, Throwable t) {
                    call.cancel();
                    prgDialog.hide();
                }
            });
        }
    }

    private void showIndentNoOnView(List<IndentNoDetailsResponse> detailsResponseList) {
        List<String> codes = new ArrayList<String>();

        detailsResponseList.stream().forEach(indentNoDetailsResponse -> {
            codes.add(indentNoDetailsResponse.getIndentNo());
        });


        HashSet<String> set = new HashSet<>(codes);
        ArrayList<String> result = new ArrayList<>(set);
        Collections.sort(result);

        resultIndentNo = new ArrayList<String>();
        resultIndentNo.add("Please Select");
//        resultIndentNo.add("ALL");


        for (int j = 0; j < result.size(); j++) {
            String codes2 = result.get(j);
            resultIndentNo.add(codes2);
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, resultIndentNo);
        adapter1.setDropDownViewResource(R.layout.spinner_item);
        spIndentNo.setAdapter(adapter1);


        bnSubmit.setVisibility(View.GONE);
        Linearfirst.setVisibility(View.GONE);
        LinearSeconds.setVisibility(View.VISIBLE);
        HeaderView.setVisibility(View.GONE);

        prgDialog.cancel();
    }


    private void GetIndentData() {


        if (spSelectedTmCode.equals("ALL")) {

            FullIPData = IPAddress + ProjectFolder + "/ISIndenNoFetchRBMALL.php?RBMCode=" + POCodeGet + "&Dcode=" + sessionManager.get_dcode();
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndenNoFetchRBMALL.php?RBMCode="+POCodeGet + "&Dcode=" + sessionManager.get_dcode();
//            FullIPData = "http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISIndenNoFetchRBMALL.php?RBMCode=" + POCodeGet + "&Dcode=" + sessionManager.get_dcode();
//            FullIPData = new_api.ISIndenNoFetchRBMALL(ProjectFolder, POCodeGet ,sessionManager.get_dcode());


        } else {

            FullIPData = IPAddress + ProjectFolder + "/ISIndenNoFetchRBM.php?TMId=" + spSelectedTmCode + "&Dcode=" + sessionManager.get_dcode();
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndenNoFetchRBM.php?TMId="+PoCodeSpinners+ "&Dcode=" + sessionManager.get_dcode();
//            FullIPData = "http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISIndenNoFetchRBM.php?TMId=" + PoCodeSpinners + "&Dcode=" + sessionManager.get_dcode();
//            FullIPData = new_api.ISIndenNoFetchRBM(ProjectFolder ,PoCodeSpinners ,sessionManager.get_dcode());

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
                        prgDialog.cancel();
                        // Oops
                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {
                            prgDialog.cancel();
                        }
                    }
                    return result;
                }

                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;


                    if (result != null) {
                        try {
                            showAllTmRequest();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(AMIndentApprovalProcess.this, "Error4", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        // Internet connection doesn't exist
                        showAlertDialogWarning(AMIndentApprovalProcess.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();


                    }

                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {

            //Internet connection doesn't exist
            showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }


    protected void showAllTmRequest() {


        List<String> codes = new ArrayList<String>();
        String Checkfile = "";
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


                codes.add(Id);
                Checkfile = "Checkfile";

            }
            if (Checkfile.equals("Checkfile")) {

                HashSet<String> set = new HashSet<>(codes);

                // Create ArrayList from the set.
                ArrayList<String> result = new ArrayList<>(set);
                //Comparator mycomparator = Collections.reverseOrder();
                //Collections.sort(result,mycomparator);

                Collections.sort(result);


                // List<String> codes3 = new ArrayList<String>();

                resultIndentNo = new ArrayList<String>();


                resultIndentNo.add("Please Select");
                resultIndentNo.add("ALL");


                for (int j = 0; j < result.size(); j++) {

                    String codes2 = result.get(j);


                    resultIndentNo.add(codes2);
                    Check = "chckfile".toString();

                }


                // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
                //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Product.setAdapter(adapter1);


                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, resultIndentNo);
                adapter1.setDropDownViewResource(R.layout.spinner_item);
                spIndentNo.setAdapter(adapter1);


                if (Check.equals("chckfile")) {

                    prgDialog.cancel();
                    bnSubmit.setVisibility(View.GONE);
                    Linearfirst.setVisibility(View.GONE);
                    LinearSeconds.setVisibility(View.VISIBLE);
                    EventBackCheck = "EventBackCheckfile2";

                    HeaderView.setVisibility(View.GONE);
                    Check = "";
                } else {
                    Toast.makeText(getApplicationContext(), "No Pending Approve1", Toast.LENGTH_SHORT).show();
                    prgDialog.cancel();
                    //finish();
                }


            } else {
                prgDialog.cancel();
                Toast.makeText(getApplicationContext(), "No Pending Approve2", Toast.LENGTH_SHORT).show();
            }


        } catch (JSONException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "No Pending Approve3", Toast.LENGTH_SHORT).show();

            prgDialog.cancel();

        }


    }

    private void callIndentNoStatusApi() {
        prgDialog.show();
        Call<SalesIndentStatusResponse> call = apiInterface.getAllAMIndentDetailsByIndentNo(spSelectedTmCode, spSelectedIndentNos);
        call.enqueue(new Callback<SalesIndentStatusResponse>() {
            @Override
            public void onResponse(Call<SalesIndentStatusResponse> call, Response<SalesIndentStatusResponse> response) {
                Log.d("RbmIndentApprovalProcess", response.body().toString());
                prgDialog.hide();
                SalesIndentStatusResponse statusResponse = response.body();
                showIndentStatusOnView(statusResponse.getResult());
            }

            @Override
            public void onFailure(Call<SalesIndentStatusResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });
    }

    protected void showIndentStatusOnView(List<SalesIndentStatusDetailsResponse> responseList) {

        indentNoList.removeAll(indentNoList);
        customerNameList.removeAll(customerNameList);
        qtyInPktList.removeAll(qtyInPktList);
        codes3.removeAll(codes3);
        hybridList.removeAll(hybridList);
        indentDateList.removeAll(indentDateList);
        customerCodeList.removeAll(customerCodeList);
        qtyInBagList.removeAll(qtyInBagList);
        qtyInKgList.removeAll(qtyInKgList);
        CancelRemarkscheck2.removeAll(CancelRemarkscheck2);
        itemRemarksList.removeAll(itemRemarksList);


        nameCheckBoxStateList.removeAll(nameCheckBoxStateList);
//        checkBoxStateCS2.removeAll(checkBoxStateCS2);
//        checkBoxStateDS2.removeAll(checkBoxStateDS2);
        approvalCheckBoxList.removeAll(approvalCheckBoxList);
        rejectCheckBoxList.removeAll(rejectCheckBoxList);

        statusUiDataList.removeAll(statusUiDataList);

        statusListView.setAdapter(null);


        try {

            responseList.stream().forEach(detailsResponse -> {
                SalesIndentStatusUIData statusUIData = new SalesIndentStatusUIData();
                statusUIData.setIndentNo(detailsResponse.getIndentNo());
                statusUIData.setCustomerName(detailsResponse.getCustomerName());
                statusUIData.setQtyInPkt(detailsResponse.getQuantityInKgsOrPackets());
                statusUIData.setRecId(detailsResponse.getRecID());
                statusUIData.setMaterialName(detailsResponse.getMaterialName());
                statusUIData.setIndentDate(detailsResponse.getIndentDate());
                statusUIData.setCustomerCode(detailsResponse.getCustomerCode());
                statusUIData.setQtyInBag(detailsResponse.getQuantityInKgsOrPackets());
                statusUIData.setQtyInKg(detailsResponse.getRequiredQuantityInKgs());
                statusUIData.setItemRemarks(detailsResponse.getTiRemarks());
                statusUIData.setCancelRemarks("");
                statusUIData.setNameCheckBoxBool(false);
                statusUIData.setApprovalCheckBoxBool(true);
                statusUIData.setRejectCheckBoxBool(false);
                statusUIData.setBaseUOM(detailsResponse.getBaseUom());
                statusUIData.setPackingQuantity(detailsResponse.getPackingQuantity());
                statusUiDataList.add(statusUIData);


//
//                IndentCodeBulk = new String[indentNoList.size()];
//                EventDateBulk = new String[customerNameList.size()];
//                AxQtyInPkt = new String[qtyInPktList.size()];
//                AxRecid = new String[codes3.size()];
//                AXHybrid = new String[hybridList.size()];
//                AxIndentDate = new String[indentDateList.size()];
//                AXCustAccount = new String[customerCodeList.size()];
//                AxQtyInBag = new String[qtyInBagList.size()];
//                AxQtyInKgs = new String[qtyInKgList.size()];
//                AxQtyInKgs_temp = new String[qtyInKgList.size()];
//                CancelRemarks = new String[CancelRemarkscheck2.size()];
//                item_remarks_String = new String[itemRemarksList.size()];
//
//
//                nameCheckBoxState = new boolean[nameCheckBoxStateList.size()];
//
////                checkBoxState3 = new boolean[checkBoxStateCS2.size()];
////                checkBoxState4 = new boolean[checkBoxStateDS2.size()];
//                approvalCheckBoxState = new boolean[approvalCheckBoxList.size()];
//                rejectCheckBoxState = new boolean[rejectCheckBoxList.size()];


            });


//            for (int j = 0; j < indentNoList.size(); j++) {
//                // Get the path of the image file
//                IndentCodeBulk[j] = indentNoList.get(j);
//                EventDateBulk[j] = customerNameList.get(j);
//                AxQtyInPkt[j] = qtyInPktList.get(j);
//                AxRecid[j] = codes3.get(j);
//                nameCheckBoxState[j] = nameCheckBoxStateList.get(j);
//
//                AXHybrid[j] = hybridList.get(j);
//                AxIndentDate[j] = indentDateList.get(j);
//                AXCustAccount[j] = customerCodeList.get(j);
//
////                checkBoxState3[j] = checkBoxStateCS2.get(j);
////                checkBoxState4[j] = checkBoxStateDS2.get(j);
//
//                approvalCheckBoxState[j] = approvalCheckBoxList.get(j);
//                rejectCheckBoxState[j] = rejectCheckBoxList.get(j);
//
//
//                AxQtyInBag[j] = qtyInBagList.get(j);
//                AxQtyInKgs[j] = qtyInKgList.get(j);
//                AxQtyInKgs_temp[j] = qtyInKgList.get(j);
//                CancelRemarks[j] = CancelRemarkscheck2.get(j);
//                item_remarks_String[j] = itemRemarksList.get(j);
//
//            }

            RBMIndentStatusListAdapter myListAdapter = new RBMIndentStatusListAdapter();
            statusListView.setAdapter(myListAdapter);
            setListViewHeightBasedOnItems(statusListView);
            Linearfirst.setVisibility(View.GONE);
            LinearSeconds.setVisibility(View.GONE);


            if (statusUiDataList.size() > 0) {
                bnSubmit.setVisibility(View.VISIBLE);
                statusListView.setVisibility(View.VISIBLE);
                HeaderView.setVisibility(View.VISIBLE);
            } else {
                bnSubmit.setVisibility(View.GONE);
                statusListView.setVisibility(View.GONE);
                HeaderView.setVisibility(View.GONE);
            }

            prgDialog.cancel();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No Pending Approve4", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            prgDialog.cancel();
            HeaderView.setVisibility(View.GONE);
        }

    }


    public void getTmRequestData() {

        if (spSelectedIndentNos.equals("ALL") && spSelectedTmCode.equals("ALL")) {


            FullIPData = IPAddress + ProjectFolder + "/ISIndentDataFetchRBMALL.php?RBMCode=" + POCodeGet;
            Log.d("Stringsss---", "---------------" + FullIPData);

        } else if (spSelectedIndentNos.equals("ALL") && !spSelectedTmCode.equals("ALL")) {


            FullIPData = IPAddress + ProjectFolder + "/ISIndentDataFetchRBM_TMALL.php?TMCode=" + spSelectedTmCode;

            Log.d("Stringsss---", "---------------" + FullIPData);

        } else {

            FullIPData = IPAddress + ProjectFolder + "/ISIndentDataFetchRBM.php?IndentNo=" + spSelectedIndentNos;
//
            Log.d("Stringsss---", "---------------" + FullIPData);
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
                        prgDialog.cancel();
                        // Oops
                    } finally {
                        try {
                            if (inputStream != null) inputStream.close();
                        } catch (Exception squish) {
                            prgDialog.cancel();
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
                            Toast.makeText(AMIndentApprovalProcess.this, "Error1", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialogWarning(AMIndentApprovalProcess.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();


                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {

            //Internet connection doesn't exist
            showAlertDialogWarning(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }


    protected void showList3() {


        Check = "";

        indentNoList.removeAll(indentNoList);
        customerNameList.removeAll(customerNameList);
        qtyInPktList.removeAll(qtyInPktList);
        codes3.removeAll(codes3);
        hybridList.removeAll(hybridList);
        indentDateList.removeAll(indentDateList);
        customerCodeList.removeAll(customerCodeList);
        qtyInBagList.removeAll(qtyInBagList);
        qtyInKgList.removeAll(qtyInKgList);
        CancelRemarkscheck2.removeAll(CancelRemarkscheck2);
        itemRemarksList.removeAll(itemRemarksList);


        nameCheckBoxStateList.removeAll(nameCheckBoxStateList);
//        checkBoxStateCS2.removeAll(checkBoxStateCS2);
//        checkBoxStateDS2.removeAll(checkBoxStateDS2);
        approvalCheckBoxList.removeAll(approvalCheckBoxList);
        rejectCheckBoxList.removeAll(rejectCheckBoxList);

        statusListView.setAdapter(null);


        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                Log.d("Objectttttt", "--------------" + c.toString());

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
                String S = c.getString(T20);
                String T = c.getString(T21);
                String U = c.getString(T22);
                String V = c.getString(T23);
                String W = c.getString(T24);
                //y passed throught x
                String Y = c.getString(T25);


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
                persons.put(T23, V);
                persons.put(T24, W);
                persons.put(T26, Y);
                 /* persons.put(T25, X);
                persons.put(T26, Y);
                persons.put(T27, Z);*/

//INDENTNO	INDENTDATE	INDENTTIME	CUSTCODE	CUSTNAME	SITE	WAREHOUSE	EXPECTEDDATE	TMCODE	TERRITORY	STATECODE	REGION	ITEMID	ITEMNAME	CROPTYPE	CROPNAME	INDENTQTY	DATAAREAID	RECVERSION	RECID	SLNO	STRINGDATE	INDENTSTATUS


                // if (Pocoode1.equals(PoCodeSpinners) && OpenCloseStatus1.equals("OPEN") && ApprovalPendingStatus1.equals("PENDING")) {


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


                indentNoList.add(Id);
                customerNameList.add(D);
                // codes1.add(A + "    " + C + "    " + D + "      " + T + "      " + M  );
                qtyInPktList.add(P);
                codes3.add(U);
//                codes4.add(L);
                hybridList.add(M);
                indentDateList.add(A);
                customerCodeList.add(C);
                qtyInBagList.add(V);
                qtyInKgList.add(W);
                itemRemarksList.add(Y);
                CancelRemarkscheck2.add("");
                nameCheckBoxStateList.add(false);
//                checkBoxStateCS2.add(true);
//                checkBoxStateDS2.add(false);
                approvalCheckBoxList.add(true);
                rejectCheckBoxList.add(false);


                // IndentCodeBulk = EventCode1;
                // EventDateBulk = CreationDate1 + "    " + Pocoode1 + "    " + ActivityCode1 + "      " + ActivityName1 + "      " + VillageName1 + "    " + TalukMandal1 + "      " + HybridName1 + "      " + SupportingPOs1 + "      " + Remarks1;
                // CancelRemarks="";

                //  CountryRemark country = new CountryRemark("", IndentCodeBulk, CancelRemarks,EventDateBulk,false);
                //  countryList.add(country);


                IndentCodeBulk = new String[indentNoList.size()];
                EventDateBulk = new String[customerNameList.size()];
                AxQtyInPkt = new String[qtyInPktList.size()];
                AxRecid = new String[codes3.size()];


                AXHybrid = new String[hybridList.size()];
                AxIndentDate = new String[indentDateList.size()];
                AXCustAccount = new String[customerCodeList.size()];
                AxQtyInBag = new String[qtyInBagList.size()];
                AxQtyInKgs = new String[qtyInKgList.size()];
                AxQtyInKgs_temp = new String[qtyInKgList.size()];
                CancelRemarks = new String[CancelRemarkscheck2.size()];
                item_remarks_String = new String[itemRemarksList.size()];


                nameCheckBoxState = new boolean[nameCheckBoxStateList.size()];

//                checkBoxState3 = new boolean[checkBoxStateCS2.size()];
//                checkBoxState4 = new boolean[checkBoxStateDS2.size()];
                approvalCheckBoxState = new boolean[approvalCheckBoxList.size()];
                rejectCheckBoxState = new boolean[rejectCheckBoxList.size()];


            }


            for (int j = 0; j < indentNoList.size(); j++) {
                // Get the path of the image file
                IndentCodeBulk[j] = indentNoList.get(j);
                EventDateBulk[j] = customerNameList.get(j);
                AxQtyInPkt[j] = qtyInPktList.get(j);
                AxRecid[j] = codes3.get(j);
                nameCheckBoxState[j] = nameCheckBoxStateList.get(j);

                AXHybrid[j] = hybridList.get(j);
                AxIndentDate[j] = indentDateList.get(j);
                AXCustAccount[j] = customerCodeList.get(j);

//                checkBoxState3[j] = checkBoxStateCS2.get(j);
//                checkBoxState4[j] = checkBoxStateDS2.get(j);

                approvalCheckBoxState[j] = approvalCheckBoxList.get(j);
                rejectCheckBoxState[j] = rejectCheckBoxList.get(j);


                AxQtyInBag[j] = qtyInBagList.get(j);
                AxQtyInKgs[j] = qtyInKgList.get(j);
                AxQtyInKgs_temp[j] = qtyInKgList.get(j);
                CancelRemarks[j] = CancelRemarkscheck2.get(j);
                item_remarks_String[j] = itemRemarksList.get(j);

            }

            if (Check.equals("chckfile")) {


               /* LayoutInflater inflater = getLayoutInflater();
                ViewGroup header = (ViewGroup) inflater.inflate(R.layout.approveheader, list,
                        false);
                //ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer, list,
                //   false);
                list.addHeaderView(header, null, false);
                // list.addFooterView(footer, null, false); */


                MyListAdapter myListAdapter = new MyListAdapter();
                statusListView.setAdapter(myListAdapter);
                setListViewHeightBasedOnItems(statusListView);


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

                EventBackCheck = "EventBackCheckfile1";

                bnSubmit.setVisibility(View.VISIBLE);
                Linearfirst.setVisibility(View.GONE);
                LinearSeconds.setVisibility(View.GONE);
                statusListView.setVisibility(View.VISIBLE);
                HeaderView.setVisibility(View.VISIBLE);

                Check = "";
                prgDialog.cancel();
            } else {
                Toast.makeText(getApplicationContext(), "No Pending Approve5", Toast.LENGTH_SHORT).show();
                prgDialog.cancel();
                //finish();
                HeaderView.setVisibility(View.GONE);
            }


        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "No Pending Approve4", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            prgDialog.cancel();
            HeaderView.setVisibility(View.GONE);
        }

    }


    public void EveentGetData(View view) {


        if ("Please Select".equals(spSelectedTmCode)) {

            Toast.makeText(getApplicationContext(), "Please Select TM code", Toast.LENGTH_LONG).show();

        } else {


            isConnectionExist = cd.checkMobileInternetConn();
            isConnectionExistMobile = cd.checkMobileInternetConns();

            if (isConnectionExist || isConnectionExistMobile) {


                // getData3();
                GetIndentData();


            } else {

                //Internet connection doesn't exist
                showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
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
    private class RBMIndentStatusListAdapter extends BaseAdapter {

//        private List<SalesIndentStatusUIData> detailsResponseList;

//        public RBMIndentStatusListAdapter(List<SalesIndentStatusUIData> detailsResponseList) {
//            this.detailsResponseList = detailsResponseList;
//        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (statusUiDataList != null && statusUiDataList.size() != 0) {
                return statusUiDataList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return statusUiDataList.get(position);
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
                LayoutInflater inflater = AMIndentApprovalProcess.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.country_remarks, null);

                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
                holder.Qtys = (EditText) convertView.findViewById(R.id.editText51);
                holder.Qtys.setEnabled(false);

                holder.AxcodeID = (TextView) convertView.findViewById(R.id.textView11);
                holder.cbSalesIndent = (CheckBox) convertView.findViewById(R.id.cbSalesIndent);

                holder.AXHybrids = (TextView) convertView.findViewById(R.id.textView15);
                holder.AxIndentDates = (TextView) convertView.findViewById(R.id.textView16);
                holder.AXCustAccounts = (TextView) convertView.findViewById(R.id.textView17);

                holder.APPROVAL = (CheckBox) convertView.findViewById(R.id.checkBox);
                holder.REJECTS = (CheckBox) convertView.findViewById(R.id.checkBox4);


                holder.QtyInBag = (AutoCompleteTextView) convertView.findViewById(R.id.autoCompleteTextView2);
                holder.QtyInBag.setEnabled(false);
                holder.QtyInKgs = (EditText) convertView.findViewById(R.id.etQtyInKgPkts);
                holder.QtyInKgs.setEnabled(false);
                holder.RejectRemarks = (EditText) convertView.findViewById(R.id.editText6);
                holder.RejectRemarks.setEnabled(false);
                holder.item_remarks = convertView.findViewById(R.id.item_remarks);
                holder.item_remarks.setEnabled(false);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;
            SalesIndentStatusUIData uiData = statusUiDataList.get(position);
            holder.code.setText("");
            holder.eventdatas.setText(uiData.getCustomerName());
            holder.cbSalesIndent.setText(uiData.getIndentNo());
            holder.cbSalesIndent.setChecked(uiData.isNameCheckBoxBool());
            holder.Qtys.setText(uiData.getQtyInPkt());
            holder.AxcodeID.setText(uiData.getRecId());

            holder.AXHybrids.setText(uiData.getMaterialName());

            holder.AxIndentDates.setText(uiData.getIndentDate());
            holder.AXCustAccounts.setText(uiData.getCustomerCode());


            holder.QtyInBag.setText(uiData.getQtyInBag());


            holder.QtyInKgs.setText(uiData.getQtyInKg());

            holder.APPROVAL.setChecked(uiData.isApprovalCheckBoxBool());
            holder.REJECTS.setChecked(uiData.isRejectCheckBoxBool());
            holder.RejectRemarks.setText(uiData.getCancelRemarks());

            holder.item_remarks.setText(uiData.getItemRemarks());

            //for managing the state of the boolean
            //array according to the state of the
            //CheckBox

            holder.cbSalesIndent.setOnClickListener(v -> {
                if (((CheckBox) v).isChecked()) {
                    statusUiDataList.get(holder.ref).setNameCheckBoxBool(true);
//                        nameCheckBoxState[holder.ref] = true;
                    holder.Qtys.setEnabled(true);
                    holder.Qtys.setFocusable(true);
                    holder.QtyInKgs.setEnabled(true);
                    holder.QtyInKgs.setFocusable(true);

                } else {
                    statusUiDataList.get(holder.ref).setNameCheckBoxBool(false);
//                        nameCheckBoxState[holder.ref] = false;
                    holder.Qtys.setEnabled(false);
                    holder.QtyInKgs.setEnabled(false);
                    // holder.QtyInBag.setText("");
                }

            });


            holder.cbSalesIndent.addTextChangedListener(new TextWatcher() {

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


            holder.APPROVAL.setOnClickListener(v -> {


                if (((CheckBox) v).isChecked()) {
//                        approvalCheckBoxState[holder.ref] = true;
//                        rejectCheckBoxState[holder.ref] = false;

                    statusUiDataList.get(holder.ref).setApprovalCheckBoxBool(true);
                    statusUiDataList.get(holder.ref).setRejectCheckBoxBool(false);

                    holder.REJECTS.setChecked(false);
                    holder.RejectRemarks.setEnabled(false);
                    holder.RejectRemarks.setText("");

                } else {
//                        approvalCheckBoxState[holder.ref] = false;
//                        rejectCheckBoxState[holder.ref] = true;

                    statusUiDataList.get(holder.ref).setApprovalCheckBoxBool(false);
                    statusUiDataList.get(holder.ref).setRejectCheckBoxBool(true);

                    holder.APPROVAL.setChecked(true);
                    holder.RejectRemarks.setEnabled(false);
                    holder.RejectRemarks.setText("");
                }

            });


            holder.REJECTS.setOnClickListener(v -> {
                if (((CheckBox) v).isChecked()) {
//                        rejectCheckBoxState[holder.ref] = true;
//                        approvalCheckBoxState[holder.ref] = false;

                    statusUiDataList.get(holder.ref).setApprovalCheckBoxBool(false);
                    statusUiDataList.get(holder.ref).setRejectCheckBoxBool(true);


                    holder.APPROVAL.setChecked(false);
                    holder.RejectRemarks.setEnabled(true);
                    holder.QtyInBag.setFocusable(true);
                } else {
//                        rejectCheckBoxState[holder.ref] = false;
//                        approvalCheckBoxState[holder.ref] = true;

                    statusUiDataList.get(holder.ref).setApprovalCheckBoxBool(true);
                    statusUiDataList.get(holder.ref).setRejectCheckBoxBool(false);

                    holder.REJECTS.setChecked(true);
                    holder.RejectRemarks.setEnabled(true);
                    holder.RejectRemarks.setText("");
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


            holder.QtyInKgs.addTextChangedListener(new TextWatcher() {

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
                public void afterTextChanged(final Editable arg0) {
                    // TODO Auto-generated method stub

                    final double[] qty2 = {0};

//                    AxQtyInPkt[holder.ref] = arg0.toString();
//                    AxQtyInKgs[holder.ref] = arg0.toString();

                    statusUiDataList.get(holder.ref).setQtyInPkt(arg0.toString());
                    statusUiDataList.get(holder.ref).setQtyInKg(arg0.toString());


                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        try {
                            qty2[0] = Double.parseDouble(arg0.toString());
                        } catch (Exception e) {
                            Log.e("RBM", "error " + e.toString());
                        }

                        if (statusUiDataList.get(holder.ref).getBaseUOM().equalsIgnoreCase("PAK")) {
                            if (!calculateQuantityInKg(qty2[0], statusUiDataList.get(holder.ref).getPackingQuantity())) {
                                holder.QtyInKgs.setError("Wrong Quantity");
                                bnSubmit.setEnabled(false);
//                                Toast.makeText(getApplicationContext(), "Please enter correct qty in count of "+int_size+int_type, Toast.LENGTH_SHORT).show();
                            } else {
                                bnSubmit.setEnabled(true);
                            }

                        } else if (statusUiDataList.get(holder.ref).getBaseUOM().equalsIgnoreCase("KG")) {
                            if (!calculateQuantityInKg(qty2[0], statusUiDataList.get(holder.ref).getPackingQuantity())) {
                                holder.QtyInKgs.setError("No decimals were allowed");
                                bnSubmit.setEnabled(false);
//                                Toast.makeText(getApplicationContext(), "Please enter correct qty in count of "+int_size+int_type, Toast.LENGTH_SHORT).show();
                            } else {
                                bnSubmit.setEnabled(true);
                            }
                        }


                    }, 500);

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

            holder.RejectRemarks.addTextChangedListener(new TextWatcher() {

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


//                    CancelRemarks[holder.ref] = arg0.toString();
//                    item_remarks_String[holder.ref] = arg0.toString();

                    statusUiDataList.get(holder.ref).setCancelRemarks(arg0.toString());
                    statusUiDataList.get(holder.ref).setItemRemarks(arg0.toString());


                }
            });


            return convertView;
        }


        private boolean calculateQuantityInKg(double qty, String sPackingQuantity) {
            if (!sPackingQuantity.equals("") && !sPackingQuantity.equals("0")) {
                try {
                    int pkgQtyInGram = (int) (Double.parseDouble(sPackingQuantity) * 1000);

                    Log.d("pkgQtyInGram", pkgQtyInGram + "");

                    int etQtyInGram = (int) (qty * 1000);

                    Log.d("etQtyInGram", etQtyInGram + "");


                    if (etQtyInGram % pkgQtyInGram == 0) {
                        return true;
                    } else {
                        return false;
                    }


                } catch (NumberFormatException e) {
                    return false;
                }


            }

            return false;
        }


        private boolean calc(double qty2, String pkgSize2) {
//        String[] pkg = pkgSize2.split("-");
            //  String[] size = pkg[1].trim().split("\\s+");
//        try {
//
//        }catch (Exception e){
//            return false;
//        }


            String[] pkg = pkgSize2.split("-");


            String[] size = pkg[1].trim().split("\\s+");
//            Log.d("Calculations","--------size-------------"+ Arrays.toString(size));
            try {
                int_size = Integer.parseInt(size[0]);
            } catch (Exception e) {
                int_size = Float.parseFloat(size[0]);
            }

//            try {
//                int_size = (int)qty2;
//            } catch (NumberFormatException e)
//            {
//                int_size = (int)qty2;
//
//            }

            if (size[1].contains("K") || size[1].contains("k")) {
                int_type = " Kgs";
                if ((qty2 - (int) qty2) != 0) {
                    float result = (float) (qty2) % int_size;
                    Log.d("kksooowoqqqqtyyyyyy", "-------" + result);

                    if (result == 0) {
                        return true;
                    } else {
                        return false;

                    }
                } else {
                    float result = (float) (qty2) % int_size;

                    if (result == 0) {
                        return true;
                    }
                }
            } else if (size[1].contains("Gm") || size[1].contains("gm") || size[1].contains("g")) {
                if (size[1].contains("K") || size[1].contains("k")) {
                    int_type = " Kgs";
                    if ((qty2 - (int) qty2) != 0) {
                        float result = (float) (qty2) % int_size;
                        Log.d("kksooowoqqqqtyyyyyy", "-------" + result);

                        if (result == 0) {
                            return true;
                        } else {
                            return false;

                        }
                    } else {
                        float result = (float) (qty2) % int_size;

                        if (result == 0) {
                            return true;
                        }
                    }
                } else {
                    int_type = " gms";
                    // int_size = Integer.parseInt(weightinkgorgms);
                    float gm_value = int_size;

                    Log.d("knksjndksdksds", "-----gmm----" + gm_value);

                    Log.d("knksjndksdksds", "-----qty-----" + (float) qty2);

                    float adc = (float) qty2 * 1000;
                    float result = adc % gm_value;
                    float result2 = adc % gm_value;


                    Log.d("knksjndksdksds", "-----res-----" + result);
                    Log.d("knksjndksdksds", "-----res2-----" + result2);


                    if (result == 0) {
                        return true;
                    } else {
                        return false;
                    }
//            double result =delta(qty2 ,gm_value);
//            if((result-(int)result)!=0) {
//                return false;
//            }else {
//                return true;
//            }
                }

            } else {
                int_type = " Kgs";

                if ((qty2 - (int) qty2) != 0) {
                    return false;
                } else {
                    return true;

                }
            }
            return false;
        }

        public double delta(double d1, double d2) {
//        return Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
            return Math.abs(d1) / Math.abs(d2);
        }

        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox cbSalesIndent;
            EditText Qtys;
            AutoCompleteTextView QtyInBag;
            EditText QtyInKgs;
            TextView AxcodeID;

            TextView AXHybrids;
            TextView AxIndentDates;
            TextView AXCustAccounts;
            CheckBox APPROVAL;
            CheckBox REJECTS;
            EditText RejectRemarks;

            TextView item_remarks;

            int ref;
        }

    }

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
                LayoutInflater inflater = AMIndentApprovalProcess.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.country_remarks, null);

                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
                holder.Qtys = (EditText) convertView.findViewById(R.id.editText51);
                holder.Qtys.setEnabled(false);

                holder.AxcodeID = (TextView) convertView.findViewById(R.id.textView11);
                holder.cbSalesIndent = (CheckBox) convertView.findViewById(R.id.cbSalesIndent);

                holder.AXHybrids = (TextView) convertView.findViewById(R.id.textView15);
                holder.AxIndentDates = (TextView) convertView.findViewById(R.id.textView16);
                holder.AXCustAccounts = (TextView) convertView.findViewById(R.id.textView17);

                holder.APPROVAL = (CheckBox) convertView.findViewById(R.id.checkBox);
                holder.REJECTS = (CheckBox) convertView.findViewById(R.id.checkBox4);


                holder.QtyInBag = (AutoCompleteTextView) convertView.findViewById(R.id.autoCompleteTextView2);
                holder.QtyInBag.setEnabled(false);
                holder.QtyInKgs = (EditText) convertView.findViewById(R.id.etQtyInKgPkts);
                holder.QtyInKgs.setEnabled(false);
                holder.RejectRemarks = (EditText) convertView.findViewById(R.id.editText6);
                holder.RejectRemarks.setEnabled(false);
                holder.item_remarks = convertView.findViewById(R.id.item_remarks);
                holder.item_remarks.setEnabled(false);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;

            holder.code.setText("");
            holder.eventdatas.setText(EventDateBulk[position]);
            holder.cbSalesIndent.setText(IndentCodeBulk[position]);
            holder.cbSalesIndent.setChecked(nameCheckBoxState[position]);
            holder.Qtys.setText(AxQtyInPkt[position]);
            holder.AxcodeID.setText(AxRecid[position]);

            holder.AXHybrids.setText(AXHybrid[position]);


            holder.AxIndentDates.setText(AxIndentDate[position]);
            holder.AXCustAccounts.setText(AXCustAccount[position]);


            holder.QtyInBag.setText(AxQtyInBag[position]);


            holder.QtyInKgs.setText(AxQtyInKgs[position]);

            holder.APPROVAL.setChecked(approvalCheckBoxState[position]);
            holder.REJECTS.setChecked(rejectCheckBoxState[position]);
            holder.RejectRemarks.setText(CancelRemarks[position]);

            holder.item_remarks.setText(item_remarks_String[position]);

            //for managing the state of the boolean
            //array according to the state of the
            //CheckBox

            holder.cbSalesIndent.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        nameCheckBoxState[holder.ref] = true;
                        holder.Qtys.setEnabled(true);
                        holder.Qtys.setFocusable(true);
                        holder.QtyInKgs.setEnabled(true);
                        holder.QtyInKgs.setFocusable(true);

                    } else {
                        nameCheckBoxState[holder.ref] = false;
                        holder.Qtys.setEnabled(false);
                        holder.QtyInKgs.setEnabled(false);
                        // holder.QtyInBag.setText("");
                    }

                }
            });


            holder.cbSalesIndent.addTextChangedListener(new TextWatcher() {

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


            holder.APPROVAL.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {


                    if (((CheckBox) v).isChecked()) {
                        approvalCheckBoxState[holder.ref] = true;
                        rejectCheckBoxState[holder.ref] = false;
                        holder.REJECTS.setChecked(false);
                        holder.RejectRemarks.setEnabled(false);
                        holder.RejectRemarks.setText("");

                    } else {
                        approvalCheckBoxState[holder.ref] = false;
                        rejectCheckBoxState[holder.ref] = true;
                        holder.APPROVAL.setChecked(true);
                        holder.RejectRemarks.setEnabled(false);
                        holder.RejectRemarks.setText("");
                    }

                }
            });


            holder.REJECTS.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        rejectCheckBoxState[holder.ref] = true;
                        approvalCheckBoxState[holder.ref] = false;
                        holder.APPROVAL.setChecked(false);
                        holder.RejectRemarks.setEnabled(true);
                        holder.QtyInBag.setFocusable(true);
                    } else {
                        rejectCheckBoxState[holder.ref] = false;
                        approvalCheckBoxState[holder.ref] = true;
                        holder.REJECTS.setChecked(true);
                        holder.RejectRemarks.setEnabled(true);
                        holder.RejectRemarks.setText("");
                    }

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


            holder.QtyInKgs.addTextChangedListener(new TextWatcher() {

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
                public void afterTextChanged(final Editable arg0) {
                    // TODO Auto-generated method stub

                    final double[] qty2 = {0};

                    AxQtyInPkt[holder.ref] = arg0.toString();
                    AxQtyInKgs[holder.ref] = arg0.toString();


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            try {
                                qty2[0] = Double.parseDouble(arg0.toString());
                            } catch (Exception e) {
                                Log.e("RBM", "error " + e.toString());
                            }

                            if (!calc(qty2[0], AxQtyInBag[holder.ref])) {
                                holder.QtyInKgs.setError("Wrong Quantity");
                                bnSubmit.setEnabled(false);
//                                Toast.makeText(getApplicationContext(), "Please enter correct qty in count of "+int_size+int_type, Toast.LENGTH_SHORT).show();
                            } else {
                                bnSubmit.setEnabled(true);
                            }
                        }
                    }, 500);

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

            holder.RejectRemarks.addTextChangedListener(new TextWatcher() {

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
                    item_remarks_String[holder.ref] = arg0.toString();


                }
            });


//            holder.Qtys.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                    // TODO Auto-generated method stub
//
//
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                              int arg3) {
//                    // TODO Auto-generated method stub
//
//                    // IndentCodeBulk[holder.ref] = arg0.toString();
//
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable arg0) {
//                    // TODO Auto-generated method stub
//
//                    AxQtyInBag[holder.ref] = arg0.toString();
//                    RecIdCheck = AxRecid[holder.ref];
//                    IndentCodeBulkEditText = IndentCodeBulk[holder.ref];
//
//                    GetUOMMaster();
//
//
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        public void run() {
//
//                            if (holder.Qtys.getText().toString().trim().length() > 0) {
//
//                                SalQtyKgs = Double.parseDouble(holder.Qtys.getText().toString()) * StdWeight * ConFactor;
//
//                                DecimalFormat precision1 = new DecimalFormat("0.00");
//                                holder.QtyInKgs.setText(precision1.format(SalQtyKgs));
//                                // QtyInKgs.setText(String.valueOf(SalQtyKgs));
//
//                            } else {
//
//                                holder.QtyInKgs.setText("");
//
//                            }
//                            // Actions to do after 10 seconds
//                        }
//                    }, 1000);
//
//                }
//
//            });


            return convertView;
        }

//        private boolean calc(double qty2, String pkgSize2) {
//            String[] pkg = pkgSize2.split("-");
//            String[] size = pkg[1].trim().split("\\s+");
//            try {
//                int_size = Integer.parseInt(size[0]);
//            }catch (Exception e){
//                return false;
//            }
//
//            if (size[1].contains("Kgs") || size[1].contains("Kg")){
//                int_type = " Kgs";
//                if((qty2-(int)qty2)!=0) {
//                    return false;
//                }else {
//                    int result =(int) (qty2) % int_size;
//                    if (result == 0){
//                        return true;
//                    }
//                }
//            }else {
//                int_type = " gms";
//                double gm_value = Double.parseDouble(int_size+"")/1000;
//                double result =delta(qty2 ,gm_value);
//                if((result-(int)result)!=0) {
//                    return false;
//                }else {
//                    return true;
//                }
//            }
//            return false;
//        }


        private boolean calc(double qty2, String pkgSize2) {
//        String[] pkg = pkgSize2.split("-");
            //  String[] size = pkg[1].trim().split("\\s+");
//        try {
//
//        }catch (Exception e){
//            return false;
//        }


            String[] pkg = pkgSize2.split("-");


            String[] size = pkg[1].trim().split("\\s+");
//            Log.d("Calculations","--------size-------------"+ Arrays.toString(size));
            try {
                int_size = Integer.parseInt(size[0]);
            } catch (Exception e) {
                int_size = Float.parseFloat(size[0]);
            }

//            try {
//                int_size = (int)qty2;
//            } catch (NumberFormatException e)
//            {
//                int_size = (int)qty2;
//
//            }

            if (size[1].contains("K") || size[1].contains("k")) {
                int_type = " Kgs";
                if ((qty2 - (int) qty2) != 0) {
                    float result = (float) (qty2) % int_size;
                    Log.d("kksooowoqqqqtyyyyyy", "-------" + result);

                    if (result == 0) {
                        return true;
                    } else {
                        return false;

                    }
                } else {
                    float result = (float) (qty2) % int_size;

                    if (result == 0) {
                        return true;
                    }
                }
            } else if (size[1].contains("Gm") || size[1].contains("gm") || size[1].contains("g")) {
                if (size[1].contains("K") || size[1].contains("k")) {
                    int_type = " Kgs";
                    if ((qty2 - (int) qty2) != 0) {
                        float result = (float) (qty2) % int_size;
                        Log.d("kksooowoqqqqtyyyyyy", "-------" + result);

                        if (result == 0) {
                            return true;
                        } else {
                            return false;

                        }
                    } else {
                        float result = (float) (qty2) % int_size;

                        if (result == 0) {
                            return true;
                        }
                    }
                } else {
                    int_type = " gms";
                    // int_size = Integer.parseInt(weightinkgorgms);
                    float gm_value = int_size;

                    Log.d("knksjndksdksds", "-----gmm----" + gm_value);

                    Log.d("knksjndksdksds", "-----qty-----" + (float) qty2);

                    float adc = (float) qty2 * 1000;
                    float result = adc % gm_value;
                    float result2 = adc % gm_value;


                    Log.d("knksjndksdksds", "-----res-----" + result);
                    Log.d("knksjndksdksds", "-----res2-----" + result2);


                    if (result == 0) {
                        return true;
                    } else {
                        return false;
                    }
//            double result =delta(qty2 ,gm_value);
//            if((result-(int)result)!=0) {
//                return false;
//            }else {
//                return true;
//            }
                }

            } else {
                int_type = " Kgs";

                if ((qty2 - (int) qty2) != 0) {
                    return false;
                } else {
                    return true;

                }
            }
            return false;
        }

        public double delta(double d1, double d2) {
//        return Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
            return Math.abs(d1) / Math.abs(d2);
        }

        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox cbSalesIndent;
            EditText Qtys;
            AutoCompleteTextView QtyInBag;
            EditText QtyInKgs;
            TextView AxcodeID;

            TextView AXHybrids;
            TextView AxIndentDates;
            TextView AXCustAccounts;
            CheckBox APPROVAL;
            CheckBox REJECTS;
            EditText RejectRemarks;

            TextView item_remarks;

            int ref;
        }

    }

    private void callApproveRejectRequest(HashMap<String, String> map, int size) {
        Log.d("ApproveRejectRequestMap", map.toString());
        Call<SuccessResponse> call = apiInterface.postApproveRejectRequestByAM(map);
        call.enqueue(new Callback<SuccessResponse>() {
            @Override
            public void onResponse(Call<SuccessResponse> call, Response<SuccessResponse> response) {
                Log.d("ApproveRejectRequestSuccess", response.body().toString());
                if (size == i) {
                    prgDialog.hide();
                    bnSubmit.setEnabled(true);
                    Toast.makeText(AMIndentApprovalProcess.this, "Indent Approve/Reject successfully", Toast.LENGTH_SHORT).show();
                    callIndentNoStatusApi();
                    i = 1;
                } else {
                    i++;
                }
            }

            @Override
            public void onFailure(Call<SuccessResponse> call, Throwable t) {
                i = 1;
                prgDialog.hide();
                call.cancel();
                Log.d("ApproveRejectRequestFailure", t.toString());
            }
        });
    }

    private int i = 1;

    public void saveDataCountCheck(View view) {
        bnSubmit.setEnabled(false);

        IndentBoxStateCheck2.removeAll(IndentBoxStateCheck2);
        RejectBoxStateCheck2.removeAll(RejectBoxStateCheck2);
        RejectRemarkscheck2.removeAll(RejectRemarkscheck2);
        AxQtyInBagCheck2.removeAll(AxQtyInBagCheck2);
        AxQtyInPktCheck2.removeAll(AxQtyInPktCheck2);


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            prgDialog.show();

//            ISIndentBulkApprovalFile.delete();
            double qty = 0.0;


            for (SalesIndentStatusUIData statusUIData : statusUiDataList) {
                try {
                    qty = Double.parseDouble(statusUIData.getQtyInPkt());
                } catch (Exception e) {
                    qty = 0.0;
                }

                if (statusUIData.isNameCheckBoxBool()) {
                    if (statusUIData.getQtyInPkt() != null && !statusUIData.getQtyInPkt().equals("0") && qty != 0.0) {
                        IndentBoxStateCheck2.add(statusUIData.isNameCheckBoxBool());
                        if (statusUIData.getQtyInPkt().trim().length() > 0) {
                            AxQtyInBagCheck2.add(statusUIData.getQtyInBag());

                        }

                        if (statusUIData.isRejectCheckBoxBool()) {
                            RejectBoxStateCheck2.add(statusUIData.isRejectCheckBoxBool());
                        }


                        if (statusUIData.getCancelRemarks().trim().length() > 0) {
                            RejectRemarkscheck2.add(statusUIData.getCancelRemarks().trim());

                        }
                    }


                }
            }


            if (IndentBoxStateCheck2.size() == 0) {
                if (qty == 0.0) {
                    bnSubmit.setEnabled(true);
                    prgDialog.cancel();
                    Toast.makeText(getApplicationContext(), " Please enter correct qty ", Toast.LENGTH_LONG).show();
                } else {
                    bnSubmit.setEnabled(true);
                    Toast.makeText(getApplicationContext(), " Please Select Indent Code ", Toast.LENGTH_LONG).show();
                    prgDialog.cancel();
                }
            } else {

                if (AxQtyInBagCheck2.size() == IndentBoxStateCheck2.size()) {

                    if (RejectRemarkscheck2.size() == RejectBoxStateCheck2.size()) {

//                        for (int j = 0; j < statusUIDataList.size(); j++) {
//                            BulkIndentCodeUpdate = IndentCodeBulk[j];
//                            AxQtyBagCheck = AxQtyInKgs[j];
//                            checkBoxStateCheck = nameCheckBoxState[j];
//                            AXRecidcheck = AxRecid[j];
//
//                            checkBoxStateAP = approvalCheckBoxState[j];
//                            checkBoxStateRET = rejectCheckBoxState[j];
//                            RejectRemarksCheck = CancelRemarks[j];
//
//                            QtyInPkts = AxQtyInPkt[j];
//
//
//                            RejectRemarksCheck = RejectRemarksCheck.replaceAll("[']", "");
//
//
//                            IntentType = "CS";
//
//
//                            if (checkBoxStateAP == true) {
//                                ApproveDataCheck = "APPROVED";
//
//                            } else {
//                                ApproveDataCheck = "REJECTED";
//                                AxQtyBagCheck = AxQtyInKgs_temp[j];
//                                QtyInPkts = AxQtyInKgs_temp[j];
//                            }
//
//
//                            if (BulkIndentCodeUpdate.trim().length() > 0 && QtyInPkts.trim().length() > 0 && checkBoxStateCheck == true) {
//
//
//                                BulkApprovalDataSave();
//
//
//                            }


//                        }


                        prgDialog.show();
                        for (SalesIndentStatusUIData uiData : statusUiDataList) {
                            HashMap<String, String> map = new HashMap<>();
                            if (uiData.isApprovalCheckBoxBool()) {
                                map.put("am_approval_status", "APPROVED");
                            } else if (uiData.isRejectCheckBoxBool()) {
                                map.put("am_approval_status", "REJECTED");
                                map.put("am_remarks", uiData.getCancelRemarks());
                            }

                            map.put("required_quantity_in_kgs", uiData.getQtyInKg());
                            map.put("quantity_in_kgs_or_packets", uiData.getQtyInKg());
                            map.put("no_of_packets_required", uiData.getQtyInPkt());
                            map.put("packing_quantity", uiData.getPackingQuantity());
                            map.put("recID", uiData.getRecId());

                            if(uiData.isNameCheckBoxBool()) {
                                callApproveRejectRequest(map, IndentBoxStateCheck2.size());
                            }
                        }

                    } else {
                        bnSubmit.setEnabled(true);
                        Toast.makeText(getApplicationContext(), " Please Enter Remarks", Toast.LENGTH_LONG).show();
                        prgDialog.cancel();
                    }

                } else {
                    bnSubmit.setEnabled(true);
                    Toast.makeText(getApplicationContext(), " Please Enter QtyInPkt", Toast.LENGTH_LONG).show();

                    prgDialog.cancel();
                }


            }
        } else {
            bnSubmit.setEnabled(true);
            //Internet connection doesn't exist
            showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();
        }


    }


//    public void saveDataCountCheck(View view) {
//        bnSubmit.setEnabled(false);
//
//        IndentBoxStateCheck2.removeAll(IndentBoxStateCheck2);
//        RejectBoxStateCheck2.removeAll(RejectBoxStateCheck2);
//        RejectRemarkscheck2.removeAll(RejectRemarkscheck2);
//        AxQtyInBagCheck2.removeAll(AxQtyInBagCheck2);
//        AxQtyInPktCheck2.removeAll(AxQtyInPktCheck2);
//
//
//        isConnectionExist = cd.checkMobileInternetConn();
//        isConnectionExistMobile = cd.checkMobileInternetConns();
//
//        if (isConnectionExist || isConnectionExistMobile) {
//
//            prgDialog.show();
//
//            ISIndentBulkApprovalFile.delete();
//            double qty = 0.0;
//            for (int j = 0; j < IndentCodeBulk.length; j++) {
//
//
//                boolean nameCheckBox = nameCheckBoxState[j];
//                boolean rejectCheckBox = rejectCheckBoxState[j];
//                String CancelRemarkscheck = CancelRemarks[j];
//                String AxQtyInBagcheck = AxQtyInKgs[j];
//                String AxQtyInPktcheck = AxQtyInPkt[j];
//                try {
//                    qty = Double.parseDouble(AxQtyInKgs[j]);
//                } catch (Exception e) {
//                    qty = 0.0;
//                }
//
//                if (nameCheckBox == true) {
//                    if (!AxQtyInBagcheck.equals("0") && qty != 0.0) {
//                        IndentBoxStateCheck2.add(nameCheckBox);
//
//                        if (AxQtyInBagcheck.trim().length() > 0) {
//                            AxQtyInBagCheck2.add(AxQtyInBagcheck);
//
//                        }
//
//
//                        if (rejectCheckBox == true) {
//                            RejectBoxStateCheck2.add(rejectCheckBox);
//
//                        }
//
//
//                        if (CancelRemarkscheck.trim().length() > 0) {
//                            RejectRemarkscheck2.add(CancelRemarkscheck);
//
//                        }
//                    }
//
//
//                }
//
//
//            }
//
//
//            if (IndentBoxStateCheck2.size() == 0) {
//                if (qty == 0.0) {
//                    bnSubmit.setEnabled(true);
//                    prgDialog.cancel();
//                    Toast.makeText(getApplicationContext(), " Please enter correct qty ", Toast.LENGTH_LONG).show();
//                } else {
//                    bnSubmit.setEnabled(true);
//                    Toast.makeText(getApplicationContext(), " Please Select Indent Code ", Toast.LENGTH_LONG).show();
//                    prgDialog.cancel();
//                }
//            } else {
//
//                if (AxQtyInBagCheck2.size() == IndentBoxStateCheck2.size()) {
//
//
//                    if (RejectRemarkscheck2.size() == RejectBoxStateCheck2.size()) {
//
//                        savedata();
//
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            public void run() {
//
//                                BulkApprovalDataSaveNew();
//
//
//                            }
//                        }, 2000);
//
//                    } else {
//                        bnSubmit.setEnabled(true);
//                        Toast.makeText(getApplicationContext(), " Please Enter Remarks", Toast.LENGTH_LONG).show();
//                        prgDialog.cancel();
//                    }
//
//                } else {
//                    bnSubmit.setEnabled(true);
//                    Toast.makeText(getApplicationContext(), " Please Enter QtyInPkt", Toast.LENGTH_LONG).show();
//
//                    prgDialog.cancel();
//                }
//
//
//            }
//        } else {
//            bnSubmit.setEnabled(true);
//            //Internet connection doesn't exist
//            showAlertDialogError(RBMIndentApprovalProcess.this, "No Internet Connection",
//                    "Your device doesn't have WIFI or Data Plan internet access", false);
//            prgDialog.cancel();
//        }
//
//
//    }


    private void savedata() {


        DeleteSalesIndentApprove();
        createTableSalesIndentApprove();


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

//            ISIndentBulkApprovalFile.delete();
            IntentType = "";

            for (int j = 0; j < IndentCodeBulk.length; j++) {


                BulkIndentCodeUpdate = IndentCodeBulk[j];
                AxQtyBagCheck = AxQtyInKgs[j];
                checkBoxStateCheck = nameCheckBoxState[j];
                AXRecidcheck = AxRecid[j];

                checkBoxStateAP = approvalCheckBoxState[j];
                checkBoxStateRET = rejectCheckBoxState[j];
                RejectRemarksCheck = CancelRemarks[j];

                QtyInPkts = AxQtyInPkt[j];


                RejectRemarksCheck = RejectRemarksCheck.replaceAll("[']", "");


                IntentType = "CS";


                if (checkBoxStateAP == true) {
                    ApproveDataCheck = "Approve";

                } else {
                    ApproveDataCheck = "Reject";
                    AxQtyBagCheck = AxQtyInKgs_temp[j];
                    QtyInPkts = AxQtyInKgs_temp[j];
                }


                if (BulkIndentCodeUpdate.trim().length() > 0 && QtyInPkts.trim().length() > 0 && checkBoxStateCheck == true) {


                    BulkApprovalDataSave();


                }


            }


        } else {

            //Internet connection doesn't exist
            showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }


    }


    private void BulkApprovalDataSave() {


        String query = "INSERT INTO SalesIndentApprove (IndentNo,AXRecID,AXQty,IndentTypes,ApproveType,RejectRemarks,AXQtyInPkt ) VALUES('" + BulkIndentCodeUpdate + "','" + AXRecidcheck + "','" + AxQtyBagCheck + "','" + IntentType + "','" + ApproveDataCheck + "','" + RejectRemarksCheck + "','" + QtyInPkts + "');";

        dbSalesIndent.execSQL(query);


    }


    private void BulkApprovalDataSaveNew() {

        fisttimecount = true;
        totalcount = 0;
        //linecheckPoevent = 1;

        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {

            prgDialog.show();


            if (isTableExists(dbSalesIndent, "SalesIndentApprove")) {


                if (fisttimecount.equals(true)) {


                    cScanDetails = dbSalesIndent.rawQuery("select MAX(id) from SalesIndentApprove ", null);


                    if (cScanDetails.moveToFirst()) {

                        do {


                            totalcount = Integer.parseInt(cScanDetails.getString(0));


                        } while (cScanDetails.moveToNext());

                    }

                    // closing connection
                    //  c.close();
                    // db.close();


                    fisttimecount = false;

                    BulkApprovalDataSaveNewSyn();


                } else {

                    if (Syncomplete.equals(false)) {
                        Toast.makeText(getApplicationContext(), " Already Syn completed ", Toast.LENGTH_LONG).show();
                        prgDialog.cancel();
                    } else {

                        Toast.makeText(getApplicationContext(), " Syn in progress", Toast.LENGTH_LONG).show();
                        prgDialog.cancel();
                    }
                }


            } else {

                //Toast.makeText(getApplicationContext(), " No Data Available ", Toast.LENGTH_LONG).show();
                Check = "Checkfile".toString();

                prgDialog.cancel();
            }

        } else {
            {

                // Internet connection doesn't exist
                showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.cancel();

            }

        }
    }


    private void BulkApprovalDataSaveNewSyn() {


        List<String> codes = new ArrayList<String>();

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();
        // check for Internet status
        if (isConnectionExist || isConnectionExistMobile) {


            int lineNumber = 1;

            if (isTableExists(dbSalesIndent, "SalesIndentApprove")) {

                cScanDetails = dbSalesIndent.rawQuery("select * from SalesIndentApprove ", null);


                if (cScanDetails.moveToFirst()) {


                    do {

                        if (lineNumber == linecheck) {


                            ApprovalDataSyn = cScanDetails.getString(1).toString();
                            AXRecidupdate = cScanDetails.getString(2).toString();
                            AxQtyUpdate = cScanDetails.getString(3).toString();
                            AxIndentTypes = cScanDetails.getString(4).toString();
                            AxApproveRejectType = cScanDetails.getString(5).toString();
                            AxRejectRemarksChecks = cScanDetails.getString(6).toString();
                            QtyInPktsChecks = cScanDetails.getString(7).toString();

                            RecIdCheck = AXRecidupdate;

                            // if(AxRejectRemarksChecks.trim().length()>0 )
                            //  {
                            EventDataApprovalUpdate();

                            // }


                        }

                        lineNumber = lineNumber + 1;

                    } while (cScanDetails.moveToNext());


                }

            }


        } else {


            // Internet connection doesn't exist
            showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


            Toast.makeText(getApplicationContext(), "Synchronization Not Completed", Toast.LENGTH_LONG).show();

            prgDialog.cancel();
            fisttimecount = true;
            totalcount = 0;
        }

    }


    private void EventDataApprovalUpdate() {


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {


            String IndentCode1 = ApprovalDataSyn.toString();

            String AXrecid1 = AXRecidupdate.trim().toString();

            String AxQtyUpdate1 = AxQtyUpdate.trim().toString();
            String AxIndentTypes1 = AxIndentTypes.trim().toString();

            String AxApproveRejectType1 = AxApproveRejectType.trim().toString();
            String AxRejectRemarksChecks1 = AxRejectRemarksChecks.trim().toString();

            String QtyInPktsChecks1 = QtyInPktsChecks.trim().toString();
            String Emp_code = POCodeGet;


            //  prgDialog1.show();
            //  prgDialog.show();

            // insertToDatabase2(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);


            insertToDatabase3(IndentCode1, AXrecid1, AxQtyUpdate1, AxIndentTypes1, AxApproveRejectType1, AxRejectRemarksChecks1, QtyInPktsChecks1, Emp_code);


        } else {

            // Internet connection doesn't exist
            showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();

        }
    }

    // private void insertToDatabase2( String EventCode1,String ApType1,String SubActivity1,String PoCodeSpinner2, String VillageNameSpineer2,String Date2,String SupportingPo2, String Remark2,String PoState2,String PoRegion2, String POTerritory2){

    private void insertToDatabase3(String IndentCode1, String AXrecid1, String AxQtyUpdate1, String AxIndentTypes1, String AxApproveRejectType1, String AxRejectRemarksChecks1, String QtyInPktsChecks1, final String Emp_code) {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {
            class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
                @Override
                protected String doInBackground(String... params) {
                    String paramUsername = params[0];
                    String paramAddress = params[1];


                    String IndentCode1 = ApprovalDataSyn.toString();

                    String AXrecid1 = AXRecidupdate.trim().toString();
                    String AxQtyUpdate1 = AxQtyUpdate.trim().toString();
                    String AxIndentTypes1 = AxIndentTypes.trim().toString();

                    String AxApproveRejectType1 = AxApproveRejectType.trim().toString();
                    String AxRejectRemarksChecks1 = AxRejectRemarksChecks.trim().toString();
                    String QtyInPktsChecks1 = QtyInPktsChecks.trim().toString();

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                    nameValuePairs.add(new BasicNameValuePair("EmpCode", Emp_code));
                    nameValuePairs.add(new BasicNameValuePair("IndentNo", IndentCode1));
                    nameValuePairs.add(new BasicNameValuePair("AXRecID", AXrecid1.trim().toString()));
                    nameValuePairs.add(new BasicNameValuePair("AXQty", AxQtyUpdate1));
                    nameValuePairs.add(new BasicNameValuePair("IndentTypes", AxIndentTypes1));
                    nameValuePairs.add(new BasicNameValuePair("ApproveType", AxApproveRejectType1));
                    nameValuePairs.add(new BasicNameValuePair("RejectRemarks", AxRejectRemarksChecks1));
//                            nameValuePairs.add(new BasicNameValuePair("QtyInPkt", QtyInPktsChecks1));
                    nameValuePairs.add(new BasicNameValuePair("QtyInKgs", QtyInPktsChecks1));
                    nameValuePairs.add(new BasicNameValuePair("RBM_Name", PONameGet));
                    nameValuePairs.add(new BasicNameValuePair("RegionId", SiteGet));


                    try {
                        HttpClient httpClient = new DefaultHttpClient();

                        // HttpPost httpPost = new HttpPost("http://172.16.3.21/HrDataUpdate.php");

                        HttpPost httpPost = new HttpPost(IPAddress + ProjectFolder + "/ISDataRBMValidate.php?Dcode=" + sessionManager.get_dcode());
//                                HttpPost httpPost = new HttpPost(FinalIPAddress + "/kanagaraj/" + ProjectFolder + "/ISDataRBMValidate.php?Dcode=" + sessionManager.get_dcode());
//                        HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISDataRBMValidate.php?Dcode=" + sessionManager.get_dcode());
//                        HttpPost httpPost = new HttpPost(new_api.ISDataRBMValidate(ProjectFolder ,sessionManager.get_dcode()));
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                        InputStream inputStream = null;
                        String result = null;
                        try {
                            HttpResponse response = httpClient.execute(httpPost);
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
                            prgDialog.show();
                        }

                    } catch (IOException e) {

                    }

                    return "success";

                }


                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);

                    if (totalcount == linecheck) {

                        Toast.makeText(getApplicationContext(), "  Indent Approve/Reject Completed", Toast.LENGTH_LONG).show();
                        bnSubmit.setEnabled(true);

                        prgDialog.cancel();
                        linecheck = 1;
                        totalcount = 0;
                        fisttimecount = true;

                        statusListView.setAdapter(null);
                        prgDialog.cancel();
                        //  finish();
                        getTmRequestData();
                        //  GetIndentData();

                    } else {


                        linecheck = linecheck + 1;

                        BulkApprovalDataSaveNewSyn();
                    }


                }


            }

            isConnectionExist = cd.checkMobileInternetConn();
            isConnectionExistMobile = cd.checkMobileInternetConns();


            if (isConnectionExist || isConnectionExistMobile) {

                SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

                //sendPostReqAsyncTask.execute(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);
                sendPostReqAsyncTask.execute(IndentCode1, AXrecid1, AxQtyUpdate1, AxIndentTypes1, AxApproveRejectType1, AxRejectRemarksChecks1, QtyInPktsChecks1);
            } else {
                // Internet connection doesn't exist
                showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.cancel();

            }

        } else {

            // Internet connection doesn't exist
            showAlertDialogError(AMIndentApprovalProcess.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();

        }
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


    @Override
    public void onBackPressed() {


        if (EventBackCheck.equals("EventBackCheckfile1")) {


            EventBackCheck = "";

            bnSubmit.setVisibility(View.GONE);
            Linearfirst.setVisibility(View.GONE);
            LinearSeconds.setVisibility(View.VISIBLE);
            statusListView.setVisibility(View.GONE);
            EventBackCheck = "EventBackCheckfile2";
            HeaderView.setVisibility(View.GONE);
        } else if (EventBackCheck.equals("EventBackCheckfile2")) {

            EventBackCheck = "";

            bnSubmit.setVisibility(View.GONE);
            Linearfirst.setVisibility(View.VISIBLE);
            LinearSeconds.setVisibility(View.GONE);
            statusListView.setVisibility(View.GONE);
            HeaderView.setVisibility(View.GONE);
        } else {


            finish();
        }
    }


    /**
     * Function to display simple Alert Dialog
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param status  - success/failure (used to set icon)
     */

    public void showAlertDialogError(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting alert dialog icon
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.e3);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }


    public void showAlertDialogWarning(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting alert dialog icon
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.e1);

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

        finish();


       /* Intent intent = new Intent(this, RBMScreenActivity.class);
        intent.putExtra("Po_code", POCodeGet);
        intent.putExtra("Po_name", PONameGet);
        intent.putExtra("Tm_name", TerritoryNameGet);
        intent.putExtra("Post_code", PostCodeTransfer);
        intent.putExtra("Division_code", DivisionGet);
        intent.putExtra("Site_ID", SiteGet);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// This flag ensures all activities on top of the CloseAllViewsDemo are cleared.
        this.startActivity(intent);*/


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


    protected void createDatabaseSalesIndentData() {


        dbSalesIndent = openOrCreateDatabase(SalesIndentPath.getPath(), Context.MODE_PRIVATE, null);


    }


    protected void createTableSalesIndentApprove() {


        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentApprove(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR, AXRecID VARCHAR ,AXQty REAL, IndentTypes VARCHAR,ApproveType VARCHAR,RejectRemarks VARCHAR,AXQtyInPkt REAL);");


    }


    protected void createTableSalesIndentApproveTemp() {

        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentApproveTemp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR, AXRecID VARCHAR ,AXQty REAL, IndentTypes VARCHAR,ApproveType VARCHAR,RejectRemarks VARCHAR,AXQtyInPkt REAL);");

    }

    private void DeleteSalesIndentApprove() {

        String DATABASE_TABLE_SalesIndentSalesIndentApprove = "SalesIndentApprove".toString();

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SalesIndentSalesIndentApprove + "'");


    }


    private void DeleteSalesIndentApproveTemp() {

        String DATABASE_TABLE_SalesIndentDetailsTemp = "SalesIndentApproveTemp".toString();

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

    public void GetPackageID() {
        String check = "";


        List<String> codes11 = new ArrayList<String>();


        if (isTableExists(dbGetmaster, "InventMaster")) {

            // private final String MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";

            // db.rawQuery(MY_QUERY, new String[]{String.valueOf(propertyId)});

            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from InventMaster  where Hybridname='" + HybridName1 + "'", null);


            if (GetCursorOrderDetails.moveToFirst()) {

                do {

                    //  PriceCheckItems1 = GetCursorOrderDetails.getString(6);


                    codes11.add(new String(GetCursorOrderDetails.getString(6)));

                    //   }


                } while (GetCursorOrderDetails.moveToNext());

            }
            // closing connection
            //  c.close();
            // db.close();


        }


        HashSet<String> set11 = new HashSet<>(codes11);

        // Create ArrayList from the set.
        ArrayList<String> result11 = new ArrayList<>(set11);
        //Comparator mycomparator = Collections.reverseOrder();
        //Collections.sort(result,mycomparator);


        Collections.sort(result11);


        List<String> codes311 = new ArrayList<String>();


        codes3.add("Please Select");
        codes311.add("Please Select");


        for (int j = 0; j < result11.size(); j++) {

            String codes211 = result11.get(j);
            codes311.add(codes211);


        }


        // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Product.setAdapter(adapter1);


        Log.d("skdmskmsmdsd", "oksodkwew" + codes3.size());
        Log.d("skdmskmsmdsd", "oksodkwew" + codes3.get(1));
        Log.d("skdmskmsmdsd", "oksodkwew" + codes311.get(1));


        PackagingIDsend = codes3.get(1);


        GetPktSize();
        Log.d("kskdslkdlsdsd", "oiwiwiwiw" + PackagingIDsend);


    }

    public void GetPktSize() {

        String check = "";
        List<String> codes2 = new ArrayList<String>();
//        List<String> codes3 = new ArrayList<String>();
//        List<String> codes4 = new ArrayList<String>();

        if (isTableExists(dbGetmaster, "SeedProcessPackingTable")) {


            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from SeedProcessPackingTable  where PackingId='" + PackagingIDsend + "'", null);

            if (GetCursorOrderDetails.moveToFirst()) {

                do {
                    codes2.add(new String(GetCursorOrderDetails.getString(2)));
                    codes2.add(new String(GetCursorOrderDetails.getString(3)));
                    codes2.add(new String(GetCursorOrderDetails.getString(4)));


                } while (GetCursorOrderDetails.moveToNext());
            }

        }


        UnitIDtosend = codes2.get(1);


    }


}
