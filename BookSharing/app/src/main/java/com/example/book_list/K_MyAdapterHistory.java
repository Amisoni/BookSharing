package com.example.book_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class K_MyAdapterHistory extends RecyclerView.Adapter<K_MyHolderHistory> {

    Context context;
    ArrayList<K_ModelHistory> models;

    public K_MyAdapterHistory(Context context, ArrayList<K_ModelHistory> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public K_MyHolderHistory onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_bookhistory,null);
        return  new K_MyHolderHistory(view1);

    }

    @Override
    public void onBindViewHolder(@NonNull K_MyHolderHistory holder, int position) {
        holder.bookimg.setImageResource(models.get(position). getBookicon());
        holder.name.setText(models.get(position).getBookName());
        holder.author.setText(models.get(position).getAuthorName());
        holder.publisher.setText(models.get(position).getPublisherName());
        holder.doner.setText(models.get(position).getDonerName());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
