package com.namget.ui.second;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.namget.R;
import com.namget.data.source.BookDataSource;
import com.namget.data.source.BookRepository;
import com.namget.databinding.ActivitySecondBinding;
import com.namget.ui.base.BaseActivity;

public class SecondActivity extends BaseActivity<ActivitySecondBinding> {

    private SecondViewModelFactory secondViewModelFactory;
    private SecondViewModel secondViewModel;
    private BookDataSource bookRepository = BookRepository.getInstance();


    @Override
    protected int onLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initViewModel();
    }

    private void initViewModel() {
        secondViewModelFactory = new SecondViewModelFactory(bookRepository);
        secondViewModel = ViewModelProviders.of(this, secondViewModelFactory).get(SecondViewModel.class);
    }


}

