package hr.svizec.cookbook;

import android.content.res.Configuration;

import com.activeandroid.ActiveAndroid;

public class Application extends com.activeandroid.app.Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        ActiveAndroid.dispose();
    }

}