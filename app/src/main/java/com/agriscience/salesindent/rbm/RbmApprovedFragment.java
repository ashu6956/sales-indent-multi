package com.agriscience.salesindent.rbm;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.agriscience.salesindent.AppLocationService;
import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.CountryRemark;
import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;

import com.agriscience.salesindent.R;

import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.SalesIndentStatusDetailsResponse;
import com.agriscience.salesindent.model.SalesIndentStatusResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RbmApprovedFragment extends Fragment {





    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;

    TextView textDeviceID;
    // Connection detector class
    WIFIInternetConnectionDetector cd;


    ProgressDialog prgDialog;

    AppLocationService appLocationService;
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

    ListView approvedListView;


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
    private String [] item_remarks_string;




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
    List<Boolean> checkBoxStateCheck2 = new ArrayList<Boolean>();


    String IPAddress = "http://103.44.97.110:8080/kanagaraj/";



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
    List<String> cody = new ArrayList<String>();

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

    LinearLayout approvedHeaderView;


    List<String> RejectRemarkscheck2 = new ArrayList<String>();
    List<Boolean> IndentBoxStateCheck2 = new ArrayList<Boolean>();
    List<Boolean> RejectBoxStateCheck2 = new ArrayList<Boolean>();
    List<String> AxQtyInBagCheck2 = new ArrayList<String>();


    private AppSharedPreferences appSharedPreferences;
    private ApiInterface apiInterface;


    public RbmApprovedFragment() {
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
        View view = inflater.inflate(R.layout.fragment_approved, container, false);
        appSharedPreferences = new AppSharedPreferences(requireContext());
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        appLocationService = new AppLocationService(getActivity());

        approvedListView = view.findViewById(R.id.listView);


        approvedHeaderView = (LinearLayout) view.findViewById(R.id.Header);


        LableName = (TextView) view.findViewById(R.id.textView33);


        cd = new WIFIInternetConnectionDetector(getActivity());

        prgDialog = new ProgressDialog(getActivity(), R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));


        callSalesIndentStatusApi(appSharedPreferences.getUserId());

        return view;
    }


    private void callSalesIndentStatusApi(String rbmId) {
//        prgDialog.show();
        Call<SalesIndentStatusResponse> call = apiInterface.getAllRbmStatusDetails(rbmId);
        call.enqueue(new Callback<SalesIndentStatusResponse>() {
            @Override
            public void onResponse(Call<SalesIndentStatusResponse> call, Response<SalesIndentStatusResponse> response) {
                SalesIndentStatusResponse statusResponse = response.body();
                Log.d("TmApproved",statusResponse.toString());
                prgDialog.hide();
                if (statusResponse.getResult() != null && statusResponse.getResult().size() > 0) {
                    Log.d("TmApproved result",statusResponse.getResult().size()+" "+statusResponse.getResult().toString());
                    approvedListView.setVisibility(View.VISIBLE);
                    SalesIndentStatusListAdapter statusListAdapter = new SalesIndentStatusListAdapter(statusResponse.getResult());
                    approvedListView.setAdapter(statusListAdapter);
                    setListViewHeightBasedOnChildren(approvedListView);
                }
                else {
                    approvedListView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<SalesIndentStatusResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
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
            SalesIndentStatusDetailsResponse detailsResponse = detailsResponseList.get(position);
            final ViewHolder holder;
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

                holder.Textview_item_remarks = convertView.findViewById(R.id.item_remarks);
                holder.Textview_item_remarks.setEnabled(false);
                holder.Textview_item_remarks.setVisibility(View.VISIBLE);


                holder.etPackingSize = (EditText) convertView.findViewById(R.id.etPackingSize);
                holder.etPackingSize.setEnabled(false);
                holder.etQtyInKgPKts = (EditText) convertView.findViewById(R.id.etQtyInKgPkts);
                holder.etQtyInKgPKts.setEnabled(false);
                holder.RejectRemarks = (EditText) convertView.findViewById(R.id.editText6);
                holder.RejectRemarks.setEnabled(false);
                holder.DS = convertView.findViewById(R.id.DS);
                convertView.setTag(holder);


            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;


            if (detailsResponse.getRbmApprovalStatus()!=null && detailsResponse.getRbmApprovalStatus().trim().equalsIgnoreCase("APPROVED")) {
                approvedHeaderView.setVisibility(View.VISIBLE);
                holder.DS.setVisibility(View.VISIBLE);
            } else {
                holder.DS.setVisibility(View.GONE);
            }


            holder.code.setText(detailsResponse.getIndentNo());
            holder.eventdatas.setText(detailsResponse.getCustomerName());
            holder.etQtyInKgPKts.setText(detailsResponse.getQuantityInKgsOrPackets());
            holder.AXHybrids.setText(detailsResponse.getMaterialName());

            holder.AxIndentDates.setText(detailsResponse.getIndentDate());
            holder.AXCustAccounts.setText(detailsResponse.getCustomerCode());


            holder.etPackingSize.setText(detailsResponse.getPackingQuantity());
//            holder.QtyInKgs.setText( AxQtyInKgs[position]);

//            if (!CancelRemarks[position].equals("null") || !CancelRemarks[position].equals("") || CancelRemarks[position]!=null){
//                holder.RejectRemarks.setText(CancelRemarks[position]);
//            }

            holder.AxStatuss.setText(detailsResponse.getRbmApprovalStatus());

            // Log.d("String-----------","----------"+AxStatus[position]);

            holder.Textview_item_remarks.setText(detailsResponse.getTiRemarks());

//



            return convertView;
        }


        private class ViewHolder {
            TextView code;
            TextView eventdatas;
            CheckBox name;
            EditText Qtys;
            EditText etPackingSize;
            EditText etQtyInKgPKts;
            TextView AxcodeID;

            TextView AXHybrids;
            TextView AxIndentDates;
            TextView AXCustAccounts;
            EditText RejectRemarks;
            TextView AxStatuss;
            LinearLayout DS;

            EditText Textview_item_remarks;

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
                holder.item_remarks =(EditText) convertView.findViewById(R.id.item_remarks);
                holder.item_remarks.setEnabled(false);
                holder.DS = convertView.findViewById(R.id.DS);
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

//            if (!CancelRemarks[position].equals("null") || !CancelRemarks[position].equals("") || CancelRemarks[position]!=null) {
//                holder.RejectRemarks.setText(CancelRemarks[position]);
//            }

            holder.AxStatuss.setText(AxStatus[position]);
            if(item_remarks_string[position].equals("")){

            }
            else{
                holder.item_remarks.setText(item_remarks_string[position]);
                Log.d("stringssssss","---------------"+item_remarks_string[position]);
            }


            if (AxStatus[position].equals("APPROVED")){
                holder.DS.setVisibility(View.VISIBLE);
                Log.d("stringssssss","---------------"+item_remarks_string[position]);
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

            int ref;


           EditText item_remarks;

        }




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

        getActivity().finish();


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


}
