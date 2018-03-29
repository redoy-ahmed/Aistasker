package com.example.redoy.aistasker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.TaskItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.RecyclerViewHolderTaskList> {

    private ArrayList<TaskItem> itemList;
    private Context context;

    public TaskListAdapter(Context context, ArrayList<TaskItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolderTaskList onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
        RecyclerViewHolderTaskList rcv = new RecyclerViewHolderTaskList(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderTaskList holder, int position) {
        holder.mTaskTitleTextView.setText(itemList.get(position).getTaskTitle());
        holder.mTaskLocationTextView.setText(itemList.get(position).getTaskLocation());
        holder.mTaskDeadlineTextView.setText(itemList.get(position).getTaskDeadline());
        holder.mTaskRequirementsTextView.setText(itemList.get(position).getTaskRequirements());
        holder.mTaskStateTextView.setText(itemList.get(position).getTaskState());
        holder.mTaskAdditionalInformationTextView.setText(itemList.get(position).getAdditionalInformation());
        holder.mTaskPriceTextView.setText(itemList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class RecyclerViewHolderTaskList extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_task_text_view_task_title)
        public TextView mTaskTitleTextView;

        @BindView(R.id.list_item_task_text_view_location)
        public TextView mTaskLocationTextView;

        @BindView(R.id.list_item_task_text_view_deadline)
        public TextView mTaskDeadlineTextView;

        @BindView(R.id.list_item_task_text_view_requirements)
        public TextView mTaskRequirementsTextView;

        @BindView(R.id.list_item_task_state_text_view)
        public TextView mTaskStateTextView;

        @BindView(R.id.list_item_task_text_view_additional_information)
        public TextView mTaskAdditionalInformationTextView;

        @BindView(R.id.list_item_task_text_view_price)
        public TextView mTaskPriceTextView;


        public RecyclerViewHolderTaskList(final View itemView) {
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
