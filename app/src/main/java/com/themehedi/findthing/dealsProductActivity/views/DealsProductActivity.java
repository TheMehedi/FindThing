package com.themehedi.findthing.dealsProductActivity.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.themehedi.findthing.R;
import com.themehedi.findthing.dealsProductActivity.adapters.DealsProductAdapter;
import com.themehedi.findthing.mainActivity.views.MainActivity;

public class DealsProductActivity extends AppCompatActivity {

    private RecyclerView dealsProductRecyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals_product);


        dealsProductRecyclerView = findViewById(R.id.dealsProductRecyclerView);
        toolbar = findViewById(R.id.toolbarProfile);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Deals Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //What to do on back clicked
                onBackPressed();
            }
        });

        dealsProductRecyclerView.setLayoutManager(new LinearLayoutManager(DealsProductActivity.this, LinearLayoutManager.VERTICAL, false));
        dealsProductRecyclerView.setAdapter(new DealsProductAdapter(DealsProductActivity.this, MainActivity.dealsProductDataModel.getData()));

    }
}