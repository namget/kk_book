package com.namget.ui.second;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.namget.data.model.Book;

class SecondDiffUtil extends DiffUtil.ItemCallback<Book> {

    // Diff 유틸 조건 이렇게 서로 같으면 욕먹을 듯 두 함수 의미 찾아보고 한번 바꿔바
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
