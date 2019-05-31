package com.dev.healthylifestyle.ui.patient.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.ContentPatientDashboardBinding;

public class DashboardFragment extends Fragment {

    private ContentPatientDashboardBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.content_patient_dashboard, container, false);
        return binding.getRoot();
    }
}
