package com.namget.ui.base;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.namget.util.GlideUtil;

public class MyBindingAdapter {

    @BindingAdapter("android:glideImage")
    public static void setImageResource(ImageView imageView, String url) {
        GlideUtil.setGlide(imageView, url);
    }
}
