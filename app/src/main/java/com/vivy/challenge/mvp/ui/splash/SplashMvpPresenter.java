package com.vivy.challenge.mvp.ui.splash;


import com.vivy.challenge.mvp.di.PerActivity;
import com.vivy.challenge.mvp.ui.base.MvpPresenter;


@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void onLocationPermissionCheck();

    void onFetchLocation();

}
