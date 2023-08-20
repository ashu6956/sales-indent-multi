package com.agriscience.salesindent.stodbm;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import androidx.appcompat.app.AppCompatActivity;

import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.model.STOIndentDetailsResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
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

import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.STOIndentNoDetailsResponse;
import com.agriscience.salesindent.model.STOIndentNoResponse;
import com.agriscience.salesindent.model.STOIndentResponse;
import com.agriscience.salesindent.model.STOIndentStatusUIData;
import com.agriscience.salesindent.model.STORbmDetailsResponse;
import com.agriscience.salesindent.model.STORbmResponse;
import com.agriscience.salesindent.model.SuccessResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DbmStockApprovalActivity extends AppCompatActivity {

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
    String int_type = " Kgs", old_indent_no = "";


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

    String LocationTimes = "", arec_check;

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


    Spinner ActivityType, SubActivity, spRbmCode, VillageNameSpineer;


    String PoHeadQRs, PoState, PoRegion, POTerritory;

    String spSelectedRbmCode = "";


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


    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";

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


    String BulkIndentCodeUpdate, W_id;


    int linecheck = 1;
    int totalcount = 0;


    CheckBox AllDataApproval;


    String ApprovalDataSyn;


    ArrayList<CountryRemark> countryList = new ArrayList<CountryRemark>();

    private String[] IndentCodeBulk;
    private String[] EventDateBulk;
    private String[] CancelRemarks;
    private String[] AxRecid;


    boolean[] checkBoxState;


    TextView LableName;


    String CancelRemarksSet = "";

    String CancelRemarkscheck;

    String AxQtyBagCheck = "";

    String AXRecidcheck;


    List<String> codes = new ArrayList<String>();
    List<String> codes1 = new ArrayList<String>();
    List<String> codes2 = new ArrayList<String>();
    List<Boolean> checkBoxState1 = new ArrayList<Boolean>();

    List<String> codes3 = new ArrayList<String>();

    private boolean checkBoxStateCheck = false;

    String AXRecidupdate = "";


    List<Boolean> checkBoxStateCheck2 = new ArrayList<Boolean>();


    private boolean checkBoxStateCS = false;
    private boolean checkBoxStateDS = false;

    private boolean checkBoxStateAP = false;
    private boolean checkBoxStateRET = false;


    List<Boolean> checkBoxStateCS2 = new ArrayList<Boolean>();
    List<Boolean> checkBoxStateDS2 = new ArrayList<Boolean>();

    List<Boolean> checkBoxStateAP2 = new ArrayList<Boolean>();
    List<Boolean> checkBoxStateRET2 = new ArrayList<Boolean>();


    boolean[] checkBoxState3;
    boolean[] checkBoxState4;

    boolean[] checkBoxState5;
    boolean[] checkBoxState6;

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


    List<String> codes4 = new ArrayList<String>();
    List<String> codes5 = new ArrayList<String>();
    List<String> codes6 = new ArrayList<String>();
    List<String> codes7 = new ArrayList<String>();
    List<String> codes8 = new ArrayList<String>();
    List<String> codes9 = new ArrayList<String>();
    List<String> codes10 = new ArrayList<String>();
    List<String> codes11 = new ArrayList<String>();
    List<String> codes12 = new ArrayList<String>();
    List<String> codes13 = new ArrayList<String>();

    private String[] AXCustAccount;
    private String[] AXHybrid;
    private String[] AxIndentDate;
    private String[] AxQtyInBag;
    private String[] AxQtyInPkt;
    private String[] AxQtyInKgs;
    private String[] AxPaking;
    private String[] AxDesc;
    private String[] Axrec;
    private String[] AxWHId;
    private String[] item_remarks;


    String DivisionGet = "";
    String ProjectFolder = "";

    ArrayList<String> resultlocation;
    ArrayList<String> resultIndentNo;
    ArrayList<String> resultproject;


    Spinner spIndentNo;
    String spSelectedIndentNo = "";

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

    Double StdWeight = 0.00;
    Double ConFactor = 0.00;

    String QtyInPkts = "";


    String QtyInPktsChecks = "";

    String Acting, DCode;

    ListView lv;
    private AppSharedPreferences appSharedPreferences;
    private ApiInterface apiInterface;


    List<String> hybridList = new ArrayList<String>();
    List<String> indentDateList = new ArrayList<String>();
    List<String> customerCodeList = new ArrayList<String>();
    List<String> qtyInBagList = new ArrayList<String>();
    List<String> qtyInKgList = new ArrayList<String>();

    List<String> indentNoList = new ArrayList<String>();
    List<String> customerNameList = new ArrayList<String>();
    List<String> qtyInPktList = new ArrayList<String>();
    List<Boolean> nameCheckBoxStateList = new ArrayList<Boolean>();


    List<String> CancelRemarkscheck2 = new ArrayList<String>();
    List<String> itemRemarksList = new ArrayList<>();

    List<Boolean> approvalCheckBoxList = new ArrayList<Boolean>();
    List<Boolean> rejectCheckBoxList = new ArrayList<Boolean>();

    private List<STOIndentStatusUIData> statusUiDataList = new ArrayList<>();
    private List<STORbmDetailsResponse> rmDetailsResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockapproval);
        getSupportActionBar().hide();
        appSharedPreferences = new AppSharedPreferences(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        appLocationService = new AppLocationService(DbmStockApprovalActivity.this);

        statusListView = findViewById(R.id.listView);

        spRbmCode = findViewById(R.id.spSTORbm);

        Linearfirst = findViewById(R.id.Linear1);
        LinearSecond = findViewById(R.id.scrollView);
        LinearSeconds = findViewById(R.id.llIndentNo);
        HeaderView = findViewById(R.id.Header);

        bnSubmit = findViewById(R.id.bnSubmit);

        LableName = findViewById(R.id.textView33);

        spIndentNo = findViewById(R.id.spinner3);

        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));
//        createTableSalesIndentApproveTemp();

//        GetRegion();
        callSTORmApi();


        spRbmCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get select item

                String UnitIds2 = spRbmCode.getItemAtPosition(position).toString();
                spSelectedRbmCode = spRbmCode.getSelectedItem().toString();

                String[] separated = spSelectedRbmCode.split("-");
                spSelectedRbmCode = separated[0];

                if ("Please Select".equals(spSelectedRbmCode)) {

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
                spSelectedIndentNo = spIndentNo.getSelectedItem().toString();

                // String[] separated = PoCodeSpinners.split("-");
                // PoCodeSpinners = separated[0];

                if ("Please Select".equals(spSelectedIndentNo)) {

                } else {
                    // IndentActivity( );
//                    getData3();
                    callIndentNoStatusApi();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });
    }

    private void callSTORmApi() {
        prgDialog.show();
        Call<STORbmResponse> call = apiInterface.getAllSTORbmDetails(appSharedPreferences.getUserId());
        call.enqueue(new Callback<STORbmResponse>() {
            @Override
            public void onResponse(Call<STORbmResponse> call, Response<STORbmResponse> response) {
                STORbmResponse tmResponse = response.body();
                prgDialog.hide();
                if (tmResponse.getResult() != null && tmResponse.getResult().size() > 0) {
                    rmDetailsResponseList = tmResponse.getResult();
                    showRmDetailsOnView();
                }
            }

            @Override
            public void onFailure(Call<STORbmResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });
    }

    private void showRmDetailsOnView() {
        List<String> codes = new ArrayList<String>();

        rmDetailsResponseList.stream().forEach(tmDetailsResponse -> {
            codes.add(tmDetailsResponse.getRBM().trim() + " - " + tmDetailsResponse.getRbmName());
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
        spRbmCode.setAdapter(adapter1);
        prgDialog.cancel();
    }


    private void callIndentApi() {

        if (spSelectedRbmCode.equals("ALL")) {
//            FullIPData = IPAddress + ProjectFolder + "/ISIndenNoFetchRBMALL.php?RBMCode=" + POCodeGet + "&Dcode=" + sessionManager.get_dcode();
        } else {
//            FullIPData = IPAddress + ProjectFolder + "/ISIndenNoFetchRBM.php?TMId=" + PoCodeSpinners + "&Dcode=" + sessionManager.get_dcode();
            prgDialog.show();
            Call<STOIndentNoResponse> call = apiInterface.getAllSTOIndentDetails(spSelectedRbmCode);
            call.enqueue(new Callback<STOIndentNoResponse>() {
                @Override
                public void onResponse(Call<STOIndentNoResponse> call, Response<STOIndentNoResponse> response) {
                    STOIndentNoResponse indentNoResponse = response.body();
                    prgDialog.hide();
                    if (indentNoResponse.getResult() != null && indentNoResponse.getResult().size() > 0) {
                        List<STOIndentNoDetailsResponse> detailsResponseList = indentNoResponse.getResult();
                        showIndentNoOnView(detailsResponseList);
                    }


                }

                @Override
                public void onFailure(Call<STOIndentNoResponse> call, Throwable t) {
                    call.cancel();
                    prgDialog.hide();
                }
            });
        }
    }

    private void showIndentNoOnView(List<STOIndentNoDetailsResponse> detailsResponseList) {
        List<String> codes = new ArrayList<String>();

        detailsResponseList.stream().forEach(indentNoDetailsResponse -> {
            codes.add(indentNoDetailsResponse.getSTOIndentNo());
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

    private void callIndentNoStatusApi() {
        prgDialog.show();
        Call<STOIndentResponse> call = apiInterface.getAllSTOIndentDetailsByIndentNoInDBM(spSelectedRbmCode, spSelectedIndentNo);
        call.enqueue(new Callback<STOIndentResponse>() {
            @Override
            public void onResponse(Call<STOIndentResponse> call, Response<STOIndentResponse> response) {
                Log.d("RbmIndentApprovalProcess", response.body().toString());
                prgDialog.hide();
                STOIndentResponse statusResponse = response.body();
                showIndentStatusOnView(statusResponse.getResult());
            }

            @Override
            public void onFailure(Call<STOIndentResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });
    }

    protected void showIndentStatusOnView(List<STOIndentDetailsResponse> responseList) {

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
                STOIndentStatusUIData statusUIData = new STOIndentStatusUIData();
                statusUIData.setIndentNo(detailsResponse.getSTOIndentNo().trim());
                statusUIData.setFromPlant(detailsResponse.getReceivingPlant().trim() + "-" + detailsResponse.getReceivingPlantName().trim());
                statusUIData.setToPlant(detailsResponse.getSendingPlant().trim() + "-" + detailsResponse.getSendingPlantName().trim());
                statusUIData.setItemWeight(detailsResponse.getRbmItemWeight());
                statusUIData.setQty(detailsResponse.getRbmQty());
                statusUIData.setNoOfPackets(detailsResponse.getRbmNoOfPac());
                statusUIData.setRecId(detailsResponse.getRecID());
                statusUIData.setMaterialName(detailsResponse.getMaterialDescription().trim());
                statusUIData.setIndentDate(detailsResponse.getIndentDate().trim());
                statusUIData.setItemRemarks(detailsResponse.getRbmRemarks().trim());
                statusUIData.setReqDate(detailsResponse.getReqDate().trim());
                statusUIData.setCancelRemarks("");
                statusUIData.setIndentCheckBoxBool(false);
                statusUIData.setApprovalCheckBoxBool(true);
                statusUIData.setRejectCheckBoxBool(false);
                statusUIData.setBaseUOM(detailsResponse.getBaseUom());
                statusUIData.setPackingQuantity(detailsResponse.getPackingQuantity());
                statusUiDataList.add(statusUIData);

            });

            if (statusUiDataList.size() > 0) {
                IndentStatusListAdapter myListAdapter = new IndentStatusListAdapter();
                statusListView.setAdapter(myListAdapter);
                setListViewHeightBasedOnItems(statusListView);
                bnSubmit.setVisibility(View.VISIBLE);
                statusListView.setVisibility(View.VISIBLE);
                HeaderView.setVisibility(View.VISIBLE);
            } else {
                bnSubmit.setVisibility(View.GONE);
                statusListView.setVisibility(View.GONE);
                HeaderView.setVisibility(View.GONE);

            }
            Linearfirst.setVisibility(View.GONE);
            LinearSeconds.setVisibility(View.GONE);
            prgDialog.cancel();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No Pending Approve4", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            prgDialog.cancel();
            HeaderView.setVisibility(View.GONE);
        }

    }

    private class IndentStatusListAdapter extends BaseAdapter {

        private class ViewHolder {
            int Ref;
            CheckBox check_indent;
            TextView text_from_ware;
            TextView text_to_ware;
            TextView text_hybrid;
            TextView text_pkg;
            EditText edit_qty;
            TextView text_exp_date;
            CheckBox cbApproval, cbReject;
            EditText rejectRemarks, item_remarks;
        }

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


            ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = DbmStockApprovalActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.stock_listview, null);

                holder.check_indent = convertView.findViewById(R.id.cbSalesIndent);
                holder.text_from_ware = convertView.findViewById(R.id.textView89);
                holder.text_to_ware = convertView.findViewById(R.id.textView15);
                holder.text_hybrid = convertView.findViewById(R.id.textView1);
                holder.edit_qty = convertView.findViewById(R.id.etQtyInKgPkts);
                holder.edit_qty.setEnabled(false);
                holder.text_exp_date = convertView.findViewById(R.id.textView16);
                holder.text_pkg = convertView.findViewById(R.id.textView);
                holder.cbApproval = convertView.findViewById(R.id.checkBox);
                holder.cbReject = convertView.findViewById(R.id.checkBox4);
                holder.rejectRemarks = convertView.findViewById(R.id.editText6);
                holder.item_remarks = convertView.findViewById(R.id.item_remarks);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();

            }
            holder.Ref = position;
            STOIndentStatusUIData uiData = statusUiDataList.get(position);
            holder.check_indent.setText(uiData.getIndentNo());
            holder.text_from_ware.setText(uiData.getFromPlant());
            holder.text_to_ware.setText(uiData.getToPlant());
            holder.text_hybrid.setText(uiData.getMaterialName());
            holder.text_pkg.setText(uiData.getPackingQuantity());
            holder.edit_qty.setText(uiData.getQty());
            holder.text_exp_date.setText(uiData.getReqDate());
            holder.cbApproval.setChecked(uiData.isApprovalCheckBoxBool());
            holder.cbReject.setChecked(uiData.isRejectCheckBoxBool());
            holder.rejectRemarks.setText(uiData.getCancelRemarks());
            holder.item_remarks.setText(uiData.getItemRemarks());
            holder.rejectRemarks.setEnabled(false);
            holder.item_remarks.setEnabled(false);

            holder.check_indent.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
//                        checkBoxState[holder.Ref] = true;
                        statusUiDataList.get(holder.Ref).setIndentCheckBoxBool(true);
                        holder.edit_qty.setEnabled(true);
                        holder.edit_qty.setFocusable(true);

                    } else {
//                        checkBoxState[holder.Ref] = false;
                        statusUiDataList.get(holder.Ref).setIndentCheckBoxBool(false);
                        holder.edit_qty.setEnabled(false);
                        holder.edit_qty.setEnabled(false);
                        // holder.QtyInBag.setText("");
                    }

                }
            });


            holder.cbApproval.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {


                    if (((CheckBox) v).isChecked()) {
//                        checkBoxState5[holder.Ref] = true;
//                        checkBoxState6[holder.Ref] = false;
//                        holder.cbReject.setChecked(false);
//                        holder.rejectRemarks.setEnabled(false);
//                        holder.rejectRemarks.setText("");

                        statusUiDataList.get(holder.Ref).setApprovalCheckBoxBool(true);
                        statusUiDataList.get(holder.Ref).setRejectCheckBoxBool(false);

                        holder.cbReject.setChecked(false);
                        holder.rejectRemarks.setEnabled(false);
                        holder.rejectRemarks.setText("");


                    } else {
                        statusUiDataList.get(holder.Ref).setApprovalCheckBoxBool(false);
                        statusUiDataList.get(holder.Ref).setRejectCheckBoxBool(true);

                        holder.cbApproval.setChecked(true);
                        holder.rejectRemarks.setEnabled(false);
                        holder.rejectRemarks.setText("");

                    }

                }
            });


            holder.cbReject.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
//                        checkBoxState6[holder.Ref] = true;
//                        checkBoxState5[holder.Ref] = false;
//                        holder.cbApproval.setChecked(false);
//                        holder.rejectRemarks.setEnabled(true);
//                        holder.edit_qty.setFocusable(true);

                        statusUiDataList.get(holder.Ref).setRejectCheckBoxBool(true);
                        statusUiDataList.get(holder.Ref).setApprovalCheckBoxBool(false);
                        holder.cbApproval.setChecked(false);
                        holder.rejectRemarks.setEnabled(true);
                        holder.edit_qty.setFocusable(true);

                    } else {
//                        checkBoxState6[holder.Ref] = false;
//                        checkBoxState5[holder.Ref] = true;
//                        holder.cbReject.setChecked(true);
//                        holder.rejectRemarks.setEnabled(true);
//                        holder.rejectRemarks.setText("");

                        statusUiDataList.get(holder.Ref).setApprovalCheckBoxBool(true);
                        statusUiDataList.get(holder.Ref).setRejectCheckBoxBool(false);

                        holder.cbReject.setChecked(true);
                        holder.rejectRemarks.setEnabled(true);
                        holder.rejectRemarks.setText("");
                    }

                }
            });
            holder.rejectRemarks.addTextChangedListener(new TextWatcher() {

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


//                    CancelRemarks[holder.Ref] = arg0.toString();


                    statusUiDataList.get(holder.Ref).setCancelRemarks(arg0.toString());
//                    statusUiDataList.get(holder.Ref).setItemRemarks(arg0.toString());


                }
            });

            holder.edit_qty.addTextChangedListener(new TextWatcher() {

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


//                    AxQtyInBag[holder.Ref] = arg0.toString();
                    final double[] qty2 = {0};

                    String sQty = arg0.toString();
                    try {
                        if (sQty != null && !sQty.equals("")) {
                            double dQty = Double.parseDouble(sQty);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                STOIndentStatusUIData statusUIData = statusUiDataList.get(holder.Ref);
                                if (!statusUIData.getBaseUOM().isEmpty()) {
                                    if (statusUIData.getBaseUOM().equalsIgnoreCase("KG") && calculateQuantityInKg(dQty, statusUIData.getPackingQuantity())) {
                                        if (sQty.trim().length() > 0) {
                                            calculateItemWeight(sQty, statusUiDataList.get(holder.Ref));
                                        } else {
                                            holder.edit_qty.setError("Wrong input Quantity entered");
                                            Toast.makeText(getApplicationContext(), "Wrong input Quantity entered", Toast.LENGTH_LONG).show();

                                        }
                                    } else if (statusUIData.getBaseUOM().equalsIgnoreCase("PAK") || statusUIData.getBaseUOM().equalsIgnoreCase("EA")) {
                                        if (sQty.trim().length() > 0 && !sQty.contains(".")) {
                                            calculateItemWeight(sQty, statusUiDataList.get(holder.Ref));
                                        } else {
                                            holder.edit_qty.setError("Enter quantity in Number’s no decimals were allowed");
                                            Toast.makeText(getApplicationContext(), "You can not enter decimal number", Toast.LENGTH_LONG).show();
                                        }

                                    }
                                }

                            }, 500);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });


            return convertView;
        }

        private boolean calculateQuantityInKg(double qty, String sPackingQuantity) {
            if (!sPackingQuantity.equals("")) {
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


    }


    private void GetRegion() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {
            prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

//                    HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ ProjectFolder + "/RegionFetchs.php?DBMCode=" + POCodeGet);
                    HttpPost httppost = new HttpPost(IPAddress + ProjectFolder + "/RegionFetchs.php?DBMCode=" + POCodeGet);
//                    HttpPost httppost = new HttpPost(FinalIPAddress + "/kanagaraj/" + ProjectFolder + "/RegionFetchs.php?DBMCode=" + POCodeGet);
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

                    if (result != null) {
                        try {
                            Log.e(TAG_RESULTS, "resultssss " + result);
                            showList1();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(DbmStockApprovalActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();

                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();

        } else {
            // Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
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
                spRbmCode.setAdapter(adapter1);
                prgDialog.cancel();
            }

        } catch (JSONException e) {
            e.printStackTrace();
            //  Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();
            prgDialog.cancel();

        }

    }

    private void GetIndentData() {

        if (spSelectedRbmCode.equals("ALL")) {

//            FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/STNoDataFetchDBMAll.php?ZMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;
            FullIPData = IPAddress + ProjectFolder + "/STNoDataFetchDBMAll.php?ZMCode=" + POCodeGet + "&Acting=" + Acting + "&Dcode=" + DCode;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/STNoDataFetchDBMAll.php?ZMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;


        } else {
//            FullIPData=   "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/STNoDataFetchDBM.php?RBMCode="+PoCodeSpinners+"&Acting="+Acting+"&Dcode="+DCode;
            FullIPData = IPAddress + ProjectFolder + "/STNoDataFetchDBM.php?RBMCode=" + spSelectedRbmCode + "&Acting=" + Acting + "&Dcode=" + DCode;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/STNoDataFetchDBM.php?RBMCode="+PoCodeSpinners+"&Acting="+Acting+"&Dcode="+DCode;

        }

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            prgDialog.show();

            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

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
                            Log.e(TAG_RESULTS, "resultssss " + result);
                            showList4();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(DbmStockApprovalActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialogWarning(DbmStockApprovalActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();
                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {

            //Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
    }

    protected void showList4() {

        List<String> codes = new ArrayList<String>();
        String Checkfile = "";
        Check = "";

        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
//                String Id = c.getString(T1);
                String A = c.getString(T2);
//                String B = c.getString(T3);
//                String C = c.getString(T4);
//                String D = c.getString(T5);

                codes.add(A);
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
                    Toast.makeText(getApplicationContext(), "No Pending Approve", Toast.LENGTH_SHORT).show();
                    prgDialog.cancel();
                    //finish();
                }
            } else {
                prgDialog.cancel();
                Toast.makeText(getApplicationContext(), "No Pending Approve", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "No Pending Approve", Toast.LENGTH_SHORT).show();
            prgDialog.cancel();
        }
    }

    public void getData3() {


        FullIPData = "";

        if (spSelectedIndentNo.equals("ALL") && spSelectedRbmCode.equals("ALL")) {
//            FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/STDataFetchDBMAll.php?ZMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;
            FullIPData = IPAddress + ProjectFolder + "/STDataFetchDBMAll.php?ZMCode=" + POCodeGet + "&Acting=" + Acting + "&Dcode=" + DCode;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/STDataFetchDBMAll.php?ZMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;

        } else if (spSelectedIndentNo.equals("ALL") && !spSelectedRbmCode.equals("ALL")) {

//            FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/STNoDataFetchDBM.php?RBMCode="+PoCodeSpinners+"&Acting="+Acting+"&Dcode="+DCode;
            FullIPData = IPAddress + ProjectFolder + "/STNoDataFetchDBM.php?RBMCode=" + spSelectedRbmCode + "&Acting=" + Acting + "&Dcode=" + DCode;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/STNoDataFetchDBM.php?RBMCode="+PoCodeSpinners+"&Acting="+Acting+"&Dcode="+DCode;

        } else {
//            FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/STDataFetchDBM.php?STNo="+IndentNos+"&Acting="+Acting+"&Dcode="+DCode;
            FullIPData = IPAddress + ProjectFolder + "/STDataFetchDBM.php?STNo=" + spSelectedIndentNo + "&Acting=" + Acting + "&Dcode=" + DCode;
//            FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/STDataFetchDBM.php?STNo="+IndentNos+"&Acting="+Acting+"&Dcode="+DCode;

        }

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {
            prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
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
                            Log.e(TAG_RESULTS, "resultssss " + result);
                            showList3();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Log.e("stockapproval", "error " + e.toString());
                            Toast.makeText(DbmStockApprovalActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialogWarning(DbmStockApprovalActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();

                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {
            //Internet connection doesn't exist
            showAlertDialogWarning(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
    }


    protected void showList3() {


        Check = "";

        codes.removeAll(codes);
        codes1.removeAll(codes1);
        codes2.removeAll(codes2);
        codes3.removeAll(codes3);
        codes4.removeAll(codes4);
        codes5.removeAll(codes5);
        codes6.removeAll(codes6);
        codes7.removeAll(codes7);
        codes8.removeAll(codes8);
        codes9.removeAll(codes9);
        codes10.removeAll(codes10);
        codes11.removeAll(codes11);
        codes12.removeAll(codes12);
        codes13.removeAll(codes13);
        CancelRemarkscheck2.removeAll(CancelRemarkscheck2);


        checkBoxState1.removeAll(checkBoxState1);
        checkBoxStateCS2.removeAll(checkBoxStateCS2);
        checkBoxStateDS2.removeAll(checkBoxStateDS2);
        checkBoxStateAP2.removeAll(checkBoxStateAP2);
        checkBoxStateRET2.removeAll(checkBoxStateRET2);

        statusListView.setAdapter(null);
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

//                String Id = c.getString(T1);
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
                /*String N = c.getString(T15);
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

//                persons.put(T1, Id);
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
                /*persons.put(T15, N);
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


                codes.add(A);
                codes1.add(B);
                codes2.add(C);
                codes3.add(D);
                codes4.add(E);
                codes5.add(F);
                codes6.add(G);
                codes7.add(H);
                codes8.add(I);
                codes9.add(J);
                codes10.add(K);
                codes11.add(L);
                codes12.add(M);
                codes13.add(N);
                CancelRemarkscheck2.add("");
                checkBoxState1.add(false);
                checkBoxStateCS2.add(false);
                checkBoxStateDS2.add(true);
                checkBoxStateAP2.add(true);
                checkBoxStateRET2.add(false);


                // IndentCodeBulk = EventCode1;
                // EventDateBulk = CreationDate1 + "    " + Pocoode1 + "    " + ActivityCode1 + "      " + ActivityName1 + "      " + VillageName1 + "    " + TalukMandal1 + "      " + HybridName1 + "      " + SupportingPOs1 + "      " + Remarks1;
                // CancelRemarks="";

                //  CountryRemark country = new CountryRemark("", IndentCodeBulk, CancelRemarks,EventDateBulk,false);
                //  countryList.add(country);


                IndentCodeBulk = new String[codes.size()];
                EventDateBulk = new String[codes1.size()];
                AxQtyInPkt = new String[codes2.size()];
                AxRecid = new String[codes3.size()];


                AXHybrid = new String[codes4.size()];
                AxIndentDate = new String[codes5.size()];
                AXCustAccount = new String[codes7.size()];
                AxQtyInBag = new String[codes6.size()];
                AxQtyInKgs = new String[codes8.size()];
                AxPaking = new String[codes9.size()];
                AxDesc = new String[codes10.size()];
                Axrec = new String[codes11.size()];
                AxWHId = new String[codes12.size()];
                item_remarks = new String[codes13.size()];
                CancelRemarks = new String[CancelRemarkscheck2.size()];

                checkBoxState = new boolean[checkBoxState1.size()];

                checkBoxState3 = new boolean[checkBoxStateCS2.size()];
                checkBoxState4 = new boolean[checkBoxStateDS2.size()];
                checkBoxState5 = new boolean[checkBoxStateAP2.size()];
                checkBoxState6 = new boolean[checkBoxStateRET2.size()];

            }


            for (int j = 0; j < codes.size(); j++) {
                // Get the path of the image file
                IndentCodeBulk[j] = codes.get(j);
                EventDateBulk[j] = codes1.get(j);
                AxQtyInPkt[j] = codes2.get(j);
                AxRecid[j] = codes3.get(j);
                checkBoxState[j] = checkBoxState1.get(j);

                AXHybrid[j] = codes4.get(j);
                AxIndentDate[j] = codes5.get(j);
                AXCustAccount[j] = codes7.get(j);

                checkBoxState3[j] = checkBoxStateCS2.get(j);
                checkBoxState4[j] = checkBoxStateDS2.get(j);

                checkBoxState5[j] = checkBoxStateAP2.get(j);
                checkBoxState6[j] = checkBoxStateRET2.get(j);

                AxQtyInBag[j] = codes6.get(j);
                AxQtyInKgs[j] = codes8.get(j);
                AxPaking[j] = codes9.get(j);
                CancelRemarks[j] = CancelRemarkscheck2.get(j);
                AxDesc[j] = codes10.get(j);
                Axrec[j] = codes11.get(j);
                AxWHId[j] = codes12.get(j);
                item_remarks[j] = codes13.get(j);
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
                Toast.makeText(getApplicationContext(), "No Pending Approve", Toast.LENGTH_SHORT).show();
                prgDialog.cancel();
                //finish();
                HeaderView.setVisibility(View.GONE);
            }


        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "No Pending Approve", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            prgDialog.cancel();
            HeaderView.setVisibility(View.GONE);
        }

    }

    public void EveentGetData(View view) {


        if ("Please Select".equals(spSelectedRbmCode)) {

            Toast.makeText(getApplicationContext(), "Please Select TM code", Toast.LENGTH_LONG).show();

        } else {


            isConnectionExist = cd.checkMobileInternetConn();
            isConnectionExistMobile = cd.checkMobileInternetConns();

            if (isConnectionExist || isConnectionExistMobile) {


                // getData3();
                GetIndentData();


            } else {

                //Internet connection doesn't exist
                showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);


            }


        }


    }

    private class MyListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            if (IndentCodeBulk != null && IndentCodeBulk.length != 0) {
                return IndentCodeBulk.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

//            ViewHolder holder;

            final ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = DbmStockApprovalActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.stock_listview, null);

                holder.check_indent = convertView.findViewById(R.id.cbSalesIndent);
                holder.text_from_ware = convertView.findViewById(R.id.textView89);
                holder.text_to_ware = convertView.findViewById(R.id.textView15);
                holder.text_hybrid = convertView.findViewById(R.id.textView1);
                holder.edit_qty = convertView.findViewById(R.id.etQtyInKgPkts);
                holder.edit_qty.setEnabled(false);
                holder.text_exp_date = convertView.findViewById(R.id.textView16);
                holder.text_pkg = convertView.findViewById(R.id.textView);
                holder.check_approve = convertView.findViewById(R.id.checkBox);
                holder.check_reject = convertView.findViewById(R.id.checkBox4);
                holder.edit_remarks = convertView.findViewById(R.id.editText6);
                holder.item_remarks = convertView.findViewById(R.id.item_remarks);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();

            }
            holder.Ref = position;
            holder.check_indent.setText(IndentCodeBulk[position]);
            holder.text_from_ware.setText(EventDateBulk[position]);
            holder.text_to_ware.setText(AxQtyInPkt[position]);
            holder.text_hybrid.setText(AxRecid[position]);
            holder.text_pkg.setText(AxDesc[position]);
            holder.edit_qty.setText(AxQtyInBag[position]);

            holder.text_exp_date.setText(AXCustAccount[position]);

            holder.check_approve.setChecked(checkBoxState5[position]);
            holder.check_reject.setChecked(checkBoxState6[position]);
            holder.edit_remarks.setText(CancelRemarks[position]);
            holder.item_remarks.setText(item_remarks[position]);
            holder.edit_remarks.setEnabled(false);
            holder.item_remarks.setEnabled(false);

            holder.check_indent.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        checkBoxState[holder.Ref] = true;
                        holder.edit_qty.setEnabled(true);
                        holder.edit_qty.setFocusable(true);

                    } else {
                        checkBoxState[holder.Ref] = false;
                        holder.edit_qty.setEnabled(false);
                        holder.edit_qty.setEnabled(false);
                        // holder.QtyInBag.setText("");
                    }

                }
            });


            holder.check_approve.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {


                    if (((CheckBox) v).isChecked()) {
                        checkBoxState5[holder.Ref] = true;
                        checkBoxState6[holder.Ref] = false;
                        holder.check_reject.setChecked(false);
                        holder.edit_remarks.setEnabled(false);
                        holder.edit_remarks.setText("");


                    } else {
                        checkBoxState5[holder.Ref] = false;
                        checkBoxState6[holder.Ref] = true;
                        holder.check_approve.setChecked(true);
                        holder.edit_remarks.setEnabled(false);
                        holder.edit_remarks.setText("");

                    }

                }
            });


            holder.check_reject.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        checkBoxState6[holder.Ref] = true;
                        checkBoxState5[holder.Ref] = false;
                        holder.check_approve.setChecked(false);
                        holder.edit_remarks.setEnabled(true);
                        holder.edit_qty.setFocusable(true);
                    } else {
                        checkBoxState6[holder.Ref] = false;
                        checkBoxState5[holder.Ref] = true;
                        holder.check_reject.setChecked(true);
                        holder.edit_remarks.setEnabled(true);
                        holder.edit_remarks.setText("");
                    }

                }
            });

            holder.edit_qty.addTextChangedListener(new TextWatcher() {

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


                    AxQtyInBag[holder.Ref] = arg0.toString();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            double qty2 = 0;
                            try {
                                qty2 = Double.parseDouble(arg0.toString());

                                if (!calc(qty2, AxDesc[holder.Ref])) {
                                    holder.edit_qty.setError("Wrong Quantity");
                                    bnSubmit.setEnabled(false);
//                                    Toast.makeText(getApplicationContext(), "Please enter correct qty in count of "+int_size, Toast.LENGTH_SHORT).show();
                                } else {
                                    bnSubmit.setEnabled(true);
                                }
                            } catch (Exception e) {
                                Log.e("RBM", "error " + e.toString());
                            }


                        }
                    }, 1500);

                }
            });

            holder.edit_remarks.addTextChangedListener(new TextWatcher() {

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


                    CancelRemarks[holder.Ref] = arg0.toString();


                }
            });

            return convertView;
        }

        private void show_toast(String s) {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
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


            String[] size = pkg[0].trim().split("\\s+");
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

            if (size[1].contains("Kg") || size[1].contains("kg") || size[1].contains("k")) {
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
                }

//            double result =delta(qty2 ,gm_value);
//            if((result-(int)result)!=0) {
//                return false;
//            }else {
//                return true;
//            }
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

//        private boolean calc(double qty2, String pkgSize2)
//        {
//
//
//
////            String[] pkg = pkgSize2.split("-");
//            String[] size = pkgSize2.trim().split("\\s+");
//            try
//            {
//                int_size = Integer.parseInt(size[0]);
//            }
//            catch (Exception e)
//            {
//                return false;
//            }
//
//            if (size[1].contains("Kgs") || size[1].contains("kg")){
//                int_type = " Kgs";
//                if((qty2-(int)qty2)!=0) {
//                    return false;
//                }else {
//                    int result =(int) (qty2) % int_size;
//                    if (result == 0)
//                    {
//                        return true;
//                    }
//                }
//            }
//            else  if (size[1].contains("GMS") || size[1].contains("gm")){
//                int_type = " gms";
//                double gm_value = Double.parseDouble(int_size+"")/1000;
//                double result =delta(qty2 ,gm_value);
//                if((result-(int)result)!=0) {
//                    return false;
//                }else {
//                    return true;
//                }
//            }
//            else{
//                if((qty2-(int)qty2)!=0) {
//                    return false;
//                }
//                else{
//                    return true;
//                }
//            }
//            return false;
//        }

        public double delta(double d1, double d2) {
//        return Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
            return Math.abs(d1) / Math.abs(d2);
        }

        private class ViewHolder {
            int Ref;
            CheckBox check_indent;
            TextView text_from_ware;
            TextView text_to_ware;
            TextView text_hybrid;
            TextView text_pkg;
            EditText edit_qty;
            TextView text_exp_date;
            CheckBox check_approve, check_reject;
            EditText edit_remarks, item_remarks;
        }

    }

    private void GetUOMMaster() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {


                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    // HttpPost httppost = new HttpPost("http://210.212.238.34:8081/kanagaraj/crosssinginsyn.php");
                    // HttpPost httppost = new HttpPost(FinalIPAddress + "/kanagaraj/"+ProjectFolder+"/ISUomMasterRBM.php");

                    HttpPost httppost = new HttpPost(IPAddress + ProjectFolder + "/ISUomMasterRBM.php?RecID=" + RecIdCheck);
//                    HttpPost httppost = new HttpPost(FinalIPAddress + "/kanagaraj/" + ProjectFolder + "/ISUomMasterRBM.php?RecID=" +RecIdCheck);
//                    HttpPost httppost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISUomMasterRBM.php?RecID=" +RecIdCheck);
//                    HttpPost httppost = new HttpPost(new_api.ISUomMasterRBM(ProjectFolder ,RecIdCheck));


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


                    if (result != null) {
                        try {
                            showListUOM();
                        } catch (Exception e) {
                            prgDialog.cancel();
                            Toast.makeText(DbmStockApprovalActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Internet connection doesn't exist
                        showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();


                    }

                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {

            //Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }

    protected void showListUOM() {


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


                StdWeight = Double.parseDouble(A);
                ConFactor = Double.parseDouble(B);


                Checkfile = "Checkfile";


            }


            prgDialog.cancel();

        } catch (JSONException e) {
            e.printStackTrace();

            //  Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();

            prgDialog.cancel();

        }


    }

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


            for (STOIndentStatusUIData statusUIData : statusUiDataList) {
                try {
                    qty = Double.parseDouble(statusUIData.getQty());
                } catch (Exception e) {
                    qty = 0.0;
                }

                if (statusUIData.isIndentCheckBoxBool()) {
                    if (statusUIData.getQty() != null && !statusUIData.getQty().equals("0") && qty != 0.0) {
                        IndentBoxStateCheck2.add(statusUIData.isIndentCheckBoxBool());
                        if (statusUIData.getQty().trim().length() > 0) {
                            AxQtyInBagCheck2.add(statusUIData.getQty());

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
                    Toast.makeText(getApplicationContext(), "Please Select Stocks transfer number ", Toast.LENGTH_LONG).show();
                    prgDialog.cancel();
                }
            } else {

                if (AxQtyInBagCheck2.size() == IndentBoxStateCheck2.size()) {

                    if (RejectRemarkscheck2.size() == RejectBoxStateCheck2.size()) {

                        prgDialog.show();
                        for (STOIndentStatusUIData uiData : statusUiDataList) {
                            HashMap<String, String> map = new HashMap<>();
                            if (uiData.isApprovalCheckBoxBool()) {
                                map.put("dbm_approval_status", "APPROVED");
                                map.put("dbm_remarks", uiData.getItemRemarks());
                            } else if (uiData.isRejectCheckBoxBool()) {
                                map.put("dbm_approval_status", "REJECTED");
                                map.put("dbm_remarks", uiData.getCancelRemarks());
                            }
                            map.put("recID", uiData.getRecId());
                            map.put("dbm_no_of_pac", uiData.getNoOfPackets());
                            map.put("dbm_item_weight", uiData.getItemWeight());
                            map.put("dbm_qty", uiData.getQty());
                            if (uiData.isIndentCheckBoxBool()) {
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
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();
        }
    }

    private int i = 1;

    private void callApproveRejectRequest(HashMap<String, String> map, int size) {
        Log.d("ApproveRejectRequestMap", map.toString());
        Call<SuccessResponse> call = apiInterface.postApproveRejectRequestBySTODBM(map);
        call.enqueue(new Callback<SuccessResponse>() {
            @Override
            public void onResponse(Call<SuccessResponse> call, Response<SuccessResponse> response) {
                Log.d("ApproveRejectRequestSuccess", response.body().toString());
                if (size == i) {
                    prgDialog.hide();
                    Toast.makeText(DbmStockApprovalActivity.this, "Indent Approve/Reject successfully", Toast.LENGTH_SHORT).show();
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


    public void savedataCountCheck(View view) {
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
            for (int j = 0; j < IndentCodeBulk.length; j++) {


                boolean checkBoxStatecheck = checkBoxState[j];
                boolean checkBoxState6check = checkBoxState6[j];
                String CancelRemarkscheck = CancelRemarks[j];
                String AxQtyInBagcheck = AxQtyInBag[j];
                String AxQtyInPktcheck = AxQtyInBag[j];
                try {
                    qty = Double.parseDouble(AxQtyInBag[j]);
                } catch (Exception e) {
                    qty = 0.0;
                }


                if (checkBoxStatecheck == true) {
                    if (!AxQtyInBagcheck.equals("0") && qty != 0.0) {
                        IndentBoxStateCheck2.add(checkBoxStatecheck);

                        if (AxQtyInBagcheck.trim().length() > 0) {
                            AxQtyInBagCheck2.add(AxQtyInBagcheck);

                        }


                        if (checkBoxState6check == true) {
                            RejectBoxStateCheck2.add(checkBoxState6check);

                        }


                        if (CancelRemarkscheck.trim().length() > 0) {
                            RejectRemarkscheck2.add(CancelRemarkscheck);

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
                    Toast.makeText(getApplicationContext(), " Please Select Stocks transfer number ", Toast.LENGTH_LONG).show();
                    prgDialog.cancel();
                }
            } else {

                if (AxQtyInBagCheck2.size() == IndentBoxStateCheck2.size()) {


                    if (RejectRemarkscheck2.size() == RejectBoxStateCheck2.size()) {

                        savedata();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {

                                BulkApprovalDataSaveNew();
                            }
                        }, 3000);

                    } else {
                        bnSubmit.setEnabled(true);
                        Toast.makeText(getApplicationContext(), " Please Enter Remarks", Toast.LENGTH_LONG).show();
                        prgDialog.cancel();
                    }

                } else {
                    bnSubmit.setEnabled(true);
                    Toast.makeText(getApplicationContext(), " Please Select Packing Size ", Toast.LENGTH_LONG).show();

                    prgDialog.cancel();
                }


            }
        } else {
            bnSubmit.setEnabled(true);
            //Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();
        }


    }


    private void savedata() {


        DeleteStockTransferApprove();
        createTableStockTransferApprove();
//        DeleteSalesIndentApprove();
//        createTableSalesIndentApprove();


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

//            ISIndentBulkApprovalFile.delete();
            IntentType = "";

            for (int j = 0; j < IndentCodeBulk.length; j++) {


                BulkIndentCodeUpdate = IndentCodeBulk[j];
                AxQtyBagCheck = AxQtyInBag[j];
                checkBoxStateCheck = checkBoxState[j];
                AXRecidcheck = AxQtyInKgs[j];


                checkBoxStateAP = checkBoxState5[j];
                checkBoxStateRET = checkBoxState6[j];
                RejectRemarksCheck = CancelRemarks[j];

                arec_check = Axrec[j];
                W_id = AxWHId[j];

//                QtyInPkts=  AxQtyInPkt[j];

                RejectRemarksCheck = RejectRemarksCheck.replaceAll("[']", "");


                IntentType = "CS";


                if (checkBoxStateAP == true) {
                    ApproveDataCheck = "APPROVED";

                } else {
                    ApproveDataCheck = "CANCELLED";

                }


                if (BulkIndentCodeUpdate.trim().length() > 0 && checkBoxStateCheck == true) {

                    BulkApprovalDataSave();

                }
            }

        } else {

            //Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }


    }


    private void BulkApprovalDataSave() {


        String query = "INSERT INTO StockTransferApprove (STNo, RBMCode,ApproveType, ZMRemarks,Qty ,RecID ,ToWID) VALUES('" + BulkIndentCodeUpdate + "','" + AXRecidcheck + "','" + ApproveDataCheck + "','" + RejectRemarksCheck + "','" + AxQtyBagCheck + "','" + arec_check + "','" + W_id + "');";

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


            if (isTableExists(dbSalesIndent, "StockTransferApprove")) {


                if (fisttimecount.equals(true)) {


                    cScanDetails = dbSalesIndent.rawQuery("select MAX(id) from StockTransferApprove ", null);


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
                showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
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

            if (isTableExists(dbSalesIndent, "StockTransferApprove")) {

                cScanDetails = dbSalesIndent.rawQuery("select * from StockTransferApprove ", null);


                if (cScanDetails.moveToFirst()) {


                    do {

                        if (lineNumber == linecheck) {


                            ApprovalDataSyn = cScanDetails.getString(1).toString();
                            AXRecidupdate = cScanDetails.getString(2).toString();
                            AxQtyUpdate = cScanDetails.getString(3).toString();
                            AxIndentTypes = cScanDetails.getString(4).toString();
                            AxApproveRejectType = cScanDetails.getString(5).toString();
                            arec_check = cScanDetails.getString(6).toString();
                            W_id = cScanDetails.getString(7).toString();
                            RecIdCheck = AXRecidupdate;


                            EventDataApprovalUpdate();


                        }

                        lineNumber = lineNumber + 1;

                    } while (cScanDetails.moveToNext());


                }

            }


        } else {


            // Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
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

            ApprovalDataSyn = cScanDetails.getString(1).toString();
            AXRecidupdate = cScanDetails.getString(2).toString();
            AxQtyUpdate = cScanDetails.getString(3).toString();
            AxIndentTypes = cScanDetails.getString(4).toString();
            AxApproveRejectType = cScanDetails.getString(5).toString();
            arec_check = cScanDetails.getString(6).toString();
            W_id = cScanDetails.getString(7).toString();

            String IndentCode1 = ApprovalDataSyn.toString();

            String AXrecid1 = AXRecidupdate.trim().toString();

            String AxQtyUpdate1 = AxQtyUpdate.trim().toString();
            String AxIndentTypes1 = AxIndentTypes.trim().toString();

            String AxApproveRejectType1 = AxApproveRejectType.trim().toString();
            String Emp_code = POCodeGet;


            //  prgDialog1.show();
            //  prgDialog.show();

            // insertToDatabase2(EventCode1,ApType1,SubActivity1,PoCodeSpinner2,VillageNameSpineer2,Date2,SupportingPo2,Remark2,PoState2,PoRegion2,POTerritory2);
            insertToDatabase3(IndentCode1, AXrecid1, AxQtyUpdate1, AxIndentTypes1, AxApproveRejectType1);


        } else {

            // Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();

        }
    }

    // private void insertToDatabase2( String EventCode1,String ApType1,String SubActivity1,String PoCodeSpinner2, String VillageNameSpineer2,String Date2,String SupportingPo2, String Remark2,String PoState2,String PoRegion2, String POTerritory2){

    private void insertToDatabase3(String IndentCode1, String AXrecid1, String AxQtyUpdate1, String AxIndentTypes1, String AxApproveRejectType1) {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {
            class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
                @Override
                protected String doInBackground(String... params) {
                    String notify = "1";
                    String IndentCode1 = ApprovalDataSyn.toString();

                    String AXrecid1 = AXRecidupdate.trim().toString();

                    String AxQtyUpdate1 = AxQtyUpdate.trim().toString();
                    String AxIndentTypes1 = AxIndentTypes.trim().toString();

                    String AxApproveRejectType1 = AxApproveRejectType.trim().toString();

                    String arec_id = arec_check;

                    String WHId = W_id;


                    if (old_indent_no.equals(IndentCode1)) {
                        notify = "0";
                    } else {
                        notify = "1";
                        old_indent_no = IndentCode1;
                    }
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("STNo", IndentCode1));
                    nameValuePairs.add(new BasicNameValuePair("RBMCode", AXrecid1.trim().toString()));
                    nameValuePairs.add(new BasicNameValuePair("ApproveType", AxQtyUpdate1));
                    nameValuePairs.add(new BasicNameValuePair("ZMRemarks", AxIndentTypes1));
                    nameValuePairs.add(new BasicNameValuePair("Qty", AxApproveRejectType1));
                    nameValuePairs.add(new BasicNameValuePair("ToWHId", WHId));
                    nameValuePairs.add(new BasicNameValuePair("notify", notify));
                    nameValuePairs.add(new BasicNameValuePair("RecID", arec_id));


                    HttpClient httpClient = new DefaultHttpClient();


//                    HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/STZMUpdate.php?STNo="+IndentCode1+"&RBMCode="+AXrecid1.trim()+"&ApproveType="+AxQtyUpdate1+"&ZMRemarks="+AxIndentTypes1+"&Qty="+AxApproveRejectType1);
                    AxIndentTypes1 = AxIndentTypes1.replaceAll(" ", "%20");
                    String urlEncoded = Uri.encode(AxIndentTypes1, ALLOWED_URI_CHARS);
                    HttpPost httpPost = new HttpPost(IPAddress + ProjectFolder + "/STZMUpdate.php?STNo=" + IndentCode1 + "&RBMCode=" + AXrecid1.trim() + "&ApproveType=" + AxQtyUpdate1 + "&ZMRemarks=" + urlEncoded + "&Qty=" + AxApproveRejectType1 + "&ToWHId=" + WHId + "&notify=" + notify + "&RecID=" + arec_id);
//                        HttpPost httpPost = new HttpPost(FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/STZMUpdate.php?STNo="+IndentCode1+"&RBMCode="+AXrecid1.trim()+"&ApproveType="+AxQtyUpdate1+"&ZMRemarks="+AxIndentTypes1+"&Qty="+AxApproveRejectType1);
//                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


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
                        Log.e(TAG, result);
                    } catch (Exception e) {
                        // Oops
                        prgDialog.show();
                    }


                    return "success";

                }


                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);

                    if (totalcount == linecheck) {
                        bnSubmit.setEnabled(true);
                        Toast.makeText(getApplicationContext(), "  Indent Approve/Reject Completed", Toast.LENGTH_LONG).show();

                        prgDialog.cancel();
                        linecheck = 1;
                        totalcount = 0;
                        fisttimecount = true;

                        statusListView.setAdapter(null);
                        prgDialog.cancel();
                        //  finish();
                        getData3();
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
                sendPostReqAsyncTask.execute(IndentCode1, AXrecid1, AxQtyUpdate1, AxIndentTypes1, AxApproveRejectType1);

            } else {

                // Internet connection doesn't exist
                showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                        "Your device doesn't have WIFI or Data Plan internet access", false);
                prgDialog.cancel();

            }

        } else {

            // Internet connection doesn't exist
            showAlertDialogError(DbmStockApprovalActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
            prgDialog.cancel();

        }
    }


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

    public void CloseActivity(View view) {
        finish();
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

    protected void createDatabaseStockTransferData() {


        dbSalesIndent = openOrCreateDatabase(SalesIndentPath.getPath(), Context.MODE_PRIVATE, null);


    }


    protected void createTableSalesIndentApprove() {


        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentApprove(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR, AXRecID VARCHAR ,AXQty REAL, IndentTypes VARCHAR,ApproveType VARCHAR,RejectRemarks VARCHAR,AXQtyInPkt REAL);");


    }

    protected void createTableStockTransferApprove() {


        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS StockTransferApprove(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, STNo VARCHAR, RBMCode VARCHAR ,ApproveType VARCHAR, ZMRemarks VARCHAR,Qty REAL,RecID VARCHAR ,ToWID VARCHAR);");


    }


    protected void createTableSalesIndentApproveTemp() {

        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS StockTransferApproveTemp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, STNo VARCHAR, RBMCode VARCHAR ,ApproveType VARCHAR, ZMRemarks VARCHAR,Qty REAL);");

    }

    protected void createTableStockTransferApproveTemp() {

        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentApproveTemp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR, AXRecID VARCHAR ,AXQty REAL, IndentTypes VARCHAR,ApproveType VARCHAR,RejectRemarks VARCHAR,AXQtyInPkt REAL);");

    }

    private void DeleteSalesIndentApprove() {

        String DATABASE_TABLE_SalesIndentSalesIndentApprove = "SalesIndentApprove".toString();

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SalesIndentSalesIndentApprove + "'");


    }

    private void DeleteStockTransferApprove() {

        String DATABASE_TABLE_StockTranferApprove = "StockTransferApprove".toString();

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_StockTranferApprove + "'");


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


    private void calculateItemWeight(String qty, STOIndentStatusUIData statusUIData) {
        if (!statusUIData.getPackingQuantity().equals("")) {
            try {

                int pkgQtyInGram = (int) (Double.parseDouble(statusUIData.getPackingQuantity()) * 1000);

                Log.d("pkgQtyInGram", pkgQtyInGram + "");

                int etQtyInGram = (int) (Double.parseDouble(qty) * 1000);

                Log.d("etQtyInGram", etQtyInGram + "");

                if (statusUIData.getBaseUOM().equalsIgnoreCase("KG")) {
                    statusUIData.setItemWeight(qty);
                    statusUIData.setNoOfPackets(String.valueOf((etQtyInGram / pkgQtyInGram)));
                } else {
                    statusUIData.setItemWeight(String.valueOf((etQtyInGram * pkgQtyInGram)));
                    statusUIData.setNoOfPackets(qty);
                }
                statusUIData.setQty(qty);
            } catch (Exception e) {
                statusUIData.setItemWeight("");
                statusUIData.setNoOfPackets("");
            }
        }
    }

}
