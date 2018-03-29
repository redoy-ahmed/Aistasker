package com.example.redoy.aistasker.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.activities.DashboardActivity;
import com.example.redoy.aistasker.activities.HelpActivity;
import com.example.redoy.aistasker.activities.IntroductionActivity;
import com.example.redoy.aistasker.activities.NotificationsActivity;
import com.example.redoy.aistasker.activities.PaymentHistoryActivity;
import com.example.redoy.aistasker.activities.PaymentSettingsActivity;
import com.example.redoy.aistasker.activities.ProfileActivity;
import com.example.redoy.aistasker.activities.ReferralsActivity;
import com.example.redoy.aistasker.activities.ReviewListActivity;
import com.example.redoy.aistasker.activities.SettingsActivity;
import com.example.redoy.aistasker.activities.TaskAlertsActivity;
import com.example.redoy.aistasker.widget.OptionListItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class MoreOptionsFragment extends Fragment {

    View rootView;

    private Context context;
    private OptionListItem optionListItemOne;
    private OptionListItem optionListItemTwo;
    private OptionListItem optionListItemThree;


    @BindView(R.id.layoutOptionsList)
    LinearLayout linearLayout;

    class ClassForDashboardActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForDashboardActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), DashboardActivity.class));
        }
    }

    class ClassForProfileActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForProfileActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), ProfileActivity.class));
        }
    }

    class ClassForPaymentHistoryActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForPaymentHistoryActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), PaymentHistoryActivity.class));
        }
    }

    class ClassForPaymentSettingsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForPaymentSettingsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), PaymentSettingsActivity.class));
        }
    }

    class ClassForReviewListActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForReviewListActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), ReviewListActivity.class));
        }
    }

    class ClassForReferralsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForReferralsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), ReferralsActivity.class));
        }
    }

    class ClassForNotificationsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForNotificationsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), NotificationsActivity.class));
        }
    }

    class ClassForTaskAlertsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForTaskAlertsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), TaskAlertsActivity.class));
        }
    }

    class ClassForSettingsActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForSettingsActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), SettingsActivity.class));
        }
    }

    class ClassForHelpActivity implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForHelpActivity(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            moreOptionsFragment.startActivity(new Intent(moreOptionsFragment.getActivity(), HelpActivity.class));
        }
    }

    class ClassForLogOut implements View.OnClickListener {
        final MoreOptionsFragment moreOptionsFragment;

        ClassForLogOut(MoreOptionsFragment moreOptionsFragment) {
            this.moreOptionsFragment = moreOptionsFragment;
        }

        public void onClick(View view) {
            new AlertDialog.Builder(rootView.getContext())
                    .setTitle("Log Out")
                    .setMessage("Are you sure to Log Out?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(rootView.getContext(), IntroductionActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, rootView);
        context = rootView.getContext();

        OptionListItem optionListItem1 = new OptionListItem(context, context.getString(R.string.dashboard_screen_title), new ClassForDashboardActivity(this));
        OptionListItem optionListItem2 = new OptionListItem(context, context.getString(R.string.more_options_profile_label), new ClassForProfileActivity(this));
        OptionListItem optionListItem3 = new OptionListItem(context, context.getString(R.string.more_options_payment_history_label), new ClassForPaymentHistoryActivity(this));
        OptionListItem optionListItem4 = new OptionListItem(context, getString(R.string.more_options_payments), new ClassForPaymentSettingsActivity(this));

        optionListItemOne = new OptionListItem(context, context.getString(R.string.more_options_reviews_label), new ClassForReviewListActivity(this));
        optionListItemTwo = new OptionListItem(context, context.getString(R.string.more_options_notifications_label), new ClassForNotificationsActivity(this));
        optionListItemThree = new OptionListItem(context, context.getString(R.string.more_options_referrals_label), new ClassForReferralsActivity(this));

        OptionListItem optionListItem5 = new OptionListItem(context, context.getString(R.string.task_alerts_screen_title), new ClassForTaskAlertsActivity(this));
        OptionListItem optionListItem6 = new OptionListItem(context, context.getString(R.string.more_options_settings_label), new ClassForSettingsActivity(this));
        OptionListItem optionListItem7 = new OptionListItem(context, context.getString(R.string.more_options_help_label), new ClassForHelpActivity(this));
        OptionListItem optionListItem8 = new OptionListItem(context, context.getString(R.string.more_options_logout_label), new ClassForLogOut(this));


        linearLayout.addView(optionListItem1.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem2.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem3.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem4.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemOne.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemTwo.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem5.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem6.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem7.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItemThree.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));
        linearLayout.addView(optionListItem8.view, new LayoutParams(LayoutParams.MATCH_PARENT, 150));

        /*linearLayout.addView(optionListItem1.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem2.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem3.view, new LayoutParams(-1, -2));
        linearLayout.addView(optionListItem4.view, new LayoutParams(-1, -2));*/

        //linearLayout.addView(new View(context), new LayoutParams(-1, (int) getResources().getDimension(R.dimen.navigation_bar_height)));


        return rootView;
    }
}
