package com.example.android.musicplayer;

public class Songs {
    private String mSongName;
    private String mArtistName;
    private String mTime;

    public Songs(String songName, String artistName, String Time) {
        mSongName = songName;
        mArtistName = artistName;
        mTime = Time;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String geTime() {
        return mTime;
    }
}
