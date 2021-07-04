package com.arinauniversity.astor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String start(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "main/start";
    }

    @GetMapping("/exit")
    public String exit() {
        return "main/exit";
    }

}
