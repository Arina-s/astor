package com.arinauniversity.astor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class BookShelf {

    private Map<String, Book> bookMap;
    private List<Book> bookList;
    private Book mainBook;
    private Figure figure;

    @Value("${owner}")
    private String owner;
    @Value("${space}")
    private int space;

    @Autowired
    public BookShelf(Map<String, Book> bookMap, List<Book> bookList, Figure figure) {
        this.bookMap = bookMap;
        this.bookList = bookList;
        this.figure = figure;
    }

    @Autowired
    @Qualifier("technicalBook")
    public void setMainBook(Book mainBook) {
        this.mainBook = mainBook;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @PostConstruct
    public void bookShelfInit() {
        System.out.println("---BookShelf initialization---");
    }

    public void printBooksNames() {
        System.out.println("Books list: " + bookList);
        System.out.println("Books map: " + bookMap);
        System.out.println("Owner : " + owner);
        System.out.println("Space : " + space);
        System.out.println("MainBook : " + mainBook);
        System.out.println("Figure : " + figure.getName());
    }

}
