package com.example.redoy.aistasker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.example.redoy.aistasker.R;

public class YesNoWidget extends RadioGroup {
    private final Context context;
    private OnStateChangedListener onStateChangedListener;

    class C04821 implements OnCheckedChangeListener {
        final YesNoWidget yesNoWidget;

        C04821(YesNoWidget yesNoWidget) {
            this.yesNoWidget = yesNoWidget;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            boolean z = false;
            if (this.yesNoWidget.onStateChangedListener != null) {
                OnStateChangedListener a = this.yesNoWidget.onStateChangedListener;
                if (i == this.yesNoWidget.getChildAt(0).getId()) {
                    z = true;
                }
                a.mo2233a(z);
            }
        }
    }

    public interface OnStateChangedListener {
        void mo2233a(boolean z);
    }

    public YesNoWidget(Context context) {
        this(context, null);
    }

    public YesNoWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        m1911e();
    }

    private void m1911e() {
        setOrientation(HORIZONTAL);
        addView(inflate(this.context, R.layout.radio_button_left, null));
        addView(inflate(this.context, R.layout.radio_button_right, null));
        super.setOnCheckedChangeListener(new C04821(this));
    }

    public boolean m1912a() {
        return getCheckedRadioButtonId() == getChildAt(0).getId();
    }

    public boolean m1913b() {
        return !m1912a();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
    }

    public void m1914c() {
        check(getChildAt(0).getId());
    }

    public void m1915d() {
        check(getChildAt(1).getId());
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }
}
