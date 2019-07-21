package com.namget.data.source;

import com.namget.data.model.Book;
import com.namget.data.remote.NetworkRemote;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class BookRemoteDataSource implements BookDataSource {


    private static class LazyHolder {
        public static final BookRemoteDataSource INSTANCE = new BookRemoteDataSource();
    }

    public static BookRemoteDataSource getInstance() {
        return BookRemoteDataSource.LazyHolder.INSTANCE;
    }

    @Override
    public Single<Book> searchBook(String query, int page) {
        return NetworkRemote.getInstance()
                .getApiService()
                .searchBook("미움받을용기", 1)
                .subscribeOn(Schedulers.newThread());
    }
}
