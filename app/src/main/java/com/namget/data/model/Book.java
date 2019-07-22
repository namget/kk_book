package com.namget.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Book implements Parcelable {
    private String title;
    private int price;
    @SerializedName("sale_price")
    private int salePrice;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Book() {
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
