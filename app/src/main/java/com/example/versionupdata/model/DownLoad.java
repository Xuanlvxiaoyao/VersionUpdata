package com.example.versionupdata.model;

import android.app.Activity;
import android.os.Environment;

import com.example.versionupdata.utils.OkUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/21.
 */

public class DownLoad {

    public static void downApk(final Activity activity, String url){
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = OkUtils.getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] bytes = response.body().bytes();

                File file=new File(Environment.getExternalStorageDirectory()+"/apkfile");
                if(!file.exists()){
                    file.mkdirs();
                }
                File file1=new File(file,"myapk.apk");
                if(!file1.exists()){
                    file.createNewFile();
                }

                FileOutputStream outputStream=new FileOutputStream(file1);
                outputStream.write(bytes);
                outputStream.close();

                bytes=null;

                Installation.installationApk(activity,file1);
            }
        });
    }
}
