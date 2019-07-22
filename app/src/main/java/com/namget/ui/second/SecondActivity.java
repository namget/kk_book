package com.namget.ui.second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.namget.R;
import com.namget.data.source.BookDataSource;
import com.namget.data.source.BookRepository;
import com.namget.databinding.ActivitySecondBinding;
import com.namget.ui.base.BaseActivity;
import com.namget.ui.second.adapter.SecondAdapter;
import com.namget.util.Constant;

public class SecondActivity extends BaseActivity<ActivitySecondBinding> {

    private SecondViewModel secondViewModel;
    private BookDataSource bookRepository = BookRepository.getInstance();
    private String query;
    private SecondAdapter secondAdapter;
    private int page = 1;
    private final String TAG = "SecondActivity";

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        secondAdapter = new SecondAdapter(diffUtil, secondViewModel);
        recyclerView.setAdapter(secondAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                //최상단
                /*if (recyclerView.canScrollVertically(1)) {

                }*/
                //최하단
                if (recyclerView.canScrollVertically(-1)) {
                    if (recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() != 0) {
                        if (secondViewModel.getIsEnd().getValue() != null && !secondViewModel.getIsEnd().getValue()) {
                            secondViewModel.searchList(query, ++page);
                        }
                    }
                }

            }
        });
    }

    private void initViewModel() {
        SecondViewModelFactory secondViewModelFactory = new SecondViewModelFactory(bookRepository);
        secondViewModel = ViewModelProviders.of(this, secondViewModelFactory).get(SecondViewModel.class);
    }

    private void observeData() {
        secondViewModel.getBookList().observe(this, books -> {
            if (secondAdapter != null) {
                if (books.size() == 0) {
                    binding.bookResultTxt.setVisibility(View.VISIBLE);
                } else {
                    binding.bookResultTxt.setVisibility(View.GONE);
                }
                secondAdapter.submitList(books);
            }
        });
        secondViewModel.getIsLoading().observe(this, isLoading -> {
            if (isLoading) {
                binding.loadingBar.setVisibility(View.VISIBLE);
            } else {
                binding.loadingBar.setVisibility(View.GONE);
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

