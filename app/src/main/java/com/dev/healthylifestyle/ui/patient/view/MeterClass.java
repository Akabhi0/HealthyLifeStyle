package com.dev.healthylifestyle.ui.patient.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MeterClass extends View {

    private Paint mPaint;
    private float mStrokeWidth;
    private int mStrokeColor;
    private RectF mRect;
    private String mStrokeCap;
    private int mStartAngle;
    private int mSweepAngle;
    private int mStartValue;
    private int mEndValue;
    private int mValue;
    private double mPointAngle;
    private int mPoint;
    private int mPointSize;
    private int mPointStartColor;
    private int mPointEndColor;
    private int mDividerColor;
    private int mDividerSize;
    private int mDividerStepAngle;
    private int mDividersCount;
    private boolean mDividerDrawFirst;
    private boolean mDividerDrawLast;

    public MeterClass(Context context) {
        super(context);
    }
}