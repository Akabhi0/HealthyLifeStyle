package com.dev.healthylifestyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomMeter extends View {
    private Path markPath = new Path();

    private Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG),
            speedometerPaint = new Paint(Paint.ANTI_ALIAS_FLAG),
            markPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF speedometerRect = new RectF();
    private Context context;

    public CustomMeter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        circlePaint = new Paint();
        speedometerPaint = new Paint();
        speedometerRect = new RectF();

        speedometerPaint.setStyle(Paint.Style.STROKE);
        speedometerPaint.setColor(context.getResources().getColor(R.color.colorPrimary));


        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawArc(speedometerRect, 0,
                360,
                false,
                speedometerPaint);

    }
}
