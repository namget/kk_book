package com.namget;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.namget.data.source.BookRepository;
import com.namget.ui.second.SecondViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final BookRepository bookRepository;

    public ViewModelFactory(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(SecondViewModel.class)){
            return (T) new SecondViewModel(bookRepository);
        }else {
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        }

    }
}
