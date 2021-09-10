package com.themehedi.findthing.wastageProductActivity.views;

import static android.widget.GridLayout.VERTICAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.themehedi.findthing.R;
import com.themehedi.findthing.wastageProductActivity.adapters.WastageProductAdapter;
import com.themehedi.findthing.wastageProductActivity.models.datamodels.WastageProductDataModel;
import com.themehedi.findthing.wastageProductActivity.presenters.WastagePresenter;
import com.themehedi.findthing.wastageProductActivity.presenters.WastagePresenterInterface;

public class WastageProductActivity extends AppCompatActivity  implements WastagePresenterInterface {


    private Toolbar toolbar;
    private WastagePresenter wastagePresenter;
    private RecyclerView wastageProductRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wastage_product);


        toolbar = findViewById(R.id.toolbarProfile);
        wastageProductRecyclerView = findViewById(R.id.wastageProductRecyclerView);

        wastageProductRecyclerView.setLayoutManager(new LinearLayoutManager(WastageProductActivity.this, RecyclerView.VERTICAL, false));
        wastagePresenter = new WastagePresenter(WastageProductActivity.this, this);

        wastagePresenter.wastage();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Wastage Products");
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
    public void onWastageResponse(WastageProductDataModel wastageProductDataModel) {

        if(wastageProductDataModel.getData().size()>0){

            wastageProductRecyclerView.setAdapter(new WastageProductAdapter(WastageProductActivity.this, wastageProductDataModel.getData()));
        }

    }

    @Override
    public void onWastageError(String errMessage) {

    }
}