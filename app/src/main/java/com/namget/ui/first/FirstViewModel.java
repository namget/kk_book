package com.namget.ui.first;

import com.namget.data.source.BookDataSource;
import com.namget.ui.base.DisposableViewModel;

public class FirstViewModel extends DisposableViewModel {
    private BookDataSource bookRepository;

    public FirstViewModel(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

}
