package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookResponse {
    @SerializedName("meta")
    private Meta metaData;
    @SerializedName("documents")
    private List<Book> results;

    public Meta getMetaData() {
        return metaData;
    }

    public void setMetaData(Meta metaData) {
        this.metaData = metaData;
    }

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> results) {
        this.results = results;
    }
}
