package com.arinauniversity.astor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookShelf bookShelf = applicationContext.getBean("bookShelf", BookShelf.class);
        bookShelf.printBooksNames();

        applicationContext.close();
    }

}
