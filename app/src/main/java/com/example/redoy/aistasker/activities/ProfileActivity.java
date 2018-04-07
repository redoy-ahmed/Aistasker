package com.example.redoy.aistasker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.redoy.aistasker.R;

import org.apmem.tools.layouts.FlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

public class ProfileActivity extends AppCompatActivity {

    protected String f3219a;

    @BindView(R.id.activity_profile_app_bar_layout)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.activity_profile_avatar_edit)
    ImageView mAvatarEditView;

    @BindView(R.id.activity_profile_avatar_widget)
    ImageView mAvatarWidget;

    @BindView(R.id.activity_profile_backdrop_edit)
    ImageView mBackdropEditView;

    @BindView(R.id.profile_general_button_action)
    Button mButtonAction;

    @BindView(R.id.profile_reviews_button_all_reviews)
    Button mButtonAllReviews;

    @BindView(R.id.activity_profile_collapsing_layout)
    CollapsingToolbarLayout mCollapsingLayout;

    @BindView(R.id.activity_profile_image_backdrop)
    ImageView mImageViewBackDrop;

    @BindView(R.id.activity_profile_image_completion_rate_info)
    ImageView mImageViewCompletionRateInformation;

    @BindView(R.id.activity_profile_layout_completion_rate)
    LinearLayout mLayoutCompletionRate;

    @BindView(R.id.profile_skills_layout_education)
    RelativeLayout mLayoutEducation;

    @BindView(R.id.profile_skills_layout_education_items)
    FlowLayout mLayoutEducationItems;

    @BindView(R.id.profile_skills_layout_languages)
    RelativeLayout mLayoutLanguages;

    @BindView(R.id.profile_skills_layout_languages_items)
    FlowLayout mLayoutLanguagesItems;

    @BindView(R.id.profile_reviews_layout_reviews_container)
    LinearLayout mLayoutReviewsContainer;

    @BindView(R.id.profile_skills_layout_specialties)
    RelativeLayout mLayoutSpecialties;

    @BindView(R.id.profile_skills_layout_specialties_items)
    FlowLayout mLayoutSpecialtiesItems;

    @BindView(R.id.profile_skills_layout_transportation)
    RelativeLayout mLayoutTransportation;

    @BindView(R.id.profile_skills_layout_transportation_items)
    FlowLayout mLayoutTransportationItems;

    @BindView(R.id.profile_skills_layout_work)
    RelativeLayout mLayoutWork;

    @BindView(R.id.profile_skills_layout_work_items)
    FlowLayout mLayoutWorkItems;

    @BindView(R.id.activity_profile_viewpager_portfolio)
    ViewPager mPortfolioViewPager;

    @BindView(R.id.profile_about_layout)
    View mProfileAboutLayout;

    @BindView(R.id.activity_profile_rating_bar_top)
    RatingBar mRatingBarTop;

    @BindView(R.id.activity_profile_screen_state_selector_reviews)
    SwitchCompat mStateSelectorTop;

    @BindView(R.id.profile_about_text_view_custom_about)
    TextView mTextViewAbout;

    @BindView(R.id.activity_profile_text_completion_rate)
    TextView mTextViewCompletionRate;

    @BindView(R.id.profile_general_text_user_name)
    TextView mTextViewDisplayName;

    @BindView(R.id.profile_general_text_last_online)
    TextView mTextViewLastOnline;

    @BindView(R.id.profile_general_text_location)
    TextView mTextViewLocation;

    @BindView(R.id.profile_about_text_member_since)
    TextView mTextViewMemberSince;

    @BindView(R.id.profile_reviews_text_view_no_reviews_message)
    TextView mTextViewNoReviewsBottom;

    @BindView(R.id.profile_general_text_report)
    TextView mTextViewReport;

    @BindView(R.id.activity_profile_text_stars_and_reviews)
    TextView mTextViewStarsAndReviewsTop;

    @BindView(R.id.activity_profile_text_sub_header_about)
    TextView mTextViewSubHeaderAbout;

    @BindView(R.id.activity_profile_text_sub_header_portfolio)
    TextView mTextViewSubHeaderPortfolio;

    @BindView(R.id.profile_general_text_view_tag_line)
    TextView mTextViewTagLine;

    @BindView(R.id.activity_profile_toolbar)
    Toolbar mToolBar;

    class FlagClass implements View.OnClickListener {
        final ProfileActivity profileActivity;

        FlagClass(ProfileActivity profileActivity) {
            this.profileActivity = profileActivity;
        }

        public void onClick(View view) {
            this.profileActivity.startActivity(new Intent(getApplicationContext(), FlagActivity.class));
        }
    }

    class AllReviewClass implements View.OnClickListener {
        final ProfileActivity profileActivity;

        AllReviewClass(ProfileActivity profileActivity) {
            this.profileActivity = profileActivity;
        }

        public void onClick(View view) {
            this.profileActivity.startActivity(new Intent(getApplicationContext(), AllReviewsActivity.class));
        }
    }

    class PostTaskClass implements View.OnClickListener {
        final ProfileActivity profileActivity;

        PostTaskClass(ProfileActivity profileActivity) {
            this.profileActivity = profileActivity;
        }

        public void onClick(View view) {
            this.profileActivity.startActivity(new Intent(getApplicationContext(), PostTaskActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        initializeWidgets();
    }

    private void initializeWidgets() {
        this.mButtonAction.setVisibility(GONE);
        this.mButtonAction.setOnClickListener(new PostTaskClass(this));
        this.mAvatarEditView.setVisibility(GONE);
        this.mBackdropEditView.setVisibility(View.INVISIBLE);
        this.mButtonAllReviews.setOnClickListener(new AllReviewClass(this));
        this.mTextViewReport.setVisibility(GONE);
        this.mTextViewReport.setOnClickListener(new FlagClass(this));
        //this.mStateSelectorTop.setOnStateChangerListener(new C08223(this));
    }
}
