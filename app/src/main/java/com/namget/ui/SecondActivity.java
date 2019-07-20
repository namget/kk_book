package com.namget.ui;

import android.os.Bundle;

import com.namget.R;
import com.namget.databinding.ActivitySecondBinding;
import com.namget.ui.base.BaseActivity;

public class SecondActivity extends BaseActivity<ActivitySecondBinding> {

    @Override
    protected int onLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
