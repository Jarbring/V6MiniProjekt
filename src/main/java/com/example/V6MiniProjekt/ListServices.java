package com.example.V6MiniProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServices {
    @Autowired
    ListRepository listRepository;

    public boolean validateLogin(String userName, String password) {
        boolean valid = false;

        //Ej färdig metod under. Den skall hämta info från ListRepository och jämföra med userName/password
        if (userName.equals(listRepository.checkUsername(userName)) && password.equals(listRepository.checkPassword(password)))
            valid = true;
        return valid;
    }
}
