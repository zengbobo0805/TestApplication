package com.test;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class FirstViewGroup extends ViewGroup {
    private static final String TAG = "FirstViewGroup";

    public FirstViewGroup(Context context) {
        super(context);
    }

    public FirstViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FirstViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        Log.d(TAG, "onMeasure count:" + count);
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            int w = view.getMeasuredWidth();
            int h = view.getMeasuredHeight();
            Log.d(TAG, "onLayout i:" + i + ",w:" + w + ",h:" + h);
            view.layout(l, t, l + w, t + h);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent getAction:" + ev.getAction());
        boolean flag = super.dispatchTouchEvent(ev);
        Log.d(TAG, "dispatchTouchEvent getAction:" + ev.getAction() + ",flag:" + flag);
        return flag;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent getAction:" + ev.getAction());
        boolean flag =  super.onInterceptTouchEvent(ev);
        Log.d(TAG, "onInterceptTouchEvent getAction:" + ev.getAction() + ",flag:" + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent getAction:" + ev.getAction());
        boolean flag = super.onTouchEvent(ev);
        Log.d(TAG, "onTouchEvent getAction:" + ev.getAction() + ",flag:" + flag);
        return flag;
    }
}
