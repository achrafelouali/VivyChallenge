package com.vivy.challenge.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.di.ActivityContext;
import com.vivy.challenge.mvp.di.PerActivity;
import com.vivy.challenge.mvp.ui.doctors.DoctorAdapter;
import com.vivy.challenge.mvp.ui.doctors.DoctorMvpPresenter;
import com.vivy.challenge.mvp.ui.doctors.DoctorMvpView;
import com.vivy.challenge.mvp.ui.doctors.DoctorPresenter;
import com.vivy.challenge.mvp.ui.login.LoginMvpPresenter;
import com.vivy.challenge.mvp.ui.login.LoginMvpView;
import com.vivy.challenge.mvp.ui.login.LoginPresenter;
import com.vivy.challenge.mvp.ui.splash.SplashMvpPresenter;
import com.vivy.challenge.mvp.ui.splash.SplashMvpView;
import com.vivy.challenge.mvp.ui.splash.SplashPresenter;
import com.vivy.challenge.mvp.utils.rx.AppSchedulerProvider;
import com.vivy.challenge.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }


    @Provides
    DoctorMvpPresenter<DoctorMvpView> provideDoctorMvpPresenter(
            DoctorPresenter<DoctorMvpView> presenter) {
        return presenter;
    }


    @Provides
    DoctorAdapter provideDoctorAdapter(DoctorPresenter<DoctorMvpView> presenter) {
        return new DoctorAdapter(new ArrayList<DoctorResponse.Doctor>(), presenter);
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
