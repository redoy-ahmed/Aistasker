package com.example.redoy.aistasker.services;

import com.example.redoy.aistasker.models.LogInResponse;
import com.example.redoy.aistasker.models.SignUpResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

public interface AirTaskerService {

    @GET("posts/1")
    Observable<SignUpResponse> getSignUpResponse();

    @GET("posts/1")
    Observable<LogInResponse> getLogInResponse();
}
