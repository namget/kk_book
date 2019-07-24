package com.namget.ui.second.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.namget.R;
import com.namget.data.model.Book;
import com.namget.databinding.ItemBookBinding;
import com.namget.ui.second.SecondViewModel;

import java.util.ArrayList;
import java.util.List;


public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolder> {
    private final List<Book> list = new ArrayList<>();
    private final SecondViewModel secondViewModel;


    public SecondAdapter(SecondViewModel secondViewModel) {
        this.secondViewModel = secondViewModel;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemBookBinding binding;

        MyViewHolder(ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Book book, SecondViewModel secondViewModel) {
            binding.setBook(book);
            binding.setViewmodel(secondViewModel);
        }
    }

    public void updateList(List<Book> newList) {
        list.addAll(newList);
        notifyItemRangeChanged(list.size(), newList.size());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBookBinding item = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_book, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(list.get(position), secondViewModel);
    }
}
