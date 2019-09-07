package com.vivy.challenge.mvp.data.prefs;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by ELOUALI Achraf on 07/09/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppPreferencesHelperTest {

    private AppPreferencesHelper mAppPreferencesHelper;

    @Before
    public void setUp() throws Exception {
        mAppPreferencesHelper = Mockito.mock(AppPreferencesHelper.class);
    }

    @Test
    public void SaveAndGetAccessToken() throws Exception {
        String AccessToken = "AcessToken";
        mAppPreferencesHelper.setAccessToken(AccessToken);
        Mockito.when(mAppPreferencesHelper.getAccessToken()).thenReturn(AccessToken);
        Assert.assertEquals(AccessToken, mAppPreferencesHelper.getAccessToken());
    }


}
