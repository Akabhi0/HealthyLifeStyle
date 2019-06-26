package com.dev.healthylifestyle.ui.patient.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev.healthylifestyle.ui.patient.model.CommonModel;
import com.dev.healthylifestyle.ui.patient.model.HDRArrayModel;
import com.dev.healthylifestyle.ui.patient.model.HDRSendModel;
import com.dev.healthylifestyle.ui.patient.repository.Repository;

public class HeartDieasesRiskCalculatorViewModel extends ViewModel {

    private MutableLiveData<Boolean> clickedMale = new MutableLiveData<>();
    private MutableLiveData<Boolean> clickedFemale = new MutableLiveData<>();
    private MutableLiveData<Boolean> onUpdate = new MutableLiveData<>();

    public MutableLiveData<Boolean> getOnUpdate() {
        return onUpdate;
    }

    public void setOnUpdate(Boolean onUpdate) {
        this.onUpdate.setValue(onUpdate);
    }

    private Repository repository;

    public HeartDieasesRiskCalculatorViewModel() {
        this.repository = Repository.getBmiRepository();
    }

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

    public void onUpdate() {
        setOnUpdate(true);
    }

    /**
     * This is used to send the data to the API
     *
     * @param model
     * @return
     */
    public MutableLiveData<CommonModel> setBMIArrayModel(HDRSendModel model) {
        return repository.sendHDRModel(model);
    }

    public MutableLiveData<HDRArrayModel> getHDRArrayMode(int userId) {
        return repository.getHDIModel(userId);
    }
}
