package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.TaskAlertAdapter;
import com.example.redoy.aistasker.models.TaskAlert;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskAlertsActivity extends AppCompatActivity {

    public LinearLayoutManager linearLayoutManager;
    public TaskAlertAdapter taskAlertAdapter;
    Context context;

    @BindView(R.id.task_alerts_fab_new_alert)
    FloatingActionButton mFabNewAlert;

    @BindView(R.id.task_alerts_recycler_view_alerts)
    RecyclerView mRecyclerViewAlerts;

    @BindView(R.id.task_alerts_text_view_empty)
    TextView mTextViewNoAlerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_alerts);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();
    }

    private void initializeData() {
        context = getApplicationContext();

        ArrayList<TaskAlert> rowListItem = getAllItemList();
        linearLayoutManager = new LinearLayoutManager(context);
        mRecyclerViewAlerts.setHasFixedSize(true);
        mRecyclerViewAlerts.setLayoutManager(linearLayoutManager);
        taskAlertAdapter = new TaskAlertAdapter(context, rowListItem);
        mRecyclerViewAlerts.setAdapter(taskAlertAdapter);
    }

    private ArrayList<TaskAlert> getAllItemList() {
        ArrayList<TaskAlert> allItems = new ArrayList<>();
        allItems.add(new TaskAlert("Cleaning Task", "Sydney"));
        allItems.add(new TaskAlert("Writing Task", "Dhaka"));
        allItems.add(new TaskAlert("Reading Task", "Sydney"));
        allItems.add(new TaskAlert("Cleaning Task", "Sydney"));

        return allItems;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return (super.onOptionsItemSelected(menuItem));
    }

}
