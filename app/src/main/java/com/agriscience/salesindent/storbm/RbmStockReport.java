package com.agriscience.salesindent.storbm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.agriscience.salesindent.storbm.RbmStockApproved;
import com.agriscience.salesindent.storbm.RbmStockPending;
import com.agriscience.salesindent.storbm.RbmStockRejected;
import com.agriscience.salesindent.widgets.FCViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.agriscience.salesindent.R;

public class RbmStockReport extends AppCompatActivity {

    private TabLayout tabLayout;
    private FCViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbm_stockreport);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setEnableSwipe(false);

        tabLayout = findViewById(R.id.tabslayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RbmStockApproved(), "Approved");
        adapter.addFragment(new RbmStockRejected(), "Rejected");
        adapter.addFragment(new RbmStockPending(), "Pending");

        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new RbmStockApproved();
                case 1:
                    return new RbmStockRejected();
                case 2:
                    return new RbmStockPending();
            }
            return null;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
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

//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        getData();
//    }
//
//    private void getData() {
//
//        if (DCode.equals("ZM")){
//            FullIPData=  IPAddress+ProjectFolder+"/ISStockTransfer_ZMReport.php?ZMCode="+POCodeGet;
//        }else {
//            FullIPData=  IPAddress+ProjectFolder+"/ISStockTransfer_RBMReport.php?RBMCode="+POCodeGet;
//        }
//
//
//            isConnectionExist = cd.checkMobileInternetConn();
//            isConnectionExistMobile = cd.checkMobileInternetConns();
//
//            if (isConnectionExist || isConnectionExistMobile) {
//
//
//                prgDialog.show();
//                class GetDataJSON extends AsyncTask<String, Void, String> {
//
//                    @Override
//                    protected String doInBackground(String... params) {
//                        DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                        HttpPost httppost = new HttpPost(FullIPData);
//                        httppost.setHeader("Content-type", "application/json");
//                        InputStream inputStream = null;
//                        String result = null;
//                        try {
//                            HttpResponse response = httpclient.execute(httppost);
//                            HttpEntity entity = response.getEntity();
//
//                            inputStream = entity.getContent();
//                            // json is UTF-8 by default
//                            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                            StringBuilder sb = new StringBuilder();
//
//                            String line = null;
//                            while ((line = reader.readLine()) != null) {
//                                sb.append(line + "\n");
//                            }
//                            result = sb.toString();
//                        } catch (Exception e) {
//                            prgDialog.cancel();
//                        } finally {
//                            try {
//                                if (inputStream != null) inputStream.close();
//                            } catch (Exception squish) {
//                                prgDialog.cancel();
//                            }
//                        }
//                        return result;
//                    }
//
//                    @Override
//                    protected void onPostExecute(String result) {
//                        myJSON = result;
//                        prgDialog.cancel();
//                        if (result!=null){
//                            try {
//                                showList3();
//                            }catch (Exception e){
//                                prgDialog.cancel();
//                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//                            }
//                        }else{
//                            // Internet connection doesn't exist
//                            showAlertDialog(getApplicationContext(), "No Internet Connection",
//                                    "Your device doesn't have WIFI or Data Plan internet access", false);
//
//                            prgDialog.cancel();
//                        }
//                    }
//                }
//                GetDataJSON g = new GetDataJSON();
//                g.execute();
//            } else {
//                showAlertDialog(this, "No Internet Connection",
//                        "Your device doesn't have WIFI or Data Plan internet access", false);
//            }
//    }
//
//    protected void showList3() {
//
//        isConnectionExist = cd.checkMobileInternetConn();
//        isConnectionExistMobile = cd.checkMobileInternetConns();
//
//        if (isConnectionExist || isConnectionExistMobile) {
//
//            codes1.removeAll(codes1);
//            codes2.removeAll(codes2);
//            codes3.removeAll(codes3);
//            codes4.removeAll(codes4);
//            codes5.removeAll(codes5);
//            codes6.removeAll(codes6);
//            codes7.removeAll(codes7);
//            codes8.removeAll(codes8);
//            lv.setAdapter(null);
//
//            try {
//                JSONObject jsonObj = new JSONObject(myJSON);
//                peoples = jsonObj.getJSONArray(TAG_RESULTS);
//
//                for (int i = 0; i < peoples.length(); i++) {
//                    JSONObject c = peoples.getJSONObject(i);
//
//                    String A = c.getString(T2);
//                    String B = c.getString(T3);
//                    String C = c.getString(T4);
//                    String D = c.getString(T5);
//                    String E = c.getString(T6);
//                    String F = c.getString(T7);
//                    String G = c.getString(T8);
//                    String H = c.getString(T9);
//                    /* String I = c.getString(T10);
//                    String J =c.getString(T11);
//                    String K = c.getString(T12);
//                    String L = c.getString(T13);
//
//                    String M = c.getString(T14);
//                    String N = c.getString(T15);
//                    String O = c.getString(T16);
//                    String P = c.getString(T17);
//                    String Q = c.getString(T18);
//                    String R = c.getString(T19);
//                    String S = c.getString(T20);
//                    String T = c.getString(T21);
//                    String U = c.getString(T22);
//                    String V = c.getString(T23);
//                    String W = c.getString(T24);
//                    String X = c.getString(T25);
//                    String Y = c.getString(T26);
//                    String Z = c.getString(T27);*/
//
//                    HashMap<String, String> persons = new HashMap<String, String>();
//
//                    persons.put(T2, A);
//                    persons.put(T3, B);
//                    persons.put(T4, C);
//                    persons.put(T5, D);
//                    persons.put(T6, E);
//                    persons.put(T7, F);
//                    persons.put(T8, G);
//                    persons.put(T9, H);
//                    /* persons.put(T10, I);
//                    persons.put(T11, J);
//                    persons.put(T12, K);
//                    persons.put(T13, L);
//                    persons.put(T14, M);
//                    persons.put(T15, N);
//                    persons.put(T16, O);
//                    persons.put(T17, P);
//                    persons.put(T18, Q);
//                    persons.put(T19, R);
//                    persons.put(T20, S);
//                    persons.put(T21, T);
//                    persons.put(T22, U);
//                    persons.put(T23, V);
//                    persons.put(T24, W);
//                    persons.put(T25, X);*/
//
//                    Check="chckfile";
//                    codes1.add(A);
//                    codes2.add(B);
//                    codes3.add(C);
//                    codes4.add(D);
//                    codes5.add(E);
//                    codes6.add(F);
//                    codes7.add(G);
//                    codes8.add(H);
//
//                    arr_st_no = new String[codes1.size()];
//                    arr_from_ware = new String[codes2.size()];
//                    arr_to_ware = new String[codes3.size()];
//                    arr_crop_type = new String[codes4.size()];
//                    arr_crop_name = new String[codes5.size()];
//                    arr_status = new String[codes6.size()];
//                    arr_qty = new String[codes7.size()];
//                    arr_exp_date = new String[codes8.size()];
//                }
//
//                for (int j = 0; j < codes1.size(); j++) {
//
//                    arr_st_no[j] = codes1.get(j);
//                    arr_from_ware[j] = codes2.get(j);
//                    arr_to_ware[j] = codes3.get(j);
//                    arr_crop_type[j] = codes4.get(j);
//                    arr_crop_name[j] = codes5.get(j);
//                    arr_status[j] = codes6.get(j);
//                    arr_qty[j] = codes7.get(j);
//                    arr_exp_date[j] = codes8.get(j);
//                }
//
//                if (Check.equals("chckfile")) {
//                    MyListAdapter myListAdapter = new MyListAdapter();
//                    lv.setAdapter(myListAdapter);
//                    setListViewHeightBasedOnItems(lv);
//                    lv.setVisibility(View.VISIBLE);
//                    HeaderView.setVisibility(View.VISIBLE);
//                    prgDialog.cancel();
//                }else {
//                    Toast.makeText(getApplicationContext(), "No Data Available", Toast.LENGTH_SHORT).show();
//                    prgDialog.cancel();
//                    //finish();
//                    HeaderView.setVisibility(View.GONE);
//                }
//            } catch (JSONException e) {
//                Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
//                e.printStackTrace();
//                prgDialog.cancel();
//                HeaderView.setVisibility(View.GONE);
//            }
//        } else{
//            showAlertDialog(this, "No Internet Connection",
//                    "Your device doesn't have WIFI or Data Plan internet access", false);
//        }
//    }
//
//    public void showAlertDialog(Context context, String title, String message, Boolean status) {
//        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
//
//        // Setting Dialog Title
//        alertDialog.setTitle(title);
//
//        // Setting Dialog Message
//        alertDialog.setMessage(message);
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
//    private class MyListAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
////            // TODO Auto-generated method stub
//            if (arr_st_no != null && arr_st_no.length != 0) {
//                return arr_st_no.length;
//            }
//            return 0;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            // TODO Auto-generated method stub
//            return arr_st_no[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            // TODO Auto-generated method stub
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
////            ViewHolder holder = null;
//
//            final MyListAdapter.ViewHolder holder;
//            if (convertView == null) {
//
//                holder = new MyListAdapter.ViewHolder();
//                LayoutInflater inflater = getLayoutInflater();
//                convertView = inflater.inflate(R.layout.stock_reportlist, null);
//
//                holder.text_st_no = convertView.findViewById(R.id.text_st_no);
//                holder.text_from = convertView.findViewById(R.id.text_from_ware);
//                holder.text_to = convertView.findViewById(R.id.text_to_ware);
//                holder.text_crop = convertView.findViewById(R.id.text_crop_type);
//                holder.edit_qty = convertView.findViewById(R.id.edit_qty);
//                holder.text_exp_date = convertView.findViewById(R.id.text_exp_date);
//                holder.text_status= convertView.findViewById(R.id.text_status);
//                holder.text_remarks = convertView.findViewById(R.id.text_remarks);
//                holder.text_remarks.setEnabled(false);
//                holder.DS = convertView.findViewById(R.id.DS);
//                convertView.setTag(holder);
//
//            } else {
//
//                holder = (MyListAdapter.ViewHolder) convertView.getTag();
//            }
//
//            holder.ref = position;
//            holder.text_st_no.setText(arr_st_no[position]);
//            holder.text_from.setText(arr_from_ware[position]);
//            holder.text_to.setText(arr_to_ware[position]);
//            holder.text_crop.setText(arr_crop_type[position]);
//            holder.edit_qty.setText(arr_qty[position]);
//            holder.text_exp_date.setText(arr_exp_date[position]);
//            holder.text_status.setText(arr_status[position]);
//            return convertView;
//        }
//
//        private class ViewHolder {
//            TextView text_st_no;
//            TextView text_from;
//            TextView text_to;
//            TextView text_crop;
//            EditText edit_qty;
//            TextView text_exp_date;
//            TextView text_status;
//            TextView text_remarks;
//            LinearLayout DS;
//            int ref;
//        }
//    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void CloseActivity(View view) {
        finish();
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
