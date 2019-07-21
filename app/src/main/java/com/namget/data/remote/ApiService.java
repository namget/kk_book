package com.namget.data.remote;

import com.namget.data.model.Book;
import com.namget.data.model.BookResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v3/search/book")
    Single<BookResponse> searchBook(@Query("sort") String sort, @Query("target") String target ,@Query("size") int size, @Query("query") String query, @Query("page") int page);
}
