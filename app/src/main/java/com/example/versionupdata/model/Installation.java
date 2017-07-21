package com.example.versionupdata.model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by Administrator on 2017/7/21.
 *
 * 安装apk
 */


public class Installation {

    public static void  installationApk(Activity activity, File file){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://"+ file.getAbsolutePath()), "application/vnd.android.package-archive");
        activity.startActivity(intent);
    }
}
