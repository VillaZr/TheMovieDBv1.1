package com.example.themoviedb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedb.model.Result;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerViewAdapter * ";

    String[] arr;
    String[] aTitle;

    private Context context;


    private RecyclerViewClickInterface recyclerViewClickInterface;

    public RecyclerViewAdapter(String[] arr, String[] aTitle, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.arr = arr;
        this.aTitle = aTitle;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent,false);
        MyViewHolder myViewHolder= new MyViewHolder(view);

        context = parent.getContext();

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.with(context)
                .load(arr[position])
                .into(holder.imageView);

        holder.textView.setText(aTitle[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        recyclerViewClickInterface.onItemClick(getAdapterPosition());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            itemView.setOnLongClickListener((view) -> {
                recyclerViewClickInterface.onLongItemClick(getAdapterPosition());
                return true;
            });

        }

    }

}
