package com.arinauniversity.astor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookShelf")
public class BookController {

    @GetMapping("")
    public String getShelf() {
        return "book/bookShelf";
    }

}
