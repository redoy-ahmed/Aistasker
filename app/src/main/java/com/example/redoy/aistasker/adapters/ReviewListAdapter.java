package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.ReviewItem;
import com.example.redoy.aistasker.models.TaskAlert;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/29/2018.
 */

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.RecyclerViewHolderReviewList> {

    private ArrayList<ReviewItem> itemList;
    private Context context;

    public ReviewListAdapter(Context context, ArrayList<ReviewItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ReviewListAdapter.RecyclerViewHolderReviewList onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_review_list, parent, false);
        ReviewListAdapter.RecyclerViewHolderReviewList rcv = new ReviewListAdapter.RecyclerViewHolderReviewList(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ReviewListAdapter.RecyclerViewHolderReviewList holder, int position) {
        holder.mReviewListTitleTextView.setText(itemList.get(position).getTaskTitle());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolderReviewList extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_review_text_view_task_title)
        public TextView mReviewListTitleTextView;


        public RecyclerViewHolderReviewList(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }
}
