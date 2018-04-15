package com.example.redoy.aistasker.fragments;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.TaskListAdapter;
import com.example.redoy.aistasker.models.TaskItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/28/2018.
 */

@SuppressLint("ValidFragment")
public class MyTaskListFragment extends Fragment {
    View rootView;

    //private EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    //private MenuItem menuItem;

    //@BindView(R.id.browse_tasks_button_empty_state_change_filter)
    //Button mButtonEmptyStateChangeFilter;

    @BindView(R.id.my_tasks_text_view_empty_state)
    TextView mLayoutEmptyState;

    @BindView(R.id.my_tasks_list_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.my_tasks_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private TaskListAdapter taskListAdapter;
    public LinearLayoutManager linearLayoutManager;

    public int code;

    @SuppressLint("ValidFragment")
    public MyTaskListFragment(int code) {
        this.code = code;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_my_task_list, container, false);
        ButterKnife.bind(this, rootView);

        initializeData();

        return rootView;
    }

    private void initializeData() {
        ArrayList<TaskItem> rowListItem;

        if (code == 1) {
            rowListItem = getAllItemList();
            linearLayoutManager = new LinearLayoutManager(rootView.getContext());
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            taskListAdapter = new TaskListAdapter(rootView.getContext(), rowListItem);
            mRecyclerView.setAdapter(taskListAdapter);
            mLayoutEmptyState.setVisibility(View.GONE);
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mLayoutEmptyState.setVisibility(View.VISIBLE);
            mLayoutEmptyState.setText(rootView.getContext().getString(R.string.browse_tasks_empty_state_message));
            mLayoutEmptyState.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.empty_state_my_tasks, 0, 0);
        }
    }

    private ArrayList<TaskItem> getAllItemList() {

        ArrayList<TaskItem> allItems = new ArrayList<>();
        allItems.add(new TaskItem("Task 1", "Australia", "Saturday, Mar 31, 2018", "Clean my house", "Drafted", "additional information","A$250"));
        allItems.add(new TaskItem("Task 2", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information","A$250"));
        allItems.add(new TaskItem("Task 3", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information","A$270"));
        allItems.add(new TaskItem("Task 4", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information","A$280"));
        allItems.add(new TaskItem("Task 5", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information","A$300"));

        return allItems;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.my_tasks_menu, menu);
    }
}
