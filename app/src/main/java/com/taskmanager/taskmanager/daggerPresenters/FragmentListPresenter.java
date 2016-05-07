package com.taskmanager.taskmanager.daggerPresenters;


import android.app.Fragment;

import javax.inject.Inject;

public class FragmentListPresenter {
    private Fragment fragment;

    @Inject
    public FragmentListPresenter() {
    }

    public void addView(Fragment fragment) {
        this.fragment = fragment;
    }
}
