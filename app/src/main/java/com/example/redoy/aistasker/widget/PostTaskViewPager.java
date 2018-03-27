package com.example.redoy.aistasker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class PostTaskViewPager extends CustomViewPager {

    class PageChangeClass implements OnPageChangeListener {
        final PostTaskViewPager postTaskViewPager;

        PageChangeClass(PostTaskViewPager postTaskViewPager) {
            this.postTaskViewPager = postTaskViewPager;
        }

        public void onPageScrolled(int i, float f, int i2) {
            this.postTaskViewPager.requestLayout();
        }

        public void onPageSelected(int i) {
        }

        public void onPageScrollStateChanged(int i) {
        }
    }

    public PostTaskViewPager(Context context) {
        this(context, null);
    }

    public PostTaskViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1873a();
    }

    private void m1873a() {
        addOnPageChangeListener(new PageChangeClass(this));
        setSwipe(false);
    }

    public void onMeasure(int i, int i2) {
        int measuredHeight;
        View childAt = getChildAt(getCurrentItem());
        if (childAt != null) {
            childAt.measure(i, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            measuredHeight = childAt.getMeasuredHeight();
            measuredHeight = measuredHeight > MeasureSpec.getSize(i2) ? MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY) : MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), MeasureSpec.EXACTLY);
        } else {
            measuredHeight = i2;
        }
        super.onMeasure(i, measuredHeight);
    }
}
