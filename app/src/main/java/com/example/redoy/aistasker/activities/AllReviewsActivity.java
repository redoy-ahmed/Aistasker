package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.ReviewsAdapter;
import com.example.redoy.aistasker.models.Review;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllReviewsActivity extends AppCompatActivity {

    @BindView(R.id.activity_all_reviews_nested_scroll_view)
    NestedScrollView mNestedScrollView;

    @BindView(R.id.all_reviews_recycler_view)
    RecyclerView mRecyclerViewAllReviews;

    @BindView(R.id.activity_profile_screen_state_selector_reviews)
    Spinner mStateSelectorWidget;

    private ReviewsAdapter reviewsAdapter;

    public LinearLayoutManager linearLayoutManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);
        ButterKnife.bind(this);
        initializeWidgets();
        initializeData();
    }

    private void initializeWidgets() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNestedScrollView.setNestedScrollingEnabled(true);
        mRecyclerViewAllReviews.setNestedScrollingEnabled(false);
    }

    private void initializeData() {
        context = getApplicationContext();
        ArrayList<Review> rowListItem = getAllItemList();
        linearLayoutManager = new LinearLayoutManager(context);
        mRecyclerViewAllReviews.setHasFixedSize(true);
        mRecyclerViewAllReviews.setLayoutManager(linearLayoutManager);
        reviewsAdapter = new ReviewsAdapter(context, rowListItem);
        mRecyclerViewAllReviews.setAdapter(reviewsAdapter);
    }

    private ArrayList<Review> getAllItemList() {
        ArrayList<Review> allItems = new ArrayList<>();
        allItems.add(new Review("Cleaning Task", "good review good review good review", "29-Dec-2017", 4));
        allItems.add(new Review("Cleaning Task", "good review good review good review", "29-Dec-2017", 4));
        allItems.add(new Review("Cleaning Task", "good review good review good review", "29-Dec-2017", 4));
        allItems.add(new Review("Cleaning Task", "good review good review good review", "29-Dec-2017", 4));

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
