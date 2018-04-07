package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.Review;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.RecyclerViewHolderReview> {

    ArrayList<Review> itemList;
    private Context context;

    public ReviewsAdapter(Context context, ArrayList<Review> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ReviewsAdapter.RecyclerViewHolderReview onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_review, parent, false);
        ReviewsAdapter.RecyclerViewHolderReview rcv = new ReviewsAdapter.RecyclerViewHolderReview(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ReviewsAdapter.RecyclerViewHolderReview holder, int position) {
        holder.ratingBar.setRating(Float.valueOf(itemList.get(position).rating));
        holder.textViewContent.setText(itemList.get(position).getBody());
        holder.textViewDate.setText(itemList.get(position).getCreatedAt());
        holder.textViewTitle.setText(itemList.get(position).getTaskName());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolderReview extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_review_avatar_widget)
        ImageView avatarWidget;

        @BindView(R.id.profile_rating_bar_top)
        RatingBar ratingBar;

        @BindView(R.id.list_item_review_text_view_body)
        TextView textViewContent;

        @BindView(R.id.textViewDate)
        TextView textViewDate;

        @BindView(R.id.list_item_review_text_view_task_title)
        TextView textViewTitle;


        public RecyclerViewHolderReview(final View itemView) {
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
