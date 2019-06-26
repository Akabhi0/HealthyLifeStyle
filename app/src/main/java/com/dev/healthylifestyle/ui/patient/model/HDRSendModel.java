package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HDRSendModel {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("agevalue")
    @Expose
    private String agevalue;

    @SerializedName("questsmoke")
    @Expose
    private String questsmoke;

    @SerializedName("questexercise")
    @Expose
    private String questexercise;

    @SerializedName("questbp")
    @Expose
    private String questbp;

    @SerializedName("questdiabetes")
    @Expose
    private String questdiabetes;

    @SerializedName("userid")
    @Expose
    private int userid;

    @SerializedName("totalcholesterol")
    @Expose
    private int totalcholesterol;

    @SerializedName("goodcholesterol")
    @Expose
    private int goodcholesterol;

    @SerializedName("badcholesterol")
    @Expose
    private int badcholesterol;

    @SerializedName("heartdiseasevalue")
    @Expose
    private int heartdiseasevalue;

    @SerializedName("result")
    @Expose
    private String result;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgevalue() {
        return agevalue;
    }

    public void setAgevalue(String agevalue) {
        this.agevalue = agevalue;
    }

    public String getQuestsmoke() {
        return questsmoke;
    }

    public void setQuestsmoke(String questsmoke) {
        this.questsmoke = questsmoke;
    }

    public String getQuestexercise() {
        return questexercise;
    }

    public void setQuestexercise(String questexercise) {
        this.questexercise = questexercise;
    }

    public String getQuestbp() {
        return questbp;
    }

    public void setQuestbp(String questbp) {
        this.questbp = questbp;
    }

    public String getQuestdiabetes() {
        return questdiabetes;
    }

    public void setQuestdiabetes(String questdiabetes) {
        this.questdiabetes = questdiabetes;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTotalcholesterol() {
        return totalcholesterol;
    }

    public void setTotalcholesterol(int totalcholesterol) {
        this.totalcholesterol = totalcholesterol;
    }

    public int getGoodcholesterol() {
        return goodcholesterol;
    }

    public void setGoodcholesterol(int goodcholesterol) {
        this.goodcholesterol = goodcholesterol;
    }

    public int getBadcholesterol() {
        return badcholesterol;
    }

    public void setBadcholesterol(int badcholesterol) {
        this.badcholesterol = badcholesterol;
    }

    public int getHeartdiseasevalue() {
        return heartdiseasevalue;
    }

    public void setHeartdiseasevalue(int heartdiseasevalue) {
        this.heartdiseasevalue = heartdiseasevalue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
