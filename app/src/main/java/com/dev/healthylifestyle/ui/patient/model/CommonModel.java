package com.dev.healthylifestyle.ui.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonModel {

    @SerializedName("Results")
    @Expose
    private String Results;

    public String getResults() {
        return Results;
    }

    public void setResults(String results) {
        Results = results;
    }
}
