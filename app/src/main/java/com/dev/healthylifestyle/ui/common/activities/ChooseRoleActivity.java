package com.dev.healthylifestyle.ui.common.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityChooseRoleBinding;

public class ChooseRoleActivity extends AppCompatActivity {
    ActivityChooseRoleBinding activityChooseRoleBinding;
    boolean isButtonPanelVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityChooseRoleBinding = DataBindingUtil.setContentView(this, R.layout.activity_choose_role);


        activityChooseRoleBinding.loginText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseRoleActivity.this,LoginActivity.class));
            }
        });




        activityChooseRoleBinding.roleSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isButtonPanelVisible) {
                    // activityRoleSelectBinding.roleSelect.setVisibility(View.VISIBLE);
                    activityChooseRoleBinding.buttonPanel.setVisibility(View.VISIBLE);
                    //activityRoleSelectBinding.loginText.setVisibility(View.VISIBLE);
                    ObjectAnimator buttonPanelAnimator = ObjectAnimator.ofPropertyValuesHolder(activityChooseRoleBinding.buttonPanel, PropertyValuesHolder.ofFloat("translationY", activityChooseRoleBinding.buttonPanel.getHeight(), 0), PropertyValuesHolder.ofFloat("rotationX", 90, 0)).setDuration(800);
                    ObjectAnimator loginTextAnimator = ObjectAnimator.ofPropertyValuesHolder(activityChooseRoleBinding.loginText, PropertyValuesHolder.ofFloat("translationY", activityChooseRoleBinding.loginText.getHeight() + activityChooseRoleBinding.buttonPanel.getHeight(), 0), PropertyValuesHolder.ofFloat("rotationX", -90, 0)).setDuration(800);
                    buttonPanelAnimator.start();
                    loginTextAnimator.start();
                    ObjectAnimator registerButtonAnimator = ObjectAnimator.ofFloat(activityChooseRoleBinding.roleSelect, "translationY", 0, -(activityChooseRoleBinding.buttonPanel.getHeight())).setDuration(800);
                    registerButtonAnimator.start();

                } else {

                    ObjectAnimator buttonPanelAnimator = ObjectAnimator.ofPropertyValuesHolder(activityChooseRoleBinding.buttonPanel, PropertyValuesHolder.ofFloat("translationY", 0, activityChooseRoleBinding.buttonPanel.getHeight()), PropertyValuesHolder.ofFloat("rotationX", 0, 90)).setDuration(800);
                    ObjectAnimator loginTextAnimator = ObjectAnimator.ofPropertyValuesHolder(activityChooseRoleBinding.loginText, PropertyValuesHolder.ofFloat("translationY", 0, activityChooseRoleBinding.loginText.getHeight() + activityChooseRoleBinding.buttonPanel.getHeight()), PropertyValuesHolder.ofFloat("rotationX", 0, -90)).setDuration(800);
                    buttonPanelAnimator.start();
                    loginTextAnimator.start();
                    ObjectAnimator registerButtonAnimator = ObjectAnimator.ofFloat(activityChooseRoleBinding.roleSelect, "translationY", -(activityChooseRoleBinding.buttonPanel.getHeight()), 0).setDuration(800);
                    registerButtonAnimator.start();

                }

                isButtonPanelVisible = !isButtonPanelVisible;
            }
        });


        activityChooseRoleBinding.loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator buttonPanelAnimator = ObjectAnimator.ofPropertyValuesHolder(activityChooseRoleBinding.buttonPanel, PropertyValuesHolder.ofFloat("translationY", 0, activityChooseRoleBinding.buttonPanel.getHeight()), PropertyValuesHolder.ofFloat("rotationX", 0, 90)).setDuration(800);
                ObjectAnimator loginTextAnimator = ObjectAnimator.ofPropertyValuesHolder(activityChooseRoleBinding.loginText, PropertyValuesHolder.ofFloat("translationY", 0, activityChooseRoleBinding.loginText.getHeight() + activityChooseRoleBinding.buttonPanel.getHeight()), PropertyValuesHolder.ofFloat("rotationX", 0, -90)).setDuration(800);
                buttonPanelAnimator.start();
                loginTextAnimator.start();
                ObjectAnimator registerButtonAnimator = ObjectAnimator.ofFloat(activityChooseRoleBinding.roleSelect, "translationY", -(activityChooseRoleBinding.buttonPanel.getHeight() + activityChooseRoleBinding.loginText.getHeight()), 0).setDuration(800);
                registerButtonAnimator.start();

                activityChooseRoleBinding.roleSelect.setVisibility(View.VISIBLE);
                isButtonPanelVisible = false;
            }
        });
    }
}
