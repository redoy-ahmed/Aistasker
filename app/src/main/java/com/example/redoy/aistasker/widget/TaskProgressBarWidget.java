package com.example.redoy.aistasker.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.redoy.aistasker.R;

import java.util.Arrays;
import java.util.List;

public class TaskProgressBarWidget extends View {
    private final float f1404a = (9.0f * getResources().getDisplayMetrics().density);
    private final float f1405b = (12.0f * getResources().getDisplayMetrics().density);
    private final float f1406c = (18.0f * getResources().getDisplayMetrics().density);
    private final RectF f1407d = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private final int f1408e = getResources().getColor(R.color.greenAlertWidgetText);
    private final int f1409f = getResources().getColor(R.color.grey3);
    private final int f1410g = getResources().getColor(R.color.greenAlertWidgetBackground);
    private final Rect f1411h = new Rect();
    private int f1412i;
    private int f1413j;
    private List<Integer> f1414k;
    private int f1415l;
    private Paint paint;

    public interface OnSegmentClickedListener {
        void mo2257a(int i);
    }

    public TaskProgressBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1900a();
    }

    private void m1900a() {
        this.paint = new Paint();
        this.paint.setStyle(Style.FILL);
        this.paint.setAntiAlias(true);
        this.paint.setTextSize(this.f1405b);
        this.paint.setTextAlign(Align.CENTER);
        this.f1415l = 1;
        this.f1414k = Arrays.asList(1, 2, 3);
    }

    @SuppressLint("WrongConstant")
    protected void onMeasure(int i, int i2) {
        this.paint.getTextBounds("Op", 0, 1, this.f1411h);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((int) this.f1406c, Integer.MIN_VALUE));
    }

    public void setState(List<Integer> statesList, int indexOfSelected) {
        this.f1414k = statesList;
        this.f1415l = indexOfSelected + 1;
        invalidate();
    }

    public void setSegmentClickedListener(final OnSegmentClickedListener onSegmentClickedListener) {
        setOnTouchListener(new OnTouchListener() {
            TaskProgressBarWidget taskProgressBarWidget;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    onSegmentClickedListener.mo2257a((((int) motionEvent.getX()) * this.taskProgressBarWidget.f1414k.size()) / this.taskProgressBarWidget.getWidth());
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1412i = getWidth();
        this.f1413j = this.f1412i / this.f1414k.size();
        this.paint.setColor(this.f1410g);
        this.f1407d.set(0.0f, 0.0f, (float) (this.f1415l * this.f1413j), this.f1406c);
        canvas.drawRoundRect(this.f1407d, this.f1404a, this.f1404a, this.paint);
        for (int i = 0; i < this.f1414k.size(); i++) {
            this.paint.setColor(m1898a(i));
            canvas.drawText("ONE", (float) ((this.f1413j * i) + (this.f1413j >> 1)), this.f1406c + this.f1411h.exactCenterY(), this.paint);
        }
    }

    private int m1898a(int i) {
        return i < this.f1415l ? this.f1408e : this.f1409f;
    }
}
