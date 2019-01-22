package com.test;


import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class FirstView extends View {
    private static final String TAG = "FirstView";

    public FirstView(Context context) {
        super(context);
    }

    public FirstView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FirstView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent getAction:" + ev.getAction());
        boolean flag = ev.getAction() != MotionEvent.ACTION_DOWN ? true : super.dispatchTouchEvent(ev);
        Log.d(TAG, "dispatchTouchEvent getAction:" + ev.getAction() + ",flag:" + flag);
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
