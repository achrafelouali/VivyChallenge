package com.vivy.challenge.mvp.ui.login;


import com.vivy.challenge.mvp.di.PerActivity;
import com.vivy.challenge.mvp.ui.base.MvpPresenter;


@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);
}
