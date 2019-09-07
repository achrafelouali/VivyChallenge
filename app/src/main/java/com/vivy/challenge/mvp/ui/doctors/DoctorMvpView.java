package com.vivy.challenge.mvp.ui.doctors;

import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by ELOUALI ACHRAF on 05/09/2019.
 */

public interface DoctorMvpView extends MvpView {

    void updateDoctor(List<DoctorResponse.Doctor> DoctorList);

}
