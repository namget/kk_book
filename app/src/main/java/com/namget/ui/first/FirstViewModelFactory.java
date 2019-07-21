package com.namget.ui.first;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.namget.data.source.BookDataSource;

public class FirstViewModelFactory implements ViewModelProvider.Factory {
    BookDataSource bookRepository;

    public FirstViewModelFactory(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) (new FirstViewModel(bookRepository));
    }
}
