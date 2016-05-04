package com.taskmanager.taskmanager.interfacePackage;

import com.taskmanager.taskmanager.ActMainModel;
import com.taskmanager.taskmanager.actClasses.ActMain;

import dagger.Component;

@Component (modules = {ActMainModel.class})
public interface ModelComponent {
    void inject(ActMain actMain);
}
