package com.dev.healthylifestyle.ui.common.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityLoginBinding;
import com.dev.healthylifestyle.ui.common.fragments.RegistrationTypeFragment;
import com.dev.healthylifestyle.utility.FragmentHelper;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        activityLoginBinding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrationTypeFragment registrationTypeFragment = new RegistrationTypeFragment();
                FragmentHelper.getInstance().showRoleSelectionDialogFragment(registrationTypeFragment, getSupportFragmentManager(), "dialog");
            }
        });
    }
}
