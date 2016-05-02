package com.taskmanager.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taskmanager.taskmanager.R;

public class FragmentWithFabCreateTask extends CommonFragmentWithFab implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_create_task, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

    }
}
