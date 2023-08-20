package com.agriscience.salesindent.storbm;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.STOIndentDetailsResponse;
import com.agriscience.salesindent.model.STOIndentResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.agriscience.salesindent.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RbmStockApproved extends Fragment {

    Boolean isConnectionExist = false;
    Boolean isConnectionExistMobile = false;
    ListView approvedListView;
    String POCodeGet ,PONameGet ,TerritoryNameGet ,PostCodeTransferGet ,SiteGet ,DivisionGet,ProjectFolder,FullIPData ,myJSON
            ,TAG_RESULTS = "result",Check ,Acting ,DCode;

        String IPAddress="http://103.44.97.110:8080/kanagaraj/";
//    String IPAddress="http://192.168.35.24/hyveg/Sales_Indent_App/";

    // Connection detector class
    WIFIInternetConnectionDetector cd;
    ProgressDialog prgDialog;


    List<String> codes1 = new ArrayList<String>();
    List<String> codes2 = new ArrayList<String>();
    List<String> codes3 = new ArrayList<String>();
    List<String> codes4 = new ArrayList<String>();
    List<String> codes5 = new ArrayList<String>();
    List<String> codes6 = new ArrayList<String>();
    List<String> codes7 = new ArrayList<String>();
    List<String> codes8 = new ArrayList<String>();
    List<String> codes9 = new ArrayList<String>();
    List<String> codes10 = new ArrayList<String>();
    List<String> codes11 = new ArrayList<String>();
    JSONArray peoples ;

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
    LinearLayout approvedHeaderView;

    private  String[] arr_st_no;
    private  String[] arr_from_ware;
    private  String[]  arr_to_ware;
    private  String[]  arr_crop_type;
    private  String[]  arr_crop_name;
    private  String[]  arr_qty;
    private  String[]  arr_exp_date;
    private  String[]  arr_status;
    private  String[]  arr_remarks;
    private  String[]  packing_size;
    private  String[]  item_remarks;

    private AppSharedPreferences appSharedPreferences;
    private ApiInterface apiInterface;

    public RbmStockApproved() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appSharedPreferences =new AppSharedPreferences(requireActivity());
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_rbm_stock_approved, container, false);
        approvedListView = view.findViewById(R.id.listView);

        cd = new WIFIInternetConnectionDetector(getActivity());
        approvedHeaderView = view.findViewById(R.id.Header);

        prgDialog = new ProgressDialog(getActivity(), R.style.StyledDialog);
        prgDialog.setMessage("Please wait...");
        prgDialog.setCancelable(false);
        prgDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.my_progress_indeterminate));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        getData();
        callSalesIndentStatusApi(appSharedPreferences.getUserId());
    }

    private void callSalesIndentStatusApi(String rbmId) {
//        prgDialog.show();
        Call<STOIndentResponse> call = apiInterface.getAllSTORbmStatusDetails(rbmId);
        call.enqueue(new Callback<STOIndentResponse>() {
            @Override
            public void onResponse(Call<STOIndentResponse> call, Response<STOIndentResponse> response) {
                STOIndentResponse statusResponse = response.body();
                Log.d("STORbmApproved",statusResponse.toString());
                prgDialog.hide();
                if (statusResponse.getResult() != null && statusResponse.getResult().size() > 0) {
                    Log.d("TmApproved result",statusResponse.getResult().size()+" "+statusResponse.getResult().toString());
                    approvedListView.setVisibility(View.VISIBLE);
                    approvedHeaderView.setVisibility(View.VISIBLE);
                    STOStatusListAdapter statusListAdapter = new STOStatusListAdapter(statusResponse.getResult());
                    approvedListView.setAdapter(statusListAdapter);
                    setListViewHeightBasedOnItems(approvedListView);
                }
                else {
                    approvedListView.setVisibility(View.GONE);
                    approvedHeaderView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<STOIndentResponse> call, Throwable t) {
                call.cancel();
                prgDialog.hide();
            }
        });
    }


    private class STOStatusListAdapter extends BaseAdapter {
        private List<STOIndentDetailsResponse> detailsResponseList;

        public STOStatusListAdapter(List<STOIndentDetailsResponse> detailsResponseList) {
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
            STOIndentDetailsResponse detailsResponse = detailsResponseList.get(position);
            ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.stock_reportlist, null);

                holder.text_st_no = convertView.findViewById(R.id.text_st_no);
                holder.text_from = convertView.findViewById(R.id.text_from_ware);
                holder.text_to = convertView.findViewById(R.id.text_to_ware);
                holder.text_crop = convertView.findViewById(R.id.text_crop_type);
                holder.edit_qty = convertView.findViewById(R.id.edit_qty);
                holder.text_exp_date = convertView.findViewById(R.id.text_exp_date);
                holder.text_status= convertView.findViewById(R.id.text_status);
                holder.text_remarks = convertView.findViewById(R.id.text_remarks);
                holder.item_remarks = convertView.findViewById(R.id.item_remarks);
                holder.text_pack_size = convertView.findViewById(R.id.text_pack);
                holder.text_remarks.setEnabled(false);
                holder.item_remarks.setEnabled(false);
                holder.DS = convertView.findViewById(R.id.DS);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;
            holder.text_st_no.setText(detailsResponse.getSTOIndentNo());
            holder.text_from.setText(detailsResponse.getReceivingPlant()+"-"+detailsResponse.getReceivingPlantName());
            holder.text_to.setText(detailsResponse.getSendingPlant()+"-"+detailsResponse.getSendingPlantName());
            holder.text_crop.setText(detailsResponse.getMaterialDescription());
            holder.text_exp_date.setText(detailsResponse.getReqDate());
            holder.text_status.setText(detailsResponse.getFinalStatus());
            holder.edit_qty.setText(detailsResponse.getFinalQuantity());
            if(detailsResponse.getDbmRemarks()!=null) {
                holder.text_remarks.setText(detailsResponse.getDbmRemarks());
            }
            else {
                holder.text_remarks.setText("");
            }

            holder.text_pack_size.setText(detailsResponse.getPackingQuantity());
            holder.item_remarks.setText(detailsResponse.getRbmRemarks());
//            if (arr_status[position].equals("APPROVED")){
            if (detailsResponse.getFinalStatus().equalsIgnoreCase("APPROVED")){
                holder.text_status.setText(detailsResponse.getFinalStatus());
                holder.DS.setVisibility(View.VISIBLE);
            }else {
                holder.DS.setVisibility(View.GONE);
            }
            return convertView;
        }

        private class ViewHolder {
            TextView text_st_no;
            TextView text_from;
            TextView text_to;
            TextView text_crop;
            EditText edit_qty;
            TextView text_exp_date;
            TextView text_status;
            EditText text_remarks, item_remarks;
            TextView text_pack_size;
            LinearLayout DS;
            int ref;
        }


    }





    private void getData() {

        if (DCode.equals("ZM")){
            FullIPData=  IPAddress+ProjectFolder+"/ISStockTransfer_ZMReport.php?ZMCode="+POCodeGet;
        }else {
            FullIPData=  IPAddress+ProjectFolder+"/ISStockTransfer_RBMReport.php?RBMCode="+POCodeGet;
        }


        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {


            prgDialog.show();
            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {
                    DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                    Log.e("rbm_approve",FullIPData);
                    HttpPost httppost = new HttpPost(FullIPData);
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
                    prgDialog.cancel();
                    if (result!=null){
                        try {
                            Log.e(TAG_RESULTS ,"resultssss "+result);
                            showList3();
                        }catch (Exception e){
                            Log.e(TAG_RESULTS ,"error "+e.toString());
                            prgDialog.cancel();
                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        // Internet connection doesn't exist
                        showAlertDialog(getActivity(), "No Internet Connection",
                                "Your device doesn't have WIFI or Data Plan internet access", false);

                        prgDialog.cancel();
                    }
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute();
        } else {
            showAlertDialog(getActivity(), "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
    }

    protected void showList3() {

        isConnectionExist = cd.checkMobileInternetConn();
        isConnectionExistMobile = cd.checkMobileInternetConns();

        if (isConnectionExist || isConnectionExistMobile) {

            Check = "";

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
            approvedListView.setAdapter(null);

            try {
                JSONObject jsonObj = new JSONObject(myJSON);
                peoples = jsonObj.getJSONArray(TAG_RESULTS);

                for (int i = 0; i < peoples.length(); i++) {
                    JSONObject c = peoples.getJSONObject(i);

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
                    /*  String K = c.getString(T12);
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
                    /*   persons.put(T12, K);
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
                    persons.put(T25, X);*/

                    Check="chckfile";
                    codes1.add(A);
                    codes2.add(B);
                    codes3.add(C);
                    codes4.add(D);
                    codes5.add(E);
                    codes6.add(F);
                    codes7.add(G);
                    codes8.add(H);
                    codes9.add(I);
                    codes10.add(J);
                    codes11.add(K);

                    arr_st_no = new String[codes1.size()];
                    arr_from_ware = new String[codes2.size()];
                    arr_to_ware = new String[codes3.size()];
                    arr_crop_type = new String[codes4.size()];
                    arr_crop_name = new String[codes5.size()];
                    arr_status = new String[codes6.size()];
                    arr_qty = new String[codes7.size()];
                    arr_exp_date = new String[codes8.size()];
                    arr_remarks = new String[codes9.size()];
                    packing_size = new String[codes10.size()];
                    item_remarks = new String[codes11.size()];
                }

                for (int j = 0; j < codes1.size(); j++) {

                    arr_st_no[j] = codes1.get(j);
                    arr_from_ware[j] = codes2.get(j);
                    arr_to_ware[j] = codes3.get(j);
                    arr_crop_type[j] = codes4.get(j);
                    arr_crop_name[j] = codes5.get(j);
                    arr_status[j] = codes6.get(j);
                    arr_qty[j] = codes7.get(j);
                    arr_exp_date[j] = codes8.get(j);
                    arr_remarks[j] = codes9.get(j);
                    packing_size[j] = codes10.get(j);
                    item_remarks[j] = codes11.get(j);
                }

                if (Check.equals("chckfile")) {
                    MyListAdapter myListAdapter = new MyListAdapter();
                    approvedListView.setAdapter(myListAdapter);
                    setListViewHeightBasedOnItems(approvedListView);
                    approvedListView.setVisibility(View.VISIBLE);
                    approvedHeaderView.setVisibility(View.VISIBLE);
                    prgDialog.cancel();
                }else {
                    Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                    prgDialog.cancel();
                    //finish();
                    approvedHeaderView.setVisibility(View.GONE);
                }
            } catch (JSONException e) {
                Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                prgDialog.cancel();
                approvedHeaderView.setVisibility(View.GONE);
            }
        } else{
            showAlertDialog(getActivity(), "No Internet Connection",
                    "Your device doesn't have WIFI or Data Plan internet access", false);
        }
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

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
//            // TODO Auto-generated method stub
            if (arr_st_no != null && arr_st_no.length != 0) {
                return arr_st_no.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return arr_st_no[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            final ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.stock_reportlist, null);

                holder.text_st_no = convertView.findViewById(R.id.text_st_no);
                holder.text_from = convertView.findViewById(R.id.text_from_ware);
                holder.text_to = convertView.findViewById(R.id.text_to_ware);
                holder.text_crop = convertView.findViewById(R.id.text_crop_type);
                holder.edit_qty = convertView.findViewById(R.id.edit_qty);
                holder.text_exp_date = convertView.findViewById(R.id.text_exp_date);
                holder.text_status= convertView.findViewById(R.id.text_status);
                holder.text_remarks = convertView.findViewById(R.id.text_remarks);
                holder.item_remarks = convertView.findViewById(R.id.item_remarks);
                holder.text_pack_size = convertView.findViewById(R.id.text_pack);
                holder.text_remarks.setEnabled(false);
                holder.item_remarks.setEnabled(false);
                holder.DS = convertView.findViewById(R.id.DS);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;
            holder.text_st_no.setText(arr_st_no[position]);
            holder.text_from.setText(arr_from_ware[position]);
            holder.text_to.setText(arr_to_ware[position]);
            holder.text_crop.setText(arr_crop_type[position]);
            holder.edit_qty.setText(arr_qty[position]);
            holder.text_exp_date.setText(arr_exp_date[position]);
            holder.text_status.setText(arr_status[position]);

            holder.text_pack_size.setText(packing_size[position]);
            holder.item_remarks.setText(item_remarks[position]);
//            if (arr_status[position].equals("APPROVED")){
            if (arr_status[position].equals("1")){
                holder.text_status.setText("APPROVED");
                holder.DS.setVisibility(View.VISIBLE);
            }else {
                holder.DS.setVisibility(View.GONE);
            }
            return convertView;
        }

        private  class ViewHolder {
            TextView text_st_no;
            TextView text_from;
            TextView text_to;
            TextView text_crop;
            EditText edit_qty;
            TextView text_exp_date;
            TextView text_status;
            EditText text_remarks, item_remarks;
            TextView text_pack_size;
            LinearLayout DS;
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
}
