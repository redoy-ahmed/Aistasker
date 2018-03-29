package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.TaskAlert;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskAlertAdapter extends RecyclerView.Adapter<TaskAlertAdapter.RecyclerViewHolderTaskAlert> {

    private ArrayList<TaskAlert> itemList;
    private Context context;

    public TaskAlertAdapter(Context context, ArrayList<TaskAlert> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public TaskAlertAdapter.RecyclerViewHolderTaskAlert onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task_alert, parent, false);
        TaskAlertAdapter.RecyclerViewHolderTaskAlert rcv = new TaskAlertAdapter.RecyclerViewHolderTaskAlert(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(TaskAlertAdapter.RecyclerViewHolderTaskAlert holder, int position) {
        holder.mTaskAlertKeyWordTextView.setText(itemList.get(position).getKeyword());
        holder.mTaskAlertDistanceTextView.setText(itemList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolderTaskAlert extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_text_view_keyword)
        public TextView mTaskAlertKeyWordTextView;

        @BindView(R.id.list_item_text_view_distance)
        public TextView mTaskAlertDistanceTextView;


        public RecyclerViewHolderTaskAlert(final View itemView) {
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