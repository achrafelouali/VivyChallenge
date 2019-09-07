package com.vivy.challenge.mvp.data.location;

import android.content.Context;
import android.location.Location;

import com.github.abdularis.rxlocation.RxLocation;
import com.google.android.gms.location.LocationRequest;
import com.vanniktech.rxpermission.RealRxPermission;
import com.vanniktech.rxpermission.RxPermission;
import com.vivy.challenge.mvp.di.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class AppLocationHelper implements LocationHelper {

    private final Flowable<Location> mLocationBuilder;
    private final RxPermission mPermission;

    @Inject
    public AppLocationHelper(@ApplicationContext Context context) {
        mLocationBuilder = RxLocation.getLocationUpdatesBuilder(context)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(2000)
                .setFastestInterval(1000)
                .build();

        mPermission = RealRxPermission.getInstance(context);
    }

    @Override
    public Flowable<Location> getLocation() {
        return mLocationBuilder;

    }

    @Override
    public RxPermission getPermission() {
        return mPermission;
    }
}
