package com.themehedi.findthing.viewDetailsActivity.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.themehedi.findthing.R;

public class ViewDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String d1, d2, d3, d4;
    private ImageView productImage;
    private TextView productTitle, productPrice, productDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);


        toolbar = findViewById(R.id.toolbarProfile);
        productImage = findViewById(R.id.productImage);
        productTitle = findViewById(R.id.productTitle);
        productPrice = findViewById(R.id.productPrice);
        productDescription = findViewById(R.id.productDescription);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("View Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //What to do on back clicked
                onBackPressed();
            }
        });

        d1 = getIntent().getExtras().getString("1");
        d2 = getIntent().getExtras().getString("2");
        d3 = getIntent().getExtras().getString("3");
        d4 = getIntent().getExtras().getString("4");


        Glide.with(ViewDetailsActivity.this)
                .load(d1)
                .placeholder(R.drawable.profile)
                .into(productImage);


        productTitle.setText(d2);
        productPrice.setText(d4);
        productDescription.setText(d3);
    }
}