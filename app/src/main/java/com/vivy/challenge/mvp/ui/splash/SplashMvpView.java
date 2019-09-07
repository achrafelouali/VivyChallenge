package com.vivy.challenge.mvp.ui.splash;

import com.vivy.challenge.mvp.ui.base.MvpView;


public interface SplashMvpView extends MvpView {

    void openLoginActivity();

    void openMainActivity();

    void showPermissionNotGrantedView();

}
