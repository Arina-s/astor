package com.arinauniversity.astor.controller;

import com.arinauniversity.astor.model.Book;
import com.arinauniversity.astor.model.BookShelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping("/bookShelf")
public class BooksController {

    private static final Logger log = Logger.getLogger(BooksController.class.getName());

    @Autowired
    private BookShelf bookShelf;

    @GetMapping()
    public String getShelf(@RequestParam(value = "genre", required = false) String genre, Model model) {
        model.addAttribute("book", getBook(genre));
        return "book/bookShelf";
    }

    private String getBook(String genre) {
        Book book = bookShelf.getBookList().stream()
                .filter(e -> e.getGenre().equals(genre))
                .findFirst()
                .orElse(null);
        if (book != null) {
            log.info(book.toString());
            return book.toString();
        } else {
            log.warning(String.format("No such genre: %s", genre));
            return "...";
        }
    }

}
