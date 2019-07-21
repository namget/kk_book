package com.namget.ui.second;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.namget.R;
import com.namget.data.model.Book;
import com.namget.data.source.BookDataSource;
import com.namget.data.source.BookRepository;
import com.namget.databinding.ActivitySecondBinding;
import com.namget.ui.base.BaseActivity;
import com.namget.ui.second.adapter.SecondAdapter;
import com.namget.util.Constant;

import java.util.ArrayList;

public class SecondActivity extends BaseActivity<ActivitySecondBinding> {

    private SecondViewModelFactory secondViewModelFactory;
    private SecondViewModel secondViewModel;
    private BookDataSource bookRepository = BookRepository.getInstance();
    private String query;
    private SecondAdapter secondAdapter;


    @Override
    protected int onLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void getData() {
        if (getIntent().hasExtra(Constant.DATA)) {
            query = getIntent().getStringExtra(Constant.DATA);
        }
    }

    private void init() {
        getData();
        initViewModel();
        initRecyclerView();
        observeData();
    }

    private void initRecyclerView() {
        SecondDiffUtil diffUtil = new SecondDiffUtil();
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
        secondAdapter = new SecondAdapter(diffUtil);
        recyclerView.setAdapter(secondAdapter);
    }

    private void initViewModel() {
        secondViewModelFactory = new SecondViewModelFactory(bookRepository);
        secondViewModel = ViewModelProviders.of(this, secondViewModelFactory).get(SecondViewModel.class);
    }

    private void observeData(){
        secondViewModel.getBookList().observe(this, books -> {
            if (secondAdapter != null) {
                secondAdapter.submitList(books);
            }
        });

        secondViewModel.searchList(query, 1);
    }
}

