package com.themehedi.findthings.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {

    // save value to sharedPreferences
    public static void setStringValue(String key, String value, Context context) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();

        editor.putString(key, value);
        editor.commit();

    }

    public static void setIntValue(String key, int value, Context context) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();

        editor.putInt(key, value);
        editor.commit();

    }


    public static int getIntValue(String key, Context context) {
        SharedPreferences preferences;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);
    }

    public static String getStringValue(String key, Context context) {
        SharedPreferences preferences;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    public static void setBooleanValue(String key, boolean isChecked, Context context) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putBoolean(key, isChecked);
        editor.commit();

    }

    public static boolean getBooleanValue(String key, Context context) {
        SharedPreferences preferences;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);

    }

}
