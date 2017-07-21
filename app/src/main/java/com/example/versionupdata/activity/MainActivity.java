package com.example.versionupdata.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.example.versionupdata.R;
import com.example.versionupdata.bean.Data;
import com.example.versionupdata.utils.DialogUtils;
import com.example.versionupdata.utils.OkUtils;
import com.example.versionupdata.utils.PackageUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Callback {

    private String path="https://guaju.github.io/versioninfo.json";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        versionUpdata();
    }

    private void versionUpdata() {


        Request request = new Request.Builder()
                .url(path)
                .build();

        Call call = OkUtils.getInstance().newCall(request);
        call.enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String string = response.body().string();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(!TextUtils.isEmpty(string)){
                    analysis(string);
                }
            }
        });
    }

    //解析
    private void analysis(String string) {
        Gson gson=new Gson();
        Data data = gson.fromJson(string, Data.class);

        String currentVersion = null;
        try {
            currentVersion = PackageUtils.getCurrentVersion(this);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if(!TextUtils.isEmpty(currentVersion)){
            if(!data.getData().getVersion().equals(currentVersion)){
                Log.e(TAG, "analysis: "+data.getData().getVersion());
                DialogUtils.getDialog(this,"升级版本",data.getData().getInfo(),data.getData().getAppurl());
            }
        }
    }
}
