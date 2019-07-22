package com.namget.ui.first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.namget.data.model.Book;
import com.namget.ui.base.DisposableViewModel;

import java.util.ArrayList;

public class FirstViewModel extends DisposableViewModel {

    private MutableLiveData<ArrayList<Book>> books = new MutableLiveData<>();
    ArrayList<Book> bookList = new ArrayList<>();
    public LiveData<ArrayList<Book>> getBooks() {
        return books;
    }

    private boolean isOverlap(Book book){
        for(Book b : bookList){
            if(b.equals(book)){
                return true;
            }
        }
        return false;
    }

    public void putData(Book book){
        if(!isOverlap(book)){
            bookList.add(book);
            books.setValue(bookList);
        }
    }

}
