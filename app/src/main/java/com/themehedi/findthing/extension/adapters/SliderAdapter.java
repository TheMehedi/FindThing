package com.themehedi.findthing.extension.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.themehedi.findthing.R;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems() {
        notifyDataSetChanged();
    }

//    public void deleteItem(int position) {
//        this.mSliderItems.remove(position);
//        notifyDataSetChanged();
//    }

//    public void addItem(SliderItem sliderItem) {
//        this.mSliderItems.add(sliderItem);
//        notifyDataSetChanged();
//    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        //String imageUrl = ApiClient.IMAGE_BASE_URL+"banner/jpg/"+bannerChildModel.getImage();

        Glide.with(viewHolder.itemView)
                .load("").apply(new RequestOptions()
                .error(R.drawable.promo_banner))
                .into(viewHolder.imageViewBackground);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }

    static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }
    }

}
