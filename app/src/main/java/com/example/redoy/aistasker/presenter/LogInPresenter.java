package com.example.redoy.aistasker.presenter;

import com.example.redoy.aistasker.callbacks.LogInViewInterface;
import com.example.redoy.aistasker.models.LogInResponse;
import com.example.redoy.aistasker.models.SignUpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.HttpException;
import rx.Observer;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

public class LogInPresenter extends BasePresenter implements Observer<LogInResponse> {
    private LogInViewInterface mViewInterface;

    public LogInPresenter(LogInViewInterface mViewInterface) {
        this.mViewInterface = mViewInterface;
    }

    @Override
    public void onCompleted() {
        mViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpException) {
            try {
                JSONObject jsonObject = new JSONObject(((HttpException) t).response().errorBody().string());
                String message = jsonObject.getString("message");
                mViewInterface.onError(message);
            } catch (IOException e) {
                mViewInterface.onError("Connection failed Try Again!");
                e.printStackTrace();
            } catch (JSONException e) {
                mViewInterface.onError("Connection failed Try Again!");
                e.printStackTrace();
            }
        } else {
            mViewInterface.onError("Connection failed Try Again!");
        }
    }

    @Override
    public void onNext(LogInResponse logInResponse) {
        mViewInterface.onLogIn(logInResponse);
    }

    public void fetchLogIn(String nothing) {
        unSubscribeAll();
        subscribe(mViewInterface.getLogIn(nothing), LogInPresenter.this);
    }
}
