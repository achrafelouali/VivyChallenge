package com.vivy.challenge.mvp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.di.component.ApplicationComponent;
import com.vivy.challenge.mvp.di.component.DaggerApplicationComponent;
import com.vivy.challenge.mvp.di.module.ApplicationModule;

import javax.inject.Inject;


public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);


        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(Level.BODY);
        }


    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
