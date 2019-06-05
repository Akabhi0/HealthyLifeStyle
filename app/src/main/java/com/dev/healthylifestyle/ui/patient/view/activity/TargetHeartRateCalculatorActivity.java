package com.dev.healthylifestyle.ui.patient.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityTargetHeartRateCalculatorBinding;

public class TargetHeartRateCalculatorActivity extends AppCompatActivity {
    private ActivityTargetHeartRateCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_target_heart_rate_calculator);
        setToolBar(getResources().getString(R.string.actv_thre));
    }

    /**
     * This is for setting the toolbar
     *
     * @param title
     */
    private void setToolBar(String title) {
        binding.toolbar.setTitle(title);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
