package com.agriscience.salesindent.stodbm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.agriscience.salesindent.stodbm.DbmStockApproved;
import com.agriscience.salesindent.stodbm.DbmStockPending;
import com.agriscience.salesindent.stodbm.DbmStockRejected;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.agriscience.salesindent.R;
import com.agriscience.salesindent.widgets.FCViewPager;

public class DbmStockReportActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private FCViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbm_stockreport);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setEnableSwipe(false);

        tabLayout = findViewById(R.id.tabslayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DbmStockApproved(), "Approved");
        adapter.addFragment(new DbmStockRejected(), "Rejected");
        adapter.addFragment(new DbmStockPending(), "Pending");

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
                    return new DbmStockApproved();
                case 1:
                    return new DbmStockRejected();
                case 2:
                    return new DbmStockPending();
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

    @Override
    public void onBackPressed() {
        finish();
    }

    public void CloseActivity(View view) {
        finish();
    }

}
