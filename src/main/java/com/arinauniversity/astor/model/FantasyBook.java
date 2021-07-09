package com.arinauniversity.astor.model;

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
