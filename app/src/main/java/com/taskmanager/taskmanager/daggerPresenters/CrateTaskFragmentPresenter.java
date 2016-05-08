package com.taskmanager.taskmanager.daggerPresenters;


import android.app.Fragment;

import com.taskmanager.taskmanager.notUI.TaskHolder;

import java.util.Calendar;

public class CrateTaskFragmentPresenter {
    private Fragment fragment;

    public void addView(Fragment fragment) {
        this.fragment = fragment;
    }

    public TaskHolder addListItem(String headerText, String descriptionText) {
        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.SECOND);
        int minuts = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        int day = c.get(Calendar.DATE);
        return new TaskHolder(headerText.isEmpty() ? "Task without header" : headerText,
                descriptionText.isEmpty() ? "Task without description" : descriptionText,
                "" + day,
                hour + ":" + minuts + ":" + seconds + "AM",
                "fffff");
    }
}
