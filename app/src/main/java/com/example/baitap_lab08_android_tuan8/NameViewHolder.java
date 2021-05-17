package com.example.baitap_lab08_android_tuan8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameItemView;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);

        nameItemView = itemView.findViewById(R.id.tvName);
    }
    public void bind(String text){
        nameItemView.setText(text);
    }
    static NameViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new NameViewHolder(view);
    }
}
