package com.vistagram.config;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.onesignal.OneSignal;
import com.orm.Database;
import com.orm.SugarApp;

/**
 * Created by Android on 11/24/2017.
 */

public class AppConfiguration extends MultiDexApplication {


    private Database database;
    private static AppConfiguration sugarContext;
    static Context context;

    public static Context getContext() {
        return context;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void onCreate() {
        super.onCreate();

        context=getApplicationContext();
        AppConfiguration.sugarContext = this;
        this.database = new Database(this);

      //  FirebaseApp.initializeApp(this);
       // FirebaseApp.getApps(this);

//        FirebaseInstanceId.getInstance().getToken();



        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }

    public void onTerminate() {
        if (this.database != null) {
            this.database.getDB().close();
        }
        super.onTerminate();
    }

    public static AppConfiguration getSugarContext() {
        return sugarContext;
    }

    protected Database getDatabase() {
        return database;
    }


}
