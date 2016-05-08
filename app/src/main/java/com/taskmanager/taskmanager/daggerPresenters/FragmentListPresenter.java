package com.taskmanager.taskmanager.daggerPresenters;


import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.taskmanager.taskmanager.R;

import javax.inject.Inject;

public class FragmentListPresenter {
    private Fragment fragment;

    @Inject
    public FragmentListPresenter() {
    }

    public void addView(Fragment fragment) {
        this.fragment = fragment;
    }

    public SwipeMenuCreator crateMenuCreator(final int width) {
        return new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem itemDone = new SwipeMenuItem(fragment.getActivity());
                ColorDrawable backgroundColorRed = new ColorDrawable(Color.rgb(255, 0 , 0));
                itemDone.setBackground(backgroundColorRed);
                itemDone.setIcon(R.drawable.ic_vector_done_white_48px);
                itemDone.setWidth(width / 5);

                SwipeMenuItem itemCancel = new SwipeMenuItem(fragment.getActivity());
                itemCancel.setBackground(backgroundColorRed);
                itemCancel.setIcon(R.drawable.ic_vector_cancel_white_48dp);
                itemCancel.setWidth(width / 5);

                SwipeMenuItem itemDelete = new SwipeMenuItem(fragment.getActivity());
                itemDelete.setBackground(backgroundColorRed);
                itemDelete.setIcon(R.drawable.ic_vector_delete_forever_white_48px);
                itemDelete.setWidth(width / 5);

                SwipeMenuItem itemShare = new SwipeMenuItem(fragment.getActivity());
                itemShare.setBackground(backgroundColorRed);
                itemShare.setIcon(R.drawable.ic_vector_share_white_48px);
                itemShare.setWidth(width / 5);

                menu.addMenuItem(itemDone);
                menu.addMenuItem(itemCancel);
                menu.addMenuItem(itemDelete);
                menu.addMenuItem(itemShare);
            }
        };
    }

    public SwipeMenuListView initListView(SwipeMenuListView listView) {
        final int width = listView.getWidth();
        listView.setMenuCreator(crateMenuCreator(width));
        listView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                Toast.makeText(fragment.getActivity(), "menu " + menu.getMenuItem(index), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return listView;
    }
}
