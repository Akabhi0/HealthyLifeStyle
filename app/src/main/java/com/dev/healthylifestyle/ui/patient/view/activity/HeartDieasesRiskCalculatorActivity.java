package com.dev.healthylifestyle.ui.patient.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityHeartDieasesRiskCalculatorBinding;
import com.dev.healthylifestyle.ui.patient.adapters.HeartDieasesCalculatorAdapter;
import com.dev.healthylifestyle.ui.patient.viewModel.HeartDieasesRiskCalculatorViewModel;
import com.dev.healthylifestyle.utility.BasicFunctions;
import com.dev.healthylifestyle.utility.Constants;
import com.dev.healthylifestyle.utility.PreferenceHelper;

public class HeartDieasesRiskCalculatorActivity extends AppCompatActivity {

    private ActivityHeartDieasesRiskCalculatorBinding binding;
    private HeartDieasesCalculatorAdapter adapter;
    private String[] valueHeartDieases;
    private int ageValue, smokeValue, exerciseValue, bloodValue, diabtiesValue, totalColestrolValue, goodColestrolValue, badColestrolValue;
    private String genderValue = "Male", ageSting, smokeString, exerciseString, bloodString, diabetesString;
    private HeartDieasesRiskCalculatorViewModel viewModel;
    private int totalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_heart_dieases_risk_calculator);
        setToolBar(getResources().getString(R.string.actv_hdrc));
        getViewModel();
    }

    private void getViewModel() {

        valueHeartDieases = getResources().getStringArray(R.array.heart_disease_value);
        adapter = new HeartDieasesCalculatorAdapter(valueHeartDieases, HeartDieasesRiskCalculatorActivity.this);
        binding.recylerView.setAdapter(adapter);
        PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
        binding.recylerView.setLayoutManager(BasicFunctions.getLinearLayoutManager(HeartDieasesRiskCalculatorActivity.this));

        viewModel = ViewModelProviders.of(this).get(HeartDieasesRiskCalculatorViewModel.class);
        binding.setViewModel(viewModel);


        /**
         * This is on clicked of the view Model
         */
        viewModel.getClickedMale().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    genderValue = "Male";
                    getFinalResult();
                }
            }
        });

        viewModel.getClickedFemale().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    genderValue = "Female";
                    getFinalResult();
                }
            }
        });


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
                binding.setBad(progress);
                getFinalResult();
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
                binding.setGood(progress);
                getFinalResult();
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
                binding.setTotal(progress);
                getFinalResult();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * This is for the last function calling
         */

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
        ageSting = binding.acsAgeSpinner.getSelectedItem().toString();
        binding.acsAgeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ageSting = binding.acsAgeSpinner.getItemAtPosition(position).toString();
                getFinalResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * This is for setting the smoke
         */
        binding.acsSmokeSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.smoke)));
        smokeString = binding.acsSmokeSpinner.getSelectedItem().toString();
        binding.acsSmokeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                smokeString = binding.acsSmokeSpinner.getItemAtPosition(position).toString();
                getFinalResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * This is for setting the exercise
         */
        binding.acsExerciseSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.yes_no)));
        exerciseString = binding.acsExerciseSpinner.getSelectedItem().toString();
        binding.acsExerciseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                exerciseString = binding.acsExerciseSpinner.getItemAtPosition(position).toString();
                getFinalResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * This is for setting the blood pressure
         */
        binding.acsBloodSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.Blood_Pressure)));
        bloodString = binding.acsBloodSpinner.getSelectedItem().toString();
        binding.acsBloodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bloodString = binding.acsBloodSpinner.getItemAtPosition(position).toString();
                getFinalResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * This is for setting the diabetes pressure
         */
        binding.acsDiabetesSpinner.setAdapter(BasicFunctions.getArrayAdapterSpinner(
                this, getResources().getStringArray(R.array.Diabetes)));
        diabetesString = binding.acsDiabetesSpinner.getSelectedItem().toString();
        binding.acsDiabetesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diabetesString = binding.acsDiabetesSpinner.getItemAtPosition(position).toString();
                getFinalResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * This is age function
     *
     * @param age
     */
    private void ageFunction(String age) {
        if (genderValue.equals("Male")) {
            ageValueFunction(age, -1, 4, 6, 7);
        } else {
            ageValueFunction(age, -9, -1, 5, 7);
        }
    }

    private void ageValueFunction(String age, int firstValue, int secondValue, int thirdValue, int fourthValue) {

        switch (age) {
            case "20 to 34":
                ageValue = firstValue;
                break;
            case "35 to 50":
                ageValue = secondValue;
                break;
            case "50 to 60":
                ageValue = thirdValue;
                break;
            case "65 to 80":
                ageValue = fourthValue;
                break;
        }

    }

    private void smokeValueFunction(String smoke) {
        if (smoke.equals("Yes")) {
            smokeValue = 2;
        } else {
            smokeValue = 0;
        }
    }

    private void exerciseValueFunction(String exercise) {
        if (exercise.equals("Yes")) {
            exerciseValue = -1;
        } else if (exercise.equals("Sometimes")) {
            exerciseValue = 0;
        } else {
            exerciseValue = 1;
        }
    }

    private void bloodPressureValue(String blood) {
        switch (blood) {
            case "less than 120/80":
                bloodValue = -3;
                break;
            case "120/80 to 139/89":
                bloodValue = 0;
                break;
            case "less then 139/85":
                bloodValue = 0;
                break;
            case "130/85 to 139/89":
                bloodValue = 1;
                break;
            case "140/90 to 139/99":
                bloodValue = 2;
                break;
            case "More than on equal to 160/100":
                bloodValue = 3;
                break;
        }
    }

    private void diabetiesFunction(String diabites) {
        if (diabites.equals("Do not have diabetes"))
            diabtiesValue = 0;
        else if (diabites.equals("Have diabetes or take anti-diabetic drugs"))
            diabtiesValue = 1;
    }

    /**
     * This is the slider related function
     *
     * @param slidervalue
     */
    private void getTotalCholesterolValue(int slidervalue) {
        if (genderValue.equals("Male"))
            assigning_Total_CholesterolValues(slidervalue, 0, -1, 4, 5);
        else
            assigning_Total_CholesterolValues(slidervalue, 0, -3, 2, 3);
    }

    private void assigning_Total_CholesterolValues(int slidervalue, int firstValue, int secondValue, int thirdValue, int fourthValue) {
        if (slidervalue == 0) {
            totalColestrolValue = firstValue;
        } else if (slidervalue <= 200) {
            totalColestrolValue = secondValue;
        } else if ((slidervalue >= 200) && (slidervalue <= 239)) {
            totalColestrolValue = thirdValue;
        } else if (slidervalue >= 240) {
            totalColestrolValue = fourthValue;
        }
    }

    private void getGoodCholesterolValue(int slidervalue) {
        if (genderValue.equals("Male")) {
            assigning_Good_CholesterolValue(slidervalue, 0, 2, 1, 0, -1);
        } else {
            assigning_Good_CholesterolValue(slidervalue, 0, 5, 2, 1, -2);
        }
    }

    private void assigning_Good_CholesterolValue(int slidervalue, int firstValue, int secondValue, int thirdValue, int fourthValue, int fifthValue) {
        if (slidervalue == 0) {
            goodColestrolValue = firstValue;
        } else if (slidervalue <= 100) {
            goodColestrolValue = secondValue;
        } else if ((slidervalue >= 100) && (slidervalue <= 159)) {
            goodColestrolValue = thirdValue;
        } else if ((slidervalue >= 160) && (slidervalue <= 190)) {
            goodColestrolValue = fourthValue;
        } else if (slidervalue >= 190) {
            goodColestrolValue = fifthValue;
        }
    }

    private void getBadCholesterolValue(int slidervalue) {
        if (genderValue.equals("Male")) {
            assigning_Bad_CholesterolValues(slidervalue, 0, -3, 0, 1, 2);
        } else {
            assigning_Bad_CholesterolValues(slidervalue, 0, -2, 0, 1, 2);
        }
    }

    private void assigning_Bad_CholesterolValues(int slidervalue, int firstValue, int secondValue, int thirdValue, int fourthValue, int fifthValue) {
        if (slidervalue == 0) {
            badColestrolValue = firstValue;
        } else if (slidervalue <= 100) {
            badColestrolValue = secondValue;
        } else if ((slidervalue >= 100) && (slidervalue <= 159)) {
            badColestrolValue = thirdValue;
        } else if ((slidervalue >= 160) && (slidervalue <= 190)) {
            badColestrolValue = fourthValue;
        } else if (slidervalue >= 190) {
            badColestrolValue = fifthValue;
        }
    }

    private void getFinalValue_And_Risk_Type() {
        totalValue = ageValue + totalColestrolValue + goodColestrolValue + badColestrolValue +
                smokeValue + exerciseValue + bloodValue + diabtiesValue;

        binding.setTotalRatio(totalValue);
        if (totalValue <= -3) {
            binding.setTextValue("Low Health Risk");

            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if ((totalValue >= -2) && (totalValue <= -1)) {
            binding.setTextValue("Low Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 0) {
            binding.setTextValue("Low Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if ((totalValue == 1) || (totalValue == 2)) {
            binding.setTextValue("Low Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 3) {
            binding.setTextValue("Low Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 4) {
            binding.setTextValue("Low Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 5) {
            binding.setTextValue("Moderate Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 6) {
            binding.setTextValue("Moderate Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 7) {
            binding.setTextValue("Moderate Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 8) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 9) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 10) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 11) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 12) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue == 13) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        } else if (totalValue >= 14) {
            binding.setTextValue("High Health Risk");
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_HDR_RATIO, totalValue);
                adapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * This is the final calculatin
     */
    private void getFinalResult() {
        ageFunction(ageSting);
        smokeValueFunction(smokeString);
        exerciseValueFunction(exerciseString);
        bloodPressureValue(bloodString);
        diabetiesFunction(diabetesString);

        if (binding.getBad() != null) {
            getBadCholesterolValue(binding.getBad());
        } else {
            binding.setBad(0);
            getBadCholesterolValue(binding.getBad());
        }
        if (binding.getGood() != null) {
            getGoodCholesterolValue(binding.getGood());
        } else {
            binding.setGood(0);
            getGoodCholesterolValue(binding.getGood());
        }
        if (binding.getTotal() != null) {
            getTotalCholesterolValue(binding.getTotal());
        } else {
            binding.setTotal(0);
            getTotalCholesterolValue(binding.getTotal());
        }

        getFinalValue_And_Risk_Type();
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
