package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.widget.TaskProgressBarWidget;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskDetailsActivity extends AppCompatActivity {

    @BindView(R.id.task_details_price_approx_hours_text_view)
    TextView mApproximateTimeTextView;

    @BindView(R.id.task_details_avatar_widget)
    ImageView mAvatarWidget;

    @BindView(R.id.task_details_badge_requirement_image_view)
    ImageView mBadgeRequirementImageView;

    @BindView(R.id.task_details_private_messages_layout_button)
    Button mButtonOpenMessages;

    @BindView(R.id.task_details_price_actions_linear_layout_action_button)
    Button mButtonTaskAction;

    @BindView(R.id.task_details_offers_layout_button_view_all_offers)
    Button mButtonViewAllOffers;

    @BindView(R.id.task_details_description_view_project_button)
    Button mButtonViewProject;

    @BindView(R.id.task_details_description_collapse_text_view)
    TextView mExpandableTextViewDescription;

    @BindView(R.id.task_details_get_directions_text_view)
    TextView mGetDirectionsTextView;

    @BindView(R.id.task_details_price_increase_price_linear_layout)
    LinearLayout mIncreasePriceLinearLayout;

    @BindView(R.id.task_details_assignees_layout_container)
    LinearLayout mLayoutAssigneesContainer;

    @BindView(R.id.task_details_assignees_layout_main_container)
    LinearLayout mLayoutAssigneesMainContainer;

    @BindView(R.id.task_details_offers_layout_offers_container)
    LinearLayout mLayoutOffersContainer;

    @BindView(R.id.task_details_offers_layout_main_container)
    LinearLayout mLayoutOffersMainContainer;

    @BindView(R.id.task_details_location_text_view)
    TextView mLocationTextView;

    @BindView(R.id.layout_top_comments_input_message_entry_widget)
    EditText mMessageInputWidget;

    @BindView(R.id.task_details_price_pending_price_linear_layout)
    LinearLayout mPendingPriceLinearLayout;

    @BindView(R.id.task_details_price_pending_price_text_view)
    TextView mPendingPriceTextView;

    @BindView(R.id.task_details_price_per_worker_label_text_view)
    TextView mPerWorkerLabelTextView;

    @BindView(R.id.task_details_price_status_divider_view)
    View mPriceStatusDividerView;

    @BindView(R.id.task_details_price_amount_text_view)
    TextView mPriceTextView;

    @BindView(R.id.task_details_private_messages_main_container)
    View mPrivateMessagesMainContainer;

    @BindView(R.id.task_details_price_prompt_info_text_view)
    TextView mPromptInfoTextView;

    @BindView(R.id.task_details_requirements_container)
    LinearLayout mRequirementsContainer;

    @BindView(R.id.task_details_requirements_recycler_view)
    RecyclerView mRequirementsRecyclerView;

    @BindView(R.id.task_details_review_header)
    View mReviewHeaderLayout;

    @BindView(R.id.task_details_review1)
    View mReviewLayout1;

    @BindView(R.id.task_details_review2)
    View mReviewLayout2;

    @BindView(R.id.task_details_scroll_view)
    NestedScrollView mScrollView;

    @BindView(R.id.task_details_price_status_image_view)
    ImageView mStatusImageView;

    @BindView(R.id.task_details_price_status_text_view)
    TextView mStatusTextView;

    @BindView(R.id.task_details_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.task_details_allow_calls_for_task_switch)
    Switch mSwitchAllowCalls;

    @BindView(R.id.task_details_progress_bar)
    TaskProgressBarWidget mTaskProgressBar;

    @BindView(R.id.task_details_assignees_layout_header_text_view)
    TextView mTextViewAssigneesHeader;

    @BindView(R.id.task_details_due_date_text_view)
    TextView mTextViewDueDate;

    @BindView(R.id.task_details_offers_layout_text_view_no_offers_message)
    TextView mTextViewNoOffersMessage;

    @BindView(R.id.task_details_offers_layout_text_view_header)
    TextView mTextViewOffersHeader;

    @BindView(R.id.task_details_private_messages_layout_header_text_view)
    TextView mTextViewPrivateMessagesHeader;

    /*@BindView(R.id.button)
    TextView mTextViewRescheduleButton;*/

    @BindView(R.id.task_details_task_title_text_view)
    TextView mTextViewTaskName;

    @BindView(R.id.task_details_time_posted_text_view)
    TextView mTextViewTaskTimePosted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        ButterKnife.bind(this);
        initializeWidgets();
    }

    private void initializeWidgets() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        this.mTaskProgressBar.setVisibility(View.VISIBLE);
        this.mTaskProgressBar.setState(list, 1);
    }
}
