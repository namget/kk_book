package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {
    @SerializedName("meta")
    private Meta metaData;
    @SerializedName("documents")
    private List<InnerBook> results;
    InnerBook innerBook;


    public Meta getMetaData() {
        return metaData;
    }

    public void setMetaData(Meta metaData) {
        this.metaData = metaData;
    }

    public List<InnerBook> getResults() {
        return results;
    }

    public void setResults(List<InnerBook> results) {
        this.results = results;
    }

    public List<Book> toBookList(List<InnerBook> innerBooks) {
        List<Book> books = new ArrayList<>();
        for (InnerBook innerBook : innerBooks) {
            books.add(innerBook.toBookList());
        }
        return books;
    }

     static class InnerBook {
        private List authors;
        private String contents;
        private String title;
        private int price;
        @SerializedName("sale_price")
        private int salePrice;
        private String thumbnail;

        private Book toBookList() {
            Book book = new Book();
            book.setTitle(title);
            book.setPrice(price);
            book.setSalePrice(salePrice);
            return book;
        }
    }

    static class Meta {
        @SerializedName("is_end")
        private boolean isEnd;
        @SerializedName("pageable_count")
        private int pageableCount;
        @SerializedName("total_count")
        private int totalCount;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public int getPageableCount() {
            return pageableCount;
        }

        public void setPageableCount(int pageableCount) {
            this.pageableCount = pageableCount;
        }
    }

}
