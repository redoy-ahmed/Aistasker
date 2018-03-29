package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.widget.OptionListItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    Context context;

    @BindView(R.id.layoutOptionsList)
    LinearLayout linearLayout;

    class ClassForEditProfile implements View.OnClickListener {
        final SettingsActivity settingsActivity;

        ClassForEditProfile(SettingsActivity settingsActivity) {
            this.settingsActivity = settingsActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForNotificationSettings implements View.OnClickListener {
        final SettingsActivity settingsActivity;

        ClassForNotificationSettings(SettingsActivity settingsActivity) {
            this.settingsActivity = settingsActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForChangePassword implements View.OnClickListener {
        final SettingsActivity settingsActivity;

        ClassForChangePassword(SettingsActivity settingsActivity) {
            this.settingsActivity = settingsActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForMobileVerification implements View.OnClickListener {
        final SettingsActivity settingsActivity;

        ClassForMobileVerification(SettingsActivity settingsActivity) {
            this.settingsActivity = settingsActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();
    }

    private void initializeData() {
        context = getApplicationContext();

        OptionListItem optionListItem1 = new OptionListItem(context, getString(R.string.edit_profile_screen_title), new ClassForEditProfile(this));
        OptionListItem optionListItem2 = new OptionListItem(context, getString(R.string.notifications_settings_screen_title), new ClassForNotificationSettings(this));
        OptionListItem optionListItem3 = new OptionListItem(context, getString(R.string.change_password_screen_title), new ClassForChangePassword(this));
        OptionListItem optionListItem4 = new OptionListItem(context, getString(R.string.add_mobile_number_screen_title), new ClassForMobileVerification(this));
        linearLayout.addView(optionListItem1.view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem2.view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem3.view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem4.view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
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
