package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.redoy.aistasker.R;

import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class PostTaskFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_post_task, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
