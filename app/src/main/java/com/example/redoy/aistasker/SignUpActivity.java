package com.example.redoy.aistasker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.sign_up_login_button_facebook)
    Button mButtonFacebook;

    @BindView(R.id.sign_up_login_button_login)
    Button mButtonMainAction;

    @BindView(R.id.login_text_view_user_blue_a)
    TextView mTextViewBlueA;

    @BindView(R.id.login_text_view_user_blue_b)
    TextView mTextViewBlueB;

    @BindView(R.id.sign_up_login_text_view_forgot_password_button)
    TextView mTextViewForgotPasswordButton;

    @BindView(R.id.login_text_view_user_green_a)
    TextView mTextViewGreenA;

    @BindView(R.id.login_text_view_user_green_b)
    TextView mTextViewGreenB;

    @BindView(R.id.login_text_view_user_pink_a)
    TextView mTextViewPinkA;

    @BindView(R.id.login_text_view_user_pink_b)
    TextView mTextViewPinkB;

    @BindView(R.id.login_text_view_user_pink_c)
    TextView mTextViewPinkC;

    @BindView(R.id.login_text_view_user_pink_d)
    TextView mTextViewPinkD;

    @BindView(R.id.login_text_view_user_red_a)
    TextView mTextViewRedA;

    @BindView(R.id.login_text_view_user_red_b)
    TextView mTextViewRedB;

    @BindView(R.id.login_text_view_user_red_c)
    TextView mTextViewRedC;

    @BindView(R.id.login_text_view_user_red_d)
    TextView mTextViewRedD;

    @BindView(R.id.sign_up_login_text_view_region_label)
    TextView mTextViewSelectRegionLabel;

    @BindView(R.id.sign_up_login_text_view_terms_and_conditions)
    TextView mTextViewTermsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }
}
