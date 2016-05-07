package com.taskmanager.taskmanager.daggerModels;


import com.taskmanager.taskmanager.daggerPresenters.CrateTaskFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateTaskFragmentPresenterModel {
    @Provides
    public CrateTaskFragmentPresenter providePresenter() {
        return new CrateTaskFragmentPresenter();
    }
}
