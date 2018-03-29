package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.TaskListAdapter;
import com.example.redoy.aistasker.models.TaskItem;
import com.pchmn.materialchips.ChipView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class BrowseTaskListFragment extends Fragment {
    View rootView;

    //private EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    //private MenuItem menuItem;

    @BindView(R.id.browse_tasks_button_empty_state_change_filter)
    Button mButtonEmptyStateChangeFilter;

    @BindView(R.id.browse_tasks_layout_empty)
    View mLayoutEmptyState;

    @BindView(R.id.browse_tasks_layout_map)
    RelativeLayout mLayoutMap;

    @BindView(R.id.browse_tasks_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.browse_tasks_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.browse_tasks_chip_widget_task_type)
    ChipView mChipWidgetTaskType;

    @BindView(R.id.browse_tasks_chip_widget_task_location)
    ChipView mChipWidgetTaskLocation;

    @BindView(R.id.browse_tasks_chip_widget_task_price)
    ChipView mChipWidgetTaskPrice;

    private TaskListAdapter taskListAdapter;
    public LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_browse_task_list, container, false);
        ButterKnife.bind(this, rootView);

        initializeData();

        return rootView;
    }

    private void initializeData() {

        mChipWidgetTaskType.setLabel(rootView.getContext().getString(R.string.browse_tasks_chip_task_type_all));
        mChipWidgetTaskLocation.setLabel(rootView.getContext().getString(R.string.browse_tasks_chip_task_location));
        mChipWidgetTaskPrice.setLabel(rootView.getContext().getString(R.string.browse_tasks_chip_task_price_any));

        ArrayList<TaskItem> rowListItem = getAllItemList();

        linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        taskListAdapter = new TaskListAdapter(rootView.getContext(), rowListItem);
        mRecyclerView.setAdapter(taskListAdapter);
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
}
