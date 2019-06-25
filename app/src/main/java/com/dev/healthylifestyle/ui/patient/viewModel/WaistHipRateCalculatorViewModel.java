package com.dev.healthylifestyle.ui.patient.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WaistHipRateCalculatorViewModel extends ViewModel {

    private MutableLiveData<Boolean> onClickedMale = new MutableLiveData<>();
    private MutableLiveData<Boolean> onClickedFemale = new MutableLiveData<>();

    public MutableLiveData<Boolean> getOnClickedMale() {
        return onClickedMale;
    }

    public void setOnClickedMale(Boolean onClickedMale) {
        this.onClickedMale.setValue(onClickedMale);
    }

    public MutableLiveData<Boolean> getOnClickedFemale() {
        return onClickedFemale;
    }

    public void setOnClickedFemale(Boolean onClickedFemale) {
        this.onClickedFemale.setValue(onClickedFemale);
    }

    public void onMaleClicked() {
        setOnClickedMale(true);
    }

    public void onFemaleClicked() {
        setOnClickedFemale(true);
    }

}
