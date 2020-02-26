package com.example.V6MiniProjekt;

public class TVSeries extends List {
    public String seriesName;
    public String genre;
    public String director;
    public int year;


    public TVSeries(String listName, long id, String tag, String seriesName, String genre, String director, int year) {
        super(listName, id, tag);
        this.seriesName=seriesName;
        this.genre=genre;
        this.director=director;
        this.year=year;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
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
}
