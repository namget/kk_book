package com.namget.ui.first;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;
import com.namget.R;
import com.namget.data.source.BookDataSource;
import com.namget.data.source.BookRepository;
import com.namget.databinding.ActivityFirstBinding;
import com.namget.ui.base.BaseActivity;

public class FirstActivity extends BaseActivity<ActivityFirstBinding> {

    private FirstViewModelFactory firstViewModelFactory;
    private FirstViewModel firstViewModel;
    private BookDataSource bookRepository = BookRepository.getInstance();

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
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
    }

    private void initViewModel(){
        firstViewModelFactory = new FirstViewModelFactory(bookRepository);
        firstViewModel = ViewModelProviders.of(this,firstViewModelFactory).get(FirstViewModel.class);
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
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }
}
