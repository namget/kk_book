package com.namget.ui.first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.namget.data.model.Book;
import com.namget.ui.base.DisposableViewModel;

import java.util.ArrayList;
import java.util.List;

public class FirstViewModel extends DisposableViewModel {
    private final int TOTAL_INIT_PRICE = 0;

    public FirstViewModel() {
        totalPrice.setValue(TOTAL_INIT_PRICE);
    }

    private final MutableLiveData<Integer> totalPrice = new MutableLiveData<>();

    public LiveData<Integer> getTotalPrice() {
        return totalPrice;
    }

    private final List<Book> bookList = new ArrayList<>();

    private void calculateTotalPrice(int price) {
        int sum = TOTAL_INIT_PRICE;
        if (totalPrice.getValue() != null) {
            sum = totalPrice.getValue();
        }
        sum += price;
        totalPrice.setValue(sum);
    }

    private boolean isOverlap(Book book) {
        for (Book b : bookList) {
            if (b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    void putData(Book book) {
        if (!isOverlap(book)) {
            bookList.add(book);
            calculateTotalPrice(book.getSalePrice());
        }
    }

}
