package com.dev.healthylifestyle.ui.patient.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityHeartDieasesRiskCalculatorBinding;
import com.dev.healthylifestyle.ui.patient.adapters.HeartDieasesCalculatorAdapter;
import com.dev.healthylifestyle.utility.BasicFunctions;

public class HeartDieasesRiskCalculatorActivity extends AppCompatActivity {
    private ActivityHeartDieasesRiskCalculatorBinding binding;
    private HeartDieasesCalculatorAdapter adapter;
    private String[] valueHeartDieases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_heart_dieases_risk_calculator);
        setToolBar(getResources().getString(R.string.actv_hdrc));
        getViewModel();
    }

    private void getViewModel() {
        valueHeartDieases = getResources().getStringArray(R.array.heart_disease_value);
        adapter = new HeartDieasesCalculatorAdapter(valueHeartDieases);
        binding.recylerView.setAdapter(adapter);
        binding.recylerView.setLayoutManager(BasicFunctions.getLinearLayoutManager(HeartDieasesRiskCalculatorActivity.this));

        /**
         * Set spinner
         */
        setSpinner();

        /**
         * operation with seekbar for bad cholesterol
         */
        binding.acsbBadCholesterol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("bad", "" + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * operation with seekbar for good cholesterol
         */
        binding.acsbGoodCholesterol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("good", "" + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * operation with seekbar for total cholesterol
         */
        binding.acsbTotalCholesterol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    /**
     * This is the function is used to set the spinner in the activity
     */
    private void setSpinner() {
        /**
         * This is for setting the age
         */
        binding.acsAgeSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.age)));

        /**
         * This is for setting the smoke
         */
        binding.acsSmokeSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.smoke)));

        /**
         * This is for setting the exercise
         */
        binding.acsExerciseSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.yes_no)));

        /**
         * This is for setting the blood pressure
         */
        binding.acsBloodSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.Blood_Pressure)));

        /**
         * This is for setting the diabetes pressure
         */
        binding.acsDiabetesSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.Diabetes)));
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
