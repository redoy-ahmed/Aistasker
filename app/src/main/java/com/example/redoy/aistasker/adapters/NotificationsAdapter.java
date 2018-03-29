package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.NotificationItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.RecyclerViewHolderNotifications> {

    private ArrayList<NotificationItem> itemList;
    private Context context;

    public NotificationsAdapter(Context context, ArrayList<NotificationItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public NotificationsAdapter.RecyclerViewHolderNotifications onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_notification, parent, false);
        NotificationsAdapter.RecyclerViewHolderNotifications rcv = new NotificationsAdapter.RecyclerViewHolderNotifications(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(NotificationsAdapter.RecyclerViewHolderNotifications holder, int position) {
        holder.mTitleTextView.setText(itemList.get(position).getTitle());
        holder.mDateTextView.setText(itemList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolderNotifications extends RecyclerView.ViewHolder {

        @BindView(R.id.notifications_list_item_date_text_view)
        public TextView mDateTextView;

        @BindView(R.id.notifications_list_item_content_text_view)
        public TextView mTitleTextView;


        public RecyclerViewHolderNotifications(final View itemView) {
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