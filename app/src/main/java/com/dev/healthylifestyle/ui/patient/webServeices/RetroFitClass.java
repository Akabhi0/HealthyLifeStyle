package com.dev.healthylifestyle.ui.patient.webServeices;

import com.dev.healthylifestyle.utility.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClass {

    /**
     * making the retrofit reference as a null
     */
    private static ApiCalls apiCalls = null;

    public static ApiCalls getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCalls = retrofit.create(ApiCalls.class);
        return apiCalls;
    }
}
