package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepFragmentPostTaskBudget extends Fragment implements Step {

    View rootView;

    @BindView(R.id.post_task_price_edit_text_hourly_rate)
    EditText mEditTextHourlyRate;

    @BindView(R.id.post_task_price_edit_text_hours)
    EditText mEditTextHours;

    @BindView(R.id.post_task_price_edit_text_price)
    EditText mEditTextPriceTotal;

    @BindView(R.id.post_task_price_layout_hourly_rate)
    LinearLayout mLayoutHourlyRate;

    @BindView(R.id.post_task_price_layout_total_price)
    RelativeLayout mLayoutPriceTotal;

    @BindView(R.id.post_task_price_state_selector_widget)
    Switch mScreenStateSelectorWidget;

    @BindView(R.id.post_task_price_text_view_decrease_worker)
    TextView mTextViewDecreaseWorkerCount;

    @BindView(R.id.post_task_price_text_view_increase_worker)
    TextView mTextViewIncreaseWorkerCount;

    @BindView(R.id.post_task_price_text_view_estimated_budget_per_runner_label)
    TextView mTextViewPerRunnerLabel;

    @BindView(R.id.post_task_price_text_view_estimated_budget)
    TextView mTextViewTotalBudget;

    @BindView(R.id.post_task_price_text_view_workers_count)
    TextView mTextViewWorkersCount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_post_task_budget, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public VerificationError verifyStep() {
        //return null if the user can go to the next step, create a new VerificationError instance otherwise
        return null;
    }

    @Override
    public void onSelected() {
        //update UI when selected
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        //handle error inside of the fragment, e.g. show error on EditText
    }
}
