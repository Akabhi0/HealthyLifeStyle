package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BMIModel {

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("weight")
    @Expose
    private String weight;

    @SerializedName("bmivalue")
    @Expose
    private String bmivalue;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmivalue() {
        return bmivalue;
    }

    public void setBmivalue(String bmivalue) {
        this.bmivalue = bmivalue;
    }

    public String getBmiresult() {
        return bmiresult;
    }

    public void setBmiresult(String bmiresult) {
        this.bmiresult = bmiresult;
    }

    @SerializedName("bmiresult")
    @Expose
    private String bmiresult;
}
