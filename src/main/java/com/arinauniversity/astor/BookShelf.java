package com.arinauniversity.astor;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {

    private List<Book> bookList = new ArrayList<>();
    private Book mainBook;
    private String owner;
    @Autowired
    private Figure figure;
    private int space;

    private BookShelf() {
    }

    public static BookShelf getBookShelf() {
        return new BookShelf();
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Autowired
    public void setMainBook(Book fantasyBook) {
        this.mainBook = fantasyBook;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void bookShelfInit() {
        System.out.println("---BookShelf initialization---");
    }

    public void printBooksNames() {
        System.out.println("Books : " + bookList);
        System.out.println("Owner : " + owner);
        System.out.println("Space : " + space);
        System.out.println("MainBook : " + mainBook);
        System.out.println("Figure : " + figure.getName());
    }

}
