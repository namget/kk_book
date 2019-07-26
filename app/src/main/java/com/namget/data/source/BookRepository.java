package com.namget.data.source;

import android.util.Pair;

import com.namget.data.model.Book;

import java.util.List;

import io.reactivex.Single;

public interface BookRepository {
    Single<Pair<Boolean, List<Book>>> searchBook(String query, int page);
}
