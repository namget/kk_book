package com.namget.ui.second;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.namget.data.source.BookDataSource;

class SecondViewModelFactory implements ViewModelProvider.Factory {

    private final BookDataSource bookRepository;

    SecondViewModelFactory(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SecondViewModel(bookRepository);
    }
}
