package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.widget.OptionListItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReferralsActivity extends AppCompatActivity {

    Context context;

    @BindView(R.id.referrals_layout_item_list)
    LinearLayout linearLayout;

    class ClassForReferFriends implements View.OnClickListener {
        final ReferralsActivity referralsActivity;

        ClassForReferFriends(ReferralsActivity referralsActivity) {
            this.referralsActivity = referralsActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForMoreInformation implements View.OnClickListener {
        final ReferralsActivity referralsActivity;

        ClassForMoreInformation(ReferralsActivity referralsActivity) {
            this.referralsActivity = referralsActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referrals);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();
    }

    private void initializeData() {
        context = getApplicationContext();

        OptionListItem optionListItem1 = new OptionListItem(context, context.getString(R.string.referrals_refer_friends_to_airtasker_label), new ClassForReferFriends(this));
        OptionListItem optionListItem2 = new OptionListItem(context, context.getString(R.string.referrals_more_information_label), new ClassForMoreInformation(this));

        linearLayout.addView(optionListItem1.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem2.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
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
