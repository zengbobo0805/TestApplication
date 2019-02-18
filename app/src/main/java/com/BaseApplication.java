package com;

import android.app.Application;
import android.os.Debug;
import android.os.Environment;

import com.utils.LogUtil;

import java.io.File;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        File file =  new File(Environment.getExternalStorageDirectory(), "/HJTrace.trace");
//        File file = new File(getCacheDir(), "/HJTrace.trace");
        //onCreate path:/data/user/0/com.hj/files/HJTrace.trace
        LogUtil.i("HJApplication onCreate path:"+file.getAbsolutePath());
        if (!file.exists()) {
            LogUtil.i("HJApplication onCreate ---1:");
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.i("HJApplication onCreate ---2:"+e.getMessage());
            }
        }

        Debug.startMethodTracing(file.getAbsolutePath());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Debug.stopMethodTracing();
    }
}
