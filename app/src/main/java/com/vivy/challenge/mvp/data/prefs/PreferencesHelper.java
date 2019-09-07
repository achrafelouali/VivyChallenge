package com.vivy.challenge.mvp.data.prefs;


public interface PreferencesHelper {


    String getAccessToken();

    void setAccessToken(String accessToken);

    void setTokenType(String tokenType);

    void setRefreshToken(String refreshToken);

    void setExpiresIn(Integer expiresIn);

    void setScope(String scope);

    void setJti(String jti);

    void setPhoneVerified(Boolean phoneVerified);

    double getLatitude();

    void setLatitude(double latitude);

    double getLongitude();

    void setLongitude(double longitude);

}
