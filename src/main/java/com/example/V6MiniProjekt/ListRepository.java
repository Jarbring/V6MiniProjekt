package com.example.V6MiniProjekt;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class ListRepository {

    List<Account> accountList = new ArrayList<>();

    public void addAccount(String userName, String password) {
        accountList.add(new Account(userName,password));
    }

    public List<Account> getAccountList() {
        accountList.add(new Account("Mikael","Mikael"));
        accountList.add(new Account("Oskar","Oskar"));
        accountList.add(new Account("Jonathan","Jonathan"));
        accountList.add(new Account("Angelica","Angelica"));
        accountList.add(new Account("Karin","Karin"));

        return accountList;
    }

    public List getMusicList() {
        List<Music> musicList = new ArrayList<>();
        musicList.add(new Music("MusicList", 1, "music", "Artist1", "song1", "Album1", "Pop", 1994));
        musicList.add(new Music("MusicList", 2, "music", "Artist2", "song2", "Album2", "Rock", 2006));
        musicList.add(new Music("MusicList", 3, "music", "Artist3", "song3", "Album3", "Hiphop", 2018));

        return musicList;
    }

    public List getMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("MovieList", 1, "movie", "Movie1", "Horror", "Derpson", 2005));
        movieList.add(new Movie("MovieList", 2, "movie", "Movie2", "Action", "Director2", 1978));
        movieList.add(new Movie("MovieList", 3, "movie", "Movie3", "Comedy", "Merpson", 2001));

        return movieList;
    }

    public List getTVSeriesList() {
        List<TVSeries> tvSeriesList = new ArrayList<>();
        tvSeriesList.add(new TVSeries("TVSeriesList", 1, "TVSeries", "Series1", "Adventure", "Director1", 2006));
        tvSeriesList.add(new TVSeries("TVSeriesList", 2, "TVSeries", "Series2", "History", "Director2", 1993));
        tvSeriesList.add(new TVSeries("TVSeriesList", 3, "TVSeries", "Series3", "Romance", "Director3", 2014));

        return tvSeriesList;
    }


}
