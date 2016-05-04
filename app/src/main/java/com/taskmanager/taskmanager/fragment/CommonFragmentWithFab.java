package com.taskmanager.taskmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taskmanager.taskmanager.actClasses.ActMain;
import com.taskmanager.taskmanager.view.FloatingActionButton;

public abstract class CommonFragmentWithFab extends Fragment {
    protected FloatingActionButton fabButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fabButton = ((ActMain)getActivity()).getFabButton();
        initComponent();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void initComponent();

    public ActMain getActMain() {
        return (ActMain) getActivity();
    }
}
