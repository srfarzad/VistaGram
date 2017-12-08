package com.vistagram.helperlibrary;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Android on 11/24/2017.
 */

public class ApplicationManager {

    /**
     * test message
     * @param context
     * @return
     */
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * Used to check app is installed or not
     *
     * @param uri PackageName of application
     */
    public static boolean appInstalledOrNot(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }


}
