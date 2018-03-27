package com.example.redoy.aistasker.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.widget.OptionListItem;

/**
 * Created by Redoy on 3/26/2018.
 */

public class MoreOptionsFragment extends Fragment {

    View rootView;

    private Context context;
    private OptionListItem optionListItemOne;
    private OptionListItem optionListItemTwo;
    private OptionListItem optionListItemThree;


    class ClassForDashboardActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForDashboardActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(DashboardActivity.m3795a(this.f2595a.f2604a));
        }
    }

    class ClassForProfileActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForProfileActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(ProfileActivity.m4960a(this.f2596a.f2604a, this.f2596a.f.m1237a().account.id));
        }
    }

    class ClassFOrPaymentHistoryActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassFOrPaymentHistoryActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(PaymentHistoryActivity.m4043a(this.f2597a.f2604a));
        }
    }

    class ClassForPaymentSettingsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForPaymentSettingsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(PaymentSettingsActivity.m5253a(this.f2598a.f2604a, SelectedTab.MAKE_PAYMENTS_TAB));
        }
    }

    class ClassForReviewListActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForReviewListActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(ReviewListActivity.m4290a(this.f2599a.f2604a));
        }
    }

    class ClassForReferralsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForReferralsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(ClassForReferralsActivity.m4290a(this.f2599a.f2604a));
        }
    }

    class ClassForNotificationsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForNotificationsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(NotificationsActivity.m5077a(this.f2600a.f2604a));
        }
    }

    class ClassForTaskAlertsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForTaskAlertsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(TaskAlertsActivity.m4362a(this.f2601a.f2604a));
        }
    }

    class ClassForSettingsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForSettingsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(new Intent(this.f2602a.f2604a, SettingsActivity.class));
        }
    }

    class ClassForHelpActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForHelpActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(HelpActivity.m4887a(this.f2603a.f2604a));
        }
    }

    class ClassForLogOut implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForLogOut(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            //moreOptionsFragment.startActivity(HelpActivity.m4887a(this.f2603a.f2604a));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_more, container, false);
        //ButterKnife.bind(this, rootView);

        context = rootView.getContext();

        OptionListItem optionListItem1 = new OptionListItem(context, context.getString(R.string.dashboard_screen_title), new ClassForDashboardActivity(this));
        OptionListItem optionListItem2 = new OptionListItem(context, context.getString(R.string.more_options_profile_label), new ClassForProfileActivity(this));
        OptionListItem optionListItem3 = new OptionListItem(context, context.getString(R.string.more_options_payment_history_label), new ClassFOrPaymentHistoryActivity(this));
        OptionListItem optionListItem4 = new OptionListItem(context, getString(R.string.more_options_payments), new ClassForPaymentSettingsActivity(this));

        optionListItemOne = new OptionListItem(context, context.getString(R.string.more_options_reviews_label), new ClassForReviewListActivity(this));
        optionListItemTwo = new OptionListItem(context, context.getString(R.string.more_options_notifications_label), new ClassForNotificationsActivity(this));
        optionListItemThree = new OptionListItem(context, context.getString(R.string.more_options_referrals_label), new ClassForReferralsActivity(this));

        OptionListItem optionListItem5 = new OptionListItem(context, context.getString(R.string.task_alerts_screen_title), new ClassForTaskAlertsActivity(this));
        OptionListItem optionListItem6 = new OptionListItem(context, context.getString(R.string.more_options_settings_label), new ClassForSettingsActivity(this));
        OptionListItem optionListItem7 = new OptionListItem(context, context.getString(R.string.more_options_help_label), new ClassForHelpActivity(this));
        OptionListItem optionListItem8 = new OptionListItem(context, context.getString(R.string.more_options_logout_label), new ClassForLogOut(this));


        LinearLayout linearLayout = rootView.findViewById(R.id.layoutOptionsList);
        linearLayout.addView(optionListItem1.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem2.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem3.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem4.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItemOne.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItemTwo.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem5.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem6.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem7.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItemThree.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem8.view, new LayoutParams(-1, -2));

        /*linearLayout.addView(optionListItem1.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem2.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem3.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem4.view, new LayoutParams(-1, -2));*/

        //linearLayout.addView(new View(context), new LayoutParams(-1, (int) getResources().getDimension(R.dimen.navigation_bar_height)));


        return rootView;
    }
}
