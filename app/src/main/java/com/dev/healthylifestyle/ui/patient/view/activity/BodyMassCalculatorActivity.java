package com.dev.healthylifestyle.ui.patient.view.activity;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityBodyMassCalculatorBinding;
import com.dev.healthylifestyle.ui.patient.adapters.BodyMassCalculatorAdapter;
import com.dev.healthylifestyle.ui.patient.model.BMIArrayModel;
import com.dev.healthylifestyle.ui.patient.model.BMISendModel;
import com.dev.healthylifestyle.ui.patient.model.CommonModel;
import com.dev.healthylifestyle.ui.patient.viewModel.BMICalculatorViewModel;
import com.dev.healthylifestyle.utility.BasicFunctions;
import com.dev.healthylifestyle.utility.Constants;
import com.dev.healthylifestyle.utility.PreferenceHelper;

public class BodyMassCalculatorActivity extends AppCompatActivity {

    private ActivityBodyMassCalculatorBinding binding;
    private BodyMassCalculatorAdapter adapter;
    private String[] valueBodyMass;
    private int minHeight = 20, maxHeight = 270, currentHeight = 250, minWeight = 5, maxWeight = 200, currentWeight = 195;
    private String BMIvalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_body_mass_calculator);
        setToolBar(getResources().getString(R.string.actv_bmic));
        getViewModel();
    }

    private void getViewModel() {
        final BMICalculatorViewModel viewModel = ViewModelProviders.of(this).get(BMICalculatorViewModel.class);
        binding.setViewModel(viewModel);

        /**
         * Getting the data form the server
         */
        viewModel.getBMIArrayModel(51).observe(this, new Observer<BMIArrayModel>() {
            @Override
            public void onChanged(final BMIArrayModel bmiArrayModel) {
                if (bmiArrayModel != null) {
                    binding.setWeight(bmiArrayModel.getBmiModels().get(0).getWeight());
                    binding.setKGS(" KGS");

                    binding.setHeight(bmiArrayModel.getBmiModels().get(0).getHeight());
                    binding.setCM(" CM");

                    binding.setTotalRatio(bmiArrayModel.getBmiModels().get(0).getBmivalue());
                    binding.setTextValue(bmiArrayModel.getBmiModels().get(0).getBmiresult());
                    BMIvalue = bmiArrayModel.getBmiModels().get(0).getBmivalue();
                    binding.acsbHeight.setProgress(Integer.parseInt(bmiArrayModel.getBmiModels().get(0).getHeight()));
                    binding.acsbWeight.setProgress(Integer.parseInt(bmiArrayModel.getBmiModels().get(0).getWeight()));

                    /**
                     * Setting default recyler view
                     */
                    valueBodyMass = getResources().getStringArray(R.array.body_mass_value);
                    adapter = new BodyMassCalculatorAdapter(valueBodyMass, BodyMassCalculatorActivity.this);
                    PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Double.parseDouble(BMIvalue));
                    binding.recylerView.setAdapter(adapter);
                    binding.recylerView.setLayoutManager(BasicFunctions.getLinearLayoutManager(BodyMassCalculatorActivity.this));

                    /**
                     * using meter
                     */
                    getMeter();


                    viewModel.getOnClicked().observe(BodyMassCalculatorActivity.this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            if (aBoolean) {
                                BMISendModel bmiSendModel = new BMISendModel();
                                bmiSendModel.setBmiresult(binding.getTextValue());
                                bmiSendModel.setBmivalue(binding.getTotalRatio());
                                bmiSendModel.setHeight(binding.getHeight());
                                bmiSendModel.setWeight(binding.getWeight());
                                bmiSendModel.setUserid(51);

                                viewModel.setBMIArrayModel(bmiSendModel).observe(BodyMassCalculatorActivity.this, new Observer<CommonModel>() {
                                    @Override
                                    public void onChanged(CommonModel commonModel) {
                                        BasicFunctions.getToastMessage(commonModel.getResults(), BodyMassCalculatorActivity.this);
                                    }
                                });
                            }

                        }
                    });

                } else {
                    BasicFunctions.getToastMessage("No Data From API", BodyMassCalculatorActivity.this);
                }
            }
        });
    }

    private void getMeter() {
        /**
         *  This is for the calculating the height
         */
        binding.acsbHeight.setMax(maxHeight - minHeight);
        binding.acsbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try {
                    if (binding.acsbWeight.getProgress() < 0) {
                        currentHeight = progress + minHeight;
                        binding.setHeight(String.valueOf(currentHeight));
                        bodyMassCalculatorResult(5, Double.parseDouble(binding.getHeight()));
                    } else {
                        currentHeight = progress + minHeight;
                        binding.setHeight(String.valueOf(currentHeight));
                        bodyMassCalculatorResult(Double.parseDouble(binding.getWeight()), Double.parseDouble(binding.getHeight()));
                    }
                } catch (NullPointerException n) {
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        /**
         * This is for the calculating the weight
         */
        binding.acsbWeight.setMax(maxWeight - minWeight);
        binding.acsbWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                try {
                    if (binding.acsbHeight.getProgress() < 0) {
                        currentWeight = progress + minWeight;
                        binding.setWeight(String.valueOf(currentWeight));
                        bodyMassCalculatorResult(Double.parseDouble(binding.getWeight()), 20.0);
                    } else {
                        currentWeight = progress + minWeight;
                        binding.setWeight(String.valueOf(currentWeight));
                        bodyMassCalculatorResult(Double.parseDouble(binding.getWeight()), Double.parseDouble(binding.getHeight()));
                    }
                } catch (NullPointerException n) {
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

    private void bodyMassCalculatorResult(double weight, double height) {
        /**
         * Convert into cm to meter of height
         */
        double meterHeight = Math.round((height / 100) * 100.0) / 100.0;
        Constants.RESULT = (float) (weight / (meterHeight * meterHeight));
        binding.setTotalRatio(String.valueOf(Math.round(Constants.RESULT * 100.0) / 100.0));

        if (Math.round(Constants.RESULT * 100.0) / 100.0 <= 18.5) {
            binding.setTextValue(getResources().getString(R.string.BMI_one));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
        if (Math.round(Constants.RESULT * 100.0) / 100.0 > 18.5 && Math.round(Constants.RESULT * 100.0) / 100.0 < 24.9) {
            binding.setTextValue(getResources().getString(R.string.BMI_two));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
        if (Math.round(Constants.RESULT * 100.0) / 100.0 >= 25 && Math.round(Constants.RESULT * 100.0) / 100.0 <= 29.9) {
            binding.setTextValue(getResources().getString(R.string.BMI_three));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
        if (Math.round(Constants.RESULT * 100.0) / 100.0 >= 30 && Math.round(Constants.RESULT * 100.0) / 100.0 <= 34.9) {
            binding.setTextValue(getResources().getString(R.string.BMI_four));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
        if (Math.round(Constants.RESULT * 100.0) / 100.0 >= 35 && Math.round(Constants.RESULT * 100.0) / 100.0 <= 39.9) {
            binding.setTextValue(getResources().getString(R.string.BMI_five));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
        if (Math.round(Constants.RESULT * 100.0) / 100.0 >= 40 && Math.round(Constants.RESULT * 100.0) / 100.0 <= 49.9) {
            binding.setTextValue(getResources().getString(R.string.BMI_six));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
        if (Math.round(Constants.RESULT * 100.0) / 100.0 >= 50) {
            binding.setTextValue(getResources().getString(R.string.BMI_seven));
            PreferenceHelper.getInstance().clear();
            if (adapter != null) {
                PreferenceHelper.getInstance().putDouble(Constants.TOTAL_BMI_RATIO, Math.round(Constants.RESULT * 100.0) / 100.0);
                adapter.notifyDataSetChanged();
            }
        }
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
