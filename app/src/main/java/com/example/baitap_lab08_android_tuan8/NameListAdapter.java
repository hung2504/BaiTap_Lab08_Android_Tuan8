package com.example.baitap_lab08_android_tuan8;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class NameListAdapter extends ListAdapter<Name, NameViewHolder> {
    protected NameListAdapter(@NonNull DiffUtil.ItemCallback<Name> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NameViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Name current = getItem(position);
        holder.bind(current.getName());
    }
    static class WordDiff extends DiffUtil.ItemCallback<Name> {

        @Override
        public boolean areItemsTheSame(@NonNull Name oldItem, @NonNull Name newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Name oldItem, @NonNull Name newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
