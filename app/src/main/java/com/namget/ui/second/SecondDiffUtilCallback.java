package com.namget.ui.second;

import androidx.recyclerview.widget.DiffUtil;

import com.namget.data.model.Book;

import java.util.List;

public class SecondDiffUtilCallback extends DiffUtil.Callback {
    private final List<Book> oldBook;
    private final List<Book> newBook;

    public SecondDiffUtilCallback(List<Book> oldBook, List<Book> newBook) {
        this.oldBook = oldBook;
        this.newBook = newBook;
    }

    @Override
    public int getOldListSize() {
        return oldBook.size();
    }

    @Override
    public int getNewListSize() {
        return newBook.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldBook.get(oldItemPosition).equals(newBook.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

}
