package com.arinauniversity.astor.model;

import org.springframework.stereotype.Component;

@Component
public class TechnicalBook implements Book {

    @Override
    public String toString() {
        return "Java philosophy";
    }

    @Override
    public String getGenre() {
        return "technical";
    }

}
