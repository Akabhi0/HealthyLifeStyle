package com.dev.healthylifestyle.ui.patient.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityNavigationBinding;
import com.dev.healthylifestyle.ui.CustomDialog;
import com.dev.healthylifestyle.ui.patient.view.fragment.DashboardFragment;
import com.dev.healthylifestyle.utility.BasicFunctions;
import com.dev.healthylifestyle.utility.Constants;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityNavigationBinding binding;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        /**
         * This is  for opening the default fragment
         */
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashboardFragment()).commit();
        }

        setToolbar("Dashboard");
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                // getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashboardFragment()).commit();
                break;
            case R.id.nav_profile:
                startActivity(BasicFunctions.useIntent(this, ProfileActivity.class));
                finish();
                break;
            case R.id.nav_calculators:
                CustomDialog customDialog = new CustomDialog(NavigationActivity.this,
                        getResources().getString(R.string.calculator),
                        Constants.REQUEST_CALCULATOR_CODE
                );
                customDialog.show();
                break;
            case R.id.nav_queries:
                // getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyQueriesFragment()).commit();
                break;
            case R.id.nav_question:
                // getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyQuestionsFragment()).commit();
                break;
            case R.id.nav_feedback:
                // getSupportFragmentManager().beginTransaction().replace(R.id.container, new FeedbackFragment()).commit();
                break;
            case R.id.nav_contact:
                //  getSupportFragmentManager().beginTransaction().replace(R.id.container, new FeedbackFragment()).commit();
                break;
            case R.id.nav_rate:
                // getSupportFragmentManager().beginTransaction().replace(R.id.container, new FeedbackFragment()).commit();
                break;
            case R.id.nav_share:
                shareVia_Social();
                break;
            case R.id.nav_logout:
                //popup
                break;
        }
        binding.drawerHrLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * This function is used to set default toolbar to android
     *
     * @param title
     */
    private void setToolbar(String title) {
        binding.toolbar.setTitle(title);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerHrLayout, binding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerHrLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        binding.navHrView.setItemIconTintList(null);
        binding.navHrView.setNavigationItemSelectedListener(this);
    }

    /**
     * This function is used to share the apps
     */
    public void shareVia_Social() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "HealthyLifeStyle");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hi, The services of healthy life style has been useful to me. Might benefit you as well.\n" + "\"Download App https://play.google.com/store/apps/details?id=com.dev.healthylifestyle");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
