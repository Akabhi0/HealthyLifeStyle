package com.dev.healthylifestyle.ui.patient.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.dev.healthylifestyle.databinding.HeartDieasesCalculatorAdapterBinding;
import com.dev.healthylifestyle.ui.patient.view.activity.HeartDieasesRiskCalculatorActivity;
import com.dev.healthylifestyle.utility.Constants;
import com.dev.healthylifestyle.utility.PreferenceHelper;

public class HeartDieasesCalculatorAdapter extends RecyclerView.Adapter<HeartDieasesCalculatorAdapter.ViewHolder> {
    private String[] value;
    private Activity activity;

    public HeartDieasesCalculatorAdapter(String[] valueHeartDieases, HeartDieasesRiskCalculatorActivity heartDieasesRiskCalculatorActivity) {
        this.value = valueHeartDieases;
        this.activity = heartDieasesRiskCalculatorActivity;
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return value.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heart_dieases_calculator_adapter, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        double hdrRatio = PreferenceHelper.getInstance().getDouble(Constants.TOTAL_HDR_RATIO);
        if (hdrRatio >= 14) {
            holder.getBinding().setStringData(value[position]);
            if (position == 15) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 13) {
            holder.getBinding().setStringData(value[position]);
            if (position == 14) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 12) {
            holder.getBinding().setStringData(value[position]);
            if (position == 13) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 11) {
            holder.getBinding().setStringData(value[position]);
            if (position == 12) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 10) {
            holder.getBinding().setStringData(value[position]);
            if (position == 11) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 9) {
            holder.getBinding().setStringData(value[position]);
            if (position == 10) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 8) {
            holder.getBinding().setStringData(value[position]);
            if (position == 9) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 7) {
            holder.getBinding().setStringData(value[position]);
            if (position == 8) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 6) {
            holder.getBinding().setStringData(value[position]);
            if (position == 7) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 5) {
            holder.getBinding().setStringData(value[position]);
            if (position == 6) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 4) {
            holder.getBinding().setStringData(value[position]);
            if (position == 5) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 3) {
            holder.getBinding().setStringData(value[position]);
            if (position == 4) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 2 || hdrRatio == 1) {
            holder.getBinding().setStringData(value[position]);
            if (position == 3) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == 0) {
            holder.getBinding().setStringData(value[position]);
            if (position == 2) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio == -1 || hdrRatio == -2) {
            holder.getBinding().setStringData(value[position]);
            if (position == 1) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
        if (hdrRatio <= -3) {
            holder.getBinding().setStringData(value[position]);
            if (position == 0) {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule_stoke));
                holder.getBinding().actvData.setTextColor(Color.WHITE);
            } else {
                holder.getBinding().actvData.setBackground(activity.getDrawable(R.drawable.capsule));
                holder.getBinding().actvData.setTextColor(Color.BLACK);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private HeartDieasesCalculatorAdapterBinding binding;

        public HeartDieasesCalculatorAdapterBinding getBinding() {
            return binding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }


}
