package com.agriscience.salesindent.tm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationSettingsResult;

import org.json.JSONArray;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.R;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.ZOrganogramResponseDetails;
import com.agriscience.salesindent.room_database.SalesIndentDataBase;
import com.agriscience.salesindent.room_database.entity.CustomerEntity;
import com.agriscience.salesindent.room_database.entity.MaterialEntity;
import com.agriscience.salesindent.room_database.entity.SalesIndentDetailsTmpEntity;
import com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity;
import com.agriscience.salesindent.room_database.entity.SeasonEntity;


public class TMSalesIndentActivity extends Activity implements AdapterView.OnItemSelectedListener {

    String PackagingIDsend = "";
    String Itemnametosend = "";
    String ItemIDtosend = "";

    String Descriptiontosend = "";
    String UnitIDtosend = "";

    String kgorgms = "";

    private int pYear;
    private int pMonth;
    private int pDay;
    /**
     * This integer will uniquely define the dialog to be used for displaying date picker.
     */
    static final int DATE_DIALOG_ID = 0;


    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;
    String myJSON;
    AppLocationService appLocationService;


    String Check = "";

    float int_size = 0;
    String int_type = " Kgs";


    File Iroot = Environment.getExternalStorageDirectory();
    File Oroot = Environment.getExternalStorageDirectory();

    ProgressDialog prgDialog;
    ProgressDialog prgDialog1;

    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;


    // Connection detector class
    WIFIInternetConnectionDetector cd;


    File ISLoginMaster = null;


    PendingResult<LocationSettingsResult> result;
//    final static int REQUEST_LOCATION = 199;


    String sMaterialName = "", sBaseUom = "", sPackingQuantity = "";
    String POCodeGet = "";
    String PONameGet = "";
    String TerritoryNameGet = "";
    String PostCodeTransfer = "";
    String SiteGet = "";

    //    String PoHeadQRs;
    String PoState = "", PoRegion = "", POTerritory = "";


    //    EditText Remark;
    EditText SupportingPo;

//    String SupportingPos,Remarks;

    String IndentCodeFinal = "";


    String IndentCreationCode;

    TextView Focusfirst;

    String sVarietyNames = "";

    String DivisionGet = "";

    TextView HybridLabel, HybridColon;


    Spinner CropType;

    Spinner spCropName;
    String sCropName = "", sCropCode = "";


    AutoCompleteTextView autoTextCustomerAccount, autoTextSeasonCode;
    String sCustomerCode = "", sCustomerName;
    String sSeasonCode = "";

    TextView seasonCodeTitle, seasonCodeColon;


    String CustGroupCheck = "";


    File ISHeaderDataFile = null;
    File ISLineDataFile = null;
    File ISLineDataTempFile = null;

    File ISIndentCodeFile = null;

    File ISProductMasterFile = null;


    private String[] SerialList;
    private String[] VarietyList;
    private String[] QtyList;

    private String[] remarks_list;


    List<String> SerialLists = new ArrayList<>();
    List<String> VarietyLists = new ArrayList<>();
    List<String> QtyLists = new ArrayList<>();

    List<String> remarks_listss = new ArrayList<>();

    ListView salesIndentLineListView;

    Integer SerialNo = 1;
    Integer LineNo = 1;

    View headerView;

    ImageButton Submit;

    String IndentCreationCodeTemp = "";
    String strDateTemp = "";
    String strTimeTemp = "";
    String CustomerAccountsTemp = "";
    String CustomerName2Temp = "";
    String CropTypesTemp = "";
    String CropNamesTemp = "";
    String HybridsTemp = "";
    String Qty2Temp = "";
    String RemarksTemp = "";
    String SitesTemp = "";
    String WarehouseTemp = "";
    String ExpectedDateTemp = "";
    String PackagingIDsendTemp = "";
    String ItemnametosendTemp = "";
    String ItemIDtosendTemp = "";

    String DescriptiontosendTemp = "";
    String UnitIDtosendTemp = "";


    String ItemNamesTemp = "";


    File ISCustMasterInput = null;
    File ISItemMasterInput = null;
    File ISCropMasterInput = null;
    File ISSiteMasterInput = null;
    File ISWarehouseMasterInput = null;

    File ISUomMaster = null;


    Button ExpectedDate;


    //    Spinner Site,Warehouse;
    String Sites, Warehouses;


    // SearchableSpinner    Hybrid;
    Spinner spVarietyName;
    Spinner spItemName;


    String ItemNames = "";

//    List<String> HybridList = new ArrayList<String>();

    String CropDiV = "";

    String CustSiteID;

    String UomValueCheck = "";

//    Double SalQty=0.00;

    Double SalQtyKgs = 0.00;


    EditText QtyInBag;
    EditText etQtyInKgs;
    EditText Remarks_feild;

    private SQLiteDatabase dbGetmaster;
    File Getmasterpath = null;


    private Cursor cScanDetails;
//    private Cursor cScanDetailsTemp;

    private Cursor GetCursorOrderDetails;

    private SQLiteDatabase dbSalesIndent;
    File SalesIndentPath = null;

    private SQLiteDatabase dbNumberSequence;


//    String GetmasterCheck="";


//    Double QtyInKgsCheck=0.00;


//    Double CurrentStockQty = 0.00;
//    Double AllocationStockQty = 0.00;
//    Double InvoieStockQty = 0.00;
//    Double BalQty=0.00;
//    Double PBalQty=0.00;
//    Double PlacementQty=0.00;

    String SalPrice = "";
    String SalPriceTemp = "";

    //    Double CustBal=0.00;
//    Double OrderValue=0.00;
//    Double CurCustBal=0.00;
    Double CustCreditLimit = 0.00;

//    String AllocationCheckItems = "";

    String PriceCheckItems1 = "";
    String PriceCheckItems2 = "";

    String MandatoryCreditLimit = "";

//    Double CustCreditLimitAlert=0.00;
//    Double OldSalesQty=0.00;
//    Double OldSalesQtyTemp=0.00;
//    Double OrderValueTemp=0.00;


    Double StdWeight = 0.00;
    Double ConFactor = 0.00;


    Spinner PkgSize;
    String PkgSizes = "";


    String PkgName = "";


    String PkgSizesTemp = "";
    String PkgNameTemp = "";
    String UomValueTemp = "";
    String Acting = "";
    String DCode = "";
    AppSharedPreferences appSharedPreferences;

    private String sDivison = "";

    private CustomerEntity customerEntity;
    private SeasonEntity seasonEntity;

    private String sMaterialCode = "";
    private String sVarietyCode = "", sVarietyName = "";

    private SalesIndentDataBase salesIndentDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmsales_indent);

        salesIndentDataBase = SalesIndentDataBase.getDataBase(this);
        ExpectedDate = findViewById(R.id.button);

        ExpectedDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        appSharedPreferences = new AppSharedPreferences(this);


        /* Get the current date */

        final Calendar c = Calendar.getInstance();
        pYear = c.get(Calendar.YEAR);
        pMonth = c.get(Calendar.MONTH);
        pDay = c.get(Calendar.DAY_OF_MONTH);


        /* Display the current date in the TextView */
        updateDisplay();


        appLocationService = new AppLocationService(TMSalesIndentActivity.this);


        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));


        autoTextCustomerAccount = findViewById(R.id.autoTextToPlant);
        autoTextSeasonCode = findViewById(R.id.autoCompleteSeasonCode);


        salesIndentLineListView = findViewById(R.id.listView);

        Focusfirst = findViewById(R.id.textView33);
        HybridLabel = findViewById(R.id.textView98);
        HybridColon = findViewById(R.id.textView99);
        spVarietyName = findViewById(R.id.spVarietyName);
        spItemName = findViewById(R.id.spItemName);

        CropType = findViewById(R.id.spinner23);

        spCropName = findViewById(R.id.spFromPlant);

        seasonCodeTitle = findViewById(R.id.tvSeasonCode);
        seasonCodeColon = findViewById(R.id.tvSeasonCodeColon);


        QtyInBag = findViewById(R.id.editText2);

        etQtyInKgs = findViewById(R.id.etQtyKgPkts);

        Remarks_feild = findViewById(R.id.etRemarks);


        PkgSize = findViewById(R.id.spinner4);


        Focusfirst.setFocusable(true);
        Focusfirst.setFocusableInTouchMode(true);
        Focusfirst.requestFocus();

        Submit = findViewById(R.id.ibSaveData);

        // Submit.setEnabled(false);


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

            ISUomMaster = new File(dir, "ISUomMaster.csv");


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

            File dir = new File(Iroot.getAbsolutePath() + "/SalesIndentData");
            dir.mkdirs();

            ISProductMasterFile = new File(dir, "ISProductMaster.csv");
        }


        if (Iroot.canWrite()) {

            Calendar cal = Calendar.getInstance();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            //  SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

            String strDate, strTime;

            strDate = sdf.format(cal.getTime());


            File dir = new File(Iroot.getAbsolutePath() + "/ISLoginMaster");
            dir.mkdirs();

            ISLoginMaster = new File(dir, "ISLoginMaster" + strDate + ".csv");
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

            File dir = new File(Iroot.getAbsolutePath() + "/Android/SalesIndentHVG");
            dir.mkdirs();

            ISIndentCodeFile = new File(dir, "NumberSequence.csv");
        }


//        createDatabaseGetMaster();
//        createDatabaseSalesIndentData();
//
//        createTableGetMasterDatabase();
//        createTableSalesIndentDetails();
//
//        DeleteSalesIndentDetailsTemp();
//        createTableSalesIndentDetailsTemp();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            POCodeGet = extras.getString("Po_code");
            PONameGet = extras.getString("Po_name");
            TerritoryNameGet = extras.getString("Tm_name");
            PostCodeTransfer = extras.getString("Post_code");
            SiteGet = extras.getString("Site_ID");
            DivisionGet = extras.getString("Division_code");

        }


        getCustomerDetailsFromDB();
        if (appSharedPreferences.getDivision().equalsIgnoreCase("FC")) {
            autoTextSeasonCode.setVisibility(View.VISIBLE);
            seasonCodeTitle.setVisibility(View.VISIBLE);
            seasonCodeColon.setVisibility(View.VISIBLE);
            getSeasonDetailsFromDB();
        } else {
            autoTextSeasonCode.setVisibility(View.GONE);
            seasonCodeTitle.setVisibility(View.GONE);
            seasonCodeColon.setVisibility(View.GONE);
        }
        GetCropNameFromMaterialDB();
        addTextChangeListener();


        // initiate spinner

        List<String> codes3 = new ArrayList<String>();
        codes3.add("Please Select");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
        adapter1.setDropDownViewResource(R.layout.spinner_item);
        spVarietyName.setAdapter(adapter1);

        ArrayAdapter<String> itemNameAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
        itemNameAdapter.setDropDownViewResource(R.layout.spinner_item);
        spItemName.setAdapter(itemNameAdapter);


//        if (ISLineDataTempFile.exists()) {
//            ISLineDataTempFile.delete();
//
//        }
    }


    private void addTextChangeListener() {
        autoTextCustomerAccount.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }
        });

        autoTextSeasonCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        etQtyInKgs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String sQty = editable.toString();

                try {
                    if (sQty != null && !sQty.equalsIgnoreCase("")) {
                        double dQty = Double.parseDouble(sQty);
                        Handler handler = new Handler();
                        handler.postDelayed(() -> {

                            if (!sBaseUom.isEmpty()) {
                                if (sBaseUom.equalsIgnoreCase("KG")) {
                                    if (sQty.trim().length() > 0 && calculateQuantityInKg(dQty)) {

                                    } else {
                                        etQtyInKgs.setError("wrong QTY entered");
                                        Toast.makeText(getApplicationContext(), "wrong QTY entered", Toast.LENGTH_LONG).show();

                                    }
                                } else if (sBaseUom.equalsIgnoreCase("PAK")) {
                                    if (sQty.trim().length() > 0 && !sQty.contains(".")) {

                                    } else {
                                        etQtyInKgs.setError("No decimals were allowed");
                                        Toast.makeText(getApplicationContext(), "You can not add decimal number", Toast.LENGTH_LONG).show();
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
    }

    // Callback received when the user "picks" a date in the dialog
    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;


                    updateDisplay();

                    //  displayToast();
                }
            };

    // Updates the date in the TextView


    private void updateDisplay() {


        ExpectedDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1

                        .append(pDay).append("/")
                        .append(pMonth + 1).append("/")
                        .append(pYear).append(" "));


        String Transchecdate = pDay + "/" + (pMonth + 1) + "/" + pYear;


        if (String.valueOf(pDay).length() == 1) {

            Transchecdate = "0" + pDay + "/" + (pMonth + 1) + "/" + pYear;

        }

        if (String.valueOf(pMonth + 1).length() == 1) {

            Transchecdate = pDay + "/" + "0" + (pMonth + 1) + "/" + pYear;

        }


        if (String.valueOf(pDay).length() == 1 && String.valueOf(pMonth + 1).length() == 1) {

            Transchecdate = "0" + pDay + "/" + "0" + (pMonth + 1) + "/" + pYear;

        }


        ExpectedDate.setText(Transchecdate);


    }


    @SuppressLint("ClickableViewAccessibility")
    public void getCustomerDetailsFromDB() {


        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<CustomerEntity> allCustomers = salesIndentDataBase.customerDao().getAllCustomers();
            runOnUiThread(() -> showCustomerAccountOnView(allCustomers));
        });


    }


    @SuppressLint("ClickableViewAccessibility")
    public void getSeasonDetailsFromDB() {
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<SeasonEntity> seasonEntityList = salesIndentDataBase.seasonDao().getAllSeasons();
            Log.d("TMSales", "getSeasonDetailsFromDB: "+seasonEntityList.toString());
            runOnUiThread(() -> showSeasonDetailsOnView(seasonEntityList));
        });
    }


    private void showCustomerAccountOnView(List<CustomerEntity> allCustomers) {
        if (allCustomers != null && allCustomers.size() > 0) {
            List<String> codes = new ArrayList<String>();
            allCustomers.stream().forEach(customerEntity -> {
                codes.add(customerEntity.getCustomerCode() + "- " + customerEntity.getCustomerName());
            });


            HashSet<String> set = new HashSet<>(codes);

            // Create ArrayList from the set.
            final ArrayList<String> result = new ArrayList<>(set);


            Collections.sort(result);

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, result);
            autoTextCustomerAccount.setAdapter(adapter);
            autoTextCustomerAccount.setThreshold(1);
            autoTextCustomerAccount.setTextColor(Color.BLACK);

            autoTextCustomerAccount.setOnItemSelectedListener(this);
            autoTextCustomerAccount.setOnItemClickListener((adapterView, view, i, l) -> {
                sCustomerCode = autoTextCustomerAccount.getText().toString();

                try {
                    String[] separated = sCustomerCode.split("-");
                    sCustomerCode = separated[0];
                    sCustomerName = separated[1];

                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> customerEntity = salesIndentDataBase.customerDao().getCustomerByCustomerCode(sCustomerCode));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                autoTextCustomerAccount.setFocusable(false);
                autoTextCustomerAccount.setFocusableInTouchMode(false);
            });

            autoTextCustomerAccount.setDropDownWidth(getResources().getDisplayMetrics().DENSITY_560);


            autoTextCustomerAccount.setOnTouchListener((paramView, paramMotionEvent) -> {
                if (result.size() > 0) {
                    // show all suggestions
                    if (!autoTextCustomerAccount.getText().toString().equals(""))
                        adapter.getFilter().filter(null);
                    autoTextCustomerAccount.showDropDown();

                }

                return false;
            });
        }
    }


    private void showSeasonDetailsOnView(List<SeasonEntity> seasonEntityList) {
        if (seasonEntityList != null && seasonEntityList.size() > 0) {
            List<String> codes = new ArrayList<>();
            seasonEntityList.stream().forEach(seasonEntity -> codes.add(seasonEntity.getSeasonCode() + "- " + seasonEntity.getSeasonName()));


            HashSet<String> set = new HashSet<>(codes);

            // Create ArrayList from the set.
            final ArrayList<String> result = new ArrayList<>(set);


            Collections.sort(result);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, result);
            autoTextSeasonCode.setAdapter(adapter);
            autoTextSeasonCode.setThreshold(1);
            autoTextSeasonCode.setTextColor(Color.BLACK);

            autoTextSeasonCode.setOnItemSelectedListener(this);
            autoTextSeasonCode.setOnItemClickListener((adapterView, view, i, l) -> {
                sSeasonCode = autoTextSeasonCode.getText().toString();

                String[] separated = sSeasonCode.split("-");
                sSeasonCode = separated[0];


                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                autoTextSeasonCode.setFocusable(false);
                autoTextSeasonCode.setFocusableInTouchMode(false);
            });

            autoTextSeasonCode.setDropDownWidth(getResources().getDisplayMetrics().DENSITY_560);


            autoTextSeasonCode.setOnTouchListener((paramView, paramMotionEvent) -> {
                if (result.size() > 0) {
                    // show all suggestions
                    if (!autoTextSeasonCode.getText().toString().equals(""))
                        adapter.getFilter().filter(null);
                    autoTextSeasonCode.showDropDown();

                }

                return false;
            });
        } else {

        }
    }


    public void GetCropNameFromMaterialDB() {

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<MaterialEntity> allMaterials = salesIndentDataBase.materialDao().getAllCropDetails();
            runOnUiThread(() -> showCropDetailsOnView(allMaterials));
        });
    }

    private void showCropDetailsOnView(List<MaterialEntity> materialEntityList) {
        if (materialEntityList != null && materialEntityList.size() > 0) {
            List<String> codes = new ArrayList<>();
            materialEntityList.stream().forEach(materialEntity -> {
                if (materialEntity.getCropName() != null && !materialEntity.getCropName().equals("")) {
                    codes.add(materialEntity.getCropName());
                }
            });


            HashSet<String> set = new HashSet<>(codes);

            // Create ArrayList from the set.
            ArrayList<String> result = new ArrayList<>(set);
            Collections.sort(result);


            List<String> codes3 = new ArrayList<String>();

            codes3.add("Please Select");
            for (int j = 0; j < result.size(); j++) {

                String codes2 = result.get(j);
                codes3.add(codes2);

            }


            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
            adapter1.setDropDownViewResource(R.layout.spinner_item);
            spCropName.setAdapter(adapter1);


            spCropName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // Get select item
                    if ("Please Select".equals(spCropName.getSelectedItem().toString())) {

                    } else {
                        sCropName = spCropName.getSelectedItem().toString();
                        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                            getVarietyDetails();
                            sCropCode = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).materialDao().getCropCodeByCropName(sCropName);

                            if (appSharedPreferences.getDivision().equalsIgnoreCase("FC") && sSeasonCode.trim().length() > 0) {
                                SetTextSeasonName();
                            }
                        });

                    }


                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }

            });

        }
    }


    public void getItemNameFromDB() {
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<MaterialEntity> allMaterials = SalesIndentDataBase.getDataBase(this).materialDao().getAllItemNameDetails(sCropName, sVarietyName);
            runOnUiThread(() -> showMaterialAsItemNameOnView(allMaterials));
        });
//        if (isTableExists(dbGetmaster, "InventMaster")) {
//
//            // private final String MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";
//
//            // db.rawQuery(MY_QUERY, new String[]{String.valueOf(propertyId)});
//
//            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from InventMaster  where Hybridname='" + Hybrids + "'", null);
//
//
//            if (GetCursorOrderDetails.moveToFirst()) {
//
//                do {
//
//                    PriceCheckItems1 = GetCursorOrderDetails.getString(2);
//
//                    //GetPriceCheckItem();
//
//                    // if( PriceCheckItems1.equals(PriceCheckItems2)) {
//
//
//                    codes.add(new String(GetCursorOrderDetails.getString(2)));
//
//                }
//                while (GetCursorOrderDetails.moveToNext());
//
//            }
//            // closing connection
//            //  c.close();
//            // db.close();
//        }


    }

    private void showMaterialAsItemNameOnView(List<MaterialEntity> materialEntityList) {

        if (materialEntityList != null && materialEntityList.size() > 0) {

            List<String> codes = new ArrayList<String>();

            materialEntityList.stream().forEach(materialEntity -> {
                        if (materialEntity.getMaterialName() != null && !materialEntity.getMaterialName().equals("")) {
                            codes.add(materialEntity.getMaterialName());
                        }
                    }
            );


            HashSet<String> set = new HashSet<>(codes);

            // Create ArrayList from the set.
            ArrayList<String> result = new ArrayList<>(set);


            Collections.sort(result);


            List<String> codes3 = new ArrayList<String>();


            codes3.add("Please Select");
            for (int j = 0; j < result.size(); j++) {

                String codes2 = result.get(j);
                codes3.add(codes2);

            }

            ArrayAdapter<String> iteNameAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
            iteNameAdapter.setDropDownViewResource(R.layout.spinner_item);
            spItemName.setAdapter(iteNameAdapter);

            iteNameAdapter.notifyDataSetChanged();

            spItemName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // Get select item

                    if (spItemName.getSelectedItemPosition() == 0) {
                        etQtyInKgs.setText("");
                        Remarks_feild.setText("");
                        etQtyInKgs.setEnabled(false);
                        Remarks_feild.setEnabled(false);

                    } else {
                        sMaterialName = spItemName.getSelectedItem().toString();
                        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                            sMaterialCode = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).materialDao().getItemCodeByItemName(sMaterialName);
                            sBaseUom = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).materialDao().getBaseUOMByItemName(sMaterialName);
                            sPackingQuantity = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).materialDao().getPackingQuantityByItemName(sMaterialName);
                        });


                        etQtyInKgs.setEnabled(true);
                        Remarks_feild.setEnabled(true);
                        etQtyInKgs.setText("");
                        Remarks_feild.setText("");
                    }


                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }

            });


        }
    }

//    public void getingtemidintiall() {
//        //item nae
//        final String[] itemnameee = {
//
//                "Please Select"
//
//
//        };
//        ArrayAdapter<String> itemnameeeadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, itemnameee);
//        itemnameeeadapter.setDropDownViewResource(R.layout.spinner_item);
//        itemNameSpinner.setAdapter(itemnameeeadapter);
//
//
//        itemNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                // Get select item
//
//                if (itemNameSpinner.getSelectedItemPosition() == 0) {
//                    etQtyInKgs.setText("");
//                    Remarks_feild.setText("");
//                    etQtyInKgs.setEnabled(false);
//                    Remarks_feild.setEnabled(false);
//
//                } else {
//                    spItemNameSelected = itemNameSpinner.getSelectedItem().toString();
//                    SalesIndentDataBase.databaseWriteExecutor.execute(() ->
//                            sBaseUom = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).materialDao().getMaterialEntityDetails(spItemNameSelected).getBaseUom());
//
//                    etQtyInKgs.setEnabled(true);
//                    Remarks_feild.setEnabled(true);
//                    etQtyInKgs.setText("");
//                    Remarks_feild.setText("");
//
////                    ItemNameGet();
////                    GetPktSize();
//
////                    GetPackageID();
//
//
//                }
//
//
//            }
//
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//
//        });
//
//    }

    public void GetPackageID() {
        String check = "";


        List<String> codes = new ArrayList<String>();
        List<String> codes11 = new ArrayList<String>();


        if (isTableExists(dbGetmaster, "InventMaster")) {

            // private final String MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";

            // db.rawQuery(MY_QUERY, new String[]{String.valueOf(propertyId)});

            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from InventMaster  where ItemName='" + sMaterialName + "'", null);


            if (GetCursorOrderDetails.moveToFirst()) {

                do {

                    //  PriceCheckItems1 = GetCursorOrderDetails.getString(6);

                    codes.add(new String(GetCursorOrderDetails.getString(6)));

                    codes11.add(new String(GetCursorOrderDetails.getString(1)));

                    //   }


                } while (GetCursorOrderDetails.moveToNext());

            }
            // closing connection
            //  c.close();
            // db.close();


        }


        HashSet<String> set = new HashSet<>(codes);
        HashSet<String> set11 = new HashSet<>(codes11);

        // Create ArrayList from the set.
        ArrayList<String> result = new ArrayList<>(set);
        ArrayList<String> result11 = new ArrayList<>(set11);
        //Comparator mycomparator = Collections.reverseOrder();
        //Collections.sort(result,mycomparator);

        Collections.sort(result);
        Collections.sort(result11);


        List<String> codes3 = new ArrayList<String>();
        List<String> codes311 = new ArrayList<String>();


        codes3.add("Please Select");
        codes311.add("Please Select");


        for (int j = 0; j < result.size(); j++) {

            String codes2 = result.get(j);
            codes3.add(codes2);


        }

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
        Log.d("skdmskmsmdsd", "oksodkwew" + sMaterialName);


        PackagingIDsend = codes3.get(1);
        Itemnametosend = sMaterialName;
        ItemIDtosend = codes311.get(1);


        GetPktSize();
        Log.d("kskdslkdlsdsd", "oiwiwiwiw" + PackagingIDsend);
        Log.d("kskdslkdlsdsd", "oiwiwiwiw" + Itemnametosend);
        Log.d("kskdslkdlsdsd", "oiwiwiwiw" + ItemIDtosend);

//        etQtyInKgs.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                          int arg3) {
//            }
//
//            @Override
//            public void afterTextChanged(final Editable arg0) {
//
//                try {
//                    // final String PkgSize2 = PkgSize.getSelectedItem().toString();
//                    final String PkgSize2 = kgorgms;
//
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        public void run() {
//                            try {
//                                double qty2 = Double.parseDouble(arg0.toString());
//                                if (!calc(qty2, PkgSize2)) {
//                                    etQtyInKgs.setError("Wrong Quantity");
////                                    Toast.makeText(TMSalesIndentActivity.this, "Please enter correct qty in count of "+int_size, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (Exception e) {
//                                Log.e("RBM", "error " + e.toString());
//                            }
//                        }
//                    }, 500);
//                } catch (Exception e) {
//                    Log.e("TAG", e.toString());
//                }
//            }
//        });


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


        Log.d("getinggggggg", "----------full--" + codes2.get(0));
        Log.d("getinggggggg", "----------back--" + codes2.get(1));
        Log.d("getinggggggg", "----------front--" + codes2.get(2));

        Descriptiontosend = codes2.get(0);
        UnitIDtosend = codes2.get(1);
        kgorgms = codes2.get(2);

        Log.d("Unitidd-----", "lpalsplaps------" + UnitIDtosend);
        Log.d("Unitidd-----", "lpalsplaps------" + kgorgms);


    }


    public void checkEmptyFiledAndAddDataToDB(View view) {


        String CustomerName2 = autoTextCustomerAccount.getText().toString();

        String CropNames2 = sCropName;
        String sVarietyName;

        sVarietyName = spVarietyName.getSelectedItem().toString();
        sVarietyNames = spVarietyName.getSelectedItem().toString();

        CropNames2 = spCropName.getSelectedItem().toString();
        sCropName = spCropName.getSelectedItem().toString();



        String Itemname2 = spItemName.getSelectedItem().toString();

        Log.d("Stringgsssss", "==================" + Itemname2);
        Log.d("Stringgsssss", "==================" + sVarietyName);
        Log.d("SeasonCode", "==================" + sSeasonCode);


        String sQty = etQtyInKgs.getText().toString();
        double dQty = 0.0;
        try {
            dQty = Double.parseDouble(etQtyInKgs.getText().toString());
        } catch (Exception e) {
            dQty = 0.0;
        }

        if(appSharedPreferences.getDivision().equalsIgnoreCase("FC")){
            if(sSeasonCode !=null && !sSeasonCode.equals("")){

            }
            else {
                Toast.makeText(getApplicationContext(), "Please Select Season", Toast.LENGTH_LONG).show();
                prgDialog.hide();
                return;

            }
        }

        if (autoTextCustomerAccount.getText().toString().trim().length() > 0) {

            if (CustomerName2.trim().length() > 0) {

                if (!CropNames2.equals("Please Select")) {



                    if (!sVarietyName.equals("Please Select")) {


                        if (!Itemname2.equals("Please Select")) {

                            if (sBaseUom.equalsIgnoreCase("KG")) {
                                if (sQty.trim().length() > 0 && calculateQuantityInKg(dQty)) {
                                    IndentCodeUpdate();

                                    Handler handler = new Handler();
                                    handler.postDelayed(() -> addSalesIndentDataIntoDB(), 30);


                                    Handler handler2 = new Handler();
                                    handler2.postDelayed(() -> displayLineData(), 50);
                                } else {
                                    etQtyInKgs.setError("wrong QTY entered");
                                    Toast.makeText(getApplicationContext(), "wrong QTY entered", Toast.LENGTH_LONG).show();

                                }
                            } else if (sBaseUom.equalsIgnoreCase("PAK") || sBaseUom.equalsIgnoreCase("EA")) {
                                if (sQty.trim().length() > 0 && !sQty.contains(".")) {
                                    IndentCodeUpdate();

                                    Handler handler = new Handler();
                                    handler.postDelayed(() -> addSalesIndentDataIntoDB(), 30);


                                    Handler handler2 = new Handler();
                                    handler2.postDelayed(() -> displayLineData(), 50);
                                } else {
                                    etQtyInKgs.setError("No decimals were allowed");
                                    Toast.makeText(getApplicationContext(), "You can not add decimal number", Toast.LENGTH_LONG).show();
                                }

                            }

                        } else {

                            Toast.makeText(getApplicationContext(), "Please Select item name", Toast.LENGTH_LONG).show();
                            prgDialog.hide();

                        }
                    } else {

                        Toast.makeText(getApplicationContext(), "Please Select Hybrid", Toast.LENGTH_LONG).show();
                        prgDialog.hide();

                    }

                } else {

                    Toast.makeText(getApplicationContext(), "Please Select Crop Name", Toast.LENGTH_LONG).show();
                    prgDialog.hide();

                }


            } else {

                Toast.makeText(getApplicationContext(), "Customer Name Must be filled", Toast.LENGTH_LONG).show();
                prgDialog.hide();


            }


        } else {

            Toast.makeText(getApplicationContext(), "Please Select Customer Account", Toast.LENGTH_LONG).show();
            prgDialog.hide();


        }


    }

    private boolean calculateQuantityInKg(double qty) {
        if (sPackingQuantity != null && !sPackingQuantity.equals("")) {
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
        try {
            int_size = Integer.parseInt(kgorgms);
        } catch (NumberFormatException e) {
            int_size = Float.parseFloat(kgorgms);

        }


//        if (UnitIDtosend.contains("K") || UnitIDtosend.contains("k")){
        if (UnitIDtosend.equals("Kg") || UnitIDtosend.equals("kg")) {
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
        } else if (UnitIDtosend.equals("Pkt") || UnitIDtosend.equals("pkt")) {
            int_type = " Kgs";

            if ((qty2 - (int) qty2) != 0) {
                return false;
            } else {
                float result = (float) (qty2) % int_size;

                if (result == 0) {
                    return true;
                }
            }
        } else {
            int_type = " gms";
            int_size = Integer.parseInt(kgorgms);
            float gm_value = Float.parseFloat(int_size + "");

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
        return false;
    }


    private void IndentCodeUpdate() {

        IndentCodeFinal = "00001";

//        if (!ISIndentCodeFile.exists()) {
//
//
//
//        } else {
//
//            try {
//
//                Check = "";
//
//                //create BufferedReader to read csv file
//                BufferedReader brs = new BufferedReader(new FileReader(ISIndentCodeFile));
//                String line = "";
//
//
//                int lineNumber = 0;
//
//                //read comma separated file line by line
//                while ((line = brs.readLine()) != null) {
//                    lineNumber++;
//
//
//                    //use comma as token separator
//                    String[] Infile = line.split(",");
//
//
//                    IndentCodeFinal = Infile[0].trim().toString();
//
//
//                }
//
//
//                brs.close();
//
//            } catch (Exception e) {
//                System.err.println("CSV file cannot be read : " + e);
//            }
//            Log.e("SAles Indent", "before " + IndentCodeFinal);
//            Integer EventCodes = Integer.parseInt(IndentCodeFinal.trim().toString()) + 1;
//            DecimalFormat formatter = new DecimalFormat("00000");
//            String aFormatted = formatter.format(EventCodes);
//            String EventCodeCheck = aFormatted.toString();
//
//            IndentCodeFinal = EventCodeCheck;
//
//            Log.e("SAles Indent", "after " + IndentCodeFinal);
//
//
//        }


    }


    public void getVarietyDetails() {


        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<MaterialEntity> materialEntityList = SalesIndentDataBase.getDataBase(this).materialDao().getAllVarietyDetails(sCropName);
            runOnUiThread(() -> showVarietyDetails(materialEntityList));
        });


//        if (isTableExists(dbGetmaster, "InventMaster")) {
//
//            // private final String MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";
//
//            // db.rawQuery(MY_QUERY, new String[]{String.valueOf(propertyId)});
//
////            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from ItemMaster  where CropName='" + CropNames  + "'", null);
//            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from InventMaster  where CropName='" + CropNames + "'", null);
//
//            if (GetCursorOrderDetails.moveToFirst()) {
//                do {
//                    PriceCheckItems1 = GetCursorOrderDetails.getString(2);
//
//                    codes.add(new String(GetCursorOrderDetails.getString(5)));
//
//                } while (GetCursorOrderDetails.moveToNext());
//
//            }
//        }


    }


    private void showVarietyDetails(List<MaterialEntity> materialEntityList) {
        if (materialEntityList != null && materialEntityList.size() > 0) {
            List<String> codes = new ArrayList<String>();

            try {
                for (MaterialEntity materialEntity : materialEntityList) {
                    if (materialEntity.getVarietyName() != null && !materialEntity.getVarietyName().equals("")) {
                        codes.add(materialEntity.getVarietyName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            HashSet<String> set = new HashSet<>(codes);
            ArrayList<String> result = new ArrayList<>(set);
//            Collections.sort(result);
            List<String> codes3 = new ArrayList<String>();
            codes3.add("Please Select");
            for (int j = 0; j < result.size(); j++) {

                String codes2 = result.get(j);
                codes3.add(codes2);

            }
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
            adapter1.setDropDownViewResource(R.layout.spinner_item);
            spVarietyName.setAdapter(adapter1);


            spVarietyName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // Get select item


                    String UnitIds2 = spVarietyName.getItemAtPosition(position).toString();


                    if ("Please Select".equals(spVarietyName.getSelectedItem().toString())) {
                        spVarietyName.setSelection(0);
//                                etQtyInKgs.setText("");
//                                Remarks_feild.setText("");
//
//                                etQtyInKgs.setEnabled(false);
//                                Remarks_feild.setEnabled(false);

                    } else {
                        sVarietyName = spVarietyName.getSelectedItem().toString();
                        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                            getItemNameFromDB();
                            sVarietyCode = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).materialDao().getVarietyCodeByVarietyName(sVarietyName);
                        });

                    }


                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }

            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tmsales_indent, menu);
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


    } */


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }


    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        pDateSetListener,
                        pYear, pMonth, pDay);

        }
        return null;
    }


    public void CloseActivity(View view) {
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        // TODO Auto-generated method stub
        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }


    public void SetTextSeasonName() {

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            seasonEntity = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).seasonDao().getSeasonBySeasonCode(sSeasonCode,sCropCode,customerEntity.getStateId());
        });
    }


    private void addSalesIndentDataIntoDB() {

        String CustomerName2 = sCustomerName;

        String sQty = etQtyInKgs.getText().toString();
        String Remarks = Remarks_feild.getText().toString();

        String ExpectedDate2 = ExpectedDate.getText().toString();


        Calendar cal = Calendar.getInstance();

        SimpleDateFormat Year = new SimpleDateFormat("yy");

        String YearCode = Year.format(cal.getTime());


        IndentCreationCode = POCodeGet + "-S" + YearCode + IndentCodeFinal;


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");


        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");

        String strDate, strTime, strdatetime;


        DecimalFormat formatter = new DecimalFormat("0.00");
        // Double OrderValueTot = Double.valueOf(formatter.format(Double.parseDouble(Qty2)*Double.parseDouble(SalPrice))) ;
        Double OrderValueTot = 0.00;


        strDate = sdf5.format(cal.getTime());
        strTime = sdf1.format(cal.getTime());
        strdatetime = sdf2.format(cal.getTime());
        String[] ware_house = appSharedPreferences.get_warehouseTM().split("!");


////        CustomerName2 = CustomerName2.replace("'", "''");
//        String query = "INSERT INTO SalesIndentDetailsTemp (IndentNo,IndentDate,IndentTime,CustCode,CustName,CropName,CropType,ItemID,ItemName,IndentQty,Site,Warehouse,ExpectedDate,SalesPrice,LineAmount,PackingId ,Description ,UnitID , Remarks ) " +
//                "VALUES('" + IndentCreationCode.trim() + "','" + strDate + "','" + strTime + "','" + sCustomerCode + "','"
//                + CustomerName2 + "','" + sCropName + "','" + sVarietyNames + "','" + ItemIDtosend + "','" + sMaterialName + "','"
//                + sQty.trim() + "','" + appSharedPreferences.get_siteTM() + "','" +
//                ware_house[0] + "','" + ExpectedDate2 + "','" +
//                SalPrice + "','" + OrderValueTot + "','" +
//                PackagingIDsend + "','" + Descriptiontosend + "','" + UnitIDtosend + "','" + Remarks + "');";
////        dbSalesIndent.execSQL(query);
//        Log.e("insert", query);

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            SalesIndentDetailsTmpEntity tmpEntity = new SalesIndentDetailsTmpEntity();
            tmpEntity.setIndentNo(IndentCreationCode.trim());
            tmpEntity.setIndentDate(strDate);
            tmpEntity.setIndentTime(strTime);
            tmpEntity.setCustomerCode(sCustomerCode);
            tmpEntity.setCustomerName(sCustomerName);
            tmpEntity.setCropName(sCropName);
            tmpEntity.setCropCode(sCropCode);
            tmpEntity.setSeasonCode(sSeasonCode);
            tmpEntity.setVarietyName(sVarietyNames);
            tmpEntity.setVarietyCode(sVarietyCode);
            tmpEntity.setVarietyCode(sVarietyCode);
            tmpEntity.setMaterialName(sMaterialName);
            tmpEntity.setMaterialCode(sMaterialCode);
            tmpEntity.setPackingQuantity(sPackingQuantity);
            tmpEntity.setQuantityInKgsOrPackets(sQty.trim());
            if (sBaseUom.equalsIgnoreCase("KG")) {
                tmpEntity.setRequiredQuantityInKgs(sQty.trim());
            } else {
                tmpEntity.setNoOfPacketsRequired(sQty.trim());
            }

            tmpEntity.setTiRemarks(Remarks);

            SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentTmpDao().insertAll(tmpEntity);
            Log.d("Temp Sales Indent Request Details From DB", SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentTmpDao().getAllSalesIndentTmp().toString());
        });


    }


    public void displayLineData() {

        salesIndentLineListView.setAdapter(null);
        SerialLists.removeAll(SerialLists);
        VarietyLists.removeAll(VarietyLists);
        QtyLists.removeAll(QtyLists);
        remarks_listss.removeAll(remarks_listss);
        SerialNo = 1;
        salesIndentLineListView.removeHeaderView(headerView);


        headerView = ((LayoutInflater) TMSalesIndentActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.lineheader, null, false);
        salesIndentLineListView.addHeaderView(headerView);
        etQtyInKgs.setText("");
        QtyInBag.setText("");
        Remarks_feild.setText("");


        spCropName.setSelection(0);
        spVarietyName.setSelection(0);
        PkgSize.setSelection(0);
        spItemName.setSelection(0);


        String check = "";


        List<String> codes = new ArrayList<String>();
        codes.add("Please Select");

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<SalesIndentDetailsTmpEntity> tmpEntityList = SalesIndentDataBase.getDataBase(this).salesIndentTmpDao().getAllSalesIndentTmp();

            Log.d("Temp Sales Indent Request Details From display line data", tmpEntityList.toString());

            if (tmpEntityList != null && tmpEntityList.size() > 0) {
                Log.d("Temp Sales Indent Request Details From display line data size ", tmpEntityList.size() + "");

                for (SalesIndentDetailsTmpEntity tmpEntity : tmpEntityList) {
                    if (tmpEntity.getIndentNo().equals(IndentCreationCode)) {
                        SerialLists.add(SerialNo.toString());
//                        VarietyLists.add(cScanDetails.getString(8));
                        VarietyLists.add(tmpEntity.getMaterialName());
                        QtyLists.add(tmpEntity.getQuantityInKgsOrPackets());

                        remarks_listss.add(tmpEntity.getTiRemarks());


                        SerialList = new String[SerialLists.size()];
                        VarietyList = new String[VarietyLists.size()];
                        QtyList = new String[QtyLists.size()];

                        remarks_list = new String[remarks_listss.size()];


                        SerialNo = SerialNo + 1;
                    }
                }

                for (int j = 0; j < VarietyLists.size(); j++) {
                    // Get the path of the image file
                    SerialList[j] = SerialLists.get(j);
                    VarietyList[j] = VarietyLists.get(j);
                    QtyList[j] = QtyLists.get(j);
                    remarks_list[j] = remarks_listss.get(j);

                }

                runOnUiThread(() -> {
                    SalesIndentLineListAdapter myListAdapter = new SalesIndentLineListAdapter();
                    salesIndentLineListView.setAdapter(myListAdapter);
                    setListViewHeightBasedOnItems(salesIndentLineListView);
                });
            }
        });


//        if (isTableExists(dbSalesIndent, "SalesIndentDetailsTemp")) {
//
//            cScanDetails = dbSalesIndent.rawQuery("select * from SalesIndentDetailsTemp", null);
//
//            if (cScanDetails.moveToFirst()) {
//
//                do {
//
//                    if (cScanDetails.getString(1).equals(IndentCreationCode)) {
//
//
//                        SerialLists.add(SerialNo.toString());
////                        VarietyLists.add(cScanDetails.getString(8));
//                        VarietyLists.add(cScanDetails.getString(9));
//                        QtyLists.add(cScanDetails.getString(10));
//
//                        remarks_listss.add(cScanDetails.getString(19));
//
//
//                        SerialList = new String[SerialLists.size()];
//                        VarietyList = new String[VarietyLists.size()];
//                        QtyList = new String[QtyLists.size()];
//
//                        remarks_list = new String[remarks_listss.size()];
//
//
//                        SerialNo = SerialNo + 1;
//
//                    }
//
//
//                } while (cScanDetails.moveToNext());
//            }
//
//
//        }


    }


    private class SalesIndentLineListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (VarietyList != null && VarietyList.length != 0) {
                return VarietyList.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return VarietyList[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //ViewHolder holder = null;
            final ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = TMSalesIndentActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.linedatalist, null);

                holder.SList = convertView.findViewById(R.id.textView1);
                holder.VList = convertView.findViewById(R.id.textView2);
                holder.Quantity = convertView.findViewById(R.id.textView3);
                holder.remarks = convertView.findViewById(R.id.edittext_remarks);


                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;


            holder.SList.setText(SerialList[position]);
            holder.VList.setText(VarietyList[position]);
            holder.Quantity.setText(QtyList[position]);

            holder.remarks.setText(remarks_list[position]);


            //for managing the state of the boolean
            //array according to the state of the
            //CheckBox


            holder.SList.addTextChangedListener(new TextWatcher() {

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


                    SerialList[holder.ref] = arg0.toString();


                }
            });


            holder.VList.addTextChangedListener(new TextWatcher() {

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


                    VarietyList[holder.ref] = arg0.toString();


                }
            });

            holder.Quantity.addTextChangedListener(new TextWatcher() {

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


                    QtyList[holder.ref] = arg0.toString();


                }
            });

            holder.remarks.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    remarks_list[holder.ref] = editable.toString();
                }
            });


            return convertView;
        }


        private class ViewHolder {

            TextView SList;
            TextView VList;
            TextView Quantity;
            TextView remarks;

            int ref;


        }

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


    public void salesIndentRequestSaveData(View view) {

        LineNo = 1;
        fetchDataForTmpTable();

    }


    private void fetchDataForTmpTable() {
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<SalesIndentDetailsTmpEntity> tmpEntityList = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentTmpDao().getAllSalesIndentTmp();
            if (tmpEntityList != null && tmpEntityList.size() > 0) {
                ZOrganogramResponseDetails zOrganogramDetails = SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).zOrganogramDetailsDao().getZOrganogramDetailsByUserId(appSharedPreferences.getUserId());
                for (SalesIndentDetailsTmpEntity detailsTmpEntity : tmpEntityList) {

                    SalesIndentRequestDetailsEntity requestDetails = new SalesIndentRequestDetailsEntity();
                    requestDetails.setIndentNo(detailsTmpEntity.getIndentNo());
                    requestDetails.setIndentDate(detailsTmpEntity.getIndentDate());
                    requestDetails.setIndentTime(detailsTmpEntity.getIndentTime());
                    if (customerEntity != null) {
                        requestDetails.setSaleOrganization(customerEntity.getSalesOrganization());
                        requestDetails.setDistributionChannel(customerEntity.getDistributionChannel());
                        requestDetails.setDivision(customerEntity.getDivision());
                        requestDetails.setCustomerStateId(customerEntity.getStateId());
                        requestDetails.setSalesOffice(customerEntity.getSales_office());
                    }
                    requestDetails.setCustomerCode(detailsTmpEntity.getCustomerCode());
                    requestDetails.setCustomerName(detailsTmpEntity.getCustomerName());
                    requestDetails.setCropCode(detailsTmpEntity.getCropCode());
                    requestDetails.setCropName(detailsTmpEntity.getCropName());
                    requestDetails.setSeasonCode(detailsTmpEntity.getSeasonCode());
                    if (seasonEntity != null) {
                        requestDetails.setSeasonStartingDate(seasonEntity.getSeasonStartDate());
                        requestDetails.setSeasonEndDate(seasonEntity.getSeasonEndDate());
                        requestDetails.setReturnCutOffDate(seasonEntity.getReturnCutOffDate());
                    }
                    requestDetails.setVarietyCode(detailsTmpEntity.getVarietyCode());
                    requestDetails.setVarietyName(detailsTmpEntity.getVarietyName());
                    requestDetails.setBaseUom(sBaseUom);
                    requestDetails.setPackingQuantity(detailsTmpEntity.getPackingQuantity());
                    requestDetails.setQuantityInKgsOrPackets(detailsTmpEntity.getQuantityInKgsOrPackets());
                    requestDetails.setRequiredQuantityInKgs(detailsTmpEntity.getRequiredQuantityInKgs());
                    requestDetails.setNoOfPacketsRequired(detailsTmpEntity.getNoOfPacketsRequired());
                    requestDetails.setIndentOverAllStatus("PENDING");
                    requestDetails.setLineItemNo(String.valueOf(LineNo));
                    requestDetails.setMaterialCode(detailsTmpEntity.getMaterialCode());
                    requestDetails.setMaterialName(detailsTmpEntity.getMaterialName());

                    if (zOrganogramDetails != null) {
                        requestDetails.setPlant(zOrganogramDetails.getPlant());
                        requestDetails.setTerritoryId(zOrganogramDetails.getTerritoryId());
                        requestDetails.setTerritoryName(zOrganogramDetails.getTerritoryName());
                        requestDetails.setTiId(zOrganogramDetails.getInChargeT());
                        requestDetails.setTiName(zOrganogramDetails.getTiName());
                        requestDetails.setTiQuantity(detailsTmpEntity.getPackingQuantity());
                        requestDetails.setTiRemarks(detailsTmpEntity.getTiRemarks());
                        requestDetails.setSalesRegionId(zOrganogramDetails.getRegion());
                        requestDetails.setSalesRegionName(zOrganogramDetails.getRegionName());
                        requestDetails.setRbmId(zOrganogramDetails.getRbm());
                        requestDetails.setAmId(zOrganogramDetails.getAreaManager());
                        requestDetails.setAmName(zOrganogramDetails.getAreaManagerName());
                        requestDetails.setDbmId(zOrganogramDetails.getDbm());
                        requestDetails.setRbmName(zOrganogramDetails.getRbmName());
                        requestDetails.setDbmName(zOrganogramDetails.getDbmName());
                        requestDetails.setRbmQuantity(null);
                        requestDetails.setAmQty(null);
                        requestDetails.setSalesDivisionId(zOrganogramDetails.getSalesDivision());
                        requestDetails.setSalesDivisionName(zOrganogramDetails.getSalesDivisionName());
                    }

                    requestDetails.setRbmApprovalStatus("PENDING");
                    requestDetails.setDbmApprovalStatus("PENDING");
                    requestDetails.setAmApprovalStatus("PENDING");

                    SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentDetailsDao().insertAll(requestDetails);
                    LineNo = LineNo + 1;
                }

                Log.d("Request Data save into DB", SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentDetailsDao().getAllSalesIndentRequestDetails().toString());
                SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentTmpDao().deleteAllSalesIndentTmpDetails();
                runOnUiThread(() -> {
                    etQtyInKgs.setText("");
                    Remarks_feild.setText("");

                    spCropName.setSelection(0);
                    spVarietyName.setSelection(0);
                    PkgSize.setSelection(0);
                    sCustomerCode = "";
                    salesIndentLineListView.setAdapter(null);
                    SerialLists.removeAll(SerialLists);
                    VarietyLists.removeAll(VarietyLists);
                    QtyLists.removeAll(QtyLists);
                    remarks_listss.removeAll(remarks_listss);
                    salesIndentLineListView.removeHeaderView(headerView);

                    Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();

                    Focusfirst.setFocusable(true);
                    Focusfirst.setFocusableInTouchMode(true);
                    Focusfirst.requestFocus();
                });


            } else {

                runOnUiThread(() -> Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_LONG).show());
            }

        });

    }


    private void ExcelSaveLineData() {


        DecimalFormat formatter = new DecimalFormat("0.00");
        // Double OrderValueTot = Double.valueOf(formatter.format(Double.parseDouble(Qty2Temp)*Double.parseDouble(SalPriceTemp))) ;

        Double OrderValueTot = 0.00;


        CustomerName2Temp = CustomerName2Temp.replace("'", "''");
        createTableSalesIndentDetails();
        String query = "INSERT INTO SalesIndentDetails(IndentNo,LineNum,IndentDate,IndentTime,CustCode,CustName,CropName,CropType,ItemID,ItemName,IndentQty,Territory,StateCode,Region,TMCode,Site,Warehouse,ExpectedDate,TMId,SalesPrice,LineAmount,PackingId ,Description ,UnitID, Remarks) VALUES('" + IndentCreationCodeTemp + "','" + LineNo + "','" + strDateTemp + "','" + strTimeTemp + "','" + CustomerAccountsTemp + "','" + CustomerName2Temp + "','" + CropNamesTemp + "','" + CropTypesTemp + "','" + ItemIDtosendTemp + "','" + ItemNamesTemp + "','" + Qty2Temp + "','" + POTerritory + "','" + PoState + "','" + PoRegion + "','" + POCodeGet + "','" + SitesTemp + "','" + WarehouseTemp + "','" + ExpectedDateTemp + "','" + SiteGet + "','" + SalPriceTemp + "','" + OrderValueTot + "','" + PackagingIDsendTemp + "','" + DescriptiontosendTemp + "','" + UnitIDtosendTemp + "','" + RemarksTemp + "')";
        dbSalesIndent.execSQL(query);
        Log.e("insert1", query);

        LineNo = LineNo + 1;

        IndentCreationCodeTemp = "";
        strDateTemp = "";
        strTimeTemp = "";
        CustomerAccountsTemp = "";
        CustomerName2Temp = "";
        CropTypesTemp = "";
        CropNamesTemp = "";
        HybridsTemp = "";
        Qty2Temp = "";

        SitesTemp = "";
        WarehouseTemp = "";
        ExpectedDateTemp = "";
        SalPriceTemp = "";
        PkgSizesTemp = "";
        PkgNameTemp = "";
        UomValueTemp = "";
        ItemIDtosendTemp = "";
        PackagingIDsendTemp = "";

        UnitIDtosendTemp = "";
        DescriptiontosendTemp = "";
        RemarksTemp = "";


    }


    /**
     * Function to display simple Alert Dialog
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param status  - success/failure (used to set icon)
     */
    public void showAlertDialogError(Context context, String title, String message, Boolean
            status) {
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


    public void showAlertDialogWarning(Context context, String title, String message, Boolean
            status) {
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


        finish();


    }


    private void DeleteGetMasterDatabase() {


        String DATABASE_TABLE_CustMaster = "CustMaster".toString();
        String DATABASE_TABLE_ItemMaster = "ItemMaster".toString();
        String DATABASE_TABLE_CropMaster = "CropMaster".toString();
        String DATABASE_TABLE_SeedProcessPackingTable = "SeedProcessPackingTable".toString();
        String DATABASE_TABLE_PriceDiscMaster = "PriceDiscMaster".toString();
        String DATABASE_TABLE_InventMaster = "InventMaster".toString();


        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_CustMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_ItemMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_CropMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SeedProcessPackingTable + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_PriceDiscMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_InventMaster + "'");


    }

    protected void createTableSalesIndentDetails() {

//idcodeinsert
        //dsdsd
        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentDetails(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR,LineNum REAL,IndentDate DATETIME, IndentTime VARCHAR, CustCode VARCHAR ,CustName VARCHAR,CropType VARCHAR,CropName VARCHAR, ItemID VARCHAR,ItemName VARCHAR,IndentQty REAL,Territory VARCHAR, StateCode VARCHAR,Region VARCHAR,TMCode VARCHAR,Site VARCHAR,Warehouse VARCHAR,ExpectedDate DATETIME, TMId VARCHAR,SalesPrice REAL,LineAmount REAL,PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,Remarks VARCHAR);");//Remarks


    }


    protected void createTableSalesIndentDetailsTemp() {
//idcodeinsert

        //remarks inserted
        dbSalesIndent.execSQL("CREATE TABLE IF NOT EXISTS SalesIndentDetailsTemp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IndentNo VARCHAR ,IndentDate DATETIME, IndentTime VARCHAR, CustCode VARCHAR ,CustName VARCHAR, CropType VARCHAR,CropName VARCHAR, ItemID VARCHAR,ItemName VARCHAR,IndentQty REAL,Site VARCHAR,Warehouse VARCHAR,ExpectedDate DATETIME,SalesPrice REAL,LineAmount REAL,PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,Remarks VARCHAR);");

    }

    private void DeleteSalesIndentDetails() {

        String DATABASE_TABLE_SalesIndentDetails = "SalesIndentDetails".toString();

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SalesIndentDetails + "'");


    }


    private void DeleteSalesIndentDetailsTemp() {

        String DATABASE_TABLE_SalesIndentDetailsTemp = "SalesIndentDetailsTemp".toString();

        dbSalesIndent.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SalesIndentDetailsTemp + "'");


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

}

