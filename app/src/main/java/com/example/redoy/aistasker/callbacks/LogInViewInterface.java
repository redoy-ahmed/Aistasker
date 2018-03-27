package com.example.redoy.aistasker.callbacks;

import com.example.redoy.aistasker.models.LogInResponse;

import rx.Observable;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

public interface LogInViewInterface {

    void onCompleted();

    void onError(String message);

    void onLogIn(LogInResponse logInResponse);

    Observable<LogInResponse> getLogIn(String nothing);
}
