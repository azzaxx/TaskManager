package com.taskmanager.taskmanager.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.taskmanager.taskmanager.daggerModels.ActMainModel;
import com.taskmanager.taskmanager.fragment.FragmentTaskList;
import com.taskmanager.taskmanager.daggerPresenters.ActMainPresenter;
import com.taskmanager.taskmanager.R;
import com.taskmanager.taskmanager.daggerComponents.DaggerModelComponent;
import com.taskmanager.taskmanager.daggerComponents.ModelComponent;
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

        initComponent().inject(this);
        mActMainPresenter.bindView(this);
        if (savedInstanceState == null) {
            mActMainPresenter.showFragment(new FragmentTaskList(), false);
        }
    }

    protected ModelComponent initComponent() {
        return mComponent = DaggerModelComponent.builder()
                .actMainModel(new ActMainModel())
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

    public ActMainPresenter getActMainPresenter() {
        return mActMainPresenter;
    }
}
