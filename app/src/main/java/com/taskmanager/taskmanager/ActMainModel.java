package com.taskmanager.taskmanager;


import dagger.Module;
import dagger.Provides;

@Module
public class ActMainModel {
    @Provides
    public ActMainPresenter providePresenter() {
        return new ActMainPresenter();
    }
}
