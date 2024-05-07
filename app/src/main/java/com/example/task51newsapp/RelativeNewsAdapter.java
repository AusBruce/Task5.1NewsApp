package com.example.task51newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RelativeNewsAdapter extends RecyclerView.Adapter<RelativeNewsAdapter.MyViewHolder> {
    private int []array;

    public RelativeNewsAdapter(int[] array) {
        this.array = array;
    }

    @NonNull
    @Override
    public RelativeNewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_news, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RelativeNewsAdapter.MyViewHolder holder, int position) {
        holder.relativeImageView.setImageResource(array[position]);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView relativeImageView;
        TextView relativeNewsTitle;
        TextView relativeNewsDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeImageView = itemView.findViewById(R.id.relativeNewsImage);
            relativeNewsTitle = itemView.findViewById(R.id.relativeNewsTitle);
            relativeNewsDescription = itemView.findViewById(R.id.relativeNewsDescription);
        }
    }
}