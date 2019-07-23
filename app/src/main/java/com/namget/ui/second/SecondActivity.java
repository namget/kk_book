package com.namget.ui.second;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.namget.R;
import com.namget.ViewModelFactory;
import com.namget.data.source.BookDataSource;
import com.namget.data.source.BookRepository;
import com.namget.databinding.ActivitySecondBinding;
import com.namget.ui.base.BaseActivity;
import com.namget.ui.second.adapter.SecondAdapter;
import com.namget.util.Constant;
import com.namget.util.LogUtil;


public class SecondActivity extends BaseActivity<ActivitySecondBinding> {

    private SecondViewModel secondViewModel;
    private BookDataSource bookRepository = BookRepository.getInstance();
    private String query;
    private SecondAdapter secondAdapter;
    private int page = 1;

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
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        secondAdapter = new SecondAdapter(secondViewModel);
        recyclerView.setAdapter(secondAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                //최상단
                /*if (!recyclerView.canScrollVertically(-1)) {

                }*/
                //최하단
                if (!recyclerView.canScrollVertically(1)) {
                    if (recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() != 0) {
                        if (secondViewModel.getIsEnd().getValue() != null && !secondViewModel.getIsEnd().getValue() &&
                                secondViewModel.getIsLoading().getValue() != null && !secondViewModel.getIsLoading().getValue()) {
                            LogUtil.e("test", "canScrollVertically : ");
                            secondViewModel.searchList(query, ++page);
                        }
                    }
                }

            }
        });
    }

    private void initViewModel() {
        ViewModelFactory viewModelFactory = new ViewModelFactory(bookRepository);
        secondViewModel = ViewModelProviders.of(this, viewModelFactory).get(SecondViewModel.class);
        binding.setViewmodel(secondViewModel);
    }

    private void observeData() {
        secondViewModel.getBookList().observe(this, books -> {
            if (secondAdapter != null) {
                secondAdapter.updateList(books);
            }
        });

        secondViewModel.getItemClicked().observe(this, result -> {
            Intent intent = new Intent();
            intent.putExtra(Constant.RESULT_DATA, result);
            setResult(RESULT_OK, intent);
            finish();
        });


        secondViewModel.searchList(query, page);
    }
}

