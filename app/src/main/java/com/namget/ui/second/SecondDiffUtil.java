package com.namget.ui.second;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.namget.data.model.Book;

class SecondDiffUtil extends DiffUtil.Callback {


    @Override
    public int getOldListSize() {
        return 0;
    }

    @Override
    public int getNewListSize() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

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
