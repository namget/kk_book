package com.namget.data.source;

import com.namget.data.model.Book;
import com.namget.data.model.BookResponse;

import java.util.ArrayList;

import io.reactivex.Single;

public interface BookDataSource {
    Single<BookResponse> searchBook(String query, int page);
}
