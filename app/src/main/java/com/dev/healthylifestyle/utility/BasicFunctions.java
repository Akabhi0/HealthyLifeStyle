package com.dev.healthylifestyle.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class BasicFunctions {

    public static DecimalFormat df2 = new DecimalFormat("#.##");

    /**
     * This is the function is used for opening the new activity
     *
     * @param activty
     * @param clas
     * @return
     */
    public static Intent useIntent(Activity activty, Class clas) {
        Intent intent = new Intent(activty, clas);
        return intent;
    }

    /**
     * Universal toast message
     *
     * @param messageToast
     * @param context
     */
    public static void getToastMessage(String messageToast, Context context) {
        Toast.makeText(context, messageToast, Toast.LENGTH_SHORT).show();
    }

    /**
     * This is the function is used for the sending index number in fixed array
     *
     * @param roundOffValue
     * @param createDivision
     * @return
     */
    public static int returnIndex(double roundOffValue, ArrayList<Double> createDivision) {
        double distance = Math.abs(createDivision.get(0) - roundOffValue);
        double valueOfIndex = 0;

        for (int c = 1; c < createDivision.size(); c++) {
            double cdistance = Math.abs(createDivision.get(c) - roundOffValue);
            if (cdistance < distance) {
                valueOfIndex = createDivision.get(c);
                distance = cdistance;
            }
        }
        int theIndex = createDivision.indexOf(valueOfIndex);
        return theIndex;
    }

    public static LinearLayoutManager getLinearLayoutManager(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        linearLayoutManager.canScrollHorizontally();
        return linearLayoutManager;
    }

    public static void setSharedPreferences(String preferencesName, float prefrencesData, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(preferencesName, MODE_PRIVATE).edit();
        editor.putFloat(Constants.TOTAL_BMI_RATIO, prefrencesData);
        editor.apply();
    }

    public static float getSharedPreferences(String preferencesName, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferencesName, MODE_PRIVATE);
        return sharedPreferences.getFloat(Constants.TOTAL_BMI_RATIO, 0f);
    }


    /**
     * This arrayAdapter is used for setting the string array data into spinner in dropdown menu like
     *
     * @param context
     * @param stringArray
     * @return
     */
    public static ArrayAdapter<String> getArrayAdapterSpinner(Context context, String[] stringArray) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item,
                stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        return adapter;
    }
}
