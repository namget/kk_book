package com.namget.ui.second;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.namget.data.model.Book;

public class SecondDiffUtil extends DiffUtil.ItemCallback<Book> {

    @Override
    public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
        return ((oldItem.getTitle().equals(newItem.getTitle()))
                && (oldItem.getSalePrice() == (newItem.getSalePrice()))
                && (oldItem.getPrice() == (newItem.getPrice())));
    }

    @Override
    public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
        return ((oldItem.getTitle().equals(newItem.getTitle()))
                && (oldItem.getSalePrice() == (newItem.getSalePrice()))
                && (oldItem.getPrice() == (newItem.getPrice())));
    }
}
