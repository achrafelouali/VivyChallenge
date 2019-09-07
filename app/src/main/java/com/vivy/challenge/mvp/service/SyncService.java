package com.vivy.challenge.mvp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.vivy.challenge.mvp.MvpApp;
import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.di.component.DaggerServiceComponent;
import com.vivy.challenge.mvp.di.component.ServiceComponent;

import javax.inject.Inject;


public class SyncService extends Service {

    @Inject
    DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((MvpApp) getApplication()).getComponent())
                .build();
        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
