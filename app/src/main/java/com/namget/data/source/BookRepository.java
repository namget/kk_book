package com.namget.data.source;

import android.util.Pair;

import com.namget.data.model.Book;

import java.util.List;

import io.reactivex.Single;

public class BookRepository implements BookDataSource {
    private BookDataSource bookRemoteDataSource = BookRemoteDataSource.getInstance();

    private static class LazyHolder {
        private static final BookRepository INSTANCE = new BookRepository();
    }

    public static BookRepository getInstance() {
        return BookRepository.LazyHolder.INSTANCE;
    }

    @Override
    public Single<Pair<Boolean, List<Book>>> searchBook(String query, int page) {
        return bookRemoteDataSource.searchBook(query, page);
    }
}
