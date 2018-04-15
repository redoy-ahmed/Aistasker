package com.example.redoy.aistasker.activities;

import android.content.Context;
import android.content.Intent;
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

public class HelpActivity extends AppCompatActivity {


    Context context;

    @BindView(R.id.support_centre_layout_item_list)
    LinearLayout linearLayout;

    class ClassForSupportCenter implements View.OnClickListener {
        final HelpActivity helpActivity;

        ClassForSupportCenter(HelpActivity helpActivity) {
            this.helpActivity = helpActivity;
        }

        public void onClick(View view) {
            helpActivity.startActivity(new Intent(helpActivity.getApplicationContext(), SupportActivity.class));
        }
    }

    class ClassForTermsAndConditions implements View.OnClickListener {
        final HelpActivity helpActivity;

        ClassForTermsAndConditions(HelpActivity helpActivity) {
            this.helpActivity = helpActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForInsurance implements View.OnClickListener {
        final HelpActivity helpActivity;

        ClassForInsurance(HelpActivity helpActivity) {
            this.helpActivity = helpActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForPrivacy implements View.OnClickListener {
        final HelpActivity helpActivity;

        ClassForPrivacy(HelpActivity helpActivity) {
            this.helpActivity = helpActivity;
        }

        public void onClick(View view) {
            //referralsActivity.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();
    }

    private void initializeData() {
        context = getApplicationContext();

        OptionListItem optionListItem1 = new OptionListItem(context, context.getString(R.string.help_support_centre_label), new HelpActivity.ClassForSupportCenter(this));
        OptionListItem optionListItem2 = new OptionListItem(context, context.getString(R.string.help_terms_and_conditions_label), new HelpActivity.ClassForTermsAndConditions(this));
        OptionListItem optionListItem3 = new OptionListItem(context, context.getString(R.string.help_insurance_label), new HelpActivity.ClassForInsurance(this));
        OptionListItem optionListItem4 = new OptionListItem(context, context.getString(R.string.help_privacy_label), new HelpActivity.ClassForPrivacy(this));

        linearLayout.addView(optionListItem1.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem2.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem3.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem4.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
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
