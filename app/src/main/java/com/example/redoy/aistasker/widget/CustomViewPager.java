package com.example.redoy.aistasker.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by Redoy on 3/27/2018.
 */

public class CustomViewPager extends ViewPager {

    private boolean z;

    public CustomViewPager(Context context) {
        this(context, null);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSwipe(boolean z) {
        this.z = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.z) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.z) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        return this.z ? super.executeKeyEvent(keyEvent) : false;
    }
}
