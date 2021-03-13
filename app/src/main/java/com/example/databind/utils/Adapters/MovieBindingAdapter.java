package com.example.databind.utils.Adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.databind.R;
import com.squareup.picasso.Picasso;

public class MovieBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url){
        Picasso.with(imageView.getContext()).load(url).into(imageView);
//        Glide.with(imageView.getContext())
//                .setDefaultRequestOptions(new RequestOptions()
//                        .circleCrop())
//                .load(url)
//                .into(imageView);
    }
}
