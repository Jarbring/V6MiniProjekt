package com.example.V6MiniProjekt;

<<<<<<< HEAD:src/main/java/com/example/V6MiniProjekt/MVCController.java
public class MVCController {
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVC {

    @GetMapping("/index")
    public String home(){

        return "index";
    }
>>>>>>> 5cef5ee32679f4e5a9314b46a354b9448464aabf:src/main/java/com/example/V6MiniProjekt/MVC.java
}
