package com.example.V6MiniProjekt;

public class List {
    public String listName;
    public long id;
    public String tag;

    public List(String listName, long id, String tag) {
        this.listName = listName;
        this.id = id;
        this.tag = tag;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
