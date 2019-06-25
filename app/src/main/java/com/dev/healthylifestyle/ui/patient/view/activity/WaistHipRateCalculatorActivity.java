package com.dev.healthylifestyle.ui.patient.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityWaistHipRateCalculatorBinding;
import com.dev.healthylifestyle.ui.patient.viewModel.WaistHipRateCalculatorViewModel;
import com.dev.healthylifestyle.utility.BasicFunctions;
import com.dev.healthylifestyle.utility.Constants;
import com.github.anastr.speedviewlib.util.OnPrintTickLabel;

import java.util.ArrayList;
import java.util.Locale;

public class WaistHipRateCalculatorActivity extends AppCompatActivity {

    private ActivityWaistHipRateCalculatorBinding binding;
    private WaistHipRateCalculatorViewModel viewModel;

    private ArrayList<Integer> fixedDivision = new ArrayList<>();
    private ArrayList<Integer> fixedDivisionTwo = new ArrayList<>();
    private ArrayList<Integer> fixedDivisionThree = new ArrayList<>();

    private ArrayList<Double> createDivision = new ArrayList<>();
    private ArrayList<Double> createDivisionTwo = new ArrayList<>();
    private ArrayList<Double> createDivisionThree = new ArrayList<>();

    private int MIN_VALUE = 5, index = 0;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_waist_hip_rate_calculator);
        binding.setTotalRatio("0.00");
        Constants.GENDER = "Male";

        setToolBar(getResources().getString(R.string.actv_whrc));
        getViewModel();
    }

    private void getViewModel() {
        viewModel = ViewModelProviders.of(this).get(WaistHipRateCalculatorViewModel.class);
        binding.setViewModel(viewModel);

        binding.speedometer.setOnPrintTickLabel(new OnPrintTickLabel() {
            @Override
            public CharSequence getTickLabel(int tickPosition, float tick) {
                if (tickPosition == 0)
                    return String.format(Locale.getDefault(), "Lower", 0);
                else if (tickPosition == 1)
                    return String.format(Locale.getDefault(), "0.95", 0);
                else if (tickPosition == 2)
                    return String.format(Locale.getDefault(), "1.0", 0);
                else if (tickPosition == 3)
                    return String.format(Locale.getDefault(), "Heigher", 0);
                return null;
            }
        });

        viewModel.getOnClickedFemale().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Constants.GENDER = "Female";
                    getValuesBasedOnSeekBar();
                }
            }
        });

        viewModel.getOnClickedMale().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Constants.GENDER = "Male";
                    getValuesBasedOnSeekBar();
                }
            }
        });


        binding.acsbWaist.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= MIN_VALUE) {
                    seekBar.setProgress(5);
                    binding.setWaistValue(String.valueOf(5));
                } else {
                    getValuesBasedOnSeekBar();
                    binding.setWaistValue(String.valueOf(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        /**
//         * This is the controls for seek bar for hips value
//         */
        binding.acsbHip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= MIN_VALUE) {
                    seekBar.setProgress(5);
                    binding.setHipValue(String.valueOf(5));
                } else {
                    getValuesBasedOnSeekBar();
                    binding.setHipValue(String.valueOf(progress));
                }
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

    private void getValuesBasedOnSeekBar() {
        if (Constants.GENDER.equals("Male")) {
            if (binding.acsbWaist.getProgress() == 0.0) {
                waistHipRatioResult(5.0, binding.acsbHip.getProgress(), 0.95, 1.0, "Male");
            } else if (binding.acsbHip.getProgress() == 0.0) {
                waistHipRatioResult(binding.acsbWaist.getProgress(), 5.0, 0.95, 1.0, "Male");
            } else {
                waistHipRatioResult(binding.acsbWaist.getProgress(), binding.acsbHip.getProgress(), 0.95, 1.0, "Male");
            }
        } else {
            if (binding.acsbHip.getProgress() == 0.0) {
                waistHipRatioResult(binding.acsbWaist.getProgress(), 5.0, 0.8, 0.85, "Female");
            } else if (binding.acsbWaist.getProgress() == 0.0) {
                waistHipRatioResult(5.0, binding.acsbHip.getProgress(), 0.8, 0.85, "Female");
            } else {
                waistHipRatioResult(binding.acsbWaist.getProgress(), binding.acsbHip.getProgress(), 0.80, 0.85, "Female");
            }
        }
    }

    private void waistHipRatioResult(double upperSeekBar, double lowerSeekBar, double limitOne, double limitTwo, String gender) {
        Constants.RESULT = (float) (upperSeekBar / lowerSeekBar);
        double roundOff = Math.round(Constants.RESULT * 100.0) / 100.0;
        binding.setTotalRatio(String.valueOf(roundOff));

        if (gender.equals("Female")) {
            fixedDivision.clear();
            fixedDivisionTwo.clear();
            fixedDivisionThree.clear();


            createDivision.clear();
            createDivisionTwo.clear();
            createDivisionThree.clear();

            double value = 0.05, valueTwo = 0.81, valueThree = 0.851;

            for (int i = 0; i <= 33; i++) {
                fixedDivision.add(i, i);
                createDivision.add(i, value);
                value = value + 0.022;
            }

            int second = 34;
            for (int i = 0; i < 33; i++) {
                fixedDivisionTwo.add(i, second);
                createDivisionTwo.add(i, valueTwo);
                valueTwo = valueTwo + 0.00095;
                second++;
            }

            int three = 67;
            for (int i = 0; i < 33; i++) {
                fixedDivisionThree.add(i, three);
                createDivisionThree.add(i, valueThree);
                valueThree = valueThree + 0.58;
                three++;
            }

            waistHipRatioCalculator(Constants.RESULT, limitOne, limitTwo, "Female");

        } else {
            fixedDivision.clear();
            fixedDivisionTwo.clear();
            fixedDivisionThree.clear();


            createDivision.clear();
            createDivisionTwo.clear();
            createDivisionThree.clear();
            double value = 0.05, valueTwo = 0.96, valueThree = 1.01;

            for (int i = 0; i <= 33; i++) {
                fixedDivision.add(i, i);
                createDivision.add(i, value);
                value = value + 0.0270;
            }

            int second = 34;
            for (int i = 0; i < 33; i++) {
                fixedDivisionTwo.add(i, second);
                createDivisionTwo.add(i, valueTwo);
                valueTwo = valueTwo + 0.0009;
                second++;
            }

            int three = 67;
            for (int i = 0; i < 33; i++) {
                fixedDivisionThree.add(i, three);
                createDivisionThree.add(i, valueThree);
                valueThree = valueThree + 0.60;
                three++;
            }

            waistHipRatioCalculator(Constants.RESULT, limitOne, limitTwo, "Male");
        }

    }

    private void waistHipRatioCalculator(double roundOff, final double limitOne, final double limitTwo, String Gender) {

        binding.speedometer.setOnPrintTickLabel(new OnPrintTickLabel() {
            @Override
            public CharSequence getTickLabel(int tickPosition, float tick) {
                if (tickPosition == 0)
                    return String.format(Locale.getDefault(), "Lower", 0);
                else if (tickPosition == 1)
                    return String.format(Locale.getDefault(), String.valueOf(limitOne), 0);
                else if (tickPosition == 2)
                    return String.format(Locale.getDefault(), String.valueOf(limitTwo), 0);
                else if (tickPosition == 3)
                    return String.format(Locale.getDefault(), "Heigher", 0);
                return null;
            }
        });

        double roundOffValue = Math.floor(roundOff * 100) / 100;

        /**
         * This is the code for the 1st half of the calculator
         */
        if (roundOffValue >= 0.05 || (roundOffValue <= limitOne)) {
            index = BasicFunctions.returnIndex(roundOffValue, createDivision);
            if (index >= 0) {
                if ((roundOffValue > 1) && Gender.equals("Male")) {
                    binding.speedometer.speedTo(67);
                } else if ((roundOffValue > .85) && Gender.equals("Female")) {
                    binding.speedometer.speedTo(67);
                } else {
                    binding.actvSpeedMeterText.setTextColor(getResources().getColor(R.color.blue));
                    binding.actvSpeedMeter.setTextColor(getResources().getColor(R.color.blue));
                    binding.actvSpeedMeterText.setText(getResources().getString(R.string.lowhealthrisk));
                    binding.speedometer.speedTo(fixedDivision.get(index));
                }
            }
        }

        /**
         * This is the code for the 2nd half of the calculator
         */
        if ((roundOffValue > limitOne) || (roundOffValue <= limitTwo)) {
            index = BasicFunctions.returnIndex(roundOffValue, createDivisionTwo);
            if (index >= 0) {
                if (roundOffValue > 1 && Gender.equals("Male")) {
                    binding.actvSpeedMeterText.setTextColor(getResources().getColor(R.color.red));
                    binding.actvSpeedMeter.setTextColor(getResources().getColor(R.color.red));
                    binding.actvSpeedMeterText.setText(getResources().getString(R.string.highrisk));
                } else if (roundOffValue > 0.85 && Gender.equals("Female")) {
                    binding.actvSpeedMeterText.setTextColor(getResources().getColor(R.color.red));
                    binding.actvSpeedMeter.setTextColor(getResources().getColor(R.color.red));
                    binding.actvSpeedMeterText.setText(getResources().getString(R.string.highrisk));
                } else {
                    binding.actvSpeedMeterText.setTextColor(getResources().getColor(R.color.green));
                    binding.actvSpeedMeter.setTextColor(getResources().getColor(R.color.green));
                    binding.actvSpeedMeterText.setText(getResources().getString(R.string.moderate));
                    binding.speedometer.speedTo(fixedDivisionTwo.get(index));
                }
            }
        }

        /**
         * This is the code for the 3rd half of the calculator
         */
        if ((roundOffValue > limitTwo) || (roundOffValue <= 20)) {
            index = BasicFunctions.returnIndex(roundOffValue, createDivisionThree);
            if (index >= 0) {
                binding.actvSpeedMeterText.setTextColor(getResources().getColor(R.color.red));
                binding.actvSpeedMeter.setTextColor(getResources().getColor(R.color.red));
                binding.actvSpeedMeterText.setText(getResources().getString(R.string.highrisk));
                binding.speedometer.speedTo(fixedDivisionThree.get(index));
            }
        }

    }
}
