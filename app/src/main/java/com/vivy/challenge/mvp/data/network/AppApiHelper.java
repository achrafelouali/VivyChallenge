package com.vivy.challenge.mvp.data.network;


import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.vivy.challenge.mvp.BuildConfig;
import com.vivy.challenge.mvp.data.network.model.DoctorRequest;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.data.network.model.LoginRequest;
import com.vivy.challenge.mvp.data.network.model.LoginResponse;
import com.vivy.challenge.mvp.utils.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;


@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }


    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(AppConstants.AUTHORIZATION, AppConstants.AUTHORIZATION_TYPE_BASIC + " " + BuildConfig.SERVER_BASIC_AUTHORIZATION)
                .addHeaders(AppConstants.HEADER_ACCEPT, AppConstants.HEADER_ACCEPT_FORMAT)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }


    @Override
    public Single<DoctorResponse> getDoctorApiCall(DoctorRequest.ServerDoctorRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_DOCTOR + request.constructParams())
                .addHeaders(AppConstants.AUTHORIZATION, AppConstants.AUTHORIZATION_TYPE_BEARER + " " + mApiHeader.getProtectedApiHeader().getAccessToken())
                .addHeaders(AppConstants.HEADER_ACCEPT, AppConstants.HEADER_ACCEPT_FORMAT)
                .build()
                .getObjectSingle(DoctorResponse.class);
    }


}

