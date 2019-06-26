package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BMISendModel {

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("weight")
    @Expose
    private String weight;

    @SerializedName("userid")
    @Expose
    private int userid;

    @SerializedName("bmivalue")
    @Expose
    private String bmivalue;

    @SerializedName("bmiresult")
    @Expose
    private String bmiresult;

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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
}
