package com.agriscience.salesindent.tm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.agriscience.salesindent.tm.TmApprovedFragment;
import com.agriscience.salesindent.tm.TmPendingFragment;
import com.agriscience.salesindent.tm.TmRejectedFragment;
import com.agriscience.salesindent.widgets.FCViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.agriscience.salesindent.R;


public class TMReportViewActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private FCViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmreport_view);

        //Generate list View from ArrayList

        getSupportActionBar().hide();

        viewPager =(FCViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setEnableSwipe(false);

        tabLayout = findViewById(R.id.tabslayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TmApprovedFragment(), "Approved");
        adapter.addFragment(new TmRejectedFragment(), "Rejected");
        adapter.addFragment(new TmPendingFragment(), "Pending");
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
                    return new TmApprovedFragment();
                case 1:
                    return new TmRejectedFragment();
                case 2:
                    return new TmPendingFragment();
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


}
