package com.vivy.challenge.mvp.ui.doctors;

import com.androidnetworking.error.ANError;
import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.data.network.model.DoctorRequest;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.ui.base.BasePresenter;
import com.vivy.challenge.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public class DoctorPresenter<V extends DoctorMvpView> extends BasePresenter<V>
        implements DoctorMvpPresenter<V> {

    boolean mCanLoad = true;
    String mLastKey = "";

    @Inject
    public DoctorPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onServerLoadMore(String name, String sort) {

        if (mLastKey != null && mCanLoad) {
            mCanLoad = false;
            getMvpView().showLoading();
            getDoctorsFromServer(name, sort);
        }

    }

    @Override
    public void onServerSearchClick(String name, String sort) {
        mLastKey = "";
        mCanLoad = false;
        getMvpView().showLoading();
        getDoctorsFromServer(name, sort);
    }

    public void getDoctorsFromServer(String name, String sort) {

        getCompositeDisposable().add(getDataManager()
                .getDoctorApiCall(new DoctorRequest.ServerDoctorRequest(name, getDataManager().getLatitude(), getDataManager().getLongitude(), mLastKey, sort))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<DoctorResponse>() {
                    @Override
                    public void accept(DoctorResponse DoctorResponse) throws Exception {
                        if (DoctorResponse != null && DoctorResponse.getDoctors() != null) {
                            getMvpView().updateDoctor(DoctorResponse.getDoctors());
                            mLastKey = DoctorResponse.getLastKey();
                        }

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        mCanLoad = true;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

}
