package com.example.atv_banda.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atv_banda.Album;
import com.example.atv_banda.R;

import java.util.List;

public abstract class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private Context context;
    private List<Album> albumList;

    public AlbumAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_album,  parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.bandTextView.setText(album.getBanda());
        holder.yearTextView.setText(String.valueOf(album.getAno()));
        holder.photographerTextView.setText(album.getFotografo());
        holder.albumImageView.setImageResource(album.getImagem());
        holder.moreInfoButton.setOnClickListener(v -> {
            // Implement your logic to show more information about the album
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    protected abstract void onCreate(Bundle savedInstanceState);

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView bandTextView, yearTextView, photographerTextView;
        ImageView albumImageView;
        Button moreInfoButton;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            bandTextView = itemView.findViewById(R.id.bandTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            photographerTextView = itemView.findViewById(R.id.photographerTextView);
            albumImageView = itemView.findViewById(R.id.albumImageView);
            moreInfoButton = itemView.findViewById(R.id.moreInfoButton);
        }
    }
}
