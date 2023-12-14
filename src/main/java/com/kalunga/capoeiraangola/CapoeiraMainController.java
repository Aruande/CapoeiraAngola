package com.kalunga.capoeiraangola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CapoeiraMainController {

    @GetMapping("")
    public String showHomePage(){
        System.out.println("main controller");
        return "index";
    }
}

