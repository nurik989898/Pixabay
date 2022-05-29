package com.example.pixabay.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pixabay.databinding.ItemImageBinding;
import com.example.pixabay.network.model.Hit;

import java.util.ArrayList;

public class ImageAdaptor extends RecyclerView.Adapter<ImageAdaptor.IamgeViewHolder> {
    ArrayList<Hit> list;

    public ImageAdaptor(ArrayList<Hit> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ImageAdaptor.IamgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IamgeViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdaptor.IamgeViewHolder holder, int position) {
    holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class IamgeViewHolder extends RecyclerView.ViewHolder {
        ItemImageBinding binding;
        public IamgeViewHolder(ItemImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(Hit object){
            Glide.with(binding.imageV)
                    .load(object.getLargeImageURL())
                    .into(binding.imageV);
        }
    }
}
