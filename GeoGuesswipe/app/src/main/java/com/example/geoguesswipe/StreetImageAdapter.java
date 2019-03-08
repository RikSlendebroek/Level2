package com.example.geoguesswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StreetImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private Context context;
    public List<StreetImage> itemsData;

    public StreetImageAdapter(Context context,  List<StreetImage> itemsData) {
        this.itemsData = itemsData;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        ImageViewHolder viewHolder = new ImageViewHolder(itemLayoutView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(itemsData.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}
