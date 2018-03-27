package com.example.redoy.aistasker.callbacks;

import com.example.redoy.aistasker.models.SignUpResponse;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

public interface SignUpViewInterface {

    void onCompleted();

    void onError(String message);

    void onSignUp(SignUpResponse signUpResponse);

    Observable<SignUpResponse> getSignUp(String nothing);
}
