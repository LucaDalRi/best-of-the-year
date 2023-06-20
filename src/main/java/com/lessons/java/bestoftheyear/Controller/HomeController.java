package com.lessons.java.bestoftheyear.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", "Luca Dal Rì");
        return "index";
    }

}
