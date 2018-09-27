package com.example.android.musicplayer;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Songs> {


    public SongAdapter(Activity context, ArrayList<Songs> song) {
        super(context, 0, song);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        Songs currentSong = getItem(position);

        TextView songName = listItemView.findViewById(R.id.song_name);
        songName.setText(currentSong.getSongName());

        TextView artistName = listItemView.findViewById(R.id.artist);
        artistName.setText(currentSong.getArtistName());

        TextView time = listItemView.findViewById(R.id.time);
        time.setText(currentSong.geTime());

        return listItemView;
    }
}
