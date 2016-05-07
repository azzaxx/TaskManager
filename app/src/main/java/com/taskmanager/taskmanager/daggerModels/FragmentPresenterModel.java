package com.taskmanager.taskmanager.daggerModels;

import com.taskmanager.taskmanager.daggerPresenters.FragmentListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentPresenterModel {
    @Provides
    public FragmentListPresenter providePresenter() {
        return new FragmentListPresenter();
    }
}
