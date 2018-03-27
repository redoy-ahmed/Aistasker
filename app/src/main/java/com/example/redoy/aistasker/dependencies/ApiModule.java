package com.example.redoy.aistasker.dependencies;

import com.example.redoy.aistasker.services.AirTaskerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    AirTaskerService provideFeedService(Retrofit retrofit) {
        return retrofit.create(AirTaskerService.class);
    }
}