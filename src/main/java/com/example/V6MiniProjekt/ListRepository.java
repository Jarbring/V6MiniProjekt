package com.example.V6MiniProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class ListRepository {

    @Autowired
    DataSource dataSource;


    public String testDB() throws SQLException {
        String result = null;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM [USER] where username = 'Jman'")) {
           if (rs.next()) {
               result = rs.getString(1);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public void addToList(String item, String username)  {

        try (Connection conn = dataSource.getConnection()){
            int listId = 0;
            PreparedStatement ps = conn.prepareStatement("SELECT ListId AS C FROM LISTS INNER JOIN [User] ON lists.email = [user].email WHERE username ='" + username +"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                listId = rs.getInt("C");
            }
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Items (listId, Item) VALUES (?, ?)");
            ps2.setInt(1,listId);
            ps2.setString(2,item);
            ps2.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private Account rsAccount(ResultSet rs) throws SQLException {
        return new Account(rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"));
    }
    private Items rsItems(ResultSet rs) throws SQLException {
        return new Items(rs.getInt("itemId"),
                rs.getString("item"),
                rs.getInt("listId"));
    }
    public List<Items> getItemsList(String userName) {
        List<Items> itemsList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Lists INNER JOIN [USER] ON [user].email = lists.email INNER JOIN Items ON items.listId = lists.listId WHERE username ='" + userName + "'")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                itemsList.add(rsItems(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsList;
    }

    public void clearList(String userName) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE N FROM Items N INNER JOIN Lists ON Lists.ListId = N.ListId INNER JOIN [User] ON [user].email = Lists.email WHERE username ='" + userName + "'")) {
            ps.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(String username, String password, String email)  {

        try (Connection conn = dataSource.getConnection()){
             PreparedStatement ps = conn.prepareStatement("INSERT INTO [USER] (username,password,email) VALUES (?,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Lists (email) VALUES (?)");
            ps2.setString(1,email);
            ps2.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Account> getAccountList() {
        List<Account> accountList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM [USER]")) {
            while (rs.next()) {
                accountList.add(rsAccount(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
    }
}
    //Helper method to create accounts from result set

