package com.example.versionupdata.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.versionupdata.model.DownLoad;

/**
 * Created by Administrator on 2017/7/21.
 */

public class DialogUtils {

    public static void getDialog(final Activity activity, String title, String mes, final String url){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(mes);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                downNewApk(activity,url);
            }
        });
        builder.show();

    }

    private static void downNewApk(Activity act,String url) {
        DownLoad.downApk(act,url);
    }


}
