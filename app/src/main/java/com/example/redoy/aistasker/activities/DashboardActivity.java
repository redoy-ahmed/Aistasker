package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.fragments.DashboardNotificationsFragment;
import com.example.redoy.aistasker.fragments.DashboardStatsFragment;

import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        initializeWidgets();
    }

    public void initializeWidgets() {
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_stats, new DashboardStatsFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_notifications, new DashboardNotificationsFragment()).commit();
    }
}
