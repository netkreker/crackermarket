package com.crackermarket.app.controllers;

import com.crackermarket.app.entities.Category;
import com.crackermarket.app.services.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String sayHello() {
        return "index";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){

        return "goodbye";
    }
}
