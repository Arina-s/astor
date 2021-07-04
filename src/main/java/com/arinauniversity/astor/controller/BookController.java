package com.arinauniversity.astor.controller;

import com.arinauniversity.astor.Book;
import com.arinauniversity.astor.BookShelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping("/bookShelf")
public class BookController {

    private static final Logger log = Logger.getLogger(BookController.class.getName());

    @Autowired
    private BookShelf bookShelf;

    @GetMapping("")
    public String getShelf(@RequestParam(value = "genre", required = false) String genre) {
        printBook(genre);
        return "book/bookShelf";
    }

    private void printBook(String genre) {
        Book book = bookShelf.getBookList().stream()
                .filter(e -> e.getGenre().equals(genre))
                .findFirst()
                .orElse(null);
        if (book != null) {
            log.info(book.toString());
        } else {
            log.warning(String.format("No such genre: %s", genre));
        }
    }

}
