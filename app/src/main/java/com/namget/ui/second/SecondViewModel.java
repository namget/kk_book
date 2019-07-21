package com.namget.ui.second;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.namget.data.model.Book;
import com.namget.data.source.BookDataSource;
import com.namget.ui.base.DisposableViewModel;
import com.namget.util.LogUtil;

import java.util.ArrayList;

import io.reactivex.Single;

public class SecondViewModel extends DisposableViewModel {

    private BookDataSource bookRepository;
    private final MutableLiveData<ArrayList<Book>> bookList = new MutableLiveData<>();

    public LiveData<ArrayList<Book>> getBookList() {
        return bookList;
    }

    public SecondViewModel(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void searchList(String query, int page) {
        addDisposable(bookRepository.searchBook(query, page)
                .subscribe(
                response -> {
//                    LogUtil.e("test", "success");
                    ArrayList<Book> books = response.getResults();
                    bookList.postValue(books);
                },
                onError -> {
//                    LogUtil.e("test", "error", onError);
                }
        ));
    }


}
