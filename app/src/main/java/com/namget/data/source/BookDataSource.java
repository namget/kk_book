package com.namget.data.source;

import com.namget.data.model.Book;

import io.reactivex.Single;

public interface BookDataSource {
    Single<Book> searchBook(String query, int page);
}
