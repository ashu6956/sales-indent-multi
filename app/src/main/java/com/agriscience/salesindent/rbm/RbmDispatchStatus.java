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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

import com.agriscience.salesindent.AppSharedPreferences;
import com.agriscience.salesindent.R;
import com.agriscience.salesindent.Retrofit.ApiClient;
import com.agriscience.salesindent.Retrofit.ApiInterface;
import com.agriscience.salesindent.WIFIInternetConnectionDetector;
import com.agriscience.salesindent.model.STOIndentDetailsResponse;
import com.agriscience.salesindent.model.STOIndentResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RbmDispatchStatus extends Fragment {

    ListView approvedListView;

    // Connection detector class
    WIFIInternetConnectionDetector cd;
    ProgressDialog prgDialog;

    LinearLayout approvedHeaderView;



    private AppSharedPreferences appSharedPreferences;
    private ApiInterface apiInterface;

    public RbmDispatchStatus() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appSharedPreferences =new AppSharedPreferences(requireActivity());
        apiInterface =ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rbm_dispatch_status, container, false);
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
