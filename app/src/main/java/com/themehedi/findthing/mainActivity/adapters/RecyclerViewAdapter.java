package com.themehedi.findthing.mainActivity.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.themehedi.findthing.BuildConfig;
import com.themehedi.findthing.R;
import com.themehedi.findthing.mainActivity.models.datamodels.DealsProductDataModel;
import com.themehedi.findthing.mainActivity.views.MainActivity;
import com.themehedi.findthing.utils.SessionManager;
import com.themehedi.findthing.utils.StaticMethod;
import com.themehedi.findthing.viewDetailsActivity.views.ViewDetailsActivity;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<DealsProductDataModel.Datum> datumList;

    public RecyclerViewAdapter(Context context, List<DealsProductDataModel.Datum> datumList) {

        this.context = context;
        this.datumList = datumList;

//        this.context = context;
//        this.deliveryDataModels = deliveryDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_item1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        ViewHolder viewHolder = holder;
        viewHolder.productTitle.setText(datumList.get(position).getTitle());
        viewHolder.productDescription.setText(datumList.get(position).getDescription());
        viewHolder.productPrice.setText("TK " + datumList.get(position).getDiscountedPrice());

        Glide.with(context)
                .load(datumList.get(position).getImage())
                .placeholder(R.drawable.profile)
                .into(viewHolder.productImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ViewDetailsActivity.class);
                intent.putExtra("1", datumList.get(position).getImage());
                intent.putExtra("2", datumList.get(position).getTitle());
                intent.putExtra("3", datumList.get(position).getDescription());
                intent.putExtra("4", "TK " + datumList.get(position).getDiscountedPrice());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return datumList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView productTitle, productDescription, productPrice;
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productTitle = itemView.findViewById(R.id.productTitle);
            productDescription = itemView.findViewById(R.id.productDescription);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);

        }
    }



}