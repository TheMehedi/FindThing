package com.themehedi.findthing.ui.activities.splashScreenActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.themehedi.findthing.R;
import com.themehedi.findthing.extension.services.AppPreferences;
import com.themehedi.findthing.ui.activities.loginActivity.view.LoginActivity;
import com.themehedi.findthing.ui.activities.mainActivity.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private AppPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        preferences = new AppPreferences(SplashScreenActivity.this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(preferences.getLoginStatus()){

                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {

                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        },4000);
    }
}