package com.taskmanager.taskmanager.actClasses;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.fragment.FragmentWithFabList;
import com.taskmanager.taskmanager.view.FloatingActionButton;

public class ActMain extends AppCompatActivity {
    private FloatingActionButton fabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_layout);
        fabButton = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_vector_add_black_48px))
                .withButtonColor(Color.parseColor("#92A537"))
                .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
                .withMargins(0, 0, 16, 36)
                .create();

        if (savedInstanceState == null) {
            showFragment(new FragmentWithFabList(), FragmentWithFabList.class.toString());
        }
    }

    public void showFragment(Fragment frg, String tag) {
        getFragmentManager().beginTransaction()
                .replace(R.id.act_main_container, frg).addToBackStack(tag).commit();
    }

    public FloatingActionButton getFabButton() {
        return fabButton;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = this.getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
