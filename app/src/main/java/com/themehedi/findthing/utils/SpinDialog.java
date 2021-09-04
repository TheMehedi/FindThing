package com.themehedi.findthing.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;

import com.themehedi.findthing.R;

public class SpinDialog {
    AlertDialog alertDialog;
    //private final Dialog dialog;
    ProgressBar progressBar;

    public SpinDialog(Context mContext, boolean cancelable) {
        LayoutInflater li = LayoutInflater.from(mContext);
        final View view = li.inflate(R.layout.spin_loading, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        alertDialogBuilder.setView(view);

        alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(cancelable);
        //	alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        progressBar = (ProgressBar) view.findViewById(R.id.spin_kit);
        //Wave wave = new Wave();
        //progressBar.setIndeterminateDrawable(wave);
    }

    public void show() {
        try {
            alertDialog.show();

        } catch (Exception e) {

        }
    }

    public void dismiss() {
        alertDialog.cancel();
    }

}