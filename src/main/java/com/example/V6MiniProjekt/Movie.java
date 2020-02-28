package com.example.V6MiniProjekt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    String title;
    String genre;
    public List<String> allGenres = Arrays.asList("Comedy", "Drama","Horror", "Action");

    public  ArrayList<Movie> movies = new ArrayList<>();

    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
