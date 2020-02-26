package com.example.V6MiniProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MVCController {

    @Autowired
    ListServices listServices;

    @GetMapping("/home")
    public String loginController(){
        return "/home";
    }

    @PostMapping("/home") //Login function on the home page
    public String loginController(HttpSession session, @RequestParam String userName, @RequestParam String password) {

        //Call a method from listService to validate login attempt
        boolean valid = listServices.validateLogin(userName, password);

        if (valid)
            return "/home";
        else
            return "/loginError";

    }

    @GetMapping("/loginError")
    public String loginError() {
        return "/loginError";
    }

    @PostMapping("/loginError") //Login function on the loginError page
    public String loginError(HttpSession session, @RequestParam String userName, @RequestParam String password) {

        //Call a method from listService to validate login attempt
        boolean valid = listServices.validateLogin(userName, password);

        if (valid)
            return "/home";
        else
            return "/loginError";

    }
}
