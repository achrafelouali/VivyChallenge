package com.vivy.challenge.mvp.di.component;

import com.vivy.challenge.mvp.di.PerService;
import com.vivy.challenge.mvp.di.module.ServiceModule;
import com.vivy.challenge.mvp.service.SyncService;

import dagger.Component;


@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
