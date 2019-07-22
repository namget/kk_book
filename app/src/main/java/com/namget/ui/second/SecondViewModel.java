package com.namget.ui.second;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.namget.data.model.Book;
import com.namget.data.model.Meta;
import com.namget.data.source.BookDataSource;
import com.namget.ui.base.DisposableViewModel;
import com.namget.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class SecondViewModel extends DisposableViewModel {

    private final BookDataSource bookRepository;
    private final MutableLiveData<List<Book>> bookList = new MutableLiveData<>();

    LiveData<List<Book>> getBookList() {
        return bookList;
    }

    private final MutableLiveData<Boolean> isEnd = new MutableLiveData<>();

    LiveData<Boolean> getIsEnd() {
        return isEnd;
    }

    private final MutableLiveData<Book> ItemClicked = new MutableLiveData<>();

    LiveData<Book> getItemClicked() {
        return ItemClicked;
    }

    private final List<Book> books = new ArrayList<>();

    public SecondViewModel(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

    void searchList(String query, int page) {
        isLoading.setValue(true);
        addDisposable(bookRepository.searchBook(query, page)
                .map(bookResponse -> {
                    List<Book> books = new ArrayList<>();
                    for (Book book : bookResponse.getResults()) {
                        book.setTitle(setFilteredTitle(book.getTitle()));
                        book.setSalePrice(setFilteredPrice(book.getPrice(), book.getSalePrice()));
                        books.add(book);
                        LogUtil.e("book", "book : " + book.getTitle());
                    }
                    bookResponse.setResults(books);
                    return bookResponse;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            books.addAll(response.getResults());
                            Meta meta = response.getMetaData();
                            bookList.setValue(books);
                            isEnd.setValue(meta.isEnd());
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

    private String setFilteredTitle(String title) {
        while (title.contains("(") && title.contains(")")) {
            StringBuilder stringBuffer = new StringBuilder(title);
            stringBuffer.replace(title.indexOf("("), title.indexOf(")") + 1, "");
            title = stringBuffer.toString();
        }
        return title;
    }

    private int setFilteredPrice(int price, int discountedPrice) {
        //90퍼 - 판매가격 > 0 => price의 90퍼도 안된다.
        if ((price * 0.9) - discountedPrice > 0 && discountedPrice > 0) {
            discountedPrice *= -1;
        }
        return discountedPrice;
    }


}
