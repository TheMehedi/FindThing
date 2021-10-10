package com.themehedi.findthings.utils;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods {
    Context mContext;
    ProgressDialog progressDialog;
    boolean isLoggable = true;
    Dialog myDialog;

    public CommonMethods(Context context) {
        this.mContext = context;
    }

    public void showProgressDialog(String text) {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage(text);
        progressDialog.show();

        // To Dismiss progress dialog
        //progressDialog.dismiss();
    }


    public void hideProgressDialog() {
        progressDialog = new ProgressDialog(mContext);
        // To Dismiss progress dialog
        progressDialog.dismiss();
    }


    public void showMatDialog(final Context c, final String title,
                              final String message) {
        new MaterialAlertDialogBuilder(c)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
                .show();
    }

    public String getCurrentDate() {
        SimpleDateFormat currentDate = new SimpleDateFormat("d,MMMM,yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        return thisDate;
    }

    public boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    public double convertToDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch (Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        } else return 0;
    }

    public int convertToInteger(String temp) {
        int result = 0;
        if (temp != null && temp.trim().length() > 0) {
            String a = temp;
            //replace all commas if present with no comma
            String s = a.replaceAll(",", "").trim();
            // if there are any empty spaces also take it out.
            String f = s.replaceAll(" ", "");
            //now convert the string to double
            result = Integer.parseInt(f);
        }

        return result; // return the result
    }


    public void DebuggableLogV(String tag, String message) {
        try {
            if (isLoggable) {
                Log.v(tag, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
