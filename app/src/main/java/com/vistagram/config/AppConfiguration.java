package com.vistagram.config;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.orm.Database;
import com.orm.SugarApp;

/**
 * Created by Android on 11/24/2017.
 */

public class AppConfiguration extends Application {
    private static AppConfiguration instance;

    private Database database;
    private static AppConfiguration sugarContext;

    public static synchronized AppConfiguration getInstance() {
        return instance;
    }

    public void onCreate() {
        super.onCreate();
        AppConfiguration.sugarContext = this;
        this.database = new Database(this);
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

    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

}
