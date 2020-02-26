package com.example.V6MiniProjekt;

public class Movie extends List {
    public String genre;

    public Movie(String name, long id, String tag) {
        super(name, id, tag);
        this.genre = genre;
    }
}
