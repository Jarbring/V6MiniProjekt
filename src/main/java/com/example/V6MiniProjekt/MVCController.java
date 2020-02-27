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
    public String homeController(){
        return "/home";
    }

    //Checks if the user is logged on before displaying the signedInHome-page
    @GetMapping("/signedInHome")
    public String loginController(HttpSession session){
        String userName = (String)session.getAttribute("userName");
        if (userName != null)
        return "/signedInHome";
        else
            return "/home";
    }

    //Not connected to a logout button yet.
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userName");
        return "/home";
    }

    @PostMapping("/home") //Login function on the home page
    public String loginController(HttpSession session, @RequestParam String userName, @RequestParam String password) {

        //Call a method from listService to validate login attempt
        boolean valid = listServices.validateLogin(userName, password);

        if (valid) {
            session.setAttribute("userName", userName);
            return "/signedInHome";
        }
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

        if (valid) {
            session.setAttribute("userName", userName);
            return "/signedInHome";
        }
        else
            return "/loginError";

    }

    @PostMapping("/home")
    public String createAccount(HttpSession session, @RequestParam String createUserName, String createPassword) {

        //Call a method to check if the username is taken and if not redirect to add the account in the database.
        boolean valid = listServices.createAccount(createUserName, createPassword);

        if (valid) {
            session.setAttribute("userName", createUserName);
            return "/signedInHome";
        }
        else
            return "/createAccountError";
    }

    @PostMapping("/createAccountError") //Create account function on the createAccountError page
    public String createAccountError(HttpSession session, @RequestParam String createUserName, String createPassword) {

        //Call a method to check if the username is taken and if not redirect to add the account in the database.
        boolean valid = listServices.createAccount(createUserName, createPassword);

        if (valid) {
            session.setAttribute("userName", createUserName);
            return "/signedInHome";
        }
        else
            return "/createAccountError";
    }
}
