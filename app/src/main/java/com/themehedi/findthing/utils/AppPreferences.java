package com.themehedi.findthing.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    Context context;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public AppPreferences(Context context) {

        this.context = context;
        preferences = this.context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public void setLoginStatus(boolean status){

        editor = preferences.edit();
        editor.putBoolean("loginStatus",status);
        editor.apply();
    }

    public boolean getLoginStatus(){

        return preferences.getBoolean("loginStatus", false);
    }



}
