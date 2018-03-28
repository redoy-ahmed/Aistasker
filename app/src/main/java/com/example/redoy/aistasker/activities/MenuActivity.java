package com.example.redoy.aistasker.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.fragments.BrowseTaskListFragment;
import com.example.redoy.aistasker.fragments.MessagesListFragment;
import com.example.redoy.aistasker.fragments.MoreOptionsFragment;
import com.example.redoy.aistasker.fragments.MyTaskFragment;
import com.example.redoy.aistasker.fragments.PostTaskFragment;
import com.example.redoy.aistasker.widget.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        }
        getSupportActionBar().setTitle(R.string.bottom_navigation_bar_post_task_label);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PostTaskFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment mFragment = null;

                        switch (item.getItemId()) {
                            case R.id.bottom_nav_bar_post_task: {
                                mFragment = new PostTaskFragment();
                                getSupportActionBar().setTitle(R.string.bottom_navigation_bar_post_task_label);
                                break;
                            }
                            case R.id.bottom_nav_bar_my_task: {
                                mFragment = new MyTaskFragment();
                                getSupportActionBar().setTitle(R.string.bottom_navigation_bar_my_tasks_label);
                                break;
                            }
                            case R.id.bottom_nav_bar_browse_tasks: {
                                getSupportActionBar().setTitle(R.string.bottom_navigation_bar_browse_label);
                                mFragment = new BrowseTaskListFragment();
                                break;
                            }
                            case R.id.bottom_nav_bar_messages: {
                                mFragment = new MessagesListFragment();
                                getSupportActionBar().setTitle(R.string.bottom_navigation_bar_messages_label);
                                break;
                            }
                            case R.id.bottom_nav_bar_more: {
                                mFragment = new MoreOptionsFragment();
                                getSupportActionBar().setTitle(R.string.more_options_screen_title);
                                break;
                            }
                        }

                        FragmentManager mFragmentManager = getSupportFragmentManager();
                        if (mFragment != null) {
                            mFragmentManager.beginTransaction().replace(R.id.frame_layout, mFragment).commit();
                        }
                        return true;
                    }
                });
    }
}
