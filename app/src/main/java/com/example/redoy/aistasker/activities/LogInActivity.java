package com.example.redoy.aistasker.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.application.AirtaskerApp;
import com.example.redoy.aistasker.callbacks.LogInViewInterface;
import com.example.redoy.aistasker.models.LogInResponse;
import com.example.redoy.aistasker.presenter.LogInPresenter;
import com.example.redoy.aistasker.services.AirTaskerService;
import com.example.redoy.aistasker.widget.ConnectivityReceiver;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class LogInActivity extends AppCompatActivity implements LogInViewInterface {

    @Inject
    AirTaskerService mService;
    private LogInPresenter mPresenter;

    @BindView(R.id.login_button)
    Button mButtonLogIn;

    @BindView(R.id.login_with_facebook_button)
    LoginButton loginButton;

    private ProgressDialog mDialog;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        callbackManager = CallbackManager.Factory.create();

        resolveDependency();
        ButterKnife.bind(this);

        mPresenter = new LogInPresenter(LogInActivity.this);
        mPresenter.onCreate();

        mDialog = new ProgressDialog(this);

        mButtonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkConnection()) {
                    getLogIn();
                }
            }
        });
    }

    private void getLogIn() {
        mDialog.setMessage("Loading...");
        mDialog.show();
        mPresenter.onResume();
        mPresenter.fetchLogIn("");
    }

    private void resolveDependency() {
        ((AirtaskerApp) getApplication())
                .getApiComponent()
                .inject(LogInActivity.this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onLogIn(LogInResponse logInResponse) {
        if (logInResponse != null) {
            if (logInResponse.getId().equals("1")) {
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
            } else {
                showToast();
            }
        }
    }

    @Override
    public Observable<LogInResponse> getLogIn(String nothing) {
        return mService.getLogInResponse();
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
