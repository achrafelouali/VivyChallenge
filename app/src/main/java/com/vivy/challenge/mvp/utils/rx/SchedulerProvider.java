package com.vivy.challenge.mvp.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Achraf ELOUALI on 5/09/2019.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler io();

}
