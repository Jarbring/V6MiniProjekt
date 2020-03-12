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
}
