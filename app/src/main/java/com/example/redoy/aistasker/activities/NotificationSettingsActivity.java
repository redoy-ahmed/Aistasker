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
import com.example.redoy.aistasker.widget.OptionItemWidget;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationSettingsActivity extends AppCompatActivity {

    private OptionItemWidget optionListItemOne;
    private OptionItemWidget optionListItemTwo;
    private OptionItemWidget optionListItemThree;
    private OptionItemWidget optionListItemFour;
    private OptionItemWidget optionListItemFive;
    private OptionItemWidget optionListItemSix;
    private OptionItemWidget optionListItemSeven;

    Context context;

    @BindView(R.id.layoutOptionsList)
    LinearLayout linearLayout;


    class ClassForTransactional implements View.OnClickListener {
        Context context;

        ClassForTransactional(Context context) {
            this.context = context;
        }

        public void onClick(View view) {
            context.startActivity(new Intent(context, AirtaskerAlertsNotificationTypesActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = getApplicationContext();

        optionListItemOne = new OptionItemWidget(context.getString(R.string.notifications_settings_label_transactional), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));
        optionListItemTwo = new OptionItemWidget(context.getString(R.string.notifications_settings_label_task_updates), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));
        optionListItemThree = new OptionItemWidget(context.getString(R.string.notifications_settings_label_task_reminders), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));
        optionListItemFour = new OptionItemWidget(context.getString(R.string.notifications_settings_label_airtasker_alerts), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));
        optionListItemFive = new OptionItemWidget(context.getString(R.string.notifications_settings_label_task_recommendations), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));
        optionListItemSix = new OptionItemWidget(context.getString(R.string.notifications_settings_label_helpful_information), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));
        optionListItemSeven= new OptionItemWidget(context.getString(R.string.notifications_settings_label_updates_newsletters), "EMAIL,SMS,PUSH", context, new ClassForTransactional(this));

        linearLayout.addView(optionListItemOne.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemTwo.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemThree.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemFour.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemFive.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemSix.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemSeven.view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
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
