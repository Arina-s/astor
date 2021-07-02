package com.arinauniversity.astor;

public class TestBean {

    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }

}
