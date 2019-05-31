package com.dev.healthylifestyle.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class HealthyLifeStyleApplicationClass extends MultiDexApplication
{
    NetworkHelper networkHelper;
    @Override
    public void onCreate() {
        super.onCreate();

        networkHelper=new NetworkHelper();
        PreferenceHelper.getInstance(getApplicationContext());
        getApplicationContext().registerReceiver(networkHelper,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        getApplicationContext().unregisterReceiver(networkHelper);
    }
}
