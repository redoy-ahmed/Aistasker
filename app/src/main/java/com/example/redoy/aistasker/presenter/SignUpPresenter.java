package com.example.redoy.aistasker.presenter;

import com.example.redoy.aistasker.callbacks.SignUpViewInterface;
import com.example.redoy.aistasker.models.SignUpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.HttpException;
import rx.Observer;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

public class SignUpPresenter extends BasePresenter implements Observer<SignUpResponse> {

    private SignUpViewInterface mViewInterface;

    public SignUpPresenter(SignUpViewInterface mViewInterface) {
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
    public void onNext(SignUpResponse signUpResponse) {
        mViewInterface.onSignUp(signUpResponse);
    }

    public void fetchSignUp(String nothing) {
        unSubscribeAll();
        subscribe(mViewInterface.getSignUp(nothing), SignUpPresenter.this);
    }
}
