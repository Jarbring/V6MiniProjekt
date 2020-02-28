package com.example.V6MiniProjekt;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class ListRepository {

    List<Account> accountList = new ArrayList<>();
    HashMap<String, List<String>> hm = new HashMap();
    List<String> mikael = new ArrayList<>();
    List<String> jonathan = new ArrayList<>();
    List<String> oskar = new ArrayList<>();
    List<String> angelica = new ArrayList<>();
    List<String> karin = new ArrayList<>();

    public void setHm(String userName, List<String> userList) {
       hm.put(userName, userList);
    }

    public HashMap<String, List<String>> getHm() {


        hm.put("Mikael", mikael);
        hm.put("Jonathan", jonathan);
        hm.put("Oskar", oskar);
        hm.put("Angelica", angelica);
        hm.put("Karin", karin);

        return hm;
    }

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

    public List<Music> getMusicList() {
        List<Music> musicList = new ArrayList<>();
        musicList.add(new Music("MusicList", 1, "music", "Artist1", "song1", "Album1", "Pop", 1994));
        musicList.add(new Music("MusicList", 2, "music", "Artist2", "song2", "Album2", "Rock", 2006));
        musicList.add(new Music("MusicList", 3, "music", "Artist3", "song3", "Album3", "Hiphop", 2018));

        return musicList;
    }

    public List<TVSeries> getTVSeriesList() {
        List<TVSeries> tvSeriesList = new ArrayList<>();
        tvSeriesList.add(new TVSeries("TVSeriesList", 1, "TVSeries", "Series1", "Adventure", "Director1", 2006));
        tvSeriesList.add(new TVSeries("TVSeriesList", 2, "TVSeries", "Series2", "History", "Director2", 1993));
        tvSeriesList.add(new TVSeries("TVSeriesList", 3, "TVSeries", "Series3", "Romance", "Director3", 2014));

        return tvSeriesList;
    }


}
