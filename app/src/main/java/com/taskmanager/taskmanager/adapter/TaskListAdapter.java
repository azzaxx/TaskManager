package com.taskmanager.taskmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.notUI.TaskHolder;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<TaskHolder> {
    private ArrayList<TaskHolder> myList;

    public TaskListAdapter(Context context, int resource, ArrayList<TaskHolder> myList) {
        super(context, resource, myList);
        this.myList = myList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_main, null);
        }
        Handler handler = new Handler();
        handler.tvTime = (TextView) convertView.findViewById(R.id.list_item_main_time_text_view);
        handler.tvAddress = (TextView) convertView.findViewById(R.id.list_item_main_address_text_view);
        handler.tvDate = (TextView) convertView.findViewById(R.id.list_item_main_date_text_view);
        handler.tvLargeText = (TextView) convertView.findViewById(R.id.list_item_main_large_text);
        handler.tvSmallText = (TextView) convertView.findViewById(R.id.list_item_main_small_text);

        handler.tvLargeText.setText(myList.get(position).largeText);
        handler.tvSmallText.setText(myList.get(position).smallText);
        handler.tvTime.setText(myList.get(position).timeText);
        handler.tvAddress.setText(myList.get(position).addressText);
        handler.tvDate.setText(myList.get(position).dateText);

        return convertView;
    }

    public class Handler {
        public TextView tvTime, tvAddress, tvDate, tvLargeText, tvSmallText;
    }
}
