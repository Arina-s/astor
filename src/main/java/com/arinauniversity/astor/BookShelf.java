package com.arinauniversity.astor;

public class BookShelf {

    private Book book;

    public BookShelf(Book book) {
        this.book = book;
    }

    public void printBooksNames() {
        System.out.println(book.getName());
    }

}
