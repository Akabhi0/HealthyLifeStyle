package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HDRSendModel {

    @SerializedName("age")
    @Expose
    private int age;

    @SerializedName("levelofexercise")
    @Expose
    private String levelofexercise;

    @SerializedName("userid")
    @Expose
    private int userid;

    @SerializedName("targetheartvalue")
    @Expose
    private String targetheartvalue;

    @SerializedName("result")
    @Expose
    private String result;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevelofexercise() {
        return levelofexercise;
    }

    public void setLevelofexercise(String levelofexercise) {
        this.levelofexercise = levelofexercise;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTargetheartvalue() {
        return targetheartvalue;
    }

    public void setTargetheartvalue(String targetheartvalue) {
        this.targetheartvalue = targetheartvalue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
