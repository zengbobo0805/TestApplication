package com.utils;

import android.util.Log;

public class LogUtil {
    private static final String TAG = "LogUtil";

    public static void i(String log) {
        Log.i(TAG, log);
    }

    public static void d(String log) {
        Log.d(TAG, log);
    }
}
