package com.namget.ui.second.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.namget.data.model.Book;
import com.namget.databinding.ItemBookBinding;

public class SecondAdapter extends ListAdapter<Book, SecondAdapter.ViewHolder> {

    public SecondAdapter(DiffUtil.ItemCallback diffUtil) {
        super(diffUtil);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(ItemBookBinding binding) {
            super(binding.getRoot());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }
}
