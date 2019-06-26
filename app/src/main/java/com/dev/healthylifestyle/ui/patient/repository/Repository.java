package com.dev.healthylifestyle.ui.patient.repository;

import androidx.lifecycle.MutableLiveData;

import com.dev.healthylifestyle.ui.patient.model.BMIArrayModel;
import com.dev.healthylifestyle.ui.patient.model.BMISendModel;
import com.dev.healthylifestyle.ui.patient.model.CommonModel;
import com.dev.healthylifestyle.ui.patient.model.HDRArrayModel;
import com.dev.healthylifestyle.ui.patient.model.HDRSendModel;
import com.dev.healthylifestyle.ui.patient.webServeices.RetroFitClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository bmiRepository = null;
    private MutableLiveData<BMIArrayModel> loginModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<CommonModel> commonModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<HDRArrayModel> hdrArrayModelMutableLiveData = new MutableLiveData<>();
    private String message;

    private Repository() {
    }

    public static Repository getBmiRepository() {
        if (bmiRepository == null)
            bmiRepository = new Repository();
        return bmiRepository;
    }


    /**
     * This is for posting the value to the server to the API
     *
     * @param userID
     * @return
     */
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

    /**
     * This is for sending the value of BMI calculator to the API
     *
     * @param model
     * @return
     */
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

    /**
     * This is for the sending the value of HDR calculator to the API
     *
     * @param model
     * @return
     */
    public MutableLiveData<CommonModel> sendHDRModel(HDRSendModel model) {
        RetroFitClass.getInstance().sendHDRData(model).enqueue(new Callback<CommonModel>() {
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

    /**
     * This is used to get data of the HDR calculatot
     *
     * @param userID
     * @return
     */
    public MutableLiveData<HDRArrayModel> getHDIModel(int userID) {
        RetroFitClass.getInstance().getHDRData(userID).enqueue(new Callback<HDRArrayModel>() {
            @Override
            public void onResponse(Call<HDRArrayModel> call, Response<HDRArrayModel> response) {
                hdrArrayModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<HDRArrayModel> call, Throwable t) {

            }
        });
        return hdrArrayModelMutableLiveData;
    }

}
