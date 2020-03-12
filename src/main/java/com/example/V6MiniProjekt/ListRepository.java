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
             ResultSet rs = stmt.executeQuery("SELECT * FROM [USER]")) {
           if (rs.next()) {
               result = rs.getString(1);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }





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
    public List<Items> getItemsList() {
        List<Items> itemsList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Items")) {
            while (rs.next()) {
                itemsList.add(rsItems(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsList;
    }

    public void addAccount(String username, String password, String email)  {

        try (Connection conn = dataSource.getConnection()){
             PreparedStatement ps = conn.prepareStatement("INSERT INTO [USER] (username,password,email) VALUES (?,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.executeUpdate();

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

