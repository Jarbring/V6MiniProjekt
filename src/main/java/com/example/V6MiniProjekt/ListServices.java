package com.example.V6MiniProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ListServices {
    @Autowired
    ListRepository listRepository;

    public boolean validateLogin(String userName, String password) {
        boolean valid = false;

        //Skall hämta info från ListRepository och jämföra med userName/password
        for (Account account : listRepository.getAccountList()) {
            if (userName.equals(account.getUsername()) && password.equals(account.getPassword())) {
                valid = true;
            }
        }
        return valid;
    }

    public boolean createAccount(String createUserName, String createPassword) {
        boolean valid = true;

        //Checks if username is taken and in not it adds the account to the database
        for (Account account : listRepository.getAccountList()) {
            if (createUserName.equals(account.getUsername())) {
                valid = false;
                break;
            }
        }
        if (valid)
            listRepository.addAccount(createUserName, createPassword);
        
        return valid;
    }
}
