package com.example.V6MiniProjekt;

public class Music extends List {
    public String artist;
    public String songName;
    public String album;
    public String genre;
    public int year;

    
    public Music(String listName, long id, String tag, String artist, String songName, String album, String genre, int year) {
        super(listName, id, tag);
        this.artist=artist;
        this.songName=songName;
        this.album=album;
        this.genre=genre;
        this.year=year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
