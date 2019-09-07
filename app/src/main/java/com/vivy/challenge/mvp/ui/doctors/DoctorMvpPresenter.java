package com.vivy.challenge.mvp.ui.doctors;

import com.vivy.challenge.mvp.ui.base.MvpPresenter;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public interface DoctorMvpPresenter<V extends DoctorMvpView>
        extends MvpPresenter<V> {

    void onServerSearchClick(String name, String sort);

    void onServerLoadMore(String name, String sort);


}


