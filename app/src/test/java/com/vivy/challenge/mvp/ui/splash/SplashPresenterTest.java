package com.vivy.challenge.mvp.ui.splash;

import android.location.Location;

import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by ELOUALI on 02/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    @Mock
    SplashMvpView mMockSplashMvpView;
    @Mock
    DataManager mMockDataManager;

    private SplashPresenter<SplashMvpView> mSplashPresenter;


    private TestScheduler mTestScheduler;


    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mSplashPresenter = new SplashPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mSplashPresenter.onAttach(mMockSplashMvpView);
    }

    @Test
    public void testFetchLocationSuccess() {

        Location locationResponse = new Location("GpsProvider");
        doReturn(Flowable.just(locationResponse)).when(mMockDataManager).getLocation();

        mSplashPresenter.onFetchLocation();
        mTestScheduler.triggerActions();


        verify(mMockSplashMvpView, never()).openMainActivity();
        verify(mMockSplashMvpView).openLoginActivity();
        verifyNoMoreInteractions(mMockSplashMvpView);
    }


    @After
    public void tearDown() throws Exception {
        mSplashPresenter.onDetach();
    }


}