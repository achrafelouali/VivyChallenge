package com.vivy.challenge.mvp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.vivy.challenge.mvp.di.ApplicationContext;
import com.vivy.challenge.mvp.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppPreferencesHelper implements PreferencesHelper {


    static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    static final String PREF_KEY_TOKEN_TYPE = "PREF_KEY_TOKEN_TYPE";
    static final String PREF_KEY_REFRESH_TOKEN = "PREF_KEY_REFRESH_TOKEN";
    static final String PREF_KEY_SCOPE = "PREF_KEY_SCOPE";
    static final String PREF_KEY_JTI = "PREF_KEY_JTI";
    static final String PREF_KEY_PHONE_VERIFIED = "PREF_KEY_PHONE_VERIFIED";
    static final String PREF_KEY_EXPIRES_IN = "PREF_KEY_EXPIRES_IN";

    static final String PREF_KEY_LATITUDE = "PREF_KEY_LATITUDE";
    static final String PREF_KEY_LONGITUDE = "PREF_KEY_LONGITUDE";


    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }


    @Override
    public void setTokenType(String tokenType) {
        mPrefs.edit().putString(PREF_KEY_TOKEN_TYPE, tokenType).apply();
    }


    @Override
    public void setRefreshToken(String refreshToken) {
        mPrefs.edit().putString(PREF_KEY_REFRESH_TOKEN, refreshToken).apply();
    }


    @Override
    public void setExpiresIn(Integer expiresIn) {
        mPrefs.edit().putInt(PREF_KEY_EXPIRES_IN, expiresIn).apply();
    }


    @Override
    public void setScope(String scope) {
        mPrefs.edit().putString(PREF_KEY_SCOPE, scope).apply();
    }

    @Override
    public void setJti(String jti) {
        mPrefs.edit().putString(PREF_KEY_JTI, jti).apply();
    }


    @Override
    public void setPhoneVerified(Boolean phoneVerified) {
        mPrefs.edit().putBoolean(PREF_KEY_PHONE_VERIFIED, phoneVerified).apply();
    }

    @Override
    public double getLatitude() {
        return Double.longBitsToDouble(mPrefs.getLong(PREF_KEY_LATITUDE, 0L));
    }

    @Override
    public void setLatitude(double latitude) {
        mPrefs.edit().putLong(PREF_KEY_LATITUDE, Double.doubleToRawLongBits(latitude)).apply();
    }

    @Override
    public double getLongitude() {
        return Double.longBitsToDouble(mPrefs.getLong(PREF_KEY_LONGITUDE, 0L));
    }

    @Override
    public void setLongitude(double longitude) {
        mPrefs.edit().putLong(PREF_KEY_LONGITUDE, Double.doubleToRawLongBits(longitude)).apply();
    }
}
