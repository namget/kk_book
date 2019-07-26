package com.namget.data.source;

import android.util.Pair;

import com.namget.data.model.Book;

import java.util.List;

import io.reactivex.Single;

public class BookDataSource implements BookRepository {
    private final BookRepository bookRemoteDataSource = BookRemoteRepository.getInstance();

    private static class LazyHolder {
        private static final BookDataSource INSTANCE = new BookDataSource();
    }

    //기본 생성자 제거
    private BookDataSource() {}

    public static BookDataSource getInstance() {
        return BookDataSource.LazyHolder.INSTANCE;
    }

    @Override
    public Single<Pair<Boolean, List<Book>>> searchBook(String query, int page) {
        return bookRemoteDataSource.searchBook(query, page);
    }
}
