package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.redoy.aistasker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardNotificationsFragment extends Fragment {

    View rootView;

    @BindView(R.id.dashboard_notifications_layout)
    LinearLayout mLayoutNotifications;

    @BindView(R.id.dashboard_notifications_progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.dashboard_notifications_text_view_error)
    TextView mTextViewNoNotifications;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_dashboard_notifications, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
