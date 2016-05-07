package com.taskmanager.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.daggerComponents.CreateTaskFragmentComponent;
import com.taskmanager.taskmanager.daggerComponents.DaggerCreateTaskFragmentComponent;
import com.taskmanager.taskmanager.daggerModels.CreateTaskFragmentPresenterModel;
import com.taskmanager.taskmanager.daggerModels.TaskHolderModel;
import com.taskmanager.taskmanager.fragment.base.BaseFragmentWithFab;
import com.taskmanager.taskmanager.notUI.TaskHolder;
import com.taskmanager.taskmanager.daggerPresenters.CrateTaskFragmentPresenter;
import com.taskmanager.taskmanager.view.FloatingActionButton;

import javax.inject.Inject;

public class FragmentCreateTask extends BaseFragmentWithFab implements View.OnClickListener {
    private CreateTaskFragmentComponent mComponent;
    @Inject
    TaskHolder taskHolder;
    @Inject
    CrateTaskFragmentPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mComponent.inject(this);
        return inflater.inflate(R.layout.fragment_create_task, container, false);
    }

    @Override
    protected void initComponent() {
        mComponent = DaggerCreateTaskFragmentComponent.builder()
                .listViewModel(new TaskHolderModel())
                .createTaskFragmentPresenterModel(new CreateTaskFragmentPresenterModel())
                .build();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.addView(this);
        fabButton.setFloatingActionButtonDrawable(getResources().getDrawable(R.drawable.ic_vector_done_black_48px));
        fabButton.setOnClickListener(this);
    }

    @Override
    public void onStop() {
        fabButton.setFloatingActionButtonDrawable(getResources().getDrawable(R.drawable.ic_vector_add_black_48px));
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        if (v instanceof FloatingActionButton) {
            taskHolder.getArrayOfTasks().add(mPresenter.addListItem());
            getFragmentManager().popBackStack();
        }
    }
}
