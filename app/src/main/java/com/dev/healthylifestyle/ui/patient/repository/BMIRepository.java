package com.dev.healthylifestyle.ui.patient.repository;

import androidx.lifecycle.MutableLiveData;

import com.dev.healthylifestyle.ui.patient.model.BMIArrayModel;
import com.dev.healthylifestyle.ui.patient.model.BMISendModel;
import com.dev.healthylifestyle.ui.patient.model.CommonModel;
import com.dev.healthylifestyle.ui.patient.webServeices.RetroFitClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BMIRepository {

    private static BMIRepository bmiRepository = null;
    private MutableLiveData<BMIArrayModel> loginModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CommonModel> commonModelMutableLiveData = new MutableLiveData<>();
    private String message;

    private BMIRepository() {
    }

    public static BMIRepository getBmiRepository() {
        if (bmiRepository == null)
            bmiRepository = new BMIRepository();
        return bmiRepository;
    }


    public MutableLiveData<BMIArrayModel> getBMIArrayModel(int userID) {
        RetroFitClass.getInstance().getBMIData(userID).enqueue(new Callback<BMIArrayModel>() {
            @Override
            public void onResponse(Call<BMIArrayModel> call, Response<BMIArrayModel> response) {
                loginModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<BMIArrayModel> call, Throwable t) {

            }
        });
        return loginModelMutableLiveData;
    }

    public MutableLiveData<CommonModel> sendBMIModel(BMISendModel model) {
        RetroFitClass.getInstance().sendBMIData(model).enqueue(new Callback<CommonModel>() {
            @Override
            public void onResponse(Call<CommonModel> call, Response<CommonModel> response) {
                commonModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CommonModel> call, Throwable t) {

            }
        });
        return commonModelMutableLiveData;
    }

}
