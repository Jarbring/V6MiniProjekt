package com.example.V6MiniProjekt;

public class Items {
    private int itemId;
    private String item;
    private int listId;


    public Items(int itemId, String item, int listId) {
        this.itemId = itemId;
        this.item = item;
        this.listId = listId;
    }
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }



}
