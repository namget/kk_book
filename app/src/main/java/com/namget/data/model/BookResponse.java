package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BookResponse {
    @SerializedName("meta")
    Meta metaData;
    @SerializedName("documents")
    ArrayList<Book> results;

    public Meta getMetaData() {
        return metaData;
    }

    public void setMetaData(Meta metaData) {
        this.metaData = metaData;
    }

    public ArrayList<Book> getResults() {
        return results;
    }

    public void setResults(ArrayList<Book> results) {
        this.results = results;
    }
}
