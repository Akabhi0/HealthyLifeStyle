package com.dev.healthylifestyle.ui.patient.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ActivityDashboardBinding;
import com.dev.healthylifestyle.ui.patient.adapters.DashBoardListAdapter;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding activityDashboardBinding;
    Context context;
    private ImageView iv_expand,dashboard_graph,iv_expand_more;
    private RecyclerView rv_dashboardlist;
    private String flag_expand = "N";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar_dashboard);
         rv_dashboardlist = findViewById(R.id.rv_dashboardlist);
         iv_expand = findViewById(R.id.iv_expand);
        iv_expand_more = findViewById(R.id.iv_expand_more);
        dashboard_graph = findViewById(R.id.dashboard_graph);

         iv_expand.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                     iv_expand.setVisibility(View.GONE);
                     iv_expand_more.setVisibility(View.VISIBLE);
                     dashboard_graph.setVisibility(View.GONE);
             }
         });

        iv_expand_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_expand.setVisibility(View.VISIBLE);
                iv_expand_more.setVisibility(View.GONE);
                dashboard_graph.setVisibility(View.VISIBLE);
            }
        });




         //setting drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, activityDashboardBinding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityDashboardBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //Setting adapter
        DashBoardListAdapter adapter = new DashBoardListAdapter();
        rv_dashboardlist.setLayoutManager(new LinearLayoutManager(context));
        rv_dashboardlist.setAdapter(adapter);
    }
}
