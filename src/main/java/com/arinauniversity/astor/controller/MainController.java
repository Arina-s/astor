package com.arinauniversity.astor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String start() {
        return "main/start";
    }

    @GetMapping("/exit")
    public String exit() {
        return "main/exit";
    }

}
