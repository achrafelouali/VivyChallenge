package com.vivy.challenge.mvp.di.component;

import android.app.Application;
import android.content.Context;

import com.vivy.challenge.mvp.MvpApp;
import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.di.ApplicationContext;
import com.vivy.challenge.mvp.di.module.ApplicationModule;
import com.vivy.challenge.mvp.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}