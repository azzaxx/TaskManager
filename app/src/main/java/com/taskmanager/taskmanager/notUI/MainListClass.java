package com.taskmanager.taskmanager.notUI;

import java.util.ArrayList;
import java.util.Calendar;

public class MainListClass {
    public String largeText;
    public String smallText;
    public String dateText;
    public String timeText;
    public String addressText;

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
        ArrayList<MainListClass> list = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.SECOND);
        int minuts = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        int day = c.get(Calendar.DATE);
        list.add(new MainListClass("some first large Text",
                "some small first text",
                "" + day,
                hour + ":" + minuts + ":" + seconds + "AM",
                "fffff"));
        list.add(new MainListClass("some second large Text",
                "some small second text",
                "" + day,
                hour + ":" + minuts + ":" + seconds + "AM",
                "fffff"));
        list.add(new MainListClass("aaasdasd ast",
                "soms dasd s ext",
                "" + day,
                hour + ":" + minuts + ":" + seconds + "AM",
                "fffff"));
        return list;
    }
}
