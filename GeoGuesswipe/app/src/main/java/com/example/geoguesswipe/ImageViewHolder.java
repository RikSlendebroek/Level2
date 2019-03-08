package com.example.geoguesswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public View view;

    public ImageViewHolder(View itemView) {

        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        view = itemView;
    }
}