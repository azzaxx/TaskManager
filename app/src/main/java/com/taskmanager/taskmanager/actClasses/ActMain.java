package com.taskmanager.taskmanager.actClasses;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.taskmanager.taskmanager.ActMainModel;
import com.taskmanager.taskmanager.ActMainPresenter;
import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.fragment.FragmentWithFabList;
import com.taskmanager.taskmanager.interfacePackage.DaggerModelComponent;
import com.taskmanager.taskmanager.interfacePackage.ModelComponent;
import com.taskmanager.taskmanager.view.FloatingActionButton;

import javax.inject.Inject;

public class ActMain extends AppCompatActivity {
    private FloatingActionButton fabButton;
    private ModelComponent mComponent;
    @Inject
    ActMainPresenter mActMainPresenter;

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

        initComponent();
        mComponent.inject(this);
        mActMainPresenter.bindView(this);
        if (savedInstanceState == null) {
            mActMainPresenter.showFragment(new FragmentWithFabList(), false);
        }
    }

    protected void initComponent() {
        mComponent = DaggerModelComponent.builder()
                .model(new ActMainModel())
                .build();
    }

    public FloatingActionButton getFabButton() {
        return fabButton;
    }

    @Override
    public void onBackPressed() {
        if (mActMainPresenter.popBackStack())
            super.onBackPressed();
    }
}
