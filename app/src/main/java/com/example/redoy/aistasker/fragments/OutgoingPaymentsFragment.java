package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.redoy.aistasker.R;

import butterknife.ButterKnife;

public class OutgoingPaymentsFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_outgoing_payment, container, false);
        ButterKnife.bind(this, rootView);
        initializeData();

        return rootView;
    }

    private void initializeData() {

    }
}