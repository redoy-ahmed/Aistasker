package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepFragmentPostTaskDueDate extends Fragment implements Step {

    View rootView;

    @BindView(R.id.post_task_schedule_drop_down_due_date)
    Spinner mDropDownWidgetDueDate;

    @BindView(R.id.post_task_schedule_text_view_due_date)
    TextView mTextViewDueDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_post_task_due_date, container, false);
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
