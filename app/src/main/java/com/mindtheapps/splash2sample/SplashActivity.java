package com.mindtheapps.splash2sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by amir on 1/7/17.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void onButtonClicked(View view) {

        // set shared prefs flag
        new Thread(new Runnable() {
            @Override
            public void run() {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("splash_enabled", false);
                editor.apply();

                finish();
            }
        }).start();

        Intent intent = new Intent(getBaseContext(), CdActivity.class);
        startActivity(intent);

    }
}
