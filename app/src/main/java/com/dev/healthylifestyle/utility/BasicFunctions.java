package com.dev.healthylifestyle.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BasicFunctions {

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

}
