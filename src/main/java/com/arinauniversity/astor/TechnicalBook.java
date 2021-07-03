package com.arinauniversity.astor;

import org.springframework.stereotype.Component;

@Component
public class TechnicalBook implements Book {

    @Override
    public String toString() {
        return "Java philosophy";
    }

}
