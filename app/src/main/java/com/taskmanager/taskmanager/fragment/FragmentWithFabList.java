package com.taskmanager.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.adapter.FragmentListAdapter;
import com.taskmanager.taskmanager.notUI.MainListClass;
import com.taskmanager.taskmanager.view.FloatingActionButton;

import java.util.ArrayList;

public class FragmentWithFabList extends CommonFragmentWithFab implements View.OnClickListener {
    private FragmentListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_list_start, container, false);
    }

    @Override
    protected void initComponent() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        adapter = new FragmentListAdapter(getActivity(), R.layout.list_item_main, new ArrayList<MainListClass>());
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
        if (v instanceof FloatingActionButton) {
//            getActMain().showFragment(new FragmentWithFabCreateTask(), true);
        }
    }
}
