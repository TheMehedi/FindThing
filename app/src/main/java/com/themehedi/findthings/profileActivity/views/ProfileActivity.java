package com.themehedi.findthings.profileActivity.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.themehedi.findthings.BuildConfig;
import com.themehedi.findthings.R;
import com.themehedi.findthings.utils.SessionManager;
import com.themehedi.findthings.utils.StaticMethod;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView imageView;
    private TextView fullNameTvId, emailTvId, phoneTvId, addressTvId;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //What to do on back clicked
                onBackPressed();
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();

        Glide.with(ProfileActivity.this)
                .load(BuildConfig.BASE_IMAGE_URL + SessionManager.getStringValue(StaticMethod.IMAGE, ProfileActivity.this))
                .placeholder(R.drawable.profile)
                .into(imageView);

        fullNameTvId.setText(SessionManager.getStringValue(StaticMethod.NAME, ProfileActivity.this));
        emailTvId.setText(SessionManager.getStringValue(StaticMethod.EMAIL, ProfileActivity.this));
        phoneTvId.setText(SessionManager.getStringValue(StaticMethod.PHONE, ProfileActivity.this));
        addressTvId.setText(SessionManager.getStringValue(StaticMethod.AREA_NAME, ProfileActivity.this) + ", " + SessionManager.getStringValue(StaticMethod.DISTRICT_NAME, ProfileActivity.this) + ", " + SessionManager.getStringValue(StaticMethod.DIVISION_NAME, ProfileActivity.this));

    }

    private void initViews() {

        toolbar = findViewById(R.id.toolbarProfile);
        imageView = findViewById(R.id.imageView);
        fullNameTvId = findViewById(R.id.fullNameTvId);
        emailTvId = findViewById(R.id.emailTvId);
        phoneTvId = findViewById(R.id.phoneTvId);
        addressTvId = findViewById(R.id.addressTvId);

    }
}