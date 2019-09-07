package com.vivy.challenge.mvp.di.component;

import com.vivy.challenge.mvp.di.PerActivity;
import com.vivy.challenge.mvp.di.module.ActivityModule;
import com.vivy.challenge.mvp.ui.doctors.DoctorActivity;
import com.vivy.challenge.mvp.ui.login.LoginActivity;
import com.vivy.challenge.mvp.ui.splash.SplashActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(DoctorActivity fragment);

}
