package com.vivy.challenge.mvp.data;


import android.content.Context;
import android.location.Location;

import com.vanniktech.rxpermission.RxPermission;
import com.vivy.challenge.mvp.data.location.LocationHelper;
import com.vivy.challenge.mvp.data.network.ApiHeader;
import com.vivy.challenge.mvp.data.network.ApiHelper;
import com.vivy.challenge.mvp.data.network.model.DoctorRequest;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.data.network.model.LoginRequest;
import com.vivy.challenge.mvp.data.network.model.LoginResponse;
import com.vivy.challenge.mvp.data.prefs.PreferencesHelper;
import com.vivy.challenge.mvp.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Single;


@Singleton
public class AppDataManager implements DataManager {


    private final Context mContext;

    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;
    private final LocationHelper mLocationHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context context,

                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper, LocationHelper locationHelper) {
        mContext = context;

        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mLocationHelper = locationHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }


    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiHelper.doServerLoginApiCall(request);
    }


    @Override
    public Flowable<Location> getLocation() {
        return mLocationHelper.getLocation();
    }


    @Override
    public RxPermission getPermission() {
        return mLocationHelper.getPermission();
    }

    @Override
    public void updateUserInfo(String accessToken, String tokenType, String refreshToken, Integer expiresIn, String scope, String jti, Boolean phoneVerified) {
        setAccessToken(accessToken);
        setTokenType(tokenType);
        setRefreshToken(refreshToken);
        setExpiresIn(expiresIn);
        setScope(scope);
        setJti(jti);
        setPhoneVerified(phoneVerified);
        updateApiHeader(accessToken);
    }


    @Override
    public void setTokenType(String tokenType) {
        mPreferencesHelper.setTokenType(tokenType);
    }


    @Override
    public void setRefreshToken(String refreshToken) {
        mPreferencesHelper.setRefreshToken(refreshToken);
    }


    @Override
    public void setExpiresIn(Integer expiresIn) {
        mPreferencesHelper.setExpiresIn(expiresIn);
    }


    @Override
    public void setScope(String scope) {
        mPreferencesHelper.setScope(scope);
    }


    @Override
    public void setJti(String jti) {
        mPreferencesHelper.setJti(jti);
    }


    @Override
    public void setPhoneVerified(Boolean phoneVerified) {
        mPreferencesHelper.setPhoneVerified(phoneVerified);
    }

    @Override
    public void updateApiHeader(String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public double getLatitude() {
        return mPreferencesHelper.getLatitude();
    }

    @Override
    public void setLatitude(double latitude) {
        mPreferencesHelper.setLatitude(latitude);
    }

    @Override
    public double getLongitude() {
        return mPreferencesHelper.getLongitude();
    }

    @Override
    public void setLongitude(double longitude) {
        mPreferencesHelper.setLongitude(longitude);
    }

    @Override
    public Single<DoctorResponse> getDoctorApiCall(DoctorRequest.ServerDoctorRequest request) {
        return mApiHelper.getDoctorApiCall(request);
    }
}
