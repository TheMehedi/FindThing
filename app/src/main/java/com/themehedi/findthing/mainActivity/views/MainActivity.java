package com.themehedi.findthing.mainActivity.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.themehedi.findthing.BuildConfig;
import com.themehedi.findthing.R;
import com.themehedi.findthing.loginActivity.views.LoginActivity;
import com.themehedi.findthing.mainActivity.adapters.SliderAdapter;
import com.themehedi.findthing.profileActivity.views.ProfileActivity;
import com.themehedi.findthing.utils.SessionManager;
import com.themehedi.findthing.utils.StaticMethod;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private SliderView sliderView;
    private SliderAdapter adapter;
    private CircleImageView profileImage;
    private TextView userName, userNumber;
    private LinearLayout linearLayout;
    private LinearLayout logoutLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        Glide.with(MainActivity.this)
                .load(BuildConfig.BASE_IMAGE_URL + SessionManager.getStringValue(StaticMethod.IMAGE, MainActivity.this))
                .placeholder(R.drawable.profile)
                .into(profileImage);

        userName.setText(SessionManager.getStringValue(StaticMethod.NAME, MainActivity.this));
        userNumber.setText("+88" + SessionManager.getStringValue(StaticMethod.PHONE, MainActivity.this));


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        logoutLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertView();
            }
        });

        adapter = new SliderAdapter(getApplicationContext());
        sliderView.setSliderAdapter(adapter);
        adapter.renewItems();
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    private void initViews() {

        sliderView = findViewById(R.id.imageSlider);
        profileImage = findViewById(R.id.profileImage);
        userName = findViewById(R.id.userName);
        userNumber = findViewById(R.id.userNumber);
        linearLayout = findViewById(R.id.linearLayout);
        logoutLinearLayout = findViewById(R.id.logoutLinearLayout);
    }

    @Override
    public void onBackPressed() {

        finish();
    }


    private void alertView() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle( "Logout" )
                .setIcon(R.drawable.cover)
                .setMessage("Are you sure you want to logout?")

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }})

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {

                        SessionManager.setBooleanValue(StaticMethod.IS_LOGIN, false, MainActivity.this);
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }).show();
    }
}