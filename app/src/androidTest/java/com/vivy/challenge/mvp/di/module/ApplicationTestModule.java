package com.vivy.challenge.mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.vivy.challenge.mvp.BuildConfig;
import com.vivy.challenge.mvp.data.AppDataManager;
import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.data.location.AppLocationHelper;
import com.vivy.challenge.mvp.data.location.LocationHelper;
import com.vivy.challenge.mvp.data.network.ApiHeader;
import com.vivy.challenge.mvp.data.network.ApiHelper;
import com.vivy.challenge.mvp.data.network.AppApiHelper;
import com.vivy.challenge.mvp.data.prefs.AppPreferencesHelper;
import com.vivy.challenge.mvp.data.prefs.PreferencesHelper;
import com.vivy.challenge.mvp.di.ApiInfo;
import com.vivy.challenge.mvp.di.ApplicationContext;
import com.vivy.challenge.mvp.di.PreferenceInfo;
import com.vivy.challenge.mvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by ELOUALI on 03/02/17.
 */
@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    LocationHelper provideAppLocationHelper(AppLocationHelper appLocationHelper) {
        return appLocationHelper;
    }


    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                preferencesHelper.getAccessToken());
    }


}
