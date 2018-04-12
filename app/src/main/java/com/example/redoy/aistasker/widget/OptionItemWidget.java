package com.example.redoy.aistasker.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redoy.aistasker.R;

public class OptionItemWidget {

    public TextView mTitleTextView, mTitleDetailsTextView, mNotificationTextView;
    public View view;
    public ImageView imageView;

    public OptionItemWidget(String title, String titleDetails, Context context, View.OnClickListener onClickListener) {
        view = LayoutInflater.from(context).inflate(R.layout.widget_option_item, null);

        mNotificationTextView = this.view.findViewById(R.id.option_item_widget_notification);
        mTitleTextView = this.view.findViewById(R.id.option_item_widget_title);
        mTitleDetailsTextView = this.view.findViewById(R.id.option_item_details);
        imageView = this.view.findViewById(R.id.option_item_widget_image_view_chevron);
        mNotificationTextView.setVisibility(View.GONE);
        mTitleTextView.setText(title);
        //mTitleDetailsTextView.setText(titleDetails);

        view.setOnClickListener(onClickListener);
    }
}

