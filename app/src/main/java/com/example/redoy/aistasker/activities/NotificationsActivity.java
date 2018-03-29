package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.NotificationsAdapter;
import com.example.redoy.aistasker.adapters.TaskAlertAdapter;
import com.example.redoy.aistasker.models.NotificationItem;
import com.example.redoy.aistasker.models.TaskAlert;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsActivity extends AppCompatActivity {

    @BindView(R.id.notifications_empty_state_text_view)
    TextView mEmptyStateTextView;

    @BindView(R.id.notifications_recycler_view)
    RecyclerView mNotificationRecyclerView;

    @BindView(R.id.notifications_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private NotificationsAdapter notificationsAdapter;
    Context context;
    public LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();
    }

    private void initializeData() {
        context = getApplicationContext();
        ArrayList<NotificationItem> rowListItem = getAllItemList();
        linearLayoutManager = new LinearLayoutManager(context);
        mNotificationRecyclerView.setHasFixedSize(true);
        mNotificationRecyclerView.setLayoutManager(linearLayoutManager);
        notificationsAdapter = new NotificationsAdapter(context, rowListItem);
        mNotificationRecyclerView.setAdapter(notificationsAdapter);
    }

    private ArrayList<NotificationItem> getAllItemList() {
        ArrayList<NotificationItem> allItems = new ArrayList<>();
        allItems.add(new NotificationItem("Notification 1", "29-Mar-2018"));
        allItems.add(new NotificationItem("Notification 2", "29-Mar-2018"));
        allItems.add(new NotificationItem("Notification 3", "29-Mar-2018"));
        allItems.add(new NotificationItem("Notification 4", "29-Mar-2018"));

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
