package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongsList extends AppCompatActivity {

    public ListView listView;
    public ArrayList<Songs> song;
    public TextView allSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        allSongs = findViewById(R.id.all_songs_id);
        allSongs.setText(R.string.all_songs);

        song = new ArrayList<Songs>();
        song.add(new Songs("Shape of you", "ed sheeran", "3:55"));
        song.add(new Songs("Friends", "marshmello & anne-marie", "3:22"));
        song.add(new Songs("L'Hiver Indien", "baloji", "3:23"));
        song.add(new Songs("Ye", "burna boy", "3:52"));
        song.add(new Songs("What lovers do", "maroon 5 ft. sza", "3:15"));
        song.add(new Songs("Live in the moment", "portugal. the man", "4:06"));
        song.add(new Songs("Medicina", "anitta", "2:21"));
        song.add(new Songs("No Brainer", "dj khaled ft. justin bieber, chance the rapper, quavo", "4:20"));
        song.add(new Songs("Lucid Dreams", "juice wrld", "3:59"));
        song.add(new Songs("Kiss Me", "magic!", "3:24"));

        SongAdapter adapter = new SongAdapter(this, song);

        listView = findViewById(R.id.list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SongsList.this, NowPlaying.class);
                intent.putExtra("name", song.get(i).getSongName());
                intent.putExtra("artist", song.get(i).getArtistName());
                startActivity(intent);
            }
        });
        listView.setAdapter(adapter);
    }
}
