package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.redoy.aistasker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrivateConversationActivity extends AppCompatActivity {

    @BindView(R.id.private_conversation_closed_message_text_view)
    TextView mClosedMessageTextView;

    @BindView(R.id.private_conversation_list_view)
    ListView mListViewMessages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_conversation);

        ButterKnife.bind(this);
    }
}
