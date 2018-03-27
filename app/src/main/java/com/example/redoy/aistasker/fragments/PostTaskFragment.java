package com.example.redoy.aistasker.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.activities.PostTaskActivity;
import com.example.redoy.aistasker.widget.TaskSuggestion;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class PostTaskFragment extends Fragment {

    View rootView;

    final PostTaskFragment postTaskFragment = null;

    @BindView(R.id.suggestions_layout_admin)
    FrameLayout layoutAdmin;

    @BindView(R.id.suggestions_layout_assembly)
    FrameLayout layoutAssembly;

    @BindView(R.id.suggestions_layout_cleaning)
    FrameLayout layoutCleaning;

    @BindView(R.id.suggestions_layout_coles)
    FrameLayout layoutColes;

    @BindView(R.id.suggestions_layout_delivery)
    FrameLayout layoutDelivery;

    @BindView(R.id.suggestions_layout_gardening)
    FrameLayout layoutGardening;

    @BindView(R.id.suggestions_layout_handyman)
    FrameLayout layoutHandyman;

    @BindView(R.id.suggestions_layout_it)
    FrameLayout layoutIt;

    @BindView(R.id.suggestions_layout_other)
    FrameLayout layoutOther;

    @BindView(R.id.suggestions_layout_photography)
    FrameLayout layoutPhotography;

    @BindView(R.id.suggestions_layout_removalists)
    FrameLayout layoutRemovalists;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_post_task, container, false);
        ButterKnife.bind(this, rootView);

        layoutCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.CLEANING);
            }
        });

        layoutAssembly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.FURNITURE);
            }
        });

        layoutHandyman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.HANDYMAN);
            }
        });


        layoutDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.PICKUP);
            }
        });

        layoutGardening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.GARDEN);
            }
        });

        layoutRemovalists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.MOVING);
            }
        });

        layoutAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.OFFICE);
            }
        });

        layoutIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.IT);
            }
        });

        layoutPhotography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.PHOTOGRAPHY);
            }
        });

        layoutOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent(TaskSuggestion.OTHER);
            }
        });

        layoutColes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return rootView;
    }

    private void startIntent(TaskSuggestion taskSuggestion) {
        Intent intent = new Intent(rootView.getContext(), PostTaskActivity.class);
        intent.putExtra(taskSuggestion.toString(), taskSuggestion.toString());
        startActivity(intent);
    }
}
