package io.github.rahsyarigami.infonunukan.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideHelper {
    public static void setImageFromUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .into(imageView);
    }
}
