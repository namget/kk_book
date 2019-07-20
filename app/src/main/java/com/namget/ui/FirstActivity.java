package com.namget.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.namget.R;
import com.namget.databinding.ActivityFirstBinding;
import com.namget.ui.base.BaseActivity;

public class FirstActivity extends BaseActivity<ActivityFirstBinding> {

    @Override
    protected int onLayoutId() {
        return R.layout.activity_first;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
