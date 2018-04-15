package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.private_messages_menu, menu);
        return true;
    }
}
