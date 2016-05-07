package com.taskmanager.taskmanager.daggerComponents;

import com.taskmanager.taskmanager.daggerModels.TaskHolderModel;
import com.taskmanager.taskmanager.fragment.FragmentCreateTask;
import com.taskmanager.taskmanager.daggerModels.CreateTaskFragmentPresenterModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TaskHolderModel.class, CreateTaskFragmentPresenterModel.class})
public interface CreateTaskFragmentComponent {
    void inject(FragmentCreateTask fragmentCreateTask);
}
