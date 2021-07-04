package com.arinauniversity.astor;

import org.springframework.stereotype.Component;

@Component
public class FantasyBook implements Book {

    @Override
    public String toString() {
        return "Harry Potter";
    }

    @Override
    public String getGenre() {
        return "fantasy";
    }

}
