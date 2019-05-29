package com.example.user.octom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.AdapterViewHolder> {

    ArrayList<songs> songs = new ArrayList<>();

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView title, author;
        Button detailButton;
        ImageView music_photo;
        LinearLayout list_itemLayout;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            detailButton = itemView.findViewById(R.id.detailButton);
            music_photo = itemView.findViewById(R.id.music_photo);
            list_itemLayout = itemView.findViewById(R.id.list_itemLayout);
        }
    }

    public void setSongs(ArrayList<songs> songs){
        this.songs = songs;
        notifyDataSetChanged();
    }

    public SongsAdapter(ArrayList<songs> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        AdapterViewHolder holder = new AdapterViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterViewHolder adapterViewHolder, int position) {
        songs song = songs.get(position);

        adapterViewHolder.music_photo.setImageResource(song.getmImageResource());

        final String title = song.getTitle();
        final String author = song.getAuthor();
        final String PrimeCuplet = song.getPrimeCuplet();
        final String webSource = song.getWebSource();
        final String TintSource = song.getTintSource();
        final int MP3SourcePlus = song.getMP3SourcePlus();
        final int MP3SourceMinus = song.getMP3SourceMinus();

        adapterViewHolder.title.setText(title);
        adapterViewHolder.author.setText(author);

        adapterViewHolder.detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("android.intent.action.SongActivity");
                adapterViewHolder.list_itemLayout.getContext().startActivity(intent);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(adapterViewHolder.list_itemLayout.getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("cuplet", PrimeCuplet);
                editor.putString("webSource", webSource);
                editor.putString("TintSource", TintSource);
                editor.putInt("MP3SourcePlus", MP3SourcePlus);
                editor.putInt("MP3SourceMinus", MP3SourceMinus);
                editor.apply();
            }
        });

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }



}
