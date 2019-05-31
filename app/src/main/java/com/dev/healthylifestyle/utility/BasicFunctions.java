package com.dev.healthylifestyle.utility;

import android.app.Activity;
import android.content.Intent;

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

}
