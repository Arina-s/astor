package com.arinauniversity.astor.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Figure {

    private String name;

    public Figure(@Value("tree") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void figureInit() {
        System.out.println("---Figure initialization---");
    }

    @PreDestroy
    public void figureDestroy() {
        System.out.println("---Figure destroy---");
    }

}
