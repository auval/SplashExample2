package com.mindtheapps.splash2sample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

/**
 * Created by amir on 1/7/17.
 */
public class LaunchActivity extends Activity {
    private final Runnable launcher = new Runnable() {
        @Override
        public void run() {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            boolean splash_enabled = preferences.getBoolean("splash_enabled", true);
            if (splash_enabled) { // can skip this in debug mode by using: && !BuildConfig.DEBUG
                Intent intent = new Intent(getBaseContext(), SplashActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getBaseContext(), CdActivity.class);
                startActivity(intent);
            }
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(launcher).start();
    }

}
