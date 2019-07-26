package com.namget.data.source;

import android.util.Pair;

import com.namget.data.model.Book;
import com.namget.data.model.BookResponse;
import com.namget.data.remote.NetworkRemote;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class BookRemoteRepository implements BookRepository {


    private static class LazyHolder {
        private static final BookRemoteRepository INSTANCE = new BookRemoteRepository();
    }

    //기본 생성자 제거
    private BookRemoteRepository(){}

    static BookRemoteRepository getInstance() {
        return BookRemoteRepository.LazyHolder.INSTANCE;
    }

    @Override
    public Single<Pair<Boolean, List<Book>>> searchBook(String query, int page) {
        return NetworkRemote.getInstance()
                .getApiService()
                .searchBook("accuracy", "title", 10, query, page)
                .map(BookResponse::toPairList)
                .subscribeOn(Schedulers.io());
    }
}
