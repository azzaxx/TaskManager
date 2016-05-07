package com.taskmanager.taskmanager.daggerModels;


import com.taskmanager.taskmanager.daggerPresenters.ActMainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActMainModel {
    @Provides
    public ActMainPresenter providePresenter() {
        return new ActMainPresenter();
    }
}
