package com.vivy.challenge.mvp.ui.doctors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.vivy.challenge.mvp.R;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.ui.base.BaseActivity;
import com.vivy.challenge.mvp.ui.custom.InfiniteScrollListener;
import com.vivy.challenge.mvp.utils.AppConstants;
import com.vivy.challenge.mvp.utils.KeyboardUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public class DoctorActivity extends BaseActivity implements
        DoctorMvpView, DoctorAdapter.Callback {


    @Inject
    DoctorMvpPresenter<DoctorMvpView> mPresenter;

    @Inject
    DoctorAdapter mDoctorAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.doctor_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.et_server_search)
    EditText mEditTextSearchName;


    String name;
    String mSort = AppConstants.DOCTOR_SORT_PARAM;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DoctorActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));


        mPresenter.onAttach(this);


        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mDoctorAdapter);

        mRecyclerView.addOnScrollListener(new InfiniteScrollListener() {
            @Override
            protected void loadMore() {
                mPresenter.onServerLoadMore(name, mSort);
            }
        });

    }

    @OnClick(R.id.btn_server_search)
    void onServerSearchClick(View v) {
        callPresenterToPerformSearch();
    }

    @OnEditorAction(R.id.et_server_search)
    boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            callPresenterToPerformSearch();
            return true;
        }
        return false;
    }


    @Override
    public void updateDoctor(List<DoctorResponse.Doctor> DoctorList) {
        mDoctorAdapter.addItems(DoctorList);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    public void callPresenterToPerformSearch() {
        KeyboardUtils.hideSoftInput(this);
        name = mEditTextSearchName.getText().toString();
        mDoctorAdapter.clearItems();
        mPresenter.onServerSearchClick(name, mSort);
    }

}
