package com.vivy.challenge.mvp.ui.doctor;

import com.vivy.challenge.mvp.data.DataManager;
import com.vivy.challenge.mvp.data.network.model.DoctorRequest;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.ui.doctors.DoctorMvpView;
import com.vivy.challenge.mvp.ui.doctors.DoctorPresenter;
import com.vivy.challenge.mvp.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by ELOUALI on 02/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DoctorPresenterTest {

    @Mock
    DoctorMvpView mMockDoctorMvpView;
    @Mock
    DataManager mMockDataManager;


    private DoctorPresenter<DoctorMvpView> mDoctorPresenter;


    private TestScheduler mTestScheduler;


    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mDoctorPresenter = new DoctorPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mDoctorPresenter.onAttach(mMockDoctorMvpView);
    }

    @Test
    public void testServerGetDoctorSuccess() {

        String mName = "Fred";
        double mLatitude = 12.0d;
        double mLongitude = 13.0d;
        String mLast = "";
        String mSort = "distance";

        DoctorResponse doctorResponse = new DoctorResponse();

        doReturn(Single.just(doctorResponse))
                .when(mMockDataManager)
                .getDoctorApiCall(eq(new DoctorRequest
                        .ServerDoctorRequest(mName, mLatitude, mLongitude, mLast, mSort)));


        mDoctorPresenter.onServerSearchClick(mName, mSort);
        mTestScheduler.triggerActions();

        verify(mMockDoctorMvpView).showLoading();
        verify(mMockDoctorMvpView).hideLoading();
    }


    @Test
    public void testServerLoadMoreDoctorSuccess() {

        String mName = "Frank";
        double mLatitude = 52.534709d;
        double mLongitude = 13.3976972d;
        String mLast = "";
        String mSort = "distance";

        DoctorResponse doctorResponse = new DoctorResponse();

        doReturn(Single.just(doctorResponse))
                .when(mMockDataManager)
                .getDoctorApiCall(eq(new DoctorRequest
                        .ServerDoctorRequest(mName, mLatitude, mLongitude, mLast, mSort)));


        mDoctorPresenter.onServerLoadMore(mName, mSort);
        mTestScheduler.triggerActions();

        verify(mMockDoctorMvpView).showLoading();
        verify(mMockDoctorMvpView).hideLoading();
    }


    @After
    public void tearDown() throws Exception {
        mDoctorPresenter.onDetach();
    }


}