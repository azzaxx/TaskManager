package com.taskmanager.taskmanager;

import android.app.Fragment;
import android.app.FragmentManager;

import com.taskmanager.taskmanager.actClasses.ActMain;

import javax.inject.Inject;

public class ActMainPresenter {
    private ActMain actMain;
    @Inject
    public ActMainPresenter() {

    }

    public void bindView(ActMain actMain) {
        this.actMain = actMain;
    }

    public void showFragment(Fragment frg, boolean addToBackStack) {
        FragmentManager fm = actMain.getFragmentManager();
        if (addToBackStack)
            fm.beginTransaction().replace(R.id.act_main_container, frg, frg.getTag())
                    .addToBackStack(frg.getTag()).commit();
        else
            fm.beginTransaction().replace(R.id.act_main_container, frg, frg.getTag()).commit();
    }

    public void removeFragment(String tag) {
        actMain.getFragmentManager().beginTransaction()
                .remove(actMain.getFragmentManager().findFragmentByTag(tag)).commit();
    }

    public boolean popBackStack() {
        FragmentManager fm = actMain.getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            return false;
        }
        return true;
    }
}
