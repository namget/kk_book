package com.namget.ui.first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.namget.data.model.Book;
import com.namget.ui.base.DisposableViewModel;

import java.util.ArrayList;
import java.util.List;

public class FirstViewModel extends DisposableViewModel {

    private final MutableLiveData<List<Book>> books = new MutableLiveData<>();
    private final List<Book> bookList = new ArrayList<>();

    LiveData<List<Book>> getBooks() {
        return books;
    }

    private boolean isOverlap(Book book) {
        for (Book b : bookList) {
            if (b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    void putData(Book book) {
        if (!isOverlap(book)) {
            bookList.add(book);
            books.setValue(bookList);
        }
    }

}
