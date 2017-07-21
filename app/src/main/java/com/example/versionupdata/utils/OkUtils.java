package com.example.versionupdata.utils;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/7/21.
 */

public class OkUtils {

    private static OkHttpClient okHttpClient=null;

    private OkUtils(){

    }

    public static OkHttpClient getInstance(){
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){
                if(okHttpClient==null){
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
}
