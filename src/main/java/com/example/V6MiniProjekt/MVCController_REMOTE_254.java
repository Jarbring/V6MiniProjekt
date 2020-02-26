package com.example.V6MiniProjekt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVC {

    @GetMapping("/index")
    public String home(){

        return "index";
    }
}
