package com.example.prescription.web;

import com.example.prescription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/userList")
    public String userList(Model model){
        try {
            model.addAttribute("userList", userService.findAll());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "userList";
    }
}
