package com.vivy.challenge.mvp.data.network;

import com.vivy.challenge.mvp.data.network.model.DoctorRequest;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.data.network.model.LoginRequest;
import com.vivy.challenge.mvp.data.network.model.LoginResponse;

import io.reactivex.Single;


public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<DoctorResponse> getDoctorApiCall(DoctorRequest.ServerDoctorRequest request);

}
