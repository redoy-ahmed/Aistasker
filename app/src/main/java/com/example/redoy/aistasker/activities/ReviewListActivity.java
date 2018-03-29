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
import com.example.redoy.aistasker.adapters.ReviewListAdapter;
import com.example.redoy.aistasker.adapters.TaskAlertAdapter;
import com.example.redoy.aistasker.models.ReviewItem;
import com.example.redoy.aistasker.models.TaskAlert;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewListActivity extends AppCompatActivity {

    public LinearLayoutManager linearLayoutManager;
    private ReviewListAdapter reviewListAdapter;
    Context context;

    @BindView(R.id.review_list_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.review_list_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.review_list_view_empty)
    TextView mViewEmptyState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();
    }

    private void initializeData() {
        context = getApplicationContext();

        ArrayList<ReviewItem> rowListItem = getAllItemList();
        linearLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        reviewListAdapter = new ReviewListAdapter(context, rowListItem);
        mRecyclerView.setAdapter(reviewListAdapter);
    }

    private ArrayList<ReviewItem> getAllItemList() {
        ArrayList<ReviewItem> allItems = new ArrayList<>();
        allItems.add(new ReviewItem("Cleaning Task"));
        allItems.add(new ReviewItem("Writing Task"));
        allItems.add(new ReviewItem("Reading Task"));
        allItems.add(new ReviewItem("Cleaning Task"));

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
