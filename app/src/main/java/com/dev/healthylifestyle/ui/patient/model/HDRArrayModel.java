package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HDRArrayModel {

    @SerializedName("Results")
    @Expose
    private ArrayList<HDRSendModel> hdrModels = new ArrayList<>();

    public ArrayList<HDRSendModel> getHdrModels() {
        return hdrModels;
    }

    public void setHdrModels(ArrayList<HDRSendModel> hdrModels) {
        this.hdrModels = hdrModels;
    }
}
