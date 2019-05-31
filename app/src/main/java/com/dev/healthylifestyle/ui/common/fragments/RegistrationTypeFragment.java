package com.dev.healthylifestyle.ui.common.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.ui.patient.activities.DashboardActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationTypeFragment extends DialogFragment {
    TextView cv_done;


    public RegistrationTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registration_type, container, false);

        cv_done = v.findViewById(R.id.cv_done);


        cv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), DashboardActivity.class));
            }
        });



        return v;
    }

}
