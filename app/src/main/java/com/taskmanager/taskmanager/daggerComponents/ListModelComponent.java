package com.taskmanager.taskmanager.daggerComponents;

import com.taskmanager.taskmanager.daggerModels.TaskHolderModel;
import com.taskmanager.taskmanager.fragment.FragmentTaskList;
import com.taskmanager.taskmanager.daggerModels.FragmentPresenterModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TaskHolderModel.class, FragmentPresenterModel.class})
public interface ListModelComponent {
    void inject(FragmentTaskList fragmentTaskList);
}
