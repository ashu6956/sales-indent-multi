package com.agriscience.salesindent.storbm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.model.STOMaterialDetailsResponse;
import com.agriscience.salesindent.model.ZOrganogramResponseDetails;
import com.agriscience.salesindent.room_database.SalesIndentDataBase;
import com.agriscience.salesindent.room_database.entity.STOIndentTmpEntity;
import com.google.gson.Gson;

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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.R;

import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.PlantDetailsResponse;
import com.agriscience.salesindent.model.PlantResponse;
import com.agriscience.salesindent.model.STOMaterialResponse;
import com.agriscience.salesindent.model.SuccessResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockTransferCreateActivity extends AppCompatActivity {

    String Descriptiontosend = "";
    String UnitIDtosend = "";
    String weightinkgorgms = "";

    String PackagingIDsend = "";
    String Itemnametosend = "";
    String ItemIDtosend = "";

    String PackagingIDsend_ = "";
    String Descriptiontosend_ = "";
    String UnitIDtosend_ = "";


    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;

    // Connection detector class
    WIFIInternetConnectionDetector cd;

    String syninput1, POCodeGet, PONameGet, TerritoryNameGet, PostCodeTransferGet, SiteGet, DivisionGet, Acting, DCode, ProjectFolder,
            crossyndata, myJSON, TAG = "Stocktransfercreate", from_ware_id, sToPlant, sCropName, sVarityName, ItemName, to_ware_id,
            sFromPlant, st_exp_date, packing_size, QtyInKgs, IndentCodeFinal, IndentCreationCode, ResponseCheckLine,
            btn_click = "0", UomValueCheck, PkgName, packing_id, old_indent_no = "", notify = "1";
    String IPAddress = "http://103.44.97.110:8080/kanagaraj/";
//    String IPAddress="http://192.168.35.24/hyveg/Sales_Indent_App/";

    private SQLiteDatabase dbGetmaster;
    JSONArray peoples = null;
    Context context = this;
    private static final String TAG_RESULTS = "result";

    private static final String T1 = "Id";
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

    String IndentCreationCode_;
    String IndentCodeFinal_;
    String from_ware_id_;
    String from_ware_name_;
    String to_ware_name_;
    String to_ware_id_;
    String CropNames_;
    String CropType_;
    String st_exp_date_;
    String POCodeGet_;
    String SiteGet_;
    String packing_id_;
    String PkgName_;
    String UomValueCheck_;
    String QtyInKgs_;
    String Acting_;
    String DCode_;
    String ItemIDtosend_;
    String Itemnametosend_;
    String remarks_;


    String sItemName = "";
    String ItemName_togetId_ = "";

    float int_size = 0;
    String int_type = " Kgs";
    File Oroot = Environment.getExternalStorageDirectory(), Getmasterpath = null, ISIndentCodeFile = null, StockTransferPath = null;
    AutoCompleteTextView autoTextToPlant;
    ProgressDialog prgDialog;
    private Cursor GetWareHouseDetails;
    Spinner spFromPlant, spCropName, spVarityName, spItemName;
    Button btn_date;
    EditText etQtyKgPkts;
    ListView list;
    private Cursor GetCursorOrderDetails, cScanDetails;
    private SQLiteDatabase dbStockTransfer;
    List<String> SerialLists = new ArrayList<>();
    List<String> VarietyLists = new ArrayList<>();
    List<String> QtyLists = new ArrayList<>();
    List<String> remarks_listss = new ArrayList<>();

    private String[] SerialList;
    private String[] VarietyList;
    private String[] QtyList;
    private String[] remarks_list;

    int SerialNo = 1, LineNo = 1, totalcountPoevent = 0;
    View headerView;

    EditText etRemarks;

    private AppSharedPreferences appSharedPreferences;
    private ApiInterface apiInterface;

    private SalesIndentDataBase salesIndentDataBase;

    private String baseUOM = "";
    private String packageQuantity = "";

    private String itemWeight = "", noOfPackets = "";


    private String sCropCode = "", sVarityCode = "", sMaterialCode = "";
    private String sFromPlantCode,sToPlantCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocktransfercreate);
        appSharedPreferences = new AppSharedPreferences(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        salesIndentDataBase = SalesIndentDataBase.getDataBase(this);
        getSupportActionBar().hide();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            POCodeGet = extras.getString("Po_code");
            PONameGet = extras.getString("Po_name");
        }

        if (Oroot.canWrite()) {
            File dir = new File(Oroot.getAbsolutePath() + "/Android/SalesIndentHVG");
            dir.mkdirs();

            Getmasterpath = new File(dir, "SIGetmasterDB.db");

        }

        if (Oroot.canWrite()) {
            File dir = new File(Oroot.getAbsolutePath() + "/Android/SalesIndentHVG");
            dir.mkdirs();

            StockTransferPath = new File(dir, "STDetailsDB.db");

        }

        if (Oroot.canWrite()) {

            File dir = new File(Oroot.getAbsolutePath() + "/Android/SalesIndentHVG");
            dir.mkdirs();

            ISIndentCodeFile = new File(dir, "NumberSequence1.csv");
        }

        prgDialog = new ProgressDialog(this, R.style.StyledDialog);
        prgDialog.setMessage(" Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));
        autoTextToPlant = findViewById(R.id.autoTextToPlant);
        spFromPlant = findViewById(R.id.spFromPlant);
        spCropName = findViewById(R.id.SpCropName);
        spVarityName = findViewById(R.id.spVarietyName);
        spItemName = findViewById(R.id.spItemName);


        btn_date = findViewById(R.id.button);
        etQtyKgPkts = findViewById(R.id.etQtyKgPkts);
        list = findViewById(R.id.listView);
        etRemarks = findViewById(R.id.etRemarks);
        cd = new WIFIInternetConnectionDetector(getApplicationContext());

        callPlanDetailsApi();


        spFromPlant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sFromPlant = spFromPlant.getSelectedItem().toString();

                if (!"Please Select".equals(sFromPlant)) {
                    String[] split = sFromPlant.split("-");
                    sFromPlantCode =split[0];
                    showToPlantDataOnView();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });


        spCropName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sCropName = spCropName.getSelectedItem().toString();
                if (!"Please Select".equals(sCropName)) {
                    showVarityNameOnView();
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        sCropCode = salesIndentDataBase.stoMaterialDao().getCropCodeByCropName(sCropName);
                    });
                } else {
                    spVarityName.setSelection(0);
                    spItemName.setSelection(0);
                    etQtyKgPkts.setText("");
                    etRemarks.setText("");
                    btn_date.setText("SELECT DATE");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });

        String[] Hybrid = {
                "Please Select",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Hybrid);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spVarityName.setAdapter(adapter);
        spItemName.setAdapter(adapter);
        spCropName.setAdapter(adapter);
        spFromPlant.setAdapter(adapter);

        spVarityName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sVarityName = spVarityName.getSelectedItem().toString();
                if (!"Please Select".equals(sVarityName)) {
                    showItemNameOnView();
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        sVarityCode = salesIndentDataBase.stoMaterialDao().getVarietyCodeByVarietyName(sVarityName);
                    });

                } else {
                    spItemName.setSelection(0);
                    etQtyKgPkts.setText("");
                    etRemarks.setText("");
                    btn_date.setText("SELECT DATE");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });

        spItemName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get select item
                if ("Please Select".equals(spItemName.getSelectedItem().toString())) {
                    etQtyKgPkts.setText("");
                    etRemarks.setText("");
                    btn_date.setText("SELECT DATE");

                    // QtyInKgs.setEnabled(false);

                } else {
                    //  Toast.makeText(context, spin_pack_size.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                    sItemName = spItemName.getSelectedItem().toString();
                    etQtyKgPkts.setEnabled(true);
                    autoTextToPlant.setEnabled(false);
                    etQtyKgPkts.setText("");
                    etRemarks.setText("");
                    getBaseUOMAndPackingQty();

                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });


        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                etQtyKgPkts.clearFocus();
                inputMethodManager.showSoftInput(etQtyKgPkts, 1);
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                android.app.DatePickerDialog dpd = new android.app.DatePickerDialog(StockTransferCreateActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, ondate, year, month, day);
                DatePicker dp = dpd.getDatePicker();
                dp.setMinDate(c.getTimeInMillis());
                dpd.show();
            }
        });

        etQtyKgPkts.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(final Editable arg0) {

//                packing_size = spin_pack_size.getSelectedItem().toString();
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//                        try {
//                            double qty2 = Double.parseDouble(arg0.toString());
//
//                            if (!calc( qty2,packing_size)) {
//                                etQtyKgPkts.setError("Wrong Quantity");
//                                Toast.makeText(Stocktransfercreate.this, "Please enter correct qty in count of "+int_size, Toast.LENGTH_SHORT).show();
//                            }
//                        }catch (Exception e){
//                            Log.e("RBM","error "+e.toString());
//                        }
//
//
//                    }
//                }, 500);


                String sQty = arg0.toString();
                try {
                    if (sQty != null && !sQty.equals("")) {
                        double dQty = Double.parseDouble(sQty);
                        Handler handler = new Handler();
                        handler.postDelayed(() -> {

                            if (!baseUOM.isEmpty()) {
                                if (baseUOM.equalsIgnoreCase("KG") && calculateQuantityInKg(dQty)) {
                                    if (sQty.trim().length() > 0) {

                                    } else {
                                        etQtyKgPkts.setError("Wrong input Quantity entered");
                                        Toast.makeText(getApplicationContext(), "Wrong input Quantity entered", Toast.LENGTH_LONG).show();

                                    }
                                } else if (baseUOM.equalsIgnoreCase("PAK") || baseUOM.equalsIgnoreCase("EA")) {
                                    if (sQty.trim().length() > 0 && !sQty.contains(".")) {

                                    } else {
                                        etQtyKgPkts.setError("Enter quantity in Number’s no decimals were allowed");
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
    }

    private void calculateItemWeight(String qty) {
        if (!packageQuantity.equals("")) {
            try {

                int pkgQtyInGram = (int) (Double.parseDouble(packageQuantity) * 1000);

                Log.d("pkgQtyInGram", pkgQtyInGram + "");

                int etQtyInGram = (int) (Double.parseDouble(qty) * 1000);

                Log.d("etQtyInGram", etQtyInGram + "");

                if (baseUOM.equalsIgnoreCase("KG")) {
                    itemWeight = qty;
                    noOfPackets = String.valueOf((etQtyInGram / pkgQtyInGram));
                } else {
                    itemWeight = String.valueOf((etQtyInGram * pkgQtyInGram));
                    noOfPackets = qty;
                }
            } catch (Exception e) {
                itemWeight = "";
                noOfPackets = "";

            }
        }
    }

    private boolean calculateQuantityInKg(double qty) {
        if (!packageQuantity.equals("")) {
            try {
                int pkgQtyInGram = (int) (Double.parseDouble(packageQuantity) * 1000);

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

    android.app.DatePickerDialog.OnDateSetListener ondate = new android.app.DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            DecimalFormat dcf = new DecimalFormat("00");

            st_exp_date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            String date = dcf.format(dayOfMonth) + "-" + dcf.format(monthOfYear + 1) + "-" + year;
            btn_date.setText(date);
            date = "0";
            Log.d("smdskdmksdmd", "polsskakaa" + btn_date.getText().toString());

            if (btn_date.getText().toString().contains("-")) {
                btn_click = "1";
            } else {
                btn_click = "0";
            }
        }
    };

    private void showFromPlantDataOnView(List<PlantDetailsResponse> plantResponse) {

        List<String> codes = new ArrayList<>();

        plantResponse.stream().forEach(plantDetailsResponse -> {
            codes.add(plantDetailsResponse.getPlantCode().trim() + "-" + plantDetailsResponse.getPlantName().trim());
        });

        HashSet<String> set = new HashSet<>(codes);
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
        spFromPlant.setAdapter(adapter1);
    }

    private void showToPlantDataOnView() {

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<ZOrganogramResponseDetails> allZOrganogramReponseDetailsByRbmId = salesIndentDataBase.zOrganogramDetailsDao().getAllZOrganogramReponseDetailsByRbmId(appSharedPreferences.getUserId());
            List<String> codes = new ArrayList<>();
            allZOrganogramReponseDetailsByRbmId.stream().forEach(zOrganogramResponseDetails -> {
                codes.add(zOrganogramResponseDetails.getPlant().trim()+"-"+zOrganogramResponseDetails.getPlant_name().trim());
            });
            runOnUiThread(() -> {
                HashSet<String> set = new HashSet<>(codes);
                final ArrayList<String> result = new ArrayList<>(set);
                Collections.sort(result);
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, result);
                autoTextToPlant.setAdapter(adapter);
                autoTextToPlant.setThreshold(1);

                autoTextToPlant.setOnTouchListener((paramView, paramMotionEvent) -> {
                    if (result.size() > 0) {
                        // show all suggestions
                        if (!autoTextToPlant.getText().toString().equals(""))
                            adapter.getFilter().filter(null);
                        autoTextToPlant.showDropDown();
                    }
                    return false;
                });

                autoTextToPlant.setOnItemClickListener((parent, view, position, id) -> {
//                        from_ware_id = ware_ids.get(position);
                    sToPlant = autoTextToPlant.getText().toString();
                    if(sToPlant!=null){
                        String[] split = sToPlant.split("-");
                        sToPlantCode = split[0];
                    }
                });


            });
        });
    }

    public void showCropNameOnView(List<STOMaterialDetailsResponse> allVarietyDetails) {

        if (allVarietyDetails != null && allVarietyDetails.size() > 0) {
            List<String> codes = new ArrayList<>();

            allVarietyDetails.stream().filter(cropVarityDetailsResponse -> cropVarityDetailsResponse != null).forEach(cropVarityDetailsResponse -> {
                codes.add(cropVarityDetailsResponse.getCropName().trim());
            });

            HashSet<String> set = new HashSet<>(codes);
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
        }
    }

    public void showItemNameOnView() {

        if (sCropName != null && sVarityName != null) {
            SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                List<STOMaterialDetailsResponse> allItemNameDetails = salesIndentDataBase.stoMaterialDao().getAllItemNameDetails(sCropName, sVarityName);
                if (allItemNameDetails != null) {
                    runOnUiThread(() -> {

                        if (allItemNameDetails != null && allItemNameDetails.size() > 0) {
                            List<String> codes = new ArrayList<>();

                            allItemNameDetails.stream().forEach(stoMaterialDetailsResponse -> {
                                codes.add(stoMaterialDetailsResponse.getMaterialName().trim());
                            });

                            HashSet<String> set = new HashSet<>(codes);
                            ArrayList<String> result = new ArrayList<>(set);
                            Collections.sort(result);
                            List<String> codes3 = new ArrayList<String>();
                            codes3.add("Please Select");
                            for (int j = 0; j < result.size(); j++) {

                                String codes2 = result.get(j);
                                codes3.add(codes2);

                            }

                            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(StockTransferCreateActivity.this, R.layout.spinner_item, codes3);
                            adapter1.setDropDownViewResource(R.layout.spinner_item);
                            spItemName.setAdapter(adapter1);
                        }
                    });

                } else {
                    Log.d(TAG, "AllItemDetails Null");
                }
            });

        } else {
            Log.d(TAG, "CropNames and varietyName Null");
        }


    }


    public void showVarityNameOnView() {

        if (sCropName != null) {
            List<String> codes = new ArrayList<>();
            SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                List<STOMaterialDetailsResponse> cropVarityDetailsResponses = salesIndentDataBase.stoMaterialDao().getAllVarietyDetailsByCropName(sCropName);
                if (cropVarityDetailsResponses != null && cropVarityDetailsResponses.size() > 0) {
                    cropVarityDetailsResponses.stream().forEach(cropVarityDetailsResponse -> {
                        codes.add(cropVarityDetailsResponse.getVarietyName());
                    });

                    runOnUiThread(() -> {
                        HashSet<String> set = new HashSet<>(codes);
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
                        spVarityName.setAdapter(adapter1);
                    });
                }
            });

        }
    }


    public void GetPktSizeData() {

        if (isTableExists(dbGetmaster, "SeedProcessPackingTable")) {


            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from SeedProcessPackingTable where PackingId='" + packing_id + "'", null);

            if (GetCursorOrderDetails.moveToFirst()) {

                do {
                    UomValueCheck = GetCursorOrderDetails.getString(3);
                    PkgName = GetCursorOrderDetails.getString(2);

                } while (GetCursorOrderDetails.moveToNext());
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//
//        syninput1 = "to_ware_house";
//        try {
//            ArrayList<String> ware_names = new ArrayList<>();
//            ArrayList<String> ware_ids = new ArrayList<>();
//
//            String[] ware_arr = sessionManager.get_warehouseRBM().split("\\|");
//            for (int i = 0; i < ware_arr.length; i++) {
//                String[] wares = ware_arr[i].split("!");
//
//                ware_ids.add(wares[0]);
//                ware_names.add(wares[1]);
//            }
//
//            HashSet<String> set = new HashSet<>(ware_names);
//            final ArrayList<String> result = new ArrayList<>(set);
//            Collections.sort(result);
//            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, result);
//            autoTextToPlant.setAdapter(adapter);
//            autoTextToPlant.setThreshold(1);
//
//            HashSet<String> set1 = new HashSet<>(ware_ids);
//            ware_ids = new ArrayList<>(set1);
//            Collections.sort(ware_ids);
//
//            autoTextToPlant.setOnTouchListener(new View.OnTouchListener() {
//
//                @SuppressLint("ClickableViewAccessibility")
//                @Override
//                public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
//                    if (result.size() > 0) {
//                        // show all suggestions
//                        if (!autoTextToPlant.getText().toString().equals(""))
//                            adapter.getFilter().filter(null);
//                        autoTextToPlant.showDropDown();
//                    }
//                    return false;
//                }
//            });
//
//            final ArrayList<String> finalWare_ids = ware_ids;
//            autoTextToPlant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    from_ware_id = finalWare_ids.get(position);
//                    from_ware_name = autoTextToPlant.getText().toString();
//                    autoTextToPlant.setEnabled(false);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(TAG, "error " + e.toString());
//        }
//
//        try {
//            if (isTableExists(dbGetmaster, "WareHouseMaster") &&
//                    isTableExists(dbGetmaster, "SeedProcessPackingTable")) {
//                set_ware();
//                set_crop_name();
//            } else {
//                DeleteGetMasterDatabase();
//                createTableGetMasterDatabase();
//
////                get_data();
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "error " + e.toString());
//        }
//
//        DeleteStockTransferDetailsTemp();
//        createTableStockTransferDetailsTemp();

    }

    private void callPlanDetailsApi() {
        prgDialog.show();
        Call<PlantResponse> call = apiInterface.getAllPlantsResponse();
        call.enqueue(new Callback<PlantResponse>() {
            @Override
            public void onResponse(Call<PlantResponse> call, Response<PlantResponse> response) {
                PlantResponse plantResponse = response.body();
                Log.d(TAG, plantResponse.toString());
                if (plantResponse != null && plantResponse.getPlantResponse().size() > 0) {
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        plantResponse.getPlantResponse().stream()
                                .forEach(plantDetailsResponse -> salesIndentDataBase.plantDao().insertAll(plantDetailsResponse));
                        Log.d(TAG + "Plan Details fetch from db", salesIndentDataBase.plantDao().getAllPlantDetails().toString());
                    });

                    callMaterialApi();


                } else {
                    prgDialog.hide();
                }

            }

            @Override
            public void onFailure(Call<PlantResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });

    }


//    private void callCropAndAssignmentApi() {
//        Call<CropVarityResponse> call = apiInterface.getCropANdAssignmentResponse(appSharedPreferences.getDivision());
//        call.enqueue(new Callback<CropVarityResponse>() {
//            @Override
//            public void onResponse(Call<CropVarityResponse> call, Response<CropVarityResponse> response) {
//                Log.d(TAG, response.body().toString());
//                CropVarityResponse cropAndAssigmentResponse = response.body();
//                Log.d(TAG, cropAndAssigmentResponse.toString());
//                if (cropAndAssigmentResponse != null && cropAndAssigmentResponse.getAcsenCropAndVarityAssignmentRes().size() > 0) {
//                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
//                        cropAndAssigmentResponse.getAcsenCropAndVarityAssignmentRes().stream()
//                                .forEach(cropVarityDetailsResponse -> salesIndentDataBase.cropAndAssignmentDao().insertAll(cropVarityDetailsResponse));
//                        Log.d(TAG + "CropVarity fetch from db", salesIndentDataBase.cropAndAssignmentDao().getAllVarietyDetails().toString());
//                    });
//
//                    callMaterialApi();
//
//                } else {
//                    prgDialog.hide();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CropVarityResponse> call, Throwable t) {
//                call.cancel();
//                prgDialog.hide();
//            }
//        });
//
//    }

    private void callMaterialApi() {
        Call<STOMaterialResponse> call = apiInterface.getMaterialResponse(appSharedPreferences.getDivision());
        call.enqueue(new Callback<STOMaterialResponse>() {
            @Override
            public void onResponse(Call<STOMaterialResponse> call, Response<STOMaterialResponse> response) {
                STOMaterialResponse materialResponse = response.body();
                Log.d(TAG + "material response", materialResponse.toString());
                prgDialog.hide();
                Toast.makeText(StockTransferCreateActivity.this, "Data imported successfully", Toast.LENGTH_LONG).show();
                if (materialResponse != null && materialResponse.getAcsenMaterialMasterRes().size() > 0) {
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        materialResponse.getAcsenMaterialMasterRes().stream()
                                .forEach(materialMasterDetailResponse -> salesIndentDataBase.stoMaterialDao().insertAll(materialMasterDetailResponse));
//
                        Log.d(TAG + "Material fetch from DB", salesIndentDataBase.stoMaterialDao().getAllSTOMaterialDetails().toString());
                        List<PlantDetailsResponse> allPlantDetails = salesIndentDataBase.plantDao().getAllPlantDetails();
                        runOnUiThread(() -> {
                            if (allPlantDetails != null && allPlantDetails.size() > 0) {
                                showFromPlantDataOnView(allPlantDetails);
                            }
                        });
                    });

                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        List<STOMaterialDetailsResponse> allSTOMaterialDetails = salesIndentDataBase.stoMaterialDao().getAllSTOMaterialDetails();
                        runOnUiThread(() -> {
                            if (allSTOMaterialDetails != null) {
                                showCropNameOnView(allSTOMaterialDetails);
                            } else {
                                Log.d(TAG, "AllMaterials null");
                            }
                        });
                    });
                }
            }

            @Override
            public void onFailure(Call<STOMaterialResponse> call, Throwable t) {
                prgDialog.hide();
                call.cancel();

            }
        });
    }

    private void get_data() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {

//            if (syninput1.equals("from_ware_house")) {
//
//                crossyndata = IPAddress + ProjectFolder + "/ISRBMWarehouse.php?warehouse="+sessionManager.get_warehouseRBM();
////                crossyndata = "http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISRBMWarehouse.php?warehouse="+sessionManager.get_warehouse();
//
//            }

            if (syninput1.equals("to_ware_house")) {

                crossyndata = IPAddress + ProjectFolder + "/ISWarehouseMaster.php";
//                crossyndata = "http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISWarehouseMaster.php";

            }


            if (syninput1.equals("ItemMaster")) {

                crossyndata = IPAddress + ProjectFolder + "/ISItemMaster.php";

            }


            if (syninput1.equals("CropMaster")) {

                crossyndata = IPAddress + ProjectFolder + "/ISCropMaster.php";

            }


            if (syninput1.equals("SeedProcessPackingTable")) {

                crossyndata = IPAddress + ProjectFolder + "/ISSeedProcessPackingTable.php";

            }
            if (syninput1.equals("InventMaster")) {

                crossyndata = IPAddress + ProjectFolder + "/ISInventMaster.php";
            }


//            class GetDataJSON extends AsyncTask<String, Void, String> {
//
//
//                @Override
//                protected String doInBackground(String... params) {
//                    Log.e(TAG, "link " + crossyndata);
//                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                    HttpPost httppost = new HttpPost(crossyndata);
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
//                        // Oops
//                    } finally {
//                        try {
//                            if (inputStream != null) inputStream.close();
//                        } catch (Exception squish) {
//                        }
//                    }
//                    return result;
//                }
//
//                @Override
//                protected void onPostExecute(String result) {
//                    myJSON = result;
//                    Log.e(TAG, "result " + myJSON);
//                    if (result != null) {
//                        try {
//                            if (syninput1.equals("from_ware_house")) {
//                                showList2(0);
//                            } else {
//                                showList3();
//                            }
//                        } catch (Exception e) {
//                            Toast.makeText(StockTransferCreateActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        // Internet connection doesn't exist
//                        showAlertDialog(StockTransferCreateActivity.this, "No Internet Connection",
//                                "Your device doesn't have WIFI or Data Plan internet access", false);
//                    }
//
//
//                }
//            }
//            GetDataJSON g = new GetDataJSON();
//            g.execute();
        } else {
            showAlertDialog(StockTransferCreateActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void showList2(int entry) {


        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            List<String> ware_names = new ArrayList<String>();
            final ArrayList<String> ware_ids = new ArrayList<>();

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

                String Id = c.getString(T1);
                String A = c.getString(T2);
//                /*String B = c.getString(T3);
//                String C = c.getString(T4);
//                String D = c.getString(T5);
//                String E = c.getString(T6);
//                String F = c.getString(T7);
//                String G = c.getString(T8);
//                String H = c.getString(T9);
//                String I = c.getString(T10);
//                String J = c.getString(T11);
//                String K = c.getString(T12);
//                String L = c.getString(T13);
//                String M = c.getString(T14);
//                String N = c.getString(T15);
//                String O = c.getString(T16);
//                String P = c.getString(T17);
//                String Q = c.getString(T18);
//                String R = c.getString(T19);
//                String S = c.getString(T20);
//                    String T = c.getString(T21);
//                    String U = c.getString(T22);
//                    String V = c.getString(T23);
//                    String W = c.getString(T24);
//                    String X = c.getString(T25);
//                    String Y = c.getString(T26);
//                    String Z = c.getString(T27);*/

                HashMap<String, String> persons = new HashMap<>();

                persons.put(T1, Id);
                persons.put(T2, A);
//                 /*persons.put(T3, B);
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
//                persons.put(T26, Y);
//                persons.put(T27, Z);*/


                if (peoples.length() == 1) {
                    from_ware_id = Id;
                    sToPlant = A;

                    autoTextToPlant.setEnabled(false);
                    autoTextToPlant.setText(sToPlant);
                } else {
                    ware_names.add(A);
                    ware_ids.add(Id);

                    HashSet<String> set = new HashSet<>(ware_names);
                    final ArrayList<String> result = new ArrayList<>(set);
                    Collections.sort(result);
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, result);
                    autoTextToPlant.setAdapter(adapter);
                    autoTextToPlant.setThreshold(1);

//                    autoTextToPlant.setOnTouchListener(new View.OnTouchListener() {
//
//                        @SuppressLint("ClickableViewAccessibility")
//                        @Override
//                        public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
//                            if (result.size() > 0) {
//                                // show all suggestions
//                                if (!autoTextToPlant.getText().toString().equals(""))
//                                    adapter.getFilter().filter(null);
//                                autoTextToPlant.showDropDown();
//                            }
//                            return false;
//                        }
//                    });

//                    autoTextToPlant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            from_ware_id = ware_ids.get(position);
//                            from_ware_name = autoTextToPlant.getText().toString();
//                        }
//                    });
                }
            }
            if (entry == 0) {
                if (syninput1.equals("from_ware_house")) {
                    syninput1 = "to_ware_house";
                    get_data();
                }
            } else {
                prgDialog.cancel();
                showAlertDialog1(StockTransferCreateActivity.this, " Data Import Successfully", true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();
        }
    }

    protected void showList3() {


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();


        if (isConnectionExist || isConnectionExistMobile) {

            try {
                JSONObject jsonObj = new JSONObject(myJSON);
                peoples = jsonObj.getJSONArray(TAG_RESULTS);

                for (int i = 0; i < peoples.length(); i++) {
                    JSONObject c = peoples.getJSONObject(i);
                    String Id = "";
                    String A;
                    String B;
                    String C;
                    String D;
                    String E;
                    String F;
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
                    if (crossyndata.contains("ISInventMaster.php")) {
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

                    }
                        /* String S = c.getString(T20);
                    String T = c.getString(T21);
                    String U = c.getString(T22);
                    String V = c.getString(T23);
                    String W = c.getString(T24);
                    String X = c.getString(T25);
                    String Y = c.getString(T26);
                    String Z = c.getString(T27);*/
                    else {

                        Id = c.getString(T1);
                        A = c.getString(T2);
                        B = c.getString(T3);
                        C = c.getString(T4);
                        D = c.getString(T5);
                        E = c.getString(T6);
                        F = c.getString(T7);
                        G = c.getString(T8);
                        H = c.getString(T9);
                        I = c.getString(T10);
                        J = c.getString(T11);
                        K = c.getString(T12);
                        L = c.getString(T13);

                        M = c.getString(T14);
                        N = c.getString(T15);
                        O = c.getString(T16);
                        P = c.getString(T17);
                        Q = c.getString(T18);
                        R = c.getString(T19);
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
                    }
                  /*  persons.put(T20, S);
                persons.put(T21, T);
                persons.put(T22, U);
                persons.put(T23, V);
                persons.put(T24, W);
                persons.put(T25, X);
                persons.put(T26, Y);
                persons.put(T27, Z);*/


                    if (syninput1.equals("to_ware_house")) {

                        String query = "INSERT INTO WareHouseMaster (WareHouseID,WareHouseName) VALUES('" + Id + "','" + A + "');";
                        dbGetmaster.execSQL(query);
                    }

                    if (syninput1.equals("ItemMaster")) {

                        String query = "INSERT INTO ItemMaster (RecID,ItemId,ItemName,ItemGroup,Uom,CropCode,CropName ) VALUES('" + Id + "','" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "');";
                        dbGetmaster.execSQL(query);
                    }

                    if (syninput1.equals("CropMaster")) {

                        String query = "INSERT INTO CropMaster (CropCode,Name,CropType ) VALUES('" + Id + "','" + A + "','" + B + "');";
                        dbGetmaster.execSQL(query);

                    }

                    if (syninput1.equals("SeedProcessPackingTable")) {

                        String query = "INSERT INTO SeedProcessPackingTable ( PackingId,Description,UnitID,StdWeight,ConvFactor,PkgSize,CartonBoxSize) VALUES('" + Id + "','" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "');";
                        dbGetmaster.execSQL(query);

                    }
                    if (syninput1.equals("InventMaster")) {
                        String query = "INSERT INTO InventMaster (ItemId,ItemName, CropCode,CropName,Hybridname,PackingId) VALUES('" + A + "','" + B + "','" + C + "','" + D + "','" + E + "','" + F + "');";
                        dbGetmaster.execSQL(query);
                    }


                }
                GetSyn8();

            } catch (JSONException e) {
                prgDialog.cancel();
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "No Data Availble", Toast.LENGTH_LONG).show();

            }
        } else {
            // Internet connection doesn't exist
            prgDialog.cancel();
            showAlertDialog(StockTransferCreateActivity.this, "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
    }

    private void GetSyn8() {

        switch (syninput1) {
            case "to_ware_house":
                set_ware();
                syninput1 = "ItemMaster";
                get_data();

                break;
            case "ItemMaster":
                syninput1 = "CropMaster";
                get_data();

                break;
            case "CropMaster":
                syninput1 = "InventMaster";
                get_data();
                break;
            case "InventMaster":
                set_crop_name();
                syninput1 = "SeedProcessPackingTable";
                get_data();
                break;

            case "SeedProcessPackingTable":
                prgDialog.cancel();
                showAlertDialog1(StockTransferCreateActivity.this, " Data Import Successfully", true);
                break;


        }
    }

    public void set_ware() {

        List<String> codes = new ArrayList<>();

        if (isTableExists(dbGetmaster, "WareHouseMaster")) {

            GetWareHouseDetails = dbGetmaster.rawQuery("select * from WareHouseMaster", null);

            if (GetWareHouseDetails.moveToFirst()) {
                do {
                    codes.add(new String(GetWareHouseDetails.getString(2)));
                } while (GetWareHouseDetails.moveToNext());
            }
        }

        HashSet<String> set = new HashSet<>(codes);
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
        spFromPlant.setAdapter(adapter1);
    }


    public void set_crop_name() {

        List<String> codes = new ArrayList<>();

        if (isTableExists(dbGetmaster, "InventMaster")) {

            GetWareHouseDetails = dbGetmaster.rawQuery("select * from InventMaster", null);

            if (GetWareHouseDetails.moveToFirst()) {
                do {
//                    if ("VEG".equals(GetWareHouseDetails.getString(3))) {
                    codes.add(new String(GetWareHouseDetails.getString(4)));
//                    }
                } while (GetWareHouseDetails.moveToNext());
            }
        }

        HashSet<String> set = new HashSet<>(codes);
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
    }

    public void set_hybrid() {

        List<String> codes = new ArrayList<>();

        if (isTableExists(dbGetmaster, "InventMaster")) {

            GetWareHouseDetails = dbGetmaster.rawQuery("select * from InventMaster  where CropName='" + sCropName + "'", null);


            if (GetWareHouseDetails.moveToFirst()) {
                do {
                    codes.add(new String(GetWareHouseDetails.getString(5)));
                } while (GetWareHouseDetails.moveToNext());
            }
        }

        HashSet<String> set = new HashSet<>(codes);
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
        spVarityName.setAdapter(adapter1);
    }

    private void ItemNameGet() {
        if (isTableExists(dbGetmaster, "InventMaster")) {
            GetWareHouseDetails = dbGetmaster.rawQuery("select * from ItemMaster where ItemId='" + sVarityName + "'", null);

            if (GetWareHouseDetails.moveToFirst()) {
                do {
                    ItemName = GetWareHouseDetails.getString(2);
                }
                while (GetWareHouseDetails.moveToNext());
            }
        }
    }

    private void GetPktSize() {
        List<String> codes2 = new ArrayList<>();

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
        weightinkgorgms = codes2.get(2);


    }

    public void GetItemName() {
        String check = "";


        List<String> codes = new ArrayList<String>();


        if (isTableExists(dbGetmaster, "InventMaster")) {

            // private final String MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";

            // db.rawQuery(MY_QUERY, new String[]{String.valueOf(propertyId)});

            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from InventMaster  where Hybridname='" + sVarityName + "'", null);


            if (GetCursorOrderDetails.moveToFirst()) {

                do {


                    //GetPriceCheckItem();

                    // if( PriceCheckItems1.equals(PriceCheckItems2)) {


                    codes.add(new String(GetCursorOrderDetails.getString(2)));

                    //   }


                } while (GetCursorOrderDetails.moveToNext());

            }
            // closing connection
            //  c.close();
            // db.close();


        }


        HashSet<String> set = new HashSet<>(codes);

        // Create ArrayList from the set.
        ArrayList<String> result = new ArrayList<>(set);
        //Comparator mycomparator = Collections.reverseOrder();
        //Collections.sort(result,mycomparator);

        Collections.sort(result);


        List<String> codes3 = new ArrayList<String>();


        codes3.add("Please Select");


        for (int j = 0; j < result.size(); j++) {

            String codes2 = result.get(j);
            codes3.add(codes2);

        }


        // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Product.setAdapter(adapter1);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
        adapter1.setDropDownViewResource(R.layout.spinner_item);
        spItemName.setAdapter(adapter1);

    }

    public void getingtemidintiall() {
        //item nae
        final String[] itemnameee = {

                "Please Select"


        };

        // ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SubActivity2);
        //  adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //  SubActivity.setAdapter(adapter2);


        ArrayAdapter<String> itemnameeeadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, itemnameee);
        itemnameeeadapter.setDropDownViewResource(R.layout.spinner_item);
        spItemName.setAdapter(itemnameeeadapter);


    }

    private void getBaseUOMAndPackingQty() {
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            STOMaterialDetailsResponse materialEntityDetails = salesIndentDataBase.stoMaterialDao().getMaterialEntityDetails(sItemName);
            if (materialEntityDetails != null) {
                Log.d(TAG, "getBaseUOMAndPackingQty:" + materialEntityDetails.toString());
                sMaterialCode = materialEntityDetails.getMaterialCode();
                baseUOM = materialEntityDetails.getBaseUom();
                packageQuantity = materialEntityDetails.getPackingQuantity();
            } else {
                Log.d(TAG, "getBaseUOMAndPackingQty: null");
            }
        });
    }

    public void GetPackageID() {
        String check = "";


        List<String> codes = new ArrayList<String>();
        List<String> codes23 = new ArrayList<String>();


        if (isTableExists(dbGetmaster, "InventMaster")) {

            // private final String MY_QUERY = "SELECT * FROM table_a a INNER JOIN table_b b ON a.id=b.other_id WHERE b.property_id=?";

            // db.rawQuery(MY_QUERY, new String[]{String.valueOf(propertyId)});

            GetCursorOrderDetails = dbGetmaster.rawQuery("select * from InventMaster  where ItemName='" + sItemName + "'", null);


            if (GetCursorOrderDetails.moveToFirst()) {

                do {


                    codes.add(new String(GetCursorOrderDetails.getString(6)));

                    codes23.add(new String(GetCursorOrderDetails.getString(1)));

                    //   }


                } while (GetCursorOrderDetails.moveToNext());

            }
            // closing connection
            //  c.close();
            // db.close();


        }


        HashSet<String> set = new HashSet<>(codes);
        HashSet<String> set23 = new HashSet<>(codes23);

        // Create ArrayList from the set.
        ArrayList<String> result = new ArrayList<>(set);
        ArrayList<String> result23 = new ArrayList<>(set23);

        //Comparator mycomparator = Collections.reverseOrder();
        //Collections.sort(result,mycomparator);

        Collections.sort(result);
        Collections.sort(result23);


        List<String> codes3 = new ArrayList<String>();
        List<String> codes323 = new ArrayList<String>();


        codes3.add("Please Select");
        codes323.add("Please Select");


        for (int j = 0; j < result.size(); j++) {

            String codes2 = result.get(j);
            codes3.add(codes2);

        }
        for (int j = 0; j < result23.size(); j++) {

            String codes223 = result23.get(j);
            codes323.add(codes223);

        }
        Log.d("skdmskmsmdsdww", "kskdoswww" + codes3);


        // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codes);
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Product.setAdapter(adapter1);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, codes3);
        adapter1.setDropDownViewResource(R.layout.spinner_item);
        Log.d("skdmskmsmdsdww", "oksodkwew" + codes3.size());
        Log.d("skdmskmsmdsdww", "oksodkwew" + codes3.get(1));
        Log.d("skdmskmsmdsdww", "oksodkwew" + sItemName);

        Log.d("skdmskmsmdsd", "oksodkwew" + codes323.get(1));

        ItemIDtosend = codes323.get(1);

        PackagingIDsend = codes3.get(1);

        Itemnametosend = sItemName;


        GetPktSize();
//        String[] separated = itemnameeq.split("G");
//
//        Log.d("skdmskmsmdsd","-------------"+ separated[0]);
//        Log.d("skdmskmsmdsd","-------------"+ separated[1]);
//
//        separated[0].split("",2);

//        etQtyKgPkts.addTextChangedListener(new TextWatcher() {
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
//                    final String PkgSize2 = weightinkgorgms;
//
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        public void run() {
//                            try {
//                                double qty2 = Double.parseDouble(arg0.toString());
//                                if (!calc(qty2, PkgSize2)) {
//                                    etQtyKgPkts.setError("Wrong Quantity");
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

    public void edttextvalueei(int value) {
        if ((etQtyKgPkts.getText().toString().length() > 0) || (!etQtyKgPkts.getText().toString().equals(""))) {
            float output = Float.parseFloat(etQtyKgPkts.getText().toString());
            float finall = output * 1000;
            float remainder = finall % value;
            if (remainder == 0) {
                etQtyKgPkts.setError(null);
            } else {
                etQtyKgPkts.setError("Invalide");
            }

        } else {
            etQtyKgPkts.setError(null);
        }

    }

    private void get_ware_id() {
        if (isTableExists(dbGetmaster, "WareHouseMaster")) {
            GetWareHouseDetails = dbGetmaster.rawQuery("select * from WareHouseMaster where WareHouseName='" + sFromPlant + "'", null);

            if (GetWareHouseDetails.moveToFirst()) {
                do {
                    to_ware_id = GetWareHouseDetails.getString(1);
                } while (GetWareHouseDetails.moveToNext());
            }
        }
    }

    public void checkEmptyFiledAndAddDataIntoDB(View view) {
        if (btn_date.getText().toString().contains("-")) {
            btn_click = "1";
        } else {
            btn_click = "0";
        }
        QtyInKgs = etQtyKgPkts.getText().toString();
        double qty = 0.0;
        try {
            qty = Double.parseDouble(QtyInKgs);
        } catch (Exception e) {
            qty = 0.0;
        }
        QtyInKgs = etQtyKgPkts.getText().toString();
        if (sToPlant == null || sToPlant.contains("Select")) {
            Toast.makeText(this, "Please select to plant", Toast.LENGTH_SHORT).show();
        } else if (sFromPlant == null || sFromPlant.contains("Select")) {
            Toast.makeText(this, "Please select from plant", Toast.LENGTH_SHORT).show();
        } else if (sCropName == null || sCropName.contains("Select")) {
            Toast.makeText(this, "Please select Crop", Toast.LENGTH_SHORT).show();
        } else if (sVarityName == null || sVarityName.contains("Select")) {
            Toast.makeText(this, "Please select varity", Toast.LENGTH_SHORT).show();
        } else if (qty == 0.0) {
            Toast.makeText(this, "Please Enter Correct Quantity", Toast.LENGTH_SHORT).show();
        } else if (btn_click.equals("0")) {
            Toast.makeText(this, "Please Select Date", Toast.LENGTH_SHORT).show();
        } else if (spFromPlant.getSelectedItem().toString().equals(autoTextToPlant.getText().toString())) {
            Toast.makeText(this, "From Plant & To Plant should not be same", Toast.LENGTH_SHORT).show();
            autoTextToPlant.setText("");
            autoTextToPlant.setEnabled(true);
            spFromPlant.setEnabled(true);
        } else {
            if (calculateQuantityInKg(qty)) {
                IndentCodeUpdate();

                Handler handler = new Handler();
                handler.postDelayed(() -> ExcelSaveData(), 30);

                Handler handler2 = new Handler();
                handler2.postDelayed(() -> DisplayLineData(), 50);
            } else {
                prgDialog.cancel();
                etQtyKgPkts.setError("Wrong Quantity");
                Toast.makeText(getApplicationContext(), "Please enter correct qty in count of " + int_size + int_type, Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void IndentCodeUpdate() {
        if (!ISIndentCodeFile.exists()) {
            IndentCodeFinal = "00001";
        } else {
            try {
                //create BufferedReader to read csv file
                BufferedReader brs = new BufferedReader(new FileReader(ISIndentCodeFile));
                String line = "";

                int lineNumber = 0;

                //read comma separated file line by line
                while ((line = brs.readLine()) != null) {
                    lineNumber++;
                    //use comma as token separator
                    String[] Infile = line.split(",");
                    IndentCodeFinal = Infile[0].trim().toString();

                }
                brs.close();

            } catch (Exception e) {
                System.err.println("CSV file cannot be read : " + e);
            }
            Log.e(TAG, "before " + IndentCodeFinal);
            Integer EventCodes = Integer.parseInt(IndentCodeFinal.trim().toString()) + 1;
            DecimalFormat formatter = new DecimalFormat("00000");
            String aFormatted = formatter.format(EventCodes);
            String EventCodeCheck = aFormatted.toString();

            IndentCodeFinal = EventCodeCheck;
            Log.e(TAG, "after " + IndentCodeFinal);
        }
    }


    private void ExcelSaveData() {
        sToPlant = autoTextToPlant.getText().toString();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");

        String strDate = sdf.format(cal.getTime());
        String strTime = sdf1.format(cal.getTime());
        SimpleDateFormat Year = new SimpleDateFormat("yy");
        String YearCode = Year.format(cal.getTime());
        String rbmRemarks = etRemarks.getText().toString();
        IndentCreationCode = POCodeGet + "-ST" + YearCode + IndentCodeFinal;
//        String query = "INSERT INTO StockTransferDetailsTemp (STNo,SlNo,FrmWhId ,FrmWh,ToWh ,ToWhId ,CropName ,CropType ,EPDate ,EmpCode ,LocationID ,PackingId ,Description ,UnitID ,Qty ,Acting ,Dcode ,ItemId,ItemName,Remarks) VALUES('" + IndentCreationCode.trim() + "','" + IndentCodeFinal + "','" + from_ware_id + "','" + sToPlant + "','" + sFromPlant + "','" + to_ware_id + "','" + sCropName + "','" + sVarityName + "','" + st_exp_date + "','" + POCodeGet + "','" + SiteGet + "','" + PackagingIDsend + "','" + Descriptiontosend + "','" + UnitIDtosend + "','" + QtyInKgs + "','" + Acting + "','" + DCode + "','" + ItemIDtosend + "','" + sItemName + "','" + Remarks + "');";
//        dbStockTransfer.execSQL(query);
//        Log.e("insert", query);

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            STOIndentTmpEntity tmpEntity = new STOIndentTmpEntity();
            tmpEntity.setSTO_indent_no(IndentCreationCode.trim());
            tmpEntity.setIndent_date(strDate);
            tmpEntity.setIndent_time(strTime);
            tmpEntity.setSending_plant(sToPlantCode);
            tmpEntity.setReceiving_plant(sFromPlantCode);
            tmpEntity.setLine_no(IndentCodeFinal);
            tmpEntity.setDivision(appSharedPreferences.getDivision());
            tmpEntity.setCrop_name(sCropName);
            tmpEntity.setCrop_code(sCropCode);
            tmpEntity.setVariety_code(sVarityCode);
            tmpEntity.setVariety_name(sVarityName);
            tmpEntity.setMaterial_code(sMaterialCode);
            tmpEntity.setMaterial_description(sItemName);
            tmpEntity.setFinal_status("PENDING");
            tmpEntity.setReq_date(st_exp_date);
            calculateItemWeight(QtyInKgs);
            tmpEntity.setRbm_qty(QtyInKgs);
            tmpEntity.setPackingQuantity(packageQuantity);
            tmpEntity.setBaseUom(baseUOM);
            tmpEntity.setRbm_item_weight(itemWeight);
            tmpEntity.setRbm_no_of_pac(noOfPackets);
            tmpEntity.setFinal_quantity(QtyInKgs);
            tmpEntity.setFinal_item_weight(itemWeight);
            tmpEntity.setFinal_no_of_pac(noOfPackets);
            tmpEntity.setRbm_remarks(rbmRemarks);
            SalesIndentDataBase.getDataBase(StockTransferCreateActivity.this).stoIndentTmpDao().insertAll(tmpEntity);
            Log.d("STO Temp Indent Request Details From DB", salesIndentDataBase.salesIndentTmpDao().getAllSalesIndentTmp().toString());
        });
    }

    public void DisplayLineData() {

        list.setAdapter(null);
        SerialLists.removeAll(SerialLists);
        VarietyLists.removeAll(VarietyLists);
        QtyLists.removeAll(QtyLists);
        remarks_listss.removeAll(remarks_listss);
        SerialNo = 1;
        list.removeHeaderView(headerView);


        headerView = ((LayoutInflater) StockTransferCreateActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.lineheader, null, false);
        TextView remarks = headerView.findViewById(R.id.text_remarks);
        remarks.setVisibility(View.VISIBLE);
        list.addHeaderView(headerView);
        etQtyKgPkts.setText("");
        spVarityName.setSelection(0);
        spCropName.setSelection(0);
        spItemName.setSelection(0);
        btn_date.setText("Select Date");

        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<STOIndentTmpEntity> allSTOIndentTmp = salesIndentDataBase.stoIndentTmpDao().getAllSTOIndentTmp();

            Log.d("Temp STO Indent Request Details From display line data", allSTOIndentTmp.toString());

            if (allSTOIndentTmp != null && allSTOIndentTmp.size() > 0) {
                for (STOIndentTmpEntity tmpEntity : allSTOIndentTmp) {
                    if (tmpEntity.getSTO_indent_no().equals(IndentCreationCode)) {
                        SerialLists.add(SerialNo + "");
//                        VarietyLists.add(cScanDetails.getString(8));
                        VarietyLists.add(tmpEntity.getMaterial_description());
                        QtyLists.add(tmpEntity.getRbm_qty());
                        remarks_listss.add(tmpEntity.getRbm_remarks());

                        SerialList = new String[SerialLists.size()];
                        VarietyList = new String[VarietyLists.size()];
                        QtyList = new String[QtyLists.size()];
                        remarks_list = new String[remarks_listss.size()];


                        SerialNo = SerialNo + 1;
                    }
                }
            }


//        if (isTableExists(dbStockTransfer, "StockTransferDetailsTemp")) {
//
//            cScanDetails = dbStockTransfer.rawQuery("select * from StockTransferDetailsTemp", null);
//
//            if (cScanDetails.moveToFirst()) {
//                do {
//                    if (cScanDetails.getString(1).equals(IndentCreationCode)) {
//
//                        SerialLists.add(SerialNo + "");
////                        VarietyLists.add(cScanDetails.getString(8));
//                        VarietyLists.add(cScanDetails.getString(19));
//                        QtyLists.add(cScanDetails.getString(15));
//                        remarks_listss.add(cScanDetails.getString(20));
//
//                        SerialList = new String[SerialLists.size()];
//                        VarietyList = new String[VarietyLists.size()];
//                        QtyList = new String[QtyLists.size()];
//                        remarks_list = new String[remarks_listss.size()];
//
//
//                        SerialNo = SerialNo + 1;
//                    }
//                } while (cScanDetails.moveToNext());
//            }
//        }

            for (int j = 0; j < VarietyLists.size(); j++) {
                // Get the path of the image file
                SerialList[j] = SerialLists.get(j);
                VarietyList[j] = VarietyLists.get(j);
                QtyList[j] = QtyLists.get(j);
                remarks_list[j] = remarks_listss.get(j);

            }

            runOnUiThread(() -> {
                MyListAdapter myListAdapter = new MyListAdapter();
                list.setAdapter(myListAdapter);
                setListViewHeightBasedOnItems(list);
                list.setFocusable(true);
                list.setFocusableInTouchMode(true);
                list.requestFocus();
            });

        });
    }

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
        alertDialog.setTitle(title);
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                syninput1 = "";
                crossyndata = "";
            }
        });
        alertDialog.show();
    }

    private void DeleteGetMasterDatabase() {

        String DATABASE_TABLE_WareHouseMaster = "WareHouseMaster";
        String DATABASE_TABLE_ItemMaster = "ItemMaster";
        String DATABASE_TABLE_CropMaster = "CropMaster";
        String DATABASE_TABLE_SeedProcessPackingTable = "SeedProcessPackingTable";
        String DATABASE_TABLE_InventMaster = "InventMaster";

        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_WareHouseMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_ItemMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_CropMaster + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_SeedProcessPackingTable + "'");
        dbGetmaster.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_InventMaster + "'");
    }

    private void DeleteStockTransferDetailsTemp() {

        String DATABASE_TABLE_StockTransferDetailsTemp = "StockTransferDetailsTemp".toString();

        dbStockTransfer.execSQL("DROP TABLE IF EXISTS '" + DATABASE_TABLE_StockTransferDetailsTemp + "'");
    }

    protected void createTableGetMasterDatabase() {

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS WareHouseMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, WareHouseID VARCHAR,WareHouseName VARCHAR);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS ItemMaster (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, RecID VARCHAR,ItemId VARCHAR, ItemName VARCHAR,ItemGroup VARCHAR,Uom VARCHAR,CropCode VARCHAR,CropName VARCHAR );");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS CropMaster(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CropCode VARCHAR,Name VARCHAR,CropType VARCHAR);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS SeedProcessPackingTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, PackingId VARCHAR,Description VARCHAR,UnitID VARCHAR,StdWeight REAL,ConvFactor  REAL, PkgSize VARCHAR,CartonBoxSize REAL);");

        dbGetmaster.execSQL("CREATE TABLE IF NOT EXISTS InventMaster (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ItemId VARCHAR,ItemName VARCHAR, CropCode VARCHAR,CropName VARCHAR,Hybridname VARCHAR,PackingId VARCHAR );");
    }

    protected void createTableStockTransferDetailsTemp() {
        dbStockTransfer.execSQL("CREATE TABLE IF NOT EXISTS StockTransferDetailsTemp(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, STNo VARCHAR,SlNo VARCHAR,FrmWhId VARCHAR,FrmWh VARCHAR ,ToWh VARCHAR ,ToWhId VARCHAR ,CropName VARCHAR ,CropType VARCHAR ,EPDate VARCHAR ,EmpCode VARCHAR ,LocationID VARCHAR ,PackingId VARCHAR ,Description VARCHAR,UnitID VARCHAR ,Qty REAL ,Acting VARCHAR ,Dcode VARCHAR,ItemId VARCHAR,ItemName VARCHAR,Remarks VARCHAR);");
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void CloseActivity(View view) {
        finish();
    }

    boolean isTableExists(SQLiteDatabase db, String tableName) {
        if (tableName == null || db == null || !db.isOpen()) {
            return false;
        }
        try {
            Cursor cursor = db.rawQuery("select * from  " + tableName + " ", null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return false;
            }
            int count = cursor.getInt(0);
            cursor.close();
            return count > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void insertToDatabase1() {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                IndentCodeUpdate();

//                Calendar cal = Calendar.getInstance();
//                SimpleDateFormat Year = new SimpleDateFormat("yy");
//                String YearCode = Year.format(cal.getTime());
//                IndentCreationCode = POCodeGet + "-ST" + YearCode + IndentCodeFinal;

                if (old_indent_no.equals(IndentCreationCode)) {
                    notify = "0";
                } else {
                    notify = "1";
                    old_indent_no = IndentCreationCode;
                }

//                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                nameValuePairs.add(new BasicNameValuePair("STNo", IndentCreationCode_));
//                nameValuePairs.add(new BasicNameValuePair("SlNo", LineNo + ""));
////                nameValuePairs.add(new BasicNameValuePair("FrmWhId", from_ware_id_));
////                nameValuePairs.add(new BasicNameValuePair("FrmWh", from_ware_name_));
////                nameValuePairs.add(new BasicNameValuePair("ToWh", to_ware_name_));
////                nameValuePairs.add(new BasicNameValuePair("ToWhId", to_ware_id_));
//
//                nameValuePairs.add(new BasicNameValuePair("FrmWhId", to_ware_id_));
//                nameValuePairs.add(new BasicNameValuePair("FrmWh", to_ware_name_));
//                nameValuePairs.add(new BasicNameValuePair("ToWh", from_ware_name_));
//                nameValuePairs.add(new BasicNameValuePair("ToWhId", from_ware_id_));
//
//                nameValuePairs.add(new BasicNameValuePair("CropName", CropNames_));
//                nameValuePairs.add(new BasicNameValuePair("CropType", CropType_));
//                nameValuePairs.add(new BasicNameValuePair("EPDate", st_exp_date_));
//                nameValuePairs.add(new BasicNameValuePair("EmpCode", POCodeGet_));
//                nameValuePairs.add(new BasicNameValuePair("LocationID", SiteGet_));
//                nameValuePairs.add(new BasicNameValuePair("PackingId", packing_id_));
//                nameValuePairs.add(new BasicNameValuePair("Description", PkgName_));
//                nameValuePairs.add(new BasicNameValuePair("UnitID", UomValueCheck_));
//                nameValuePairs.add(new BasicNameValuePair("Qty", QtyInKgs_));
//                nameValuePairs.add(new BasicNameValuePair("Acting", Acting_));
//                nameValuePairs.add(new BasicNameValuePair("Dcode", DCode_));
//                nameValuePairs.add(new BasicNameValuePair("notify", notify));
//
//                nameValuePairs.add(new BasicNameValuePair("ItemID", ItemIDtosend_));
//                nameValuePairs.add(new BasicNameValuePair("ItemName", Itemnametosend_));
//                nameValuePairs.add(new BasicNameValuePair("processingItem", CropType_));
//                nameValuePairs.add(new BasicNameValuePair("remarks", remarks_));

//                Log.d("Result---", "----------" + nameValuePairs);


                InputStream inputStream = null;
//                try {
//                    HttpClient httpClient = new DefaultHttpClient();
//
//                    HttpPost httpPost = new HttpPost(IPAddress + ProjectFolder + "/ISStockTransferInsert.php");
//
////                HttpPost httpPost = new HttpPost("http://192.168.35.24/hyveg/Sales_Indent_App/" + ProjectFolder + "/ISStockTransferInsert.php");
//                    Log.e("Stock-transfer-url", String.valueOf(httpPost));
//
//                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//
//                    HttpResponse response = httpClient.execute(httpPost);
//
//                    int status = response.getStatusLine().getStatusCode();
//                    ResponseCheckLine = String.valueOf(status);
//                    HttpEntity entity = response.getEntity();
//
//                    inputStream = entity.getContent();
//                    // json is UTF-8 by default
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                    StringBuilder sb = new StringBuilder();
//                    // List<String> codes = new ArrayList<String>();
//                    // String line = null;
//                    String line = "";
//                    int lineNumber = 0;
//
//                    while ((line = reader.readLine()) != null) {
//
//                        sb.append(line + "\n");
//                    }
//                    Log.e("tn", sb.toString());
//                } catch (ClientProtocolException e) {
//
//                } catch (IOException e) {

//                }
                return "success";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);


                LineNo = LineNo + 1;
                IndentCreationCode_ = "";
                IndentCodeFinal_ = "";
                to_ware_name_ = "";
                to_ware_id_ = "";
                CropNames_ = "";
                CropType_ = "";
                st_exp_date_ = "";
                POCodeGet_ = "";
                SiteGet_ = "";
                packing_id_ = "";
                PkgName_ = "";
                UomValueCheck_ = "";
                QtyInKgs_ = "";
                PackagingIDsend = "";
                Itemnametosend_ = "";
                remarks_ = "";
                ItemIDtosend_ = "";
                Acting_ = "";
                DCode_ = "";
                ExcelDataRead();
                if (LineNo == totalcountPoevent) {
                    IndentCodeSave();
                    DeleteStockTransferDetailsTemp();
                    createTableStockTransferDetailsTemp();
                    Toast.makeText(StockTransferCreateActivity.this, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show();
//                    if (notify.equals("1")) {
//                        showAlertDialog1(Stocktransfercreate.this, " Data Uploaded Successfully", true);
//                    }
                }

                if (totalcountPoevent == 1) {
                    IndentCodeSave();
                    DeleteStockTransferDetailsTemp();
                    createTableStockTransferDetailsTemp();
                    Toast.makeText(StockTransferCreateActivity.this, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show();
                }

                if (prgDialog != null) {
                    prgDialog.cancel();
                }
            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute();

    }

    private void empty_fields() {
        spCropName.setSelection(0);
        spVarityName.setSelection(0);
        spItemName.setSelection(0);
        etQtyKgPkts.setText("");
        btn_date.setText("Select Date");
        IndentCodeSave();
    }

    public void callPostSTOIndentApi(View view) {
        LineNo = 1;
        SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
            List<STOIndentTmpEntity> tmpEntityList = SalesIndentDataBase.getDataBase(StockTransferCreateActivity.this).stoIndentTmpDao().getAllSTOIndentTmp();
            if (tmpEntityList != null && tmpEntityList.size() > 0) {
                ZOrganogramResponseDetails zOrganogramDetails = SalesIndentDataBase.getDataBase(StockTransferCreateActivity.this).zOrganogramDetailsDao().getZOrganogramDetailsByRbmId(appSharedPreferences.getUserId());
                for (STOIndentTmpEntity detailsTmpEntity : tmpEntityList) {
                    detailsTmpEntity.setLine_no(String.valueOf(LineNo));
                    if (zOrganogramDetails != null) {

                        detailsTmpEntity.setSales_region(zOrganogramDetails.getRegion());
                        detailsTmpEntity.setSales_region_name(zOrganogramDetails.getRegionName());
                        detailsTmpEntity.setSales_division(zOrganogramDetails.getSalesDivision());
                        detailsTmpEntity.setSales_division_name(zOrganogramDetails.getSalesDivisionName());
                        detailsTmpEntity.setRBM(zOrganogramDetails.getRbm());
                        detailsTmpEntity.setRbm_name(zOrganogramDetails.getRbmName());
                        detailsTmpEntity.setDbm(zOrganogramDetails.getDbm());
                        detailsTmpEntity.setDbm_name(zOrganogramDetails.getDbmName());
                        detailsTmpEntity.setDbm_approval_status("PENDING");
                    }
                    Log.d(TAG, "callPostSTOIndentApi: "+detailsTmpEntity.toString());
                    callIndentPostApi(detailsTmpEntity, tmpEntityList.size());

//                    SalesIndentDataBase.getDataBase(Stocktransfercreate.this).salesIndentDetailsDao().insertAll(detailsTmpEntity);
                    LineNo = LineNo + 1;
                }

//                Log.d("Request Data save into DB", SalesIndentDataBase.getDataBase(Stocktransfercreate.this).salesIndentDetailsDao().getAllSalesIndentRequestDetails().toString());
//                SalesIndentDataBase.getDataBase(TMSalesIndentActivity.this).salesIndentTmpDao().deleteAllSalesIndentTmpDetails();
                runOnUiThread(() -> {
                    etQtyKgPkts.setText("");
                    etRemarks.setText("");
                    spCropName.setSelection(0);
                    spVarityName.setSelection(0);
                    spItemName.setSelection(0);
                    list.setAdapter(null);
                    SerialLists.removeAll(SerialLists);
                    VarietyLists.removeAll(VarietyLists);
                    QtyLists.removeAll(QtyLists);
                    remarks_listss.removeAll(remarks_listss);
                    list.removeHeaderView(headerView);

//                    Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();

//                    Focusfirst.setFocusable(true);
//                    Focusfirst.setFocusableInTouchMode(true);
//                    Focusfirst.requestFocus();
                });


            } else {

                Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_LONG).show();


            }

        });
//
//        cScanDetails = dbStockTransfer.rawQuery("select * from StockTransferDetailsTemp", null);
//        if ((cScanDetails.getCount() == 0)) {
//            Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show();
//        } else {
//            LineNo = 1;
//            ExcelDataRead();
//        }

    }

    private int i = 1;

    private void callIndentPostApi(STOIndentTmpEntity requestDetails, int size) {
        HashMap<String, String> map = new HashMap<>();
        map.put("data", new Gson().toJson(requestDetails));
        Log.d(TAG, map.toString());
        Call<SuccessResponse> call = apiInterface.postSTOIndentRequest(map);
        call.enqueue(new Callback<SuccessResponse>() {
            @Override
            public void onResponse(Call<SuccessResponse> call, Response<SuccessResponse> response) {
                Log.d("Post Data", "success");
                if (size == i) {
                    prgDialog.hide();
                    Toast.makeText(StockTransferCreateActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    SalesIndentDataBase.databaseWriteExecutor.execute(() -> {
                        salesIndentDataBase.stoIndentTmpDao().deleteAllSTOIndentTmpDetails();
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
                Toast.makeText(StockTransferCreateActivity.this, "Invalid response", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean calc(double qty2, String pkgSize2) {
//        String[] pkg = pkgSize2.split("-");
        //  String[] size = pkg[1].trim().split("\\s+");
//        try {
//
//        }catch (Exception e){
//            return false;
//        }

        try {
            int_size = Integer.parseInt(weightinkgorgms);
        } catch (NumberFormatException e) {
            int_size = Float.parseFloat(weightinkgorgms);

        }


        if (UnitIDtosend.equals("Kg") || UnitIDtosend.equals("kg")) {
            int_type = " Kgs";
            if ((qty2 - (int) qty2) != 0) {
                float result = (float) (qty2) % int_size;

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
            int_size = Integer.parseInt(weightinkgorgms);
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

    public static double delta(double d1, double d2) {
//        return Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
        return Math.abs(d1) / Math.abs(d2);
    }

    public void IndentCodeSave() {

        ISIndentCodeFile.delete();
        try {
            FileWriter fw = new FileWriter(ISIndentCodeFile, true);
            BufferedWriter pw = new BufferedWriter(fw);
            pw.append(IndentCodeFinal + "\r\n");
            pw.flush();
            pw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
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
                LayoutInflater inflater = StockTransferCreateActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.linedatalist, null);

                holder.SList = convertView.findViewById(R.id.textView1);
                holder.VList = convertView.findViewById(R.id.textView2);
                holder.QList = convertView.findViewById(R.id.textView3);
                holder.remarks = convertView.findViewById(R.id.edittext_remarks);

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;


            holder.SList.setText(SerialList[position]);
            holder.VList.setText(VarietyList[position]);
            holder.QList.setText(QtyList[position]);
            holder.remarks.setText(remarks_list[position]);

            return convertView;
        }

        private class ViewHolder {
            TextView SList;
            TextView VList;
            TextView QList;
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

    private void ExcelDataRead() {
        if (isTableExists(dbStockTransfer, "StockTransferDetailsTemp")) {

            cScanDetails = dbStockTransfer.rawQuery("select MAX(id) from StockTransferDetailsTemp ", null);
            if (cScanDetails.moveToFirst()) {
                totalcountPoevent = Integer.parseInt(cScanDetails.getString(0));
            }
            while (cScanDetails.moveToNext()) ;

            cScanDetails = dbStockTransfer.rawQuery("select * from StockTransferDetailsTemp", null);

            int line_number = 1;
            if (cScanDetails.moveToFirst()) {

                do {
                    if (line_number == LineNo) {
                        IndentCreationCode_ = cScanDetails.getString(1);
                        IndentCodeFinal_ = cScanDetails.getString(2);
                        from_ware_id_ = cScanDetails.getString(3);
                        from_ware_name_ = cScanDetails.getString(4);
                        to_ware_name_ = cScanDetails.getString(5);
                        to_ware_id_ = cScanDetails.getString(6);
                        CropNames_ = cScanDetails.getString(7);

                        CropType_ = cScanDetails.getString(8);

                        st_exp_date_ = cScanDetails.getString(9);
                        POCodeGet_ = cScanDetails.getString(10);
                        SiteGet_ = cScanDetails.getString(11);
                        packing_id_ = cScanDetails.getString(12);
                        PkgName_ = cScanDetails.getString(13);
                        UomValueCheck_ = cScanDetails.getString(14);
                        QtyInKgs_ = cScanDetails.getString(15);
                        Acting_ = cScanDetails.getString(16);
                        DCode_ = cScanDetails.getString(17);
                        ItemIDtosend_ = cScanDetails.getString(18);
                        Itemnametosend_ = cScanDetails.getString(19);
                        remarks_ = cScanDetails.getString(20);


                        // PackagingIDsend_=cScanDetails.getString();


//idcode
                        insertToDatabase1();
                    }
                    line_number = line_number + 1;

                } while (cScanDetails.moveToNext());
            }

            spVarityName.setSelection(0);
            spCropName.setSelection(0);
            spItemName.setSelection(0);

            list.setAdapter(null);
            SerialLists.removeAll(SerialLists);
            VarietyLists.removeAll(VarietyLists);
            QtyLists.removeAll(QtyLists);
            remarks_listss.removeAll(remarks_listss);
            list.removeHeaderView(headerView);

        }
    }

}
