package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.MessageItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.RecyclerViewHolderMessageList> {

    private ArrayList<MessageItem> itemList;
    private Context context;

    public MessageListAdapter(Context context, ArrayList<MessageItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MessageListAdapter.RecyclerViewHolderMessageList onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_message, parent, false);
        MessageListAdapter.RecyclerViewHolderMessageList rcv = new MessageListAdapter.RecyclerViewHolderMessageList(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MessageListAdapter.RecyclerViewHolderMessageList holder, int position) {
        holder.mMessageTaskTitleTextView.setText(itemList.get(position).getMsgTaskTitle());
        holder.mMessageTimeTextView.setText(itemList.get(position).getMsgTime());
        holder.mMessagePreviewTextView.setText(itemList.get(position).getMsgPreview());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolderMessageList extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_message_text_view_task_title)
        public TextView mMessageTaskTitleTextView;

        @BindView(R.id.list_item_message_text_view_time)
        public TextView mMessageTimeTextView;

        @BindView(R.id.list_item_message_text_view_message_preview)
        public TextView mMessagePreviewTextView;


        public RecyclerViewHolderMessageList(final View itemView) {
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