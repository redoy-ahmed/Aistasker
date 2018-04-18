package com.example.redoy.aistasker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.Conversation;

import java.util.ArrayList;

public class PrivateConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int SELF = 100;
    private ArrayList<Conversation> messageArrayList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView message, timestamp;

        public ViewHolder(View view) {
            super(view);
            message = itemView.findViewById(R.id.message);
            timestamp = itemView.findViewById(R.id.timestamp);
        }
    }

    public PrivateConversationAdapter(ArrayList<Conversation> messageArrayList) {
        this.messageArrayList = messageArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        if (viewType == SELF) {
            // self message
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_self, parent, false);
        } else {
            // others message
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_other, parent, false);
        }

        return new ViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        Conversation conversation = messageArrayList.get(position);
        if (conversation.getUser().equals("Me")) {
            return SELF;
        }
        return position;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Conversation conversation = messageArrayList.get(position);
        ((ViewHolder) holder).message.setText(conversation.getMessage());
        ((ViewHolder) holder).timestamp.setText(conversation.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }
}

