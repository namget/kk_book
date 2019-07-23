package com.namget.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private final String title;
    private final int price;
    private final int salePrice;
    private final String thumbnail;

    public Book(String title, int price, int salePrice,  String thumbnail) {
        this.title = title;
        this.price = price;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.price);
        dest.writeInt(this.salePrice);
        dest.writeString(this.thumbnail);
    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.price = in.readInt();
        this.salePrice = in.readInt();
        this.thumbnail = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
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
    public boolean equals(Object obj) {
       if (obj instanceof Book){
            Book book = (Book) obj;
           return (this.title.equals(book.title) && this.price == book.price && this.salePrice == book.salePrice);
       }
       return false;
    }
}
