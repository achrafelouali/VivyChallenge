package com.vivy.challenge.mvp.data.network;

import com.vivy.challenge.mvp.BuildConfig;


public final class ApiEndPoint {

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL_OAUTH
            + "/oauth/token?grant_type=password";

    public static final String ENDPOINT_DOCTOR = BuildConfig.BASE_URL_GET
            + "/api/users/me/doctors?search=";

    public static final String ENDPOINT_DOCTOR_PHOTO = BuildConfig.BASE_URL_GET
            + "/api/doctors/";

    public static final String KEYS_PROFILEPICTURES = "/keys/profilepictures";

    private ApiEndPoint() {
    }

}
