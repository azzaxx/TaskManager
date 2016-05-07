package com.taskmanager.taskmanager.notUI;

import java.util.ArrayList;

public class TaskHolder {
    public String largeText;
    public String smallText;
    public String dateText;
    public String timeText;
    public String addressText;
    public static ArrayList<TaskHolder> list;

    public TaskHolder() {
    }

    public TaskHolder(String largeText, String smallText, String dateText,
                      String timeText, String addressText) {
        this.largeText = largeText;
        this.smallText = smallText;
        this.dateText = dateText;
        this.addressText = addressText;
        this.timeText = timeText;
    }

    public TaskHolder getMainClass() {
        return new TaskHolder(largeText, smallText, dateText, timeText, addressText);
    }

    public ArrayList<TaskHolder> getArrayOfTasks() {
        if (list == null)
            list = new ArrayList<>();
        return list;
    }
}
