package com.arinauniversity.astor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookShelf bookShelfArina = applicationContext.getBean("bookShelf", BookShelf.class);
        BookShelf bookShelfSara = applicationContext.getBean("bookShelf", BookShelf.class);

        bookShelfArina.printBooksNames();
        bookShelfSara.printBooksNames();
        System.out.println(bookShelfArina == bookShelfSara);
        bookShelfSara.setOwner("Sara");
        bookShelfArina.printBooksNames();
        bookShelfSara.printBooksNames();

        applicationContext.close();
    }

}
