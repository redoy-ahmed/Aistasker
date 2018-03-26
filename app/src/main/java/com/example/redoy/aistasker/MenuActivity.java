package com.example.redoy.aistasker;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment mFragment = null;

                        switch (item.getItemId()) {
                            case R.id.bottom_nav_bar_post_task:
                                mFragment = new PostTaskFragment();
                                break;
                            case R.id.bottom_nav_bar_my_task:
                                mFragment = new MyTaskListFragment();
                                break;
                            case R.id.bottom_nav_bar_browse_tasks:
                                mFragment = new BrowseTaskListFragment();
                                break;
                            case R.id.bottom_nav_bar_messages:
                                mFragment = new MessagesListFragment();
                                break;
                            case R.id.bottom_nav_bar_more:
                                mFragment = new MoreOptionsFragment();
                                break;
                        }
                        
                        FragmentManager mFragmentManager = getSupportFragmentManager();
                        if (mFragment != null) {
                            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
                        }
                        return true;
                    }
                });
    }
}
