package com.namget.util;

import android.util.Log;

import com.namget.BuildConfig;

public class LogUtil {

    //기본생성자 방지
    private LogUtil(){
        throw new AssertionError();
    }

    public static void e(String TAG , String message){
        if(BuildConfig.DEBUG){
            Log.e(TAG,message);
        }
    }

    public static void e(String TAG , String message, Throwable e){
        if(BuildConfig.DEBUG){
            Log.e(TAG,message,e);
        }
    }

    public static void d(String TAG , String message){
        if(BuildConfig.DEBUG){
            Log.e(TAG,message);
        }
    }

    public static void d(String TAG , String message, Throwable d){
        if(BuildConfig.DEBUG){
            Log.e(TAG,message,d);
        }
    }
}
