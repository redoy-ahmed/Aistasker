package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.adapters.PrivateConversationAdapter;
import com.example.redoy.aistasker.models.Conversation;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrivateConversationActivity extends AppCompatActivity {

    private PrivateConversationAdapter mAdapter;
    private ArrayList<Conversation> messageArrayList;

    @BindView(R.id.message)
    EditText inputMessage;

    @BindView(R.id.btn_send)
    Button btnSend;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_conversation);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeWidgets();
    }

    private void initializeWidgets() {
        messageArrayList = new ArrayList<>();

        messageArrayList.add(new Conversation("Hi", "5:02pm", "Redoy"));
        messageArrayList.add(new Conversation("Hello", "5:05pm", "Redoy"));

        mAdapter = new PrivateConversationAdapter(messageArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    private void sendMessage() {
        final String message = this.inputMessage.getText().toString().trim();

        if (TextUtils.isEmpty(message)) {
            Toast.makeText(getApplicationContext(), "Enter a message", Toast.LENGTH_SHORT).show();
            return;
        }

        messageArrayList.add(new Conversation(message, "5:30pm", "Me"));

        mAdapter.notifyDataSetChanged();
        if (mAdapter.getItemCount() > 1) {
            recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null, mAdapter.getItemCount() - 1);
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.private_messages_menu, menu);
        return true;
    }
}
