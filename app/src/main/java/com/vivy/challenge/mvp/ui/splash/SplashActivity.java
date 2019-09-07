package com.vivy.challenge.mvp.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.vivy.challenge.mvp.R;
import com.vivy.challenge.mvp.ui.base.BaseActivity;
import com.vivy.challenge.mvp.ui.doctors.DoctorActivity;
import com.vivy.challenge.mvp.ui.login.LoginActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);
        mPresenter.onLocationPermissionCheck();

    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = DoctorActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void showPermissionNotGrantedView() {
        Snackbar mySnackbar = Snackbar.make(findViewById(android.R.id.content),
                R.string.location_permission_not_granted_error, Snackbar.LENGTH_INDEFINITE);
        View snackBarView = mySnackbar.getView();
        snackBarView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        mySnackbar.setAction(R.string.retry, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onLocationPermissionCheck();
            }
        });
        mySnackbar.show();
    }
}
