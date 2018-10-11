package com.xperttech.application;

import android.app.Application;

/**
 * Created by
 */

public class BaseApplication extends Application {

    private static BaseApplication baseApplication = null;

    public static BaseApplication getBaseApplication() {
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;

    }
}