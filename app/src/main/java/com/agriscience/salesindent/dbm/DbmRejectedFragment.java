package com.agriscience.salesindent.dbm;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import androidx.fragment.app.Fragment;

import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.model.SalesIndentStatusDetailsResponse;
import com.agriscience.salesindent.model.SalesIndentStatusResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.CountryRemark;
import com.agriscience.salesindent.R;

import com.agriscience.salesindent.WIFIInternetConnectionDetector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DbmRejectedFragment extends Fragment {

    //    MyCustomAdapter dataAdapter = null;
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

    ListView rejectedListView;


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
    private  String[]  AxStatus;

    private String[]  item_remarks_string;




    boolean[] checkBoxState;


    TextView LableName;





    String CancelRemarksSet="";

    String CancelRemarkscheck;

    String AxQtyBagCheck="";

    String AXRecidcheck;



    List<String> codes = new ArrayList<String>();
    List<String> codes1 = new ArrayList<String>();
    List<String> codes2 = new ArrayList<String>();
    List<Boolean> checkBoxState1 = new ArrayList<Boolean>();

    List<String> codes3 = new ArrayList<String>();

    private boolean checkBoxStateCheck=false;

    String AXRecidupdate="";



    List<String> CancelRemarkscheck2 = new ArrayList<String>();
    List<String> Cody = new ArrayList<String>();
    List<Boolean> checkBoxStateCheck2 = new ArrayList<Boolean>();


    private boolean checkBoxStateCS=false;
    private boolean checkBoxStateDS=false;

    private boolean checkBoxStateAP=false;
    private boolean checkBoxStateRET=false;




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
    List<String> codes7 = new ArrayList<String>();
    List<String> codes8 = new ArrayList<String>();
    List<String> codes9 = new ArrayList<String>();

    private  String[]  AXCustAccount;
    private  String[]  AXHybrid;
    private  String[]  AxIndentDate;
    private  String[]  AxQtyInBag;
    private  String[]  AxQtyInPkt;
    private  String[]  AxQtyInKgs;



    String DivisionGet="";
    String ProjectFolder="";

    ArrayList<String> resultlocation;
    ArrayList<String> resultIndentNo;
    ArrayList<String> resultproject;


    Spinner IndentNo;
    String IndentNos="";

    String FullIPData="";

    String EventBackCheck="";
    ViewGroup headerView;

    String AxQtyUpdate="";
    String AxIndentTypes="";

    String IntentType="";


    String UomValueCheck="";

    Double SalQty=0.00;

    Double SalQtyKgs=0.00;

    Double QtyInKgsCheck=0.00;

    String ItemCodeCheck="";

    String RecIdCheck="";

    int Axposion=1;

    LinearLayout rejectedHeaderView;


    List<String> RejectRemarkscheck2 = new ArrayList<String>();
    List<Boolean> IndentBoxStateCheck2 = new ArrayList<Boolean>();
    List<Boolean> RejectBoxStateCheck2 = new ArrayList<Boolean>();
    List<String> AxQtyInBagCheck2 = new ArrayList<String>();





    String ApproveDataCheck="";
    String RejectDataCheck="";
    String RejectRemarksCheck="";

    String AxApproveRejectType="";
    String AxRejectRemarksChecks="";
    String Acting ,DCode;

    private ApiInterface apiInterface;
    private AppSharedPreferences appSharedPreferences;
    public DbmRejectedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_dbmrejected, container, false);
        appLocationService = new AppLocationService(getActivity());
        appSharedPreferences = new AppSharedPreferences(requireActivity());
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        rejectedListView = (ListView) view.findViewById(R.id.listView);


        rejectedHeaderView = (LinearLayout) view.findViewById(R.id.Header);


//        LableName = (TextView) view.findViewById(R.id.textView33);


        //     FinalIPAddress = "http://210.212.238.34:8081";

        //FinalIPAddress="http://117.232.103.178:8080";
        // FinalIPAddress = "http://10.20.1.37:8080";
//        FinalIPAddress="http://103.44.97.110:8080";


        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {


            POCodeGet = extras.getString("Po_code");
            PONameGet = extras.getString("Po_name");
            TerritoryNameGet = extras.getString("Tm_name");
            PostCodeTransferGet = extras.getString("Post_code");
            SiteGet = extras.getString("Site_ID");
            DivisionGet = extras.getString("Division_code");
            Acting = extras.getString("Acting");
            DCode = extras.getString("D_code");

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


        cd = new WIFIInternetConnectionDetector(getActivity());

        prgDialog = new ProgressDialog(getActivity(), R.style.StyledDialog);
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


//        getData3();
 callSalesIndentStatusApi(appSharedPreferences.getUserId());
        return view;
    }

    private void callSalesIndentStatusApi(String dbmId) {
//        prgDialog.show();
        Call<SalesIndentStatusResponse> call = apiInterface.getAllDbmStatusDetails(dbmId);
        call.enqueue(new Callback<SalesIndentStatusResponse>() {
            @Override
            public void onResponse(Call<SalesIndentStatusResponse> call, Response<SalesIndentStatusResponse> response) {
                SalesIndentStatusResponse statusResponse = response.body();
                Log.d("TmRejected ",statusResponse.toString());
//                prgDialog.hide();
                if (statusResponse.getResult() != null && statusResponse.getResult().size() > 0) {
                    Log.d("Rejected Data",statusResponse.getResult().size()+" "+statusResponse.getResult().toString());
                    rejectedListView.setVisibility(View.VISIBLE);
                    SalesIndentStatusListAdapter statusListAdapter = new SalesIndentStatusListAdapter(statusResponse.getResult());
                    rejectedListView.setAdapter(statusListAdapter);
                    setListViewHeightBasedOnChildren(rejectedListView);
                }
                else {
                    rejectedListView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<SalesIndentStatusResponse> call, Throwable t) {
                call.cancel();
//                prgDialog.hide();
            }
        });
    }

    private  void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.MATCH_PARENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));


        listView.setLayoutParams(params);
    }


    private class SalesIndentStatusListAdapter extends BaseAdapter {
        private List<SalesIndentStatusDetailsResponse> detailsResponseList;

        public SalesIndentStatusListAdapter(List<SalesIndentStatusDetailsResponse> detailsResponseList) {
            this.detailsResponseList = detailsResponseList;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (detailsResponseList != null && detailsResponseList.size() > 0) {
                return detailsResponseList.size();
            }
            return 0;


        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return detailsResponseList.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //ViewHolder holder = null;
            SalesIndentStatusDetailsResponse statusResponse = detailsResponseList.get(position);

            ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = getActivity().getLayoutInflater();
                convertView = inflater.inflate(R.layout.country_remarks_tm, null);

                holder.code = (TextView) convertView.findViewById(R.id.textView44);
                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
                holder.Qtys = (EditText) convertView.findViewById(R.id.editText51);
                holder.Qtys.setEnabled(false);
                holder.AxcodeID = (TextView) convertView.findViewById(R.id.textView11);

                holder.AXHybrids = (TextView) convertView.findViewById(R.id.textView15);
                holder.AxIndentDates = (TextView) convertView.findViewById(R.id.textView16);
                holder.AXCustAccounts = (TextView) convertView.findViewById(R.id.textView17);

                holder.AxStatuss = (TextView) convertView.findViewById(R.id.textView45);


                holder.etPackingSize = (EditText) convertView.findViewById(R.id.etPackingSize);
                holder.etPackingSize.setEnabled(false);
                holder.etQtyInKgPkts = (EditText) convertView.findViewById(R.id.etQtyInKgPkts);
                holder.etQtyInKgPkts.setEnabled(false);
                holder.RejectRemarks =(EditText) convertView.findViewById(R.id.editText6);
                holder.RejectRemarks.setEnabled(false);
                holder.item_remarks=(EditText)convertView.findViewById(R.id.item_remarks);
                holder.item_remarks.setEnabled(false);
                holder.item_remarks.setVisibility(View.VISIBLE);

                holder.DS =convertView.findViewById(R.id.DS);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;

            if (statusResponse.getDbmApprovalStatus()!=null && statusResponse.getDbmApprovalStatus().trim().equalsIgnoreCase("REJECTED")){
                rejectedHeaderView.setVisibility(View.VISIBLE);
                holder.DS.setVisibility(View.VISIBLE);
            }else {
                holder.DS.setVisibility(View.GONE);
            }


            holder.code.setText(statusResponse.getIndentNo());
            holder.eventdatas.setText( statusResponse.getCustomerName());
//            holder.Qtys.setText(statusResponse.getQuantityInKgsOrPackets());
            holder.etQtyInKgPkts.setText(statusResponse.getQuantityInKgsOrPackets());
//            holder.AxcodeID.setText( AxRecid[position]);
            holder.AXHybrids.setText(statusResponse.getMaterialName());

            holder.AxIndentDates.setText( statusResponse.getIndentDate());
            holder.AXCustAccounts.setText(statusResponse.getCustomerCode());
            holder.etPackingSize.setText(statusResponse.getPackingQuantity());
//            holder.QtyInKgs.setText( AxQtyInKgs[position]);

//            if (!CancelRemarks[position].equals("null") || !CancelRemarks[position].equals("") || CancelRemarks[position]!=null)
//            {
//                //  Log.d("---------rej----------","----"+position+"---"+CancelRemarks[position]);
//                holder.RejectRemarks.setText(CancelRemarks[position]);
//            }

//            Log.d("StringRejectedRemaqrks","------------"+CancelRemarks[position]) ;
//            if (statusResponse.getTiRemarks()!=null || !statusResponse.getTiRemarks().equals("null") || !statusResponse.getTiRemarks().equals("")) {
//                if(statusResponse.getTiRemarks().equals(""))
//                {
////                    Log.d("item_remarks_string","-----itemm--11---"+(item_remarks_string[position]));
//                }
//                else
//                {
//                    //  Log.d("item_remarks_string","-----itemm-----"+(item_remarks_string[position]));
//                    // holder.item_remarks.setText(item_remarks_string[position]);
////                    String aa=item_remarks_string[position];
////                    Log.d("---------rej----------","----"+position+"---"+aa);
//                    holder.item_remarks.setText(statusResponse.getTiRemarks());
//                }
//
//
//            }

            if(statusResponse.getDbmRemarks()!=null){
                holder.RejectRemarks.setText(statusResponse.getDbmRemarks());
            }

            holder.AxStatuss.setText(statusResponse.getDbmApprovalStatus());

            return convertView;
        }



        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox name;
            EditText Qtys;
            EditText etPackingSize;
            EditText etQtyInKgPkts;
            TextView AxcodeID;

            TextView AXHybrids;
            TextView AxIndentDates;
            TextView AXCustAccounts;
            EditText RejectRemarks;
            TextView AxStatuss;
            LinearLayout DS;

            EditText item_remarks;

            int ref;


        }



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




    public void getData3() {


        FullIPData="";

        FullIPData=  IPAddress+ProjectFolder+"/ISIndentDataFetchDBMMALLReport.php?DBMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;
//        FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentDataFetchDBMMALLReport.php?DBMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;
//        FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentDataFetchDBMMALLReport.php?DBMCode="+POCodeGet+"&Acting="+Acting+"&Dcode="+DCode;

//        FullIPData = new_api.ISIndentDataFetchDBMMALLReport(ProjectFolder ,POCodeGet ,Acting ,DCode);

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



                    if (result!=null)


                    {
                        try {
                            showList3();
                        }catch (Exception e){
                            prgDialog.cancel();
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        // Internet connection doesn't exist
                        showAlertDialogWarning(getActivity(), "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();



                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        }


        else

        {

            //Internet connection doesn't exist
            showAlertDialogWarning(getActivity(), "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


        }
    }


    protected void showList3() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

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
            CancelRemarkscheck2.removeAll(CancelRemarkscheck2);
            Cody.removeAll(Cody);


            rejectedListView.setAdapter(null);

       /* list.removeHeaderView(headerView);


        LayoutInflater inflater = getLayoutInflater();
        headerView = (ViewGroup) inflater.inflate(R.layout.approveheader, list,
                false);
        //ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer, list,
        //   false);
        list.addHeaderView(headerView, null, false);
        // list.addFooterView(footer, null, false);*/


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
                    String S = c.getString(T20);
                    String T = c.getString(T21);
                    String U = c.getString(T22);
                    String V = c.getString(T23);
                    String W = c.getString(T24);
                    String X = c.getString(T25);
                    String Y = c.getString(T26);
               /* String Y = c.getString(T26);
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
                    persons.put(T23, V);
                    persons.put(T24, W);
                    persons.put(T25, X); persons.put(T26, Y);


                    Check = "chckfile";

                    codes.add(Id);
                    codes1.add(D);
                    // codes1.add(A + "    " + C + "    " + D + "      " + T + "      " + M  );
                    codes2.add(P);
                    codes3.add(U);
//                    codes4.add(L);
                    codes4.add(M);
                    codes5.add(A);
                    codes6.add(C);
                    codes7.add(V);
                    codes8.add(W);
                    codes9.add(R);
                    CancelRemarkscheck2.add(X);
                    Cody.add(Y);


                    IndentCodeBulk = new String[codes.size()];
                    EventDateBulk = new String[codes1.size()];
                    AxQtyInPkt = new String[codes2.size()];
                    AxRecid = new String[codes3.size()];


                    AXHybrid = new String[codes4.size()];
                    AxIndentDate = new String[codes5.size()];
                    AXCustAccount = new String[codes6.size()];
                    AxQtyInBag = new String[codes7.size()];
                    AxQtyInKgs = new String[codes8.size()];
                    CancelRemarks = new String[CancelRemarkscheck2.size()];
                    item_remarks_string = new String[Cody.size()];

                    AxStatus = new String[codes9.size()];


                }


                for (int j = 0; j < codes.size(); j++) {
                    // Get the path of the image file
                    IndentCodeBulk[j] = codes.get(j);
                    EventDateBulk[j] = codes1.get(j);
                    AxQtyInPkt[j] = codes2.get(j);
                    AxRecid[j] = codes3.get(j);


                    AXHybrid[j] = codes4.get(j);
                    AxIndentDate[j] = codes5.get(j);
                    AXCustAccount[j] = codes6.get(j);

                    AxQtyInBag[j] = codes7.get(j);
                    AxQtyInKgs[j] = codes8.get(j);
                    CancelRemarks[j] = CancelRemarkscheck2.get(j);
                    AxStatus[j] = codes9.get(j);
                    item_remarks_string[j] = Cody.get(j);

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
                    rejectedListView.setAdapter(myListAdapter);
                    setListViewHeightBasedOnItems(rejectedListView);


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

                    rejectedListView.setVisibility(View.VISIBLE);
                    rejectedHeaderView.setVisibility(View.VISIBLE);

                    Check = "";
                    prgDialog.cancel();
                } else {
                    Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                    prgDialog.cancel();
                    //finish();
                    rejectedHeaderView.setVisibility(View.GONE);
                }


            } catch (JSONException e) {
                Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                prgDialog.cancel();
                rejectedHeaderView.setVisibility(View.GONE);
            }
        }
        else

        {
            prgDialog.cancel();
            //Internet connection doesn't exist
            showAlertDialogWarning(getActivity(), "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);


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

            final  ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = getActivity().getLayoutInflater();
                convertView = inflater.inflate(R.layout.country_remarks_tm, null);

                holder.code = (TextView) convertView.findViewById(R.id.textView44);
                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
                holder.Qtys = (EditText) convertView.findViewById(R.id.editText51);
                holder.Qtys.setEnabled(false);
                holder.AxcodeID = (TextView) convertView.findViewById(R.id.textView11);

                holder.AXHybrids = (TextView) convertView.findViewById(R.id.textView15);
                holder.AxIndentDates = (TextView) convertView.findViewById(R.id.textView16);
                holder.AXCustAccounts = (TextView) convertView.findViewById(R.id.textView17);

                holder.AxStatuss = (TextView) convertView.findViewById(R.id.textView45);



                holder.QtyInBag = (EditText) convertView.findViewById(R.id.etPackingSize);
                holder.QtyInBag.setEnabled(false);
                holder.QtyInKgs = (EditText) convertView.findViewById(R.id.etQtyInKgPkts);
                holder.QtyInKgs.setEnabled(false);
                holder.RejectRemarks =(EditText) convertView.findViewById(R.id.editText6);
                holder.RejectRemarks.setEnabled(false);

                holder.item_remarks=convertView.findViewById(R.id.item_remarks);
                holder.item_remarks.setEnabled(false);

                holder.DS =convertView.findViewById(R.id.DS);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;

            holder.code.setText(IndentCodeBulk[position]);
            holder.eventdatas.setText( EventDateBulk[position]);
            holder.Qtys.setText( AxQtyInPkt[position]);
            holder.AxcodeID.setText( AxRecid[position]);
            holder.AXHybrids.setText( AXHybrid[position]);



            holder.AxIndentDates.setText( AxIndentDate[position]);
            holder.AXCustAccounts.setText( AXCustAccount[position]);


            holder.QtyInBag.setText( AxQtyInBag[position]);
            holder.QtyInKgs.setText( AxQtyInKgs[position]);

            if (!CancelRemarks[position].equals("null") || !CancelRemarks[position].equals("") || CancelRemarks[position]!=null)
            {
                holder.RejectRemarks.setText(CancelRemarks[position]);
            }

            if(!item_remarks_string[position].equals(""))
            {
                Log.d("stringssssss","------"+position+"--rejjj-----"+item_remarks_string[position]);

                holder.item_remarks.setText(item_remarks_string[position]);

            }
            holder.AxStatuss.setText(AxStatus[position]);

            if (AxStatus[position].equals("CANCELLED")){
                holder.DS.setVisibility(View.VISIBLE);
            }else {
                holder.DS.setVisibility(View.GONE);
            }



            return convertView;
        }



        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox name;
            EditText Qtys;
            EditText QtyInBag;
            EditText QtyInKgs;
            TextView AxcodeID;

            TextView AXHybrids;
            TextView AxIndentDates;
            TextView AXCustAccounts;
            EditText RejectRemarks;
            TextView AxStatuss;
            LinearLayout DS;
            EditText item_remarks;

            int ref;


        }




    }





//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_tmreport_view, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


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




   /* @Override
    public void onBackPressed() {


        if (EventBackCheck.equals("EventBackCheckfile1")) {


            EventBackCheck = "";

            list.setVisibility(View.GONE);
            EventBackCheck="EventBackCheckfile2";
            HeaderView.setVisibility(View.GONE);
        }

        else if (EventBackCheck.equals("EventBackCheckfile2")) {

            EventBackCheck = "";


            list.setVisibility(View.GONE);
            HeaderView.setVisibility(View.GONE);
        } else {


            finish();
        }
    }*/

//    @Override
//    public void onBackPressed() {
//
//
//
//        finish();
//
//    }





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


//    public void CloseActivity(View view) {
//
//          finish();
//
//
//        /*(Intent intent = new Intent(this, DBMScreenActivity.class);
//        intent.putExtra("Po_code", POCodeGet);
//        intent.putExtra("Po_name", PONameGet);
//        intent.putExtra("Tm_name", TerritoryNameGet);
//        intent.putExtra("Post_code", PostCodeTransfer);
//        intent.putExtra("Division_code", DivisionGet);
//        intent.putExtra("Site_ID", SiteGet);
//
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// This flag ensures all activities on top of the CloseAllViewsDemo are cleared.
//        this.startActivity(intent);*/
//
//
//
//    }


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
