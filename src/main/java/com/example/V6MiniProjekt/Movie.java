package com.example.V6MiniProjekt;

public class Movie extends List {
    public String movieName;
    public String genre;
    public String director;
    public int year;

    public Movie(String listName, long id, String tag, String movieName, String genre, String director, int year) {
        super(listName, id, tag);
        this.movieName=movieName;
        this.genre = genre;
        this.director=director;
        this.year=year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
