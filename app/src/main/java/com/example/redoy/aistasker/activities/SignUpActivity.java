package com.example.redoy.aistasker.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.application.AirtaskerApp;
import com.example.redoy.aistasker.callbacks.SignUpViewInterface;
import com.example.redoy.aistasker.models.SignUpResponse;
import com.example.redoy.aistasker.presenter.SignUpPresenter;
import com.example.redoy.aistasker.services.AirTaskerService;
import com.example.redoy.aistasker.widget.ConnectivityReceiver;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class SignUpActivity extends AppCompatActivity implements SignUpViewInterface {

    @Inject
    AirTaskerService mService;
    private SignUpPresenter mPresenter;

    @BindView(R.id.sign_up_button)
    Button mButtonSignUp;

    @BindView(R.id.sign_up_login_text_view_region_label)
    TextView mTextViewSelectRegionLabel;

    @BindView(R.id.sign_up_login_text_view_terms_and_conditions)
    TextView mTextViewTermsText;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        resolveDependency();
        ButterKnife.bind(this);

        mPresenter = new SignUpPresenter(this);
        mPresenter.onCreate();

        mDialog = new ProgressDialog(this);

        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkConnection()) {
                    getSignUp();
                }
            }
        });
    }

    private void getSignUp() {
        mDialog.setMessage("Loading...");
        mDialog.show();
        mPresenter.onResume();
        mPresenter.fetchSignUp("");
    }

    private void resolveDependency() {
        ((AirtaskerApp) getApplication())
                .getApiComponent()
                .inject(SignUpActivity.this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {
        Log.e("error", message);
        mDialog.dismiss();
    }

    @Override
    public void onSignUp(SignUpResponse signUpResponse) {
        if (signUpResponse != null) {
            if (signUpResponse.getId().equals("1")) {
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
            } else {
                showToast();
            }
        }
    }

    @Override
    public Observable<SignUpResponse> getSignUp(String nothing) {
        return mService.getSignUpResponse();
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), "Error occured!", Toast.LENGTH_LONG).show();
    }

    private boolean checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        return isConnected;
    }
}