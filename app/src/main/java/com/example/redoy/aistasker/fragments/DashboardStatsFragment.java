package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.redoy.aistasker.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardStatsFragment extends Fragment {

    View rootView;
    private List<View> f2571b;

    @BindView(R.id.assigned_bar)
    View assignedBar;

    @BindView(R.id.assigned_value)
    TextView assignedValue;

    @BindView(R.id.awaiting_bar)
    View awaitingBar;

    @BindView(R.id.awaiting_value)
    TextView awaitingValue;

    @BindView(R.id.bar_graph)
    LinearLayout barGraph;

    @BindView(R.id.bid_bar)
    View bidBar;

    @BindView(R.id.bid_lbl)
    TextView bidLbl;

    @BindView(R.id.bid_value)
    TextView bidValue;

    @BindView(R.id.preview_offer_image_view_completion_rate_info)
    ImageView imageViewCompletionRateInfo;

    @BindView(R.id.lbl_completed_tasks)
    TextView lblCompletedTasks;

    @BindView(R.id.dashboard_state_selector_widget)
    SwitchCompat mScreenStateSelectorWidget;

    @BindView(R.id.overdue_bar)
    View overdueBar;

    @BindView(R.id.overdue_value)
    TextView overdueValue;

    @BindView(R.id.preview_offer_rating_bar)
    RatingBar ratingBar;

    @BindView(R.id.preview_offer_text_view_completion_rate)
    TextView textViewCompletionRate;

    @BindView(R.id.preview_offer_text_view_rating_and_reviews)
    TextView textViewNumberOfReviews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_dashboard_stats, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
