package com.namget.ui.second;

import com.namget.data.source.BookDataSource;
import com.namget.ui.base.DisposableViewModel;

public class SecondViewModel extends DisposableViewModel {

    private BookDataSource bookRepository;

    public SecondViewModel(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

}
