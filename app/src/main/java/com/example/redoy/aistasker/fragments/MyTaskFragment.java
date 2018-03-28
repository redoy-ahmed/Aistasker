package com.example.redoy.aistasker.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.TaskListAdapter;
import com.example.redoy.aistasker.models.TaskItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class MyTaskFragment extends Fragment {

    View rootView;

    @BindView(R.id.my_tasks_list_tab_layout)
    public TabLayout tabLayout;

    @BindView(R.id.my_tasks_list_viewpager)
    public ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_my_task, container, false);
        ButterKnife.bind(this, rootView);

        loadDataIntoWidgets();

        return rootView;
    }

    private void loadDataIntoWidgets() {
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new MyTaskListFragment(0), rootView.getContext().getString(R.string.browse_tasks_my_tasks_tab_label_all));
        adapter.addFrag(new MyTaskListFragment(1), rootView.getContext().getString(R.string.browse_tasks_my_tasks_tab_label_posted));
        adapter.addFrag(new MyTaskListFragment(0), rootView.getContext().getString(R.string.browse_tasks_my_tasks_tab_label_draft));
        adapter.addFrag(new MyTaskListFragment(1), rootView.getContext().getString(R.string.browse_tasks_my_tasks_tab_label_assigned));
        adapter.addFrag(new MyTaskListFragment(0), rootView.getContext().getString(R.string.browse_tasks_my_tasks_tab_label_offered));
        adapter.addFrag(new MyTaskListFragment(1), rootView.getContext().getString(R.string.browse_tasks_my_tasks_tab_label_completed));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
