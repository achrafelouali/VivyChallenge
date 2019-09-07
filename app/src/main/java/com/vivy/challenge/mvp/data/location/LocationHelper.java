package com.vivy.challenge.mvp.data.location;


import android.location.Location;

import com.vanniktech.rxpermission.RxPermission;

import io.reactivex.Flowable;

public interface LocationHelper {

    Flowable<Location> getLocation();

    RxPermission getPermission();
}
