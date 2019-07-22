package com.namget.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book implements Parcelable {
    private String title;
    private String contents;
    private String url;
    private String isbn;
    private String datetime;
    private List<String> author;
    private String publisher;
    private List<String> translators;
    private int price;
    @SerializedName("sale_price")
    private int salePrice;
    private String thumbnail;
    private String status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getTranslators() {
        return translators;
    }

    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.contents);
        dest.writeString(this.url);
        dest.writeString(this.isbn);
        dest.writeString(this.datetime);
        dest.writeStringList(this.author);
        dest.writeString(this.publisher);
        dest.writeStringList(this.translators);
        dest.writeInt(this.price);
        dest.writeInt(this.salePrice);
        dest.writeString(this.thumbnail);
        dest.writeString(this.status);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.contents = in.readString();
        this.url = in.readString();
        this.isbn = in.readString();
        this.datetime = in.readString();
        this.author = in.createStringArrayList();
        this.publisher = in.readString();
        this.translators = in.createStringArrayList();
        this.price = in.readInt();
        this.salePrice = in.readInt();
        this.thumbnail = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof  Book){
            Book book = (Book) obj;
            if((this.title.equals(book.title)) && (this.salePrice == book.salePrice) && (this.salePrice == book.salePrice)){
                return true;
            }
        }
        return false;
    }
}
