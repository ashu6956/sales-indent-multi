package com.agriscience.salesindent.am;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.agriscience.salesindent.am.AMApprovedFragment;
import com.agriscience.salesindent.am.AMAutoApproveFragment;
import com.agriscience.salesindent.am.AMPendingFragment;
import com.agriscience.salesindent.am.AMRejectedFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.agriscience.salesindent.R;
import com.agriscience.salesindent.widgets.FCViewPager;

public class AMReportViewActivity extends AppCompatActivity {

//    //MyCustomAdapter dataAdapter = null;
//    private static final String TAG = "";
//    String myJSON;
//    private static final String TAG_RESULTS1 = "result";
//    private static final String T1 = "Id";
//    private static final String T2k = "POCode";
//    private static final String T3k = "POName";
//    private static final String T4k = "TerritoryName";
//    private static final String T5k = "Password";
//    private static final String T6k = "POSCode";
//
//
//    private static final String TAG_RESULTS = "result";
//
//    private static final String T2 = "A";
//    private static final String T3 = "B";
//    private static final String T4 = "C";
//    private static final String T5 = "D";
//    private static final String T6 = "E";
//    private static final String T7 = "F";
//    private static final String T8 = "G";
//    private static final String T9 = "H";
//    private static final String T10 = "I";
//    private static final String T11 = "J";
//    private static final String T12 = "K";
//    private static final String T13 = "L";
//    private static final String T14 = "M";
//    private static final String T15 = "N";
//    private static final String T16 = "O";
//    private static final String T17 = "P";
//    private static final String T18 = "Q";
//    private static final String T19 = "R";
//    private static final String T20 = "S";
//    private static final String T21 = "T";
//    private static final String T22 = "U";
//    private static final String T23 = "V";
//    private static final String T24 = "W";
//    private static final String T25 = "X";
//    private static final String T26 = "Y";
//    private static final String T27 = "Z";
//
//    ;
//
//    JSONArray peoples = null;
//
//    ArrayList<HashMap<String, String>> personList;
//
//    EditText usernames, Passwords;
//    String usernames1, Passwords1, textDeviceID1;
//    Button Login;
//    String Check = "";
//    String Checks = "";
//
//    String NameUser, Departments, Imei;
//
//    Boolean isConnectionExist = false;
//    Boolean isConnectionExistMobile = false;
//
//    TextView textDeviceID;
//    // Connection detector class
//    WIFIInternetConnectionDetector cd;
//
//
//    ProgressDialog prgDialog;
//
//    private TextToSpeech tts;
//    String txtText;
//    String toSpeak, text;
//    AppLocationService appLocationService;
//
//
//    TextView Latitude, Longitude, ImeiNo, SimNo, MobileNo, TmName;
//
//    String LocationTimes = "";
//
//    EditText Location, TmCode, PoCode, PoName, SupportingPo, EventDecription, Expenses, NoofFarmer, FarmerName, ContactNo, Remarks;
//
//
//    Spinner Crop, Stage, EventName, ActivityName;
//    String Crops, Stages;
//
//
//    String Eventcodes = "";
//    String Activitycodes = "";
//    String EventNames = "";
//    String ActivityNames = "";
//
//
//    TextView Remarks1;
//
//    Button Upload1, Upload2, Upload3;
//    ImageView Image1, Image2, Image3;
//    Bitmap bitmap1, bitmap2, bitmap3;
//
//    int CAMERA_PIC_REQUEST = 0;
//    private static final int SELECT_PICTURE = 1;
//    private String selectedImagePath;
//
//    String CheckUpload1 = "";
//    String CheckUpload2 = "";
//    String CheckUpload3 = "";
//
//
//    private Button uploadButton, btnselectpic, btnselectaudio, btnselectvideo;
//    private ImageView imageview;
//    private int serverResponseCode = 0;
//    private ProgressDialog dialog = null;
//
//    private String upLoadServerUri = null;
//    private String filepath1 = "";
//    private String filepath2 = "";
//    private String filepath3 = "";
//    int FLAG = 0;
//
//
//    String imagenames;
//    String timevalue;
//    Integer UploadCount1 = 1;
//
//
//    String Pocodes, Ponames, Tmcodes;
//
//
//    String Imagepath1 = "";
//    String Imagepath2 = "";
//    String Imagepath3 = "";
//
//
//    Boolean Syncomplete = true;
//    Boolean fisttimecountexit = true;
//
//    Boolean fistautosyn = true;
//
//    String Nfarm, Remks, Supprtpo, Expnss, IM1, IM2, IM3;
//
//
//    String ChecksEvent = "";
//
//    String EventDataUpdateCheck = "";
//
//
//    String UpDateString = "";
//
//
//    String POCodeGet = "";
//    String PONameGet = "";
//    String TerritoryNameGet = "";
//    String PostCodeTransfer = "";
//
//    EditText ActivityNamee;
//
//
//    String Creationdate1, ActivityName1, TerritoryName1, StateCode1, Region1, VillageName1, POCode1, HybridName1, BudgetAmt1, Status1;
//
//
//    EditText AType, SubActivityName;
//
//
//    Spinner EventCode;
//
//    String EventCodes;
//
//
//    String Village, pocodemy;
//
//    Button Transdate;
//
//    private TextView pDisplayDate;
//    private Button CrostD2, CroenD2;
//    private int pYear;
//    private int pMonth;
//    private int pDay;
//    /**
//     * This integer will uniquely define the dialog to be used for displaying date picker.
//     */
//    static final int DATE_DIALOG_ID = 0;
//
//
//    Spinner ActivityType, SubActivity, PoCodeSpinner, VillageNameSpineer;
//
//
//    String PoHeadQRs, PoState, PoRegion, POTerritory;
//
//    String PoCodeSpinners = "";
//
//
//    File Iroot = Environment.getExternalStorageDirectory();
//    File Oroot = Environment.getExternalStorageDirectory();
//
//
//    File APPOMasterInput = null;
//    File APActivityTypeMasterInput = null;
//    File APSubActivityMasterInput = null;
//    File APVillageMasterInput = null;
//
//    File APEvenetDataFile = null;
//    File APEventCodeFile = null;
//
//
//    File APEventRecordBulkApprovalFile = null;
//    File ISIndentBulkApprovalFile = null;
//
//    Button PODate;
//
//
//    Spinner POCodeCheckSpinner;
//    Button DateCheck;
//
//
//    String POCodeCheckSpinners;
//    Button Submit;
//
//    String ActivityTypes, SubActivitys, VillageNameSpineers = "";
//
//    Boolean fisttimecount = true;
//
//
//    EditText pocoderet, villagenameret, Dateret, Supportingret, TmRemarkret;
//
//    String Atypes, Anames, Daterets, Supportingrets, TmRemarkrets;
//
//    LinearLayout Linearfirst;
//    LinearLayout LinearSeconds;
//    ScrollView LinearSecond;
//
//
//    private String[] EventCodess;
//    private String[] Dates;
//    private String[] Pocodess;
//    private String[] ActivityTypess;
//    private String[] Activitys;
//    private String[] Villages;
//    private Integer[] Selections;
//
//
//    List<String> EventCodessTransfer = new ArrayList<String>();
//    List<String> DatesTransfer = new ArrayList<String>();
//    List<String> PocodessTransfer = new ArrayList<String>();
//    List<String> ActivityTypessTransfer = new ArrayList<String>();
//    List<String> ActivitysTransfer = new ArrayList<String>();
//    List<String> VillagesTransfer = new ArrayList<String>();
//    List<Integer> SelectionsTransfer = new ArrayList<Integer>();
//
//    ListView list;
//
//
//    Button SelectAll;
//    ImageButton BulkUpload;
//
//
//    String BulkIndentCodeUpdate;
//
//
//    int linecheck = 1;
//    int totalcount = 0;
//
//
//    CheckBox AllDataApproval;
//
//
//    String ApprovalDataSyn;
//
//
//    ArrayList<CountryRemark> countryList = new ArrayList<CountryRemark>();
//
//    private String[] IndentCodeBulk;
//    private  String[]  EventDateBulk;
//    private  String[]  CancelRemarks;
//    private  String[]  AxRecid;
//    private  String[]  AxStatus;
//
//
//
//
//    boolean[] checkBoxState;
//
//
//    TextView LableName;
//
//
//
//
//
//    String CancelRemarksSet="";
//
//    String CancelRemarkscheck;
//
//    String AxQtyBagCheck="";
//
//    String AXRecidcheck;
//
//
//
//    List<String> codes = new ArrayList<String>();
//    List<String> codes1 = new ArrayList<String>();
//    List<String> codes2 = new ArrayList<String>();
//    List<Boolean> checkBoxState1 = new ArrayList<Boolean>();
//
//    List<String> codes3 = new ArrayList<String>();
//
//    private boolean checkBoxStateCheck=false;
//
//    String AXRecidupdate="";
//
//
//
//    List<String> CancelRemarkscheck2 = new ArrayList<String>();
//    List<Boolean> checkBoxStateCheck2 = new ArrayList<Boolean>();
//
//
//    private boolean checkBoxStateCS=false;
//    private boolean checkBoxStateDS=false;
//
//    private boolean checkBoxStateAP=false;
//    private boolean checkBoxStateRET=false;
//
//
//
//
//    List<Boolean> checkBoxStateCS2 = new ArrayList<Boolean>();
//    List<Boolean> checkBoxStateDS2 = new ArrayList<Boolean>();
//
//    List<Boolean> checkBoxStateAP2 = new ArrayList<Boolean>();
//    List<Boolean> checkBoxStateRET2 = new ArrayList<Boolean>();
//
//
//    boolean[] checkBoxState3;
//    boolean[] checkBoxState4;
//
//    boolean[] checkBoxState5;
//    boolean[] checkBoxState6;
//
//    String FinalIPAddress;
//
//
//    File ISHeaderDataFile =null;
//    File ISLineDataFile =null;
//    File ISLineDataTempFile =null;
//
//    File ISIndentCodeFile =null;
//
//    File ISProductMasterFile =null;
//
//    File ISCustMasterInput=null;
//    File ISItemMasterInput=null;
//    File ISCropMasterInput =null;
//    File ISSiteMasterInput =null;
//    File ISWarehouseMasterInput =null;
//
//    String PostCodeTransferGet="";
//    String SiteGet="";
//
//
//
//    List<String> codes4 = new ArrayList<String>();
//    List<String> codes5 = new ArrayList<String>();
//    List<String> codes6 = new ArrayList<String>();
//    List<String> codes7 = new ArrayList<String>();
//    List<String> codes8 = new ArrayList<String>();
//    List<String> codes9 = new ArrayList<String>();
//
//    private  String[]  AXCustAccount;
//    private  String[]  AXHybrid;
//    private  String[]  AxIndentDate;
//    private  String[]  AxQtyInBag;
//    private  String[]  AxQtyInPkt;
//    private  String[]  AxQtyInKgs;
//
//
//
//    String DivisionGet="";
//    String ProjectFolder="";
//
//    ArrayList<String> resultlocation;
//    ArrayList<String> resultIndentNo;
//    ArrayList<String> resultproject;
//
//
//    Spinner IndentNo;
//    String IndentNos="";
//
//    String FullIPData="";
//
//    String EventBackCheck="";
//    ViewGroup headerView;
//
//    String AxQtyUpdate="";
//    String AxIndentTypes="";
//
//    String IntentType="";
//
//
//    String UomValueCheck="";
//
//    Double SalQty=0.00;
//
//    Double SalQtyKgs=0.00;
//
//    Double QtyInKgsCheck=0.00;
//
//    String ItemCodeCheck="";
//
//    String RecIdCheck="";
//
//    int Axposion=1;
//
//    LinearLayout HeaderView;
//
//
//    List<String> RejectRemarkscheck2 = new ArrayList<String>();
//    List<Boolean> IndentBoxStateCheck2 = new ArrayList<Boolean>();
//    List<Boolean> RejectBoxStateCheck2 = new ArrayList<Boolean>();
//    List<String> AxQtyInBagCheck2 = new ArrayList<String>();
//
//
//
//
//
//    String ApproveDataCheck="";
//    String RejectDataCheck="";
//    String RejectRemarksCheck="";
//
//    String AxApproveRejectType="";
//    String AxRejectRemarksChecks="";


    TabLayout tabLayout;
    FCViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbmreport_view);

        //Generate list View from ArrayList

        getSupportActionBar().hide();
        
        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        viewPager.setEnableSwipe(false);


        tabLayout = findViewById(R.id.tabslayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AMApprovedFragment(), "Approved");
        adapter.addFragment(new AMRejectedFragment(), "Rejected");
        adapter.addFragment(new AMAutoApproveFragment(), "Auto-Approve");
        adapter.addFragment(new AMPendingFragment(), "Pending");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new AMApprovedFragment();
                case 1:
                    return new AMRejectedFragment();
                case 2:
                    return new AMAutoApproveFragment();
                case 3:
                    return new AMPendingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }
        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }

//    private void IndentActivity( )
//    {
//
//        Intent intent = new Intent(this, RBMIndentSelection.class);
//        intent.putExtra("Po_code", POCodeGet);
//        intent.putExtra("Po_name", PONameGet);
//        intent.putExtra("Tm_name", TerritoryNameGet);
//        intent.putExtra("Post_code", PostCodeTransferGet);
//        intent.putExtra("Site_ID", SiteGet);
//        intent.putExtra("Division_code", DivisionGet);
//        intent.putExtra("IndentNo_No", IndentNos);
//        startActivity(intent);
//
//    }
//
//
//    /**
//     * Callback received when the user "picks" a date in the dialog
//     */
//    /*  private DatePickerDialog.OnDateSetListener pDateSetListener =
//            new DatePickerDialog.OnDateSetListener() {
//
//                public void onDateSet(DatePicker view, int year,
//                                      int monthOfYear, int dayOfMonth) {
//                    pYear = year;
//                    pMonth = monthOfYear;
//                    pDay = dayOfMonth;
//
//
//
//                    updateDisplay();
//
//                    updateDisplay2();
//
//                    //  displayToast();
//                }
//            };
//
//    /** Updates the date in the TextView
//   private void updateDisplay() {
//
//
//       // Transdate.setText(
//           //     new StringBuilder()
//                        // Month is 0 based so add 1
//
//                     //   .append(pDay).append("/")
//                        //.append(pMonth + 1).append("/")
//                       // .append(pYear).append(" "));
//
//
//
//
//
//
//    }
//
//    private void updateDisplay2() {
//
//
//      //  DateCheck.setText(
//              //  new StringBuilder()
//                        // Month is 0 based so add 1
//
//                       // .append(pDay).append("/")
//                        //.append(pMonth + 1).append("/")
//                        //.append(pYear).append(" "));
//
//
//
//    }
//
//
//    public void Getlist3() {
//
//        String check = "";
//
//
//        List<String> codes = new ArrayList<String>();
//        codes.add("Please Select");
//
//        try {
//            //create BufferedReader to read csv file
//            BufferedReader br = new BufferedReader(new FileReader(APPOMasterInput));
//            String line = "";
//
//
//            int lineNumber = 0;
//
//            //read comma separated file line by line
//            while ((line = br.readLine()) != null) {
//                lineNumber++;
//
//
//                //use comma as token separator
//                String[] country = line.split(",");
//
//
//                if (PostCodeTransfer.equals("TM")) {
//
//                    if (country[12].equals(POCodeGet)) {
//
//                        // codes.add(new String(country[16]));
//                        codes.add(new String(country[16] + "-" + country[17]));
//                    }
//                } else {
//                    if (country[16].equals(POCodeGet)) {
//
//                        // codes.add(new String(country[16]));
//                        codes.add(new String(country[16] + "-" + country[17]));
//
//                    }
//                }
//
//
//            }
//
//
//            HashSet<String> set = new HashSet<>(codes);
//
//            // Create ArrayList from the set.
//            ArrayList<String> result = new ArrayList<>(set);
//            //Comparator mycomparator = Collections.reverseOrder();
//            //Collections.sort(result,mycomparator);
//
//            Collections.sort(result);
//
//            //ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
//            // adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            //PoCodeSpinner.setAdapter(adapter1);
//
//            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes);
//            adapter1.setDropDownViewResource(R.layout.spinner_item);
//            PoCodeSpinner.setAdapter(adapter1);
//
//
//        } catch (Exception e) {
//            System.err.println("CSV file cannot be read : " + e);
//            // Toast.makeText(getApplicationContext(), "CSV file  cannot be read or Opened ", Toast.LENGTH_LONG).show();
//
//        }
//
//    }
//
//*/
//
//
//
//
//    public void getData3() {
//
//
//        FullIPData="";
//
//        FullIPData=  FinalIPAddress+"/kanagaraj/"+ProjectFolder+"/ISIndentDataFetchRBMMALLReport.php?RBMCode="+POCodeGet;
////        FullIPData=  "http://192.168.35.24/hyveg/Sales_Indent_App/"+ProjectFolder+"/ISIndentDataFetchRBMMALLReport.php?RBMCode="+POCodeGet;
//
//
//
//        isConnectionExist = cd.checkMobileInternetConn();
//        isConnectionExistMobile = cd.checkMobileInternetConns();
//
//        if (isConnectionExist || isConnectionExistMobile) {
//
//
//            prgDialog.show();
//            class GetDataJSON extends AsyncTask<String, Void, String> {
//
//                @Override
//                protected String doInBackground(String... params) {
//                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                    //  HttpPost httppost = new HttpPost(FinalIPAddress+"/kanagaraj/APEventRecorders/APEeventDataFetch.php");
//                    //HttpPost httppost = new HttpPost(FinalIPAddress+"/kanagaraj/APEventRecorders/APEventDatafetchChecknew.php?Pocode="+PoCodeSpinners);
//                    HttpPost httppost = new HttpPost(FullIPData);
//
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
//
//                        String line = null;
//                        while ((line = reader.readLine()) != null) {
//                            sb.append(line + "\n");
//                        }
//                        result = sb.toString();
//                    } catch (Exception e) {
//                        prgDialog.hide();
//                        // Oops
//                    } finally {
//                        try {
//                            if (inputStream != null) inputStream.close();
//                        } catch (Exception squish) {
//                            prgDialog.hide();
//                        }
//                    }
//                    return result;
//                }
//
//                @Override
//                protected void onPostExecute(String result) {
//                    myJSON = result;
//
//                    if (result!=null)
//
//
//                    {
//
//                        showList3();
//
//                    }
//                    else
//                    {
//                        // Internet connection doesn't exist
//                        showAlertDialogWarning(RBMReportViewActivity.this, "No Internet Connection",
//                                "Your device doesn't have WIFI or Data Plan internet access", false);
//
//                        prgDialog.hide();
//
//
//
//                    }
//                }
//            }
//            GetDataJSON g = new GetDataJSON();
//            g.execute();
//        }
//
//
//        else
//
//        {
//
//            //Internet connection doesn't exist
//            showAlertDialogWarning(RBMReportViewActivity.this, "No Internet Connection",
//                    "Your device doesn't have WIFI or Data Plan internet access", false);
//
//
//        }
//    }
//
//
//    protected void showList3() {
//
//        isConnectionExist = cd.checkMobileInternetConn();
//        isConnectionExistMobile = cd.checkMobileInternetConns();
//
//        if (isConnectionExist || isConnectionExistMobile) {
//
//        Check = "";
//
//        codes.removeAll(codes);
//        codes1.removeAll(codes1);
//        codes2.removeAll(codes2);
//        codes3.removeAll(codes3);
//        codes4.removeAll(codes4);
//        codes5.removeAll(codes5);
//        codes6.removeAll(codes6);
//        codes7.removeAll(codes7);
//        codes8.removeAll(codes8);
//        CancelRemarkscheck2.removeAll(CancelRemarkscheck2);
//
//
//
//
//
//        list.setAdapter(null);
//
//       /* list.removeHeaderView(headerView);
//
//
//        LayoutInflater inflater = getLayoutInflater();
//        headerView = (ViewGroup) inflater.inflate(R.layout.approveheader, list,
//                false);
//        //ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer, list,
//        //   false);
//        list.addHeaderView(headerView, null, false);
//        // list.addFooterView(footer, null, false);*/
//
//
//        try {
//            JSONObject jsonObj = new JSONObject(myJSON);
//            peoples = jsonObj.getJSONArray(TAG_RESULTS);
//
//            for (int i = 0; i < peoples.length(); i++) {
//                JSONObject c = peoples.getJSONObject(i);
//
//                String Id = c.getString(T1);
//                String A = c.getString(T2);
//                String B = c.getString(T3);
//                String C = c.getString(T4);
//                String D = c.getString(T5);
//                String E = c.getString(T6);
//                String F = c.getString(T7);
//                String G = c.getString(T8);
//                String H = c.getString(T9);
//                String I = c.getString(T10);
//                String J =c.getString(T11);
//                String K = c.getString(T12);
//                String L = c.getString(T13);
//
//                String M = c.getString(T14);
//                String N = c.getString(T15);
//                String O = c.getString(T16);
//                String P = c.getString(T17);
//                String Q = c.getString(T18);
//                String R = c.getString(T19);
//                String S = c.getString(T20);
//                String T = c.getString(T21);
//                String U = c.getString(T22);
//                String V = c.getString(T23);
//                String W = c.getString(T24);
//                String X = c.getString(T25);
//                /*String Y = c.getString(T26);
//                String Z = c.getString(T27);*/
//
//
//
//                HashMap<String, String> persons = new HashMap<String, String>();
//
//                persons.put(T1, Id);
//                persons.put(T2, A);
//                persons.put(T3, B);
//                persons.put(T4, C);
//                persons.put(T5, D);
//                persons.put(T6, E);
//                persons.put(T7, F);
//                persons.put(T8, G);
//                persons.put(T9, H);
//                persons.put(T10, I);
//                persons.put(T11, J);
//                persons.put(T12, K);
//                persons.put(T13, L);
//                persons.put(T14, M);
//                persons.put(T15, N);
//                persons.put(T16, O);
//                persons.put(T17, P);
//                persons.put(T18, Q);
//                persons.put(T19, R);
//                persons.put(T20, S);
//                persons.put(T21, T);
//                persons.put(T22, U);
//                persons.put(T23, V);
//                persons.put(T24, W);
//                persons.put(T25, X);
//
//
//
//
//                Check="chckfile";
//
//                codes.add(Id);
//                codes1.add(D);
//                // codes1.add(A + "    " + C + "    " + D + "      " + T + "      " + M  );
//                codes2.add(P);
//                codes3.add(U);
//                codes4.add(L);
//                codes5.add(A);
//                codes6.add(C);
//                codes7.add(V);
//                codes8.add(W);
//                codes9.add(R);
//                CancelRemarkscheck2.add(X);
//
//
//
//                IndentCodeBulk = new String[codes.size()];
//                EventDateBulk = new String[codes1.size()];
//                AxQtyInPkt = new String[codes2.size()];
//                AxRecid=new String[codes3.size()];
//
//
//                AXHybrid=new String[codes4.size()];
//                AxIndentDate=new String[codes5.size()];
//                AXCustAccount=new String[codes6.size()];
//                AxQtyInBag=new String[codes7.size()];
//                AxQtyInKgs=new String[codes8.size()];
//                CancelRemarks=new String[CancelRemarkscheck2.size()];
//
//                AxStatus=new String[codes9.size()];
//
//
//
//            }
//
//
//
//
//            for (int j = 0; j < codes.size(); j++) {
//                // Get the path of the image file
//                IndentCodeBulk[j] = codes.get(j);
//                EventDateBulk[j] = codes1.get(j);
//                AxQtyInPkt[j] = codes2.get(j);
//                AxRecid[j] = codes3.get(j);
//
//
//                AXHybrid[j] = codes4.get(j);
//                AxIndentDate[j] = codes5.get(j);
//                AXCustAccount[j] = codes6.get(j);
//
//                AxQtyInBag[j] = codes7.get(j);
//                AxQtyInKgs[j] = codes8.get(j);
//                CancelRemarks[j] = CancelRemarkscheck2.get(j);
//                AxStatus[j] = codes9.get(j);
//
//            }
//
//            if (Check.equals("chckfile")) {
//
//
//               /* LayoutInflater inflater = getLayoutInflater();
//                ViewGroup header = (ViewGroup) inflater.inflate(R.layout.approveheader, list,
//                        false);
//                //ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer, list,
//                //   false);
//                list.addHeaderView(header, null, false);
//                // list.addFooterView(footer, null, false); */
//
//
//                MyListAdapter myListAdapter = new MyListAdapter();
//                list.setAdapter(myListAdapter);
//                setListViewHeightBasedOnItems(list);
//
//
//
//            }
//            // displayListView();
//
//
//            //  for (int j = 0; j < EventCodessTransfer.size(); j++) {
//            // Get the path of the image file
//            // EventCodess[j] = EventCodessTransfer.get(j);
//            // Dates[j] = DatesTransfer.get(j);
//            // Pocodess[j] = PocodessTransfer.get(j);
//            // ActivityTypess[j] = ActivityTypessTransfer.get(j);
//            // Activitys[j] = ActivitysTransfer.get(j);
//            // Villages[j] = VillagesTransfer.get(j);
//            // Selections[j] = SelectionsTransfer.get(j);
//            //   }
//
//
//            if (Check.equals("chckfile")) {
//
//                EventBackCheck="EventBackCheckfile1";
//
//                list.setVisibility(View.VISIBLE);
//                HeaderView.setVisibility(View.VISIBLE);
//
//                Check = "";
//                prgDialog.hide();
//            } else {
//                Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_SHORT).show();
//                prgDialog.hide();
//                //finish();
//                HeaderView.setVisibility(View.GONE);
//            }
//
//
//
//        } catch (JSONException e) {
//            Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//            prgDialog.hide();
//            HeaderView.setVisibility(View.GONE);
//        }
//        }
//
//
//        else
//
//        {
//
//            //Internet connection doesn't exist
//            showAlertDialogWarning(RBMReportViewActivity.this, "No Internet Connection",
//                    "Your device doesn't have WIFI or Data Plan internet access", false);
//
//
//        }
//    }
//
//
//
//    private class MyListAdapter extends BaseAdapter {
//
//
//
//        @Override
//        public int getCount() {
//            // TODO Auto-generated method stub
//            if (IndentCodeBulk != null && IndentCodeBulk.length != 0) {
//                return IndentCodeBulk.length;
//            }
//            return 0;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            // TODO Auto-generated method stub
//            return IndentCodeBulk[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            // TODO Auto-generated method stub
//            return position;
//        }
//
//
//
//
//
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            //ViewHolder holder = null;
//
//            final  ViewHolder holder;
//            if (convertView == null) {
//
//                holder = new ViewHolder();
//                LayoutInflater inflater = RBMReportViewActivity.this.getLayoutInflater();
//                convertView = inflater.inflate(R.layout.country_remarks_tm, null);
//
//                holder.code = (TextView) convertView.findViewById(R.id.textView44);
//                holder.eventdatas = (TextView) convertView.findViewById(R.id.textView89);
//                holder.Qtys = (EditText) convertView.findViewById(R.id.editText51);
//                holder.Qtys.setEnabled(false);
//                holder.AxcodeID = (TextView) convertView.findViewById(R.id.textView11);
//
//                holder.AXHybrids = (TextView) convertView.findViewById(R.id.textView15);
//                holder.AxIndentDates = (TextView) convertView.findViewById(R.id.textView16);
//                holder.AXCustAccounts = (TextView) convertView.findViewById(R.id.textView17);
//
//                holder.AxStatuss = (TextView) convertView.findViewById(R.id.textView45);
//
//
//
//                holder.QtyInBag = (EditText) convertView.findViewById(R.id.editText4);
//                holder.QtyInBag.setEnabled(false);
//                holder.QtyInKgs = (EditText) convertView.findViewById(R.id.editText5);
//                holder.QtyInKgs.setEnabled(false);
//                holder.RejectRemarks =(EditText) convertView.findViewById(R.id.editText6);
//                holder.RejectRemarks.setEnabled(false);
//                convertView.setTag(holder);
//
//            } else {
//
//                holder = (ViewHolder) convertView.getTag();
//            }
//
//            holder.ref = position;
//
//            holder.code.setText(IndentCodeBulk[position]);
//            holder.eventdatas.setText( EventDateBulk[position]);
//            holder.Qtys.setText( AxQtyInPkt[position]);
//            holder.AxcodeID.setText( AxRecid[position]);
//            holder.AXHybrids.setText( AXHybrid[position]);
//
//
//
//            holder.AxIndentDates.setText( AxIndentDate[position]);
//            holder.AXCustAccounts.setText( AXCustAccount[position]);
//
//
//            holder.QtyInBag.setText( AxQtyInBag[position]);
//            holder.QtyInKgs.setText( AxQtyInKgs[position]);
//
//
//            holder.RejectRemarks.setText(CancelRemarks[position]);
//
//            holder.AxStatuss.setText(AxStatus[position]);
//
//
//
//
//            return convertView;
//        }
//
//
//
//        private class ViewHolder {
//            TextView code;
//            TextView eventdatas;
//            CheckBox name;
//            EditText Qtys;
//            EditText QtyInBag;
//            EditText QtyInKgs;
//            TextView AxcodeID;
//
//            TextView AXHybrids;
//            TextView AxIndentDates;
//            TextView AXCustAccounts;
//            EditText RejectRemarks;
//            TextView AxStatuss;
//
//            int ref;
//
//
//        }
//
//
//
//
//    }
//
//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tmreport_view, menu);
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

    @Override
    public void onBackPressed() {



        finish();

    }





//    /**
//     * Function to display simple Alert Dialog
//     *
//     * @param context - application context
//     * @param title   - alert dialog title
//     * @param message - alert message
//     * @param status  - success/failure (used to set icon)
//     */

//    public void showAlertDialogError(Context context, String title, String message, Boolean status) {
//        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
//
//        // Setting Dialog Title
//        alertDialog.setTitle(title);
//
//        // Setting Dialog Message
//        alertDialog.setMessage(message);
//
//        // Setting alert dialog icon
//        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.e3);
//
//        // Setting OK Button
//        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//
//        // Showing Alert Message
//        alertDialog.show();
//    }
//
//
//    public void showAlertDialogWarning(Context context, String title, String message, Boolean status) {
//        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
//
//        // Setting Dialog Title
//        alertDialog.setTitle(title);
//
//        // Setting Dialog Message
//        alertDialog.setMessage(message);
//
//        // Setting alert dialog icon
//        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.e1);
//
//        // Setting OK Button
//        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//
//        // Showing Alert Message
//        alertDialog.show();
//    }
//
//
//    public void showAlertDialog1(Context context, String title, Boolean status) {
//        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
//
//        // Setting Dialog Title
//        alertDialog.setTitle(title);
//
//        // Setting Dialog Message
//        // alertDialog.setMessage(message);
//
//        // Setting alert dialog icon
//        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
//
//        // Setting OK Button
//        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//
//        // Showing Alert Message
//        alertDialog.show();
//    }
//
//    //protected Dialog onCreateDialog(int id) {
//    // switch (id) {
//    //  case DATE_DIALOG_ID:
//    //  return new DatePickerDialog(this,
//    // pDateSetListener,
//    //pYear, pMonth, pDay);
//
//    // }
//    //return null;
//    // }


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


//    public static boolean setListViewHeightBasedOnItems(ListView listView) {
//
//        ListAdapter listAdapter = listView.getAdapter();
//        if (listAdapter != null) {
//
//            int numberOfItems = listAdapter.getCount();
//
//            // Get total height of all items.
//            int totalItemsHeight = 0;
//            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
//                View item = listAdapter.getView(itemPos, null, listView);
//                item.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//                totalItemsHeight += item.getMeasuredHeight();
//            }
//
//            // Get total height of all item dividers.
//            int totalDividersHeight = listView.getDividerHeight() *
//                    (numberOfItems - 1);
//            // Get padding
//            int totalPadding = listView.getPaddingTop() + listView.getPaddingBottom();
//
//            // Set list height.
//            ViewGroup.LayoutParams params = listView.getLayoutParams();
//            params.height = totalItemsHeight + totalDividersHeight + totalPadding;
//            listView.setLayoutParams(params);
//            listView.requestLayout();
//
//            return true;
//
//        } else {
//            return false;
//        }
//
//    }


}
