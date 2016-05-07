package com.taskmanager.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.fragment.base.BaseFragmentWithFab;
import com.taskmanager.taskmanager.main.ActMain;
import com.taskmanager.taskmanager.adapter.TaskListAdapter;
import com.taskmanager.taskmanager.daggerComponents.DaggerListModelComponent;
import com.taskmanager.taskmanager.daggerComponents.ListModelComponent;
import com.taskmanager.taskmanager.daggerModels.FragmentPresenterModel;
import com.taskmanager.taskmanager.daggerModels.TaskHolderModel;
import com.taskmanager.taskmanager.notUI.TaskHolder;
import com.taskmanager.taskmanager.daggerPresenters.FragmentListPresenter;

import javax.inject.Inject;

public class FragmentTaskList extends BaseFragmentWithFab implements View.OnClickListener {
    private TaskListAdapter adapter;
    private ListModelComponent mComponent;
    @Inject
    FragmentListPresenter mPresenter;
    @Inject
    TaskHolder taskHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mComponent.inject(this);
        return inflater.inflate(R.layout.fragment_list_start, container, false);
    }

    @Override
    protected void initComponent() {
        mComponent = DaggerListModelComponent.builder()
                .fragmentPresenterModel(new FragmentPresenterModel())
                .taskHolderModel(new TaskHolderModel())
                .build();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter.addView(this);
        adapter = new TaskListAdapter(getActivity(), R.layout.list_item_main, taskHolder.getArrayOfTasks());
        ((ListView) view.findViewById(R.id.fragment_list_start_list_view)).
                setAdapter(adapter);
        fabButton.setFloatingActionButtonDrawable(getResources().getDrawable(R.drawable.ic_vector_add_black_48px));
    }

    @Override
    public void onStart() {
        fabButton.setOnClickListener(this);
        adapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        ((ActMain)getActivity()).getActMainPresenter().showFragment(new FragmentCreateTask(), true);
    }
}
