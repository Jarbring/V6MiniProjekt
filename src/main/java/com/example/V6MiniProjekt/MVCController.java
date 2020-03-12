package com.example.V6MiniProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class MVCController {
Account account;
    @Autowired
    ListServices listServices;

    @GetMapping("/home")
    public String homeController(){
        return "/home";
    }

    @GetMapping("/home1")
    public String createAccount(){
        return "/signedInHome";
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
    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userName");

        return "/home";
    }

    @PostMapping("/home") //Login function on the home page
    public String loginController(HttpSession session, @RequestParam String userName, @RequestParam String password) {

        //Call a method from listService to validate login attempt
        boolean valid = listServices.validateLogin(userName, password);

        if (valid) {
            account = new Account(userName, password);
            session.setAttribute("userName", userName);
            return "redirect:/myLists";
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
            return "redirect:/myLists";
        }
        else
            return "/loginError";

    }
    @PostMapping("/home1")
    public String createAccount(HttpSession session, @RequestParam String createUserName, String createPassword, String createEmail) {

        //Call a method to check if the username is taken and if not redirect to add the account in the database.
        boolean valid = listServices.createAccount(createUserName, createPassword,createEmail);
        if (valid) {
            session.setAttribute("userName", createUserName);
            List<String> temp = new ArrayList<>();
            listServices.listRepository.setHm(createUserName, temp);
            return "redirect:/myLists";
        }
        else
            return "/createAccountError";
    }
    @PostMapping("/createAccountError") //Create account function on the createAccountError page
    public String createAccountError(HttpSession session, @RequestParam String createUserName, String createPassword,String createEmail) {

        //Call a method to check if the username is taken and if not redirect to add the account in the database.
        boolean valid = listServices.createAccount(createUserName, createPassword,createEmail);

        if (valid) {
            session.setAttribute("userName", createUserName);
            return "/signedInHome";
        }
        else
            return "/createAccountError";
    }

    @GetMapping("/myLists")
    String task1(Model model, HttpSession session){
        String userName = (String)session.getAttribute("userName");


           model.addAttribute("myList", listServices.getItemsList());

            return "signedInHome";
    }

    @PostMapping("/myLists")
    public String task1(HttpSession session, Model model, @RequestParam String item, @RequestParam(required = false, defaultValue = "1") int rensa) {

        String userName = (String)session.getAttribute("userName");
        /*List<String> newItem = new ArrayList<>();
        newItem.add(item);
        listServices.setHm(userName, newItem);*/
        //listServices.listRepository.getHm().size();
        if (rensa == 0){
            listServices.listRepository.hm.get(userName).clear();
            return "redirect:/myLists";
        }

        listServices.listRepository.hm.get(userName).add(item);
        model.getAttribute("myList");
        return "redirect:/myLists";
    }
}
