package com.namget.ui.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;

import com.namget.R;
import com.namget.data.model.Book;
import com.namget.databinding.ActivityFirstBinding;
import com.namget.ui.base.BaseActivity;
import com.namget.ui.second.SecondActivity;
import com.namget.util.Constant;

public class FirstActivity extends BaseActivity<ActivityFirstBinding> {

    private FirstViewModelFactory firstViewModelFactory;
    private FirstViewModel firstViewModel;

    @Override
    protected int onLayoutId() {
        return R.layout.activity_first;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initToolbar();
        initViewModel();
        observeData();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
    }

    private void initViewModel() {
        firstViewModelFactory = new FirstViewModelFactory();
        firstViewModel = ViewModelProviders.of(this, firstViewModelFactory).get(FirstViewModel.class);
    }

    private void observeData() {
        firstViewModel.getBooks().observe(this, list -> {
            int sum = 0;
            for (Book book : list) {
                sum += book.getSalePrice();
            }
            binding.leftMoneyTxt.setText(String.valueOf(sum));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        binding.toolbar.setTitle("");
        SearchView searchView = (SearchView) binding.toolbar.getMenu().findItem(R.id.action_search).getActionView();
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra(Constant.DATA, query);
                startActivityForResult(intent, Constant.DATA_REQ_CODE);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.DATA_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.hasExtra(Constant.RESULT_DATA)) {
                    firstViewModel.putData(data.getParcelableExtra(Constant.RESULT_DATA));
                }
            }
        }
    }
}
