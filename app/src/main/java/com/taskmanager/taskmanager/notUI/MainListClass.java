package com.taskmanager.taskmanager.notUI;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

public class MainListClass {
    public String largeText;
    public String smallText;
    public String dateText;
    public String timeText;
    public String addressText;
    public static ArrayList<MainListClass> list;

    public MainListClass() {
    }

    public MainListClass(String largeText, String smallText, String dateText,
                         String timeText, String addressText) {
        this.largeText = largeText;
        this.smallText = smallText;
        this.dateText = dateText;
        this.addressText = addressText;
        this.timeText = timeText;
    }

    public MainListClass getMainClass() {
        return new MainListClass(largeText, smallText, dateText, timeText, addressText);
    }

    public static ArrayList<MainListClass> getArrayOfMainClass() {
        if (list == null)
            list = new ArrayList<>();
        return list;
    }
}
