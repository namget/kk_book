package com.namget.ui.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.namget.util.GlideUtil;

public class MyBindingAdapter {

    @BindingAdapter("android:filteredText")
    public static void setFilteredTitle(TextView textView, String title) {
        while (title.contains("(") && title.contains(")")) {
            StringBuffer stringBuffer = new StringBuffer(title);
            stringBuffer.replace(title.indexOf("("), title.indexOf(")") + 1, "");
            title = stringBuffer.toString();
        }
        textView.setText(title);
    }

    @BindingAdapter("android:glideImage")
    public static void setImageResource(ImageView imageView, String url) {
        GlideUtil.setGlide(imageView, url);
    }
}
