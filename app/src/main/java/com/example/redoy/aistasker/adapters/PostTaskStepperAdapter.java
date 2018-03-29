package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.fragments.StepFragmentPostTaskBudget;
import com.example.redoy.aistasker.fragments.StepFragmentPostTaskDetails;
import com.example.redoy.aistasker.fragments.StepFragmentPostTaskDueDate;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class PostTaskStepperAdapter extends AbstractFragmentStepAdapter {

    public PostTaskStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            return new StepFragmentPostTaskDetails();
        } else if (position == 1) {
            return new StepFragmentPostTaskDueDate();
        } else {
            return new StepFragmentPostTaskBudget();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        StepViewModel.Builder builder = new StepViewModel.Builder(context);
        switch (position) {
            case 0:
                builder.setTitle("DETAILS")
                        .setEndButtonLabel("CONTINUE")
                        .setNextButtonEndDrawableResId(R.drawable.ms_ic_chevron_right)
                        .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
                break;
            case 1:
                builder.setTitle("DUE DATE")
                        .setEndButtonLabel("CONTINUE")
                        .setBackButtonLabel("DETAILS")
                        .setBackButtonStartDrawableResId(R.drawable.ms_ic_chevron_left);
                break;
            case 2:
                builder.setTitle("BUDGET")
                        .setBackButtonLabel("DUE DATE")
                        .setEndButtonLabel("POST TASK");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }
}
