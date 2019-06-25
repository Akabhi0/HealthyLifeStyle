package com.dev.healthylifestyle.ui.patient.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityTargetHeartRateCalculatorBinding;

import java.util.ArrayList;

public class TargetHeartRateCalculatorActivity extends AppCompatActivity {
    private ActivityTargetHeartRateCalculatorBinding binding;

    private ArrayList<Integer> fixedDivision = new ArrayList<>();
    private ArrayList<Integer> fixedDivisionTwo = new ArrayList<>();
    private ArrayList<Integer> fixedDivisionThree = new ArrayList<>();

    private ArrayList<Double> createDivision = new ArrayList<>();
    private ArrayList<Double> createDivisionTwo = new ArrayList<>();
    private ArrayList<Double> createDivisionThree = new ArrayList<>();

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
