package com.themehedi.findthing.splashScreenActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.themehedi.findthing.R;
import com.themehedi.findthing.loginActivity.views.LoginActivity;
import com.themehedi.findthing.mainActivity.views.MainActivity;
import com.themehedi.findthing.utils.SessionManager;
import com.themehedi.findthing.utils.StaticMethod;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(SessionManager.getBooleanValue(StaticMethod.IS_LOGIN, SplashScreenActivity.this)){

                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                else {

                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        },4000);
    }
}