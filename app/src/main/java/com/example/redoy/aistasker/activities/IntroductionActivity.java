package com.example.redoy.aistasker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.application.AirtaskerApp;
import com.example.redoy.aistasker.callbacks.SignUpViewInterface;
import com.example.redoy.aistasker.presenter.SignUpPresenter;
import com.example.redoy.aistasker.services.AirTaskerService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroductionActivity extends AppCompatActivity {

    @BindView(R.id.introduction_button_login)
    Button mButtonLogin;

    @BindView(R.id.introduction_button_sign_up)
    Button mButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroductionActivity.this, SignUpActivity.class));
            }
        });
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroductionActivity.this, LogInActivity.class));
            }
        });
    }
}
