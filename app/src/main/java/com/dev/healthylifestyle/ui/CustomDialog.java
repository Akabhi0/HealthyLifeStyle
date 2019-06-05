package com.dev.healthylifestyle.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.CalculatorDialogeBinding;
import com.dev.healthylifestyle.utility.Constants;

public class CustomDialog extends Dialog {

    private CalculatorDialogeBinding calculatorDialogeBinding;
    private Activity activity;
    private String Title;
    private int request_code;
    private onClickCalculatorDialog onClickCalculatorDialog;

    public CustomDialog(@NonNull Activity context, String title, int request_code, CustomDialog.onClickCalculatorDialog onClickCalculatorDialog) {
        super(context);
        this.activity = context;
        this.Title = title;
        this.request_code = request_code;
        this.onClickCalculatorDialog = onClickCalculatorDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (request_code == Constants.REQUEST_CALCULATOR_CODE) {
            calculatorDialogeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity),
                    R.layout.calculator_dialoge,
                    null, false);

            calculatorDialogeBinding.setTitle(Title);
            calculatorControls();
            setContentView(calculatorDialogeBinding.getRoot());
        }
    }


    /**
     * This is calculator controls
     */
    private void calculatorControls() {
        calculatorDialogeBinding.actvBmic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculatorDialog.onClickedDialogOption(true, Constants.BODY_MASS_CAL_VALUE);
                dismiss();
            }
        });

        calculatorDialogeBinding.actvCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculatorDialog.onClickedDialogOption(true, Constants.CALORIES_CALCULATOR_VALUE);
                dismiss();
            }
        });

        calculatorDialogeBinding.actvHdrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculatorDialog.onClickedDialogOption(true, Constants.HEART_DIEASES_VALUE);
                dismiss();
            }
        });

        calculatorDialogeBinding.actvLsrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculatorDialog.onClickedDialogOption(true, Constants.LIFE_STYLE_RISK_VALUE);
                dismiss();
            }
        });


        calculatorDialogeBinding.actvThre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculatorDialog.onClickedDialogOption(true, Constants.TARGET_HEART_VALUE);
                dismiss();
            }
        });

        calculatorDialogeBinding.actvWhrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculatorDialog.onClickedDialogOption(true, Constants.WAIST_HIP_RATIO_VALUE);
                dismiss();
            }
        });

    }

    public interface onClickCalculatorDialog {
        void onClickedDialogOption(Boolean clicked, int calculatorValue);
    }

    public void onClickedOptionFunction(onClickCalculatorDialog onClickCalculatorDialog) {
        this.onClickCalculatorDialog = onClickCalculatorDialog;
    }

}
