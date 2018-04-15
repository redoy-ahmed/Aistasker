package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.MessageListAdapter;
import com.example.redoy.aistasker.models.MessageItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class MessagesListFragment extends Fragment {

    View rootView;

    @BindView(R.id.messages_list_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.messages_list_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.messages_list_view_empty)
    TextView mViewEmpty;

    private MessageListAdapter messageListAdapter;
    public LinearLayoutManager linearLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_messages, container, false);
        ButterKnife.bind(this, rootView);

        initializeData();
        return rootView;
    }

    private void initializeData() {
        ArrayList<MessageItem> rowListItem;

        rowListItem = getAllItemList();
        linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        messageListAdapter = new MessageListAdapter(rootView.getContext(), rowListItem);
        mRecyclerView.setAdapter(messageListAdapter);

    }

    private ArrayList<MessageItem> getAllItemList() {

        ArrayList<MessageItem> allItems = new ArrayList<>();
        allItems.add(new MessageItem("Cleaning Task", "3:10 PM", "This is a cleaning task dummy message"));
        allItems.add(new MessageItem("Photography Task", "4:10 PM", "This is a Photography task dummy message"));
        allItems.add(new MessageItem("Travelling Task", "5:10 PM", "This is a Travelling task dummy message"));
        allItems.add(new MessageItem("Eating Task", "6:20 PM", "This is a Eating task dummy message"));
        allItems.add(new MessageItem("Writing Task", "7:30 PM", "This is a Writing task dummy message"));
        allItems.add(new MessageItem("Reading Task", "8:40 PM", "This is a Reading task dummy message"));
        allItems.add(new MessageItem("Clening Task", "3:10 PM", "This is a cleaning task dummy message"));
        allItems.add(new MessageItem("Watching Task", "9:50 PM", "This is a Watching task dummy message"));
        allItems.add(new MessageItem("Cleaning Task", "10:00 PM", "This is a Cleaning task dummy message"));
        allItems.add(new MessageItem("Clening Task", "3:10 PM", "This is a cleaning task dummy message"));
        allItems.add(new MessageItem("Money Task", "11:10 PM", "This is a Money task dummy message"));
        allItems.add(new MessageItem("Dummy Task", "12:10 PM", "This is a Dummy task dummy message"));

        return allItems;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.message_list_menu, menu);
    }
}
