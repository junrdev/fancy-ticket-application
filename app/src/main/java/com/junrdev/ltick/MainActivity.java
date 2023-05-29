package com.junrdev.ltick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    //duration of splash activity
    private final long SPLASH_DELAY_TIME = 3000;
    private static final String PREF_SPLASH_SHOWN = "splash_shown";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean splashShown = preferences.getBoolean(PREF_SPLASH_SHOWN, false);

        if(!splashShown){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(PREF_SPLASH_SHOWN, true);
            editor.apply();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent _splash_intent = new Intent(MainActivity.this, home_navigationhost.class);
                    startActivity(_splash_intent);
                }
            }, SPLASH_DELAY_TIME);
        }else{
            Intent intent = new Intent(MainActivity.this, home_navigationhost.class);
            startActivity(intent);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(PREF_SPLASH_SHOWN, false);
            editor.apply();
            finish();
        }
    }

}