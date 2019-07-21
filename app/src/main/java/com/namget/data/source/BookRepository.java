package com.namget.data.source;

import com.namget.data.model.Book;

import io.reactivex.Single;

public class BookRepository implements BookDataSource {
    private BookRemoteDataSource bookRemoteDataSource = BookRemoteDataSource.getInstance();

    private static class LazyHolder {
        public static final BookRepository INSTANCE = new BookRepository();
    }

    public static BookRepository getInstance() {
        return BookRepository.LazyHolder.INSTANCE;
    }

    @Override
    public Single<Book> searchBook(String query, int page) {
        return bookRemoteDataSource.searchBook(query,page);
    }
}