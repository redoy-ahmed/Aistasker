package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.redoy.aistasker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import us.feras.mdv.MarkdownView;

public class TermsAndConditionsActivity extends AppCompatActivity {

    @BindView(R.id.terms_and_conditions_button)
    Button mButtonAccept;

    @BindView(R.id.terms_and_conditions_mark_down_view)
    MarkdownView mMarkdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        ButterKnife.bind(this);
    }
}
