package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {
    @SerializedName("meta")
    private Meta metaData;
    @SerializedName("documents")
    private List<InnerBook> results;

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

    public List<Book> toBookList() {
        List<Book> books = new ArrayList<>();
        for (InnerBook innerBook : this.results) {
            books.add(innerBook.toBookList());
        }
        return books;
    }

    static class InnerBook {

        private String title;
        private String contents;
        private String url;
        private String isbn;
        private String datetime;
        private List<String> authors;
        private String publisher;
        private List<String> translators;
        private int price;
        @SerializedName("sale_price")
        private int salePrice;
        private String thumbnail;
        private String status;

        private Book toBookList() {
            Book book = new Book();
            book.setTitle(setFilteredTitle(this.title));
            book.setPrice(this.price);
            book.setSalePrice(setFilteredPrice(this.price, this.salePrice));
            return book;
        }
        private String setFilteredTitle(String title) {
            while (title.contains("(") && title.contains(")")) {
                StringBuilder stringBuffer = new StringBuilder(title);
                stringBuffer.replace(title.indexOf("("), title.indexOf(")") + 1, "");
                title = stringBuffer.toString();
            }
            return title;
        }
        private int setFilteredPrice(int price, int discountedPrice) {
            //90퍼 - 판매가격 > 0 => price의 90퍼도 안된다.
            if ((price * 0.9) - discountedPrice > 0 && discountedPrice > 0) {
                discountedPrice *= -1;
            }
            return discountedPrice;
        }
    }

    public static class Meta {
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
