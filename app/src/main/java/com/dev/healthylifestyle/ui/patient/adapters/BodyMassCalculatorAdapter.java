package com.dev.healthylifestyle.ui.patient.adapters;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.healthylifestyle.R;
import com.dev.healthylifestyle.databinding.BodyMassCalculatorAdapterBinding;
import com.dev.healthylifestyle.ui.patient.view.activity.BodyMassCalculatorActivity;
import com.dev.healthylifestyle.utility.Constants;
import com.dev.healthylifestyle.utility.PreferenceHelper;

public class BodyMassCalculatorAdapter extends RecyclerView.Adapter<BodyMassCalculatorAdapter.ViewHolder> {
    private String[] valueBodyMass;
    private BodyMassCalculatorActivity activity;

    public BodyMassCalculatorAdapter(String[] valueBodyMass, BodyMassCalculatorActivity bodyMassCalculatorActivity) {
        this.valueBodyMass = valueBodyMass;
        this.activity = bodyMassCalculatorActivity;
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return valueBodyMass.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.body_mass_calculator_adapter, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        double bmiRatio = PreferenceHelper.getInstance().getDouble(Constants.TOTAL_BMI_RATIO);
        if (bmiRatio >= 50) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 6) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (bmiRatio < 50 && bmiRatio >= 40) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 5) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (bmiRatio < 40 && bmiRatio >= 35) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 4) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (bmiRatio < 35 && bmiRatio >= 30) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 3) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (bmiRatio < 30 && bmiRatio >= 25) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 2) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (bmiRatio < 25 && bmiRatio >= 18.5) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 1) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (bmiRatio < 18.5) {
            holder.getBodyMassCalculatorAdapterBinding().setStringData(valueBodyMass[position]);
            if (position == 0) {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBodyMassCalculatorAdapterBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBodyMassCalculatorAdapterBinding().actvData.setTextColor(Color.BLACK);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private BodyMassCalculatorAdapterBinding bodyMassCalculatorAdapterBinding;

        public BodyMassCalculatorAdapterBinding getBodyMassCalculatorAdapterBinding() {
            return bodyMassCalculatorAdapterBinding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bodyMassCalculatorAdapterBinding = DataBindingUtil.bind(itemView);
        }
    }

}
