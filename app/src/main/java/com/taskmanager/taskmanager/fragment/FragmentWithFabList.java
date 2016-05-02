package com.taskmanager.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.taskmanager.taskmanager.Model;
import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.actClasses.ActMain;
import com.taskmanager.taskmanager.adapter.FragmentListAdapter;
import com.taskmanager.taskmanager.view.FloatingActionButton;

public class FragmentWithFabList extends CommonFragmentWithFab implements View.OnClickListener {
    private ListView lvMainList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_list_start, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        lvMainList = (ListView) view.findViewById(R.id.fragment_list_start_list_view);
        lvMainList.setAdapter(new FragmentListAdapter(getActivity(), R.layout.list_item_main,
                Model.newInstance().list));
        fabButton.setFloatingActionButtonDrawable(getResources().getDrawable(R.drawable.ic_vector_add_black_48px));
        fabButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof FloatingActionButton) {
            ((ActMain) getActivity()).showFragment(new FragmentWithFabCreateTask(), FragmentWithFabCreateTask.class.toString());
        }
    }
}
