package com.dev.healthylifestyle.ui.patient.view.activity;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityCaloriesCalculatorBinding;
import com.dev.healthylifestyle.ui.patient.viewModel.CaloriesCalculatorViewModel;
import com.dev.healthylifestyle.utility.Constants;
import com.github.anastr.speedviewlib.util.OnPrintTickLabel;

import java.util.ArrayList;
import java.util.Locale;

public class CaloriesCalculatorActivity extends AppCompatActivity {

    private ActivityCaloriesCalculatorBinding binding;
    private CaloriesCalculatorViewModel viewModel;

    private ArrayList<Integer> fixedDivision = new ArrayList<>();
    private ArrayList<Integer> fixedDivisionTwo = new ArrayList<>();
    private ArrayList<Integer> fixedDivisionThree = new ArrayList<>();

    private ArrayList<Double> createDivision = new ArrayList<>();
    private ArrayList<Double> createDivisionTwo = new ArrayList<>();
    private ArrayList<Double> createDivisionThree = new ArrayList<>();
    int minAge = 1, maxAge = 100, currentAge = 99, minHeight = 20, maxHeight = 270, currentHeight = 250,
            minWeight = 5, maxWeight = 200, currentWeight = 195;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calories_calculator);
        setToolBar(getResources().getString(R.string.actv_cc));
        getViewModel();
    }

    private void getViewModel() {
        viewModel = ViewModelProviders.of(this).get(CaloriesCalculatorViewModel.class);
        binding.setViewModel(viewModel);

        binding.speedometer.setOnPrintTickLabel(new OnPrintTickLabel() {
            @Override
            public CharSequence getTickLabel(int tickPosition, float tick) {
                if (tickPosition == 0)
                    return String.format(Locale.getDefault(), "lower", 0);
                else if (tickPosition == 1)
                    return String.format(Locale.getDefault(), "1000", 0);
                else if (tickPosition == 2)
                    return String.format(Locale.getDefault(), "2000", 0);
                else if (tickPosition == 3)
                    return String.format(Locale.getDefault(), "higher", 0);
                return null;
            }
        });

        viewModel.getOnClickedFemale().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Constants.GENDER = "Female";
                    // getValuesBasedOnSeekBar();
                }
            }
        });

        viewModel.getOnClickedMale().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Constants.GENDER = "Male";
                    // getValuesBasedOnSeekBar();
                }
            }
        });


        /**
         * This is for the age value form seek bar
         */
        binding.acsbAge.setMax(maxAge - minAge);
        binding.acsbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentAge = progress + minAge;
                binding.setAge(String.valueOf(currentAge));
                getValuesBasedOnSeekBar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        /**
//         * This is the controls for seek bar for height value
//         */
        binding.acsbHeight.setMax(maxHeight - minHeight);
        binding.acsbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentHeight = progress + minHeight;
                binding.setHeight(String.valueOf(currentHeight));
                getValuesBasedOnSeekBar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * This is for the change in the weight of the seek bar
         */
        binding.acsbWeight.setMax(maxWeight - minWeight);
        binding.acsbWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentWeight = progress + minWeight;
                binding.setWeight(String.valueOf(currentWeight));
                getValuesBasedOnSeekBar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void getValuesBasedOnSeekBar() {
//        if (Constants.GENDER.equals("Male")) {
//            if (binding.acsbWaist.getProgress() == 0.0) {
//                waistHipRatioResult(5.0, binding.acsbHip.getProgress(), 0.95, 1.0, "Male");
//            } else if (binding.acsbHip.getProgress() == 0.0) {
//                waistHipRatioResult(binding.acsbWaist.getProgress(), 5.0, 0.95, 1.0, "Male");
//            } else {
//                waistHipRatioResult(binding.acsbWaist.getProgress(), binding.acsbHip.getProgress(), 0.95, 1.0, "Male");
//            }
//        } else {
//            if (binding.acsbHip.getProgress() == 0.0) {
//                waistHipRatioResult(binding.acsbWaist.getProgress(), 5.0, 0.8, 0.85, "Female");
//            } else if (binding.acsbWaist.getProgress() == 0.0) {
//                waistHipRatioResult(5.0, binding.acsbHip.getProgress(), 0.8, 0.85, "Female");
//            } else {
//                waistHipRatioResult(binding.acsbWaist.getProgress(), binding.acsbHip.getProgress(), 0.80, 0.85, "Female");
//            }
//        }
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
