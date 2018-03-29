package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.widget.YesNoWidget;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;

public class StepFragmentPostTaskDetails extends Fragment implements Step {

    View rootView;

    @BindView(R.id.post_task_details_edit_text_widget_description)
    EditText mEditTextDescription;

    @BindView(R.id.post_task_details_edit_text_widget_title)
    EditText mEditTextTitle;

    @BindView(R.id.post_task_details_layout_location_container)
    LinearLayout mLayoutLocationContainer;

    @BindView(R.id.post_task_details_location_selection_widget)
    Switch mLocationSelectionWidget;

    @BindView(R.id.post_task_details_places_auto_complete)
    EditText mPlacesAutoCompleteWidget;

    @BindView(R.id.post_task_details_text_view_location_label)
    TextView mTextViewLocationLabel;

    @BindView(R.id.list_item_task_text_view_requirements)
    TextView mTextViewTaskRequirements;

    @BindView(R.id.post_task_details_yes_no_widget_online)
    YesNoWidget mYesNoOnline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_post_task_details, container, false);

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
