package com.example.versionupdata.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2017/7/21.
 */

public class PackageUtils {

    public static String getCurrentVersion(Activity activity) throws PackageManager.NameNotFoundException {
        PackageManager pm = activity.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(activity.getPackageName(), PackageManager.GET_CONFIGURATIONS);
        return pi.versionName;

    }
}
