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

public class SecondViewModel extends DisposableViewModel {

    private BookDataSource bookRepository;
    private final MutableLiveData<ArrayList<Book>> bookList = new MutableLiveData<>();

    public LiveData<ArrayList<Book>> getBookList() {
        return bookList;
    }

    private final MutableLiveData<Boolean> isEnd = new MutableLiveData<>();

    public LiveData<Boolean> getIsEnd() {
        return isEnd;
    }

    private MutableLiveData<Book> ItemClicked = new MutableLiveData<>();

    public LiveData<Book> getItemClicked() {
        return ItemClicked;
    }

    private ArrayList<Book> bookDatas = new ArrayList<>();


    public SecondViewModel(BookDataSource bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void searchList(String query, int page) {
        isLoading.setValue(true);
        addDisposable(bookRepository.searchBook(query, page)
                .map(bookResponse -> {
                    ArrayList<Book> books = new ArrayList<>();
                    for (Book book : bookResponse.getResults()) {
                        book.setTitle(setFilteredTitle(book.getTitle()));
                        book.setSalePrice(setFilteredPrice(book.getPrice(), book.getSalePrice()));
                        books.add(book);
                        LogUtil.e("book", "book : " + book.getTitle());
                    }
                    bookResponse.setResults(books);
                    return bookResponse;
                })
                .subscribe(
                        response -> {
                            bookDatas.addAll(response.getResults());
                            Meta meta = response.getMetaData();
                            bookList.postValue(bookDatas);
                            isEnd.postValue(meta.isEnd());
                            isLoading.postValue(false);
                            LogUtil.e("test", "success");
                        },
                        onError -> {
                            isLoading.postValue(false);
                            LogUtil.e("test", "error", onError);
                        }
                ));
    }

    public void ItemClick(View view, Book book) {
        ItemClicked.setValue(book);
    }

    private String setFilteredTitle(String title) {
        while (title.contains("(") && title.contains(")")) {
            StringBuffer stringBuffer = new StringBuffer(title);
            stringBuffer.replace(title.indexOf("("), title.indexOf(")") + 1, "");
            title = stringBuffer.toString();
        }
        return title;
    }

    private int setFilteredPrice(int price, int saledPrice) {
//        LogUtil.e("test", "price : " + (price * 0.9) + "price2 : " + saledPrice + "price3 : " + ((price * 0.9) - saledPrice));
        //90퍼 - 판매가격 > 0 => price의 90퍼도 안된다.
        if ((price * 0.9) - saledPrice > 0 && saledPrice > 0) {
            saledPrice *= -1;
        }
        return saledPrice;
    }


}
