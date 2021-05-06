package com.themehedi.findthing.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.themehedi.findthing.R;
import com.themehedi.findthing.extension.services.AppPreferences;

public class WelcomeActivity extends AppCompatActivity {

    private AppPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        preferences = new AppPreferences(WelcomeActivity.this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(preferences.getLoginStatus()){

                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {

                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        },4000);
    }
}