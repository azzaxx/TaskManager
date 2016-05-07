package com.taskmanager.taskmanager.daggerModels;

import com.taskmanager.taskmanager.notUI.TaskHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskHolderModel {
    @Provides
    @Singleton
    public TaskHolder provideMainListClass() {
        return new TaskHolder();
    }
}
