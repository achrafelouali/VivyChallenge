package com.vivy.challenge.mvp.ui.splash;

import android.Manifest;
import android.location.Location;

import com.vanniktech.rxpermission.Permission;
import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.ui.base.BasePresenter;
import com.vivy.challenge.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    Disposable disposable;

    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    private void decideNextActivity() {
        if (getDataManager().getAccessToken() == null) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openMainActivity();
        }
    }

    @Override
    public void onFetchLocation() {

        disposable = getDataManager()
                .getLocation()
                .subscribe(new Consumer<Location>() {
                    @Override
                    public void accept(Location location) throws Exception {
                        getDataManager().setLatitude(location.getLatitude());
                        getDataManager().setLongitude(location.getLongitude());

                        if (!isViewAttached()) {
                            return;
                        }

                        decideNextActivity();
                        disposable.dispose();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }


    @Override
    public void onLocationPermissionCheck() {
        getCompositeDisposable().add(getDataManager().getPermission().requestEach(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(@NonNull Permission Permission)
                            throws Exception {

                        if (Permission.state() == com.vanniktech.rxpermission.Permission.State.GRANTED) {
                            onFetchLocation();
                        } else {
                            getMvpView().showPermissionNotGrantedView();
                        }
                    }
                }));
    }
}
