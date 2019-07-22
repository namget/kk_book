package com.namget.data.source;

import com.namget.data.model.BookResponse;
import com.namget.data.remote.NetworkRemote;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class BookRemoteDataSource implements BookDataSource {


    private static class LazyHolder {
        private static final BookRemoteDataSource INSTANCE = new BookRemoteDataSource();
    }

    static BookRemoteDataSource getInstance() {
        return BookRemoteDataSource.LazyHolder.INSTANCE;
    }

    @Override
    public Single<BookResponse> searchBook(String query, int page) {
        return NetworkRemote.getInstance()
                .getApiService()
                .searchBook("accuracy", "title", 10, query, page)
//                .map(BookResponse)
                .subscribeOn(Schedulers.io());
    }
}
