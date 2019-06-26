package com.dev.healthylifestyle.ui.patient.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeartDieasesRiskCalculatorViewModel extends ViewModel {

    private MutableLiveData<Boolean> clickedMale = new MutableLiveData<>();
    private MutableLiveData<Boolean> clickedFemale = new MutableLiveData<>();

    public MutableLiveData<Boolean> getClickedMale() {
        return clickedMale;
    }

    public void setClickedMale(Boolean clickedMale) {
        this.clickedMale.setValue(clickedMale);
    }

    public MutableLiveData<Boolean> getClickedFemale() {
        return clickedFemale;
    }

    public void setClickedFemale(Boolean clickedFemale) {
        this.clickedFemale.setValue(clickedFemale);
    }

    public void clickedMale() {
        setClickedMale(true);
    }

    public void clickedFemale() {
        setClickedFemale(true);
    }
}
