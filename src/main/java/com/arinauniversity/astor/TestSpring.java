package com.arinauniversity.astor;

import com.arinauniversity.astor.config.SpringConfig;
import com.arinauniversity.astor.model.BookShelf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

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
