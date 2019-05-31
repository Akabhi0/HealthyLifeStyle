package com.dev.healthylifestyle.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper
{
    // TODO: CHANGE THIS TO SOMETHING MEANINGFUL
    private static final String SETTINGS_NAME = "MyPref";
    private static PreferenceHelper sSharedPrefs;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private boolean mBulkUpdate = false;

    private PreferenceHelper(Context context) {
        mPref = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceHelper getInstance(Context context) {
        if (sSharedPrefs == null) {
            sSharedPrefs = new PreferenceHelper(context.getApplicationContext());
        }
        return sSharedPrefs;
    }

    public static PreferenceHelper getInstance() {
        if (sSharedPrefs != null) {
            return sSharedPrefs;
        }

        //Option 1:
        throw new IllegalArgumentException("Should use getInstance(Context) at least once before using this method.");


    }

    public void putString(String key, String val) {
        doEdit();
        mEditor.putString(key, val);
        doCommit();
    }

    public void putInt(String key, int val) {
        doEdit();
        mEditor.putInt(key, val);
        doCommit();
    }

    public void putBoolean(String key, boolean val) {
        doEdit();
        mEditor.putBoolean(key, val);
        doCommit();
    }

    public void putFloat(String key, float val) {
        doEdit();
        mEditor.putFloat(key, val);
        doCommit();
    }


    public void putDouble(String key, double val) {
        doEdit();
        mEditor.putString(key, String.valueOf(val));
        doCommit();
    }

    public void putLong(String key, long val) {
        doEdit();
        mEditor.putLong(key, val);
        doCommit();
    }

    /* public File getString(String key, String defaultValue) {
         return mPref.getString(key, defaultValue);
     }
 */
    public String getString(String key) {
        return mPref.getString(key, "");
    }

    public int getInt(String key) {
        int i = 10;
        return mPref.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {

        try {
            return mPref.getInt(key, defaultValue);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public long getLong(String key) {
        int i = 10;
        return mPref.getLong(key, 0);
    }

    public long getLong(String key, long defaultValue) {
        int i = 10;
        return mPref.getLong(key, defaultValue);
    }

    public float getFloat(String key) {
        return mPref.getFloat(key, 0);
    }

    public float getFloat(String key, float defaultValue) {
        return mPref.getFloat(key, defaultValue);
    }


    public double getDouble(String key) {
        return getDouble(key, 0);
    }


    public double getDouble(String key, double defaultValue) {
        try {
            int i = 10;
            return Double.valueOf(mPref.getString(key, String.valueOf(defaultValue)));
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mPref.getBoolean(key, defaultValue);
    }

    public boolean getBoolean(String key) {
        return mPref.getBoolean(key, false);
    }


    public void remove(String... keys) {
        doEdit();
        for (String key : keys) {
            mEditor.remove(key);
        }
        doCommit();
    }


    public void clear() {
        doEdit();
        mEditor.clear();
        doCommit();
    }

    public void edit() {
        mBulkUpdate = true;
        mEditor = mPref.edit();
    }

    public void commit() {
        mBulkUpdate = false;
        mEditor.commit();
        mEditor = null;
    }

    private void doEdit() {
        if (!mBulkUpdate && mEditor == null) {
            mEditor = mPref.edit();
        }
    }

    private void doCommit() {
        if (!mBulkUpdate && mEditor != null) {
            mEditor.commit();
            mEditor = null;
        }
    }

}
