package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {

    Button rewindButton, pauseAndPlayButton, fastForwardButton;
    TextView songNameID, artistNameID, details, detailsText;
    ImageView musicLogo;
    SeekBar seekBar;
    String nameSong;
    String nameArtist;
    public static MediaPlayer mediaPlayer;
    public Runnable runnable;
    public Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        TextView nowPlayingID = findViewById(R.id.now_playing_id);
        songNameID = findViewById(R.id.song_name_id);
        artistNameID = findViewById(R.id.artist_name_id);
        rewindButton = findViewById(R.id.rewind_button);
        pauseAndPlayButton = findViewById(R.id.pause_and_play_button);
        fastForwardButton = findViewById(R.id.fast_forward_button);
        detailsText = findViewById(R.id.details_text);
        details = findViewById(R.id.details_id);
        seekBar = findViewById(R.id.seekbar_id);
        musicLogo = findViewById(R.id.music_logo);
        handler = new Handler();

        nowPlayingID.setText(R.string.now_playing);
        rewindButton.setText("<<");
        pauseAndPlayButton.setText(R.string.ii);
        fastForwardButton.setText(">>");
        details.setText(R.string.about_song);

        nameSong = getIntent().getStringExtra("name");
        nameArtist = getIntent().getStringExtra("artist");

        if (nameSong.equals("Shape of you") && nameArtist.equals("ed sheeran")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_ed_sheeran);
            musicLogo.setImageResource(R.drawable.shape_of_you);
            mediaPlayer = MediaPlayer.create(this, R.raw.sheeran);
        } else if (nameSong.equals("Friends") && nameArtist.equals("marshmello & anne-marie")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_marshmello);
            musicLogo.setImageResource(R.drawable.marshmello);

            mediaPlayer = MediaPlayer.create(this, R.raw.marshmello);
        } else if (nameSong.equals("L'Hiver Indien") && nameArtist.equals("baloji")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_baloji);
            musicLogo.setImageResource(R.drawable.baloji);
            mediaPlayer = MediaPlayer.create(this, R.raw.baloji);
        } else if (nameSong.equals("Ye") && nameArtist.equals("burna boy")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_burna);
            musicLogo.setImageResource(R.drawable.burna);
            mediaPlayer = MediaPlayer.create(this, R.raw.burna);
        } else if (nameSong.equals("What lovers do") && nameArtist.equals("maroon 5 ft. sza")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_maroon);
            musicLogo.setImageResource(R.drawable.maroon_five);
            mediaPlayer = MediaPlayer.create(this, R.raw.maroon);
        } else if (nameSong.equals("Live in the moment") && nameArtist.equals("portugal. the man")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_portugal);
            musicLogo.setImageResource(R.drawable.portugal_man);
            mediaPlayer = MediaPlayer.create(this, R.raw.portugal);
        } else if (nameSong.equals("Medicina") && nameArtist.equals("anitta")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.details_anitta);
            musicLogo.setImageResource(R.drawable.medicina);
            mediaPlayer = MediaPlayer.create(this, R.raw.medicina);
        } else if (nameSong.equals("No Brainer") && nameArtist.equals("dj khaled ft. justin bieber, chance the rapper, quavo")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.khaled_details);
            musicLogo.setImageResource(R.drawable.no_brainer);
            mediaPlayer = MediaPlayer.create(this, R.raw.no_brainer);
        } else if (nameSong.equals("Lucid Dreams") && nameArtist.equals("juice wrld")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.juice_details);
            musicLogo.setImageResource(R.drawable.lucid_dreams);
            mediaPlayer = MediaPlayer.create(this, R.raw.lucid_dreams);
        } else if (nameSong.equals("Kiss Me") && nameArtist.equals("magic!")) {
            stop();
            songNameID.setText(nameSong);
            artistNameID.setText(nameArtist);
            detailsText.setText(R.string.magic_details);
            musicLogo.setImageResource(R.drawable.kiss_me);
            mediaPlayer = MediaPlayer.create(this, R.raw.kiss_me);
        }

        rewindButton.setOnClickListener(this);
        pauseAndPlayButton.setOnClickListener(this);
        fastForwardButton.setOnClickListener(this);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    public void changeSeekbar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pause_and_play_button:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    pauseAndPlayButton.setText(">");
                } else {
                    mediaPlayer.start();
                    pauseAndPlayButton.setText("||");
                    changeSeekbar();
                }
                break;

            case R.id.fast_forward_button:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
                break;

            case R.id.rewind_button:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
                break;
        }
    }
}

