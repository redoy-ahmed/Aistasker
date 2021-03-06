package com.example.redoy.aistasker.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.application.AirtaskerApp;
import com.example.redoy.aistasker.callbacks.SignUpViewInterface;
import com.example.redoy.aistasker.models.SignUpResponse;
import com.example.redoy.aistasker.presenter.SignUpPresenter;
import com.example.redoy.aistasker.services.AirTaskerService;
import com.example.redoy.aistasker.widget.ConnectivityReceiver;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;

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

    @BindView(R.id.sign_up_text_view_region_label)
    TextView mTextViewSelectRegionLabel;

    @BindView(R.id.sign_up_text_view_terms_and_conditions)
    TextView mTextViewTermsText;

    @BindView(R.id.login_button)
    LoginButton loginButton;

    @BindView(R.id.sign_up_drop_down_region_selection)
    Spinner mSpinnerRegion;

    private ProgressDialog mDialog;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_up);
        resolveDependency();
        ButterKnife.bind(this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        callbackManager = CallbackManager.Factory.create();

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

        List<String> list = new ArrayList<>();
        list.add("Australia");
        list.add("United Kingdom");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerRegion.setAdapter(dataAdapter);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent(getApplicationContext(), IntroductionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            }
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}