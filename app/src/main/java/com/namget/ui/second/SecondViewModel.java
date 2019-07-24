package com.namget.ui.second;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.namget.SingleLiveEvent;
import com.namget.data.model.Book;
import com.namget.data.source.BookDataSource;
import com.namget.ui.base.DisposableViewModel;
import com.namget.util.LogUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class SecondViewModel extends DisposableViewModel {
    public SecondViewModel(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final BookDataSource bookRepository;
    private final MutableLiveData<List<Book>> bookList = new MutableLiveData<>();

    public LiveData<List<Book>> getBookList() {
        return bookList;
    }

    private final MutableLiveData<Boolean> isEnd = new MutableLiveData<>();

    LiveData<Boolean> getIsEnd() {
        return isEnd;
    }

    private final SingleLiveEvent<Book> ItemClicked = new SingleLiveEvent<>();

    LiveData<Book> getItemClicked() {
        return ItemClicked;
    }

    void searchList(String query, int page) {
        isLoading.setValue(true);
        addDisposable(bookRepository.searchBook(query, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            isEnd.setValue(response.first);
                            bookList.setValue(response.second);
                            isLoading.setValue(false);
                            LogUtil.e("test", "success");
                        },
                        onError -> {
                            isLoading.setValue(false);
                            LogUtil.e("test", "error", onError);
                        }
                ));
    }

    public void ItemClick(View view, Book book) {
        ItemClicked.setValue(book);
    }


}
