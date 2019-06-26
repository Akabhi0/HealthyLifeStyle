package com.dev.healthylifestyle.ui.patient.webServeices;

import com.dev.healthylifestyle.ui.patient.model.BMIArrayModel;
import com.dev.healthylifestyle.ui.patient.model.BMISendModel;
import com.dev.healthylifestyle.ui.patient.model.CommonModel;
import com.dev.healthylifestyle.ui.patient.model.HDRSendModel;
import com.dev.healthylifestyle.utility.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiCalls {

    String URL_GET_BMI = Constants.BASE_URL + "api/User/GetBmi";
    String URL_POST_BMI = Constants.BASE_URL + "api/User/InsertBmi";

    String URL_POST_HDR = Constants.BASE_URL + "api/User/InsertHeartRate";

    @FormUrlEncoded
    @POST(URL_GET_BMI)
    Call<BMIArrayModel> getBMIData(@Field("userid") int userid);

    @POST(URL_POST_BMI)
    Call<CommonModel> sendBMIData(@Body BMISendModel bmiSendModel);

    @POST(URL_POST_HDR)
    Call<CommonModel> sendHDRData(@Body HDRSendModel hdrSendModel);

}
