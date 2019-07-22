package com.namget.ui.second.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.namget.R;
import com.namget.data.model.Book;
import com.namget.databinding.ItemBookBinding;
import com.namget.ui.second.SecondViewModel;

import java.util.ArrayList;
import java.util.List;

public class SecondAdapter extends ListAdapter<Book, SecondAdapter.MyViewHolder> {
    private SecondViewModel secondviewModel;

    public SecondAdapter(DiffUtil.ItemCallback<Book> diffUtil, SecondViewModel secondviewModel) {
        super(diffUtil);
        this.secondviewModel = secondviewModel;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ItemBookBinding binding;

        MyViewHolder(ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Book book) {
            binding.setBook(book);
            binding.executePendingBindings();
        }
    }

    @Override
    public void submitList(@Nullable List<Book> list) {
        super.submitList(list != null ? new ArrayList<>(list) : null);
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
