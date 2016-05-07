package com.taskmanager.taskmanager.daggerComponents;

import com.taskmanager.taskmanager.daggerModels.ActMainModel;
import com.taskmanager.taskmanager.main.ActMain;

import dagger.Component;

@Component (modules = {ActMainModel.class})
public interface ModelComponent {
    void inject(ActMain actMain);
}
