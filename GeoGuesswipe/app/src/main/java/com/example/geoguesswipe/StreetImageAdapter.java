package com.example.geoguesswipe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class StreetImageAdapter extends RecyclerView.Adapter<StreetImageAdapter.ViewHolder> {

    private StreetImage[] itemsData;

    public StreetImageAdapter(StreetImage[] itemsData) {
        this.itemsData = itemsData;
    }

    @NonNull
    @Override
    public StreetImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.item_layout, null );
        ViewHolder viewHolder = new ViewHolder( itemLayoutView );
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull StreetImageAdapter.ViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(itemsData[i].getImage());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;


        public ViewHolder(View itemView) {

            super( itemView );

            imageView = itemView.findViewById( R.id.imageView );

        }
    }
}
