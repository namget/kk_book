package com.namget.util;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.namget.R;

public class GlideUtil {

    //기본생성자 방지
    private GlideUtil(){
        throw new AssertionError();
    }

    public static void setGlide(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().
                        centerCrop().
                        diskCacheStrategy(DiskCacheStrategy.ALL).
                        error(R.mipmap.ic_launcher))
                .into(imageView);
    }
}
