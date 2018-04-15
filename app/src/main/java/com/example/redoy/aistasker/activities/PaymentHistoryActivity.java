package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.fragments.EarnedPaymentsFragment;
import com.example.redoy.aistasker.fragments.MakePaymentsFragment;
import com.example.redoy.aistasker.fragments.OutgoingPaymentsFragment;
import com.example.redoy.aistasker.fragments.ReceivePaymentsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentHistoryActivity extends AppCompatActivity {

    @BindView(R.id.payment_history_view_pager)
    ViewPager mViewPager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadDataIntoWidgets();
    }

    private void loadDataIntoWidgets() {
        context = getApplicationContext();
        setupViewPager();
    }

    private void setupViewPager() {
        PaymentHistoryActivity.ViewPagerAdapter adapter = new PaymentHistoryActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new EarnedPaymentsFragment(), context.getString(R.string.payment_history_tab_title_earned));
        adapter.addFrag(new OutgoingPaymentsFragment(), context.getString(R.string.payment_history_tab_title_outgoing));
        mViewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
