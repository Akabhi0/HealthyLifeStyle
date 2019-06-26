package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BMIArrayModel {

    public ArrayList<BMIModel> getBmiModels() {
        return bmiModels;
    }

    public void setBmiModels(ArrayList<BMIModel> bmiModels) {
        this.bmiModels = bmiModels;
    }

    @SerializedName("Results")
    @Expose
    private ArrayList<BMIModel> bmiModels = new ArrayList<>();
}
