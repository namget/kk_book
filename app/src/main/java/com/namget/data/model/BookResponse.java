package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

public class BookResponse {
    @SerializedName("meta")
    Meta metaData;
    @SerializedName("documents")
    Document<Book> results;
}
