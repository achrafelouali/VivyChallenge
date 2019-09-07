package com.vivy.challenge.mvp.data;


import com.vivy.challenge.mvp.data.location.LocationHelper;
import com.vivy.challenge.mvp.data.network.ApiHelper;
import com.vivy.challenge.mvp.data.prefs.PreferencesHelper;


public interface DataManager extends PreferencesHelper, ApiHelper, LocationHelper {

    void updateApiHeader(String accessToken);

    void updateUserInfo(
            String accessToken,
            String tokenType,
            String refreshToken,
            Integer expiresIn,
            String scope,
            String jti,
            Boolean phoneVerified
    );
}
