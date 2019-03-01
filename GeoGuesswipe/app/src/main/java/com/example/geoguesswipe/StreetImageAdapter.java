package com.example.geoguesswipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class StreetImageAdapter extends RecyclerView.Adapter<StreetImageAdapter.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder {
        ImageView imageView;


        public ViewHolder(View itemView) {

            super( itemView);

            imageView = itemView.findViewById(android.R.id.view1);

        }
    }
}
