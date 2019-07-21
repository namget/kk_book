package com.namget.data.remote;

import com.namget.data.model.Book;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET ("/v3/search/book?sort=accuracy&target=title&size=10&query={query}&page={page}")
    Single<Book> searchBook(@Path("qurey") String query, @Path("page") int page);
}
