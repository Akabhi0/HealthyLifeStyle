package com.dev.healthylifestyle.ui.patient.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev.healthylifestyle.ui.patient.model.BMIArrayModel;
import com.dev.healthylifestyle.ui.patient.model.BMISendModel;
import com.dev.healthylifestyle.ui.patient.model.CommonModel;
import com.dev.healthylifestyle.ui.patient.repository.Repository;

public class BMICalculatorViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<Boolean> onClicked = new MutableLiveData<>();

    public BMICalculatorViewModel() {
        repository = Repository.getBmiRepository();
    }

    public MutableLiveData<Boolean> getOnClicked() {
        return onClicked;
    }

    public void setOnClicked(Boolean onClicked) {
        this.onClicked.setValue(onClicked);
    }

    public MutableLiveData<BMIArrayModel> getBMIArrayModel(int userID) {
        return repository.getBMIArrayModel(userID);
    }

    public MutableLiveData<CommonModel> setBMIArrayModel(BMISendModel bmiSendModel) {
        return repository.sendBMIModel(bmiSendModel);
    }

    public void onClickSendUpdates() {
        setOnClicked(true);
    }
}
