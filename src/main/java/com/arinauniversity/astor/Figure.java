package com.arinauniversity.astor;

public class Figure {

    private String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void figureInit() {
        System.out.println("---Figure initialization---");
    }

    public void figureDestroy() {
        System.out.println("---Figure destroy---");
    }

}
