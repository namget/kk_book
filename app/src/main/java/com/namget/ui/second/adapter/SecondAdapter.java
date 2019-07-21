package com.namget.ui.second.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.namget.R;
import com.namget.data.model.Book;
import com.namget.databinding.ItemBookBinding;

public class SecondAdapter extends ListAdapter<Book, SecondAdapter.MyViewHolder> {

    public SecondAdapter(DiffUtil.ItemCallback<Book> diffUtil) {
        super(diffUtil);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ItemBookBinding binding;

        MyViewHolder(ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Book book) {
            binding.setBook(book);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBookBinding item = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_book, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
