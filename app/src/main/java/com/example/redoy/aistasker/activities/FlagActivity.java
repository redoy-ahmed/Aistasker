package com.example.redoy.aistasker.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.models.FlagCategory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlagActivity extends AppCompatActivity {

    @BindView(R.id.flag_edit_text_user_input)
    EditText mCommentEditText;

    @BindView(R.id.flag_drop_down_category)
    Spinner mDropDownWidget;

    @BindView(R.id.flag_button_send)
    Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);
        ButterKnife.bind(this);
        initializeWidgets();
        initializeData();
    }

    private void initializeWidgets() {
    }

    private void initializeData() {

        String[] strArr = new String[FlagCategory.values().length];
        for (int i = 0; i < FlagCategory.values().length; i++) {
            strArr[i] = getString(FlagCategory.values()[i].getTitleId());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, strArr);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDropDownWidget.setAdapter(dataAdapter);
    }
}
