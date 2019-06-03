package com.dev.healthylifestyle.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

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

    public CustomDialog(@NonNull Activity context, String title, int request_code) {
        super(context);
        this.activity = context;
        this.Title = title;
        this.request_code = request_code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (request_code == Constants.REQUEST_CALCULATOR_CODE) {
            calculatorDialogeBinding = DataBindingUtil.inflate(LayoutInflater.from(activity),
                    R.layout.calculator_dialoge,
                    null, false);

            calculatorDialogeBinding.setTitle(Title);
        }
    }
}
