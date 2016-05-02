package com.taskmanager.taskmanager;


import android.content.Context;

import com.taskmanager.taskmanager.notUI.MainListClass;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;

@Module
public class Model {
    private static Context context;
    private static Model model;
    public ArrayList<MainListClass> list = MainListClass.getArrayOfMainClass();

    public Model(Context context) {
        this.context = context;
        model = this;
    }

    public static Model newInstance(Context context) {
        if (getModel() == null) {
            return new Model(context);
        }
        return model;
    }
    public static Model newInstance() {
        if (getModel() == null) {
            return new Model(context);
        }
        return model;
    }

    public static Model getModel() {
        return model;
    }
}
