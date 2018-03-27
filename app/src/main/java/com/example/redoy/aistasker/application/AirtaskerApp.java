package com.example.redoy.aistasker.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.redoy.aistasker.dependencies.ApiComponent;
import com.example.redoy.aistasker.dependencies.Constant;
import com.example.redoy.aistasker.dependencies.DaggerApiComponent;
import com.example.redoy.aistasker.dependencies.DaggerNetworkComponent;
import com.example.redoy.aistasker.dependencies.NetworkComponent;
import com.example.redoy.aistasker.dependencies.NetworkModule;
import com.example.redoy.aistasker.widget.ConnectivityReceiver;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

public class AirtaskerApp extends Application {
    private ApiComponent mApiComponent;
    private static AirtaskerApp mInstance;
    private static Context mContext;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
        mInstance = this;
        AirtaskerApp.mContext = getApplicationContext();
        MultiDex.install(this);
    }

    public static synchronized AirtaskerApp getInstance() {
        return mInstance;
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
